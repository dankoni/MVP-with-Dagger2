package com.androidmeetupdemo.search.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidmeetupdemo.R;
import com.androidmeetupdemo.network.apiservice.OmbdServiceApi;
import com.androidmeetupdemo.network.models.Title;
import com.androidmeetupdemo.search.model.SearchModel;
import com.androidmeetupdemo.search.model.SearchModelImpl;
import com.androidmeetupdemo.search.views.SearchAdapter;
import com.androidmeetupdemo.search.views.SearchView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by danko.misic on 10/2/16.
 */
public class SearchPresenterImpl implements SearchPresenter{
    private SearchView view;
    private SearchModel model;
    private ArrayList<Title> searchData;

    public SearchPresenterImpl(SearchView view,OmbdServiceApi serviceApi) {
        this.view = view;
        this.model = new SearchModelImpl(serviceApi,this);
    }

    @Override
    public void requestTitles(String title) {
        model.getSearchResults(title);
    }

    @Override
    public void updateSearchResult(ArrayList<Title> searchResults) {
        this.searchData = searchResults;
        view.searchComplete(searchResults);
    }

}
