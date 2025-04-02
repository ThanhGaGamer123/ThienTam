package orderSupply;

public class orderSupply {
    private String mahdnhap;
    private String mancc;

    private int soloaithuoc;
    private String ngaynhap;
    private int tongtien;
    
    public orderSupply() {
    }

    public orderSupply(String mahdnhap, String mancc, int soloaithuoc, String ngaynhap, int tongtien) {
        this.mahdnhap = mahdnhap;
        this.mancc = mancc;
        this.soloaithuoc = soloaithuoc;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
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

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}
