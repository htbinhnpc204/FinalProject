package com.htbinh.finalproject.ui.schedule;

public class scheduleModel {
    private String ngay;
    private String monhoc;
    private String tiet;
    private String gv;
    private String phong;

    public scheduleModel(String ngay, String monhoc, String tiet, String gv, String phong) {
        this.ngay = ngay;
        this.monhoc = monhoc;
        this.tiet = tiet;
        this.gv = gv;
        this.phong = phong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    public String getGv() {
        return gv;
    }

    public void setGv(String gv) {
        this.gv = gv;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }
}
