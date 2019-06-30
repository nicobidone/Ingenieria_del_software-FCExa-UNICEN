package com.unicen.exa.ingenieria.height_map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.FillExtrusionLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.unicen.exa.ingenieria.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static com.mapbox.mapboxsdk.style.expressions.Expression.get;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillExtrusionColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillExtrusionHeight;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillExtrusionOpacity;

/**
 * Use data-driven styling and GeoJSON data to set extrusions' heights
 */
public class HeightMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private HashMap<String, Integer> result;
    private JSONArray array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.result = (HashMap<String, Integer>) getIntent().getSerializableExtra("result");
        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));

        // This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_height_map);

        InputStream inputStream = getResources().openRawResource(R.raw.countries);
        String json = new Scanner(inputStream).useDelimiter("\\A").next();
        try {
            this.array = new JSONArray(json);
            int a = 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*for(int i = 0; i < array.length(); i++){
            JSONObject jsonObj = (JSONObject)array.get(i); // get the josn object
            if(jsonObj.getString("name").equals("Rose")){ // compare for the key-value
                ((JSONObject)arr.get(i)).put("id", 22); // put the new value for the key
            }
            textview.setText(arr.toString());// display and verify your Json with updated value
        }*/

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        mapboxMap.setStyle(Style.SATELLITE, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                // Add the marathon route source to the map
                // Create a GeoJsonSource and use the Mapbox Datasets API to retrieve the GeoJSON data
                // More info about the Datasets API at https://www.mapbox.com/api-documentation/#retrieve-a-dataset
                GeoJsonSource courseRouteGeoJson = new GeoJsonSource(
                        "coursedata", loadJsonFromAsset("countries.geojson"));

                style.addSource(courseRouteGeoJson);
                addExtrusionsLayerToMap(style);
            }
        });
    }

    private void addExtrusionsLayerToMap(@NonNull Style loadedMapStyle) {
        // Add FillExtrusion layer to map using GeoJSON data
        loadedMapStyle.addLayer(new FillExtrusionLayer("course", "coursedata").withProperties(
                fillExtrusionColor(Color.YELLOW),
                fillExtrusionOpacity(0.7f),
                fillExtrusionHeight(get("e"))));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private String loadJsonFromAsset(String filename) {
        // Using this method to load in GeoJSON files from the assets folder.
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
