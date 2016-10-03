package com.androidmeetupdemo.network.apiservice;

import com.androidmeetupdemo.network.models.SearchResults;

import retrofit2.Call;

/**
 * Created by danko.misic on 10/2/16.
 */
public class GetListOfTitles {
    OmbdServiceApi serviceApi;

    public GetListOfTitles(OmbdServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    public Call<SearchResults> getSearchResult(String title){
        return serviceApi.searchByName(title);
    }
}
