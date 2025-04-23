package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.cart_DTO;

public class cart_DAO implements DAO<cart_DTO> {
    @Override
    public int add(cart_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO GioHang (makh, mathuoc, soluong, thanhtien, dongia)" + 
        "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakh());
            pst.setString(2, t.getMathuoc());
            pst.setInt(3, t.getSl());
            pst.setDouble(4, t.getThanhtien());
            pst.setDouble(5, t.getDongia());

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
    public int update(cart_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE GioHang SET mathuoc = ?, soluong = ?, thanhtien = ?, dongia = ? WHERE makh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMathuoc());
            pst.setInt(2, t.getSl());
            pst.setDouble(3, t.getThanhtien());
            pst.setDouble(4, t.getDongia());
            pst.setString(5, t.getMakh());

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
    public int delete(cart_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM GioHang WHERE makh = ?";

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
    public ArrayList<cart_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<cart_DTO> carts = new ArrayList<>();
        String command = "SELECT * FROM GioHang";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cart_DTO cart = new cart_DTO();
                cart.setMakh(rs.getString("makh"));
                cart.setMathuoc(rs.getString("mathuoc"));
                cart.setSl(rs.getInt("soluong"));
                cart.setThanhtien(rs.getDouble("thanhtien"));
                cart.setDongia(rs.getDouble("dongia"));
                carts.add(cart);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return carts;
    }

    @Override
    public ArrayList<cart_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<cart_DTO> carts = new ArrayList<>();
        String command = "SELECT * FROM GioHang WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cart_DTO cart = new cart_DTO();
                cart.setMakh(rs.getString("makh"));
                cart.setMathuoc(rs.getString("mathuoc"));
                cart.setSl(rs.getInt("soluong"));
                cart.setThanhtien(rs.getDouble("thanhtien"));
                cart.setDongia(rs.getDouble("dongia"));
                carts.add(cart);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return carts;
    }

    @Override
    public cart_DTO selectByID(cart_DTO t) {
        Connection sql = data.SQL.createConnection();

        cart_DTO cart = new cart_DTO();
        String command = "SELECT * FROM GioHang WHERE makh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakh());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cart.setMakh(rs.getString("makh"));
                cart.setMathuoc(rs.getString("mathuoc"));
                cart.setSl(rs.getInt("soluong"));
                cart.setThanhtien(rs.getDouble("thanhtien"));
                cart.setDongia(rs.getDouble("dongia"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return cart;
    }
    
}
