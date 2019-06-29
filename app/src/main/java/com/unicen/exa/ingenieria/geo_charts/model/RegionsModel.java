package com.unicen.exa.ingenieria.geo_charts.model;

import java.io.Serializable;

public class RegionsModel implements Serializable {

    private static final String gc_region = "file:///android_asset/geocharts_region.html";

    public String get_gc_region(){
        return gc_region;
    }
}
