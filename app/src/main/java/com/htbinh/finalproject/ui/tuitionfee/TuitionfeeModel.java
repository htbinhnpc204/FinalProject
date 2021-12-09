package com.htbinh.finalproject.ui.tuitionfee;

public class TuitionfeeModel {
    private String hocki;
    private String stcdk;
    private String hocphipn;
    private String sonokt;
    private String sodukt;
    private String Tongtien;

    public TuitionfeeModel(String hocki, String stcdk, String hocphipn, String sonokt, String sodukt, String tongtien) {
        this.hocki = hocki;
        this.stcdk = stcdk;
        this.hocphipn = hocphipn;
        this.sonokt = sonokt;
        this.sodukt = sodukt;
        Tongtien = tongtien;
    }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
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

    public String getSodukt() {
        return sodukt;
    }

    public void setSodukt(String sodukt) {
        this.sodukt = sodukt;
    }

    public String getTongtien() {
        return Tongtien;
    }

    public void setTongtien(String tongtien) {
        Tongtien = tongtien;
    }
}
