package com.w3app.admin.tamilfmpart1.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.w3app.admin.tamilfmpart1.Fragment.MyFmFragment;
import com.w3app.admin.tamilfmpart1.R;

import java.io.IOException;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.e("aaa","onreceive");
        if (Control.timer) {
            Log.e("aaa","timer");
            if (Control.playPauseRecord) {
                Log.e("aaa","playpause");
                try {
                    Control.recorder_var.stopRecording();
                    Log.e("aaa","stoprecording");
                } catch (IOException e) {
                    Log.e("aaa","catch");
                    e.printStackTrace();
                }
                Log.e("aaa","after try");
                MyFmFragment.imageView_record.setImageResource(R.drawable.ic_rac);
                Toast.makeText(context, context.getResources().getString(R.string.recording_complite), Toast.LENGTH_SHORT).show();
                Control.record = true;
                Control.playPauseRecord = false;
            }
            Control.mRadioManager.stopRadio();
            Log.e("aaa","radio stop");
            MyFmFragment.imageView_play.setImageResource(R.drawable.ic_play);
            MyFmFragment.textView_play.setText(context.getResources().getString(R.string.textView_play_myfm));
            intent = new Intent(context, NotificationService.class);
            intent.setAction(Constants.ACTION.Timer_ACTION);
            context.startService(intent);
            Toast.makeText(context, context.getResources().getString(R.string.timer_end), Toast.LENGTH_SHORT).show();
        }
    }
}