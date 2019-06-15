package com.unicen.exa.ingenieria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.unicen.exa.ingenieria.chart_fragment.ChartsFragment;
import com.unicen.exa.ingenieria.geo_charts.GeoChartActivity;
import com.unicen.exa.ingenieria.settings_fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SettingsFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    private Fragment chartsFragment;
    private Fragment settingsFragment;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Fragments
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);

        /**
         * Solo creo las instancias de los fragments en la primera creacion de la activity
         * Los Fragments persisten en memoria... por eso estan los sets en el FragmentsListener
         * Que se lleman en los onAttach de los fragments (cuando se gira el telefono o vuelve la app de segundo plano)
         * OJO!! Si no se hace esto quedan fragments repetidos en memoria y mal vinculados con la Activity
         */
        if (savedInstanceState == null) {
            chartsFragment = new SettingsFragment();
            settingsFragment = new SettingsFragment();
        }

        FragmentManager manager = getSupportFragmentManager();
        pagerAdapter = new PagerAdapter(manager);
        pagerAdapter.addFragment(chartsFragment, "ChartsFragment");
        pagerAdapter.addFragment(settingsFragment, "SettingsFragment");
        viewPager.setAdapter(pagerAdapter);

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent intent;

        int id = item.getItemId();

        if (id == R.id.nav_region_geo_charts) {
            intent = new Intent(this, GeoChartActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_any_charts) {

        } else if (id == R.id.nav_mpandroid_charts) {
//            pagerAdapter.deleteLastFragment();
//            ChartsFragment chartsFragment = new ChartsFragment();
//            pagerAdapter.addFragment();
//
//            pagerAdapter.addFragment(chartsFragment, "ChartsFragment");

            ChartsFragment newFragment = new ChartsFragment();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.tab_layout, newFragment);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

    @Override
    public void onFragmentInteraction(int data) {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof SettingsFragment) {
            SettingsFragment settingsFragment = (SettingsFragment) fragment;
            settingsFragment.setOnFragmentInteractionListener(this);
        }
    }

}
