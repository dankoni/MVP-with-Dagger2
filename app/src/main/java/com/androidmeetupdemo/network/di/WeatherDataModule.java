package com.androidmeetupdemo.network.di;

import com.androidmeetupdemo.di.ActivityScope;
import com.androidmeetupdemo.network.apiservice.OmbdServiceApi;
import com.androidmeetupdemo.network.apiservice.WeatherServiceApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by danko.misic on 11/18/16.
 */
@Module
public class WeatherDataModule {
    private Retrofit retrofit;
    private WeatherServiceApi service;


    @Provides
    @ActivityScope
    WeatherServiceApi provideService(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client =  new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(WeatherServiceApi.class);
        return service;
    }
}
