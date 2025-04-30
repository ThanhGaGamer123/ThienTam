package DTO;

public class cart_DTO {
    private String makh;
    private String mathuoc;
    private int sl;
    private double thanhtien;
    private double dongia;
    
    public cart_DTO(String makh, String mathuoc, int sl, double thanhtien, double dongia) {
        this.makh = makh;
        this.mathuoc = mathuoc;
        this.sl = sl;
        this.thanhtien = thanhtien;
        this.dongia = dongia;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    
}
