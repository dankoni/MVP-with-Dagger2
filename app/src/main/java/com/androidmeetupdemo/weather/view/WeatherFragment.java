package com.androidmeetupdemo.weather.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidmeetupdemo.R;
import com.androidmeetupdemo.network.di.WeatherDataModule;
import com.androidmeetupdemo.weather.di.DaggerWeatherComponent;
import com.androidmeetupdemo.weather.di.WeatherModule;
import com.androidmeetupdemo.weather.model.WeatherRecyclerAdapter;
import com.androidmeetupdemo.weather.presenter.WeatherPresenter;
import com.androidmeetupdemo.weather.presenter.WeatherPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danko.misic on 11/18/16.
 */
public class WeatherFragment extends Fragment implements WeatherView{


    @BindView(R.id.weather_recycler_view)
    RecyclerView mRecycView;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Inject
    WeatherPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);
        ButterKnife.bind(this,view);
        DaggerWeatherComponent.builder().weatherModule(new WeatherModule()).weatherDataModule(new WeatherDataModule()).build().inject(this);

        mRecycView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycView.setLayoutManager(mLayoutManager);

        ArrayList<String> towns = new ArrayList<>();
        towns.add("London");
        towns.add("London");
        towns.add("London");
        towns.add("London");
        towns.add("London");
        towns.add("London");
        towns.add("London");
        presenter.askForTownData(towns);

        ArrayList<Integer> towns2 = new ArrayList<>();
        towns2.add(1);
        towns2.add(2);
        towns2.add(3);
        towns2.add(4);
        towns2.add(5);
       // mAdapter = new WeatherRecyclerAdapter(towns2);
       // mRecycView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void updateView(List<Integer> temperature) {
        ArrayList<Integer> towns = new ArrayList<>();
        towns.add(1);
        towns.add(2);
        towns.add(3);
        towns.add(4);
        towns.add(5);
        mAdapter = new WeatherRecyclerAdapter(towns);
       mRecycView.setAdapter(mAdapter);

    }
}
