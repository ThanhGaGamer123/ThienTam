package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.customer_DTO;

public class customer_DAO implements DAO<customer_DTO> {
    @Override
    public int add(customer_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO KhachHang (makh, tenkh, sdt, email, masonha, duong, phuong, quan, tinh, diemkm, passwordkh, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakh());
            pst.setString(2, t.getTenkh());
            pst.setInt(3, t.getSdt());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getMasonha());
            pst.setString(6, t.getDuong());
            pst.setString(7, t.getPhuong());
            pst.setString(8, t.getQuan());
            pst.setString(9, t.getTinh());
            pst.setInt(10, t.getDiemKM());
            pst.setString(11, t.getPassword());
            pst.setBoolean(12, t.getTinhtrang());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    @Override
    public int update(customer_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE KhachHang SET tenkh = ?, sdt = ?, email = ?, masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, diemkm = ?, passwordkh = ?, tinhtrang = ? WHERE makh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getTenkh());
            pst.setInt(2, t.getSdt());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getMasonha());
            pst.setString(5, t.getDuong());
            pst.setString(6, t.getPhuong());
            pst.setString(7, t.getQuan());
            pst.setString(8, t.getTinh());
            pst.setInt(9, t.getDiemKM());
            pst.setString(10, t.getPassword());
            pst.setBoolean(11, t.getTinhtrang());
            pst.setString(12, t.getMakh());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    @Override
    public int delete(customer_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM KhachHang WHERE makh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakh());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    @Override
    public ArrayList<customer_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<customer_DTO> customers = new ArrayList<>();
        String command = "SELECT * FROM KhachHang";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customer_DTO customer = new customer_DTO();
                customer.setMakh(rs.getString("makh"));
                customer.setTenkh(rs.getString("tenkh"));
                customer.setSdt(rs.getInt("sdt"));
                customer.setEmail(rs.getString("email"));
                customer.setMasonha(rs.getString("masonha"));
                customer.setDuong(rs.getString("duong"));
                customer.setPhuong(rs.getString("phuong"));
                customer.setQuan(rs.getString("quan"));
                customer.setTinh(rs.getString("tinh"));
                customer.setDiemKM(rs.getInt("diemkm"));
                customer.setPassword(rs.getString("passwordkh"));
                customer.setTinhtrang(rs.getBoolean("tinhtrang"));
                customers.add(customer);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return customers;
    }

    @Override
    public ArrayList<customer_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<customer_DTO> customers = new ArrayList<>();
        String command = "SELECT * FROM KhachHang WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                customer_DTO customer = new customer_DTO();
                customer.setMakh(rs.getString("makh"));
                customer.setTenkh(rs.getString("tenkh"));
                customer.setSdt(rs.getInt("sdt"));
                customer.setEmail(rs.getString("email"));
                customer.setMasonha(rs.getString("masonha"));
                customer.setDuong(rs.getString("duong"));
                customer.setPhuong(rs.getString("phuong"));
                customer.setQuan(rs.getString("quan"));
                customer.setTinh(rs.getString("tinh"));
                customer.setDiemKM(rs.getInt("diemkm"));
                customer.setPassword(rs.getString("passwordkh"));
                customer.setTinhtrang(rs.getBoolean("tinhtrang"));
                customers.add(customer);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return customers;
    }

    @Override
    public customer_DTO selectByID(customer_DTO t) {
        Connection sql = data.SQL.createConnection();

        customer_DTO customer = new customer_DTO();
        String command = "SELECT * FROM KhachHang WHERE makh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakh());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                customer.setMakh(rs.getString("makh"));
                customer.setTenkh(rs.getString("tenkh"));
                customer.setSdt(rs.getInt("sdt"));
                customer.setEmail(rs.getString("email"));
                customer.setMasonha(rs.getString("masonha"));
                customer.setDuong(rs.getString("duong"));
                customer.setPhuong(rs.getString("phuong"));
                customer.setQuan(rs.getString("quan"));
                customer.setTinh(rs.getString("tinh"));
                customer.setDiemKM(rs.getInt("diemkm"));
                customer.setPassword(rs.getString("passwordkh"));
                customer.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return customer;
    }
    
}
