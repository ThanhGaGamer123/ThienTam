package order_details;

public class order_details {
    private String mactdh;
    private String madon;
    private String macthdnhap;

    private int sl;
    private int dongia;
    private int thanhtien; //don gia * sl
    
    public order_details() {
    }

    public order_details(String mactdh, String madon, String macthdnhap, int sl, int dongia, int thanhtien) {
        this.mactdh = mactdh;
        this.madon = madon;
        this.macthdnhap = macthdnhap;
        this.sl = sl;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
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

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
}
