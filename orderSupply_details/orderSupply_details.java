package orderSupply_details;

public class orderSupply_details {
    private String macthdnhap;
    private String mahdnhap;
    private String mathuoc;

    private int[] slnhap;
    private int[] gianhap;
    private int thanhtien;
    
    public orderSupply_details() {
    }

    public orderSupply_details(String macthdnhap, String mahdnhap, String mathuoc, int[] slnhap,
            int[] gianhap, int thanhtien) {
        this.macthdnhap = macthdnhap;
        this.mahdnhap = mahdnhap;
        this.mathuoc = mathuoc;
        this.slnhap = slnhap;
        this.gianhap = gianhap;
        this.thanhtien = thanhtien;
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

    public int[] getSlnhap() {
        return slnhap;
    }

    public void setSlnhap(int[] slnhap) {
        this.slnhap = slnhap;
    }


    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int[] getGianhap() {
        return gianhap;
    }

    public void setGianhap(int[] gianhap) {
        this.gianhap = gianhap;
    }
}
