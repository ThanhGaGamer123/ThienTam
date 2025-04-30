package customer;

import DTO.customer_DTO;
import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class customer_DTOArr {
    private ArrayList<customer_DTO> a;

    public customer_DTOArr() {
        this.a = new ArrayList<>();
    }

    public ArrayList<customer_DTO> getA() {
        return a;
    }

    public void setA(ArrayList<customer_DTO> a) {
        this.a = a;
    }

    public void readDatabase() {
        try (Connection con = MyConnection.createConnection();
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM KhachHang");
                ResultSet rs = pstmt.executeQuery()) {

            a.clear();

            while (rs.next()) {
                customer_DTO kh = new customer_DTO(
                        rs.getString("makh"),
                        rs.getString("tenkh"),
                        Integer.parseInt(rs.getString("sdt")),
                        rs.getString("masonha"),
                        rs.getString("duong"),
                        rs.getString("phuong"),
                        rs.getString("quan"),
                        rs.getString("tinh"),
                        rs.getString("email"),
                        rs.getString("passwordkh"),
                        rs.getInt("diemkm"),
                        rs.getBoolean("tinhtrang"));
                a.add(kh);
            }

            System.out.println("Dữ liệu đã được tải từ database.");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu từ database: " + e.getMessage());
        }
    }

    public void printCustomers() {
        if (a.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        System.out.println("Danh sách khách hàng:");
        for (customer_DTO kh : a) {
            // In thông tin khách hàng
            System.out.println("Mã KH: " + kh.getMakh() +
                    ", Tên: " + kh.getTenkh() +
                    ", SĐT: " + kh.getSdt() +
                    ", Email: " + kh.getEmail() +
                    ", Địa chỉ: " + kh.getMasonha() + ", " + kh.getDuong() + ", " + kh.getPhuong() + ", " + kh.getQuan()
                    + ", " + kh.getTinh() +
                    ", Điểm KM: " + kh.getDiemKM() +
                    ", Mật khẩu: [ĐÃ ẨN]");
        }
    }
}
