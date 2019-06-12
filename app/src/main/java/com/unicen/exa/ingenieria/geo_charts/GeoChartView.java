package com.unicen.exa.ingenieria.geo_charts;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.unicen.exa.ingenieria.R;

public class GeoChartView {

    private Activity activity;
    private static final String id_app  = "Android";

    public GeoChartView(Activity activity) {
        this.activity = activity;
    }

    public void show_graphic(String addr){
        WebView myWebView = (WebView) activity.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setUseWideViewPort(true);

        myWebView.addJavascriptInterface(new WebAppInterface(activity.getApplication()), id_app);
        myWebView.loadUrl(addr);
    }


}
