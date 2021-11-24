package com.htbinh.finalproject.ui.notification;

public class NotificationModel {
    private String tengv;
    private String lophp;
    private String ngaynhan;
    private String noidung;

    public NotificationModel(String tengv, String lophp, String ngaynhan, String noidung) {
        this.tengv = tengv;
        this.lophp = lophp;
        this.ngaynhan = ngaynhan;
        this.noidung = noidung;
    }

    public String getTengv() {
        return tengv;
    }

    public void setTengv(String tengv) {
        this.tengv = tengv;
    }

    public String getLophp() {
        return lophp;
    }

    public void setLophp(String lophp) {
        this.lophp = lophp;
    }

    public String getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(String ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
