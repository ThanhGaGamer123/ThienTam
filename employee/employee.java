package employee;

public class employee {
    private String manv;
    private String tennv;
    private String chucvu;

    private String gioitinh;
    private String cccd;
    private String sdt;
    private String masonha;
    private String duong;
    private String phuong;
    private String quan;
    private String tinh;

    private String username;
    private String password;
    private String manhathuoc;

    private Boolean tinhtrang;

    public employee() {}

    public employee(String manv, String tennv, String chucvu, String gioitinh, String cccd, String sdt, String masonha,
            String duong, String phuong, String quan, String tinh, String username, String password, String manhathuoc,
            Boolean tinhtrang) {
        this.manv = manv;
        this.tennv = tennv;
        this.chucvu = chucvu;
        this.gioitinh = gioitinh;
        this.cccd = cccd;
        this.sdt = sdt;
        this.masonha = masonha;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.username = username;
        this.password = password;
        this.manhathuoc = manhathuoc;
        this.tinhtrang = tinhtrang;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getManhathuoc() {
        return manhathuoc;
    }

    public void setManhathuoc(String manhathuoc) {
        this.manhathuoc = manhathuoc;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    
}   
