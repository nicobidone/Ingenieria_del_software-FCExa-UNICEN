package com.unicen.exa.ingenieria.geo_charts.view.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegionsViewModel extends ViewModel {

    private final MutableLiveData<Object> selected = new MutableLiveData<>();

    public void select(Object item) {
        selected.setValue(item);
    }

    public LiveData<Object> getSelected() {
        return selected;
    }
}
