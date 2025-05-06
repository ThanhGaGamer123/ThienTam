package DTO;

public class cart_DTO {
    private String magh; //
    private String makh;
    private String mathuoc;
    private String donvi; //
    private int sl;
    private double thanhtien;
    private double dongia;
    private String macthdnhap; //

    public cart_DTO() {
    }

    public cart_DTO(String magh, String makh, String mathuoc, String donvi, int sl, double thanhtien, double dongia,
            String macthdnhap) {
        this.magh = magh;
        this.makh = makh;
        this.mathuoc = mathuoc;
        this.donvi = donvi;
        this.sl = sl;
        this.thanhtien = thanhtien;
        this.dongia = dongia;
        this.macthdnhap = macthdnhap;
    }

    public String getMagh() {
        return magh;
    }

    public String getMakh() {
        return makh;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public String getDonvi() {
        return donvi;
    }

    public int getSl() {
        return sl;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public double getDongia() {
        return dongia;
    }

    public String getMacthdnhap() {
        return macthdnhap;
    }

    public void setMagh(String magh) {
        this.magh = magh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setMacthdnhap(String macthdnhap) {
        this.macthdnhap = macthdnhap;
    }

}
