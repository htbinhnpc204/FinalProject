package com.htbinh.finalproject.ui.news;

import android.os.Parcel;
import android.os.Parcelable;


public class NewsModel implements Parcelable {
    private String title, description, date, imgLink, detailsLink;

    public NewsModel(String title, String description, String date, String imgLink, String detailsLink) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.imgLink = imgLink;
        this.detailsLink = detailsLink;
    }

    protected NewsModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        date = in.readString();
        imgLink = in.readString();
        detailsLink = in.readString();
    }

    public static final Creator<NewsModel> CREATOR = new Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel in) {
            return new NewsModel(in);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(date);
        parcel.writeString(imgLink);
        parcel.writeString(detailsLink);
    }
}