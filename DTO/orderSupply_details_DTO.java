package DTO;

import java.util.ArrayList;

public class orderSupply_details_DTO {
    private String macthdnhap;
    private String mahdnhap;
    private String mathuoc;

    private ArrayList<Integer> slnhap;
    private ArrayList<Integer> slcon;
    private ArrayList<Double> gianhap;
    private double thanhtien;

    private Boolean tinhtrang;
    
    public orderSupply_details_DTO() {
    }

    public orderSupply_details_DTO(String macthdnhap, String mahdnhap, String mathuoc, ArrayList<Integer> slnhap,
            ArrayList<Integer> slcon, ArrayList<Double> gianhap, double thanhtien, Boolean tinhtrang) {
        this.macthdnhap = macthdnhap;
        this.mahdnhap = mahdnhap;
        this.mathuoc = mathuoc;
        this.slnhap = slnhap;
        this.slcon = slcon;
        this.gianhap = gianhap;
        this.thanhtien = thanhtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMacthdnhap() {
        return macthdnhap;
    }

    public void setMacthdnhap(String macthdnhap) {
        this.macthdnhap = macthdnhap;
    }

    public String getMahdnhap() {
        return mahdnhap;
    }

    public void setMahdnhap(String mahdnhap) {
        this.mahdnhap = mahdnhap;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public ArrayList<Integer> getSlnhap() {
        return slnhap;
    }

    public void setSlnhap(ArrayList<Integer> slnhap) {
        this.slnhap = slnhap;
    }

    public ArrayList<Integer> getSlcon() {
        return slcon;
    }

    public void setSlcon(ArrayList<Integer> slcon) {
        this.slcon = slcon;
    }

    public ArrayList<Double> getGianhap() {
        return gianhap;
    }

    public void setGianhap(ArrayList<Double> gianhap) {
        this.gianhap = gianhap;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    
}
