package medicine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    // Hàm kết nối SQL Server và lấy dữ liệu từ bảng Thuoc (cập nhật theo dữ liệu
    // của bạn)

    public void readDatabase() {
        try {
            // Nạp driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password);
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Thuoc")) {

                System.out.println("Kết nối SQL Server thành công!");

                sp.clear(); // Xóa danh sách cũ trước khi tải mới

                // Đọc dữ liệu từ ResultSet và thêm vào danh sách
                while (rs.next()) {
                    // Lấy dữ liệu từ ResultSet và phân tách
                    String[] donvi = rs.getString("DonVi").split(";");
                    String[] doituongsudung = rs.getString("Doituongsudung").split(";");

                    // Chuyển giaBan từ chuỗi sang mảng int[]
                    String[] giaBanString = rs.getString("GiaBan").split(",");
                    int[] giaban = new int[giaBanString.length];
                    for (int i = 0; i < giaBanString.length; i++) {
                        try {
                            giaban[i] = Integer.parseInt(giaBanString[i].trim()); // Chuyển chuỗi thành int
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi khi chuyển đổi giá bán: " + giaBanString[i]);
                            giaban[i] = 0; // Nếu có lỗi, gán giá trị 0
                        }
                    }

                    // Tạo đối tượng medicine và thêm vào danh sách
                    medicine thuoc = new medicine(
                            rs.getString("MaThuoc"),
                            rs.getString("MaTon"),
                            rs.getString("TenThuoc"),
                            rs.getString("DanhMuc"),
                            donvi,
                            rs.getString("ThanhPhan"),
                            rs.getString("ThongTin"),
                            rs.getString("XuatXu"),
                            doituongsudung,
                            giaban);

                    sp.add(thuoc); // Thêm vào danh sách sản phẩm
                }

                System.out.println("Dữ liệu đã tải từ bảng Thuoc.");

            } catch (SQLException e) {
                System.out.println("Lỗi SQL: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc lỗi khác: " + e.getMessage());
        }
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
}
