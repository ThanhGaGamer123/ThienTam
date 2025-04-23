package order;

import java.util.ArrayList;

public class order {
    private String madon;
    private String makh;
    private int sdt; // *
    private String manv;

    private String tennguoinhan; // *
    private String sdtnguoinhan; // *

    private String phuong;
    private String quan;
    private String tinh;

    private String diachicuthe; // *

    private ArrayList<String> sanphammua;

    private String ngaydat;
    private String ghichu; // *

    private String pttt;
    private int tongtien;
    private String tinhtrang;

    public order() {
    }

    public order(String madon, String makh, int sdt, String manv, String tennguoinhan, String sdtnguoinhan,
            String phuong, String quan, String tinh, String diachicuthe, ArrayList<String> sanphammua, String ngaydat,
            String ghichu, String pttt, int tongtien, String tinhtrang) {
        this.madon = madon;
        this.makh = makh;
        this.sdt = sdt;
        this.manv = manv;
        this.tennguoinhan = tennguoinhan;
        this.sdtnguoinhan = sdtnguoinhan;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.diachicuthe = diachicuthe;
        this.sanphammua = sanphammua;
        this.ngaydat = ngaydat;
        this.ghichu = ghichu;
        this.pttt = pttt;
        this.tongtien = tongtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMadon() {
        return madon;
    }

    public String getMakh() {
        return makh;
    }

    public String getManv() {
        return manv;
    }

    public String getTennguoinhan() {
        return tennguoinhan;
    }

    public String getSdtnguoinhan() {
        return sdtnguoinhan;
    }

    public String getPhuong() {
        return phuong;
    }

    public String getQuan() {
        return quan;
    }

    public String getTinh() {
        return tinh;
    }

    public String getDiachicuthe() {
        return diachicuthe;
    }

    public ArrayList<String> getSanphammua() {
        return sanphammua;
    }

    public void setSanphammua(ArrayList<String> sanphammua) {
        this.sanphammua = sanphammua;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public String getPttt() {
        return pttt;
    }

    public int getTongtien() {
        return tongtien;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setTennguoinhan(String tennguoinhan) {
        this.tennguoinhan = tennguoinhan;
    }

    public void setSdtnguoinhan(String sdtnguoinhan) {
        this.sdtnguoinhan = sdtnguoinhan;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public void setDiachicuthe(String diachicuthe) {
        this.diachicuthe = diachicuthe;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setPttt(String pttt) {
        this.pttt = pttt;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

}
