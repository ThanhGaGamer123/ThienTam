package order_details;

import java.util.ArrayList;

public class order_details {
    private String mactdh; // mã chi tiết hóa đơn
    private String madon;
    private String macthdnhap; // mã hóa đơn nhập hàng

    private ArrayList<String> sanphammua; // thông tin tất cả sản phẩm đơn đó mua
    private String diachicuthe;
    private int sl;
    // private int dongia;
    private int thanhtien; // don gia * sl

    private String ngaydat;

    public order_details() {
    }

    public order_details(String mactdh, String madon, String macthdnhap, ArrayList<String> sanphammua,
            String diachicuthe, int sl, int thanhtien, String ngaydat) {
        this.mactdh = mactdh;
        this.madon = madon;
        this.macthdnhap = macthdnhap;
        this.sanphammua = sanphammua;
        this.diachicuthe = diachicuthe;
        this.sl = sl;
        this.thanhtien = thanhtien;
        this.ngaydat = ngaydat;
    }

    public String getMactdh() {
        return mactdh;
    }

    public String getMadon() {
        return madon;
    }

    public String getMacthdnhap() {
        return macthdnhap;
    }

    public ArrayList<String> getSanphammua() {
        return sanphammua;
    }

    public String getDiachicuthe() {
        return diachicuthe;
    }

    public int getSl() {
        return sl;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setMactdh(String mactdh) {
        this.mactdh = mactdh;
    }

    public void setMadon(String madon) {
        this.madon = madon;
    }

    public void setMacthdnhap(String macthdnhap) {
        this.macthdnhap = macthdnhap;
    }

    public void setSanphammua(ArrayList<String> sanphammua) {
        this.sanphammua = sanphammua;
    }

    public void setDiachicuthe(String diachicuthe) {
        this.diachicuthe = diachicuthe;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

}
