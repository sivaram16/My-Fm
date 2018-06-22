package com.w3app.admin.tamilfmpart1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.w3app.admin.tamilfmpart1.Activity.MainActivity;
import com.w3app.admin.tamilfmpart1.R;


/**
 * Created by viaviweb-2 on 19-Apr-17.
 */

public class FacebookFragment extends Fragment {

    private WebView webView;
    private String postUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.facebook_fragment, container, false);

        postUrl=getResources().getString(R.string.facebookLink);

        webView = (WebView)view.findViewById(R.id.webView_facebook);
        webView.setWebViewClient(new MyBrowser());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(postUrl);
        webView.setHorizontalScrollBarEnabled(false);

        webView.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event ) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }

                return false;
            }
        });

        return view;

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            MainActivity.onBackPress=false;
        }
        else {
        }
    }

   /* public boolean canGoBack() {
        return this.webView != null && this.webView.canGoBack();
    }

    public void goBack() {
        if(this.webView != null) {
            this.webView.goBack();
        }
    }*/


}