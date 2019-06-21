package com.unicen.exa.ingenieria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.unicen.exa.ingenieria.geo_charts.RegionsActivity;

public class MainActivity extends FragmentActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private int counter = 0;

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setVisibility(View.GONE);

        /* Instantiate a ViewPager and a PagerAdapter. */
        mPager = (ViewPager) findViewById(R.id.pager);
        //mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), new FirstFragment(), new SecondFragment());
        mPager.setAdapter(mPagerAdapter);
    }

    public void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent intent;

        int id = item.getItemId();

        if (id == R.id.nav_region_geo_charts) {
            startActivity(new Intent(this, RegionsActivity.class));
        } else if (id == R.id.nav_any_charts) {

        } else if (id == R.id.nav_mpandroid_charts) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)
            counter = savedInstanceState.getInt("counter");
    }

    protected void setTabsText(TabLayout tabLayout) {
        TabLayout.Tab tabAt0 = tabLayout.getTabAt(0);
        if (tabAt0 != null) {
            tabAt0.setText("Chart");
        }
        TabLayout.Tab tabAt1 = tabLayout.getTabAt(1);
        if (tabAt1 != null) {
            tabAt1.setText("Settings");
        }
    }
}
