package com.unicen.exa.ingenieria.geo_charts.view.fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class RegionsViewModel extends ViewModel {

    private final MutableLiveData<Object> selected = new MutableLiveData<>();

    public void select(Object item) {
        selected.setValue(item);
    }

    public LiveData<Object> getSelected() {
        return selected;
    }
}
