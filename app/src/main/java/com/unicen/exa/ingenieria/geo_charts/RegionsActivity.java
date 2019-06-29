package com.unicen.exa.ingenieria.geo_charts;

import android.os.Bundle;

import com.unicen.exa.ingenieria.MainActivity;
import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.geo_charts.model.RegionsModel;
import com.unicen.exa.ingenieria.geo_charts.presenter.RegionsPresenter;
import com.unicen.exa.ingenieria.geo_charts.view.RegionsView;

import java.io.Serializable;
import java.util.HashMap;

public class RegionsActivity extends MainActivity implements Serializable {

    private RegionsPresenter presenter;
    private HashMap<String, Integer> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.result = (HashMap<String, Integer>) getIntent().getSerializableExtra("result");

        presenter = new RegionsPresenter(new RegionsView(this,getSupportFragmentManager(), result), new RegionsModel());
    }

}
