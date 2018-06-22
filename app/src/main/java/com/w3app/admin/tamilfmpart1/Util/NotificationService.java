package com.w3app.admin.tamilfmpart1.Util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.w3app.admin.tamilfmpart1.Activity.MainActivity;
import com.w3app.admin.tamilfmpart1.Activity.front1;
import com.w3app.admin.tamilfmpart1.Fragment.MyFmFragment;
import com.w3app.admin.tamilfmpart1.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import co.mobiwise.library.radio.RadioListener;

public class NotificationService extends Service implements RadioListener {
    public front1 obj = new front1();
   public static String fm_url;
    NotificationCompat.Builder status;
    private final String LOG_TAG = "NotificationService";
    RemoteViews views, bigViews;
    NotificationManager mNotificationManager;
    private String NOTIFICATION_CHANNEL_ID = "onlinradio_ch_1";




    @Override

    public void onCreate() {

        registerReceiver(onCallIncome, new IntentFilter("android.intent.action.PHONE_STATE"));

        mNotificationManager = (NotificationManager) Control.activity.getSystemService(Context.NOTIFICATION_SERVICE);
        Control.mRadioManager.registerListener(this);
        Control.mRadioManager.setLogging(true);
        super.onCreate();
    }


    private void showNotification() {
        // Using RemoteViews to bind custom layouts into Notification
        views = new RemoteViews(getPackageName(), R.layout.status_bar);
        bigViews = new RemoteViews(getPackageName(), R.layout.status_bar_expanded);

        // showing default album image
        views.setViewVisibility(R.id.status_bar_icon, View.VISIBLE);
        views.setImageViewResource(R.id.status_bar_icon, R.mipmap.icon);
        //  views.setViewVisibility(R.id.status_bar_album_art, View.GONE);
        bigViews.setImageViewBitmap(R.id.status_bar_album_art,
                Constants.getDefaultAlbumArt(this));

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent playIntent = new Intent(this, NotificationService.class);
        playIntent.setAction(Constants.ACTION.PLAY_ACTION);
        PendingIntent pplayIntent = PendingIntent.getService(this, 0,
                playIntent, 0);


        Intent closeIntent = new Intent(this, NotificationService.class);
        closeIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
        PendingIntent pcloseIntent = PendingIntent.getService(this, 0,
                closeIntent, 0);

        views.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);

        views.setOnClickPendingIntent(R.id.status_bar_collapse, pcloseIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_collapse, pcloseIntent);

