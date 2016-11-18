package com.androidmeetupdemo.weather.presenter;

import java.util.ArrayList;

/**
 * Created by danko.misic on 11/18/16.
 */
public interface WeatherPresenter {
    void askForTownData(ArrayList<String> towns);
    void dataCompiled(ArrayList<Integer> temperature);
}
