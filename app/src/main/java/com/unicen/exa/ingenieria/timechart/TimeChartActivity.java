package com.unicen.exa.ingenieria.timechart;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.google.android.gms.maps.model.LatLng;
import com.unicen.exa.ingenieria.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TimeChartActivity extends AppCompatActivity {

    private HashMap<String, ArrayList<ItemDownload>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_chart);

        try {
            readItems(R.raw.dataset);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String[] countries = data.keySet().toArray(new String[0]);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                if (item instanceof String){
                    String country=(String) item;
                    ArrayList<ItemDownload> downloads = data.get(country);

                    LineChart timechart = findViewById(R.id.timechart);

                    ArrayList<Entry> values = new ArrayList<Entry>();
                    HashMap<Integer, Integer> down_per_month = new HashMap<Integer, Integer>();
                    for(ItemDownload i: downloads){
                        if(down_per_month.containsKey(i.getMonth()))
                            down_per_month.put(i.getMonth(), down_per_month.get(i.getMonth())+1);
                        else
                            down_per_month.put(i.getMonth(), 1);
                    }

                    for (int month: down_per_month.keySet())
                        values.add(new Entry(month, down_per_month.get(month)));

                    Collections.sort(values, new EntryXComparator());

                    LineDataSet dataSet = new LineDataSet(values, "Downloads");
                    LineData data = new LineData(dataSet);
                    timechart.setData(data);

                }
            }

        });

    }

    private void readItems(int resource) throws JSONException {
        data = new HashMap<String, ArrayList<ItemDownload>>();
        InputStream inputStream = getResources().openRawResource(resource);
        String json = new Scanner(inputStream).useDelimiter("\\A").next();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONArray object = array.getJSONArray(i);
            if (data.containsKey(object.getString(3))) {
                ArrayList<ItemDownload> l = data.get(object.getString(3));
                l.add(new ItemDownload(object.getString(2), 1));
                data.put(object.getString(3),l);
            }
            else{
                ArrayList<ItemDownload> l = new ArrayList<ItemDownload>();
                l.add(new ItemDownload(object.getString(2), 1));
                data.put(object.getString(3),l);
            }
        }

    }

    private class ItemDownload {

        private String date;

        private int month;

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getYear() {
            return year;
        }

        private int day;
        private int year;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getDownloads() {
            return downloads;
        }

        public void setDownloads(int downloads) {
            this.downloads = downloads;
        }

        private int downloads;


        public ItemDownload(String date, int downloads) {
            this.date = date;
            this.downloads = downloads;

            String[] date_array = this.date.split("/");
            this.month = Integer.valueOf(date_array[0]);
            this.day = Integer.valueOf(date_array[1]);
            this.year = Integer.valueOf(date_array[2]);

        }
    }
}

