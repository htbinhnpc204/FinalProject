package com.htbinh.finalproject.ui.result;

import android.os.Parcel;
import android.os.Parcelable;


public class ResultModel implements Parcelable {
    private String hocky;
    private String soTcTichLuy;
    private String xeploai;
    private String diemTbcHocKy;
    private String diemTbcHocBong;



    public ResultModel(String hocky, String soTcTichLuy, String xeploai, String diemTbcHocKy, String diemTbcHocBong) {
        this.hocky = hocky;
        this.soTcTichLuy = soTcTichLuy;
        this.xeploai = xeploai;
        this.diemTbcHocKy = diemTbcHocKy;
        this.diemTbcHocBong = diemTbcHocBong;
    }

    protected ResultModel(Parcel in) {
        hocky = in.readString();
        soTcTichLuy = in.readString();
        xeploai = in.readString();
        diemTbcHocKy = in.readString();
        diemTbcHocBong = in.readString();
    }

    public static final Creator<ResultModel> CREATOR = new Creator<ResultModel>() {
        @Override
        public ResultModel createFromParcel(Parcel in) {
            return new ResultModel(in);
        }

        @Override
        public ResultModel[] newArray(int size) {
            return new ResultModel[size];
        }
    };

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }

    public String getSoTcTichLuy() {
        return soTcTichLuy;
    }

    public void setSoTcTichLuy(String soTcTichLuy) {
        this.soTcTichLuy = soTcTichLuy;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }

    public String getDiemTbcHocKy() {
        return diemTbcHocKy;
    }

    public void setDiemTbcHocKy(String diemTbcHocKy) {
        this.diemTbcHocKy = diemTbcHocKy;
    }

    public String getDiemTbcHocBong() {
        return diemTbcHocBong;
    }

    public void setDiemTbcHocBong(String diemTbcHocBong) {
        this.diemTbcHocBong = diemTbcHocBong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hocky);
        parcel.writeString(soTcTichLuy);
        parcel.writeString(xeploai);
        parcel.writeString(diemTbcHocKy);
        parcel.writeString(diemTbcHocBong);
    }

}


