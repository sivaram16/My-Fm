package com.w3app.admin.tamilfmpart1.Activity;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.w3app.admin.tamilfmpart1.Adapter.ViewPagerAdapter;
import com.w3app.admin.tamilfmpart1.R;
import com.w3app.admin.tamilfmpart1.Util.Constants;
import com.w3app.admin.tamilfmpart1.Util.Control;
import com.w3app.admin.tamilfmpart1.Util.NotificationService;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.onesignal.OneSignal;

import co.mobiwise.library.radio.RadioManager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private TextView textView_toolBar;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private Constants constants;
    public static boolean doubleBackToExitPressedOnce = false, onBackPress = false;
    final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 101;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Control.isDestroyed = false;
        Constants.forceRTLIfSupported(getWindow(), MainActivity.this);
        Control.mRadioManager = RadioManager.with(getApplicationContext());

        constants = new Constants(MainActivity.this);
        Control.activity = MainActivity.this;

        String[] pageTitle = {getResources().getString(R.string.my_fm), getResources().getString(R.string.facebook), getResources().getString(R.string.twitter)};

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);

        toolbar.setTitle("");

        textView_toolBar = (TextView) findViewById(R.id.toolbar_title_main_activity);
        textView_toolBar.setText(getResources().getString(R.string.toolbar_title));
        textView_toolBar.setTypeface(constants.contm);

        setSupportActionBar(toolbar);

        mAdView = (AdView) findViewById(R.id.adView_home_activity);
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(MainActivity.this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.admob_interstitial_id));
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        toolbar.setNavigationIcon(R.drawable.ic_sidemenu);

        //setting Tab layout (number of Tabs = number of ViewPager pages)
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //handling navigation view item event
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        final View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        TextView textView_appName = (TextView) headerLayout.findViewById(R.id.app_name);
        TextView textView_appSubName = (TextView) headerLayout.findViewById(R.id.app_subTitle);

        textView_appName.setTypeface(constants.contm);
        textView_appSubName.setTypeface(constants.contm);

        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        checkPer();

        OneSignal.startInit(this)
                .init();

    }

    @Override
    public void onBackPressed() {
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            if (onBackPress) {
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, getResources().getString(R.string.Please_click_BACK_again_to_exit), Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            } else {
                viewPager.setCurrentItem(0);
                onBackPress = true;
            }
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Checking if the item is in checked state or not, if not make it in checked state
        if (item.isChecked()) item.setChecked(false);
        else
            item.setChecked(true);

        //Closing drawer on item click
        drawer.closeDrawers();

        int id = item.getItemId();

        switch (id) {

            case R.id.my_fm:
                viewPager.setCurrentItem(0);
                onBackPress = true;
                return true;

            case R.id.share:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String sAux = "\n" + getResources().getString(R.string.Let_me_recommend_you_this_application) + "\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=" + getApplication().getPackageName();
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
                return true;

            case R.id.rate_app:
                Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
                }
                return true;

            case R.id.more_app:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.play_more_app))));
                return true;

            case R.id.about_us:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(MainActivity.this, About_Us.class));
                        }
                    });
                } else {
                    startActivity(new Intent(MainActivity.this, About_Us.class));
                }

                return true;

            case R.id.privacy_policy:
                startActivity(new Intent(MainActivity.this, Privacy_Policy.class));
                return true;

            default:
                return true;
        }
    }

    public void checkPer() {
        if ((ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE" + "android.permission.WRITE_INTERNAL_STORAGE" +
                "android.permission.RECORD_AUDIO" + "android.permission.READ_PHONE_STATE") != PackageManager.PERMISSION_GRANTED)) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.WRITE_INTERNAL_STORAGE",
                                "android.permission.RECORD_AUDIO", "android.permission.READ_PHONE_STATE"},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            } else {
                Control.allowPermitionExternalStorage = true;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        boolean canUseExternalStorage = false;

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    canUseExternalStorage = true;
                    Control.allowPermitionExternalStorage = true;
                }

                if (!canUseExternalStorage) {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.cannot_use_save_permission), Toast.LENGTH_SHORT).show();
                    Control.allowPermitionExternalStorage = false;
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        Control.isDestroyed = true;
        if (!Control.mRadioManager.isPlaying()) {
            Intent serviceIntent = new Intent(getApplication(), NotificationService.class);
            serviceIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
            startService(serviceIntent);
        }
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Control.mRadioManager.connect();
    }
}
