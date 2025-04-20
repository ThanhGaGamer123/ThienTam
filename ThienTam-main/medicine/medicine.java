package medicine;

import java.util.ArrayList;

public class medicine {
    private String mathuoc;
    private String maton;
    private String tenthuoc;

    private String danhmuc;
    private ArrayList<String> donvi;
    private String thanhphan;
    private String thongtin;
    private String xuatxu;
    private ArrayList<String> doituongsudung;
    private ArrayList<Integer> giaban;

    private Boolean tinhtrang;

    public medicine() {
    }

    public medicine(String mathuoc, String maton, String tenthuoc, String danhmuc, ArrayList<String> donvi,
            String thanhphan, String thongtin, String xuatxu, ArrayList<String> doituongsudung,
            ArrayList<Integer> giaban, Boolean tinhtrang) {
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
        this.tinhtrang = tinhtrang;
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

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public ArrayList<String> getDonvi() {
        return donvi;
    }

    public void setDonvi(ArrayList<String> donvi) {
        this.donvi = donvi;
    }

    public ArrayList<String> getDoituongsudung() {
        return doituongsudung;
    }

    public void setDoituongsudung(ArrayList<String> doituongsudung) {
        this.doituongsudung = doituongsudung;
    }

    public ArrayList<Integer> getGiaban() {
        return giaban;
    }

    public void setGiaban(ArrayList<Integer> giaban) {
        this.giaban = giaban;
    }



}
