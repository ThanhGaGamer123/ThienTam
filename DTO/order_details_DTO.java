package DTO;

public class order_details_DTO {
    private String mactdh;
    private String madon;
    private String macthdnhap;

    private int sl;
    private double dongia;
    private double thanhtien; //don gia * sl

    private Boolean tinhtrang;
    
    public order_details_DTO() {
    }

    public order_details_DTO(String mactdh, String madon, String macthdnhap, int sl, double dongia, double thanhtien,
            Boolean tinhtrang) {
        this.mactdh = mactdh;
        this.madon = madon;
        this.macthdnhap = macthdnhap;
        this.sl = sl;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMactdh() {
        return mactdh;
    }

    public void setMactdh(String mactdh) {
        this.mactdh = mactdh;
    }

    public String getMadon() {
        return madon;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public String getMacthdnhap() {
        return macthdnhap;
    }

    public void setMacthdnhap(String macthdnhap) {
        this.macthdnhap = macthdnhap;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
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
