package com.example.minhd.hsumanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView wvNotificationContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wvNotificationContent=(WebView)findViewById(R.id.wv_NotificationContent);
        Intent intent=getIntent();
        String linkAfterGet=intent.getStringExtra("link");
        wvNotificationContent.loadUrl(linkAfterGet);
        wvNotificationContent.setWebViewClient(new WebViewClient());
    }
}
