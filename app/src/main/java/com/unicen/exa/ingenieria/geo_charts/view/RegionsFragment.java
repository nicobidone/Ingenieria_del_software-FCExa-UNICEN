package com.unicen.exa.ingenieria.geo_charts.view;

import android.arch.lifecycle.Observer;
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

import java.io.Serializable;

public class RegionsFragment extends Fragment implements Serializable {

    public static final String TAG = "RegionsFragment";
    private static final String id_app = "Android";
    private static final String addr = "file:///android_asset/geocharts_region.html";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions, container, false);
        WebView myWebView = view.findViewById(R.id.webview_geochart);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new RegionsFragment());
            }
        });
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            RegionsViewModel model = ViewModelProviders.of(getActivity()).get(RegionsViewModel.class);
            model.getSelected().observe(this, new Observer<Object>() {
                @Override
                public void onChanged(@Nullable Object o) {
                    if ((boolean)o) {
                        replaceFragment(new RegionsFragment());
                        model.select(false);
                        Log.i(TAG,"New fragment set");
                    }
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
