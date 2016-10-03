package com.androidmeetupdemo.network.di;

import com.androidmeetupdemo.di.ActivityScope;
import com.androidmeetupdemo.network.apiservice.OmbdServiceApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by danko.misic on 10/2/16.
 */
@Module
public class RetrofitModule {
    private  Retrofit retrofit;
    private  OmbdServiceApi service;


    @Provides
    @ActivityScope
    OmbdServiceApi provideService(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(OmbdServiceApi.class);
        return service;
    }


}
