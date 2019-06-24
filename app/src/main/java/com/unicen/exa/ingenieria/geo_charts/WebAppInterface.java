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
        this.result = new HashMap<String, Integer>(result);
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String getInts() {
        return a1dToJson(this.result).toString();
    }

    @JavascriptInterface
    public Integer getInt() {
        return 100;
    }

    private String a1dToJson(HashMap<String, Integer> data) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        int i=0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (i > 0)
                sb.append(",");
            sb.append("\""+entry.getKey()+"\""+","+entry.getValue());
            i++;
        }
        sb.append("]");
        return sb.toString();
    }
}
