package cart;

public class cart {

    private String makh;
    private String mathuoc;
    private int sl;
    private int thanhtien;
    private int dongia;

    public cart(String makh, String mathuoc, int sl, int thanhtien, int dongia) {

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

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

}
