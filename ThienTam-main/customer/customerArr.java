package customer;

import java.sql.*;
import java.util.ArrayList;

public class customerArr {
    private ArrayList<customer> a;

    public customerArr() {
        this.a = new ArrayList<>();
    }

    public ArrayList<customer> getA() {
        return a;
    }

    public void setA(ArrayList<customer> a) {
        this.a = a;
    }

    public void readDatabase() {
        try {
   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Kết nối SQL Server thành công!");
            }

           
            String query = "SELECT * FROM KhachHang";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            a.clear();

    
            while (rs.next()) {
                customer kh = new customer(
                        rs.getString("MaKH"),
                        rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getString("SoNha"),
                        rs.getString("Duong"),
                        rs.getString("Phuong"),
                        rs.getString("Quan"),
                        rs.getString("Tinh"),
                        rs.getInt("DiemKM"),
                        rs.getString("Passwordkh"));
                a.add(kh);
            }

    
            rs.close();
            stmt.close();
            con.close();

            System.out.println("Dữ liệu đã được tải từ database.");
        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc truy vấn SQL: " + e.getMessage());
        }
    }

    public void printCustomers() {
        if (a.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        System.out.println("Danh sách khách hàng:");
        for (customer kh : a) {
            System.out.println("Mã KH: " + kh.getMakh() +
                    ", Tên: " + kh.getTenkh() +
                    ", SĐT: " + kh.getSdtkh() +
                    ", Email: " + kh.getEmail() +
                    ", Địa chỉ: " + kh.getSoNhakhach() + ", " + kh.getPhuongkh() + ", " + kh.getQuankh() + ", "
                    + kh.getTinhkh() +
                    ", Điểm KM: " + kh.getDiemkm() +
                    ", Mật khẩu: [ĐÃ ẨN]");
        }
    }
}
