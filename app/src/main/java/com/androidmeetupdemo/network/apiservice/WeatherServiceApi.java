package com.androidmeetupdemo.network.apiservice;

import com.androidmeetupdemo.network.models.TownWeather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by danko.misic on 11/18/16.
 */
public interface WeatherServiceApi {

    @GET("data/2.5/weather")
    Observable<TownWeather> getTownWeather(@Query("q") String town, @Query("appid") String appId);
}
