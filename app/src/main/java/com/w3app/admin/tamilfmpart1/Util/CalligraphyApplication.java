package com.w3app.admin.tamilfmpart1.Util;

import android.app.Application;

import com.w3app.admin.tamilfmpart1.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by admin on 12-08-2017.
 */

public class CalligraphyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/lato_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
