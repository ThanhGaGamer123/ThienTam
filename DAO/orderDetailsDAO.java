package DAO;

import DTO.order_details_DTO;
import data.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class orderDetailsDAO {

    // public static void themChiTietDonHang(order_details_DTO ct) {
    // if (ct.getMadon() == null || ct.getMadon().isEmpty()) {
    // System.err.println("Mã đơn hàng không hợp lệ. Không thể thêm chi tiết đơn
    // hàng.");
    // return;
    // }

    // String sql = "INSERT INTO ChiTietDonHang (mactdh, sl, thanhtien, madon,
    // donvi, dongia, macthdnhap, tinhtrang) "
    // + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    // try (Connection con = MyConnection.createConnection();
    // PreparedStatement stmt = con.prepareStatement(sql)) {

    // stmt.setString(1, ct.getMactdh());
    // stmt.setInt(2, ct.getSl());
    // stmt.setDouble(3, ct.getThanhtien());
    // stmt.setString(4, ct.getMadon());
    // stmt.setString(5, ct.getDonvi());
    // stmt.setDouble(6, ct.getDongia());
    // stmt.setString(7, ct.getMacthdnhap());
    // stmt.setBoolean(8, ct.getTinhtrang() != null ? ct.getTinhtrang() : false); //
    // Status

    // int rowsInserted = stmt.executeUpdate();
    // if (rowsInserted > 0) {
    // System.out.println("Thêm chi tiết đơn hàng thành công!");
    // } else {
    // System.out.println("Không thêm được chi tiết đơn hàng.");
    // }

    // } catch (SQLException e) {
    // System.err.println("Lỗi khi thêm chi tiết đơn hàng: " + e.getMessage());
    // e.printStackTrace();
    // }
    // }
    public static void themChiTietDonHang(order_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        // Kiểm tra mã chi tiết hóa đơn nhập
        if (t.getMacthdnhap() == null || t.getMacthdnhap().isEmpty()) {
            System.out.println("Mã chi tiết hóa đơn nhập không hợp lệ!");
            return; // Kết thúc nếu không có mã hợp lệ
        }

        String command = "INSERT INTO ChiTietDonHang (mactdh, donvi, sl, thanhtien, madon, dongia, macthdnhap, tinhtrang) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactdh());
            pst.setString(2, t.getDonvi());
            pst.setInt(3, t.getSl());
            pst.setDouble(4, t.getThanhtien());
            pst.setString(5, t.getMadon());
            pst.setDouble(6, t.getDongia());
            pst.setString(7, t.getMacthdnhap());
            pst.setBoolean(8, t.getTinhtrang());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }

    public static String taoMaCTHDMoi() {
        String newMaCTHD = "CTHD001"; // Default if the table is empty
        String sql = "SELECT TOP 1 mactdh FROM ChiTietDonHang ORDER BY CAST(SUBSTRING(mactdh, 5, LEN(mactdh) - 4) AS INT) DESC";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String lastMaCTHD = rs.getString("mactdh"); // Example: "CTHD999"
                int num = Integer.parseInt(lastMaCTHD.substring(4)); // Get the numeric part
                num++;
                newMaCTHD = String.format("CTHD%03d", num); // Format to "CTHD002"
            }

        } catch (SQLException e) {
            System.out.println("SQL error when creating new detail ID: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newMaCTHD;
    }

    public static ArrayList<order_details_DTO> layChiTietDonHangTheoMaDon(String mahd) {
        ArrayList<order_details_DTO> danhSachChiTiet = new ArrayList<>();
        String sql = "ssSELECT * FROM ChiTietDonHang WHERE madon = ?";
        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, mahd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String mactdh = rs.getString("mactdh");
                String donvi = rs.getString("donvi");
                int sl = rs.getInt("sl");
                double thanhtien = rs.getDouble("thanhtien");
                String madon = rs.getString("madon");
                double dongia = rs.getDouble("dongia");
                String macthdnhap = rs.getString("macthdnhap");
                boolean tinhtrang = rs.getBoolean("tinhtrang");
                String tenthuoc = rs.getString("tenthuoc");

                System.out.println("Mã CTDH: " + mactdh);
                System.out.println("Mã đơn: " + madon);
                System.out.println("Mã CTHD nhập: " + macthdnhap);
                System.out.println("Tên thuốc: " + tenthuoc);
                System.out.println("Số lượng: " + sl);
                System.out.println("Đơn vị: " + donvi);
                System.out.println("Đơn giá: " + dongia);
                System.out.println("Thành tiền: " + thanhtien);
                System.out.println("Tình trạng: " + tinhtrang);
                System.out.println("-------------------------------------------------");

                order_details_DTO ct = new order_details_DTO(mactdh, madon, macthdnhap, sl, donvi, dongia, thanhtien,
                        tinhtrang);
                danhSachChiTiet.add(ct);

            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy chi tiết đơn hàng: " + e.getMessage());
        }

        return danhSachChiTiet;
    }

    public static void hienThiChiTietDonHang(String mahd, DefaultTableModel model) {
        String sql = "SELECT CHITIETDONHANG.*, Thuoc.tenthuoc " +
                "FROM CHITIETDONHANG " +
                "JOIN GIOHANG ON GIOHANG.MACTHDNHAP = CHITIETDONHANG.MACTHDNHAP " +
                "JOIN THUOC ON GIOHANG.MATHUOC = THUOC.MATHUOC " +
                "JOIN donhang ON CHITIETDONHANG.madon = donhang.madon " +
                "WHERE donhang.madon = ?";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, mahd);
            ResultSet rs = stmt.executeQuery();

            model.setRowCount(0); // clear table

            while (rs.next()) {
                String tenSanPham = rs.getString("tenthuoc");
                int sl = rs.getInt("sl");
                String dvi = rs.getString("donvi");
                double dongia = rs.getDouble("dongia");
                double thanhtien = rs.getDouble("thanhtien");

                // Thêm trực tiếp vào bảng
                model.addRow(new Object[] { tenSanPham, sl, dvi, dongia, thanhtien });
            }

            System.out.println("Đã load chi tiết đơn hàng thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy chi tiết đơn hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
