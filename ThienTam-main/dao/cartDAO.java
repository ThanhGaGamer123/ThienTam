package DAO;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cartDAO {



    public static void xoaSanPhamTrongGio(String makh, String mathuoc) {
        try (Connection con = MyConnection.createConnection()) {
            String sql = "DELETE FROM GioHang WHERE MaKH = ? AND MaThuoc = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
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
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void capNhatSoLuong(String makh, String mathuoc, int soluong) {
        try (Connection con = MyConnection.createConnection()) {
            String sql = "UPDATE GioHang SET soluong = ? WHERE MaKH = ? AND MaThuoc = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, soluong);
                ps.setString(2, makh);
                ps.setString(3, mathuoc);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Đã cập nhật số lượng thành công.");
                } else {
                    System.out.println("Không tìm thấy sản phẩm để cập nhật.");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi cập nhật số lượng: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
