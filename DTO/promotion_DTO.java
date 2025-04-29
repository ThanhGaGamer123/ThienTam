package DTO;

public class promotion_DTO {
    private String makm;
    private String tenkm;

    private String ngaybatdau;
    private String ngayketthuc;
    private String noidung;

    private int giam;
    private int diem;
    private Boolean tinhtrang;
    
    public promotion_DTO() {
    }

    public promotion_DTO(String makm, String tenkm, String ngaybatdau, String ngayketthuc, String noidung, int giam,
            int diem, Boolean tinhtrang) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.noidung = noidung;
        this.giam = giam;
        this.diem = diem;
        this.tinhtrang = tinhtrang;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getGiam() {
        return giam;
    }

    public void setGiam(int giam) {
        this.giam = giam;
    }

    
}
