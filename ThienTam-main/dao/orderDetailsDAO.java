package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import order_details.order_details;

public class orderDetailsDAO {

    public static void themChiTietDonHang(order_details ct) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "123";

        if (ct.getMadon() == null || ct.getMadon().isEmpty()) {
            System.err.println("Mã đơn hàng không hợp lệ. Không thể thêm chi tiết đơn hàng.");
            return;
        }

        String sql = "INSERT INTO ChiTietDonHang (mactdh, sl, thanhtien, madon, sanphammua, diachicuthe, macthdnhap) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = con.prepareStatement(sql)) {

            String mactdh = "CT_" + ct.getMadon(); // Tạo mã theo format CT_madon
            stmt.setString(1, mactdh);
          //  stmt.setInt(2, ct.getTongsoluong());
            stmt.setInt(3, ct.getThanhtien());
            stmt.setString(4, ct.getMadon());
            stmt.setString(5, String.join(";", ct.getSanphammua()));
            stmt.setString(6, ct.getDiachicuthe());
            stmt.setString(7, ct.getMacthdnhap()); // Có thể null

            stmt.executeUpdate();

            System.out.println("Thêm chi tiết đơn hàng thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm chi tiết đơn hàng:");
            e.printStackTrace();
        }
    }

}