package com.androidmeetupdemo.weather.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidmeetupdemo.R;

import java.util.List;

/**
 * Created by danko.misic on 11/25/16.
 */
public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.ViewHolder>{

    private List<Integer> tempData;

    public WeatherRecyclerAdapter(List<Integer> tempData) {
        this.tempData = tempData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int temperature = tempData.get(position);
        holder.temperature.setText(String.valueOf(temperature));

    }

    @Override
    public int getItemCount() {
        return tempData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView temperature;
        public ViewHolder(View itemView) {
            super(itemView);
            temperature = (TextView) itemView.findViewById(R.id.temp_text);
        }
    }
}
