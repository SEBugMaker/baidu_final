package com.sunguyi.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunguyi.myapplication.R;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<Weather_Item> weatherList;

    public WeatherAdapter(List<Weather_Item> weatherList) {
        this.weatherList = weatherList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather_Item weatherItem = weatherList.get(position);
        holder.timeTextView.setText(weatherItem.getTime());
        holder.temperatureTextView.setText(weatherItem.getTemperature());
        holder.weatherIconImageView.setImageResource(weatherItem.getWeatherIcon());
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTextView;
        public TextView temperatureTextView;
        public ImageView weatherIconImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.time);
            temperatureTextView = itemView.findViewById(R.id.temperature);
            weatherIconImageView = itemView.findViewById(R.id.weatherIcon);

        }
    }
}