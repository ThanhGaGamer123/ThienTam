package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

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
            pst.setDouble(5, t.getTongtien());
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
            pst.setDouble(4, t.getTongtien());
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
                orderSupply.setTongtien(rs.getDouble("tongtien"));
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
                orderSupply.setTongtien(rs.getDouble("tongtien"));
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
                orderSupply.setTongtien(rs.getDouble("tongtien"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return orderSupply;
    }

    public void loadData(DefaultTableModel modelOrderSupply, Boolean flag) {
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
                double tongtien = rs.getDouble("tongtien");
                Boolean tinhtrang = rs.getBoolean("tinhtrang");
                JLabel statusImg;
                if (tinhtrang) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                JButton eyeButton = new JButton(data.imagePath.resize_eye);
                if (flag && tinhtrang)
                    modelOrderSupply.addRow(
                            new Object[] { mahdnhap, tenncc, soloaithuoc, ngaynhap, tongtien, statusImg, eyeButton });
                if (!flag)
                    modelOrderSupply.addRow(
                            new Object[] { mahdnhap, tenncc, soloaithuoc, ngaynhap, tongtien, statusImg, eyeButton });
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
                orderSupply.setTongtien(rs.getDouble("tongtien"));
                orderSupplies.add(orderSupply);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }

    public JFreeChart createLineChart(String startmonth, String startyear, String endmonth, String endyear) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection con = data.SQL.createConnection();
            Statement st = con.createStatement();

            // Truy vấn nhóm theo tháng và năm
            StringBuilder query = new StringBuilder(
                    "SELECT SUBSTRING(ngaynhap, 13, 2) AS Thang, " +
                            "SUBSTRING(ngaynhap, 16, 4) AS Nam, " +
                            "SUM(tongtien) AS TongTienTheoThang " +
                            "FROM HoaDonNhap WHERE 1=1");

            // Thêm điều kiện lọc theo tháng và năm
            query.append(" AND SUBSTRING(ngaynhap, 13, 2) >= '").append(startmonth).append("'")
                    .append(" AND SUBSTRING(ngaynhap, 13, 2) <= '").append(endmonth).append("'");

            query.append(" AND SUBSTRING(ngaynhap, 16, 4) >= '").append(startyear).append("'")
                    .append(" AND SUBSTRING(ngaynhap, 16, 4) <= '").append(endyear).append("'");

            query.append(" GROUP BY SUBSTRING(ngaynhap, 13, 2), SUBSTRING(ngaynhap, 16, 4)" +
                    " ORDER BY Nam, Thang");

            ResultSet rs = st.executeQuery(query.toString());
            while (rs.next()) {
                int thang = Integer.parseInt(rs.getString("Thang")); // Lấy tháng
                int nam = Integer.parseInt(rs.getString("Nam")); // Lấy năm
                int tongTien = rs.getInt("TongTienTheoThang"); // Tổng tiền theo tháng

                // Tạo giá trị trục X dạng "Tháng.Năm" (ví dụ: "04.2025")
                String xValue = String.format("%02d.%d", thang, nam);
                dataset.addValue(tongTien, "Tổng tiền nhập hàng", xValue);
            }
            // Đóng kết nối
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createLineChart(
                "", // Tiêu đề
                "", // Nhãn trục X
                "", // Nhãn trục Y
                dataset, // Dataset
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, // Hiển thị legend
                true, // Hiển thị tooltips
                false // Không hiển thị URLs
        );
        return chart;

    }

}
