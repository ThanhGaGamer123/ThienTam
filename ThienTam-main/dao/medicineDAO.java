package dao;

import advanceMethod.advance;
import java.sql.*;
import java.util.ArrayList;
import medicine.medicine;

public class medicineDAO {

    public static medicine timThuocTheoMa(String maThuoc) {
        medicine thuoc = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM Thuoc WHERE MaThuoc = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, maThuoc);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String maton = rs.getString("MaTon");
                    String tenthuoc = rs.getString("TenThuoc");
                    String danhmuc = rs.getString("DanhMuc");
                    String donviStr = rs.getString("DonVi");
                    String thanhphan = rs.getString("ThanhPhan");
                    String thongtin = rs.getString("ThongTin");
                    String xuatxu = rs.getString("XuatXu");
                    String doituongStr = rs.getString("DoiTuongSuDung");
                    String giabanStr = rs.getString("GiaBan");
                    Boolean tinhtrang = rs.getBoolean("TinhTrang");

                    // Chuyển đổi kiểu dữ liệu
                    ArrayList<String> donvi = advance.StringconvertToStringArrayList(donviStr);
                    ArrayList<String> doituongsudung = advance.StringconvertToStringArrayList(doituongStr);
                    ArrayList<Integer> giaban = advance.StringArrayListToIntArrayList(
                        advance.StringconvertToStringArrayList(giabanStr)
                    );

                    // Tạo đối tượng medicine
                    thuoc = new medicine(maThuoc, maton, tenthuoc, danhmuc, donvi, thanhphan,
                            thongtin, xuatxu, doituongsudung, giaban, tinhtrang);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return thuoc;
    }
}
