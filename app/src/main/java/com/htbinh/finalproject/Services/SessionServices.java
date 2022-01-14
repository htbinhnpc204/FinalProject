package com.htbinh.finalproject.Services;

import android.util.DisplayMetrics;

import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;
import com.htbinh.finalproject.ui.news.NewsModel;
import com.htbinh.finalproject.ui.notification.NotificationModel;
import com.htbinh.finalproject.ui.personInfo.StudentModel;
import com.htbinh.finalproject.ui.result.ResultModel;
import com.htbinh.finalproject.ui.result.resultdetails.ResultDetailsModel;
import com.htbinh.finalproject.ui.schedule.ScheduleModel;
import com.htbinh.finalproject.ui.tuitionfee.TuitionfeeModel;

import java.util.ArrayList;

public class SessionServices {
    //This class for storing data to deliver in app!!
    public static DisplayMetrics appMetrics;
    public static ArrayList<NewsModel> listNews;
    public static ArrayList<ExamScheduleModel> listExamSchedule;
    public static StudentModel personInfoModel;
    public static ArrayList<ScheduleModel> listSchedule;
    public static ArrayList<TuitionfeeModel> listTuition;
    public static ArrayList<NotificationModel> listNotification;
    public static ArrayList<ResultModel> listResult;

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

    public static ArrayList<ScheduleModel> getListSchedule() {
        return listSchedule;
    }

    public static void setListSchedule(ArrayList<ScheduleModel> listSchedule) {
        SessionServices.listSchedule = listSchedule;
    }

    public static ArrayList<TuitionfeeModel> getListTuition() {
        return listTuition;
    }

    public static void setListTuition(ArrayList<TuitionfeeModel> listTuition) {
        SessionServices.listTuition = listTuition;
    }

    public static ArrayList<NotificationModel> getListNotification() {
        return listNotification;
    }

    public static void setListNotification(ArrayList<NotificationModel> listNotification) {
        SessionServices.listNotification = listNotification;
    }

    public static ArrayList<ResultModel> getListResult() {
        return listResult;
    }

    public static void setListResult(ArrayList<ResultModel> listResult) {
        SessionServices.listResult = listResult;
    }
}
