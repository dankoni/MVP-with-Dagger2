package com.androidmeetupdemo.weather.presenter;

import com.androidmeetupdemo.weather.model.WeatherDataRequests;
import com.androidmeetupdemo.weather.model.WeatherModel;
import com.androidmeetupdemo.weather.model.WeatherModelImpl;
import com.androidmeetupdemo.weather.view.WeatherView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danko.misic on 11/24/16.
 */
public class WeatherPresenterImpl implements WeatherPresenter {
    WeatherView view;
    WeatherModel model;

    public WeatherPresenterImpl(WeatherDataRequests dataRequests) {
        this.model = new WeatherModelImpl(this,dataRequests);
    }

    @Override
    public void askForTownData(ArrayList<String> towns) {
        model.requestForTemp(towns);
    }

    @Override
    public void dataCompiled(List<Integer> temperature) {
           view.updateView(temperature);
    }
}
