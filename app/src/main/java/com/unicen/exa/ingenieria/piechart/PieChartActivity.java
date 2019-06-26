package com.unicen.exa.ingenieria.piechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.unicen.exa.ingenieria.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
public class PieChartActivity extends AppCompatActivity {
    private HashMap<String, Integer> result;
    private PieChart piechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        result = (HashMap<String, Integer>) getIntent().getSerializableExtra("result");
        piechart = findViewById(R.id.piechart);

        piechart.setUsePercentValues(true);
        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> entry = new ArrayList<PieEntry>();

        for( String key: result.keySet()){
            entry.add(new PieEntry(result.get(key), key));

        }

        PieDataSet dataset = new PieDataSet(entry, "countries");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataset);

        piechart.setData(data);

    }
}
