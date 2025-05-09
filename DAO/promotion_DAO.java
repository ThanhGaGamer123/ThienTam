package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.promotion_DTO;

public class promotion_DAO implements DAO<promotion_DTO> {
    @Override
    public int add(promotion_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO ChuongTrinhKhuyenMai (makm, tenkm, ngaybatdau, ngayketthuc, giam, noidung, diem, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakm());
            pst.setString(2, t.getTenkm());
            pst.setString(3, t.getNgaybatdau());
            pst.setString(4, t.getNgayketthuc());
            pst.setInt(5, t.getGiam());
            pst.setString(6, t.getNoidung());
            pst.setInt(7, t.getDiem());
            pst.setBoolean(8, t.getTinhtrang());

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
    public int update(promotion_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE ChuongTrinhKhuyenMai SET tenkm = ?, ngaybatdau = ?, ngayketthuc = ?, giam = ?, noidung = ?, diem = ?, tinhtrang = ? WHERE makm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getTenkm());
            pst.setString(2, t.getNgaybatdau());
            pst.setString(3, t.getNgayketthuc());
            pst.setInt(4, t.getGiam());
            pst.setString(5, t.getNoidung());
            pst.setInt(6, t.getDiem());
            pst.setBoolean(7, t.getTinhtrang());
            pst.setString(8, t.getMakm());

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

    public int update1(promotion_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE ChuongTrinhKhuyenMai SET tenkm = ?, ngaybatdau = ?, ngayketthuc = ?, giam = ?, noidung = ?, diem = ?, tinhtrang = ? WHERE makm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getTenkm());
            pst.setString(2, t.getNgaybatdau());
            pst.setString(3, t.getNgayketthuc());
            pst.setInt(4, t.getGiam());
            pst.setString(5, t.getNoidung());
            pst.setInt(6, t.getDiem());
            pst.setBoolean(7, false);
            pst.setString(8, t.getMakm());

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

    public String autoUpdateMaKM() {
        String maKM = null;
        Connection con = data.SQL.createConnection();
        try (PreparedStatement ps = con
                .prepareStatement("select top 1 makm from ChuongTrinhKhuyenMai order by makm desc")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maKM = rs.getString("makm");
                int newMaKM = Integer.parseInt(maKM.substring(2)) + 1;
                maKM = String.format("KM%04d", newMaKM);
            } else {
                maKM = "KM0001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(con);
        }
        return maKM;
    }

    @Override
    public int delete(promotion_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM ChuongTrinhKhuyenMai WHERE makm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakm());

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
    public ArrayList<promotion_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<promotion_DTO> promotions = new ArrayList<>();
        String command = "SELECT * FROM ChuongTrinhKhuyenMai";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                promotion_DTO promotion = new promotion_DTO();
                promotion.setMakm(rs.getString("makm"));
                promotion.setTenkm(rs.getString("tenkm"));
                promotion.setNgaybatdau(rs.getString("ngaybatdau"));
                promotion.setNgayketthuc(rs.getString("ngayketthuc"));
                promotion.setGiam(rs.getInt("giam"));
                promotion.setNoidung(rs.getString("noidung"));
                promotion.setDiem(rs.getInt("diem"));
                promotion.setTinhtrang(rs.getBoolean("tinhtrang"));
                promotions.add(promotion);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return promotions;
    }

    @Override
    public ArrayList<promotion_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<promotion_DTO> promotions = new ArrayList<>();
        String command = "SELECT * FROM ChuongTrinhKhuyenMai WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                promotion_DTO promotion = new promotion_DTO();
                promotion.setMakm(rs.getString("makm"));
                promotion.setTenkm(rs.getString("tenkm"));
                promotion.setNgaybatdau(rs.getString("ngaybatdau"));
                promotion.setNgayketthuc(rs.getString("ngayketthuc"));
                promotion.setGiam(rs.getInt("giam"));
                promotion.setNoidung(rs.getString("noidung"));
                promotion.setDiem(rs.getInt("diem"));
                promotion.setTinhtrang(rs.getBoolean("tinhtrang"));
                promotions.add(promotion);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return promotions;
    }

    @Override
    public promotion_DTO selectByID(promotion_DTO t) {
        Connection sql = data.SQL.createConnection();

        promotion_DTO promotion = new promotion_DTO();
        String command = "SELECT * FROM ChuongTrinhKhuyenMai WHERE makm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMakm());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                promotion.setMakm(rs.getString("makm"));
                promotion.setTenkm(rs.getString("tenkm"));
                promotion.setNgaybatdau(rs.getString("ngaybatdau"));
                promotion.setNgayketthuc(rs.getString("ngayketthuc"));
                promotion.setGiam(rs.getInt("giam"));
                promotion.setNoidung(rs.getString("noidung"));
                promotion.setDiem(rs.getInt("diem"));
                promotion.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return promotion;
    }
    
}
