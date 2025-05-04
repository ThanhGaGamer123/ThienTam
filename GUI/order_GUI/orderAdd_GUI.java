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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.customer_BUS;
import BUS.medicine_BUS;
import BUS.order_BUS;
import BUS.order_details_BUS;
import BUS.promotion_BUS;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.medicine_DTO;
import DTO.order_details_DTO;
import GUI.customerSearch_GUI;
import GUI.promotionSearch_GUI;
import GUI.medicine_GUI.medicineSearch_GUI;
import advanceMethod.advance;

public class orderAdd_GUI extends JFrame {
    public orderAdd_GUI(DefaultTableModel modelCollect, employee_DTO em, DefaultTableModel modelOrder) {
        this.setSize(1500, 800);
        this.setTitle("Lập hóa đơn");
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

        JLabel title = new JLabel("Lập Hóa Đơn Mới");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 11;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel title_kh = new JLabel("Thông Tin Khách Hàng");
        title_kh.setForeground(Color.BLACK);
        title_kh.setFont(new Font(null, Font.BOLD, 26));
        gdc.gridx = 4;
        gdc.gridy = 1;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(title_kh, gdc);

        JLabel title_thuoc = new JLabel("Thông Tin Mua Thuốc");
        title_thuoc.setForeground(Color.BLACK);
        title_thuoc.setFont(new Font(null, Font.BOLD, 26));
        gdc.gridx = 4;
        gdc.gridy = 11;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title_thuoc, gdc);

