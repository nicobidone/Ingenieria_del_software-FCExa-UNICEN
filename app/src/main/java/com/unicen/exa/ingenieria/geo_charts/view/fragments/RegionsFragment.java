package com.unicen.exa.ingenieria.geo_charts.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.geo_charts.model.RegionsWebAppInterface;

import java.io.Serializable;

public class RegionsFragment extends Fragment implements Serializable {

    public static final String TAG = "RegionsFragment";
    private static final String id_app = "Android";
    private String addr = "file:///android_asset/geocharts_region.html";

    private Serializable wai;
    public static RegionsFragment newInstance(RegionsWebAppInterface wai) {

        Bundle args = new Bundle();
        args.putSerializable("wai", (Serializable) wai);

        RegionsFragment fragment = new RegionsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null){
            wai = arguments.getSerializable("wai");
        }

        View view = inflater.inflate(R.layout.fragment_regions, container, false);
        WebView myWebView = view.findViewById(R.id.webview_geochart);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> replaceFragment(new RegionsFragment()));

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.addJavascriptInterface((RegionsWebAppInterface) wai, id_app);
        myWebView.loadUrl(addr);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            RegionsViewModel model = ViewModelProviders.of(getActivity()).get(RegionsViewModel.class);
            model.getSelected().observe(this, o -> {
                if ((boolean)o) {
                    replaceFragment(new RegionsFragment());
                    model.select(false);
                    Log.i(TAG,"New fragment set");
                }
            });
        }
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
