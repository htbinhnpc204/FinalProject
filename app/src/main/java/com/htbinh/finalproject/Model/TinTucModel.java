package com.htbinh.finalproject.Model;

public class TinTucModel {
    private int hinhanh;
    private String thongtin ;
    private String ngay;
    private String noidung ;

    public TinTucModel(int hinhanh, String thongtin, String ngay, String noidung) {
        this.hinhanh = hinhanh;
        this.thongtin = thongtin;
        this.ngay = ngay;
        this.noidung = noidung;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
