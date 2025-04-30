package DTO;

public class orderSupply_DTO {
    private String mahdnhap;
    private String mancc;

    private int soloaithuoc;
    private String ngaynhap;
    private double tongtien;

    private Boolean tinhtrang;
    
    public orderSupply_DTO() {
    }

    public orderSupply_DTO(String mahdnhap, String mancc, int soloaithuoc, String ngaynhap, double tongtien,
            Boolean tinhtrang) {
        this.mahdnhap = mahdnhap;
        this.mancc = mancc;
        this.soloaithuoc = soloaithuoc;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMahdnhap() {
        return mahdnhap;
    }

    public void setMahdnhap(String mahdnhap) {
        this.mahdnhap = mahdnhap;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public int getSoloaithuoc() {
        return soloaithuoc;
    }

    public void setSoloaithuoc(int soloaithuoc) {
        this.soloaithuoc = soloaithuoc;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    
}
