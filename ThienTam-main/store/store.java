package store;

public class store {
    private String mant;
    private String masonha;
    private String duong;
    private String phuong;
    private String quan;
    private String tinh;
    private String manql;
    
    public store() {
    }

    public store(String mant, String masonha, String duong, String phuong, 
    String quan, String tinh, String manql) {
        this.mant = mant;
        this.masonha = masonha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.manql = manql;
    }

    public String getMant() {
        return mant;
    }

    public void setMant(String mant) {
        this.mant = mant;
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

    public String getManql() {
        return manql;
    }

    public void setManql(String manql) {
        this.manql = manql;
    }

    
}
