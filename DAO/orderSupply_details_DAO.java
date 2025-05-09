package DAO;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import DTO.orderSupply_details_DTO;
import advanceMethod.advance;

public class orderSupply_details_DAO implements DAO<orderSupply_details_DTO> {
    @Override
    public int add(orderSupply_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO ChiTietHoaDonNhap (macthdnhap, mahdnhap, gianhap, thanhtien, slnhap, slcon, mathuoc, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMacthdnhap());
            pst.setString(2, t.getMahdnhap());
            pst.setString(3, advance.DoubleArrayListToString(t.getGianhap()));
            pst.setDouble(4, t.getThanhtien());
            pst.setString(5, advance.IntArrayListToString(t.getSlnhap()));
            pst.setString(6, advance.IntArrayListToString(t.getSlcon()));
            pst.setString(7, t.getMathuoc());
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
    public int update(orderSupply_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE ChiTietHoaDonNhap SET mahdnhap = ?, gianhap = ?, thanhtien = ?, slnhap = ?, slcon = ?, mathuoc = ?, tinhtrang = ? WHERE macthdnhap = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMahdnhap());
            pst.setString(2, advance.DoubleArrayListToString(t.getGianhap()));
            pst.setDouble(3, t.getThanhtien());
            pst.setString(4, advance.IntArrayListToString(t.getSlnhap()));
            pst.setString(5, advance.IntArrayListToString(t.getSlcon()));
            pst.setString(6, t.getMathuoc());
            pst.setBoolean(7, t.getTinhtrang());
            pst.setString(8, t.getMacthdnhap());

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
    public int delete(orderSupply_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM ChiTietHoaDonNhap WHERE macthdnhap = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMacthdnhap());

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
    public ArrayList<orderSupply_details_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<orderSupply_details_DTO> orderSupply_details = new ArrayList<>();
        String command = "SELECT * FROM ChiTietHoaDonNhap";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                orderSupply_details_DTO order = new orderSupply_details_DTO();
                order.setMacthdnhap(rs.getString("macthdnhap"));
                order.setMahdnhap(rs.getString("mahdnhap"));
                order.setMathuoc(rs.getString("mathuoc"));
                order.setSlnhap(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slnhap"))));
                order.setSlcon(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slcon"))));
                order.setGianhap(advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("gianhap"))));
                order.setThanhtien(rs.getDouble("thanhtien"));
                order.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderSupply_details.add(order);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderSupply_details;
    }

    @Override
    public ArrayList<orderSupply_details_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<orderSupply_details_DTO> orderSupply_details = new ArrayList<>();
        String command = "SELECT * FROM ChiTietHoaDonNhap WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                orderSupply_details_DTO order = new orderSupply_details_DTO();
                order.setMacthdnhap(rs.getString("macthdnhap"));
                order.setMahdnhap(rs.getString("mahdnhap"));
                order.setMathuoc(rs.getString("mathuoc"));
                order.setSlnhap(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slnhap"))));
                order.setSlcon(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slcon"))));
                order.setGianhap(advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("gianhap"))));
                order.setThanhtien(rs.getDouble("thanhtien"));
                order.setTinhtrang(rs.getBoolean("tinhtrang"));
                orderSupply_details.add(order);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderSupply_details;
    }

    @Override
    public orderSupply_details_DTO selectByID(orderSupply_details_DTO t) {
        Connection sql = data.SQL.createConnection();

        orderSupply_details_DTO order = new orderSupply_details_DTO();
        String command = "SELECT * FROM ChiTietHoaDonNhap WHERE macthdnhap = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMacthdnhap());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                order.setMacthdnhap(rs.getString("macthdnhap"));
                order.setMahdnhap(rs.getString("mahdnhap"));
                order.setMathuoc(rs.getString("mathuoc"));
                order.setSlnhap(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slnhap"))));
                order.setSlcon(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slcon"))));
                order.setGianhap(advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("gianhap"))));
                order.setThanhtien(rs.getDouble("thanhtien"));
                order.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return order;
    }
    
    public static void selectAllToOrderSupply(DefaultTableModel modelSupply, String mahdnhap) {
        modelSupply.setRowCount(0);
        
        String command = "select macthdnhap, tenthuoc, slnhap, gianhap, thanhtien, slcon, ChiTietHoaDonNhap.tinhtrang from ChiTietHoaDonNhap, Thuoc where ChiTietHoaDonNhap.mathuoc = Thuoc.mathuoc and mahdnhap = '" + mahdnhap + "'";
        Connection sql = data.SQL.createConnection();

        try {
            PreparedStatement pst = sql.prepareStatement(command);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String macthdnhap = rs.getString("macthdnhap");
                String tenthuoc = rs.getString("tenthuoc");
                ArrayList<Integer> slnhap = advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slnhap")));
                ArrayList<Double> gianhap = advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("gianhap")));
                double thanhtien = rs.getDouble("thanhtien");
                ArrayList<Integer> slcon = advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slcon")));
                Boolean tinhtrang = rs.getBoolean("tinhtrang");
                JLabel statusImg;
                if(tinhtrang) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                 JButton deleteButton = new JButton("Thu hồi");
                deleteButton.setForeground(Color.BLACK);
                deleteButton.setFont(new Font(null, Font.PLAIN, 18));
                String SLnhap = String.join(";", advance.IntArrayListToStringArrayList(slnhap));
                String GIAnhap = String.join(";", advance.DoubleArrayListToStringArrayList(gianhap));
                String SLcon = String.join(";", advance.IntArrayListToStringArrayList(slcon));
                modelSupply.addRow(new Object[]{macthdnhap, tenthuoc, SLnhap, GIAnhap, thanhtien, SLcon, statusImg, deleteButton});
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }
}
