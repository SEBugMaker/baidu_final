package com.sunguyi.myapplication;

public class Weather_Item {
    private String time;
    private String temperature;
    private int weatherIcon;



    public Weather_Item(String time, String temperature, int weatherIcon) {
        this.time = time;
        this.temperature = temperature;
        this.weatherIcon = weatherIcon;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }
}