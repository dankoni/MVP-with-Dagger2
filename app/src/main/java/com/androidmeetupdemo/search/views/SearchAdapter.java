package com.androidmeetupdemo.search.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidmeetupdemo.R;
import com.androidmeetupdemo.network.models.Title;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danko.misic on 10/2/16.
 */
public class SearchAdapter extends ArrayAdapter<Title> {

    private final Context context;
    List<Title> data = new ArrayList<>();

    public SearchAdapter(Context context, int resource, List<Title> objects) {
        super(context, resource);
        this.context = context;
        this.data = objects;
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Title getItem(int position) {
        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.search_item, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.year = (TextView) convertView.findViewById(R.id.year);
            convertView.setTag(viewHolder);
        }

        final Title  title = getItem(position);
        viewHolder.title.setText(title.getTitle());
        viewHolder.year.setText(title.getYear());

        return convertView;
    }

    private static class ViewHolder {
        TextView title;
        TextView year;
    }

}
