package com.androidmeetupdemo.network.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

/**
 * Created by danko.misic on 10/2/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults {
    @JsonProperty("Search")
    ArrayList<Title> Search;
    int totalResults;
    @JsonProperty("Response")
    boolean response;

    public SearchResults() {
    }

    public ArrayList<Title> getSearch() {
        return Search;
    }

    public void setSearch(ArrayList<Title> search) {
        this.Search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
