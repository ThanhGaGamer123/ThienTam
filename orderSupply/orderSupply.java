package orderSupply;

public class orderSupply {
    private String mahdnhap;
    private String mancc;

    private String soloaithuoc;
    private String ngaynhap;
    private String tongtien;
    
    public orderSupply() {
    }

    public orderSupply(String mahdnhap, String mancc, String soloaithuoc, String ngaynhap, String tongtien) {
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

    public String getSoloaithuoc() {
        return soloaithuoc;
    }

    public void setSoloaithuoc(String soloaithuoc) {
        this.soloaithuoc = soloaithuoc;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
}
