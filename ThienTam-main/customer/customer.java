package customer;

public class customer {
    private String makh;
    private String tenkh;
    private int sdtkh;
    private String email;
    private String soNhakhach;
    private String phuongkh;
    private String quankh;
    private String tinhkh;
    private int diemkm;
    private String password;

    public customer() {
    }

    public customer(String makh, String tenkh, int sdtkh, String email, String soNhakhach, String phuongkh,
            String quankh, String tinhkh, int diemkm, String password) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdtkh = sdtkh;
        this.email = email;
        this.soNhakhach = soNhakhach;
        this.phuongkh = phuongkh;
        this.quankh = quankh;
        this.tinhkh = tinhkh;
        this.diemkm = diemkm;
        this.password = password;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(int sdtkh) {
        this.sdtkh = sdtkh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoNhakhach() {
        return soNhakhach;
    }

    public void setSoNhakhach(String soNhakhach) {
        this.soNhakhach = soNhakhach;
    }

    public String getPhuongkh() {
        return phuongkh;
    }

    public void setPhuongkh(String phuongkh) {
        this.phuongkh = phuongkh;
    }

    public String getQuankh() {
        return quankh;
    }

    public void setQuankh(String quankh) {
        this.quankh = quankh;
    }

    public String getTinhkh() {
        return tinhkh;
    }

    public void setTinhkh(String tinhkh) {
        this.tinhkh = tinhkh;
    }

    public int getDiemkm() {
        return diemkm;
    }

    public void setDiemkm(int diemkm) {
        this.diemkm = diemkm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
