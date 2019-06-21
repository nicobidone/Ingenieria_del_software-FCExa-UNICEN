package com.unicen.exa.ingenieria.geo_charts;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.unicen.exa.ingenieria.R;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class WebAppInterface {
    Context mContext;
    private HashMap<String, Integer> result;

    /**
     * Instantiate the interface and set the context
     */
    WebAppInterface(Context c, HashMap<String, Integer> result) {
        mContext = c;
        this.result = result;
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String[][] getInts() {
        return a1dToJson(result);
    }

    @JavascriptInterface
    public Integer getInt() {
        return 100;
    }

    private String[][] a1dToJson(HashMap<String, Integer> data) {
        String[][] array = new String[data.size()][2];
        int count = 1;
        array[0][0] = "Countries";
        array[0][0] = "Popularity";
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            array[count][0] = entry.getKey();
            array[count][1] = entry.getValue().toString();
            count++;
        }
        Log.d("array", data.toString());
        return array;
    }
}
