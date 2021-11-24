package com.htbinh.finalproject.ui.resultdetails;

public class ResultDetailsModel {
    private String TenHP;
    private String MaHp;
    private String sotc;
    private String diemcc;
    private String diemgk;
    private String diemck;
    private String diemtk;
    private String diemchu;

    public ResultDetailsModel(String tenHP, String maHp, String sotc, String diemcc, String diemgk, String diemck, String diemtk, String diemchu) {
        TenHP = tenHP;
        MaHp = maHp;
        this.sotc = sotc;
        this.diemcc = diemcc;
        this.diemgk = diemgk;
        this.diemck = diemck;
        this.diemtk = diemtk;
        this.diemchu = diemchu;
    }

    public String getTenHP() {
        return TenHP;
    }

    public void setTenHP(String tenHP) {
        TenHP = tenHP;
    }

    public String getMaHp() {
        return MaHp;
    }

    public void setMaHp(String maHp) {
        MaHp = maHp;
    }

    public String getSotc() {
        return sotc;
    }

    public void setSotc(String sotc) {
        this.sotc = sotc;
    }

    public String getDiemcc() {
        return diemcc;
    }

    public void setDiemcc(String diemcc) {
        this.diemcc = diemcc;
    }

    public String getDiemgk() {
        return diemgk;
    }

    public void setDiemgk(String diemgk) {
        this.diemgk = diemgk;
    }

    public String getDiemck() {
        return diemck;
    }

    public void setDiemck(String diemck) {
        this.diemck = diemck;
    }

    public String getDiemtk() {
        return diemtk;
    }

    public void setDiemtk(String diemtk) {
        this.diemtk = diemtk;
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }
}
