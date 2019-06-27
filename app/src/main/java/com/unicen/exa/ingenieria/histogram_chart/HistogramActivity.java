package com.unicen.exa.ingenieria.histogram_chart;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.unicen.exa.ingenieria.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HistogramActivity extends AppCompatActivity {

    private HashMap<String, Integer> result;
    private BarChart barchart;
    private TextView country_selected;
    private TextView country_downloads;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histogram);
        country_selected = findViewById(R.id.country_selected);
        country_downloads = findViewById(R.id.country_downloads);


        result = (HashMap<String, Integer>) getIntent().getSerializableExtra("result");

        barchart = findViewById(R.id.barchart);
        barchart.setDrawBarShadow(false);
        barchart.setDrawValueAboveBar(true);
        //barchart.setMaxVisibleValueCount(50);
        barchart.setPinchZoom(false);
        barchart.setDrawGridBackground(true);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> countries = new ArrayList();
        int i = 0;
        for(String key : result.keySet()){
            barEntries.add(new BarEntry(result.get(key),i));
            countries.add(key);
            i++;
        }



        BarDataSet dataSet = new BarDataSet(barEntries, "Countries");
        BarData data = new BarData(countries, dataSet);

        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        barchart.setData(data);
        barchart.getLegend().setEnabled(false);
        barchart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                country_selected.setText(countries.get(e.getXIndex()));

                float a = e.getVal();
                country_downloads.setText(String.valueOf(e.getVal()));
            }

            @Override
            public void onNothingSelected() {

            }
        });

    }
}
