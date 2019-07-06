package com.unicen.exa.ingenieria.piechart;

import android.util.Log;
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
    private HashMap<String, Integer> data;
    private ArrayList<String> keys;
    private static final String TAG = "RecyclerViewAdapter";

    public RecyclerViewAdapter(HashMap<String, Integer> in){
        Log.d(TAG, "RecyclerViewAdapter: In: "+in);
//        data = new HashMap<>();
//        keys = new ArrayList<>();
//        for(String key : in.keySet()){
//            data.put(key,in.get(key));
//            keys.add(key);
//        }

        data = new HashMap<>();
        data.put("HOLAAAAAAAAAAAA",3);
        keys = new ArrayList<>(data.keySet());
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
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
