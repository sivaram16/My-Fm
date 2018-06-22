package com.w3app.admin.tamilfmpart1.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.w3app.admin.tamilfmpart1.R;
import com.w3app.admin.tamilfmpart1.Util.Constants;

import java.io.IOException;
import java.io.InputStream;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by viaviweb-2 on 02-Jun-17.
 */

public class Privacy_Policy extends AppCompatActivity {

    public Toolbar toolbar;
    private TextView textview_privacy_policy,textView_Toolbar;
    private String str;
    private Constants constants;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_policy);

        Constants.forceRTLIfSupported(getWindow(), Privacy_Policy.this);

        constants=new Constants(Privacy_Policy.this);

        toolbar = (Toolbar) findViewById(R.id.privacy_policy_toolbar);
        textView_Toolbar = (TextView) findViewById(R.id.toolbar_title_privacy_policy);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        textView_Toolbar.setText(getResources().getString(R.string.Privacy_Policy));
        textView_Toolbar.setTypeface(constants.contm);

       /* final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow_color), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);*/


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textview_privacy_policy = (TextView) findViewById(R.id.textview_privacy_policy);

        try {
            InputStream is = getAssets().open("privarcypolicy.txt");

            // We guarantee that the available method returns the total
            // size of the asset...  of course, this does mean that a single
            // asset can't be more than 2 gigs.
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            str = new String(buffer);

            // Finally stick the string into the text view.
            // Replace with whatever you need to have the text into.

            Log.d("text", str);

        } catch (IOException e) {
            // Should never happen!
            throw new RuntimeException(e);
        }

        textview_privacy_policy.setText(Html.fromHtml(str));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
