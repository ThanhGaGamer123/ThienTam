package customer;

public class customer {
    private String makh, tenkh, sdtkh, email, soNhakhach, duongkh, phuongkh, quankh, tinhkh, passwordkh;
    private int diemkm;




    public customer() {
    }

    public customer(String makh, String tenkh, String sdtkh, String email, String soNhakhach, String duongkh,
            String phuongkh, String quankh, String tinhkh, int diemkm, String passwordkh) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdtkh = sdtkh;
        this.email = email;
        this.soNhakhach = soNhakhach;
        this.duongkh = duongkh;
        this.phuongkh = phuongkh;
        this.quankh = quankh;
        this.tinhkh = tinhkh;
        this.diemkm = diemkm;
        this.passwordkh = passwordkh;
    }

    public String getMakh() {
        return makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public String getEmail() {
        return email;
    }

    public String getSoNhakhach() {
        return soNhakhach;
    }

    public String getDuongkh() {
        return duongkh;
    }

    public String getPhuongkh() {
        return phuongkh;
    }

    public String getQuankh() {
        return quankh;
    }

    public String getTinhkh() {
        return tinhkh;
    }

    public int getDiemkm() {
        return diemkm;
    }

    public String getPasswordkh() {
        return passwordkh;
    }

    @Override
    public String toString() {
        return "Mã KH: " + makh +
                ", Tên: " + tenkh +
                ", SDT: " + sdtkh +
                ", Email: " + email +
                ", Địa chỉ: " + soNhakhach + ", " + duongkh + ", " + phuongkh + ", " + quankh + ", " + tinhkh +
                ", Điểm KM: " + diemkm;
    }

}
