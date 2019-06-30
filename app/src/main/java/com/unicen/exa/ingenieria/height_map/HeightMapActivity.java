package com.unicen.exa.ingenieria.height_map;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cocoahero.android.geojson.Feature;
import com.cocoahero.android.geojson.FeatureCollection;
import com.cocoahero.android.geojson.GeoJSON;
import com.cocoahero.android.geojson.GeoJSONObject;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.FillExtrusionLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.unicen.exa.ingenieria.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static com.mapbox.mapboxsdk.style.expressions.Expression.get;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillExtrusionColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillExtrusionHeight;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillExtrusionOpacity;

/**
 * Use data-driven styling and GeoJSON data to set extrusions' heights
 */
public class HeightMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "HeightMapActivity";
    private MapView mapView;
    private HashMap<String, Integer> result;
    private JSONObject geojson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.result = (HashMap<String, Integer>) getIntent().getSerializableExtra("result");
        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
//        loadJson(R.raw.south_america);
        Log.d(TAG, "onCreate: AFTER LOAD");
        // This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_height_map);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    private void loadJson(int resource) {
        InputStream inputStream = getResources().openRawResource(resource);
        try {
            GeoJSONObject geoJSON = GeoJSON.parse(inputStream);
            FeatureCollection featureCollection = (FeatureCollection) geoJSON;
            List<Feature> features = featureCollection.getFeatures();

            for (Feature feature : features) {
                String country = feature.getProperties().getString("name");
                if (result.containsKey(country))
                    feature.getProperties().put("e", result.get(country));
                else
                    feature.getProperties().put("e", 0);
            }


            Log.d(TAG, "loadJson: featureCollection: " + featureCollection.toJSON());

            geojson = featureCollection.toJSON();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        mapboxMap.setStyle(Style.SATELLITE, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                // Add the marathon route source to the map
                // Create a GeoJsonSource and use the Mapbox Datasets API to retrieve the GeoJSON data
                // More info about the Datasets API at https://www.mapbox.com/api-documentation/#retrieve-a-dataset
//                GeoJsonSource courseRouteGeoJson = new GeoJsonSource("coursedata", HeightMapActivity.this.geojson.toString());
                Log.d(TAG, "ENTROOOOOOOOOOOOOOOOOOOOOOOOOOO");
                GeoJsonSource courseRouteGeoJson =
                        new GeoJsonSource("coursedata",
                                loadJsonFromAsset("marathon_route.geojson"));

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
