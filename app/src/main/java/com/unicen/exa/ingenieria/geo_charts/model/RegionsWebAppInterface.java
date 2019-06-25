package com.unicen.exa.ingenieria.geo_charts.model;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.io.Serializable;

public class RegionsWebAppInterface implements Serializable {
    Context mContext;

    /** Instantiate the interface and set the context */
    public RegionsWebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String getInts(){
        Integer[] aux = new Integer[3];
        aux[0] = 100;
        aux[1] = 200;
        aux[2] = 300;
        return a1dToJson(aux).toString();
    }

    @JavascriptInterface
    public Integer getInt(){
        return 100;
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
}

