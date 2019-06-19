package com.unicen.exa.ingenieria.geo_charts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.unicen.exa.ingenieria.MainActivity;
import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.RootFragment;
import com.unicen.exa.ingenieria.SlidePagerAdapter;
import com.unicen.exa.ingenieria.geo_charts.model.GeoChartModel;
import com.unicen.exa.ingenieria.geo_charts.presenter.GeoChartPresenter;
import com.unicen.exa.ingenieria.geo_charts.view.GeoChartFragment;
import com.unicen.exa.ingenieria.geo_charts.view.GeoChartSettingsFragment;
import com.unicen.exa.ingenieria.geo_charts.view.GeoChartView;

public class GeoChartActivity extends MainActivity {

    private GeoChartPresenter presenter;
    private ViewPager mPager;
    private SlidePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setToolbar();

        Fragment geoChartFragment = new GeoChartFragment();
        Fragment geoChartSettingsFragment = new GeoChartSettingsFragment();

        mPager = findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), RootFragment.newInstance(geoChartFragment),geoChartSettingsFragment);
        mPager.setAdapter(mPagerAdapter);

        presenter = new GeoChartPresenter(new GeoChartView(this), new GeoChartModel());
    }

}
