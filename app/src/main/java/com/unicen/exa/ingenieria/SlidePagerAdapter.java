package com.unicen.exa.ingenieria;

// For this example, only two pages

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/* PagerAdapter class */
public class SlidePagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_ITEMS = 2;
    private Fragment first;
    private Fragment second;

    public SlidePagerAdapter(FragmentManager fm, Fragment first, Fragment second) {
        super(fm);
        this.first = first;
        this.second = second;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return first;
            case 1:
                return second;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
