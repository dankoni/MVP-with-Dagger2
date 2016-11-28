package com.androidmeetupdemo.weather.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danko.misic on 11/18/16.
 */
public interface WeatherPresenter {
    void askForTownData(List<String> towns);
    void dataCompiled(List<Integer> temperature);
}
