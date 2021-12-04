package com.htbinh.finalproject;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.htbinh.finalproject.ui.news.NewsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SessionServices {
    public static ArrayList<NewsModel> listNews;

    public static ArrayList<NewsModel> getListNews() {
        return listNews;
    }

    public static void setListNews(ArrayList<NewsModel> listNews) {
        SessionServices.listNews = listNews;
    }
}
