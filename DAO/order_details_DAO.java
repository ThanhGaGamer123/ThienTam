package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.order_details_DTO;

public class order_details_DAO implements DAO<order_details_DTO> {
    @Override
    public int add(order_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO ChiTietDonHang (mactdh, sl, thanhtien, madon, dongia, macthdnhap, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactdh());
            pst.setInt(2, t.getSl());
            pst.setDouble(3, t.getThanhtien());
            pst.setString(4, t.getMadon());
            pst.setDouble(5, t.getDongia());
            pst.setString(6, t.getMacthdnhap());
            pst.setBoolean(7, t.getTinhtrang());

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
    public int update(order_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE ChiTietDonHang SET sl = ?, thanhtien = ?, madon = ?, dongia = ?, macthdnhap = ?, tinhtrang = ? WHERE mactdh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setInt(1, t.getSl());
            pst.setDouble(2, t.getThanhtien());
            pst.setString(3, t.getMadon());
            pst.setDouble(4, t.getDongia());
            pst.setString(5, t.getMacthdnhap());
            pst.setBoolean(6, t.getTinhtrang());
            pst.setString(7, t.getMactdh());

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
    public int delete(order_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM ChiTietDonhang WHERE mactdh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactdh());

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
    public ArrayList<order_details_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<order_details_DTO> orderDetails = new ArrayList<>();
        String command = "SELECT * FROM ChiTietDonHang";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                order_details_DTO orderDetail = new order_details_DTO();
                orderDetail.setMactdh(rs.getString("mactdh"));
                orderDetail.setSl(rs.getInt("sl"));
                orderDetail.setMadon(rs.getString("madon"));
                orderDetail.setThanhtien(rs.getDouble("thanhtien"));
                orderDetail.setDongia(rs.getDouble("dongia"));
                orderDetail.setMacthdnhap(rs.getString("macthdnhap"));
                orderDetail.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderDetails.add(orderDetail);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderDetails;
    }

    @Override
    public ArrayList<order_details_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<order_details_DTO> orderDetails = new ArrayList<>();
        String command = "SELECT * FROM ChiTietDonHang WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                order_details_DTO orderDetail = new order_details_DTO();
                orderDetail.setMactdh(rs.getString("mactdh"));
                orderDetail.setSl(rs.getInt("sl"));
                orderDetail.setMadon(rs.getString("madon"));
                orderDetail.setThanhtien(rs.getDouble("thanhtien"));
                orderDetail.setDongia(rs.getDouble("dongia"));
                orderDetail.setMacthdnhap(rs.getString("macthdnhap"));
                orderDetail.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderDetails.add(orderDetail);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderDetails;
    }

    @Override
    public order_details_DTO selectByID(order_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        order_details_DTO orderDetail = new order_details_DTO();
        String command = "SELECT * FROM ChiTietDonHang WHERE mactdh = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMactdh());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                orderDetail.setMactdh(rs.getString("mactdh"));
                orderDetail.setSl(rs.getInt("sl"));
                orderDetail.setMadon(rs.getString("madon"));
                orderDetail.setThanhtien(rs.getDouble("thanhtien"));
                orderDetail.setDongia(rs.getDouble("dongia"));
                orderDetail.setMacthdnhap(rs.getString("macthdnhap"));
                orderDetail.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderDetail;
    }
    
}
