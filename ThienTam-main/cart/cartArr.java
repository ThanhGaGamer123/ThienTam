package cart;

import java.sql.*;
import java.util.ArrayList;

public class cartArr {

    public cartArr() {
    }

    private static ArrayList<cart> a = new ArrayList<>();

    public static ArrayList<cart> getA() {
        return a;
    }

    public void setA(ArrayList<cart> c) {
        a = c;
    }

    public void readCartDatabase(ArrayList<cart> cartList, String makh) {
        try {
            // Nạp driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password);
                    PreparedStatement pst = con.prepareStatement("SELECT * FROM GioHang WHERE MaKH = ?")) {

                pst.setString(1, makh); // truyền mã khách hàng vào truy vấn

                ResultSet rs = pst.executeQuery();

                System.out.println("Kết nối SQL Server thành công với bảng GioHang!");

                cartList.clear(); // Xóa giỏ hàng cũ

                while (rs.next()) {
                    cart c = new cart(
                            rs.getString("MaKH"),
                            rs.getString("MaThuoc"),
                            rs.getInt("SoLuong"),
                            rs.getInt("ThanhTien"),
                            rs.getInt("DonGia"));
                    cartList.add(c);
                }

                System.out.println("Đã tải giỏ hàng cho khách hàng: " + makh);

            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi đọc giỏ hàng: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc lỗi khác khi đọc giỏ hàng: " + e.getMessage());
        }
    }

    public void updateCartDatabase(ArrayList<cart> cartList) {
        try {
            // Nạp driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password)) {
                System.out.println("Kết nối SQL Server thành công để cập nhật giỏ hàng!");

                // Bước 1: Xoá toàn bộ giỏ hàng cũ (nếu bạn muốn chỉ lưu 1 giỏ duy nhất)
                String deleteQuery = "DELETE FROM GioHang WHERE MaKH = ?";
                try (PreparedStatement deleteStmt = con.prepareStatement(deleteQuery)) {
                    if (!cartList.isEmpty()) {
                        deleteStmt.setString(1, cartList.get(0).getMakh());
                        deleteStmt.executeUpdate();
                    }
                }

                // Bước 2: Chèn lại từng cart trong danh sách
                String insertQuery = "INSERT INTO GioHang (MaKH, MaThuoc, SoLuong, ThanhTien, DonGia) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
                    for (cart c : cartList) {

                        insertStmt.setString(1, c.getMakh());
                        insertStmt.setString(2, c.getMathuoc());
                        insertStmt.setInt(3, c.getSl());
                        insertStmt.setInt(4, c.getThanhtien());
                        insertStmt.setInt(5, c.getDongia());

                        insertStmt.addBatch(); // Tối ưu hiệu năng
                    }

                    insertStmt.executeBatch(); // Chạy batch insert
                }

                System.out.println("Đã cập nhật giỏ hàng thành công!");

            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi cập nhật giỏ hàng: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc lỗi khác khi cập nhật giỏ hàng: " + e.getMessage());
        }
    }

}
