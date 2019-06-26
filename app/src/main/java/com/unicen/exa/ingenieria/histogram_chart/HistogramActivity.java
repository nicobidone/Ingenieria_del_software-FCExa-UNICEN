package com.unicen.exa.ingenieria.histogram_chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
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
        ArrayList<String> countries = new ArrayList<String>();
        int i = 0;
        for (String key : result.keySet()) {
            barEntries.add(new BarEntry(result.get(key), i));
            countries.add(key);
            i++;
        }


        BarDataSet dataSet = new BarDataSet(barEntries, "Countries");
        BarData data = new BarData(dataSet);

        barchart.setData(data);
        barchart.getLegend().setEnabled(false);

        /*XAxis xaxis = barchart.getXAxis();
        xaxis.setValueFormatter(new MyAxisValueFormatter(countries));
        xaxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xaxis.setGranularity(1);
        xaxis.setCenterAxisLabels(true);
        xaxis.setAxisMinimum(1);*/

        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        /*barchart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                country_selected.setText(countries.get((int)e.getX()));
                int a = e.describeContents();

                country_downloads.setText(String.valueOf(e.describeContents()));
            }

            @Override
            public void onNothingSelected() {

            }
        });
*/
    }


    public class MyAxisValueFormatter implements IAxisValueFormatter{
        private ArrayList<String> mValues;

        public MyAxisValueFormatter(ArrayList<String> values){
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if((int) value < mValues.size())
                return mValues.get((int) value);
            else
                return "";
        }
    }

}
