package com.htbinh.finalproject.ui.tuitionfee;

public class TuitionfeeModel {
    private String hocki;
    private String Namhoc;
    private String stcdk;
    private String hocphipn;
    private String sonokt;
    private String Tongtien;

    public TuitionfeeModel(String hocki, String namhoc, String stcdk, String hocphipn, String sonokt, String tongtien) {
        this.hocki = hocki;
        Namhoc = namhoc;
        this.stcdk = stcdk;
        this.hocphipn = hocphipn;
        this.sonokt = sonokt;
        Tongtien = tongtien;

    }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    public String getNamhoc() {
        return Namhoc;
    }

    public void setNamhoc(String namhoc) {
        Namhoc = namhoc;
    }

    public String getStcdk() {
        return stcdk;
    }

    public void setStcdk(String stcdk) {
        this.stcdk = stcdk;
    }

    public String getHocphipn() {
        return hocphipn;
    }

    public void setHocphipn(String hocphipn) {
        this.hocphipn = hocphipn;
    }

    public String getSonokt() {
        return sonokt;
    }

    public void setSonokt(String sonokt) {
        this.sonokt = sonokt;
    }

    public String getTongtien() {
        return Tongtien;
    }

    public void setTongtien(String tongtien) {
        Tongtien = tongtien;
    }
}
