package GUI.order_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.order_BUS;
import advanceMethod.advance;

public class orderGUI extends JFrame {
    public orderGUI(String madh, DefaultTableModel modelSell, DefaultTableModel modelCollect) {
        this.setSize(1400, 800);
        this.setTitle("Thông tin đơn hàng");
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

        JLabel title = new JLabel("Thông Tin Đơn Hàng");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel title_ds = new JLabel("Danh Sách Chi Tiết Đơn Hàng");
        title_ds.setForeground(Color.BLACK);
        title_ds.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 9;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title_ds, gdc);

        JLabel mandon = new JLabel("Mã đơn:");
        mandon.setForeground(Color.BLACK);
        mandon.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(mandon, gdc);

        JTextField tf_mandon = new JTextField();
        tf_mandon.setForeground(Color.BLACK);
        tf_mandon.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 5;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_mandon, gdc);

        JLabel makh = new JLabel("Mã khách hàng:");
        makh.setForeground(Color.BLACK);
        makh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(makh, gdc);

        JTextField tf_makh = new JTextField();
        tf_makh.setForeground(Color.BLACK);
        tf_makh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_makh, gdc);
        
        JLabel tenkh = new JLabel("Tên khách hàng:");
        tenkh.setForeground(Color.BLACK);
        tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 20, 30, 0);
        main.add(tenkh, gdc);

        JTextField tf_tenkh = new JTextField();
        tf_tenkh.setForeground(Color.BLACK);
        tf_tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 2;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenkh, gdc);

        JLabel manv = new JLabel("Mã nhân viên:");
        manv.setForeground(Color.BLACK);
        manv.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(manv, gdc);

        JTextField tf_manv = new JTextField();
        tf_manv.setForeground(Color.BLACK);
        tf_manv.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_manv, gdc);
        
        JLabel tennv = new JLabel("Tên nhân viên:");
        tennv.setForeground(Color.BLACK);
        tennv.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 20, 30, 0);
        main.add(tennv, gdc);

        JTextField tf_tennv = new JTextField();
        tf_tennv.setForeground(Color.BLACK);
        tf_tennv.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 3;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tennv, gdc);

        JLabel diachi = new JLabel("Địa chỉ nhận hàng:");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(diachi, gdc);

        JTextArea ta_diachi = new JTextArea();
        ta_diachi.setForeground(Color.BLACK);
        ta_diachi.setFont(new Font(null, Font.PLAIN, 20));
        ta_diachi.setLineWrap(true);
        ta_diachi.setAutoscrolls(true);

        JScrollPane diachi_scroll = new JScrollPane();
        diachi_scroll.setViewportView(ta_diachi);
        diachi_scroll.setPreferredSize(new Dimension(0, 100));

        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 5;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(diachi_scroll, gdc);

        JLabel ngaydat = new JLabel("Thời gian đặt:");
        ngaydat.setForeground(Color.BLACK);
        ngaydat.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngaydat, gdc);

        JTextField tf_ngaydat = new JTextField();
        tf_ngaydat.setForeground(Color.BLACK);
        tf_ngaydat.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_ngaydat, gdc);
        
        JLabel tinhtrang = new JLabel("Tình trạng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 20, 30, 0);
        main.add(tinhtrang, gdc);

        String[] options = {"Đang xử lý", "Đã xử lý", "Đã giao", "Đã hủy"};
        JComboBox cb_tinhtrang = new JComboBox(options);
        cb_tinhtrang.setForeground(Color.BLACK);
        cb_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(cb_tinhtrang, gdc);

        JButton capnhat = new JButton("Cập nhật");
        capnhat.setForeground(Color.BLACK);
        capnhat.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 20, 30, 100);
        main.add(capnhat, gdc);

        JLabel tongtien = new JLabel("Tổng tiền:");
        tongtien.setForeground(Color.BLACK);
        tongtien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tongtien, gdc);

        JTextField tf_tongtien = new JTextField();
        tf_tongtien.setForeground(Color.BLACK);
        tf_tongtien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_tongtien, gdc);
        
        JLabel pttt = new JLabel("Phương thức thanh toán:");
        pttt.setForeground(Color.BLACK);
        pttt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 20, 30, 0);
        main.add(pttt, gdc);

        JTextField tf_pttt = new JTextField();
        tf_pttt.setForeground(Color.BLACK);
        tf_pttt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 6;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_pttt, gdc);

        JLabel ghichu = new JLabel("Ghi chú:");
        ghichu.setForeground(Color.BLACK);
        ghichu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ghichu, gdc);

        JTextArea ta_ghichu = new JTextArea();
        ta_ghichu.setForeground(Color.BLACK);
        ta_ghichu.setFont(new Font(null, Font.PLAIN, 20));
        ta_ghichu.setLineWrap(true);
        ta_ghichu.setAutoscrolls(true);

        JScrollPane ghichu_scroll = new JScrollPane();
        ghichu_scroll.setViewportView(ta_ghichu);
        ghichu_scroll.setPreferredSize(new Dimension(0, 100));

        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 5;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(ghichu_scroll, gdc);

        JLabel nguoinhan = new JLabel("Người nhận:");
        nguoinhan.setForeground(Color.BLACK);
        nguoinhan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(nguoinhan, gdc);

        JTextField tf_nguoinhan = new JTextField();
        tf_nguoinhan.setForeground(Color.BLACK);
        tf_nguoinhan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_nguoinhan, gdc);
        
        JLabel sdt_nguoinhan = new JLabel("SĐT người nhận:");
        sdt_nguoinhan.setForeground(Color.BLACK);
        sdt_nguoinhan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 20, 30, 0);
        main.add(sdt_nguoinhan, gdc);

        JTextField tf_sdt_nguoinhan = new JTextField();
        tf_sdt_nguoinhan.setForeground(Color.BLACK);
        tf_sdt_nguoinhan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 8;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_sdt_nguoinhan, gdc);

        String[] columns = {"Mã CTĐH", "Tên thuốc", "Đơn vị", "Số lượng", "Đơn giá", 
        "Thành tiền", "Mã CTĐHN", "Tình trạng", ""};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.setFont(new Font(null, Font.PLAIN, 18));
        table.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        table.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_supply = new JScrollPane();
        scroll_supply.setViewportView(table);
        gdc.gridx = 0;
        gdc.gridy = 10;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 100);
        main.add(scroll_supply, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //load dữ liệu đơn hàng
        order_BUS.loadOrder(madh, tf_mandon, tf_makh, tf_tenkh, tf_manv, tf_tennv, 
        ta_diachi, tf_ngaydat, cb_tinhtrang, tf_tongtien, tf_pttt, ta_ghichu, 
        tf_nguoinhan, tf_sdt_nguoinhan, model);

        table.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (value instanceof JLabel) ? (JLabel) value : new JLabel();

                // Thiết lập màu nền khi được chọn
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

        table.getColumn("").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = (value instanceof JButton) ? (JButton) value : new JButton();

                if (isSelected) {
                    button.setBackground(new Color(173, 216, 230)); // Màu nền sáng
                } else {
                    button.setBackground(Color.WHITE); // Màu nền mặc định
                }
        
                button.setOpaque(true);
                button.setBorderPainted(false); // Ẩn viền nút
                return button;
            }   
        });
    
        //cập nhật tình trạng đơn hàng
        capnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ketQua = order_BUS.updateStatus(cb_tinhtrang, madh);
                if(ketQua == 1) {
                    order_BUS.loadOrder(madh, tf_mandon, tf_makh, tf_tenkh, tf_manv, tf_tennv, 
                    ta_diachi, tf_ngaydat, cb_tinhtrang, tf_tongtien, tf_pttt, ta_ghichu, 
                    tf_nguoinhan, tf_sdt_nguoinhan, model);

                    order_BUS.loadData(modelSell);
                }
                if(ketQua == 2) {
                    JOptionPane.showMessageDialog(null, 
                    "Đơn hàng đã hủy.");
                }
                if(ketQua == 3) {
                    JOptionPane.showMessageDialog(null, 
                    "Đơn hàng đã xử lý.");
                }
                if(ketQua == 4) {
                    JOptionPane.showMessageDialog(null, 
                    "Đơn hàng đã giao.");
                }
            }
        });
    
        //thu hồi thuốc
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(order_BUS.deleteOrderDetail(model, table, modelCollect)) {
                    order_BUS.loadOrder(madh, tf_mandon, tf_makh, tf_tenkh, tf_manv, tf_tennv, 
                    ta_diachi, tf_ngaydat, cb_tinhtrang, tf_tongtien, tf_pttt, ta_ghichu, 
                    tf_nguoinhan, tf_sdt_nguoinhan, model);
                } else {
                    JOptionPane.showMessageDialog(null, 
                    "Chi tiết đơn hàng này đã ngừng hoạt động.");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
    }

    public static void main(String[] args) {
        new orderGUI(null, null, null);
    }
}
