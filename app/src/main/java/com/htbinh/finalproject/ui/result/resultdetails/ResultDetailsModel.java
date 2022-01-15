package com.htbinh.finalproject.ui.result.resultdetails;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultDetailsModel implements Parcelable {
    private String tenMh;
    private String maHp;
    private String diemChu;
    private String tinChi;
    private String diemTk;

    public ResultDetailsModel(String tenMh, String maHp, String diemChu, String tinChi, String diemTk) {
        this.tenMh = tenMh;
        this.maHp = maHp;
        this.diemChu = diemChu;
        this.tinChi = tinChi;
        this.diemTk = diemTk;
    }

    protected ResultDetailsModel(Parcel in) {
        tenMh = in.readString();
        maHp = in.readString();
        diemChu = in.readString();
        tinChi = in.readString();
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
        parcel.writeString(diemTk);
    }
}
