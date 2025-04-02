package promotion_details;

public class promotion_details {
    private String mactkm;
    private String madon;
    private String makm;

    private String ngayapdung;
    
    public promotion_details() {
    }

    public promotion_details(String mactkm, String madon, String makm, String ngayapdung) {
        this.mactkm = mactkm;
        this.madon = madon;
        this.makm = makm;
        this.ngayapdung = ngayapdung;
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

    public String getNgayapdung() {
        return ngayapdung;
    }

    public void setNgayapdung(String ngayapdung) {
        this.ngayapdung = ngayapdung;
    }
}
