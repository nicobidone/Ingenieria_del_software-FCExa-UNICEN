package com.unicen.exa.ingenieria.geo_charts.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.unicen.exa.ingenieria.R;
import java.io.Serializable;

public class RegionsFragment extends Fragment implements Serializable {

    public static final String TAG = "RegionsFragment";
    private static final String id_app = "Android";
    private String addr = "file:///android_asset/geocharts_region.html";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions, container, false);
        WebView myWebView = view.findViewById(R.id.webview_geochart);
        RegionsViewModel model = ViewModelProviders.of(getActivity()).get(RegionsViewModel.class);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.addJavascriptInterface(model.getWAI(), id_app);
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
