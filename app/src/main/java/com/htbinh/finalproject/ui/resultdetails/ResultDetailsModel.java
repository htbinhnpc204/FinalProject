package com.htbinh.finalproject.ui.resultdetails;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultDetailsModel implements Parcelable {
    private String tenMh;
    private String maHp;
    private String diemChu;
    private String tinChi;
    private String diemCc;
    private String diemGk;
    private String diemCk;
    private String diemTk;

    public ResultDetailsModel(String tenMh, String maHp, String diemChu, String tinChi, String diemCc, String diemGk, String diemCk, String diemTk) {
        this.tenMh = tenMh;
        this.maHp = maHp;
        this.diemChu = diemChu;
        this.tinChi = tinChi;
        this.diemCc = diemCc;
        this.diemGk = diemGk;
        this.diemCk = diemCk;
        this.diemTk = diemTk;
    }

    protected ResultDetailsModel(Parcel in) {
        tenMh = in.readString();
        maHp = in.readString();
        diemChu = in.readString();
        tinChi = in.readString();
        diemCc = in.readString();
        diemGk = in.readString();
        diemCk = in.readString();
        diemTk = in.readString();
    }

    public static final Creator<ResultDetailsModel> CREATOR = new Creator<ResultDetailsModel>() {
        @Override
        public ResultDetailsModel createFromParcel(Parcel in) {
            return new ResultDetailsModel(in);
        }

        @Override
        public ResultDetailsModel[] newArray(int size) {
            return new ResultDetailsModel[size];
        }
    };

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public String getDiemChu() {
        return diemChu;
    }

    public void setDiemChu(String diemChu) {
        this.diemChu = diemChu;
    }

    public String getTinChi() {
        return tinChi;
    }

    public void setTinChi(String tinChi) {
        this.tinChi = tinChi;
    }

    public String getDiemCc() {
        return diemCc;
    }

    public void setDiemCc(String diemCc) {
        this.diemCc = diemCc;
    }

    public String getDiemGk() {
        return diemGk;
    }

    public void setDiemGk(String diemGk) {
        this.diemGk = diemGk;
    }

    public String getDiemCk() {
        return diemCk;
    }

    public void setDiemCk(String diemCk) {
        this.diemCk = diemCk;
    }

    public String getDiemTk() {
        return diemTk;
    }

    public void setDiemTk(String diemTk) {
        this.diemTk = diemTk;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tenMh);
        parcel.writeString(maHp);
        parcel.writeString(diemChu);
        parcel.writeString(tinChi);
        parcel.writeString(diemCc);
        parcel.writeString(diemGk);
        parcel.writeString(diemCk);
        parcel.writeString(diemTk);
    }

}