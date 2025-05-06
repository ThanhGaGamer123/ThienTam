package DAO;

import DTO.cart_DTO;
import data.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cartDAO {

    public static String taoMaGHMoi() {
        String newMaGH = "GH001";
        String sql = "SELECT TOP 1 MaGH FROM GioHang ORDER BY CAST(SUBSTRING(MaGH, 3, LEN(MaGH)) AS INT) DESC";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String lastMaGH = rs.getString("MaGH");
                int num = Integer.parseInt(lastMaGH.substring(2));
                num++;
                newMaGH = String.format("GH%03d", num);
            }

        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi tạo mã giỏ hàng mới: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newMaGH;
    }

    public ArrayList<cart_DTO> readCartDatabase(String makh) {
        ArrayList<cart_DTO> cartList = new ArrayList<>();

        try (Connection con = MyConnection.createConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM GioHang WHERE MaKH = ?")) {

            pst.setString(1, makh);
            ResultSet rs = pst.executeQuery();

            System.out.println("Kết nối SQL Server thành công với bảng GioHang!");

            while (rs.next()) {
                cart_DTO c = new cart_DTO(
                        rs.getString("MaGH"),
                        rs.getString("MaKH"),
                        rs.getString("MaThuoc"),
                        rs.getString("Donvi"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("ThanhTien"),
                        rs.getDouble("DonGia"),
                        rs.getString("macthdnhap"));
                cartList.add(c);
            }

            if (cartList.isEmpty()) {
                System.out.println("Giỏ hàng trống cho khách hàng: " + makh);
            } else {
                System.out.println("Đã tải giỏ hàng cho khách hàng: " + makh);
            }

        } catch (SQLException e) {
            System.out.println("Lỗi SQL khi đọc giỏ hàng: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc giỏ hàng: " + e.getMessage());
            e.printStackTrace();
        }

        return cartList;
    }

    public void xoaSanPhamTrongGio(String magh) {
        try (Connection con = MyConnection.createConnection()) {
            String sql = "DELETE FROM GioHang WHERE MaGH = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, magh);

                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Đã xoá sản phẩm trong giỏ hàng với mã giỏ: " + magh);
                } else {
                    System.out.println("Không tìm thấy sản phẩm để xoá.");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi xoá sản phẩm khỏi giỏ: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void capNhatSoLuong(String magh, int soluong) {
        try (Connection con = MyConnection.createConnection()) {
            String sql = "UPDATE GioHang SET SoLuong = ? WHERE MaGH = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, soluong);
                ps.setString(2, magh); // Sử dụng MaGH để xác định sản phẩm

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Đã cập nhật số lượng thành công.");
                } else {
                    System.out.println("Không tìm thấy sản phẩm để cập nhật.");
                }
            } catch (SQLException e) {
                System.out.println("Lỗi SQL khi cập nhật số lượng: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateCart(ArrayList<cart_DTO> cartList) {
        try (Connection con = MyConnection.createConnection()) {
            if (con == null) {
                System.out.println("Không thể kết nối đến SQL Server.");
                return;
            }

            System.out.println("Kết nối SQL Server thành công để cập nhật giỏ hàng!");

            // Step 1: Delete old cart for the customer (only if cartList is not empty)
            String deleteQuery = "DELETE FROM GioHang WHERE MaKH = ?";
            try (PreparedStatement deleteStmt = con.prepareStatement(deleteQuery)) {
                if (!cartList.isEmpty()) {
                    deleteStmt.setString(1, cartList.get(0).getMakh());
                    deleteStmt.executeUpdate();
                }
            }

            // Step 2: Insert new items into the cart
            String insertQuery = "INSERT INTO GioHang (MaGH, MaKH, MaThuoc, Donvi, SoLuong, ThanhTien, DonGia, macthdnhap) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
                for (cart_DTO c : cartList) {
                    insertStmt.setString(1, c.getMagh()); // Set MaGH
                    insertStmt.setString(2, c.getMakh()); // Set MaKH
                    insertStmt.setString(3, c.getMathuoc()); // Set MaThuoc
                    insertStmt.setString(4, c.getDonvi()); // Set Donvi
                    insertStmt.setInt(5, c.getSl()); // Set SoLuong
                    insertStmt.setDouble(6, c.getThanhtien()); // Set ThanhTien
                    insertStmt.setDouble(7, c.getDongia()); // Set DonGia
                    insertStmt.setString(8, c.getMacthdnhap()); // Set macthdnhap

                    insertStmt.addBatch(); // Add to batch
                }

                insertStmt.executeBatch(); // Execute all statements
            }

            System.out.println("Đã cập nhật giỏ hàng thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật giỏ hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getMacthdnhapByMathuoc(String mathuoc) {
        String macthdnhap = null;

        String query = "SELECT TOP 1 macthdnhap FROM ChiTietHoaDonNhap WHERE mathuoc = ? AND tinhtrang = 1";

        try (Connection con = MyConnection.createConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, mathuoc);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                macthdnhap = rs.getString("macthdnhap");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return macthdnhap; // Trả về mã tìm được (null nếu không có)
    }

    public static String laythongtinMacthdnhap(String makh, String mathuoc) {
        String macthdnhap = null;
        Connection sql = data.SQL.createConnection();

        String query = "SELECT macthdnhap FROM GioHang WHERE makh = ? AND mathuoc = ?";

        try (PreparedStatement pst = sql.prepareStatement(query)) {
            pst.setString(1, makh);
            pst.setString(2, mathuoc);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                macthdnhap = rs.getString("macthdnhap");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return macthdnhap; // Trả về macthdnhap hoặc null nếu không tìm thấy
    }

}