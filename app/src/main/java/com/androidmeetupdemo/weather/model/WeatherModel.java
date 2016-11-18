package com.androidmeetupdemo.weather.model;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by danko.misic on 11/18/16.
 */
public interface WeatherModel {
    void requestForTemp(ArrayList<String> towns);
    void dataReady(ArrayAdapter<Integer> temps);
}
