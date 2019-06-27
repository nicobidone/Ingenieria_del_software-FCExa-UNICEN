package com.unicen.exa.ingenieria.geo_charts.model;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.io.Serializable;
import java.util.HashMap;

public class RegionsWebAppInterface implements Serializable {
    Context mContext;
    private HashMap<String, Integer> result;

    /** Instantiate the interface and set the context */
    public RegionsWebAppInterface(Context c, HashMap<String, Integer> result) {
        mContext = c;
        this.result = result;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String getInts(){
        Integer[] aux = new Integer[result.keySet().size()];
        int i =0;
        for(String key: result.keySet()) {
            aux[i] = result.get(key);
            i++;
        }
        return a1dToJson(aux).toString();
    }

    @JavascriptInterface
    public String getStrings(){
        String[] aux = new String[result.keySet().size()];
        int i =0;
        for(String key: result.keySet()) {
            aux[i] = key;
            i++;
        }
        return aStToJson(aux).toString();
    }

    private String a1dToJson(Integer[] data) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            Integer d = data[i];
            if (i > 0)
                sb.append(",");
            sb.append(d);
        }
        sb.append("]");
        return sb.toString();
    }

    private String aStToJson(String[] data) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            String d = data[i];
            sb.append("\"");
            if (i > 0){
                sb.append(",");
                sb.append("\"");
            }
            sb.append(d);
        }

        sb.append("\"");
        sb.append("]");
        return sb.toString();
    }
}

