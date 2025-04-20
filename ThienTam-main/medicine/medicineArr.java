package medicine;

import advanceMethod.advance;
import java.sql.*;
import java.util.ArrayList;

public class medicineArr {
    private ArrayList<medicine> sp;

    public medicineArr() {
        this.sp = new ArrayList<>();
    }

    public ArrayList<medicine> getSp() {
        return sp;
    }

    public void setSp(ArrayList<medicine> sp) {
        this.sp = sp;
    }

    // Hàm in danh sách thuốc
    public void printMedicines() {
        if (sp.isEmpty()) {
            System.out.println("Danh sách thuốc trống.");
            return;
        }

        System.out.println("Danh sách thuốc:");
        for (medicine m : sp) {
            System.out.println(m); // toString() trong medicine sẽ giúp in gọn
        }
    }

    // Tìm kiếm thuốc theo tên
    public ArrayList<medicine> findName(String timkiem) {
        ArrayList<medicine> result = new ArrayList<>();
        for (medicine m : sp) {
            if (m.getTenthuoc().toLowerCase().contains(timkiem.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    // Tìm theo đối tượng sử dụng
    public ArrayList<medicine> findDTuongSD(String s) {
        ArrayList<medicine> result = new ArrayList<>();
        for (medicine m : sp) {
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
    public ArrayList<medicine> findXuatXu(String x) {
        ArrayList<medicine> result = new ArrayList<>();
        for (medicine m : sp) {
            if (m.getXuatxu().toLowerCase().contains(x.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    // Tìm theo thông tin thuốc
    public ArrayList<medicine> findChiDinh(String c) {
        ArrayList<medicine> result = new ArrayList<>();
        for (medicine m : sp) {
            if (m.getThongtin().toLowerCase().contains(c.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    public ArrayList<medicine> selectAll() {
        ArrayList<medicine> medicines = new ArrayList<>();
        String command = "SELECT t.*, k.tinhtrang FROM Thuoc t JOIN Kho k ON t.maton = k.maton";

        try (Connection sql = data.SQL.createConnection();
                PreparedStatement pst = sql.prepareStatement(command);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                medicine med = new medicine();
                med.setMathuoc(rs.getString("mathuoc"));
                med.setTenthuoc(rs.getString("tenthuoc"));
                med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                med.setThanhphan(rs.getString("thanhphan"));
                med.setThongtin(rs.getString("thongtin"));
                med.setXuatxu(rs.getString("xuatxu"));
                med.setDanhmuc(rs.getString("danhmuc"));
                med.setGiaban(
                        advance.StringArrayListToIntArrayList(
                                advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                med.setMaton(rs.getString("maton"));
                med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                med.setTinhtrang(rs.getBoolean("tinhtrang")); // từ bảng Kho
                medicines.add(med);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn thuốc: " + e.getMessage());
            e.printStackTrace();
        }

        return medicines;
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
