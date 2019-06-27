package com.unicen.exa.ingenieria.heatmap_chart;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.unicen.exa.ingenieria.R;

public abstract class BaseActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    protected int getLayoutId() {
        return R.layout.map;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUpMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMap();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        start();
    }

    private void setUpMap() {
        if (mMap == null) {
            MapFragment mapFragment = (MapFragment) getFragmentManager() .findFragmentById(R.id.map); mapFragment.getMapAsync(this);
        }
    }

    /**
     * Run the demo-specific code.
     */
    protected abstract void start();

    protected GoogleMap getMap() {
        return mMap;
    }
}
