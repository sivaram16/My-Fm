package com.w3app.admin.tamilfmpart1.Fragment;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.w3app.admin.tamilfmpart1.R;
import com.w3app.admin.tamilfmpart1.Util.Constants;
import com.w3app.admin.tamilfmpart1.Util.Control;
import com.w3app.admin.tamilfmpart1.Util.MyReceiver;
import com.w3app.admin.tamilfmpart1.Util.NotificationService;
import com.shawnlin.numberpicker.NumberPicker;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import omrecorder.AudioChunk;
import omrecorder.AudioRecordConfig;
import omrecorder.OmRecorder;
import omrecorder.PullTransport;
import omrecorder.PullableSource;

import static android.content.Context.ALARM_SERVICE;

public class MyFmFragment extends Fragment {

    public static ImageView imageView_timer, imageView_play, imageView_record, imageView_myFm;
    public static ProgressBar progressBar;
    public View view;
    public static TextView textView_play, textView_timer, textView_stoptimer;
    private Constants constants;
    private int columnWidth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.myfm_fragment, container, false);

        constants = new Constants(getActivity());
        columnWidth = (int) (constants.getScreenWidth());

        progressBar = (ProgressBar) view.findViewById(R.id.ProgressBar_myfm);
        imageView_myFm = (ImageView) view.findViewById(R.id.imageView_myfm);
        imageView_timer = (ImageView) view.findViewById(R.id.imageView_timer_myfm);
        imageView_play = (ImageView) view.findViewById(R.id.imageView_play_myfm);
        imageView_record = (ImageView) view.findViewById(R.id.imageView_record_myfm);
        textView_play = (TextView) view.findViewById(R.id.textView_play_myfm);
        textView_timer = (TextView) view.findViewById(R.id.textView_timer);
        textView_stoptimer = (TextView) view.findViewById(R.id.textView_stoptimer);
        progressBar.setVisibility(View.GONE);

        imageView_myFm.setLayoutParams(new RelativeLayout.LayoutParams(columnWidth, columnWidth / 2));

        try {
            if (Control.mRadioManager != null) {
                if (Control.mRadioManager.isPlaying()) {
                    imageView_play.setImageResource(R.drawable.ic_pause);
                    textView_play.setText(getResources().getString(R.string.textView_pause_myfm));
                } else {
                    imageView_play.setImageResource(R.drawable.ic_play);
                    textView_play.setText(getResources().getString(R.string.textView_play_myfm));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Control.playPauseRecord) {
            imageView_record.setImageResource(R.drawable.ic_rac_hov);
        } else {
            imageView_record.setImageResource(R.drawable.ic_rac);
        }

        imageView_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotificationService.class);
                intent.setAction(Constants.ACTION.PLAY_ACTION);
                getActivity().startService(intent);
            }
        });

        imageView_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Control.mRadioManager.isPlaying()) {
                    if (!Control.timer) {
                        timer();
                    } else {
                        openCancelTimerDialog();
                    }
                } else {
                    Toast.makeText(getActivity(), getResources().getString(R.string.not_start_fm), Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageView_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Control.allowPermitionExternalStorage) {
                    try {
                        recoding();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), getResources().getString(R.string.cannot_use_save_permission), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    public void timer() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);

        final NumberPicker hours_picker = (NumberPicker) dialog.findViewById(R.id.hours_picker);
        final NumberPicker minute_picker = (NumberPicker) dialog.findViewById(R.id.minute_picker);
        Button button = (Button) dialog.findViewById(R.id.button_dialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hours = String.valueOf(hours_picker.getValue());
                String minute = String.valueOf(minute_picker.getValue());

                String totalTime = hours + ":" + minute;
                int total_timer = (int) Constants.convert_long(totalTime);
                Control.timer = true;

                Intent intent = new Intent(getActivity(), MyReceiver.class);
                Control.pendingIntent = PendingIntent.getBroadcast(getActivity().getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
                Control.alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Control.alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + total_timer, Control.pendingIntent);
                } else {
                    Control.alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + total_timer, Control.pendingIntent);
                }
                updateTimer(System.currentTimeMillis(), total_timer);

                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void updateTimer(final long currentTime, final int time) {
        long timeleft = (currentTime + time) - System.currentTimeMillis();
        if (timeleft > 0) {
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(timeleft),
                    TimeUnit.MILLISECONDS.toMinutes(timeleft) % TimeUnit.HOURS.toMinutes(1),
                    TimeUnit.MILLISECONDS.toSeconds(timeleft) % TimeUnit.MINUTES.toSeconds(1));

            textView_stoptimer.setVisibility(View.GONE);
            textView_timer.setVisibility(View.VISIBLE);
            textView_timer.setText(hms);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (Control.timer) {
                        updateTimer(currentTime, time);
                    } else {
                        textView_stoptimer.setVisibility(View.VISIBLE);
                        textView_timer.setVisibility(View.GONE);
                    }
                }
            }, 1000);
        } else {
            textView_stoptimer.setVisibility(View.VISIBLE);
            textView_timer.setVisibility(View.GONE);
        }
    }

    public void recoding() throws IOException {
        if (Control.mRadioManager.isPlaying()) {
            if (Control.record) {
                Control.record = false;
                Control.playPauseRecord = true;
                setupRecorder();
                Control.recorder_var.startRecording();
                imageView_record.setImageResource(R.drawable.ic_rac_hov);
                Toast.makeText(getActivity(), getResources().getString(R.string.recording_start), Toast.LENGTH_SHORT).show();
            } else {
                Control.recorder_var.stopRecording();
                imageView_record.setImageResource(R.drawable.ic_rac);
                Toast.makeText(getActivity(), getResources().getString(R.string.recording_complite), Toast.LENGTH_SHORT).show();
                Control.record = true;
                Control.playPauseRecord = false;
            }
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.not_start_fm), Toast.LENGTH_SHORT).show();
        }
    }

    private PullableSource mic() {
        return new PullableSource.Default(
                new AudioRecordConfig.Default(
                        MediaRecorder.AudioSource.MIC, AudioFormat.ENCODING_PCM_16BIT,
                        AudioFormat.CHANNEL_IN_MONO, 44100
                )
        );
    }

    private void setupRecorder() {
        Control.recorder_var = OmRecorder.wav(
                new PullTransport.Default(mic(), new PullTransport.OnAudioChunkPulledListener() {
                    @Override
                    public void onAudioChunkPulled(AudioChunk audioChunk) {
                    }
                }), file());
    }

    @NonNull
    private File file() {
        String iconsStoragePath = Environment.getExternalStorageDirectory() + "/MyFm/";
        File sdIconStorageDir = new File(iconsStoragePath);
        //create storage directories, if they don't exist
        sdIconStorageDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Recording-" + n;
        String file_name = fname + ".wav";
        return new File(iconsStoragePath, file_name);
    }

    private void openCancelTimerDialog() {
        AlertDialog.Builder alert;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alert = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            alert = new AlertDialog.Builder(getActivity());
        }

        alert.setTitle(getString(R.string.cancel_timer));
        alert.setMessage(getString(R.string.sure_cancel_timer));
        alert.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Control.timer = false;
                textView_stoptimer.setVisibility(View.VISIBLE);
                textView_timer.setVisibility(View.GONE);
                Control.alarmManager.cancel(Control.pendingIntent);
            }
        });
        alert.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }

}