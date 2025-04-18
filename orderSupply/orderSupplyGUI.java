package orderSupply;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import advanceMethod.advance;

public class orderSupplyGUI extends JFrame {
    public orderSupplyGUI(String mahdnhap) {
        this.setSize(1400, 600);
        this.setTitle("Thông tin đơn nhập");
        ImageIcon logo = new ImageIcon(advance.img+"logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel main = new JPanel();
        main.setBackground(Color.white);
        main.setLayout(new GridBagLayout());

        JScrollPane scroll_frame = new JScrollPane();
        scroll_frame.setViewportView(main);

        this.getContentPane().add(scroll_frame, BorderLayout.CENTER);

        GridBagConstraints gdc = new GridBagConstraints();

        JLabel title = new JLabel("Thông Tin Hóa Đơn Nhập");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        String[] columns = {"Mã chi tiết đơn nhập", "Tên thuốc", "Số lượng nhập", "Giá nhập", "Thành tiền", "Số lượng còn", "Tình trạng"};
        DefaultTableModel modelSupply = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableSupply = new JTable(modelSupply);
        tableSupply.setFont(new Font(null, Font.PLAIN, 18));
        tableSupply.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableSupply.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        tableSupply.getTableHeader().setResizingAllowed(false);
        tableSupply.getTableHeader().setReorderingAllowed(false);
        tableSupply.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        tableSupply.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableSupply.getColumnCount(); i++) {
            tableSupply.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_supply = new JScrollPane();
        scroll_supply.setViewportView(tableSupply);
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 20, 30, 20);
        main.add(scroll_supply, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //tự động cập nhật thông tin
        updateTableSupplier(modelSupply, mahdnhap);

        tableSupply.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                        JLabel label = (value instanceof JLabel) ? (JLabel) value : new JLabel();

                        if (isSelected) {
                            label.setBackground(new Color(173, 216, 230)); // Màu nền sáng
                            label.setOpaque(true); // Để màu nền có hiệu lực
                        } else {
                            label.setBackground(Color.WHITE); // Màu nền mặc định
                            label.setOpaque(true);
                        }

                        return label;
            }
        });
    }

    public static void updateTableSupplier(DefaultTableModel modelSupply, String mahdnhap) {
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
                ArrayList<Integer> gianhap = advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("gianhap")));
                int thanhtien = rs.getInt("thanhtien");
                ArrayList<Integer> slcon = advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slcon")));
                Boolean tinhtrang = rs.getBoolean("tinhtrang");
                JLabel statusImg;
                if(tinhtrang) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                String SLnhap = String.join(";", advance.IntArrayListToStringArrayList(slnhap));
                String GIAnhap = String.join(";", advance.IntArrayListToStringArrayList(gianhap));
                String SLcon = String.join(";", advance.IntArrayListToStringArrayList(slcon));
                modelSupply.addRow(new Object[]{macthdnhap, tenthuoc, SLnhap, GIAnhap, thanhtien, SLcon, statusImg});
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }

    public static void main(String[] args) {
        new orderSupplyGUI(null);
    }
}
