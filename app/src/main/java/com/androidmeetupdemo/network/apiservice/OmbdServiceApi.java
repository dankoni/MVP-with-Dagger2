package com.androidmeetupdemo.network.apiservice;

import com.androidmeetupdemo.network.models.SearchResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dankoni on 9/26/16.
 */

public interface OmbdServiceApi {
    @GET("/")
    Call<SearchResults> searchByName(@Query("s") String title);
}
