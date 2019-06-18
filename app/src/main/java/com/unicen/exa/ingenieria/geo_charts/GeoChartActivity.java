package com.unicen.exa.ingenieria.geo_charts;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.unicen.exa.ingenieria.MainActivity;
import com.unicen.exa.ingenieria.R;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), new GeoChartFragment(), new GeoChartSettingsFragment());
        mPager.setAdapter(mPagerAdapter);

        presenter = new GeoChartPresenter(new GeoChartView(this), new GeoChartModel());
        //presenter.show_gc_map();
    }

}
