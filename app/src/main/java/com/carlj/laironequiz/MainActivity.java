package com.carlj.laironequiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView firstWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //WebView myWebView = new WebView(activityContext);
        //setContentView(myWebView);
        firstWebView = (WebView) findViewById(R.id.firstWebView);
        WebSettings settingsWebView = firstWebView.getSettings();
        settingsWebView.setJavaScriptEnabled(true);
        settingsWebView.setDomStorageEnabled(true);
        firstWebView.setWebChromeClient(new WebChromeClient());
        firstWebView.loadUrl("https://www.autoscuolalairone.it/quiz/mobile");
        firstWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //super.onPageFinished(view, url);
                CookieSyncManager.getInstance().sync();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (firstWebView.canGoBack())
            firstWebView.goBack();
        else
            super.onBackPressed();
    }
}
