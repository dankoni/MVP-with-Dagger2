package com.androidmeetupdemo.weather.di;


import com.androidmeetupdemo.weather.view.WeatherView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danko.misic on 11/18/16.
 */
@Module
public class WeatherModule {
    private WeatherView view;

    @Provides
    WeatherView getView(){
        return this.view;
    }

}
