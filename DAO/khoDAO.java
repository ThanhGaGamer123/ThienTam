
package DAO;

import data.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class khoDAO {

    public static String layMaTonKho(String mathuoc) {
        String sql = "SELECT maton FROM Thuoc WHERE mathuoc = ?";
        try (Connection conn = MyConnection.createConnection()) {
            if (conn == null) {
                System.err.println("Không thể kết nối SQL Server, hãy kiểm tra thông tin kết nối.");
                return null;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, mathuoc);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("maton");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi truy vấn maton: " + e.getMessage());
        }
        return null;
    }

    public static boolean truSoLuong(String maton, int soLuongMua, String donvi) {
        String sql = "UPDATE Kho SET slton = ? WHERE maton = ?";
        try (Connection conn = MyConnection.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            String currentSlton = laySoLuongTon(maton);
            if (currentSlton == null) {
                return false;
            }

            String[] sltonArray = currentSlton.split(";");

            int loai;
            switch (donvi) {
                case "hộp":
                    loai = 0;
                    break;
                case "vỉ":
                    loai = 1;
                    break;
                case "viên":
                    loai = 2;
                    break;
                default:
                    System.err.println("Đơn vị không hợp lệ.");
                    return false;
            }

            // Cập nhật số lượng tồn kho
            int currentSltonValue = Integer.parseInt(sltonArray[loai]);
            currentSltonValue -= soLuongMua;
            if (currentSltonValue < 0) {
                System.err.println("Không đủ hàng tồn kho.");
                return false; // Không đủ hàng
            }

            sltonArray[loai] = String.valueOf(currentSltonValue);
            String newSlton = String.join(";", sltonArray);

            // Cập nhật vào cơ sở dữ liệu
            stmt.setString(1, newSlton);
            stmt.setString(2, maton);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật kho: " + e.getMessage());
            return false;
        }
    }

    public static String laySoLuongTon(String maton) {
        String sql = "SELECT slton FROM Kho WHERE maton = ?";
        try (Connection conn = MyConnection.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maton);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("slton");
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy số lượng tồn kho: " + e.getMessage());
        }
        return null;
    }

}
