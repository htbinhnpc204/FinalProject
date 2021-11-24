package com.htbinh.finalproject.ui.result;

public class ResultModel {
    private String name;
    private String tinchi;
    private String diemtbhk;
    private String diemtbhb;
    private String xeploai;

    public ResultModel(String name, String tinchi, String diemtbhk, String diemtbhb, String xeploai) {
        this.name = name;
        this.tinchi = tinchi;
        this.diemtbhk = diemtbhk;
        this.diemtbhb = diemtbhb;
        this.xeploai = xeploai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTinchi() {
        return tinchi;
    }

    public void setTinchi(String tinchi) {
        this.tinchi = tinchi;
    }

    public String getDiemtbhk() {
        return diemtbhk;
    }

    public void setDiemtbhk(String diemtbhk) {
        this.diemtbhk = diemtbhk;
    }

    public String getDiemtbhb() {
        return diemtbhb;
    }

    public void setDiemtbhb(String diemtbhb) {
        this.diemtbhb = diemtbhb;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }
}
