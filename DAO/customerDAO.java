package DAO;

import data.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class customerDAO {

    public static String taoMaKHMoi() {
        String newMaKH = "KH1"; // mặc định nếu bảng rỗng
        String sql = "SELECT TOP 1 MaKH FROM KhachHang ORDER BY CAST(SUBSTRING(MaKH, 3, LEN(MaKH)) AS INT) DESC";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            var rs = pst.executeQuery();
            if (rs.next()) {
                String lastMaKH = rs.getString("MaKH"); // ví dụ: "KH999"
                int num = Integer.parseInt(lastMaKH.substring(2)); // lấy phần số
                num++;
                newMaKH = "KH" + num; // Tạo mã mới
            }

        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi tạo mã khách hàng mới: " + e.getMessage());
            e.printStackTrace();
        }

        return newMaKH;
    }

    public void themKhachhang(String tenkh, String email, String sdt, String masonha, String duong,
            String phuong, String quan, String tinh, String password) {

        // Gọi hàm tạo mã khách hàng mới
        String maKH = taoMaKHMoi();

        String sql = "INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, maSoNha, Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh, tinhtrang) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            // Thiết lập tham số cho PreparedStatement
            pst.setString(1, maKH);
            pst.setString(2, tenkh);
            pst.setString(3, sdt);
            pst.setString(4, email);
            pst.setString(5, masonha);
            pst.setString(6, duong);
            pst.setString(7, phuong);
            pst.setString(8, quan);
            pst.setString(9, tinh);
            pst.setInt(10, 0); // DiemKM mặc định là 0
            pst.setString(11, password);
            pst.setBoolean(12, true); // Tình trạng khách hàng mặc định là 'true'

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thêm khách hàng thành công. Mã KH: " + maKH);
            } else {
                System.out.println("Không thể thêm khách hàng.");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi thêm khách hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void capNhatThongtinKH(String tenkh, String sdt, String email, String makh) {
        try (Connection con = MyConnection.createConnection()) {
            String sql = "UPDATE KhachHang SET tenkh = ?, sdt = ?, email = ? WHERE makh = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, tenkh);
                ps.setString(2, sdt); // Sửa lại vị trí tham số cho đúng
                ps.setString(3, email);
                ps.setString(4, makh); // Sửa lại vị trí tham số cho đúng

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Đã cập nhật thông tin thành công.");
                } else {
                    System.out.println("Không tìm thấy khách hàng để cập nhật.");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi cập nhật thông tin: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}