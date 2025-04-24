package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

import BUS.employee_BUS;
import BUS.medicine_BUS;
import BUS.orderSupply_BUS;
import DTO.employee_DTO;
import DTO.orderSupply_DTO;
import GUI.medicine_GUI.medicineAdd_GUI;
import GUI.medicine_GUI.medicineSearch_GUI;
import GUI.orderSupply_GUI.orderSupplyAdd_GUI;
import GUI.orderSupply_GUI.orderSupplySearch_GUI;
import advanceMethod.advance;

public class employee_GUI extends JFrame {
    public employee_GUI(employee_DTO nv) {
        // this.setSize(1280, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        this.setTitle("Nhân viên");
        ImageIcon logo = new ImageIcon(advance.img+"logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        //Tạo Tab Panel
        JTabbedPane tab = new JTabbedPane();
        tab.setForeground(Color.BLACK);
        tab.setFont(new Font(null, Font.BOLD, 20));
        tab.setBackground(Color.white);
        // tab.setBounds(0, 10, 1280, 710);
        this.add(tab, BorderLayout.CENTER);

        
        //Panel Thông tin nhân viên
        JPanel employeeStatus = new JPanel();
        employeeStatus.setBackground(Color.white);
        employeeStatus.setLayout(new GridBagLayout());

        JScrollPane employeeScroll = new JScrollPane();
        employeeScroll.setViewportView(employeeStatus);

        tab.addTab("Thông tin", data.imagePath.resize_statusIcon, employeeScroll);

        GridBagConstraints gdc_employee = new GridBagConstraints();

        gdc_employee.gridwidth = 1;
        gdc_employee.gridheight = 1;

        JLabel title = new JLabel("Thông Tin Nhân Viên");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 40));
        // title.setBounds(200,80,500,50);
        gdc_employee.gridx = 0;
        gdc_employee.gridy = 0;
        gdc_employee.gridwidth = 2;
        gdc_employee.anchor = GridBagConstraints.CENTER;
        gdc_employee.insets = new Insets(50, 0, 30, 0);
        employeeStatus.add(title, gdc_employee);

        // reset
        gdc_employee.gridwidth = 1;
        gdc_employee.anchor = GridBagConstraints.NONE;

        JLabel manv = new JLabel("Mã nhân viên: ");
        manv.setForeground(Color.BLACK);
        manv.setFont(new Font(null, Font.PLAIN, 22));
        // manv.setBounds(200,140,300,30);
        gdc_employee.gridy = 1;
        gdc_employee.gridx = 0;
        gdc_employee.anchor = GridBagConstraints.WEST;
        gdc_employee.insets = new Insets(0, 0, 30, 0);
        employeeStatus.add(manv, gdc_employee);

        JLabel tennv = new JLabel("Tên nhân viên: ");
        tennv.setForeground(Color.BLACK);
        tennv.setFont(new Font(null, Font.PLAIN, 22));
        // tennv.setBounds(200,180,300,30);
        gdc_employee.gridy = 2;
        gdc_employee.gridx = 0;
        employeeStatus.add(tennv, gdc_employee);

        JLabel chucvu = new JLabel("Chức vụ: ");
        chucvu.setForeground(Color.BLACK);
        chucvu.setFont(new Font(null, Font.PLAIN, 22));
        // chucvu.setBounds(200,220,300,30);
        gdc_employee.gridy = 3;
        gdc_employee.gridx = 0;
        employeeStatus.add(chucvu, gdc_employee);

        JLabel gioitinh = new JLabel("Giới tính: ");
        gioitinh.setForeground(Color.BLACK);
        gioitinh.setFont(new Font(null, Font.PLAIN, 22));
        gdc_employee.gridy = 4;
        gdc_employee.gridx = 0;
        employeeStatus.add(gioitinh, gdc_employee);

        JLabel cccd = new JLabel("CCCD: ");
        cccd.setForeground(Color.BLACK);
        cccd.setFont(new Font(null, Font.PLAIN, 22));
        gdc_employee.gridy = 5;
        gdc_employee.gridx = 0;
        employeeStatus.add(cccd, gdc_employee);

