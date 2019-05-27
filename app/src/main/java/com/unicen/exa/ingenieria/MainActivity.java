package com.unicen.exa.ingenieria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new MainView(this), new MainModel());

        WebView myWebView = (WebView) findViewById(R.id.webview);
        //myWebView.loadUrl("https://www.nintenderos.com/");

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.loadUrl("file:///android_asset/test.html");

        //myWebView.loadData(customHTML,"text/html","UTF-8");
    }
}
