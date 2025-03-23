package promotion;

public class promotion {
    private String makm;
    private String tenkm;

    private String ngaybatdau;
    private String ngayketthuc;
    private String noidung;
    
    public promotion() {
    }

    public promotion(String makm, String tenkm, String ngaybatdau, String ngayketthuc, String noidung) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.noidung = noidung;
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
}
