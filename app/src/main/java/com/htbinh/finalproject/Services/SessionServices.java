package com.htbinh.finalproject.Services;

import android.util.DisplayMetrics;

import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;
import com.htbinh.finalproject.ui.news.NewsModel;
import com.htbinh.finalproject.ui.personInfo.StudentModel;

import java.util.ArrayList;

public class SessionServices {
    //This class for storing data to deliver in app!!
    public static DisplayMetrics appMetrics;
    public static ArrayList<NewsModel> listNews;
    public static ArrayList<ExamScheduleModel> listExamSchedule;
    public static StudentModel personInfoModel;



    public static DisplayMetrics getAppMetrics() {
        return appMetrics;
    }
    public static void setAppMetrics(DisplayMetrics appMetrics) {
        SessionServices.appMetrics = appMetrics;
    }

    public static ArrayList<NewsModel> getListNews() {
        return listNews;
    }

    public static void setListNews(ArrayList<NewsModel> listNews) {
        SessionServices.listNews = listNews;
    }

    public static ArrayList<ExamScheduleModel> getListExamSchedule() {
        return listExamSchedule;
    }

    public static void setListExamSchedule(ArrayList<ExamScheduleModel> listExamSchedule) {
        SessionServices.listExamSchedule = listExamSchedule;
    }

    public static StudentModel getPersonInfoModel() {
        return personInfoModel;
    }

    public static void setPersonInfoModel(StudentModel personInfoModel) {
        SessionServices.personInfoModel = personInfoModel;
    }
}
