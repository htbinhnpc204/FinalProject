package com.htbinh.finalproject.ui.personInfor;

public class PersonInforModel {

    private String stdid, name, ctzcard, pob, phone, email;

    public PersonInforModel(String stdid, String name, String ctzcard, String pob, String phone, String email) {
        this.stdid = stdid;
        this.name = name;
        this.ctzcard = ctzcard;
        this.pob = pob;
        this.phone = phone;
        this.email = email;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtzcard() {
        return ctzcard;
    }

    public void setCtzcard(String ctzcard) {
        this.ctzcard = ctzcard;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}