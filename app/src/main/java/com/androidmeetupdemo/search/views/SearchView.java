package com.androidmeetupdemo.search.views;

import com.androidmeetupdemo.network.models.Title;

import java.util.ArrayList;

/**
 * Created by dankoni on 9/25/16.
 */

public interface SearchView {
    void searchComplete(ArrayList<Title> searchResults);
}
