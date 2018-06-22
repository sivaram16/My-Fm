package com.w3app.admin.tamilfmpart1.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.w3app.admin.tamilfmpart1.R;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class front1 extends AppCompatActivity {
    public static String web1;
   // web1 = new URL("http://prclive1.listenon.in:9948/;");


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.front);
        new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
                .execute("http://www.adageindia.in/photo/47478415/Radio-City-Is-Now-Officially-A-Part-Of-Jagran-Prakashan.jpg?27128");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView2))
                .execute("http://radiosindia.com/images/radiogilli.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView3))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/tamil-olli.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView4))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/shakti-fm.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView5))
                .execute("http://radiosindia.com/images/radiomirchi.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView6))
                .execute("http://radiosindia.com/images/sooryanfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView7))
                .execute("http://radiosindia.com/images/bigfmtamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView8))
                .execute("http://radiosindia.com/images/hellofm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView9))
                .execute("http://radiosindia.com/images/fmrainbow.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView10))
                .execute("http://radiosindia.com/images/radiocitychennai.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView11))
                .execute("http://radiosindia.com/images/tamilhdradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView12))
                .execute("http://radiosindia.com/images/suryanfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView13))
                .execute("http://radiosindia.com/images/feverfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView14))
                .execute("http://radiosindia.com/images/fmgold.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView15))
                .execute("http://radiosindia.com/images/radioone.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView16))
                .execute("http://radiosindia.com/images/vividhbharathi.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView17))
                .execute("http://radiosindia.com/images/tamilfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView18))
                .execute("http://radiosindia.com/images/varnamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView19))
                .execute("http://radiosindia.com/images/fmrainbow.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView20))
                .execute("http://radiosindia.com/images/air.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView21))
                .execute("http://radiosindia.com/images/minnalfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView22))
                .execute("http://radiosindia.com/images/tamilsunfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView23))
                .execute("http://radiosindia.com/images/lankasrifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView24))
                .execute("http://radiosindia.com/images/puradsifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView25))
                .execute("http://radiosindia.com/images/ustamilfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView26))
                .execute("http://radiosindia.com/images/sahanafm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView27))
                .execute("http://radiosindia.com/images/vasanthamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView28))
                .execute("http://radiosindia.com/images/eastfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView29))
                .execute("http://radiosindia.com/images/ruthramfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView30))
                .execute("http://radiosindia.com/images/abinayamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView31))
                .execute("http://radiosindia.com/images/mrchefm.jpeg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView32))
                .execute("http://radiosindia.com/images/chellamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView33))
                .execute("http://radiosindia.com/images/paristamilfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView34))
                .execute("http://radiosindia.com/images/kathirfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView35))
                .execute("http://radiosindia.com/images/mazhaifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView36))
                .execute("http://radiosindia.com/images/chandrufm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView37))
                .execute("http://radiosindia.com/images/tamilheartchatfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView38))
                .execute("http://radiosindia.com/images/mukilfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView39))
                .execute("http://radiosindia.com/images/etrradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView40))
                .execute("http://radiosindia.com/images/etrmusic.jpg");
        /*new DownloadImageTask((ImageView) findViewById(R.id.imageView41))
                .execute("http://radiosindia.com/images/tamilaruvifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView42))
                .execute("http://radiosindia.com/images/ilctamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView43))
                .execute("http://radiosindia.com/images/nakshatraradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView44))
                .execute("http://radiosindia.com/images/raajafm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView45))
                .execute("http://radiosindia.com/images/olifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView46))
                .execute("http://radiosindia.com/images/a9radio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView47))
                .execute("http://radiosindia.com/images/athavanradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView48))
                .execute("http://radiosindia.com/images/natpufm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView49))
                .execute("http://radiosindia.com/images/jtrfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView50))
                .execute("http://radiosindia.com/images/americantamilradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView51))
                .execute("http://radiosindia.com/images/clubhouse.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView52))
                .execute("http://radiosindia.com/images/londontamilradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView53))
                .execute("http://radiosindia.com/images/btctamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView54))
                .execute("http://radiosindia.com/images/geethavani.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView55))
                .execute("http://radiosindia.com/images/geethamradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView56))
                .execute("http://radiosindia.com/images/osaifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView57))
                .execute("http://radiosindia.com/images/atbctamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView58))
                .execute("http://radiosindia.com/images/thendralradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView59))
                .execute("http://radiosindia.com/images/capitalfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView60))
                .execute("http://radiosindia.com/images/chennairadio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView61))
                .execute("http://radiosindia.com/images/itr.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView62))
                .execute("http://radiosindia.com/images/tamilkushi.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView63))
                .execute("http://radiosindia.com/images/jeifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView64))
                .execute("http://radiosindia.com/images/bulbfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView65))
                .execute("http://radiosindia.com/images/therifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView66))
                .execute("http://radiosindia.com/images/kalasamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView67))
                .execute("http://radiosindia.com/images/varnangalfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView68))
                .execute("http://radiosindia.com/images/slbctamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView69))
                .execute("http://radiosindia.com/images/homeshakthi.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView70))
                .execute("http://radiosindia.com/images/thendralfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView71))
                .execute("http://radiosindia.com/images/megazonesouth.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView72))
                .execute("http://radiosindia.com/images/gtrfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView73))
                .execute("http://radiosindia.com/images/ctbc.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView74))
                .execute("http://radiosindia.com/images/ctr24.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView75))
                .execute("http://radiosindia.com/images/ilayamaanradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView76))
                .execute("http://radiosindia.com/images/tamaraifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView77))
                .execute("http://radiosindia.com/images/masalafm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView78))
                .execute("http://radiosindia.com/images/itamilfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView79))
                .execute("http://radiosindia.com/images/vegamtamilradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView80))
                .execute("http://radiosindia.com/images/laksivision.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView81))
                .execute("http://radiosindia.com/images/timefm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView82))
                .execute("http://radiosindia.com/images/ibctamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView83))
                .execute("http://radiosindia.com/images/hungama.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView84))
                .execute("http://radiosindia.com/images/arangamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView85))
                .execute("http://radiosindia.com/images/ragasiamradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView86))
                .execute("http://radiosindia.com/images/vannafm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView87))
                .execute("http://radiosindia.com/images/ntamilfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView88))
                .execute("http://radiosindia.com/images/agaramtamilradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView89))
                .execute("http://radiosindia.com/images/redfmtamil.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView90))
                .execute("http://radiosindia.com/images/radiovaanam.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView91))
                .execute("http://radiosindia.com/images/tsrlive.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView92))
                .execute("http://radiosindia.com/images/ezhisaifm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView93))
                .execute("http://radiosindia.com/images/virutchamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView94))
                .execute("http://radiosindia.com/images/tamilpanpalai.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView95))
                .execute("http://radiosindia.com/images/idhayamfm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView96))
                .execute("http://radiosindia.com/images/mtr995fm.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView97))
                .execute("http://radiosindia.com/images/yuwaveradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView98))
                .execute("http://radiosindia.com/images/tamilliteradio.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView99))
                .execute("http://radiosindia.com/images/thamilesai.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView100))
                .execute("http://radiosindia.com/images/uritamilradio.jpg");*/

       //hindi

        new DownloadImageTask((ImageView) findViewById(R.id.imageView41))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/radio-city-91-1-fm-hindi.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView42))
                .execute("https://onlineradiofm.in/assets/image/radio/180/MeethiMirchi.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView43))
                .execute("https://onlineradiofm.in/assets/image/radio/180/MirchiTop20.jpg");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView44))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/red-fm-93-5.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView45))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/hits-of-bollywood.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView46))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/planet-radio-city-hindi.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView47))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/calm-radio-hindi.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView48))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/bbc-hindi-radio.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView49))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/bombay-beats-hindi.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView50))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/radio-tarana-hindi.png");

        //malayalam

        new DownloadImageTask((ImageView) findViewById(R.id.imageView51))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/psalms-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView52))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/nadam-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView53))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/ganam-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView54))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/heavenly-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView55))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/kerala-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView56))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/radio-heartbeats-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView57))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/ragam-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView58))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/luminous-radio-malayalam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView59))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/radio-city-malayam.png");
        new DownloadImageTask((ImageView) findViewById(R.id.imageView60))
                .execute("https://cdn.webrad.io/images/logos/onlineradios-in/marconi-malayalam.png");


        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout_1);
        layout1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://prclive1.listenon.in:9948/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
                }
        });
        RelativeLayout layout2 = (RelativeLayout) findViewById(R.id.layout_2);
        layout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s2.voscast.com:10616/;stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout3 = (RelativeLayout) findViewById(R.id.layout_3);
        layout3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://91.121.165.41:9035/stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout4 = (RelativeLayout) findViewById(R.id.layout_4);
        layout4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://76.164.217.100:7012/stream/1/";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout5 = (RelativeLayout) findViewById(R.id.layout_5);
        layout5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://163.172.165.94:8720/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout6 = (RelativeLayout) findViewById(R.id.layout_6);
        layout6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://104.238.193.114:7077/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout7 = (RelativeLayout) findViewById(R.id.layout_7);
        layout7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://163.172.165.94:8736/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout8 = (RelativeLayout) findViewById(R.id.layout_8);
        layout8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://163.172.165.94:8728/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout9 = (RelativeLayout) findViewById(R.id.layout_9);
        layout9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://117.218.118.70:88/broadwave.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        RelativeLayout layout10 = (RelativeLayout) findViewById(R.id.layout_10);
        layout10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://163.172.165.94:8742/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout11 = (RelativeLayout) findViewById(R.id.layout_11);
        layout11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://live.cmr24.net:8081/CMR/TamilHD-LQ/icecast.audio";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout12 = (RelativeLayout) findViewById(R.id.layout_12);
        layout12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.36.195:7112/1/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout13 = (RelativeLayout) findViewById(R.id.layout_13);
        layout13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.36.195:7112/5/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout14 = (RelativeLayout) findViewById(R.id.layout_14);
        layout14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.36.195:7112/3/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout15 = (RelativeLayout) findViewById(R.id.layout_15);
        layout15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.36.195:7112/4/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout16 = (RelativeLayout) findViewById(R.id.layout_16);
        layout16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.36.195:7112/2/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout17 = (RelativeLayout) findViewById(R.id.layout_17);
        layout17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://31.14.40.149:8000/;stream.mp3/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout18 = (RelativeLayout) findViewById(R.id.layout_18);
        layout18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://198.178.123.8:8402/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout19 = (RelativeLayout) findViewById(R.id.layout_19);
        layout19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://163.172.165.94:8748/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout20 = (RelativeLayout) findViewById(R.id.layout_20);
        layout20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout21 = (RelativeLayout) findViewById(R.id.layout_21);
        layout21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://astro2.rastream.com/era";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout22 = (RelativeLayout) findViewById(R.id.layout_22);
        layout22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.4.210:3596/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout23 = (RelativeLayout) findViewById(R.id.layout_23);
        layout23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://5984.cloudrad.io:8032/;stream/1";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout24 = (RelativeLayout) findViewById(R.id.layout_24);
        layout24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://puradsifm.net:9994/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout25 = (RelativeLayout) findViewById(R.id.layout_25);
        layout25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://streaming.radio.co/s0cfc93915/listen";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout26 = (RelativeLayout) findViewById(R.id.layout_26);
        layout26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s7.voscast.com:9042/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout27 = (RelativeLayout) findViewById(R.id.layout_27);
        layout27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://76.164.217.100:7489/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout28 = (RelativeLayout) findViewById(R.id.layout_28);
        layout28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://174.142.215.249:9966/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout29 = (RelativeLayout) findViewById(R.id.layout_29);
        layout29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s2.voscast.com:10480/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout30 = (RelativeLayout) findViewById(R.id.layout_30);
        layout30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.170.8:5756/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout31 = (RelativeLayout) findViewById(R.id.layout_31);
        layout31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "https://streamer.radio.co/s5fb71259c/listen";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout32 = (RelativeLayout) findViewById(R.id.layout_32);
        layout32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://radio.chellam.fm:5012/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout33 = (RelativeLayout) findViewById(R.id.layout_33);
        layout33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s6.voscast.com:7108/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout34 = (RelativeLayout) findViewById(R.id.layout_34);
        layout34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://198.178.123.5:12262/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout35 = (RelativeLayout) findViewById(R.id.layout_35);
        layout35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://media.mazhaifm.com:9999/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout36 = (RelativeLayout) findViewById(R.id.layout_36);
        layout36.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://144.217.195.24:8825/;stream/1";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout37 = (RelativeLayout) findViewById(R.id.layout_37);
        layout37.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://144.217.195.24:8140/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout38 = (RelativeLayout) findViewById(R.id.layout_38);
        layout38.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://streaming.shoutcast.com/MUKILFMRADIO";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout39 = (RelativeLayout) findViewById(R.id.layout_39);
        layout39.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://128.etr.audio:8012/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout40 = (RelativeLayout) findViewById(R.id.layout_40);
        layout40.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://212.83.150.15:8304/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        /*final Button button41 = findViewById(R.id.tamilaruvifm);
        button41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://usa3-vn.mixstream.net:8852/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button42 = findViewById(R.id.ilctamil);
        button42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s2.voscast.com:9370/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button43 = findViewById(R.id.nakshatraradio);
        button43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://14123.live.streamtheworld.com/SAM02AAC265_SC";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button44 = findViewById(R.id.raajafm);
        button44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://212.83.138.48:8324/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button45 = findViewById(R.id.olifm);
        button45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://mediacorp.rastream.com/968fm";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button46 = findViewById(R.id.a9radio);
        button46.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://195.154.217.103:8175/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button47 = findViewById(R.id.athavanradio);
        button47.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s1.voscast.com:9038/mountpoint3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button48 = findViewById(R.id.natpufm);
        button48.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://167.114.131.90:5014/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button49 = findViewById(R.id.jtrfm);
        button49.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://195.154.217.103:8175/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button50 = findViewById(R.id.americantamilradio);
        button50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://69.46.24.226:7188/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button51 = findViewById(R.id.clubhousefm);
        button51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://5.135.154.91:8302/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button52 = findViewById(R.id.londontamilradio);
        button52.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.41.102:5240/stream?type=http&nocache=25";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button53 = findViewById(R.id.btctamilradio);
        button53.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://199.175.48.216:8080/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button54 = findViewById(R.id.geethavani);
        button54.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://50.7.70.66:8657/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button55 = findViewById(R.id.geethamradio);
        button55.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://www.geethamradio.com:8020/new_hifi.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button56 = findViewById(R.id.osaifm);
        button56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://astro4.rastream.com/osai";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button57 = findViewById(R.id.atbcradio);
        button57.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s7.viastreaming.net:7920/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button58 = findViewById(R.id.thendralfm);
        button58.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://220.247.227.20:8000/Threndralstream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button59 = findViewById(R.id.capitalfm);
        button59.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://ca4.rcast.net:8060/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button60 = findViewById(R.id.chennairadio);
        button60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://api.chennairadio.ca:8000/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button61 = findViewById(R.id.itrfm);
        button61.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s4.voscast.com:8360/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button62 = findViewById(R.id.tamilkushi);
        button62.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s2.voscast.com:9780/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button63 = findViewById(R.id.jeifm);
        button63.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://167.114.131.90:8808/jeifm";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button64 = findViewById(R.id.bulbfm);
        button64.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://streaming.shoutcast.com/Bulb-FM";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        }); final Button button65 = findViewById(R.id.therifm);
        button65.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.95.18.39:5444/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button66 = findViewById(R.id.kalasamfm);
        button66.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://sc1.streamingpulse.com:8084/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button67 = findViewById(R.id.varnangalfm);
        button67.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://37.187.93.104:8487/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button68 = findViewById(R.id.slbctamil);
        button68.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://220.247.227.6:8000/Tnsstream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button69 = findViewById(R.id.homeshakthi);
        button69.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s10.voscast.com:7784/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button70 = findViewById(R.id.thendralworldradio);
        button70.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://37.187.79.93:9116/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button71 = findViewById(R.id.megazoneradio);
        button71.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://zas1.ndx.co.za:8162/;listen.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button72 = findViewById(R.id.gtrfm);
        button72.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://94.23.62.189:5250/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button73 = findViewById(R.id.ctbcradio);
        button73.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://ctbcfmradio.primcast.com:4086/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button74 = findViewById(R.id.ctr24);
        button74.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://198.27.66.225:8498/stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button75 = findViewById(R.id.ilayamaanradio);
        button75.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://212.83.138.48:8086/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button76 = findViewById(R.id.thamaraifm);
        button76.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://api.spreaker.com/listen/user/9791457/episode/latest/shoutcast.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button77 = findViewById(R.id.masalafm);
        button77.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://s9.voscast.com:8720/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button78 = findViewById(R.id.itamilfm);
        button78.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://216.155.128.202:8898/stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button79 = findViewById(R.id.vegamtamilradio);
        button79.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://vtr24.com:8000/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button80 = findViewById(R.id.lakshivisionfm);
        button80.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://87.117.193.10:8010/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button81 = findViewById(R.id.timefm);
        button81.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1 = "http://192.184.9.158:8087/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }
        });
        final Button button82 = findViewById(R.id.ibctamil);
        button82.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://38.96.148.226:6176/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button83 = findViewById(R.id.hungamatamil);
        button83.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://103.16.47.70:9555/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button84 = findViewById(R.id.arangamfm);
        button84.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://198.178.123.20:8600/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button85 = findViewById(R.id.ragasiamradio);
        button85.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://109.74.196.48:8251/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button86 = findViewById(R.id.vannafm);
        button86.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://5.135.165.204:8050/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button87 = findViewById(R.id.ntamilfm);
        button87.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://188.165.232.7:8147/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button88 = findViewById(R.id.agaramtamilfm);
        button88.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://rathesh.com:3001/live";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });

        final Button button89 = findViewById(R.id.redfm);
        button89.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.99.35.93:6130/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button90= findViewById(R.id.radiovanam);
        button90.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://207.38.90.99:8024/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button91 = findViewById(R.id.tsrradio);
        button91.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://5.135.154.91:4376/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button92 = findViewById(R.id.ezhisaifm);
        button92.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://eu4.radioboss.fm:8191/;listen.pls?sid=1";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button93 = findViewById(R.id.virutchamfm);
        button93.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://151.80.97.38:8196/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button94 = findViewById(R.id.tamilpanpalai);
        button94.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://144.217.129.213:9950/stream64";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button95 = findViewById(R.id.idhayamfm);
        button95.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://proxima.shoutca.st:8528/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button96 = findViewById(R.id.mtr995);
        button96.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://176.31.120.92:9004/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button97 = findViewById(R.id.yuwaveradio);
        button97.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://144.217.203.184:8615/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        }); final Button button98 = findViewById(R.id.tamilliteradio);
        button98.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://212.83.138.48:8348/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        final Button button99 = findViewById(R.id.thamilesai);
        button99.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://50.22.212.195:8050/;stream.mp3";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        }); final Button button100 = findViewById(R.id.uritamilradio);
        button100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://eu4.radioboss.fm:8178/autodj";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });*/

        //hindi

        RelativeLayout layout41 = (RelativeLayout) findViewById(R.id.layout_41);
        layout41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://prclive1.listenon.in:9960/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout42 = (RelativeLayout) findViewById(R.id.layout_42);
        layout42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://51.15.208.163:8081/radio/MeethiMirchiHDLive/icecast.audio";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout43 = (RelativeLayout) findViewById(R.id.layout_43);
        layout43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://51.15.208.163:8081/radio/mt20live/icecast.audio";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout44 = (RelativeLayout) findViewById(R.id.layout_44);
        layout44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://14013.live.streamtheworld.com/CKYRFM_SC";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout45 = (RelativeLayout) findViewById(R.id.layout_45);
        layout45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://50.7.77.115:8174/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout46 = (RelativeLayout) findViewById(R.id.layout_46);
        layout46.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://prclive1.listenon.in:9960/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout47 = (RelativeLayout) findViewById(R.id.layout_47);
        layout47.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://62.138.24.39:5328/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout48 = (RelativeLayout) findViewById(R.id.layout_48);
        layout48.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://bbcwssc.ic.llnwd.net/stream/bbcwssc_mp1_ws-hinda";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout49 = (RelativeLayout) findViewById(R.id.layout_49);
        layout49.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://sc-bb.1.fm:8017/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout50 = (RelativeLayout) findViewById(R.id.layout_50);
        layout50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://peridot.streamguys.com:7150/Tarana.aac";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });

    //malayalam

        RelativeLayout layout51 = (RelativeLayout) findViewById(R.id.layout_51);
        layout51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://viadj.viastreaming.net:7084/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout52 = (RelativeLayout) findViewById(R.id.layout_52);
        layout52.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://viadj.viastreaming.net:7070/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout53 = (RelativeLayout) findViewById(R.id.layout_53);
        layout53.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://5.79.88.132:7104/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout54 = (RelativeLayout) findViewById(R.id.layout_54);
        layout54.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://178.32.107.151:5060/stream/1/";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout55 = (RelativeLayout) findViewById(R.id.layout_55);
        layout55.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://radio.hostonnet.com:8000/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout56 = (RelativeLayout) findViewById(R.id.layout_56);
        layout56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://64.150.176.9:8272/live";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout57 = (RelativeLayout) findViewById(R.id.layout_57);
        layout57.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://178.32.107.151:5116/stream/1/";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout58 = (RelativeLayout) findViewById(R.id.layout_58);
        layout58.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://192.111.140.6:8546/stream";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout59 = (RelativeLayout) findViewById(R.id.layout_59);
        layout59.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://prclive1.listenon.in:9908/;";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });
        RelativeLayout layout60 = (RelativeLayout) findViewById(R.id.layout_60);
        layout60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web1= "http://ample-zeno-11.radiojar.com/051bvhgvwa5tv?rj-ttl=5&rj-token=AAABZB_54pXgfr_FUMD9YNXgMkS9WAF0fBlkkF8LNiP2dYZLbHP8hQ";
                Intent i = new Intent(front1.this, MainActivity.class);
                startActivity(i);
            }

        });





    }
   /* public  String geturl()
    {
        return web1;
    }
*/
   private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
       ImageView bmImage;

       public DownloadImageTask(ImageView bmImage) {
           this.bmImage = bmImage;
       }

       protected Bitmap doInBackground(String... urls) {
           String urldisplay = urls[0];
           Bitmap mIcon11 = null;
           try {
               InputStream in = new java.net.URL(urldisplay).openStream();
               mIcon11 = BitmapFactory.decodeStream(in);
           } catch (Exception e) {
               Log.e("Error", e.getMessage());
               e.printStackTrace();
           }
           return mIcon11;
       }

       protected void onPostExecute(Bitmap result) {
           bmImage.setImageBitmap(result);
       }
   }


}