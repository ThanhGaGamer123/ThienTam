package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.promotion_details_DTO;

public class promotion_details_DAO implements DAO<promotion_details_DTO> {
    @Override
    public int add(promotion_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO ChiTietKM (mactkm, madon, makm, ngayapdung, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactkm());
            pst.setString(2, t.getMadon());
            pst.setString(3, t.getMakm());
            pst.setString(4, t.getNgayapdung());
            pst.setBoolean(5, t.getTinhtrang());

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
    public int update(promotion_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE ChiTietKM SET madon = ?, makm = ?, ngayapdung = ?, tinhtrang = ? WHERE mactkm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMadon());
            pst.setString(2, t.getMakm());
            pst.setString(3, t.getNgayapdung());
            pst.setBoolean(4, t.getTinhtrang());
            pst.setString(5, t.getMactkm());

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
    public int delete(promotion_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM ChiTietKM WHERE mactkm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactkm());

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
    public ArrayList<promotion_details_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<promotion_details_DTO> promotionDetails = new ArrayList<>();
        String command = "SELECT * FROM ChiTietKM";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                promotion_details_DTO promotionDetail = new promotion_details_DTO();
                promotionDetail.setMactkm(rs.getString("mactkm"));
                promotionDetail.setMadon(rs.getString("madon"));
                promotionDetail.setMakm(rs.getString("makm"));
                promotionDetail.setNgayapdung(rs.getString("ngayapdung"));
                promotionDetail.setTinhtrang(rs.getBoolean("tinhtrang"));
                promotionDetails.add(promotionDetail);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return promotionDetails;
    }

    @Override
    public ArrayList<promotion_details_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<promotion_details_DTO> promotionDetails = new ArrayList<>();
        String command = "SELECT * FROM ChiTietKM WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                promotion_details_DTO promotionDetail = new promotion_details_DTO();
                promotionDetail.setMactkm(rs.getString("mactkm"));
                promotionDetail.setMadon(rs.getString("madon"));
                promotionDetail.setMakm(rs.getString("makm"));
                promotionDetail.setNgayapdung(rs.getString("ngayapdung"));
                promotionDetail.setTinhtrang(rs.getBoolean("tinhtrang"));
                promotionDetails.add(promotionDetail);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return promotionDetails;
    }

    @Override
    public promotion_details_DTO selectByID(promotion_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        promotion_details_DTO promotionDetail = new promotion_details_DTO();
        String command = "SELECT * FROM ChiTietKM WHERE mactkm = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactkm());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                promotionDetail.setMactkm(rs.getString("mactkm"));
                promotionDetail.setMadon(rs.getString("madon"));
                promotionDetail.setMakm(rs.getString("makm"));
                promotionDetail.setNgayapdung(rs.getString("ngayapdung"));
                promotionDetail.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return promotionDetail;
    }
    
}
