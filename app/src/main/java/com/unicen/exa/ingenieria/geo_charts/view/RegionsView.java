package com.unicen.exa.ingenieria.geo_charts.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

public class RegionsView extends ViewModel {

    private Fragment regionFragment, regionSettingsFragment;

//    public RegionsView(){
//
//    }
//
//    public RegionsView(Fragment regionFragment, Fragment regionSettingsFragment) {
//        this.regionFragment = regionFragment;
//        this.regionSettingsFragment = regionSettingsFragment;
//    }

    private final MutableLiveData<Object> selected = new MutableLiveData<>();

    public void select(Object item) {
        selected.setValue(item);
    }

    public LiveData<Object> getSelected() {
        return selected;
    }
}
