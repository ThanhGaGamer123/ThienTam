package customer;

import java.sql.*;
import java.util.ArrayList;

public class customerArr {
    private ArrayList<customer> a;

    public customerArr() {
        this.a = new ArrayList<>();
    }

    public ArrayList<customer> getA() {
        return a;
    }

    public void setA(ArrayList<customer> a) {
        this.a = a;
    }

    public void readDatabase() {
        try {
            // Kết nối SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            // Tạo kết nối
            try (Connection con = DriverManager.getConnection(url, username, password);
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM KhachHang")) {

                a.clear();

                // Đọc dữ liệu từ ResultSet
                while (rs.next()) {
                    // Khởi tạo đối tượng customer với dữ liệu từ SQL
                    customer kh = new customer(
                            rs.getString("makh"), // Mã khách hàng
                            rs.getString("tenkh"), // Tên khách hàng
                            Integer.parseInt(rs.getString("sdt")), // Số điện thoại (chuyển từ String sang int)
                            rs.getString("masonha"), // Mã số nhà
                            rs.getString("duong"), // Đường
                            rs.getString("phuong"), // Phường
                            rs.getString("quan"), // Quận
                            rs.getString("tinh"), // Tỉnh
                            rs.getString("email"), // Email
                            rs.getString("passwordkh"), // Mật khẩu
                            new ArrayList<>(), // Giỏ hàng tạm thời
                            rs.getInt("diemkm") // Điểm khách hàng
                    );
                    a.add(kh); // Thêm khách hàng vào danh sách
                }

                System.out.println("Dữ liệu đã được tải từ database.");
            } catch (SQLException ex) {
                System.out.println("Lỗi kết nối hoặc truy vấn SQL: " + ex.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi tải driver: " + e.getMessage());
        }
    }

    public void printCustomers() {
        if (a.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        System.out.println("Danh sách khách hàng:");
        for (customer kh : a) {
            // In thông tin khách hàng
            System.out.println("Mã KH: " + kh.getMakh() +
                    ", Tên: " + kh.getTenkh() +
                    ", SĐT: " + kh.getSdt() +
                    ", Email: " + kh.getEmail() +
                    ", Địa chỉ: " + kh.getMasonha() + ", " + kh.getDuong() + ", " + kh.getPhuong() + ", " + kh.getQuan()
                    + ", " + kh.getTinh() +
                    ", Điểm KM: " + kh.getDiemKM() +
                    ", Mật khẩu: [ĐÃ ẨN]");
        }
    }
}
