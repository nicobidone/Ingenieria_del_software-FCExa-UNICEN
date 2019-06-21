package com.unicen.exa.ingenieria.geo_charts.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.unicen.exa.ingenieria.R;

import java.io.Serializable;

public class RegionsFragment extends Fragment implements Serializable {

    public static final String TAG = "RegionsFragment";
    private static final String id_app = "Android";
    private static final String addr = "file:///android_asset/geocharts_region.html";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.webview_geochart);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.addJavascriptInterface(new RegionsWebAppInterface(getActivity()), id_app);
        myWebView.loadUrl(addr);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegionsView model = ViewModelProviders.of(getActivity()).get(RegionsView.class);
//        model.getSelected().observe(this,
//                o -> this.replaceFragment(new RegionsFragment()));

    }

    public void replaceFragment(Fragment regionsFragment) {
        FragmentTransaction trans = getFragmentManager()
                .beginTransaction();
        trans.replace(R.id.root_frame, regionsFragment);
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);

        trans.commit();
    }
}
