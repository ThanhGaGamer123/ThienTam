package products;

public class product {
    private String maThuoc;
    private String tenThuoc;
    private String donVi;
    private String thanhPhan;
    private String thongTinThuoc;
    private float giaBan;
    private float giaNhap;
    private String xuatXu;
    private String maTon;
    private String doiTuongSD;

    public product() {
    }

    public product(String maThuoc, String tenThuoc, String donVi, String thanhPhan, String thongTinThuoc,
            float giaBan, float giaNhap, String xuatXu, String maTon, String doiTuongSD) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donVi = donVi;
        this.thanhPhan = thanhPhan;
        this.thongTinThuoc = thongTinThuoc;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.xuatXu = xuatXu;
        this.maTon = maTon;
        this.doiTuongSD = doiTuongSD;
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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public String getThongTinThuoc() {
        return thongTinThuoc;
    }

    public void setThongTinThuoc(String thongTinThuoc) {
        this.thongTinThuoc = thongTinThuoc;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMaTon() {
        return maTon;
    }

    public void setMaTon(String maTon) {
        this.maTon = maTon;
    }

    public String getDoiTuongSD() {
        return doiTuongSD;
    }

    public void setDoiTuongSD(String doiTuongSD) {
        this.doiTuongSD = doiTuongSD;
    }

    @Override
    public String toString() {
        return "product{" +
                "maThuoc='" + maThuoc + '\'' +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", donVi='" + donVi + '\'' +
                ", thanhPhan='" + thanhPhan + '\'' +
                ", thongTinThuoc='" + thongTinThuoc + '\'' +
                ", giaBan=" + giaBan +
                ", giaNhap=" + giaNhap +
                ", xuatXu='" + xuatXu + '\'' +
                ", maTon='" + maTon + '\'' +
                ", doiTuongSD='" + doiTuongSD + '\'' +
                '}';
    }
}
