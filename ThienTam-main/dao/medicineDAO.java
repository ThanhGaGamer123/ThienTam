package DAO;

import DTO.medicine_DTO;
import advanceMethod.advance;
import java.sql.*;
import java.util.ArrayList;

public class medicineDAO {

    public static medicine_DTO timThuocTheoMa(String maThuoc) {
        medicine_DTO thuoc = null;

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
                    String hansudung = rs.getString("HanSuDung");
                    String giabanStr = rs.getString("GiaBan");
                    Boolean tinhtrang = rs.getBoolean("TinhTrang");

                    ArrayList<String> donvi = (donviStr != null && !donviStr.isEmpty())
                            ? advance.StringconvertToStringArrayList(donviStr)
                            : new ArrayList<>();

                    ArrayList<String> doituongsudung = (doituongStr != null && !doituongStr.isEmpty())
                            ? advance.StringconvertToStringArrayList(doituongStr)
                            : new ArrayList<>();

                    ArrayList<Double> giaban = (giabanStr != null && !giabanStr.isEmpty())
                            ? advance
                                    .StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(giabanStr))
                            : new ArrayList<>();

                    thuoc = new medicine_DTO(maThuoc, maton, tenthuoc, danhmuc, donvi, thanhphan,
                            thongtin, xuatxu, doituongsudung, hansudung, giaban, tinhtrang);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return thuoc;
    }

}
