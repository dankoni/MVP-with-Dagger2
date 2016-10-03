package com.androidmeetupdemo.search.views;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.androidmeetupdemo.R;
import com.androidmeetupdemo.di.ActivityModule;
import com.androidmeetupdemo.network.models.Title;
import com.androidmeetupdemo.search.di.DaggerSearchComponent;
import com.androidmeetupdemo.search.di.SearchModule;
import com.androidmeetupdemo.search.presenter.SearchPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SearchFragment extends Fragment implements SearchView{
    @BindView(R.id.search_button) Button searchButton;
    @BindView(R.id.enterTitle) EditText enterTitle;
    @BindView(R.id.searchList) ListView searchList;

    @Inject
    SearchPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this,view);

        DaggerSearchComponent.builder().activityModule(new ActivityModule(getActivity())).searchModule(new SearchModule(this)).build().inject(this);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!enterTitle.getText().toString().isEmpty() && !enterTitle.getText().toString().equalsIgnoreCase("")){
                    String  title = enterTitle.getText().toString();
                    presenter.requestTitles(title);
                }
            }
        });
        return view;
    }

    @Override
    public void searchComplete(ArrayList<Title> searchResults) {
         SearchAdapter adapter = new SearchAdapter(getActivity(),R.layout.search_item,searchResults);
         searchList.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

}
