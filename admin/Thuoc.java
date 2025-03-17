public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private int giaBan;
    private int giaNhap;

    public Thuoc(String maThuoc, String tenThuoc, int giaBan, int giaNhap) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

}
