package com.w3app.admin.tamilfmpart1.Util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaPlayer;

import co.mobiwise.library.radio.RadioManager;
import omrecorder.Recorder;

public class Control {
    public static Recorder recorder_var;
    public static RadioManager mRadioManager;
    public static Context activity;
    public static AlarmManager alarmManager;
    public static PendingIntent pendingIntent;
    public static boolean record = true, playcheck = true, playPauseRecord = false, timer = false,
            allowPermitionExternalStorage = false, isDestroyed = false;

}
