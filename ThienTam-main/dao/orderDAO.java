package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class orderDAO {

    public static String taoMaHDMoi() {
        String newMaHD = "HD001";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "123";

        String sql = "SELECT TOP 1 madon FROM DonHang ORDER BY CAST(SUBSTRING(madon, 3, LEN(madon)) AS INT) DESC";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String lastMaHD = rs.getString("madon"); // ví dụ: "HD999"
                int num = Integer.parseInt(lastMaHD.substring(2)); // lấy phần số
                num++;
                newMaHD = String.format("HD%03d", num); // định dạng lại mã đơn hàng, ví dụ: "HD002"
            }

        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi tạo mã đơn hàng mới: " + e.getMessage());
            e.printStackTrace();
        }

        return newMaHD;
    }

    public static void taodonhangmoi(String madon, String makh, int sdt, String manv, String tennguoinhan,
            String sdtnguoinhan, String phuong, String quan, String tinh, String diachicuthe,
            ArrayList<String> sanphammua, String ngaydat, String ghichu, String pttt, int tongtien, String tinhtrang) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "123";

        // Gộp danh sách sản phẩm thành một chuỗi cách nhau bởi dấu ";"
        String sanphammuaChuoi = String.join("     ;     ", sanphammua);

        String sql = "INSERT INTO DonHang (madon, makh, sdt, manv, tennguoinhan, sdtnguoinhan, phuong, quan, tinh, diachicuthe, sanphammua, ngaydat, ghichu, pttt, tongtien, tinhtrang) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, madon);
            stmt.setString(2, makh);
            stmt.setInt(3, sdt);
            stmt.setString(4, manv);
            stmt.setString(5, tennguoinhan);
            stmt.setString(6, sdtnguoinhan);
            stmt.setString(7, phuong);
            stmt.setString(8, quan);
            stmt.setString(9, tinh);
            stmt.setString(10, diachicuthe);
            stmt.setString(11, sanphammuaChuoi);
            stmt.setString(12, ngaydat);
            stmt.setString(13, ghichu);
            stmt.setString(14, pttt);
            stmt.setInt(15, tongtien);
            stmt.setString(16, tinhtrang);

            stmt.executeUpdate();

            System.out.println("Thêm đơn hàng thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm đơn hàng: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
