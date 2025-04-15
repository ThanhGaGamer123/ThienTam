package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cartDAO {

    public void xoaSanPhamTrongGio(String makh, String mathuoc) {
        try {
            // Nạp driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password);
                    PreparedStatement pst = con
                            .prepareStatement("DELETE FROM GioHang WHERE MaKH = ? AND MaThuoc = ?")) {

                pst.setString(1, makh);
                pst.setString(2, mathuoc);

                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Đã xoá sản phẩm " + mathuoc + " trong giỏ hàng của khách " + makh);
                } else {
                    System.out.println("Không tìm thấy sản phẩm để xoá.");
                }

            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi xoá sản phẩm khỏi giỏ: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc lỗi khác khi xoá giỏ hàng: " + e.getMessage());
        }
    }

    public void capNhatSoLuong(String makh, String mathuoc, int soluong) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "123";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn
                        .prepareStatement("UPDATE GioHang SET soluong = ? WHERE makh = ? AND mathuoc = ?")) {

            stmt.setInt(1, soluong);
            stmt.setString(2, makh);
            stmt.setString(3, mathuoc);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Đã cập nhật số lượng thành công.");
            } else {
                System.out.println("Không tìm thấy sản phẩm để cập nhật.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
