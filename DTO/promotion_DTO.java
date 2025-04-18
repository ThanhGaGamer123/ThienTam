package DTO;

public class promotion_DTO {
    private String makm;
    private String tenkm;

    private String ngaybatdau;
    private String ngayketthuc;
    private String noidung;

    private int diem;
    
    public promotion_DTO() {
    }

    public promotion_DTO(String makm, String tenkm, String ngaybatdau, String ngayketthuc, String noidung, int diem) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.noidung = noidung;
        this.diem = diem;
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
}
