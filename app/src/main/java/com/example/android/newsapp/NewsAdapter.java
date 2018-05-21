package com.example.android.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String Date_SEPARATOR = "T";
    private static final String TimeAppendix = "Z";
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();


    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        //set the news title
        TextView titleView = (TextView) listItemView.findViewById(R.id.news_title);
        String newsTitle = currentNews.getTitle();
        titleView.setText(newsTitle);

        //set the category
        TextView categroyView = (TextView) listItemView.findViewById(R.id.category);
        String category = currentNews.getCategory();
        categroyView.setText(category);

        //set the author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        String author = currentNews.getAuthor();
        authorView.setText(author);

        //set date and time
        String date = currentNews.getDate();
        String day = "";
        String time = "";
        if (date.contains(Date_SEPARATOR)) {
            String[] parts = date.split(Date_SEPARATOR);
            day = parts[0];
            time  = parts[1];

            if (time.contains(TimeAppendix)){
                String[] timeParts = time.split(TimeAppendix);
                time = timeParts[0];
            }
        }

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(day);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(time);

        return listItemView;
    }

}
