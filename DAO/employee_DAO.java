package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.employee_DTO;

public class employee_DAO implements DAO<employee_DTO> {
    @Override
    public int add(employee_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO NhanVien (manv, tennv, chucvu, gioitinh, cccd, sdt, masonha, duong, phuong, quan, tinh, username, passwordnv, manhathuoc, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getManv());
            pst.setString(2, t.getTennv());
            pst.setString(3, t.getChucvu());
            pst.setString(4, t.getGioitinh());
            pst.setString(5, t.getCccd());
            pst.setString(6, t.getSdt());
            pst.setString(7, t.getMasonha());
            pst.setString(8, t.getDuong());
            pst.setString(9, t.getPhuong());
            pst.setString(10, t.getQuan());
            pst.setString(11, t.getTinh());
            pst.setString(12, t.getUsername());
            pst.setString(13, t.getPassword());
            pst.setString(14, t.getManhathuoc());
            pst.setBoolean(15, t.getTinhtrang());

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
    public int update(employee_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE NhanVien SET tennv = ?, chucvu = ?, gioitinh = ?, cccd = ?, sdt = ?, masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, username = ?, passwordnv = ?, manhathuoc = ?, tinhtrang = ? WHERE manv = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getTennv());
            pst.setString(2, t.getChucvu());
            pst.setString(3, t.getGioitinh());
            pst.setString(4, t.getCccd());
            pst.setString(5, t.getSdt());
            pst.setString(6, t.getMasonha());
            pst.setString(7, t.getDuong());
            pst.setString(8, t.getPhuong());
            pst.setString(9, t.getQuan());
            pst.setString(10, t.getTinh());
            pst.setString(11, t.getUsername());
            pst.setString(12, t.getPassword());
            pst.setString(13, t.getManhathuoc());
            pst.setBoolean(14, t.getTinhtrang());
            pst.setString(15, t.getManv());

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

    public int update1(employee_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE NhanVien SET tennv = ?, chucvu = ?, gioitinh = ?, cccd = ?, sdt = ?, masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, username = ?, passwordnv = ?, manhathuoc = ?, tinhtrang = ? WHERE manv = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getTennv());
            pst.setString(2, t.getChucvu());
            pst.setString(3, t.getGioitinh());
            pst.setString(4, t.getCccd());
            pst.setString(5, t.getSdt());
            pst.setString(6, t.getMasonha());
            pst.setString(7, t.getDuong());
            pst.setString(8, t.getPhuong());
            pst.setString(9, t.getQuan());
            pst.setString(10, t.getTinh());
            pst.setString(11, t.getUsername());
            pst.setString(12, t.getPassword());
            pst.setString(13, t.getManhathuoc());
            pst.setBoolean(14, false);
            pst.setString(15, t.getManv());

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

    public String autoUpdateMaNV() {
        String maNV = null;
        Connection con = data.SQL.createConnection();
        try (PreparedStatement ps = con.prepareStatement("select top 1 manv from NhanVien order by manv desc")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maNV = rs.getString("manv");
                int newMaNV = Integer.parseInt(maNV.substring(2)) + 1;
                maNV = String.format("NV%04d", newMaNV);
            } else {
                maNV = "NV0001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(con);
        }
        return maNV;
    }

    @Override
    public int delete(employee_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM NhanVien WHERE manv = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getManv());

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
    public ArrayList<employee_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<employee_DTO> employees = new ArrayList<>();
        String command = "SELECT * FROM NhanVien";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                employee_DTO em = new employee_DTO();
                em.setManv(rs.getString("manv"));
                em.setTennv(rs.getString("tennv"));
                em.setChucvu(rs.getString("chucvu"));
                em.setGioitinh(rs.getString("gioitinh"));
                em.setCccd(rs.getString("cccd"));
                em.setSdt(rs.getString("sdt"));
                em.setMasonha(rs.getString("masonha"));
                em.setDuong(rs.getString("duong"));
                em.setPhuong(rs.getString("phuong"));
                em.setQuan(rs.getString("quan"));
                em.setTinh(rs.getString("tinh"));
                em.setUsername(rs.getString("username"));
                em.setPassword(rs.getString("passwordnv"));
                em.setManhathuoc(rs.getString("manhathuoc"));
                em.setTinhtrang(rs.getBoolean("tinhtrang"));
                employees.add(em);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return employees;
    }

    @Override
    public ArrayList<employee_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<employee_DTO> employees = new ArrayList<>();
        String command = "SELECT * FROM NhanVien WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                employee_DTO em = new employee_DTO();
                em.setManv(rs.getString("manv"));
                em.setTennv(rs.getString("tennv"));
                em.setChucvu(rs.getString("chucvu"));
                em.setGioitinh(rs.getString("gioitinh"));
                em.setCccd(rs.getString("cccd"));
                em.setSdt(rs.getString("sdt"));
                em.setMasonha(rs.getString("masonha"));
                em.setDuong(rs.getString("duong"));
                em.setPhuong(rs.getString("phuong"));
                em.setQuan(rs.getString("quan"));
                em.setTinh(rs.getString("tinh"));
                em.setUsername(rs.getString("username"));
                em.setPassword(rs.getString("passwordnv"));
                em.setManhathuoc(rs.getString("manhathuoc"));
                em.setTinhtrang(rs.getBoolean("tinhtrang"));
                employees.add(em);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return employees;
    }

    @Override
    public employee_DTO selectByID(employee_DTO t) {
        Connection sql = data.SQL.createConnection();

        employee_DTO em = new employee_DTO();
        String command = "SELECT * FROM NhanVien WHERE manv = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getManv());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                em.setManv(rs.getString("manv"));
                em.setTennv(rs.getString("tennv"));
                em.setChucvu(rs.getString("chucvu"));
                em.setGioitinh(rs.getString("gioitinh"));
                em.setCccd(rs.getString("cccd"));
                em.setSdt(rs.getString("sdt"));
                em.setMasonha(rs.getString("masonha"));
                em.setDuong(rs.getString("duong"));
                em.setPhuong(rs.getString("phuong"));
                em.setQuan(rs.getString("quan"));
                em.setTinh(rs.getString("tinh"));
                em.setUsername(rs.getString("username"));
                em.setPassword(rs.getString("passwordnv"));
                em.setManhathuoc(rs.getString("manhathuoc"));
                em.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return em;
    }
}
