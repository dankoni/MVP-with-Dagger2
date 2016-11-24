package com.androidmeetupdemo.weather.di;


import com.androidmeetupdemo.network.apiservice.WeatherServiceApi;
import com.androidmeetupdemo.network.di.WeatherDataModule;
import com.androidmeetupdemo.weather.model.WeatherDataRequests;
import com.androidmeetupdemo.weather.presenter.WeatherPresenter;
import com.androidmeetupdemo.weather.presenter.WeatherPresenterImpl;
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
    WeatherView provideView(){
        return this.view;
    }

    @Provides
    WeatherPresenter providePresenter(){
        return new WeatherPresenterImpl();
    }

    @Provides
    WeatherDataRequests provideDataInteractor(WeatherServiceApi  weatherApi){
        return new WeatherDataRequests(weatherApi);
    }
}
