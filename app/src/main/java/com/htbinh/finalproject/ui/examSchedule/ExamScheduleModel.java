package com.htbinh.finalproject.ui.examSchedule;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.htbinh.finalproject.ui.examSchedule.ExamScheduleModel;

public class ExamScheduleModel implements Parcelable{
    private String ngaythi;
    private String tenlhp;
    private String tenhp;
    private String giangvien;
    private String giothi;
    private String phongthi;


    public ExamScheduleModel(String s, String s1, String s2) {
    }

    public ExamScheduleModel(String ngaythi, String tenlhp, String tenhp, String giangvien, String giothi, String phongthi) {
        this.ngaythi = ngaythi;
        this.tenlhp = tenlhp;
        this.tenhp = tenhp;
        this.giangvien = giangvien;
        this.giothi = giothi;
        this.phongthi = phongthi;
    }

    protected ExamScheduleModel(Parcel in) {
        ngaythi = in.readString();
        tenlhp = in.readString();
        tenhp = in.readString();
        giangvien = in.readString();
        giothi = in.readString();
        phongthi = in.readString();
    }

    public static final Parcelable.Creator<ExamScheduleModel> CREATOR = new Parcelable.Creator<ExamScheduleModel>() {
        @Override
        public ExamScheduleModel createFromParcel(Parcel in) {
            return new ExamScheduleModel(in);
        }

        @Override
        public ExamScheduleModel[] newArray(int size) {
            return new ExamScheduleModel[size];
        }
    };

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    public String getTenlhp() {
        return tenlhp;
    }

    public void setTenlhp(String malhp) {
        this.tenlhp = malhp;
    }

    public String getTenhp() {
        return tenhp;
    }

    public void setTenhp(String tenhp) {
        this.tenhp = tenhp;
    }

    public String getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(String giangvien) {
        this.giangvien = giangvien;
    }

    public String getGiothi() {
        return giothi;
    }

    public void setGiothi(String giothi) {
        this.giothi = giothi;
    }

    public String getPhongthi() {
        return phongthi;
    }

    public void setPhongthi(String phongthi) {
        this.phongthi = phongthi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ngaythi);
        parcel.writeString(tenlhp);
        parcel.writeString(tenhp);
        parcel.writeString(giangvien);
        parcel.writeString(giothi);
        parcel.writeString(phongthi);
    }

}
