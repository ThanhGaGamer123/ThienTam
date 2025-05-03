package DTO;

public class order_details_DTO {
    private String mactdh;
    private String madon;
    private String macthdnhap;

    private int sl;
    private String donvi;
    private double dongia;
    private double thanhtien;

    private Boolean tinhtrang;

    public order_details_DTO() {
    }

    public order_details_DTO(String mactdh, String madon, String macthdnhap, int sl, String donvi, double dongia,
            double thanhtien, Boolean tinhtrang) {
        this.mactdh = mactdh;
        this.madon = madon;
        this.macthdnhap = macthdnhap;
        this.sl = sl;
        this.donvi = donvi;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMactdh() {
        return mactdh;
    }

    public String getMadon() {
        return madon;
    }

    public String getMacthdnhap() {
        return macthdnhap;
    }

    public int getSl() {
        return sl;
    }

    public String getDonvi() {
        return donvi;
    }

    public double getDongia() {
        return dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setMactdh(String mactdh) {
        this.mactdh = mactdh;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public void setMacthdnhap(String macthdnhap) {
        this.macthdnhap = macthdnhap;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

}