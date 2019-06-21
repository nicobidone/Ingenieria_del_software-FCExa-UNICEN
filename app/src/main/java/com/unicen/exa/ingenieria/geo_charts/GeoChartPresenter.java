package com.unicen.exa.ingenieria.geo_charts;

public class GeoChartPresenter {

    private GeoChartView view;
    private GeoChartModel model;

    public GeoChartPresenter(GeoChartView view, GeoChartModel model){
        this.view = view;
        this.model = model;
    }

    public void show_gc_map() {
        view.show_graphic(model.get_gc_region(), model.getResult());
    }
}
