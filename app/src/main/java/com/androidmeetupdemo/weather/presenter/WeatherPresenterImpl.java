package com.androidmeetupdemo.weather.presenter;

import com.androidmeetupdemo.network.models.Weather;
import com.androidmeetupdemo.weather.di.WeatherModule;
import com.androidmeetupdemo.weather.model.WeatherModel;
import com.androidmeetupdemo.weather.view.WeatherView;

import java.util.ArrayList;

/**
 * Created by danko.misic on 11/24/16.
 */
public class WeatherPresenterImpl implements WeatherPresenter {
    WeatherView view;
    WeatherModel model;

    @Override
    public void askForTownData(ArrayList<String> towns) {

    }

    @Override
    public void dataCompiled(ArrayList<Integer> temperature) {

    }
}
