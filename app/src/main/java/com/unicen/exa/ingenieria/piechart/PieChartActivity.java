package com.unicen.exa.ingenieria.piechart;

import android.graphics.Color;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
    private static final int MINIMO = 160;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        result = (HashMap<String, Integer>) getIntent().getSerializableExtra("result");
        piechart = findViewById(R.id.piechart);

        piechart.setUsePercentValues(false);
        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> entry = new ArrayList<PieEntry>();
        int count = 0;

        for( String key: result.keySet()){
            if(result.get(key) > MINIMO)
                entry.add(new PieEntry(result.get(key), key));
            else
                count+=result.get(key);
                //si hay tiempo podriamos listar los paises correspondientes a otros con sus cantidades
        }
        entry.add(new PieEntry(count, "Otros"));
        PieDataSet dataset = new PieDataSet(entry, "countries");
        dataset.setColors(ColorTemplate.VORDIPLOM_COLORS);

        PieData data = new PieData(dataset);

        piechart.setData(data);

    }
}
