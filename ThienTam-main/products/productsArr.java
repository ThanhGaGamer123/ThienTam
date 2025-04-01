package products;

import java.sql.*;
import java.util.ArrayList;

public class productsArr {
    private ArrayList<product> sp;

    public productsArr() {
        this.sp = new ArrayList<>();
    }

    public ArrayList<product> getSp() {
        return sp;
    }

    public void setSp(ArrayList<product> sp) {
        this.sp = sp;
    }

    // Hàm kết nối SQL Server và lấy dữ liệu từ bảng Thuoc

    public void readDatabase() {
        try {
            // Nạp driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password);
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Thuoc")) {

                System.out.println("Kết nối SQL Server thành công!");

                sp.clear(); // Xóa danh sách cũ trước khi tải mới

                // Đọc dữ liệu từ ResultSet và thêm vào danh sách
                while (rs.next()) {
                    product thuoc = new product(
                            rs.getString("MaThuoc"),
                            rs.getString("TenThuoc"),
                            rs.getString("DonVi"),
                            rs.getString("ThanhPhan"),
                            rs.getString("TTinThuoc"), 
                            rs.getFloat("GiaBan"),
                            rs.getFloat("GiaNhap"),
                            rs.getString("XuatXu"),
                            rs.getString("MaTon"),
                            rs.getString("DoiTuongSD"));

                    sp.add(thuoc);
                }

                System.out.println("Dữ liệu đã tải từ bảng Thuoc.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc SQL: " + e.getMessage());
        }
    }

    // Hàm in danh sách sản phẩm
    public void printProducts() {
        if (sp.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (product p : sp) {
            System.out.println(p); // toString() trong product sẽ giúp in gọn
        }
    }

    // Tìm kiếm thuốc theo tên
    public ArrayList<product> findName(String timkiem) {
        ArrayList<product> result = new ArrayList<>();
        for (product p : sp) {
            if (p.getTenThuoc().toLowerCase().contains(timkiem.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public ArrayList<product> findDTuongSD(String s) {
        ArrayList<product> result = new ArrayList<>();
        for (product p : sp) {
            if (p.getDoiTuongSD().toLowerCase().contains(s.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    // Tìm theo xuất xứ
    public ArrayList<product> findXuatXu(String x) {
        ArrayList<product> result = new ArrayList<>();
        for (product p : sp) {
            if (p.getXuatXu().toLowerCase().contains(x.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    // Tìm theo chỉ định
    public ArrayList<product> findChiDinh(String c) {
        ArrayList<product> result = new ArrayList<>();
        for (product p : sp) {
            if (p.getThongTinThuoc().toLowerCase().contains(c.toLowerCase())) {
                result.add(p);
            }
        }
        return result;  
    }

}
