package com.androidmeetupdemo;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidmeetupdemo.search.views.SearchFragment;
import com.androidmeetupdemo.weather.view.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchFragment searchFragment = new SearchFragment();
        WeatherFragment weatherFragment = new WeatherFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container,weatherFragment).commit();
    }
}
