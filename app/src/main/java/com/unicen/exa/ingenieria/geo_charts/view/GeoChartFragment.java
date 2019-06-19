package com.unicen.exa.ingenieria.geo_charts.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.unicen.exa.ingenieria.R;

import java.io.Serializable;

public class GeoChartFragment extends Fragment implements Serializable {

    public static final String TAG = "GeoChartFragment";
    private static final String id_app  = "Android";
    private static final String addr = "file:///android_asset/geocharts_region.html";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_geo_chart, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.webview_geochart);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setUseWideViewPort(true);

        myWebView.addJavascriptInterface(new WebAppInterface(getActivity()), id_app);
        myWebView.loadUrl(addr);

        return view;
    }
}
