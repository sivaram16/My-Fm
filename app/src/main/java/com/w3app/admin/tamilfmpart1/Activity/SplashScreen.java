package com.w3app.admin.tamilfmpart1.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.w3app.admin.tamilfmpart1.R;
import com.w3app.admin.tamilfmpart1.Util.Constants;


public class SplashScreen extends AppCompatActivity {

    // splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Constants.forceRTLIfSupported(getWindow(),SplashScreen.this);

        if (Constants.isNetworkAvailable(SplashScreen.this)) {
            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity

                    Intent i = new Intent(SplashScreen.this, front1.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else {
            Toast.makeText(SplashScreen.this,getResources().getString(R.string.internet_connection), Toast.LENGTH_SHORT).show();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(getResources().getString(R.string.internet_connection_message));
            alertDialogBuilder.setPositiveButton(getResources().getString(R.string.exit),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }
}
