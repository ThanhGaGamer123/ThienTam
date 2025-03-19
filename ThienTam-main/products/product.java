package products;

public class product {
    private String mathuoc;
    private String tenthuoc;
    private String donvi;
    private String thanhphan;
    private String thongtinsp;
    private float giaban;
    private float gianhap;
    private String xuatxu;
    private String mahangton;

    public product() {
    }

    public product(String mathuoc, String tenthuoc, String donvi, String thanhphan, String thongtinsp, float giaban,
            float gianhap, String xuatxu, String mahangton) {
        this.mathuoc = mathuoc;
        this.tenthuoc = tenthuoc;
        this.donvi = donvi;
        this.thanhphan = thanhphan;
        this.thongtinsp = thongtinsp;
        this.giaban = giaban;
        this.gianhap = gianhap;
        this.xuatxu = xuatxu;
        this.mahangton = mahangton;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
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

    public String getThongtinsp() {
        return thongtinsp;
    }

    public void setThongtinsp(String thongtinsp) {
        this.thongtinsp = thongtinsp;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getMahangton() {
        return mahangton;
    }

    public void setMahangton(String mahangton) {
        this.mahangton = mahangton;
    }
}
