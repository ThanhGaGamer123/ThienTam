package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.supplier_DTO;

public class supplier_DAO implements DAO<supplier_DTO> {
    @Override
    public int add(supplier_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO NhaCungCap (mancc, tenncc, sdt, masonha, duong, phuong, quan, tinh, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMancc());
            pst.setString(2, t.getTenncc());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getMasonha());
            pst.setString(5, t.getDuong());
            pst.setString(6, t.getPhuong());
            pst.setString(7, t.getQuan());
            pst.setString(8, t.getTinh());
            pst.setBoolean(9, t.getTinhtrang());

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
    public int update(supplier_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE NhaCungCap SET tenncc = ?, sdt = ?, masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, tinhtrang = ? WHERE mancc = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getTenncc());
            pst.setString(2, t.getSdt());
            pst.setString(3, t.getMasonha());
            pst.setString(4, t.getDuong());
            pst.setString(5, t.getPhuong());
            pst.setString(6, t.getQuan());
            pst.setString(7, t.getTinh());
            pst.setBoolean(8, t.getTinhtrang());
            pst.setString(9, t.getMancc());

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
    public int delete(supplier_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM NhaCungCap WHERE mancc = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMancc());

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
    public ArrayList<supplier_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<supplier_DTO> suppliers = new ArrayList<>();
        String command = "SELECT * FROM NhaCungCap";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                supplier_DTO sup = new supplier_DTO();
                sup.setMancc(rs.getString("mancc"));
                sup.setTenncc(rs.getString("tenncc"));
                sup.setSdt(rs.getString("sdt"));
                sup.setMasonha(rs.getString("masonha"));
                sup.setDuong(rs.getString("duong"));
                sup.setPhuong(rs.getString("phuong"));
                sup.setQuan(rs.getString("quan"));
                sup.setTinh(rs.getString("tinh"));
                sup.setTinhtrang(rs.getBoolean("tinhtrang"));
                suppliers.add(sup);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return suppliers;
    }

    @Override
    public ArrayList<supplier_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<supplier_DTO> suppliers = new ArrayList<>();
        String command = "SELECT * FROM NhaCungCap WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                supplier_DTO sup = new supplier_DTO();
                sup.setMancc(rs.getString("mancc"));
                sup.setTenncc(rs.getString("tenncc"));
                sup.setSdt(rs.getString("sdt"));
                sup.setMasonha(rs.getString("masonha"));
                sup.setDuong(rs.getString("duong"));
                sup.setPhuong(rs.getString("phuong"));
                sup.setQuan(rs.getString("quan"));
                sup.setTinh(rs.getString("tinh"));
                sup.setTinhtrang(rs.getBoolean("tinhtrang"));
                suppliers.add(sup);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return suppliers;
    }

    @Override
    public supplier_DTO selectByID(supplier_DTO t) {
        Connection sql = data.SQL.createConnection();

        supplier_DTO sup = new supplier_DTO();
        String command = "SELECT * FROM NhaCungCap WHERE mancc = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMancc());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                sup.setMancc(rs.getString("mancc"));
                sup.setTenncc(rs.getString("tenncc"));
                sup.setSdt(rs.getString("sdt"));
                sup.setMasonha(rs.getString("masonha"));
                sup.setDuong(rs.getString("duong"));
                sup.setPhuong(rs.getString("phuong"));
                sup.setQuan(rs.getString("quan"));
                sup.setTinh(rs.getString("tinh"));
                sup.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return sup;
    }
    
}
