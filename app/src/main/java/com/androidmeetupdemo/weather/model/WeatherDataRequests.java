package com.androidmeetupdemo.weather.model;

import com.androidmeetupdemo.network.apiservice.WeatherServiceApi;
import com.androidmeetupdemo.network.models.TownWeather;

import java.util.List;

import rx.Observable;

/**
 * Created by danko.misic on 11/23/16.
 */
public class WeatherDataRequests {

    private WeatherServiceApi serviceApi;

    public WeatherDataRequests(WeatherServiceApi weatherApi) {
        serviceApi=weatherApi;
    }


    /*public Observable<List<Integer>> listOfWeatherForTowns(List<String> towns){
         return
    }*/
}
