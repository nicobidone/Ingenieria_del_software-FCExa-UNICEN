package com.unicen.exa.ingenieria.geo_charts.presenter;

import com.unicen.exa.ingenieria.geo_charts.model.RegionsModel;
import com.unicen.exa.ingenieria.geo_charts.view.RegionsViewModel;

public class RegionsPresenter{

    private RegionsViewModel view;
    private RegionsModel model;

    public RegionsPresenter(RegionsViewModel view, RegionsModel model){
        this.view = view;
        this.model = model;
    }


}
