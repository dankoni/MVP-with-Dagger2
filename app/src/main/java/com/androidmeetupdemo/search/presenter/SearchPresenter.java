package com.androidmeetupdemo.search.presenter;

import android.widget.ListView;

import com.androidmeetupdemo.network.models.Title;

import java.util.ArrayList;

/**
 * Created by dankoni on 9/28/16.
 */

public interface SearchPresenter {

    void requestTitles(String title);
    void updateSearchResult(ArrayList<Title> search);
}
