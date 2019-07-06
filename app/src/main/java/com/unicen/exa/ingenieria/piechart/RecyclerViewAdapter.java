package com.unicen.exa.ingenieria.piechart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicen.exa.ingenieria.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private HashMap<String, Integer> data;
    private ArrayList<String> keys;
    private static final String TAG = "RecyclerViewAdapter";

    public RecyclerViewAdapter() {
        data = new HashMap<>();
        keys = new ArrayList<>(data.keySet());
    }

    public HashMap<String, Integer> getData() {
        return data;
    }

    public void setData(HashMap<String, Integer> data) {
        this.data = new HashMap<>(data);
        keys = new ArrayList<>(this.data.keySet());
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String country = keys.get(position);
        viewHolder.item.setText(country);
        int count = 0;
        if(data.containsKey(country))
            count = data.get(country);
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
