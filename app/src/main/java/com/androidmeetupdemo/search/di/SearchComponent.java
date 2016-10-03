package com.androidmeetupdemo.search.di;

import com.androidmeetupdemo.di.ActivityModule;
import com.androidmeetupdemo.di.ActivityScope;
import com.androidmeetupdemo.network.di.RetrofitModule;
import com.androidmeetupdemo.search.views.SearchFragment;

import dagger.Component;

/**
 * Created by danko.misic on 10/2/16.
 */
@ActivityScope
@Component (modules = {SearchModule.class,ActivityModule.class,RetrofitModule.class})
public interface SearchComponent {
    void inject(SearchFragment searchFragment);
}
