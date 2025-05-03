package DTO;

public class order_DTO {
    private String madon;
    private String makh;
    private String sdt_nguoidat;
    private String manv;

    private String diachicuthe;
    private String phuong;
    private String quan;
    private String tinh;
    
    private String ngaydat;
    private String pttt;
    private double tongtien;
    private String tinhtrang;

    private String ghichu;
    private String nguoinhan;
    private String sdt_nguoinhan;
    
    public order_DTO() {
    }

    public order_DTO(String madon, String makh, String sdt_nguoidat, String manv, String diachicuthe, String phuong,
            String quan, String tinh, String ngaydat, String pttt, double tongtien, String tinhtrang, String ghichu,
            String nguoinhan, String sdt_nguoinhan) {
        this.madon = madon;
        this.makh = makh;
        this.sdt_nguoidat = sdt_nguoidat;
        this.manv = manv;
        this.diachicuthe = diachicuthe;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.ngaydat = ngaydat;
        this.pttt = pttt;
        this.tongtien = tongtien;
        this.tinhtrang = tinhtrang;
        this.ghichu = ghichu;
        this.nguoinhan = nguoinhan;
        this.sdt_nguoinhan = sdt_nguoinhan;
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

    public String getSdt_nguoidat() {
        return sdt_nguoidat;
    }

    public void setSdt_nguoidat(String sdt_nguoidat) {
        this.sdt_nguoidat = sdt_nguoidat;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getDiachicuthe() {
        return diachicuthe;
    }

    public void setDiachicuthe(String diachicuthe) {
        this.diachicuthe = diachicuthe;
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

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getNguoinhan() {
        return nguoinhan;
    }

    public void setNguoinhan(String nguoinhan) {
        this.nguoinhan = nguoinhan;
    }

    public String getSdt_nguoinhan() {
        return sdt_nguoinhan;
    }

    public void setSdt_nguoinhan(String sdt_nguoinhan) {
        this.sdt_nguoinhan = sdt_nguoinhan;
    }

    

    
}
