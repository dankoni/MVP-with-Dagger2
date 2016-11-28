package com.androidmeetupdemo.weather.model;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danko.misic on 11/18/16.
 */
public interface WeatherModel {
    void requestForTemp(List<String> towns);
}
