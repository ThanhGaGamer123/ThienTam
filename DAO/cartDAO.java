package DAO;

import DTO.cart_DTO;
import data.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cartDAO {

    public ArrayList<cart_DTO> readCartDatabase(String makh) {
        ArrayList<cart_DTO> cartList = new ArrayList<>();

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM GioHang WHERE MaKH = ?")) {

            pst.setString(1, makh);
            ResultSet rs = pst.executeQuery();

            System.out.println("Kết nối SQL Server thành công với bảng GioHang!");

            while (rs.next()) {
                cart_DTO c = new cart_DTO(
                        rs.getString("MaKH"),
                        rs.getString("MaThuoc"),
                        rs.getInt("SoLuong"),
                        rs.getInt("ThanhTien"),
                        rs.getInt("DonGia"));
                cartList.add(c);
            }

            System.out.println("Đã tải giỏ hàng cho khách hàng: " + makh);

        } catch (Exception e) {
            System.out.println("Lỗi khi đọc giỏ hàng: " + e.getMessage());
            e.printStackTrace();
        }

        return cartList;
    }

    public void xoaSanPhamTrongGio(String makh, String mathuoc) {
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

    public void capNhatSoLuong(String makh, String mathuoc, int soluong) {
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

    public void updateCart(ArrayList<cart_DTO> cartList) {
        try (Connection con = MyConnection.createConnection()) {
            if (con == null) {
                System.out.println("Không thể kết nối đến SQL Server.");
                return;
            }

            System.out.println("Kết nối SQL Server thành công để cập nhật giỏ hàng!");

            // Bước 1: Xoá toàn bộ giỏ hàng cũ cho khách hàng (chỉ nếu cartList không rỗng)
            String deleteQuery = "DELETE FROM GioHang WHERE MaKH = ?";
            try (PreparedStatement deleteStmt = con.prepareStatement(deleteQuery)) {
                if (!cartList.isEmpty()) {
                    deleteStmt.setString(1, cartList.get(0).getMakh());
                    deleteStmt.executeUpdate();
                }
            }

            // Bước 2: Chèn lại các mục trong giỏ hàng
            String insertQuery = "INSERT INTO GioHang (MaKH, MaThuoc, SoLuong, ThanhTien, DonGia) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
                for (cart_DTO c : cartList) {
                    insertStmt.setString(1, c.getMakh());
                    insertStmt.setString(2, c.getMathuoc());
                    insertStmt.setInt(3, c.getSl());
                    insertStmt.setDouble(4, c.getThanhtien());
                    insertStmt.setDouble(5, c.getDongia());

                    insertStmt.addBatch(); // Thêm vào batch
                }

                insertStmt.executeBatch(); // Thực thi tất cả câu lệnh
            }

            System.out.println("Đã cập nhật giỏ hàng thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật giỏ hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
