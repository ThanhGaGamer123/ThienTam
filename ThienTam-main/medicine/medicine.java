package medicine;

public class medicine {
    private String mathuoc;
    private String maton;
    private String tenthuoc;

    private String danhmuc;
    private String[] donvi;
    private String thanhphan;
    private String thongtin;
    private String xuatxu;
    private String[] doituongsudung;
    private int[] giaban;

    public medicine() {
    }

    public medicine(String mathuoc, String maton, String tenthuoc, String danhmuc, String[] donvi, String thanhphan,
            String thongtin, String xuatxu, String[] doituongsudung, int[] giaban) {
        this.mathuoc = mathuoc;
        this.maton = maton;
        this.tenthuoc = tenthuoc;
        this.danhmuc = danhmuc;
        this.donvi = donvi;
        this.thanhphan = thanhphan;
        this.thongtin = thongtin;
        this.xuatxu = xuatxu;
        this.doituongsudung = doituongsudung;
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

    public String[] getDoituongsudung() {
        return doituongsudung;
    }

    public void setDoituongsudung(String[] doituongsudung) {
        this.doituongsudung = doituongsudung;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String[] getDonvi() {
        return donvi;
    }

    public void setDonvi(String[] donvi) {
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

    public int[] getGiaban() {
        return giaban;
    }

    public void setGiaban(int[] giaban) {
        this.giaban = giaban;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }


}