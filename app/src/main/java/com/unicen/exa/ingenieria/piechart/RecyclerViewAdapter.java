package com.unicen.exa.ingenieria.piechart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicen.exa.ingenieria.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private HashMap<String, Integer> result;
    private ArrayList<String> keys;
    private Context mcontext;
    Bundle bundle;

    public RecyclerViewAdapter(HashMap<String, Integer> result, Context mcontext){
        this.result = result;
        this.mcontext = mcontext;
        this.keys = new ArrayList<String>();
        for(String k: result.keySet())
            this.keys.add(k);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String country = keys.get(position);
        viewHolder.item.setText(country);
        int count = 0;
        if(result.containsKey(country))
            count = result.get(country);
        viewHolder.item_count.setText(String.valueOf(count));
    }

    @Override
    public int getItemCount() {
        return keys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView item;
        TextView item_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            item_count = itemView.findViewById(R.id.item_count);
        }
    }
}
