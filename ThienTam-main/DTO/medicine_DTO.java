package DTO;

import java.util.ArrayList;

public class medicine_DTO {
    private String mathuoc;
    private String maton;
    private String tenthuoc;

    private String danhmuc;
    private ArrayList<String> donvi;
    private String thanhphan;
    private String thongtin;
    private String xuatxu;
    private ArrayList<String> doituongsudung;
    private String hansudung;
    private ArrayList<Double> giaban;

    private Boolean tinhtrang;

    public medicine_DTO() {
    }

    public medicine_DTO(String mathuoc, String maton, String tenthuoc, String danhmuc, ArrayList<String> donvi,
            String thanhphan, String thongtin, String xuatxu, ArrayList<String> doituongsudung, String hansudung,
            ArrayList<Double> giaban, Boolean tinhtrang) {
        this.mathuoc = mathuoc;
        this.maton = maton;
        this.tenthuoc = tenthuoc;
        this.danhmuc = danhmuc;
        this.donvi = donvi;
        this.thanhphan = thanhphan;
        this.thongtin = thongtin;
        this.xuatxu = xuatxu;
        this.doituongsudung = doituongsudung;
        this.hansudung = hansudung;
        this.giaban = giaban;
        this.tinhtrang = tinhtrang;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public String getMaton() {
        return maton;
    }

    public void setMaton(String maton) {
        this.maton = maton;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getThanhphan() {
        return thanhphan;
    }

    public void setThanhphan(String thanhphan) {
        this.thanhphan = thanhphan;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public ArrayList<String> getDonvi() {
        return donvi;
    }

    public void setDonvi(ArrayList<String> donvi) {
        this.donvi = donvi;
    }

    public ArrayList<String> getDoituongsudung() {
        return doituongsudung;
    }

    public void setDoituongsudung(ArrayList<String> doituongsudung) {
        this.doituongsudung = doituongsudung;
    }

    public ArrayList<Double> getGiaban() {
        return giaban;
    }

    public void setGiaban(ArrayList<Double> giaban) {
        this.giaban = giaban;
    }

    public String getHansudung() {
        return hansudung;
    }

    public void setHansudung(String hansudung) {
        this.hansudung = hansudung;
    }

}
