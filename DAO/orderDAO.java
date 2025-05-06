package DAO;

import DTO.order_DTO;
import data.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class orderDAO {

    public static String taoMaHDMoi() {
        String newMaHD = "DH0001"; // Mặc định nếu bảng rỗng
        String sql = "SELECT TOP 1 madon FROM DonHang ORDER BY CAST(SUBSTRING(madon, 3, LEN(madon)) AS INT) DESC";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String lastMaHD = rs.getString("madon"); // Ví dụ: "HD999"
                int num = Integer.parseInt(lastMaHD.substring(2)); // Lấy phần số
                num++;
                newMaHD = String.format("DH0%03d", num); // Định dạng lại mã đơn hàng, ví dụ: "HD002"
            }

        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi tạo mã đơn hàng mới: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newMaHD;
    }

    public static boolean taodonhangmoi(String madon, String makh, String sdt_nguoidat, String manv, String diachicuthe,
            String phuong, String quan, String tinh, String ngaydat, String pttt,
            String tinhtrang, double tongtien, String ghichu, String nguoinhan,
            String sdt_nguoinhan) {
        String sql = "INSERT INTO DonHang (madon, makh, sdt_nguoidat, manv, diachicuthe, phuong, " +
                "quan, tinh, ngaydat, pttt, tinhtrang, tongtien, ghichu, nguoinhan, sdt_nguoinhan) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, madon);
            stmt.setString(2, makh);
            stmt.setString(3, sdt_nguoidat);
            stmt.setString(4, manv);
            stmt.setString(5, diachicuthe);
            stmt.setString(6, phuong);
            stmt.setString(7, quan);
            stmt.setString(8, tinh);
            stmt.setString(9, ngaydat);
            stmt.setString(10, pttt);
            stmt.setString(11, tinhtrang);
            stmt.setDouble(12, tongtien);
            stmt.setString(13, ghichu);
            stmt.setString(14, nguoinhan);
            stmt.setString(15, sdt_nguoinhan);

            stmt.executeUpdate();
            System.out.println("Thêm đơn hàng thành công!");
            return true; // Trả về true nếu thành công

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm đơn hàng: " + e.getMessage());
            return false; // Trả về false nếu có lỗi
        }
    }

    public static void capNhatTongTien(String madon, double tongtien) {
        System.out.println("Cập nhật tổng tiền cho mã đơn hàng: " + madon + " với tổng tiền: " + tongtien);

        String sql = "UPDATE DonHang SET tongtien = ? WHERE madon = ?";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, tongtien);
            stmt.setString(2, madon);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cập nhật tổng tiền thành công!");
            } else {
                System.out.println("Không tìm thấy mã đơn hàng để cập nhật.");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật tổng tiền: " + e.getMessage());
        }
    }

    public static ArrayList<order_DTO> layTatCaDonHangTheoKhachHang(String makh) {
        ArrayList<order_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM DonHang WHERE makh = ?";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, makh);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String madon = rs.getString("madon");
                String sdtNguoidat = rs.getString("sdt_nguoidat");
                String manv = rs.getString("manv");
                String diachicuthe = rs.getString("diachicuthe");
                String phuong = rs.getString("phuong");
                String quan = rs.getString("quan");
                String tinh = rs.getString("tinh");
                String ngaydat = rs.getString("ngaydat");
                String pttt = rs.getString("pttt");
                String tinhtrang = rs.getString("tinhtrang");
                double tongtien = rs.getDouble("tongtien");
                String ghichu = rs.getString("ghichu");
                String nguoinhan = rs.getString("nguoinhan");
                String sdtNguoinhan = rs.getString("sdt_nguoinhan");

                // Tạo đối tượng DonHangDTO và thêm vào danh sách
                order_DTO donHang = new order_DTO(madon, makh, sdtNguoidat, manv, diachicuthe, phuong, quan, tinh,
                        ngaydat, pttt, tongtien, tinhtrang, ghichu, nguoinhan, sdtNguoinhan);
                danhSach.add(donHang);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSach; // Trả về danh sách đơn hàng
    }

}