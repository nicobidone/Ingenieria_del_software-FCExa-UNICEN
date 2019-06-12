package com.unicen.exa.ingenieria.geo_charts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unicen.exa.ingenieria.R;

public class GeoChartActivity extends AppCompatActivity {

    private GeoChartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_chart);

        presenter = new GeoChartPresenter(new GeoChartView(this), new GeoChartModel());

        presenter.show_gc_map();
    }
}
