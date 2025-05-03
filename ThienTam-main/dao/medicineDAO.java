package DAO;

import DTO.medicine_DTO;
import advanceMethod.advance;
import connection.MyConnection;
import java.sql.*;
import java.util.ArrayList;

public class medicineDAO {

    public static medicine_DTO timThuocTheoMa(String maThuoc) {
        medicine_DTO thuoc = null;

        String sql = "SELECT * FROM Thuoc WHERE MaThuoc = ?";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

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
                        ? advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(giabanStr))
                        : new ArrayList<>();

                thuoc = new medicine_DTO(maThuoc, maton, tenthuoc, danhmuc, donvi, thanhphan,
                        thongtin, xuatxu, doituongsudung, hansudung, giaban, tinhtrang);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi tìm thuốc theo mã: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return thuoc;
    }

    public ArrayList<medicine_DTO> selectAll() {
        ArrayList<medicine_DTO> medicines = new ArrayList<>();
        String command = "SELECT t.*, k.tinhtrang FROM Thuoc t JOIN Kho k ON t.maton = k.maton";

        try (Connection sql = data.SQL.createConnection();
                PreparedStatement pst = sql.prepareStatement(command);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                medicine_DTO med = new medicine_DTO();
                med.setMathuoc(rs.getString("mathuoc"));
                med.setTenthuoc(rs.getString("tenthuoc"));

                // Kiểm tra và chuyển đổi 'donvi' nếu có dữ liệu
                String donviStr = rs.getString("donvi");
                if (donviStr != null && !donviStr.isEmpty()) {
                    med.setDonvi(advance.StringconvertToStringArrayList(donviStr));
                }

                med.setThanhphan(rs.getString("thanhphan"));
                med.setThongtin(rs.getString("thongtin"));
                med.setXuatxu(rs.getString("xuatxu"));
                med.setDanhmuc(rs.getString("danhmuc"));

                // Kiểm tra và chuyển đổi 'giaban' từ chuỗi sang ArrayList<Double>
                String giabanStr = rs.getString("giaban");
                if (giabanStr != null && !giabanStr.isEmpty()) {
                    med.setGiaban(advance
                            .StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(giabanStr)));
                }

                med.setMaton(rs.getString("maton"));

                // Chuyển đổi 'doituongsudung' từ chuỗi thành ArrayList nếu có dữ liệu
                String doituongsudungStr = rs.getString("doituongsudung");
                if (doituongsudungStr != null && !doituongsudungStr.isEmpty()) {
                    med.setDoituongsudung(advance.StringconvertToStringArrayList(doituongsudungStr));
                }

                // Lấy giá trị 'tinhtrang' từ bảng 'Kho'
                med.setTinhtrang(rs.getBoolean("tinhtrang"));

                // Đọc trường 'hansudung' (hạn sử dụng) và gán giá trị
                med.setHansudung(rs.getString("hansudung"));

                // Thêm đối tượng thuốc vào danh sách
                medicines.add(med);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn thuốc: " + e.getMessage());
            e.printStackTrace();
        }

        return medicines; // Trả về danh sách thuốc
    }

}
