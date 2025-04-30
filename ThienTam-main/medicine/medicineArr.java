package medicine;

import DTO.medicine_DTO;
import advanceMethod.advance;
import java.sql.*;
import java.util.ArrayList;

public class medicineArr {
    private ArrayList<medicine_DTO> sp;

    public medicineArr() {
        this.sp = new ArrayList<>();
    }

    public ArrayList<medicine_DTO> getSp() {
        return sp;
    }

    public void setSp(ArrayList<medicine_DTO> sp) {
        this.sp = sp;
    }

    // Hàm in danh sách thuốc
    public void printMedicines() {
        if (sp.isEmpty()) {
            System.out.println("Danh sách thuốc trống.");
            return;
        }

        System.out.println("Danh sách thuốc:");
        for (medicine_DTO m : sp) {
            System.out.println(m); // toString() trong medicine sẽ giúp in gọn
        }
    }

    // Tìm kiếm thuốc theo tên
    public ArrayList<medicine_DTO> findName(String timkiem) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            if (m.getTenthuoc().toLowerCase().contains(timkiem.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    // Tìm theo đối tượng sử dụng
    public ArrayList<medicine_DTO> findDTuongSD(String s) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            for (String dt : m.getDoituongsudung()) {
                if (dt.toLowerCase().contains(s.toLowerCase())) {
                    result.add(m);
                    break;
                }
            }
        }
        return result;
    }

    // Tìm theo xuất xứ
    public ArrayList<medicine_DTO> findXuatXu(String x) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            if (m.getXuatxu().toLowerCase().contains(x.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    // Tìm theo thông tin thuốc
    public ArrayList<medicine_DTO> findChiDinh(String c) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            if (m.getThongtin().toLowerCase().contains(c.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
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

    public void readDatabase() {
        try {
            sp = selectAll(); // Gọi hàm đã có sẵn để đọc dữ liệu
            System.out.println("Dữ liệu đã tải từ bảng Thuoc.");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu từ database: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
