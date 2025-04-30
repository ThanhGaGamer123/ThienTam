package DAO;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import order_details.order_details;

public class orderDetailsDAO {

    public static void themChiTietDonHang(order_details ct) {
        if (ct.getMadon() == null || ct.getMadon().isEmpty()) {
            System.err.println("Mã đơn hàng không hợp lệ. Không thể thêm chi tiết đơn hàng.");
            return;
        }
        String sanphammuaChuoi = String.join(";", ct.getSanphammua());

        String sql = "INSERT INTO ChiTietDonHang (mactdh, sl, thanhtien, madon, sanphammua, diachicuthe, macthdnhap) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, ct.getMactdh());
            stmt.setInt(2, ct.getSl()); // sl
            stmt.setInt(3, ct.getThanhtien()); // thanhtien
            stmt.setString(4, ct.getMadon()); // madon
            stmt.setString(5, String.join(";", sanphammuaChuoi));
            stmt.setString(6, ct.getDiachicuthe()); // diachicuthe
            stmt.setString(7, ct.getMacthdnhap()); // macthdnhap (có thể null)

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm chi tiết đơn hàng thành công!");
            } else {
                System.out.println("Không thêm được chi tiết đơn hàng.");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm chi tiết đơn hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<order_details> layDanhSachDonHangTheoMaKH(String makh) {
        ArrayList<order_details> danhSach = new ArrayList<>();
        String sql = "SELECT ctdh.*, dh.ngaydat " +
                "FROM ChiTietDonHang ctdh " +
                "JOIN DonHang dh ON ctdh.madon = dh.madon " +
                "WHERE dh.makh = ?";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, makh);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String mactdh = rs.getString("mactdh");
                int sl = rs.getInt("sl");
                int thanhtien = rs.getInt("thanhtien");
                String madon = rs.getString("madon");
                String sanphammuaStr = rs.getString("sanphammua");
                String diachicuthe = rs.getString("diachicuthe");
                String macthdnhap = rs.getString("macthdnhap");
                String ngaydat = rs.getString("ngaydat");

                // Chuyển chuỗi sản phẩm mua thành danh sách
                ArrayList<String> sanphammua = new ArrayList<>(Arrays.asList(sanphammuaStr.split(";")));

                // Tạo đối tượng order_details và thêm vào danh sách
                order_details ct = new order_details(mactdh, madon, macthdnhap, sanphammua, diachicuthe, sl, thanhtien,
                        ngaydat);
                danhSach.add(ct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSach;
    }

}