        JLabel title_ds = new JLabel("Danh Sách Mua Thuốc");
        title_ds.setForeground(Color.BLACK);
        title_ds.setFont(new Font(null, Font.BOLD, 26));
        gdc.gridx = 0;
        gdc.gridy = 21;
        gdc.gridwidth = 11;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title_ds, gdc);
        
        JLabel title_thanhtoan = new JLabel("Thông Tin Thanh Toán");
        title_thanhtoan.setForeground(Color.BLACK);
        title_thanhtoan.setFont(new Font(null, Font.BOLD, 26));
        gdc.gridx = 4;
        gdc.gridy = 27;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title_thanhtoan, gdc);

        JTextField search_bar = new JTextField("Nhập tên khách hàng...");
        search_bar.setForeground(Color.BLACK);
        search_bar.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(search_bar, gdc);

        JButton search = new JButton("Tìm kiếm");
        search.setForeground(Color.BLACK);
        search.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(search, gdc);

        JButton search_advance = new JButton("Tìm kiếm nâng cao");
        search_advance.setForeground(Color.BLACK);
        search_advance.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(search_advance, gdc);

        JButton reset = new JButton();
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 20));
        reset.setIcon(data.imagePath.resize_reset);
        gdc.gridx = 3;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(reset, gdc);

        String[] columns = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Tình trạng"};
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
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 4;
        gdc.gridheight = 9;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 50);
        main.add(scroll, gdc);
        gdc.gridheight = 1;

        JLabel tenkh = new JLabel("Tên khách hàng:");
        tenkh.setForeground(Color.BLACK);
        tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tenkh, gdc);

        JTextField tf_tenkh = new JTextField();
        tf_tenkh.setForeground(Color.BLACK);
        tf_tenkh.setFont(new Font(null, Font.PLAIN, 20));
        tf_tenkh.setEditable(false);
        tf_tenkh.setBackground(Color.white);
        tf_tenkh.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 2;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenkh, gdc);

        JLabel email = new JLabel("Email:");
        email.setForeground(Color.BLACK);
        email.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(email, gdc);

        JTextField tf_email = new JTextField();
        tf_email.setForeground(Color.BLACK);
        tf_email.setFont(new Font(null, Font.PLAIN, 20));
        tf_email.setEditable(false);
        tf_email.setBackground(Color.white);
        tf_email.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 3;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_email, gdc);

        JLabel sdt = new JLabel("Số điện thoại:");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(sdt, gdc);

        JTextField tf_sdt = new JTextField();
        tf_sdt.setForeground(Color.BLACK);
        tf_sdt.setFont(new Font(null, Font.PLAIN, 20));
        tf_sdt.setEditable(false);
        tf_sdt.setBackground(Color.white);
        tf_sdt.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 4;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_sdt, gdc);

        JLabel diachi = new JLabel("Địa chỉ:");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(diachi, gdc);

        JTextArea ta_diachi = new JTextArea();
        ta_diachi.setForeground(Color.BLACK);
        ta_diachi.setFont(new Font(null, Font.PLAIN, 20));
        ta_diachi.setAutoscrolls(true);
        ta_diachi.setLineWrap(true);
        ta_diachi.setEditable(false);

        JScrollPane diachi_scroll = new JScrollPane();
        diachi_scroll.setViewportView(ta_diachi);
        diachi_scroll.setPreferredSize(new Dimension(0, 100));

        gdc.gridx = 5;
        gdc.gridy = 5;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 2;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(diachi_scroll, gdc);

        JLabel diemkm = new JLabel("Điểm tích lũy:");
        diemkm.setForeground(Color.BLACK);
        diemkm.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(diemkm, gdc);

        JTextField tf_diemkm = new JTextField();
        tf_diemkm.setForeground(Color.BLACK);
        tf_diemkm.setFont(new Font(null, Font.PLAIN, 20));
        tf_diemkm.setEditable(false);
        tf_diemkm.setBackground(Color.white);
        tf_diemkm.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 6;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_diemkm, gdc);

        JButton btn_chon = new JButton("Chọn");
        btn_chon.setForeground(Color.BLACK);
        btn_chon.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 7;
        gdc.gridwidth = 6;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(btn_chon, gdc);

        JTextField search_bar_med = new JTextField("Nhập tên thuốc...");
        search_bar_med.setForeground(Color.BLACK);
        search_bar_med.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(20, 100, 30, 0);
        main.add(search_bar_med, gdc);

        JButton search_med = new JButton("Tìm kiếm");
        search_med.setForeground(Color.BLACK);
        search_med.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(20, 10, 30, 0);
        main.add(search_med, gdc);

        JButton search_advance_med = new JButton("Tìm kiếm nâng cao");
        search_advance_med.setForeground(Color.BLACK);
        search_advance_med.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(20, 10, 30, 0);
        main.add(search_advance_med, gdc);

        JButton reset_med = new JButton();
        reset_med.setForeground(Color.BLACK);
        reset_med.setFont(new Font(null, Font.PLAIN, 20));
        reset_med.setIcon(data.imagePath.resize_reset);
        gdc.gridx = 3;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(20, 10, 30, 50);
        main.add(reset_med, gdc);

        String[] columns_med = {"Mã thuốc", "Tên thuốc", "Tình trạng"};
        DefaultTableModel modelMedic = new DefaultTableModel(columns_med, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableMedic = new JTable(modelMedic);
        tableMedic.setFont(new Font(null, Font.PLAIN, 18));
        tableMedic.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableMedic.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        tableMedic.getTableHeader().setResizingAllowed(false);
        tableMedic.getTableHeader().setReorderingAllowed(false);
        tableMedic.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        tableMedic.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableMedic.getColumnModel().getColumn(2).setPreferredWidth(10);
        tableMedic.setRowHeight(30);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableMedic.getColumnCount(); i++) {
            tableMedic.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_medic = new JScrollPane();
        scroll_medic.setViewportView(tableMedic);
        gdc.gridx = 0;
        gdc.gridy = 12;
        gdc.gridwidth = 4;
        gdc.gridheight = 9;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 50);
        main.add(scroll_medic, gdc);
        gdc.gridheight = 1;

        JLabel tenthuoc = new JLabel("Tên thuốc:");
        tenthuoc.setForeground(Color.BLACK);
        tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 12;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tenthuoc, gdc);

        JTextField tf_tenthuoc = new JTextField();
        tf_tenthuoc.setForeground(Color.BLACK);
        tf_tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        tf_tenthuoc.setEditable(false);
        tf_tenthuoc.setBackground(Color.white);
        tf_tenthuoc.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 12;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenthuoc, gdc);

        JLabel soluongcon = new JLabel("Số lượng còn:");
        soluongcon.setForeground(Color.BLACK);
        soluongcon.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(soluongcon, gdc);

        JTextField tf_hop = new JTextField();
        tf_hop.setForeground(Color.BLACK);
        tf_hop.setFont(new Font(null, Font.PLAIN, 20));
        tf_hop.setEditable(false);
        tf_hop.setBackground(Color.white);
        tf_hop.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 3;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_hop, gdc);
        
        JLabel slhop = new JLabel("Hộp");
        slhop.setForeground(Color.BLACK);
        slhop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 6;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(slhop, gdc);

        JTextField tf_vi = new JTextField();
        tf_vi.setForeground(Color.BLACK);
        tf_vi.setFont(new Font(null, Font.PLAIN, 20));
        tf_vi.setEditable(false);
        tf_vi.setBackground(Color.white);
        tf_vi.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 7;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 3;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tf_vi, gdc);
        
        JLabel slvi = new JLabel("Vỉ");
        slvi.setForeground(Color.BLACK);
        slvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 8;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(slvi, gdc);

        JTextField tf_vien = new JTextField();
        tf_vien.setForeground(Color.BLACK);
        tf_vien.setFont(new Font(null, Font.PLAIN, 20));
        tf_vien.setEditable(false);
        tf_vien.setBackground(Color.white);
        tf_vien.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 9;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 3;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tf_vien, gdc);
        
        JLabel slvien = new JLabel("Viên");
        slvien.setForeground(Color.BLACK);
        slvien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 10;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(slvien, gdc);

        JLabel donvi = new JLabel("Đơn vị:");
        donvi.setForeground(Color.BLACK);
        donvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(donvi, gdc);

        JRadioButton rad_hop = new JRadioButton();
        rad_hop.setForeground(Color.BLACK);
        rad_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 3;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(rad_hop, gdc);
        
        JLabel hop = new JLabel("Hộp");
        hop.setForeground(Color.BLACK);
        hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 6;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(hop, gdc);

        JRadioButton rad_vi = new JRadioButton();
        rad_vi.setForeground(Color.BLACK);
        rad_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 7;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 3;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(rad_vi, gdc);
        
        JLabel vi = new JLabel("Vỉ");
        vi.setForeground(Color.BLACK);
        vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 8;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(vi, gdc);

        JRadioButton rad_vien = new JRadioButton();
        rad_vien.setForeground(Color.BLACK);
        rad_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 9;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 3;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(rad_vien, gdc);
        
        JLabel vien = new JLabel("Viên");
        vien.setForeground(Color.BLACK);
        vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 10;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(vien, gdc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rad_hop);
        buttonGroup.add(rad_vi);
        buttonGroup.add(rad_vien);

        JLabel giaban = new JLabel("Giá bán:");
        giaban.setForeground(Color.BLACK);
        giaban.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 15;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(giaban, gdc);

        JTextField tf_giaban = new JTextField();
        tf_giaban.setForeground(Color.BLACK);
        tf_giaban.setFont(new Font(null, Font.PLAIN, 20));
        tf_giaban.setEditable(false);
        tf_giaban.setBackground(Color.white);
        tf_giaban.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 15;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_giaban, gdc);

        JLabel slmua = new JLabel("Số lượng mua:");
        slmua.setForeground(Color.BLACK);
        slmua.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 16;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(slmua, gdc);

        SpinnerNumberModel sp_slmua = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner tf_slmua = new JSpinner(sp_slmua);
        tf_slmua.setForeground(Color.BLACK);
        tf_slmua.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 16;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_slmua, gdc);

        JButton btn_them = new JButton("Thêm");
        btn_them.setForeground(Color.BLACK);
        btn_them.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 17;
        gdc.gridwidth = 6;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(btn_them, gdc);

        JTextField search_bar_km = new JTextField("Nhập tên khuyến mãi...");
        search_bar_km.setForeground(Color.BLACK);
        search_bar_km.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 27;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(20, 100, 30, 0);
        main.add(search_bar_km, gdc);

        JButton search_km = new JButton("Tìm kiếm");
        search_km.setForeground(Color.BLACK);
        search_km.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 27;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(20, 10, 30, 0);
        main.add(search_km, gdc);

        JButton search_advance_km = new JButton("Tìm kiếm nâng cao");
        search_advance_km.setForeground(Color.BLACK);
        search_advance_km.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 27;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(20, 10, 30, 0);
        main.add(search_advance_km, gdc);

        JButton reset_km = new JButton();
        reset_km.setForeground(Color.BLACK);
        reset_km.setFont(new Font(null, Font.PLAIN, 20));
        reset_km.setIcon(data.imagePath.resize_reset);
        gdc.gridx = 3;
        gdc.gridy = 27;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(20, 10, 30, 50);
        main.add(reset_km, gdc);

        String[] columns_ds = {"Mã CTĐH", "Tên thuốc", "Đơn vị", "Số lượng", "Đơn giá", "Thành tiền", ""};
        DefaultTableModel model_ds = new DefaultTableModel(columns_ds, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table_ds = new JTable(model_ds);
        table_ds.setFont(new Font(null, Font.PLAIN, 18));
        table_ds.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        table_ds.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        table_ds.getTableHeader().setResizingAllowed(false);
        table_ds.getTableHeader().setReorderingAllowed(false);
        table_ds.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        table_ds.getColumnModel().getColumn(0).setPreferredWidth(10);
        table_ds.getColumnModel().getColumn(6).setPreferredWidth(10);
        table_ds.setRowHeight(30);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table_ds.getColumnCount(); i++) {
            table_ds.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_ds = new JScrollPane();
        scroll_ds.setViewportView(table_ds);
        gdc.gridx = 0;
        gdc.gridy = 22;
        gdc.gridwidth = 11;
        gdc.gridheight = 5;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 50);
        main.add(scroll_ds, gdc);
        gdc.gridheight = 1;

        String[] columns_km = {"Mã KM", "Tên KM", "Giảm (%)", "Điểm", "Tình trạng"};
        DefaultTableModel modelKM = new DefaultTableModel(columns_km, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableKM = new JTable(modelKM);
        tableKM.setFont(new Font(null, Font.PLAIN, 18));
        tableKM.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableKM.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        tableKM.getTableHeader().setResizingAllowed(false);
        tableKM.getTableHeader().setReorderingAllowed(false);
        tableKM.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        tableKM.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableKM.getColumnModel().getColumn(2).setPreferredWidth(10);
        tableKM.setRowHeight(30);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableKM.getColumnCount(); i++) {
            tableKM.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_km = new JScrollPane();
        scroll_km.setViewportView(tableKM);
        gdc.gridx = 0;
        gdc.gridy = 28;
        gdc.gridwidth = 4;
        gdc.gridheight = 9;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 50);
        main.add(scroll_km, gdc);
        gdc.gridheight = 1;

        JLabel tenKH = new JLabel("Tên khách hàng:");
        tenKH.setForeground(Color.BLACK);
        tenKH.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 28;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tenKH, gdc);

        JTextField tf_tenKH = new JTextField();
        tf_tenKH.setForeground(Color.BLACK);
        tf_tenKH.setFont(new Font(null, Font.PLAIN, 20));
        tf_tenKH.setEditable(false);
        tf_tenKH.setBackground(Color.white);
        tf_tenKH.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 28;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenKH, gdc);

        JLabel tenNV = new JLabel("Tên nhân viên:");
        tenNV.setForeground(Color.BLACK);
        tenNV.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 29;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tenNV, gdc);

        JTextField tf_tenNV = new JTextField();
        tf_tenNV.setForeground(Color.BLACK);
        tf_tenNV.setFont(new Font(null, Font.PLAIN, 20));
        tf_tenNV.setEditable(false);
        tf_tenNV.setBackground(Color.white);
        tf_tenNV.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 29;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenNV, gdc);

        JLabel diachiTT = new JLabel("Địa chỉ mua hàng:");
        diachiTT.setForeground(Color.BLACK);
        diachiTT.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 30;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(diachiTT, gdc);

        JTextArea ta_diachiTT = new JTextArea();
        ta_diachiTT.setForeground(Color.BLACK);
        ta_diachiTT.setFont(new Font(null, Font.PLAIN, 20));
        ta_diachiTT.setEditable(false);
        ta_diachiTT.setBackground(Color.white);
        ta_diachiTT.setAutoscrolls(true);
        ta_diachiTT.setLineWrap(true);
        ta_diachiTT.setEditable(false);

        JScrollPane diachiTT_scroll = new JScrollPane();
        diachiTT_scroll.setViewportView(ta_diachiTT);
        diachiTT_scroll.setPreferredSize(new Dimension(0, 100));

        gdc.gridx = 5;
        gdc.gridy = 30;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(diachiTT_scroll, gdc);

        JLabel km = new JLabel("Áp dụng khuyến mãi:");
        km.setForeground(Color.BLACK);
        km.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 31;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(km, gdc);

        JTextField tf_km = new JTextField();
        tf_km.setForeground(Color.BLACK);
        tf_km.setFont(new Font(null, Font.PLAIN, 20));
        tf_km.setEditable(false);
        tf_km.setBackground(Color.white);
        tf_km.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 31;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_km, gdc);

        JLabel tongtien = new JLabel("Tổng tiền:");
        tongtien.setForeground(Color.BLACK);
        tongtien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 32;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(tongtien, gdc);

        JTextField tf_tongtien = new JTextField();
        tf_tongtien.setForeground(Color.BLACK);
        tf_tongtien.setFont(new Font(null, Font.PLAIN, 20));
        tf_tongtien.setEditable(false);
        tf_tongtien.setBackground(Color.white);
        tf_tongtien.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        gdc.gridx = 5;
        gdc.gridy = 32;
        gdc.gridwidth = 7;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tongtien, gdc);

        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 37;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(finish, gdc);

        JButton reset_all = new JButton("Đặt lại");
        reset_all.setForeground(Color.BLACK);
        reset_all.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 37;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 40, 30, 0);
        main.add(reset_all, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //xử lý khách hàng
        //load data khách hàng
        customer_BUS.loadData(model, true);

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
    
        //tìm kiếm khách hàng
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer_BUS.findCustomer(model, search_bar);
            }
        });
    
        //tìm kiếm nâng cao khách hàng
        search_advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new customerSearch_GUI(model);
            }
        });
    
        //chọn khách hàng
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!customer_BUS.upData(table, model, tf_tenkh, tf_email, tf_sdt, ta_diachi,
                tf_diemkm))
                    JOptionPane.showMessageDialog(null, 
                    "Thông tin khách hàng này đã ngừng hoạt động.");
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
    
        //chọn button
        customer_DTO customer = new customer_DTO();
        btn_chon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!customer_BUS.chooseCus(tf_email, customer)) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng trước!");
                }
                System.out.println(customer.getMakh());
                
                order_BUS.purchase(customer, em, null, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);
            }
        });
        
        //reset khách hàng
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_bar.setText("Nhập tên khách hàng...");
                tf_tenkh.setText("");
                tf_email.setText("");
                tf_sdt.setText("");
                ta_diachi.setText("");
                tf_diemkm.setText("");
                customer_BUS.loadData(model, true);
                customer.setMakh(null);
                tf_tenKH.setText("");
            }
        });

        //xử lý thuốc
        //load data thuốc
        medicine_BUS.loadDataOther(modelMedic, true);

        tableMedic.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
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
    
        //tìm kiếm thuốc
        search_med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.searchMedicineOther(search_bar_med, modelMedic);
            }
        });
    
        //tìm kiếm thuốc nâng cao
        search_advance_med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new medicineSearch_GUI(null, modelMedic);
            }
        });
        
        //chọn thuốc
        medicine_DTO med = new medicine_DTO();
        tableMedic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!medicine_BUS.chooseMed(tableMedic, modelMedic, tf_tenthuoc, tf_hop, tf_vi, 
                tf_vien, med))
                    JOptionPane.showMessageDialog(null, 
                    "Thông tin thuốc này đã ngừng hoạt động.");
                if(rad_hop.isSelected())
                    medicine_BUS.radioDonVi(med, tf_giaban, 0);
                if(rad_vi.isSelected())
                    medicine_BUS.radioDonVi(med, tf_giaban, 1);
                if(rad_vien.isSelected())
                    medicine_BUS.radioDonVi(med, tf_giaban, 2);
                System.out.println(med.getMathuoc());
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

        //cập nhật giá bán
        rad_hop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.radioDonVi(med, tf_giaban, 0);
            }
        });

        rad_vi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.radioDonVi(med, tf_giaban, 1);
            }
        });

        rad_vien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.radioDonVi(med, tf_giaban, 2);
            }
        });

        //thêm chi tiết đơn hàng
        ArrayList<order_details_DTO> ods = new ArrayList<>();
        btn_them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ketQua = order_details_BUS.addOrderDetails(med, rad_hop, rad_vi, rad_vien, 
                tf_hop, tf_vi, tf_vien, tf_giaban, tf_slmua, ods, model_ds, modelCollect,
                tf_tenthuoc);
                if(ketQua == 0) {
                    JOptionPane.showMessageDialog(null, 
                    "Đã hết đơn vị thuốc này.");
                } else if(ketQua == 1) {
                    JOptionPane.showMessageDialog(null, 
                    "Số lượng mua vượt quá số lượng còn.");
                } else if(ketQua == -1) {
                    JOptionPane.showMessageDialog(null, 
                    "Vui lòng chọn thuốc.");
                } else if(ketQua == -2) {
                    JOptionPane.showMessageDialog(null, 
                    "Vui lòng chọn đơn vị.");
                }

                
                order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);
            }
        });

        table_ds.getColumn("").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = (value instanceof JButton) ? (JButton) value : new JButton();

                if (isSelected) {
                    button.setBackground(new Color(173, 216, 230)); // Màu nền sáng
                } else {
                    button.setBackground(Color.WHITE); // Màu nền mặc định
                }
        
                button.setOpaque(true);
                button.setBorderPainted(true);
                return button;
            }   
        });

        //xóa chi tiết đơn hàng
        table_ds.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                order_details_BUS.deleteOrderDetails(ods, model_ds, table_ds, rad_hop, 
                rad_vi, rad_vien, tf_hop, tf_vi, tf_vien, tf_giaban, modelCollect);
                
                order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);
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

        //reset thuốc
        reset_med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_bar_med.setText("Nhập tên thuốc...");
                medicine_BUS.loadDataOther(modelMedic, true);
                tf_tenthuoc.setText("");
                tf_hop.setText("");
                tf_vi.setText("");
                tf_vien.setText("");
                buttonGroup.clearSelection();
                tf_giaban.setText("");
                tf_slmua.setValue(1);

                order_details_BUS.resetDelete(ods, model_ds, tf_hop, tf_vi, tf_vien, rad_hop, 
                rad_vi, rad_vien, tf_giaban);
                ods.clear();
                order_details_BUS.loadData(ods, model_ds);
            }
        });
    
        //xử lý khuyến mãi
        //load khuyến mãi
        promotion_BUS.loadData(modelKM);

        tableKM.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
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

        //tìm kiếm khuyến mãi
        search_km.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promotion_BUS.search(modelKM, search_bar_km);
            }
        });

        //tìm kiếm nâng cao khuyến mãi
        search_advance_km.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new promotionSearch_GUI(modelKM);
            }
        });

        //reset khuyến mãi
        reset_km.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_bar_km.setText("Nhập tên khuyến mãi...");
                promotion_BUS.loadData(modelKM);
                tf_km.setText("");

                order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);
            }
        });
    
        //load thanh toán
        order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);

        //chọn khuyến mãi
        tableKM.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);

                int ketQua = promotion_BUS.choosePromotion(modelKM, tableKM, tf_tenKH, 
                tf_km, customer, tf_tongtien);
                if(ketQua == 3) {
                    JOptionPane.showMessageDialog(null, 
                    "Khách hàng không đủ điểm để áp dụng chương trình khuyến mãi này.");
                }
                if(ketQua == 2) {
                    JOptionPane.showMessageDialog(null, 
                    "Chương trình khuyến mãi này đã ngừng hoạt động.");
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
    
        //hoàn tất
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!order_BUS.completeOrder(customer, em, tf_tongtien, ods, tf_km, modelOrder)) {
                    JOptionPane.showMessageDialog(null, 
                    "Danh sách mua thuốc đang rỗng!");
                }

                order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);

                //khách hàng
                search_bar.setText("Nhập tên khách hàng...");
                tf_tenkh.setText("");
                tf_email.setText("");
                tf_sdt.setText("");
                ta_diachi.setText("");
                tf_diemkm.setText("");
                customer_BUS.loadData(model, true);
                customer.setMakh(null);
                tf_tenKH.setText("");
                
                //thuốc
                search_bar_med.setText("Nhập tên thuốc...");
                medicine_BUS.loadDataOther(modelMedic, true);
                tf_tenthuoc.setText("");
                tf_hop.setText("");
                tf_vi.setText("");
                tf_vien.setText("");
                buttonGroup.clearSelection();
                tf_giaban.setText("");
                tf_slmua.setValue(1);
                ods.clear();
                order_details_BUS.loadData(ods, model_ds);

                //khuyến mãi
                search_bar_km.setText("Nhập tên khuyến mãi...");
                promotion_BUS.loadData(modelKM);
                tf_km.setText("");
            }
        });

        //reset all
        reset_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order_BUS.purchase(customer, em, ods, tf_tenKH, tf_tenNV, ta_diachiTT, tf_tongtien);

                //khách hàng
                search_bar.setText("Nhập tên khách hàng...");
                tf_tenkh.setText("");
                tf_email.setText("");
                tf_sdt.setText("");
                ta_diachi.setText("");
                tf_diemkm.setText("");
                customer_BUS.loadData(model, true);
                customer.setMakh(null);
                tf_tenKH.setText("");
                
                //thuốc
                search_bar_med.setText("Nhập tên thuốc...");
                medicine_BUS.loadDataOther(modelMedic, true);
                tf_tenthuoc.setText("");
                tf_hop.setText("");
                tf_vi.setText("");
                tf_vien.setText("");
                buttonGroup.clearSelection();
                tf_giaban.setText("");
                tf_slmua.setValue(1);

                order_details_BUS.resetDelete(ods, model_ds, tf_hop, tf_vi, tf_vien, rad_hop, 
                rad_vi, rad_vien, tf_giaban);
                ods.clear();
                order_details_BUS.loadData(ods, model_ds);

                //khuyến mãi
                search_bar_km.setText("Nhập tên khuyến mãi...");
                promotion_BUS.loadData(modelKM);
                tf_km.setText("");
            }
        });
    
        //reset thuốc khi tắt window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                order_details_BUS.resetDelete(ods, model_ds, tf_hop, tf_vi, tf_vien, rad_hop, 
                rad_vi, rad_vien, tf_giaban);

                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new orderAdd_GUI(null, null, null);
    }
}
