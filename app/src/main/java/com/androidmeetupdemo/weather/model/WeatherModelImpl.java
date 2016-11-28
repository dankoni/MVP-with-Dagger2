package com.androidmeetupdemo.weather.model;

import android.widget.ArrayAdapter;

import com.androidmeetupdemo.weather.presenter.WeatherPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by danko.misic on 11/23/16.
 */
public class WeatherModelImpl implements WeatherModel{
    WeatherPresenter presenter;
    WeatherDataRequests dataRequests;

    public WeatherModelImpl(WeatherPresenter presenter, WeatherDataRequests dataRequests) {
        this.presenter = presenter;
        this.dataRequests = dataRequests;
    }

    @Override
    public void requestForTemp(List<String> towns) {
        dataRequests.listOfWeatherForTowns(towns).subscribeOn(Schedulers.io()).subscribe(new Subscriber<List<Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Integer> integers) {
                presenter.dataCompiled(integers);
            }
        });

    }

}