        JLabel sdt = new JLabel("Số điện thoại: ");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font(null, Font.PLAIN, 22));
        // sdt.setBounds(200,260,300,30);
        gdc_employee.gridy = 6;
        gdc_employee.gridx = 0;
        employeeStatus.add(sdt, gdc_employee);

        JPanel tf_diachi = new JPanel();
        tf_diachi.setBackground(Color.white);
        tf_diachi.setLayout(new FlowLayout());
        gdc_employee.gridy = 7;
        gdc_employee.gridx = 0;
        employeeStatus.add(tf_diachi, gdc_employee);

        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 22));
        // diachi.setBounds(200,300,700,30);
        tf_diachi.add(diachi);

        JLabel nhathuoc = new JLabel("Mã nhà thuốc: ");
        nhathuoc.setForeground(Color.BLACK);
        nhathuoc.setFont(new Font(null, Font.PLAIN, 22));
        // nhathuoc.setBounds(200,340,300,30);
        gdc_employee.gridy = 8;
        gdc_employee.gridx = 0;
        gdc_employee.insets = new Insets(0, 0, 30, 0);
        employeeStatus.add(nhathuoc, gdc_employee);

        JButton btn_nhathuoc = new JButton("Xem chi tiết");
        btn_nhathuoc.setForeground(Color.BLACK);
        btn_nhathuoc.setFont(new Font(null, Font.PLAIN, 20));
        // btn_nhathuoc.setBounds(440,340,120,30);
        gdc_employee.gridy = 8;
        gdc_employee.gridx = 1;
        gdc_employee.insets = new Insets(0, 0, 30, 0);
        employeeStatus.add(btn_nhathuoc, gdc_employee);

        JLabel tinhtrang = new JLabel("Tình trạng: ");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 22));
        gdc_employee.gridy = 9;
        gdc_employee.gridx = 0;
        gdc_employee.insets = new Insets(0, 0, 50, 0);
        employeeStatus.add(tinhtrang, gdc_employee);
        
        // JLabel background = new JLabel();
        // background.setIcon(new ImageIcon(advance.img+"backgrounds.jpg"));
        // gdc_employee.gridx = 0;
        // gdc_employee.gridy = 0;
        // gdc_employee.gridwidth = 1;
        // gdc_employee.gridheight = 9;
        // employeeStatus.add(background, gdc_employee);

        //Panel Hóa đơn bán
        JPanel orderSell = new JPanel();
        orderSell.setBackground(Color.white);
        orderSell.setLayout(new GridBagLayout());
        
        JScrollPane orderScroll = new JScrollPane();
        orderScroll.setViewportView(orderSell);

        tab.addTab("Hóa đơn bán", data.imagePath.resize_orderSell, orderScroll);

        GridBagConstraints gdc_ordersell = new GridBagConstraints();

        JLabel titleSell = new JLabel("Danh Sách Hóa Đơn Bán");
        titleSell.setForeground(Color.BLACK);
        titleSell.setFont(new Font(null, Font.BOLD, 30));
        // titleSell.setBounds(450, 2, 500, 40);
        gdc_ordersell.gridx = 0;
        gdc_ordersell.gridy = 0;
        gdc_ordersell.gridwidth = 5;
        gdc_ordersell.anchor = GridBagConstraints.CENTER;
        gdc_ordersell.insets = new Insets(20, 0, 20, 0);
        orderSell.add(titleSell, gdc_ordersell);

        // reset
        gdc_ordersell.gridwidth = 1;

        JTextField search_bar = new JTextField("Nhập mã đơn...");
        search_bar.setForeground(Color.BLACK);
        search_bar.setFont(new Font(null, Font.PLAIN, 18));
        // search_bar.setBounds(200, 45, 200, 30);
        gdc_ordersell.gridx = 0;
        gdc_ordersell.gridy = 1;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.weightx = 1.2;
        gdc_ordersell.insets = new Insets(0, 50, 30, 5);
        orderSell.add(search_bar, gdc_ordersell);

        JButton search = new JButton("Tìm Kiếm");
        search.setForeground(Color.BLACK);
        search.setFont(new Font(null, Font.PLAIN, 18));
        // search.setBounds(420, 45, 120, 30);
        gdc_ordersell.gridx = 1;
        gdc_ordersell.gridy = 1;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.weightx = 0.5;
        gdc_ordersell.insets = new Insets(0, 5, 30, 5);
        orderSell.add(search, gdc_ordersell);

        JButton search_advance = new JButton("Tìm Kiếm Nâng Cao");
        search_advance.setForeground(Color.BLACK);
        search_advance.setFont(new Font(null, Font.PLAIN, 18));
        // search_advance.setBounds(560, 45, 220, 30);
        gdc_ordersell.gridx = 2;
        gdc_ordersell.gridy = 1;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.weightx = 1;
        gdc_ordersell.insets = new Insets(0, 5, 30, 5);
        orderSell.add(search_advance, gdc_ordersell);

        String[] option = {"Tùy chọn", "Tổng tiền từ cao tới thấp", "Tổng tiền từ thấp tới cao",
        "Thời gian gần nhất", "Thời gian xa nhất"};
        JComboBox loc = new JComboBox<>(option);
        loc.setForeground(Color.BLACK);
        loc.setFont(new Font(null, Font.PLAIN, 18));
        // loc.setBounds(800, 45, 230, 30);
        gdc_ordersell.gridx = 3;
        gdc_ordersell.gridy = 1;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.weightx = 1;
        gdc_ordersell.insets = new Insets(0, 5, 30, 5);
        orderSell.add(loc, gdc_ordersell);

        JButton reset = new JButton();
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 18));
        reset.setIcon(data.imagePath.resize_reset);
        // reset.setBounds(1050, 45, 30, 30);
        gdc_ordersell.gridx = 4;
        gdc_ordersell.gridy = 1;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.weightx = 0.2;
        gdc_ordersell.insets = new Insets(0, 5, 30, 50);
        orderSell.add(reset, gdc_ordersell);

        // reset
        gdc_ordersell.fill = GridBagConstraints.NONE;
        gdc_ordersell.weightx = 0;

        String columns[] = {"Mã đơn", "Mã khách", "Mã nhân viên", "Ngày đặt", 
        "Tổng tiền", "Tình trạng", "Xem chi tiết"};
        DefaultTableModel model = new DefaultTableModel(columns,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.setFont(new Font(null, Font.PLAIN, 18));
        table.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        table.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll = new JScrollPane(table);
        // scroll.setBounds(40, 90, 1050, 500);
        gdc_ordersell.gridx = 0;
        gdc_ordersell.gridy = 2;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.gridwidth = 4;
        gdc_ordersell.gridheight = 3;
        gdc_ordersell.insets = new Insets(0, 50, 30, 5);
        orderSell.add(scroll, gdc_ordersell);

        // reset
        gdc_ordersell.gridwidth = 1;
        gdc_ordersell.gridheight = 1;

        JButton themSell = new JButton("Thêm");
        themSell.setFont(new Font(null, Font.PLAIN, 18));
        themSell.setForeground(Color.BLACK);
        themSell.setIcon(data.imagePath.resize_addButton);
        // themSell.setBounds(1120, 90, 115, 50);
        gdc_ordersell.gridx = 4;
        gdc_ordersell.gridy = 2;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.insets = new Insets(0, 5, 30, 50);
        orderSell.add(themSell, gdc_ordersell);

        JButton suaSell = new JButton("Sửa");
        suaSell.setFont(new Font(null, Font.PLAIN, 18));
        suaSell.setForeground(Color.BLACK);
        suaSell.setIcon(data.imagePath.resize_fixButton);
        // suaSell.setBounds(1120, 180, 115, 50);
        gdc_ordersell.gridx = 4;
        gdc_ordersell.gridy = 3;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.insets = new Insets(0, 5, 30, 50);
        orderSell.add(suaSell, gdc_ordersell);

        JButton xoaSell = new JButton("Xóa");
        xoaSell.setFont(new Font(null, Font.PLAIN, 18));
        xoaSell.setForeground(Color.BLACK);
        xoaSell.setIcon(data.imagePath.resize_deleteButton);
        // xoaSell.setBounds(1120, 270, 115, 50);
        gdc_ordersell.gridx = 4;
        gdc_ordersell.gridy = 4;
        gdc_ordersell.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordersell.insets = new Insets(0, 5, 30, 50);
        orderSell.add(xoaSell, gdc_ordersell);

        //Panel Hóa đơn nhập
        JPanel orderCollect = new JPanel();
        orderCollect.setBackground(Color.white);
        orderCollect.setLayout(new GridBagLayout());

        JScrollPane orderCollectScroll = new JScrollPane();
        orderCollectScroll.setViewportView(orderCollect);

        tab.addTab("Hóa đơn nhập", data.imagePath.resize_package, orderCollectScroll);

        GridBagConstraints gdc_ordercollect = new GridBagConstraints();

        JLabel titleCollect = new JLabel("Danh Sách Hóa Đơn Nhập");
        titleCollect.setForeground(Color.BLACK);
        titleCollect.setFont(new Font(null, Font.BOLD, 30));
        // titleCollect.setBounds(450, 2, 500, 40);
        gdc_ordercollect.gridx = 0;
        gdc_ordercollect.gridy = 0;
        gdc_ordercollect.gridwidth = 5;
        gdc_ordercollect.anchor = GridBagConstraints.CENTER;
        gdc_ordercollect.insets = new Insets(20, 0, 20, 0);
        orderCollect.add(titleCollect, gdc_ordercollect);

        // reset
        gdc_ordercollect.gridwidth = 1;

        JTextField search_bar_2 = new JTextField("Nhập mã đơn...");
        search_bar_2.setForeground(Color.BLACK);
        search_bar_2.setFont(new Font(null, Font.PLAIN, 18));
        // search_bar_2.setBounds(200, 45, 200, 30);
        gdc_ordercollect.gridx = 0;
        gdc_ordercollect.gridy = 1;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.weightx = 1.2;
        gdc_ordercollect.insets = new Insets(0, 50, 30, 5);
        orderCollect.add(search_bar_2, gdc_ordercollect);

        JButton search_2 = new JButton("Tìm Kiếm");
        search_2.setForeground(Color.BLACK);
        search_2.setFont(new Font(null, Font.PLAIN, 18));
        // search_2.setBounds(420, 45, 120, 30);
        gdc_ordercollect.gridx = 1;
        gdc_ordercollect.gridy = 1;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.weightx = 0.5;
        gdc_ordercollect.insets = new Insets(0, 5, 30, 5);
        orderCollect.add(search_2, gdc_ordercollect);

        JButton search_advance_2 = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_2.setForeground(Color.BLACK);
        search_advance_2.setFont(new Font(null, Font.PLAIN, 18));
        // search_advance_2.setBounds(560, 45, 220, 30);
        gdc_ordercollect.gridx = 2;
        gdc_ordercollect.gridy = 1;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.weightx = 1;
        gdc_ordercollect.insets = new Insets(0, 5, 30, 5);
        orderCollect.add(search_advance_2, gdc_ordercollect);

        String[] option_2 = {"Tùy chọn", "Tổng tiền từ cao tới thấp", "Tổng tiền từ thấp tới cao",
        "Thời gian gần nhất", "Thời gian xa nhất"};
        JComboBox loc_2 = new JComboBox<>(option_2);
        loc_2.setForeground(Color.BLACK);
        loc_2.setFont(new Font(null, Font.PLAIN, 18));
        // loc_2.setBounds(800, 45, 230, 30);
        gdc_ordercollect.gridx = 3;
        gdc_ordercollect.gridy = 1;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.weightx = 1;
        gdc_ordercollect.insets = new Insets(0, 5, 30, 5);
        orderCollect.add(loc_2, gdc_ordercollect);
        
        JButton reset_2 = new JButton();
        reset_2.setForeground(Color.BLACK);
        reset_2.setFont(new Font(null, Font.PLAIN, 18));
        reset_2.setIcon(data.imagePath.resize_reset);
        // reset_2.setBounds(1050, 45, 30, 30);
        gdc_ordercollect.gridx = 4;
        gdc_ordercollect.gridy = 1;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.weightx = 0.2;
        gdc_ordercollect.insets = new Insets(0, 5, 30, 50);
        orderCollect.add(reset_2, gdc_ordercollect);
        
        // reset
        gdc_ordercollect.fill = GridBagConstraints.NONE;
        gdc_ordercollect.weightx = 0;

        String columnsCollect[] = {"Mã đơn", "Tên nhà cung cấp", "Số loại thuốc", "Thời gian nhập", 
        "Tổng tiền", "Tình trạng", "Xem chi tiết"};
        DefaultTableModel modelCollect = new DefaultTableModel(columnsCollect,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableCollect = new JTable(modelCollect);
        tableCollect.setFont(new Font(null, Font.PLAIN, 18));
        tableCollect.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableCollect.getTableHeader().setForeground(Color.WHITE); // Màu chữ tiêu đề
        tableCollect.getTableHeader().setResizingAllowed(false);
        tableCollect.getTableHeader().setReorderingAllowed(false);
        tableCollect.getTableHeader().setFont(new Font(null, Font.BOLD, 18)); // Font tiêu đề
        tableCollect.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableCollect.setRowHeight(30);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableCollect.getColumnCount(); i++) {
            tableCollect.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollCollect = new JScrollPane(tableCollect);
        // scrollCollect.setBounds(40, 90, 1050, 500);
        gdc_ordercollect.gridx = 0;
        gdc_ordercollect.gridy = 2;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.gridwidth = 4;
        gdc_ordercollect.gridheight = 3;
        gdc_ordercollect.insets = new Insets(0, 50, 30, 5);
        orderCollect.add(scrollCollect, gdc_ordercollect);

        // reset
        gdc_ordercollect.gridwidth = 1;
        gdc_ordercollect.gridheight = 1;

        JButton themCollect = new JButton("Thêm");
        themCollect.setFont(new Font(null, Font.PLAIN, 18));
        themCollect.setForeground(Color.BLACK);
        themCollect.setIcon(data.imagePath.resize_addButton);
        // themCollect.setBounds(1120, 90, 115, 50);
        gdc_ordercollect.gridx = 4;
        gdc_ordercollect.gridy = 2;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.insets = new Insets(0, 5, 30, 50);
        orderCollect.add(themCollect, gdc_ordercollect);

        JButton xoaCollect = new JButton("Xóa");
        xoaCollect.setFont(new Font(null, Font.PLAIN, 18));
        xoaCollect.setForeground(Color.BLACK);
        xoaCollect.setIcon(data.imagePath.resize_deleteButton);
        // xoaCollect.setBounds(1120, 270, 115, 50);
        gdc_ordercollect.gridx = 4;
        gdc_ordercollect.gridy = 3;
        gdc_ordercollect.fill = GridBagConstraints.HORIZONTAL;
        gdc_ordercollect.insets = new Insets(0, 5, 30, 50);
        orderCollect.add(xoaCollect, gdc_ordercollect);

        // JLabel backgroundCollect = new JLabel();
        // backgroundCollect.setIcon(new ImageIcon(advance.img+"backgrounds.jpg"));
        // backgroundCollect.setBounds(0,0, 1280, 720);
        // orderCollect.add(backgroundCollect);

        //Panel Thuốc
        JPanel medic = new JPanel();
        medic.setBackground(Color.white);
        medic.setLayout(new GridBagLayout());

        JScrollPane medicScroll = new JScrollPane();
        medicScroll.setViewportView(medic);

        tab.addTab("Thuốc", data.imagePath.resize_medic, medicScroll);

        GridBagConstraints gdc_medic = new GridBagConstraints();

        JLabel titleMedic = new JLabel("Danh Sách Thuốc");
        titleMedic.setForeground(Color.BLACK);
        titleMedic.setFont(new Font(null, Font.BOLD, 30));
        // titleMedic.setBounds(450, 2, 500, 40);
        gdc_medic.gridx = 0;
        gdc_medic.gridy = 0;
        gdc_medic.gridwidth = 4;
        gdc_medic.anchor = GridBagConstraints.CENTER;
        gdc_medic.insets = new Insets(20, 0, 20, 0);
        medic.add(titleMedic, gdc_medic);

        // reset
        gdc_medic.gridwidth = 1;

        JTextField search_bar_3 = new JTextField("Nhập tên thuốc...");
        search_bar_3.setForeground(Color.BLACK);
        search_bar_3.setFont(new Font(null, Font.PLAIN, 18));
        // search_bar_3.setBounds(300, 45, 200, 30);
        gdc_medic.gridx = 0;
        gdc_medic.gridy = 1;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.weightx = 1.2;
        gdc_medic.insets = new Insets(0, 50, 30, 5);
        medic.add(search_bar_3, gdc_medic);

        JButton search_3 = new JButton("Tìm Kiếm");
        search_3.setForeground(Color.BLACK);
        search_3.setFont(new Font(null, Font.PLAIN, 18));
        // search_3.setBounds(520, 45, 120, 30);
        gdc_medic.gridx = 1;
        gdc_medic.gridy = 1;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.weightx = 0.5;
        gdc_medic.insets = new Insets(0, 5, 30, 5);
        medic.add(search_3, gdc_medic);

        JButton search_advance_3 = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_3.setForeground(Color.BLACK);
        search_advance_3.setFont(new Font(null, Font.PLAIN, 18));
        // search_advance_3.setBounds(660, 45, 220, 30);
        gdc_medic.gridx = 2;
        gdc_medic.gridy = 1;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.weightx = 1;
        gdc_medic.insets = new Insets(0, 5, 30, 5);
        medic.add(search_advance_3, gdc_medic);

        JButton reset_3 = new JButton();
        reset_3.setForeground(Color.BLACK);
        reset_3.setFont(new Font(null, Font.PLAIN, 18));
        reset_3.setIcon(data.imagePath.resize_reset);
        // reset_3.setBounds(900, 45, 30, 30);
        gdc_medic.gridx = 3;
        gdc_medic.gridy = 1;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.weightx = 0.2;
        gdc_medic.insets = new Insets(0, 5, 30, 50);
        medic.add(reset_3, gdc_medic);
        
        // reset
        gdc_medic.fill = GridBagConstraints.NONE;
        gdc_medic.weightx = 0;

        String columnsMedic[] = {"Mã thuốc", "Tên thuốc", "Danh mục", "Tình trạng", 
        "Xem chi tiết"};
        DefaultTableModel modelMedic = new DefaultTableModel(columnsMedic,0) {
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

        JScrollPane scrollMedic = new JScrollPane(tableMedic);
        // scrollMedic.setBounds(40, 90, 1050, 500);
        gdc_medic.gridx = 0;
        gdc_medic.gridy = 2;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.gridwidth = 3;
        gdc_medic.gridheight = 3;
        gdc_medic.insets = new Insets(0, 50, 30, 5);
        medic.add(scrollMedic, gdc_medic);

        // reset
        gdc_medic.gridwidth = 1;
        gdc_medic.gridheight = 1;

        JButton themMedic = new JButton("Thêm");
        themMedic.setFont(new Font(null, Font.PLAIN, 18));
        themMedic.setForeground(Color.BLACK);
        themMedic.setIcon(data.imagePath.resize_addButton);
        // themMedic.setBounds(1120, 90, 115, 50);
        gdc_medic.gridx = 3;
        gdc_medic.gridy = 2;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.insets = new Insets(0, 5, 30, 50);
        medic.add(themMedic, gdc_medic);

        JButton suaMedic = new JButton("Sửa");
        suaMedic.setFont(new Font(null, Font.PLAIN, 18));
        suaMedic.setForeground(Color.BLACK);
        suaMedic.setIcon(data.imagePath.resize_fixButton);
        // suaMedic.setBounds(1120, 180, 115, 50);
        gdc_medic.gridx = 3;
        gdc_medic.gridy = 3;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.insets = new Insets(0, 5, 30, 50);
        medic.add(suaMedic, gdc_medic);

        JButton xoaMedic = new JButton("Xóa");
        xoaMedic.setFont(new Font(null, Font.PLAIN, 18));
        xoaMedic.setForeground(Color.BLACK);
        xoaMedic.setIcon(data.imagePath.resize_deleteButton);
        // xoaMedic.setBounds(1120, 270, 115, 50);
        gdc_medic.gridx = 3;
        gdc_medic.gridy = 4;
        gdc_medic.fill = GridBagConstraints.HORIZONTAL;
        gdc_medic.insets = new Insets(0, 5, 30, 50);
        medic.add(xoaMedic, gdc_medic);

        // JLabel backgroundMedic = new JLabel();
        // backgroundMedic.setIcon(new ImageIcon(advance.img+"backgrounds.jpg"));
        // backgroundMedic.setBounds(0,0, 1280, 720);
        // medic.add(backgroundMedic);

        //Panel Thống kê
        JPanel statistic = new JPanel();
        statistic.setBackground(Color.white);
        statistic.setLayout(new GridBagLayout());

        JScrollPane statisticScroll = new JScrollPane();
        statisticScroll.setViewportView(statistic);

        tab.addTab("Thống kê", data.imagePath.resize_statistic, statisticScroll);

        GridBagConstraints gdc_statistic = new GridBagConstraints();

        JLabel titleStatistic = new JLabel("Thống Kê Nhân Viên");
        titleStatistic.setForeground(Color.BLACK);
        titleStatistic.setFont(new Font(null, Font.BOLD, 30));
        // titleStatistic.setBounds(450, 20, 500, 50);
        gdc_statistic.gridx = 0;
        gdc_statistic.gridy = 0;
        gdc_statistic.gridwidth = 5;
        gdc_statistic.anchor = GridBagConstraints.CENTER;
        gdc_statistic.insets = new Insets(20, 0, 20, 0);
        statistic.add(titleStatistic, gdc_statistic);

        // reset
        gdc_statistic.gridwidth = 1;
        
        JLabel wallet = new JLabel();
        wallet.setIcon(data.imagePath.resize_wallet);
        wallet.setBorder(BorderFactory.createEmptyBorder(0,0,0,250));
        // wallet.setBounds(70, 150, 100, 100);
        gdc_statistic.gridx = 0;
        gdc_statistic.gridy = 1;
        gdc_statistic.fill = GridBagConstraints.HORIZONTAL;
        gdc_statistic.insets = new Insets(0, 50, 20, 50);
        statistic.add(wallet, gdc_statistic);

        JPanel sellStatistic = new JPanel();
        sellStatistic.setBackground(Color.white);
        sellStatistic.setBorder(new LineBorder(Color.green, 3));
        sellStatistic.setPreferredSize(new Dimension(300, 200));
        // sellStatistic.setBounds(100, 100, 300, 200);
        gdc_statistic.gridx = 0;
        gdc_statistic.gridy = 1;
        gdc_statistic.fill = GridBagConstraints.BOTH;
        gdc_statistic.weightx = 1;
        gdc_statistic.weighty = 1;
        gdc_statistic.insets = new Insets(0, 70, 20, 20);
        statistic.add(sellStatistic, gdc_statistic);

        JLabel customer = new JLabel();
        customer.setIcon(data.imagePath.resize_customer);
        customer.setBorder(BorderFactory.createEmptyBorder(0,0,0,250));
        // customer.setBounds(70, 390, 120, 100);
        gdc_statistic.gridx = 0;
        gdc_statistic.gridy = 2;
        gdc_statistic.fill = GridBagConstraints.HORIZONTAL;
        gdc_statistic.insets = new Insets(0, 50, 20, 50);
        statistic.add(customer, gdc_statistic);

        JPanel customerStatistic = new JPanel();
        customerStatistic.setBackground(Color.white);
        customerStatistic.setBorder(new LineBorder(Color.blue,3));
        customerStatistic.setPreferredSize(new Dimension(300, 200));
        // customerStatistic.setBounds(100, 340, 300, 200);
        gdc_statistic.gridx = 0;
        gdc_statistic.gridy = 2;
        gdc_statistic.fill = GridBagConstraints.BOTH;
        gdc_statistic.weightx = 1;
        gdc_statistic.weighty = 1;
        gdc_statistic.insets = new Insets(0, 70, 20, 20);
        statistic.add(customerStatistic, gdc_statistic);

        JPanel columnStatistic = new JPanel();
        columnStatistic.setBackground(Color.white);
        columnStatistic.setBorder(new LineBorder(Color.red, 3));
        columnStatistic.setPreferredSize(new Dimension(700, 440));
        // columnStatistic.setBounds(500, 100, 700, 440);
        gdc_statistic.gridx = 1;
        gdc_statistic.gridy = 1;
        gdc_statistic.fill = GridBagConstraints.BOTH;
        gdc_statistic.weightx = 1;
        gdc_statistic.weighty = 1;
        gdc_statistic.insets = new Insets(0, 20, 20, 20);
        gdc_statistic.gridwidth = 4;
        gdc_statistic.gridheight = 2;
        statistic.add(columnStatistic, gdc_statistic);

        // JLabel backgroundStatistic = new JLabel();
        // backgroundStatistic.setIcon(new ImageIcon(advance.img+"backgrounds.jpg"));
        // backgroundStatistic.setBounds(0,0, 1280, 720);
        // statistic.add(backgroundStatistic);

        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Tập tin");
        file.setForeground(Color.BLACK);
        file.setFont(new Font(null, Font.BOLD, 16));
        file.setMnemonic('T');
        file.setIcon(data.imagePath.resize_fileIcon);
        JMenu system = new JMenu("Hệ thống");
        system.setForeground(Color.BLACK);
        system.setFont(new Font(null, Font.BOLD, 16));
        system.setMnemonic('H');
        system.setIcon(data.imagePath.resize_systemIcon);
        JMenuItem save = new JMenuItem("Lưu");
        save.setForeground(Color.BLACK);
        save.setFont(new Font(null, Font.PLAIN, 16));
        save.setMnemonic('L');
        save.setIcon(data.imagePath.resize_saveIcon);
        JMenuItem export = new JMenuItem("Xuất");
        export.setForeground(Color.BLACK);
        export.setFont(new Font(null, Font.PLAIN, 16));
        export.setMnemonic('X');
        export.setIcon(data.imagePath.resize_exportIcon);
        JMenuItem log_out = new JMenuItem("Đăng xuất");
        log_out.setForeground(Color.BLACK);
        log_out.setFont(new Font(null, Font.PLAIN, 16));
        log_out.setMnemonic('X');
        log_out.setIcon(data.imagePath.resize_logOut);
        JMenuItem exit = new JMenuItem("Thoát");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font(null, Font.PLAIN, 16));
        exit.setMnemonic('T');
        exit.setIcon(data.imagePath.resize_exitIcon);
        file.add(save);
        file.add(export);
        system.add(log_out);
        system.add(exit);
        menuBar.add(file);
        menuBar.add(system);
        this.setJMenuBar(menuBar);
        
        this.setVisible(true);

        //xử lý các tính năng

        employee_BUS.loadData(nv, manv, tennv, chucvu, gioitinh, cccd, sdt, diachi, nhathuoc, tinhtrang);

        //Hiển thị thông tin nhà thuốc
        btn_nhathuoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!employee_BUS.showStore(nv)) {
                    JOptionPane.showMessageDialog(null, 
                    "Không tìm thấy thông tin nhà thuốc.");
                }
            }
        });

        //Tự động cập nhật thông tin hóa đơn bán



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

        table.getColumn("Xem chi tiết").setCellRenderer(new DefaultTableCellRenderer() {
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

        //xử lý đơn hàng nhập
        //cập nhật thông tin đơn hàng nhập
        orderSupply_BUS.loadData(modelCollect, true);

        tableCollect.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
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

        tableCollect.getColumn("Xem chi tiết").setCellRenderer(new DefaultTableCellRenderer() {
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

        //thêm đơn hàng nhập
        themCollect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new orderSupplyAdd_GUI(modelCollect);
            }
        });

        //xóa đơn hàng nhập
        xoaCollect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!orderSupply_BUS.deleteOrderSupply(tableCollect, modelCollect)) {
                    JOptionPane.showMessageDialog(null, 
                    "Đơn hàng nhập này đã ngừng hoạt động!");
                }
            }
        });

        ArrayList<orderSupply_DTO> orderSupplies = new ArrayList<>();

        //tìm kiếm
        search_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderSupply_BUS.findOrderSupplyByID(orderSupplies, modelCollect, search_bar_2);
            }
        });

        //tìm kiếm nâng cao
        search_advance_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new orderSupplySearch_GUI(modelCollect, loc_2.getSelectedIndex(), orderSupplies);
            }
        });

        //lọc
        loc_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderSupply_BUS.orderSupplyFilter(loc_2, orderSupplies, modelCollect);
            }
        });

        //reset
        reset_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderSupply_BUS.reset(search_bar_2, loc_2, orderSupplies, modelCollect);
            }
        });

        //xem chi tiết
        tableCollect.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                orderSupply_BUS.showDetails(tableCollect, modelCollect);
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

        //Xử lý thuốc
        //Tự động cập nhật thông tin thuốc
        medicine_BUS.loadData(modelMedic, true);

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

        tableMedic.getColumn("Xem chi tiết").setCellRenderer(new DefaultTableCellRenderer() {
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

        //đăng xuất
        log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc muốn đăng xuất không?");
                if(choice == 0) {
                    new login_GUI();
                }
            }
        });

        //thoát
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //xem thuốc
        tableMedic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                medicine_BUS.showDetails(tableMedic, modelMedic);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
        });

        //thêm thuốc
        themMedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new medicineAdd_GUI(modelMedic);
            }
        });

        //sửa thuốc
        suaMedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!medicine_BUS.rectifyMedicine(tableMedic, modelMedic)) {
                    JOptionPane.showMessageDialog(null, 
                    "Thông tin thuốc này đã ngừng hoạt động!");
                }
            }
        });

        //xóa thuốc
        xoaMedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!medicine_BUS.deleteMedicine(tableMedic, modelMedic, modelCollect)) {
                    JOptionPane.showMessageDialog(null, 
                    "Thông tin thuốc này đã ngừng hoạt động!");
                }
            }
        });

        //tìm kiếm
        search_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.searchMedicine(search_bar_3, modelMedic);
            }
        });

        //tìm kiếm nâng cao
        search_advance_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new medicineSearch_GUI(modelMedic, null);
            }
        });

        //reset thuốc
        reset_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.reset(search_bar_3, modelMedic);
            }
        });
    }

    public static void main(String[] args) {
        new employee_GUI(null);
    }
} 
