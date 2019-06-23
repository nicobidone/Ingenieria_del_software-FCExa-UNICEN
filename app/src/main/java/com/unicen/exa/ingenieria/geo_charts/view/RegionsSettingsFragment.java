package com.unicen.exa.ingenieria.geo_charts.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unicen.exa.ingenieria.R;

public class RegionsSettingsFragment extends Fragment {

    private RegionsViewModel model;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions_settings, container, false);
        Button button = view.findViewById(R.id.button2);

        if (getActivity() != null) {
            model = ViewModelProviders.of(getActivity()).get(RegionsViewModel.class);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.select(true);
                }
            });
        }

        return view;
    }


}
