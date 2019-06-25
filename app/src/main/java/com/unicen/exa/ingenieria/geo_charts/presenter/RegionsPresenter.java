package com.unicen.exa.ingenieria.geo_charts.presenter;

import com.unicen.exa.ingenieria.geo_charts.model.RegionsModel;
import com.unicen.exa.ingenieria.geo_charts.view.RegionsView;

public class RegionsPresenter{

    private RegionsView view;
    private RegionsModel model;

    public RegionsPresenter(RegionsView view, RegionsModel model){
        this.view = view;
        this.model = model;
    }

//    public void set_gc_region(){
//        view.set_gc_region(model.get_gc_region());
//    }
}
