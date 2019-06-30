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
    private static final int MINIMO = 20;

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
        dataset.setColors(getColorArray());

        PieData data = new PieData(dataset);

        piechart.setData(data);

    }

    ArrayList<Integer> getColorArray(){
        ArrayList<Integer> out =new ArrayList<>();

        Integer color;
        color = getResources().getColor(R.color.md_red_500);
        out.add(color);

        color = getResources().getColor(R.color.md_pink_500);
        out.add(color);

        color = getResources().getColor(R.color.md_purple_500);
        out.add(color);

        color = getResources().getColor(R.color.md_indigo_500);
        out.add(color);

        color = getResources().getColor(R.color.md_blue_500);
        out.add(color);

        color = getResources().getColor(R.color.md_cyan_500);
        out.add(color);

        color = getResources().getColor(R.color.md_teal_500);
        out.add(color);

        color = getResources().getColor(R.color.md_green_500);
        out.add(color);

        color = getResources().getColor(R.color.md_light_green_500);
        out.add(color);

        color = getResources().getColor(R.color.md_lime_500);
        out.add(color);

        color = getResources().getColor(R.color.md_yellow_500);
        out.add(color);

        color = getResources().getColor(R.color.md_orange_500);
        out.add(color);

        color = getResources().getColor(R.color.md_deep_orange_500);
        out.add(color);

        color = getResources().getColor(R.color.md_brown_500);
        out.add(color);

        color = getResources().getColor(R.color.md_red_700);
        out.add(color);

        color = getResources().getColor(R.color.md_pink_700);
        out.add(color);

        color = getResources().getColor(R.color.md_purple_700);
        out.add(color);

        color = getResources().getColor(R.color.md_indigo_700);
        out.add(color);

        color = getResources().getColor(R.color.md_blue_700);
        out.add(color);

        color = getResources().getColor(R.color.md_cyan_700);
        out.add(color);

        color = getResources().getColor(R.color.md_teal_700);
        out.add(color);

        color = getResources().getColor(R.color.md_green_700);
        out.add(color);

        color = getResources().getColor(R.color.md_light_green_700);
        out.add(color);

        color = getResources().getColor(R.color.md_lime_700);
        out.add(color);

        color = getResources().getColor(R.color.md_yellow_700);
        out.add(color);

        color = getResources().getColor(R.color.md_orange_700);
        out.add(color);

        color = getResources().getColor(R.color.md_deep_orange_700);
        out.add(color);

        color = getResources().getColor(R.color.md_brown_700);
        out.add(color);

        color = getResources().getColor(R.color.md_red_200);
        out.add(color);

        color = getResources().getColor(R.color.md_pink_200);
        out.add(color);

        color = getResources().getColor(R.color.md_purple_200);
        out.add(color);

        color = getResources().getColor(R.color.md_indigo_200);
        out.add(color);

        color = getResources().getColor(R.color.md_blue_200);
        out.add(color);

        color = getResources().getColor(R.color.md_cyan_200);
        out.add(color);

        color = getResources().getColor(R.color.md_teal_200);
        out.add(color);

        color = getResources().getColor(R.color.md_green_200);
        out.add(color);

        color = getResources().getColor(R.color.md_light_green_200);
        out.add(color);

        color = getResources().getColor(R.color.md_lime_200);
        out.add(color);

        color = getResources().getColor(R.color.md_yellow_200);
        out.add(color);

        color = getResources().getColor(R.color.md_orange_200);
        out.add(color);

        color = getResources().getColor(R.color.md_deep_orange_200);
        out.add(color);

        color = getResources().getColor(R.color.md_brown_200);
        out.add(color);


        return out;
    }
}