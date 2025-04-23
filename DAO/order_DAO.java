package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.order_DTO;

public class order_DAO implements DAO<order_DTO> {
    @Override
    public int add(order_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO DonHang (madon, makh, manv, masonha, duong, phuong, quan, tinh, ngaydat, pttt, tinhtrang, tongtien, ghichu, nguoinha, sdt_nguoinhan)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMadon());
            pst.setString(2, t.getMakh());
            pst.setString(3, t.getManv());
            pst.setString(4, t.getMasonha());
            pst.setString(5, t.getDuong());
            pst.setString(6, t.getPhuong());
            pst.setString(7, t.getQuan());
            pst.setString(8, t.getTinh());
            pst.setString(9, t.getNgaydat());
            pst.setString(10, t.getPttt());
            pst.setString(11, t.getTinhtrang());
            pst.setDouble(12, t.getTongtien());
            pst.setString(13, t.getGhichu());
            pst.setString(14, t.getNguoinhan());
            pst.setInt(15, t.getSdt_nguoinhan());

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
    public int update(order_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE DonHang SET makh = ?, manv = ?, masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, ngaydat = ?, pttt = ?, tinhtrang = ?, tongtien = ?, ghichu = ?, nguoinha = ?, sdt_nguoinhan = ? WHERE madon = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakh());
            pst.setString(2, t.getManv());
            pst.setString(3, t.getMasonha());
            pst.setString(4, t.getDuong());
            pst.setString(5, t.getPhuong());
            pst.setString(6, t.getQuan());
            pst.setString(7, t.getTinh());
            pst.setString(8, t.getNgaydat());
            pst.setString(9, t.getPttt());
            pst.setString(10, t.getTinhtrang());
            pst.setDouble(11, t.getTongtien());
            pst.setString(12, t.getGhichu());
            pst.setString(13, t.getNguoinhan());
            pst.setInt(14, t.getSdt_nguoinhan());
            pst.setString(15, t.getMadon());

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
    public int delete(order_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM DonHang WHERE madon = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMadon());

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
    public ArrayList<order_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<order_DTO> orders = new ArrayList<>();
        String command = "SELECT * FROM DonHang";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                order_DTO order = new order_DTO();
                order.setMadon(rs.getString("madon"));
                order.setMakh(rs.getString("makh"));
                order.setManv(rs.getString("manv"));
                order.setMasonha(rs.getString("masonha"));
                order.setDuong(rs.getString("duong"));
                order.setPhuong(rs.getString("phuong"));
                order.setQuan(rs.getString("quan"));
                order.setTinh(rs.getString("tinh"));
                order.setNgaydat(rs.getString("ngaydat"));
                order.setPttt(rs.getString("pttt"));
                order.setTinhtrang(rs.getString("tinhtrang"));
                order.setTongtien(rs.getDouble("tongtien"));
                order.setGhichu(rs.getString("ghichu"));
                order.setNguoinhan(rs.getString("nguoinhan"));
                order.setSdt_nguoinhan(rs.getInt("sdt_nguoinhan"));
                orders.add(order);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orders;
    }

    @Override
    public ArrayList<order_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<order_DTO> orders = new ArrayList<>();
        String command = "SELECT * FROM DonHang WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                order_DTO order = new order_DTO();
                order.setMadon(rs.getString("madon"));
                order.setMakh(rs.getString("makh"));
                order.setManv(rs.getString("manv"));
                order.setMasonha(rs.getString("masonha"));
                order.setDuong(rs.getString("duong"));
                order.setPhuong(rs.getString("phuong"));
                order.setQuan(rs.getString("quan"));
                order.setTinh(rs.getString("tinh"));
                order.setNgaydat(rs.getString("ngaydat"));
                order.setPttt(rs.getString("pttt"));
                order.setTinhtrang(rs.getString("tinhtrang"));
                order.setTongtien(rs.getDouble("tongtien"));
                order.setGhichu(rs.getString("ghichu"));
                order.setNguoinhan(rs.getString("nguoinhan"));
                order.setSdt_nguoinhan(rs.getInt("sdt_nguoinhan"));
                orders.add(order);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orders;
    }

    @Override
    public order_DTO selectByID(order_DTO t) {
        Connection sql = data.SQL.createConnection();

        order_DTO order = new order_DTO();
        String command = "SELECT * FROM DonHang WHERE madon = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMadon());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                order.setMadon(rs.getString("madon"));
                order.setMakh(rs.getString("makh"));
                order.setManv(rs.getString("manv"));
                order.setMasonha(rs.getString("masonha"));
                order.setDuong(rs.getString("duong"));
                order.setPhuong(rs.getString("phuong"));
                order.setQuan(rs.getString("quan"));
                order.setTinh(rs.getString("tinh"));
                order.setNgaydat(rs.getString("ngaydat"));
                order.setPttt(rs.getString("pttt"));
                order.setTinhtrang(rs.getString("tinhtrang"));
                order.setTongtien(rs.getDouble("tongtien"));
                order.setGhichu(rs.getString("ghichu"));
                order.setNguoinhan(rs.getString("nguoinhan"));
                order.setSdt_nguoinhan(rs.getInt("sdt_nguoinhan"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return order;
    }
    
}
