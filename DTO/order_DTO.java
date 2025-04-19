package DTO;

public class order_DTO {
    private String madon;
    private String makh;
    private String manv;

    private String masonha;
    private String duong;
    private String phuong;
    private String quan;
    private String tinh;
    
    private String ngaydat;
    private String pttt;
    private int tongtien;
    private String tinhtrang;
    
    public order_DTO() {
    }

    public order_DTO(String madon, String makh, String manv, String masonha, String duong, String phuong, String quan,
            String tinh, String ngaydat, String pttt, int tongtien, String tinhtrang) {
        this.madon = madon;
        this.makh = makh;
        this.manv = manv;
        this.masonha = masonha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.ngaydat = ngaydat;
        this.pttt = pttt;
        this.tongtien = tongtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMadon() {
        return madon;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMasonha() {
        return masonha;
    }

    public void setMasonha(String masonha) {
        this.masonha = masonha;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getPttt() {
        return pttt;
    }

    public void setPttt(String pttt) {
        this.pttt = pttt;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
