package com.unicen.exa.ingenieria.geo_charts.view.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.unicen.exa.ingenieria.geo_charts.model.RegionsWebAppInterface;

public class RegionsViewModel extends ViewModel {

    private final MutableLiveData<Object> selected = new MutableLiveData<>();
    private RegionsWebAppInterface wai;

    public void select(Object item) {
        selected.setValue(item);
    }

    public LiveData<Object> getSelected() {
        return selected;
    }

    public RegionsWebAppInterface getWAI() {
        return wai;
    }

    public void setWAI(RegionsWebAppInterface wai) {
        this.wai = wai;
    }


}
