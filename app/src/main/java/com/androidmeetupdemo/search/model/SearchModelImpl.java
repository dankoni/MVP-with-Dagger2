package com.androidmeetupdemo.search.model;

import android.util.Log;

import com.androidmeetupdemo.network.apiservice.GetListOfTitles;
import com.androidmeetupdemo.network.apiservice.OmbdServiceApi;
import com.androidmeetupdemo.network.models.SearchResults;
import com.androidmeetupdemo.search.presenter.SearchPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by danko.misic on 10/2/16.
 */
public class SearchModelImpl implements SearchModel{

    private  OmbdServiceApi serviceApi;
    private  SearchPresenter presenter;

    public SearchModelImpl(OmbdServiceApi serviceApi, SearchPresenter presenter) {
        this.serviceApi = serviceApi;
        this.presenter = presenter;
    }

    @Override
    public void getSearchResults(String title) {

        Call<SearchResults> results = new GetListOfTitles(serviceApi).getSearchResult(title);
        results.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                Log.d(SearchModelImpl.class.getSimpleName(),"onResponse");
                SearchResults result = response.body();
                if(result.getTotalResults()>0) {
                    presenter.updateSearchResult(result.getSearch());
                }
            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                Log.d(SearchModelImpl.class.getSimpleName(),"onFailure");
            }
        });

    }
}
