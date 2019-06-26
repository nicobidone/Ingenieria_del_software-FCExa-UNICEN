package com.unicen.exa.ingenieria.geo_charts;

import android.os.Bundle;

import com.unicen.exa.ingenieria.MainActivity;
import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.geo_charts.model.RegionsModel;
import com.unicen.exa.ingenieria.geo_charts.presenter.RegionsPresenter;
import com.unicen.exa.ingenieria.geo_charts.view.RegionsView;

public class RegionsActivity extends MainActivity {

    private RegionsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        super.setToolbar();

        presenter = new RegionsPresenter(new RegionsView(this,getSupportFragmentManager()), new RegionsModel());
    }

}