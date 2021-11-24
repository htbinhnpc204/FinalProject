package com.htbinh.finalproject.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.htbinh.finalproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsItemAdapter extends BaseAdapter {

    private final Context context;
    private final int layout;
    private final List<NewsModel> arraylist;

    public NewsItemAdapter(Context context, int layout, List<NewsModel> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        ImageView img = view.findViewById(R.id.news_img);
        TextView date = view.findViewById(R.id.news_date);
        TextView title = view.findViewById(R.id.news_title);
        TextView description = view.findViewById(R.id.news_des);

        NewsModel item = arraylist.get(i);

        Picasso.get().load("https://ute.udn.vn/Upload/TinTuc/khcnh3141121035349.jpg").resize(150, 150).
                centerCrop().into(img);
        title.setText(item.getTitle());
        date.setText(item.getDate());
        description.setText(item.getDescription());

        return view;
    }
}
