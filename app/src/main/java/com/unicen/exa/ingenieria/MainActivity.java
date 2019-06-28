package com.unicen.exa.ingenieria;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.unicen.exa.ingenieria.geo_charts.RegionsActivity;
import com.unicen.exa.ingenieria.heatmap_chart.HeatmapActivity;
import com.unicen.exa.ingenieria.histogram_chart.HistogramActivity;
import com.unicen.exa.ingenieria.piechart.PieChartActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MainActivity extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private int counter = 0;

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;
    private HashMap<String, Integer> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setVisibility(View.GONE);

        mPager = findViewById(R.id.pager);
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

        InputStream inputStream = getResources().openRawResource(R.raw.data);

        result = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                if(result.containsKey(row[3]))
                    result.put(row[3], result.get(row[3])+1);
                else
                    result.put(row[3], 1);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent intent;

        int id = item.getItemId();

        if (id == R.id.nav_region_geo_charts) {
            Intent i = new Intent(MainActivity.this, RegionsActivity.class);
            i.putExtra("result", result);
            startActivity(i);
        } else if (id == R.id.nav_histogram) {
            Intent i = new Intent(MainActivity.this, HistogramActivity.class);
            i.putExtra("result", result);
            startActivity(i);

        } else if (id == R.id.nav_pie_chart) {
            Intent i = new Intent(MainActivity.this, PieChartActivity.class);
            i.putExtra("result", result);
            startActivity(i);
        }else if(id == R.id.nav_region_heatmap){
            startActivity(new Intent(this, HeatmapActivity.class));
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