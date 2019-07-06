package com.unicen.exa.ingenieria.piechart;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.unicen.exa.ingenieria.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PieChartActivity extends AppCompatActivity {

    private static final String TAG = "PieChartActivity";

    HashMap<String, Integer> data;
    HashMap<String, Integer> otros;
    private static int TOTAL = 0;
    private static final double PORCENTAJE_MINIMO = 0.02;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        initData();

        int otrosCount = 0;
        otros = new HashMap<>();
        for (String key : data.keySet()) {
            TOTAL += data.get(key);
            if (data.get(key) < TOTAL * PORCENTAJE_MINIMO) {
                otrosCount += data.get(key);
                otros.put(key, data.get(key));
            }
        }

        pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.getDescription().setText("");
        pieChart.getLegend().setEnabled(false);
        pieChart.disableScroll();
        pieChart.setRotationEnabled(false);
        ArrayList<PieEntry> entrys = new ArrayList<PieEntry>();


        for (String key : data.keySet()) {
            if (data.get(key) > TOTAL * PORCENTAJE_MINIMO)
                entrys.add(new PieEntry(data.get(key), key));
        } //si hay tiempo podriamos listar los paises correspondientes a otros con sus cantidades

        entrys.add(new PieEntry(otrosCount, "Otros"));
        final PieDataSet dataset = new PieDataSet(entrys, "countries");
        dataset.setColors(getColorArray());
        PieData data = new PieData(dataset);

        pieChart.setData(data);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                PieEntry entry = (PieEntry) e;
                int nro = (int) entry.getValue();
                String txt = String.valueOf(nro);
                Toast.makeText(PieChartActivity.this, txt, Toast.LENGTH_LONG).show();


                String label = entry.getLabel();
                if (label.equals("Otros"))
                    adapter.setData(otros);
                else {
                    HashMap<String, Integer> oneRelevantCountry = new HashMap<>();
                    oneRelevantCountry.put(label, nro);
                    adapter.setData(oneRelevantCountry);
                }
            }

            @Override
            public void onNothingSelected() {

            }
        });

    }


    private void initData() {
        TOTAL = 0;
        InputStream inputStream = getResources().openRawResource(R.raw.data);
        data = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                data.put(row[1], Integer.valueOf(row[2]));
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: " + e);
            }
        }
    }


    ArrayList<Integer> getColorArray() {
        ArrayList<Integer> out = new ArrayList<>();

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
