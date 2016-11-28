package com.androidmeetupdemo.weather.model;

import com.androidmeetupdemo.network.apiservice.WeatherServiceApi;
import com.androidmeetupdemo.network.models.TownWeather;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by danko.misic on 11/23/16.
 */
public class WeatherDataRequests {

    public static final String apiKey = "32bc7442fa84ffe869d8e4d9905757e2";
    private WeatherServiceApi serviceApi;

    public WeatherDataRequests(WeatherServiceApi weatherApi) {
        serviceApi=weatherApi;
    }

    private Observable<Integer> weatherForTown(String town){
        return serviceApi.getTownWeather(town,apiKey).map(new Func1<TownWeather, Double>() {
            @Override
            public Double call(TownWeather townWeather) {
                return townWeather.getMain().getTemp();
            }
        }).map(new Func1<Double, Integer>() {
            @Override
            public Integer call(Double aDouble) {
                return aDouble.intValue();
            }
        });
    }

    public Observable<List<Integer>> listOfWeatherForTowns(List<String> towns){
        return Observable.from(towns)
                .concatMap(new Func1<String, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(String s) {
                        return weatherForTown(s);
                    }
                }).toList();

    }
}
