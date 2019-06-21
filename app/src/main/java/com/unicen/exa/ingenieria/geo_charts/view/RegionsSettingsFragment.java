package com.unicen.exa.ingenieria.geo_charts.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unicen.exa.ingenieria.R;

public class RegionsSettingsFragment extends Fragment {

    private RegionsView model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(RegionsView.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions_settings, container, false);

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(item -> {
            model.select(item);
        });
        return view;
    }
}
