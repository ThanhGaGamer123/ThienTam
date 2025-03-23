package promotion_details;

public class promotion_details {
    private String mactkm;
    private String madon;
    private String makm;

    private String ngaybatdau;
    private String ngayketthuc;
    private String noidung;
    
    public promotion_details() {
    }

    public promotion_details(String mactkm, String madon, String makm, String ngaybatdau, String ngayketthuc,
            String noidung) {
        this.mactkm = mactkm;
        this.madon = madon;
        this.makm = makm;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.noidung = noidung;
    }

    public String getMactkm() {
        return mactkm;
    }

    public void setMactkm(String mactkm) {
        this.mactkm = mactkm;
    }

    public String getMadon() {
        return madon;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
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
