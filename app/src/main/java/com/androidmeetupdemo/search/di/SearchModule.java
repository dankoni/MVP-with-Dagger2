package com.androidmeetupdemo.search.di;

import android.content.Context;

import com.androidmeetupdemo.di.ActivityScope;
import com.androidmeetupdemo.network.apiservice.OmbdServiceApi;
import com.androidmeetupdemo.search.model.SearchModel;
import com.androidmeetupdemo.search.model.SearchModelImpl;
import com.androidmeetupdemo.search.presenter.SearchPresenter;
import com.androidmeetupdemo.search.presenter.SearchPresenterImpl;
import com.androidmeetupdemo.search.views.SearchView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danko.misic on 10/2/16.
 */
@Module
public class SearchModule{
    private SearchView view;

    public SearchModule(SearchView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    SearchView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    SearchPresenter providePresenter(SearchView view, OmbdServiceApi serviceApi){
        return new SearchPresenterImpl(view,serviceApi);
    }

}
