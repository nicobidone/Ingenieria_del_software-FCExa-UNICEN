package com.unicen.exa.ingenieria.geo_charts;

import java.util.HashMap;

public class GeoChartModel {

    private HashMap<String, Integer> result_model;

    private static final String gc_region = "file:///android_asset/geocharts_region.html";

    public GeoChartModel(HashMap<String, Integer> result){
        this.result_model = new HashMap<String, Integer>(result);
    }

    public String get_gc_region(){
        return gc_region;
    }

    public HashMap<String, Integer> getResult(){
        return this.result_model;
    }
}
