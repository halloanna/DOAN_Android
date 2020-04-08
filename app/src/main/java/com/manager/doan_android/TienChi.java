package com.manager.doan_android;

public class TienChi {
    public TienChi(String ten, String tien, String ngay) {
        this.ten = ten;
        this.tien = tien;
        this.ngay=ngay;
    }

    public Integer _id;
    public String ten;
    public String tien;
    public String ngay;

    public Integer get_id() {
        return _id;
    }

    public String getTen() {
        return ten;
    }

    public String getTien() { return tien;   }
    public String getNgay(){return  ngay;}

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTien(String age) {
        this.tien = tien;
    }
    public void setNgay(String nam){this.ngay=ngay;}
}
