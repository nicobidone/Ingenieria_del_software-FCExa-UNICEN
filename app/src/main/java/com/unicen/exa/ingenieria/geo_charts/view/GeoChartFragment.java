package com.unicen.exa.ingenieria.geo_charts.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.unicen.exa.ingenieria.R;

public class GeoChartFragment extends Fragment {

    public static final String TAG = "GeoChartFragment";
    private static final String id_app  = "Android";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_geo_chart, container, false);

        WebView myWebView = (WebView) view.findViewById(R.id.webview_geochart);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
//        myWebView.getSettings().setSupportZoom(true);
//        myWebView.getSettings().setBuiltInZoomControls(true);
//        myWebView.getSettings().setDisplayZoomControls(false);
//        myWebView.getSettings().setUseWideViewPort(true);

        myWebView.addJavascriptInterface(new WebAppInterface(getActivity()), id_app);
        myWebView.loadUrl("file:///android_asset/geocharts_region.html");

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }
}
