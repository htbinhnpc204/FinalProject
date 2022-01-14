package com.htbinh.finalproject.ui.schedule;

public class ScheduleModel {
    private String thu;
    private String monhoc;
    private String tiet;
    private String gv;
    private String phong;

    public ScheduleModel(String thu, String monhoc, String tiet, String gv, String phong) {
        this.thu = thu;
        this.monhoc = monhoc;
        this.tiet = tiet;
        this.gv = gv;
        this.phong = phong;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
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
