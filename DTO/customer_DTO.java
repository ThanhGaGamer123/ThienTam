package DTO;

public class customer_DTO {
    private String makh;
    private String tenkh;

    private int sdt;
    private String masonha;
    private String duong;
    private String phuong;
    private String quan;
    private String tinh;
    
    private String email;
    private String password;

    private int diemKM;
    private Boolean tinhtrang;

    public customer_DTO() {
    }

    public customer_DTO(String makh, String tenkh, int sdt, String masonha, String duong, String phuong, String quan,
            String tinh, String email, String password, int diemKM,
            Boolean tinhtrang) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.masonha = masonha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.email = email;
        this.password = password;
        this.diemKM = diemKM;
        this.tinhtrang = tinhtrang;
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

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getMasonha() {
        return masonha;
    }

    public void setMasonha(String masonha) {
        this.masonha = masonha;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDiemKM() {
        return diemKM;
    }

    public void setDiemKM(int diemKM) {
        this.diemKM = diemKM;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    
}
