package com.unicen.exa.ingenieria;

// For this example, only two pages

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


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
