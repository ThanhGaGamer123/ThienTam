package medicine;

public class medicine {
    private String mathuoc;
    private String maton;
    private String tenthuoc;

    private String donvi;
    private String thanhphan;
    private String thongtin;
    private String xuatxu;

    private String gianhap;
    private String giaban;
    
    public medicine() {
    }

    public medicine(String mathuoc, String maton, String tenthuoc, String donvi, String thanhphan, String thongtin,
            String xuatxu, String gianhap, String giaban) {
        this.mathuoc = mathuoc;
        this.maton = maton;
        this.tenthuoc = tenthuoc;
        this.donvi = donvi;
        this.thanhphan = thanhphan;
        this.thongtin = thongtin;
        this.xuatxu = xuatxu;
        this.gianhap = gianhap;
        this.giaban = giaban;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public String getMaton() {
        return maton;
    }

    public void setMaton(String maton) {
        this.maton = maton;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getThanhphan() {
        return thanhphan;
    }

    public void setThanhphan(String thanhphan) {
        this.thanhphan = thanhphan;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getGianhap() {
        return gianhap;
    }

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }
}
