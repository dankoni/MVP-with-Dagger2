package com.androidmeetupdemo.weather.di;

import com.androidmeetupdemo.di.ActivityModule;
import com.androidmeetupdemo.di.ActivityScope;
import com.androidmeetupdemo.network.di.WeatherDataModule;
import com.androidmeetupdemo.weather.view.WeatherFragment;

import dagger.Component;

/**
 * Created by danko.misic on 11/18/16.
 */
@ActivityScope
@Component(modules = {ActivityModule.class,WeatherModule.class, WeatherDataModule.class})
public interface WeatherComponent {
    void inject(WeatherFragment weatherFragment);
}
