package com.unicen.exa.ingenieria.geo_charts.view;

import android.app.Activity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.RootFragment;
import com.unicen.exa.ingenieria.SlidePagerAdapter;
import com.unicen.exa.ingenieria.geo_charts.model.RegionsWebAppInterface;
import com.unicen.exa.ingenieria.geo_charts.view.fragments.RegionsFragment;
import com.unicen.exa.ingenieria.geo_charts.view.fragments.RegionsSettingsFragment;

public class RegionsView {


    private ViewPager mPager;
    private SlidePagerAdapter mPagerAdapter;

    public RegionsView(Activity activity, FragmentManager supportFragmentManager){
        Fragment regionsFragment = RegionsFragment.newInstance(new RegionsWebAppInterface(activity));
        Fragment regionsSettingsFragment = new RegionsSettingsFragment();

        mPager = activity.findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(supportFragmentManager, RootFragment.newInstance(regionsFragment), regionsSettingsFragment);
        mPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = activity.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager);
        setTabsText(tabLayout);
        setToolbar(activity);
    }

    private void setTabsText(TabLayout tabLayout) {
        TabLayout.Tab tabAt0 = tabLayout.getTabAt(0);
        if (tabAt0 != null) {
            tabAt0.setText("Chart");
        }
        TabLayout.Tab tabAt1 = tabLayout.getTabAt(1);
        if (tabAt1 != null) {
            tabAt1.setText("Settings");
        }
    }

    private void setToolbar(Activity activity){
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        DrawerLayout drawer = activity.findViewById(R.id.drawer_layout);
        NavigationView navigationView = activity.findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) activity);
    }

//    public void set_gc_region(String gc_region) {
//        gc_region = gc_region;
//    }
//
//    public String get_gc_region(){
//        return gc_region;
//    }
}
