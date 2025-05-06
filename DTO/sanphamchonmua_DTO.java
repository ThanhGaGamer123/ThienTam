
package DTO;

public class sanphamchonmua_DTO {

    private String mathuoc;
    private String magio;
    private String tenthuoc;
    private int soLuong;
    private String donvi;
    private int donGia;

    public sanphamchonmua_DTO() {
    }

    public sanphamchonmua_DTO(String mathuoc, String magio, String tenthuoc, int soLuong, String donvi, int donGia) {
        this.mathuoc = mathuoc;
        this.magio = magio;
        this.tenthuoc = tenthuoc;
        this.soLuong = soLuong;
        this.donvi = donvi;
        this.donGia = donGia;
    }

    public String getMagio() {
        return magio;
    }

    public void setMagio(String magio) {
        this.magio = magio;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getDonvi() {
        return donvi;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

}