        views.setImageViewResource(R.id.status_bar_play, R.drawable.ic_pause_notification);
        bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.ic_pause_notification);

        views.setTextViewText(R.id.status_bar_track_name, getResources().getString(R.string.statu_barTitle));
        bigViews.setTextViewText(R.id.status_bar_track_name, getResources().getString(R.string.statu_barTitle));

        NotificationChannel mChannel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Online Channel";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
            mNotificationManager.createNotificationChannel(mChannel);
        }


        status = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        status.setCustomContentView(views);
        status.setCustomBigContentView(bigViews);
        status.setSmallIcon(R.drawable.ic_not);
        status.setContentIntent(pendingIntent);
        status.setChannelId(NOTIFICATION_CHANNEL_ID);
        startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE, status.build());
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(Constants.ACTION.STARTFOREGROUND_ACTION)) {
            showNotification();
        } else if (intent.getAction().equals(Constants.ACTION.PLAY_ACTION)) {
            playPause();
        } else if (intent.getAction().equals(Constants.ACTION.Timer_ACTION)) {
            if (!(views == null)) {
                Control.timer = false;
                Control.playcheck = true;
                if(!Control.isDestroyed) {
                    views.setImageViewResource(R.id.status_bar_play, R.drawable.ic_play_notification);
                    bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.ic_play_notification);
                    startForeground(101, status.build());
                } else {
                    unregisterReceiver(onCallIncome);
                    Control.mRadioManager.unregisterListener(NotificationService.this);
                    stopService(intent);
                    stopForeground(true); // delete notification
                }
            }

        } else if (intent.getAction().equals(Constants.ACTION.STOPFOREGROUND_ACTION)) {
            if (Control.playPauseRecord) {
                try {
                    Control.recorder_var.stopRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(!Control.isDestroyed) {
                    MyFmFragment.imageView_record.setImageResource(R.drawable.ic_rac);
                }
                Toast.makeText(this, getResources().getString(R.string.recording_complite), Toast.LENGTH_SHORT).show();
                Control.record = true;
                Control.playPauseRecord = false;
            }

            if (Control.mRadioManager != null && Control.mRadioManager.isPlaying()) {
                unregisterReceiver(onCallIncome);
                Control.mRadioManager.stopRadio();
                Control.mRadioManager.unregisterListener(NotificationService.this);
//                stopService(intent);
//                stopForeground(true); // delete notification
            }
            Control.playcheck = true;
            Control.timer = false;
            if(!Control.isDestroyed) {
                MyFmFragment.imageView_play.setImageResource(R.drawable.ic_play);
                MyFmFragment.textView_play.setText(getResources().getString(R.string.textView_play_myfm));
            }
            Log.i(LOG_TAG, "Received Stop Foreground Intent");
            stopForeground(true);
            stopSelf();
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class load extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            MyFmFragment.progressBar.setVisibility(View.VISIBLE);
            MyFmFragment.imageView_play.setEnabled(false);
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String urlfm = params[0];
            Log.d("urlfm", urlfm);
            try {
                Control.mRadioManager.startRadio(urlfm);
                return "";
            } catch (Exception e1) {
                e1.printStackTrace();
                return "";
            }
        }
    }

    public void playPause() {


        if (Control.playcheck) {
          //  String fm_url = getResources().getString(R.string.fmUrl);
            fm_url=obj.web1;
            new UrlClass().execute(fm_url);

        } else {
            Control.playcheck = true;
            if (Control.mRadioManager.isPlaying()) {
                if (Control.playPauseRecord) {
                    try {
                        Control.recorder_var.stopRecording();
                        MyFmFragment.imageView_record.setImageResource(R.drawable.ic_rac);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Control.record = true;
                Control.mRadioManager.stopRadio();
                MyFmFragment.imageView_play.setImageResource(R.drawable.ic_play);
                MyFmFragment.textView_play.setText(getResources().getString(R.string.textView_play_myfm));
                views.setImageViewResource(R.id.status_bar_play, R.drawable.ic_play_notification);
                bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.ic_play_notification);
                startForeground(101, status.build());
            }
//            else {
//                Control.mp.start();
//                if (Control.playPauseRecord) {
//                    Control.recorder_var.resumeRecording();
//                }
//                MyFmFragment.imageView_play.setImageResource(R.drawable.ic_pause);
//                MyFmFragment.textView_play.setText(getResources().getString(R.string.textView_pause_myfm));
//                views.setImageViewResource(R.id.status_bar_play, R.drawable.ic_pause_notification);
//                bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.ic_pause_notification);
//                startForeground(101, status.build());
//            }
        }
    }

    public void startService() {
        Intent serviceIntent = new Intent(getApplication(), NotificationService.class);
        serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
        startService(serviceIntent);
    }

    public class UrlClass extends AsyncTask<String, String, String> {

        String final_fmUrl;

        @Override
        protected String doInBackground(String... params) {
            try {
                String url = params[0];
                if (url.endsWith(".m3u") || url.endsWith(".m3u8") || url.contains("yp.shoutcast.com/sbin/tunein-station.m3u?id=")) {
                    final_fmUrl = ParserM3UToURL.parse(url, "m3u");
                } else if (url.endsWith(".pls") || url.contains("listen.pls?sid=") || url.contains("yp.shoutcast.com/sbin/tunein-station.pls?id=")) {
                    final_fmUrl = ParserM3UToURL.parse(url, "pls");
                } else {
                    final_fmUrl = url;
                }
                return "";
            } catch (Exception e1) {
                e1.printStackTrace();
                return "";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            new load().execute(final_fmUrl);
            Log.d("final_fmUrl", final_fmUrl);
            super.onPostExecute(s);
        }
    }

    BroadcastReceiver onCallIncome = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String a = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (a.equals(TelephonyManager.EXTRA_STATE_OFFHOOK) || a.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

                if (Control.mRadioManager.isPlaying()) {
                    if (Control.playPauseRecord) {
                        Control.recorder_var.pauseRecording();
                    }
                    Control.mRadioManager.stopRadio();
                    MyFmFragment.imageView_play.setImageResource(R.drawable.ic_play);
                    MyFmFragment.textView_play.setText(getResources().getString(R.string.textView_play_myfm));
                    views.setImageViewResource(R.id.status_bar_play, R.drawable.ic_play_notification);
                    bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.ic_play_notification);
                    startForeground(101, status.build());
                }
            }
//            else if (a.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
//                if (!Control.mp.isPlaying()) {
//                    Control.mp.start();
//                    if (Control.playPauseRecord) {
//                        Control.recorder_var.resumeRecording();
//                    }
//                    MyFmFragment.imageView_play.setImageResource(R.drawable.ic_pause);
//                    MyFmFragment.textView_play.setText(getResources().getString(R.string.textView_pause_myfm));
//                    views.setImageViewResource(R.id.status_bar_play, R.drawable.ic_pause_notification);
//                    bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.ic_pause_notification);
//                    startForeground(101, status.build());
//                }
//            }
        }
    };

    @Override
    public void onRadioLoading() {

    }

    @Override
    public void onRadioConnected() {
        Log.e("radio", "connected");
    }

    @Override
    public void onRadioStarted() {
        Log.e("radio", "started");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Control.playcheck = false;
                startService();
                MyFmFragment.imageView_play.setEnabled(true);
                MyFmFragment.imageView_play.setImageResource(R.drawable.ic_pause);
                MyFmFragment.textView_play.setText(getResources().getString(R.string.textView_pause_myfm));
                MyFmFragment.progressBar.setVisibility(View.GONE);
            }
        }, 0);
    }

    @Override
    public void onRadioStopped() {
    }

    @Override
    public void onMetaDataReceived(final String s, final String s1) {
    }

    @Override
    public void onError() {
    }
}
