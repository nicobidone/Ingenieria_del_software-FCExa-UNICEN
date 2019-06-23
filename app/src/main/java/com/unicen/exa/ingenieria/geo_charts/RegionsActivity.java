package com.unicen.exa.ingenieria.geo_charts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.unicen.exa.ingenieria.MainActivity;
import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.RootFragment;
import com.unicen.exa.ingenieria.SlidePagerAdapter;
import com.unicen.exa.ingenieria.geo_charts.presenter.RegionsPresenter;
import com.unicen.exa.ingenieria.geo_charts.view.RegionsFragment;
import com.unicen.exa.ingenieria.geo_charts.view.RegionsSettingsFragment;

public class RegionsActivity extends MainActivity {

    private RegionsPresenter presenter;
    private ViewPager mPager;
    private SlidePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setToolbar();


        Fragment regionsFragment = new RegionsFragment();
        Fragment regionsSettingsFragment = new RegionsSettingsFragment();
        mPager = findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), RootFragment.newInstance(regionsFragment), regionsSettingsFragment);
        mPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager);
        super.setTabsText(tabLayout);

//        presenter = new RegionsPresenter(new RegionsViewModel(regionsFragment, regionsSettingsFragment), new RegionsModel());
    }


}
