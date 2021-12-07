package com.htbinh.finalproject;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;
import com.htbinh.finalproject.ui.news.NewsModel;
import com.htbinh.finalproject.ui.personInfo.PersonInfoModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SessionServices {
    //This class for storing data to deliver in app!!
    public static ArrayList<NewsModel> listNews;

    public static ArrayList<NewsModel> getListNews() {
        return listNews;
    }

    public static void setListNews(ArrayList<NewsModel> listNews) {
        SessionServices.listNews = listNews;
    }

    public  static PersonInfoModel listPerson;

    public static PersonInfoModel getListPerson() {
        return listPerson;
    }

    public static void setListPerson(PersonInfoModel listPerson) {
        SessionServices.listPerson = listPerson;
    }

    public static ArrayList<ExamScheduleModel> listExamSchedule;

    public static ArrayList<ExamScheduleModel> getListExamSchedule() {
        return listExamSchedule;
    }

    public static void setListExamSchedule(ArrayList<ExamScheduleModel> listExamSchedule) {
        SessionServices.listExamSchedule = listExamSchedule;
    }
}
