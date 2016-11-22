package com.androidmeetupdemo.weather.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidmeetupdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danko.misic on 11/18/16.
 */
public class WeatherFragment extends Fragment{


    @BindView(R.id.weather_recycler_view)
    RecyclerView mRecycView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);
        ButterKnife.bind(this,view);

        return view;
    }
}
