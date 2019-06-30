package com.unicen.exa.ingenieria.piechart;

import com.unicen.exa.ingenieria.MainActivity;
import com.unicen.exa.ingenieria.R;
import com.unicen.exa.ingenieria.heatmap_chart.BaseActivity;

import java.util.ArrayList;

public class ColorPallets {

    ArrayList<Integer> getColors(){
        ArrayList<Integer> out =new ArrayList<>();

        Integer color;
        color = MainActivity.getResources().getColor(R.color.md_red_500);
        out.add(color);

        color = MainActivity.getResources().getColor(R.color.md_pink_500);
        out.add(color);

        color = MainActivity.getResources().getColor(R.color.md__500);
        out.add(color);


        return out;
    }
}
