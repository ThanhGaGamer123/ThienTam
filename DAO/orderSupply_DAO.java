package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import DTO.orderSupply_DTO;

public class orderSupply_DAO implements DAO<orderSupply_DTO> {
    @Override
    public int add(orderSupply_DTO t) {
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
    public int update(orderSupply_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE HoaDonNhap SET mancc = ?, soloaithuoc = ?, ngaynhap = ?, tongtien = ?, tinhtrang = ? WHERE mahdnhap = ?";

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
    public int delete(orderSupply_DTO t) {
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
    public ArrayList<orderSupply_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<orderSupply_DTO> orderSupplies = new ArrayList<>();
        String command = "SELECT * FROM HoaDonNhap";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                orderSupply_DTO orderSupply = new orderSupply_DTO();
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
    public ArrayList<orderSupply_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<orderSupply_DTO> orderSupplies = new ArrayList<>();
        String command = "SELECT * FROM HoaDonNhap WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                orderSupply_DTO orderSupply = new orderSupply_DTO();
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
    public orderSupply_DTO selectByID(orderSupply_DTO t) {
        Connection sql = data.SQL.createConnection();

        orderSupply_DTO orderSupply = new orderSupply_DTO();
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

    public void loadData(DefaultTableModel modelOrderSupply) {
        modelOrderSupply.setRowCount(0);
        
        String command = "select mahdnhap, tenncc, soloaithuoc, ngaynhap, tongtien, HoaDonNhap.tinhtrang from HoaDonNhap, NhaCungCap where HoaDonNhap.mancc = NhaCungCap.mancc";
        Connection sql = data.SQL.createConnection();

        try {
            PreparedStatement pst = sql.prepareStatement(command);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mahdnhap = rs.getString("mahdnhap");
                String tenncc = rs.getString("tenncc");
                int soloaithuoc = rs.getInt("soloaithuoc");
                String ngaynhap = rs.getString("ngaynhap");
                int tongtien = rs.getInt("tongtien");
                Boolean tinhtrang = rs.getBoolean("tinhtrang");
                JLabel statusImg;
                if(tinhtrang) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                JButton eyeButton = new JButton(data.imagePath.resize_eye);
                modelOrderSupply.addRow(new Object[]{mahdnhap, tenncc, soloaithuoc, ngaynhap, tongtien, statusImg, eyeButton});
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }
    
    public void selectAllToArrayList(ArrayList<orderSupply_DTO> orderSupplies) {
        String command = "select * from HoaDonNhap";
        Connection sql = data.SQL.createConnection();
        orderSupplies.clear();

        try {
            PreparedStatement pst = sql.prepareStatement(command);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                orderSupply_DTO orderSupply = new orderSupply_DTO();
                orderSupply.setMahdnhap(rs.getString("mahdnhap"));
                orderSupply.setMancc(rs.getString("mancc"));
                orderSupply.setNgaynhap(rs.getString("ngaynhap"));
                orderSupply.setSoloaithuoc(rs.getInt("soloaithuoc"));
                orderSupply.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderSupply.setTongtien(rs.getInt("tongtien"));
                orderSupplies.add(orderSupply);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }
}
