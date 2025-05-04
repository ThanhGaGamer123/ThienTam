package Arr_xt;

import DTO.cart_DTO;
import connection.MyConnection;
import java.sql.*;
import java.util.ArrayList;

public class cartArr {

    public cartArr() {
    }

    private static ArrayList<cart_DTO> a = new ArrayList<>();

    public static ArrayList<cart_DTO> getA() {
        return a;
    }

    public void setA(ArrayList<cart_DTO> c) {
        a = c;
    }

    public void readCartDatabase(String makh) {
        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM GioHang WHERE MaKH = ?")) {

            pst.setString(1, makh);
            ResultSet rs = pst.executeQuery();

            System.out.println("Kết nối SQL Server thành công với bảng GioHang!");

            // Clear list before loading
            a.clear();

            while (rs.next()) {
                cart_DTO c = new cart_DTO(
                        rs.getString("MaKH"),
                        rs.getString("MaThuoc"),
                        rs.getInt("SoLuong"),
                        rs.getInt("ThanhTien"),
                        rs.getInt("DonGia"));
                a.add(c);
            }

            System.out.println("Đã tải giỏ hàng cho khách hàng: " + makh);

        } catch (Exception e) {
            System.out.println("Lỗi khi đọc giỏ hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateCartDatabase(ArrayList<cart_DTO> cartList) {
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
