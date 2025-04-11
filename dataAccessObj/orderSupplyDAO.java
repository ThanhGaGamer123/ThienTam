package dataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import orderSupply.orderSupply;

public class orderSupplyDAO implements DAO<orderSupply> {
    @Override
    public int add(orderSupply t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO HoaDonNhap (mahdnhap, mancc, soloaithuoc, ngaynhap, tongtien, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMahdnhap());
            pst.setString(2, t.getMancc());
            pst.setInt(3, t.getSoloaithuoc());
            pst.setString(4, t.getNgaynhap());
            pst.setInt(5, t.getTongtien());
            pst.setBoolean(6, t.getTinhtrang());

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
    public int update(orderSupply t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE HoaDonNhap SET mancc = ?, soloaithuoc = ?, ngaynhap = ?, tongtien = ?, tinhtrang = ? WHERE mahdnhap = ?" + 
        "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMancc());
            pst.setInt(2, t.getSoloaithuoc());
            pst.setString(3, t.getNgaynhap());
            pst.setInt(4, t.getTongtien());
            pst.setBoolean(5, t.getTinhtrang());
            pst.setString(6, t.getMahdnhap());

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
    public int delete(orderSupply t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM HoaDonNhap WHERE mahdnhap = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMahdnhap());

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
    public ArrayList<orderSupply> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<orderSupply> orderSupplies = new ArrayList<>();
        String command = "SELECT * FROM HoaDonNhap";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                orderSupply orderSupply = new orderSupply();
                orderSupply.setMahdnhap(rs.getString("mahdnhap"));
                orderSupply.setMancc(rs.getString("mancc"));
                orderSupply.setNgaynhap(rs.getString("ngaynhap"));
                orderSupply.setSoloaithuoc(rs.getInt("soloaithuoc"));
                orderSupply.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderSupply.setTongtien(rs.getInt("tongtien"));
                orderSupplies.add(orderSupply);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderSupplies;
    }

    @Override
    public ArrayList<orderSupply> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<orderSupply> orderSupplies = new ArrayList<>();
        String command = "SELECT * FROM HoaDonNhap WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                orderSupply orderSupply = new orderSupply();
                orderSupply.setMahdnhap(rs.getString("mahdnhap"));
                orderSupply.setMancc(rs.getString("mancc"));
                orderSupply.setNgaynhap(rs.getString("ngaynhap"));
                orderSupply.setSoloaithuoc(rs.getInt("soloaithuoc"));
                orderSupply.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderSupply.setTongtien(rs.getInt("tongtien"));
                orderSupplies.add(orderSupply);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderSupplies;
    }

    @Override
    public orderSupply selectByID(orderSupply t) {
        Connection sql = data.SQL.createConnection();

        orderSupply orderSupply = new orderSupply();
        String command = "SELECT * FROM HoaDonNhap WHERE mahdnhap = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMahdnhap());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                orderSupply.setMahdnhap(rs.getString("mahdnhap"));
                orderSupply.setMancc(rs.getString("mancc"));
                orderSupply.setNgaynhap(rs.getString("ngaynhap"));
                orderSupply.setSoloaithuoc(rs.getInt("soloaithuoc"));
                orderSupply.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderSupply.setTongtien(rs.getInt("tongtien"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderSupply;
    }
    
}
