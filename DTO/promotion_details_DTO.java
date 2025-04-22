package DTO;

public class promotion_details_DTO {
    private String mactkm;
    private String madon;
    private String makm;

    private String ngayapdung;
    private Boolean tinhtrang;
    
    public promotion_details_DTO() {
    }

    public promotion_details_DTO(String mactkm, String madon, String makm, String ngayapdung, Boolean tinhtrang) {
        this.mactkm = mactkm;
        this.madon = madon;
        this.makm = makm;
        this.ngayapdung = ngayapdung;
        this.tinhtrang = tinhtrang;
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

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }


}
