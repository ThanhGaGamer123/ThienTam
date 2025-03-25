package employee;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import login.signup.login;
import order.order;
import order.orderArr;
import store.store;
import store.storeArr;
import store.storeGUI;

public class employGUI extends JFrame {
    public employGUI(employee nv) {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        this.setTitle("Nhân viên");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        //Tạo Tab Panel
        JTabbedPane tab = new JTabbedPane();
        tab.setBounds(0, 10, 1280, 710);
        tab.setForeground(Color.BLACK);
        tab.setFont(new Font(null, Font.BOLD, 20));
        tab.setBackground(Color.white);

        //Lấy các icon
        ImageIcon statusIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\info.png");
        ImageIcon resize_statusIcon = new ImageIcon(statusIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon order_sell = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\order_sell.png");
        ImageIcon resize_orderSell = new ImageIcon(order_sell.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon addButton = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\add.png");
        ImageIcon resize_addButton = new ImageIcon(addButton.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon fixButton = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\fix.png");
        ImageIcon resize_fixButton = new ImageIcon(fixButton.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon deleteButton = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\delete.png");
        ImageIcon resize_deleteButton = new ImageIcon(deleteButton.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon Package = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\package.png");
        ImageIcon resize_package = new ImageIcon(Package.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon Medic = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\medic.png");
        ImageIcon resize_medic = new ImageIcon(Medic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon Statistic = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\statistic.png");
        ImageIcon resize_statistic = new ImageIcon(Statistic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        ImageIcon fileIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\file.png");
        ImageIcon resize_fileIcon = new ImageIcon(fileIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon systemIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\system.png");
        ImageIcon resize_systemIcon = new ImageIcon(systemIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon saveIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\save.png");
        ImageIcon resize_saveIcon = new ImageIcon(saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon exportIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\export.png");
        ImageIcon resize_exportIcon = new ImageIcon(exportIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon logOut = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\log_out.png");
        ImageIcon resize_logOut = new ImageIcon(logOut.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon exitIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\exit.png");
        ImageIcon resize_exitIcon = new ImageIcon(exitIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon Check = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\check.png");
        ImageIcon resize_check = new ImageIcon(Check.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon eye = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\eyes.png");
        ImageIcon resize_eye = new ImageIcon(eye.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon Reset = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\reset.png");
        ImageIcon resize_reset = new ImageIcon(Reset.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        

        ImageIcon Wallet = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\wallet.png");
        ImageIcon resize_wallet = new ImageIcon(Wallet.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        ImageIcon Customer = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\customer.png");
        ImageIcon resize_customer = new ImageIcon(Customer.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH));

        //Panel Thông tin nhân viên
        JPanel employeeStatus = new JPanel();
        employeeStatus.setBackground(Color.white);
        employeeStatus.setLayout(null);

        JLabel title = new JLabel("Thông Tin Nhân Viên");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setBounds(200,80,500,50);
        employeeStatus.add(title);

        JLabel manv = new JLabel("Mã nhân viên: ");
        manv.setForeground(Color.BLACK);
        manv.setFont(new Font(null, Font.PLAIN, 20));
        manv.setBounds(200,140,300,30);
        employeeStatus.add(manv);

        JLabel tennv = new JLabel("Tên nhân viên: ");
        tennv.setForeground(Color.BLACK);
        tennv.setFont(new Font(null, Font.PLAIN, 20));
        tennv.setBounds(200,180,300,30);
        employeeStatus.add(tennv);

        JLabel chucvu = new JLabel("Chức vụ: ");
        chucvu.setForeground(Color.BLACK);
        chucvu.setFont(new Font(null, Font.PLAIN, 20));
        chucvu.setBounds(200,220,300,30);
        employeeStatus.add(chucvu);

        JLabel sdt = new JLabel("Số điện thoại: ");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font(null, Font.PLAIN, 20));
        sdt.setBounds(200,260,300,30);
        employeeStatus.add(sdt);

        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        diachi.setBounds(200,300,700,30);
        employeeStatus.add(diachi);

        JLabel nhathuoc = new JLabel("Mã nhà thuốc: ");
        nhathuoc.setForeground(Color.BLACK);
        nhathuoc.setFont(new Font(null, Font.PLAIN, 20));
        nhathuoc.setBounds(200,340,300,30);
        employeeStatus.add(nhathuoc);

        JButton btn_nhathuoc = new JButton("Xem chi tiết");
        btn_nhathuoc.setForeground(Color.BLACK);
        btn_nhathuoc.setFont(new Font(null, Font.PLAIN, 16));
        btn_nhathuoc.setBounds(440,340,120,30);
        employeeStatus.add(btn_nhathuoc);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\backgrounds.jpg"));
        background.setBounds(0,0, 1280, 720);
        employeeStatus.add(background);

        //Panel Hóa đơn bán
        JPanel orderSell = new JPanel();
        orderSell.setBackground(Color.white);
        orderSell.setLayout(null);

        JLabel titleSell = new JLabel("Danh Sách Hóa Đơn Bán");
        titleSell.setForeground(Color.BLACK);
        titleSell.setFont(new Font(null, Font.BOLD, 30));
        titleSell.setBounds(450, 2, 500, 40);
        orderSell.add(titleSell);

        JTextField search_bar = new JTextField("Nhập mã đơn...");
        search_bar.setForeground(Color.BLACK);
        search_bar.setFont(new Font(null, Font.PLAIN, 18));
        search_bar.setBounds(200, 45, 200, 30);
        orderSell.add(search_bar);

        JButton search = new JButton("Tìm Kiếm");
        search.setForeground(Color.BLACK);
        search.setFont(new Font(null, Font.PLAIN, 18));
        search.setBounds(420, 45, 120, 30);
        orderSell.add(search);

        JButton search_advance = new JButton("Tìm Kiếm Nâng Cao");
        search_advance.setForeground(Color.BLACK);
        search_advance.setFont(new Font(null, Font.PLAIN, 18));
        search_advance.setBounds(560, 45, 220, 30);
        orderSell.add(search_advance);

        String[] option = {"Tùy chọn", "Tổng tiền từ cao tới thấp", "Tổng tiền từ thấp tới cao",
        "Thời gian gần nhất", "Thời gian xa nhất"};
        JComboBox loc = new JComboBox<>(option);
        loc.setForeground(Color.BLACK);
        loc.setFont(new Font(null, Font.PLAIN, 18));
        loc.setBounds(800, 45, 230, 30);
        orderSell.add(loc);

        JButton reset = new JButton();
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 18));
        reset.setBounds(1050, 45, 30, 30);
        reset.setIcon(resize_reset);
        orderSell.add(reset);

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
        scroll.setBounds(40, 90, 1050, 500);
        orderSell.add(scroll);

        JButton themSell = new JButton("Thêm");
        themSell.setFont(new Font(null, Font.PLAIN, 18));
        themSell.setForeground(Color.BLACK);
        themSell.setBounds(1120, 90, 115, 50);
        themSell.setIcon(resize_addButton);
        orderSell.add(themSell);

        JButton suaSell = new JButton("Sửa");
        suaSell.setFont(new Font(null, Font.PLAIN, 18));
        suaSell.setForeground(Color.BLACK);
        suaSell.setBounds(1120, 180, 115, 50);
        suaSell.setIcon(resize_fixButton);
        orderSell.add(suaSell);

        JButton xoaSell = new JButton("Xóa");
        xoaSell.setFont(new Font(null, Font.PLAIN, 18));
        xoaSell.setForeground(Color.BLACK);
        xoaSell.setBounds(1120, 270, 115, 50);
        xoaSell.setIcon(resize_deleteButton);
        orderSell.add(xoaSell);

        JLabel backgroundSell = new JLabel();
        backgroundSell.setIcon(new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\backgrounds.jpg"));
        backgroundSell.setBounds(0,0, 1280, 720);
        orderSell.add(backgroundSell);

        //Panel Hóa đơn nhập
        JPanel orderCollect = new JPanel();
        orderCollect.setBackground(Color.white);
        orderCollect.setLayout(null);

        JLabel titleCollect = new JLabel("Danh Sách Hóa Đơn Nhập");
        titleCollect.setForeground(Color.BLACK);
        titleCollect.setFont(new Font(null, Font.BOLD, 30));
        titleCollect.setBounds(450, 2, 500, 40);
        orderCollect.add(titleCollect);

        JTextField search_bar_2 = new JTextField("Nhập mã đơn...");
        search_bar_2.setForeground(Color.BLACK);
        search_bar_2.setFont(new Font(null, Font.PLAIN, 18));
        search_bar_2.setBounds(200, 45, 200, 30);
        orderCollect.add(search_bar_2);

        JButton search_2 = new JButton("Tìm Kiếm");
        search_2.setForeground(Color.BLACK);
        search_2.setFont(new Font(null, Font.PLAIN, 18));
        search_2.setBounds(420, 45, 120, 30);
        orderCollect.add(search_2);

        JButton search_advance_2 = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_2.setForeground(Color.BLACK);
        search_advance_2.setFont(new Font(null, Font.PLAIN, 18));
        search_advance_2.setBounds(560, 45, 220, 30);
        orderCollect.add(search_advance_2);

        JButton reset_2 = new JButton();
        reset_2.setForeground(Color.BLACK);
        reset_2.setFont(new Font(null, Font.PLAIN, 18));
        reset_2.setBounds(1050, 45, 30, 30);
        reset_2.setIcon(resize_reset);
        orderCollect.add(reset_2);

        String[] option_2 = {"Tùy chọn", "Tổng tiền từ cao tới thấp", "Tổng tiền từ thấp tới cao",
        "Thời gian gần nhất", "Thời gian xa nhất"};
        JComboBox loc_2 = new JComboBox<>(option_2);
        loc_2.setForeground(Color.BLACK);
        loc_2.setFont(new Font(null, Font.PLAIN, 18));
        loc_2.setBounds(800, 45, 230, 30);
        orderCollect.add(loc_2);

        String columnsCollect[] = {"Mã đơn", "Mã nhà cung cấp", "Số loại thuốc", "Ngày nhập", 
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
        scrollCollect.setBounds(40, 90, 1050, 500);
        orderCollect.add(scrollCollect);

        JButton themCollect = new JButton("Thêm");
        themCollect.setFont(new Font(null, Font.PLAIN, 18));
        themCollect.setForeground(Color.BLACK);
        themCollect.setBounds(1120, 90, 115, 50);
        themCollect.setIcon(resize_addButton);
        orderCollect.add(themCollect);

        JButton suaCollect = new JButton("Sửa");
        suaCollect.setFont(new Font(null, Font.PLAIN, 18));
        suaCollect.setForeground(Color.BLACK);
        suaCollect.setBounds(1120, 180, 115, 50);
        suaCollect.setIcon(resize_fixButton);
        orderCollect.add(suaCollect);

        JButton xoaCollect = new JButton("Xóa");
        xoaCollect.setFont(new Font(null, Font.PLAIN, 18));
        xoaCollect.setForeground(Color.BLACK);
        xoaCollect.setBounds(1120, 270, 115, 50);
        xoaCollect.setIcon(resize_deleteButton);
        orderCollect.add(xoaCollect);

        JLabel backgroundCollect = new JLabel();
        backgroundCollect.setIcon(new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\backgrounds.jpg"));
        backgroundCollect.setBounds(0,0, 1280, 720);
        orderCollect.add(backgroundCollect);

        //Panel Thuốc
        JPanel medic = new JPanel();
        medic.setBackground(Color.white);
        medic.setLayout(null);

        JLabel titleMedic = new JLabel("Danh Sách Thuốc");
        titleMedic.setForeground(Color.BLACK);
        titleMedic.setFont(new Font(null, Font.BOLD, 30));
        titleMedic.setBounds(450, 2, 500, 40);
        medic.add(titleMedic);

        JTextField search_bar_3 = new JTextField("Nhập mã thuốc...");
        search_bar_3.setForeground(Color.BLACK);
        search_bar_3.setFont(new Font(null, Font.PLAIN, 18));
        search_bar_3.setBounds(300, 45, 200, 30);
        medic.add(search_bar_3);

        JButton search_3 = new JButton("Tìm Kiếm");
        search_3.setForeground(Color.BLACK);
        search_3.setFont(new Font(null, Font.PLAIN, 18));
        search_3.setBounds(520, 45, 120, 30);
        medic.add(search_3);

        JButton search_advance_3 = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_3.setForeground(Color.BLACK);
        search_advance_3.setFont(new Font(null, Font.PLAIN, 18));
        search_advance_3.setBounds(660, 45, 220, 30);
        medic.add(search_advance_3);

        JButton reset_3 = new JButton();
        reset_3.setForeground(Color.BLACK);
        reset_3.setFont(new Font(null, Font.PLAIN, 18));
        reset_3.setBounds(900, 45, 30, 30);
        reset_3.setIcon(resize_reset);
        medic.add(reset_3);

        String columnsMedic[] = {"Mã thuốc", "Mã tồn", "Tên thuốc", "Danh mục", 
        "Xuất xứ", "Xem chi tiết"};
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
        tableMedic.getColumnModel().getColumn(1).setPreferredWidth(10);
        tableMedic.getColumnModel().getColumn(4).setPreferredWidth(10);
        tableMedic.setRowHeight(30);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableMedic.getColumnCount(); i++) {
            tableMedic.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollMedic = new JScrollPane(tableMedic);
        scrollMedic.setBounds(40, 90, 1050, 500);
        medic.add(scrollMedic);

        JButton themMedic = new JButton("Thêm");
        themMedic.setFont(new Font(null, Font.PLAIN, 18));
        themMedic.setForeground(Color.BLACK);
        themMedic.setBounds(1120, 90, 115, 50);
        themMedic.setIcon(resize_addButton);
        medic.add(themMedic);

        JButton suaMedic = new JButton("Sửa");
        suaMedic.setFont(new Font(null, Font.PLAIN, 18));
        suaMedic.setForeground(Color.BLACK);
        suaMedic.setBounds(1120, 180, 115, 50);
        suaMedic.setIcon(resize_fixButton);
        medic.add(suaMedic);

        JButton xoaMedic = new JButton("Xóa");
        xoaMedic.setFont(new Font(null, Font.PLAIN, 18));
        xoaMedic.setForeground(Color.BLACK);
        xoaMedic.setBounds(1120, 270, 115, 50);
        xoaMedic.setIcon(resize_deleteButton);
        medic.add(xoaMedic);

        JLabel backgroundMedic = new JLabel();
        backgroundMedic.setIcon(new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\backgrounds.jpg"));
        backgroundMedic.setBounds(0,0, 1280, 720);
        medic.add(backgroundMedic);

        //Panel Thống kê
        JPanel statistic = new JPanel();
        statistic.setBackground(Color.white);
        statistic.setLayout(null);

        JLabel titleStatistic = new JLabel("Thống Kê Nhân Viên");
        titleStatistic.setForeground(Color.BLACK);
        titleStatistic.setFont(new Font(null, Font.BOLD, 30));
        titleStatistic.setBounds(450, 20, 500, 50);
        statistic.add(titleStatistic);

        
        JLabel wallet = new JLabel();
        wallet.setIcon(resize_wallet);
        wallet.setBounds(70, 150, 100, 100);
        statistic.add(wallet);

        JPanel sellStatistic = new JPanel();
        sellStatistic.setBackground(Color.white);
        sellStatistic.setBounds(100, 100, 300, 200);
        sellStatistic.setBorder(new LineBorder(Color.green, 3));
        statistic.add(sellStatistic);

        JLabel customer = new JLabel();
        customer.setIcon(resize_customer);
        customer.setBounds(70, 390, 120, 100);
        statistic.add(customer);

        JPanel customerStatistic = new JPanel();
        customerStatistic.setBackground(Color.white);
        customerStatistic.setBounds(100, 340, 300, 200);
        customerStatistic.setBorder(new LineBorder(Color.blue,3));
        statistic.add(customerStatistic);

        JPanel columnStatistic = new JPanel();
        columnStatistic.setBackground(Color.white);
        columnStatistic.setBounds(500, 100, 700, 440);
        columnStatistic.setBorder(new LineBorder(Color.red, 3));
        statistic.add(columnStatistic);

        JLabel backgroundStatistic = new JLabel();
        backgroundStatistic.setIcon(new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\backgrounds.jpg"));
        backgroundStatistic.setBounds(0,0, 1280, 720);
        statistic.add(backgroundStatistic);

        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Tập tin");
        file.setForeground(Color.BLACK);
        file.setFont(new Font(null, Font.BOLD, 16));
        file.setMnemonic('T');
        file.setIcon(resize_fileIcon);
        JMenu system = new JMenu("Hệ thống");
        system.setForeground(Color.BLACK);
        system.setFont(new Font(null, Font.BOLD, 16));
        system.setMnemonic('H');
        system.setIcon(resize_systemIcon);
        JMenuItem save = new JMenuItem("Lưu");
        save.setForeground(Color.BLACK);
        save.setFont(new Font(null, Font.PLAIN, 16));
        save.setMnemonic('L');
        save.setIcon(resize_saveIcon);
        JMenuItem export = new JMenuItem("Xuất");
        export.setForeground(Color.BLACK);
        export.setFont(new Font(null, Font.PLAIN, 16));
        export.setMnemonic('X');
        export.setIcon(resize_exportIcon);
        JMenuItem log_out = new JMenuItem("Đăng xuất");
        log_out.setForeground(Color.BLACK);
        log_out.setFont(new Font(null, Font.PLAIN, 16));
        log_out.setMnemonic('X');
        log_out.setIcon(resize_logOut);
        JMenuItem exit = new JMenuItem("Thoát");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font(null, Font.PLAIN, 16));
        exit.setMnemonic('T');
        exit.setIcon(resize_exitIcon);
        file.add(save);
        file.add(export);
        system.add(log_out);
        system.add(exit);
        menuBar.add(file);
        menuBar.add(system);
        this.setJMenuBar(menuBar);

        tab.addTab("Thông tin", resize_statusIcon, employeeStatus);
        tab.addTab("Hóa đơn bán", resize_orderSell, orderSell);
        tab.addTab("Hóa đơn nhập", resize_package, orderCollect);
        tab.addTab("Thuốc", resize_medic, medic);
        tab.addTab("Thống kê", resize_statistic, statistic);
        this.add(tab);
        
        this.setVisible(true);

        //xử lý các tính năng

        //Tự động điền thông tin khi đăng nhập:
        manv.setText(manv.getText() + nv.getManv());
        tennv.setText(tennv.getText() + nv.getTennv());
        chucvu.setText(chucvu.getText() + nv.getChucvu());
        sdt.setText(sdt.getText() + nv.getSdt());
        diachi.setText(diachi.getText() + nv.getMasonha() + ", " + nv.getDuong() + ", "
        + nv.getPhuong() + ", " + nv.getQuan() + ", " + nv.getTinh());
        nhathuoc.setText(nhathuoc.getText() + nv.getManhathuoc());

        //Hiển thị thông tin nhà thuốc
        btn_nhathuoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeArr arr = new storeArr();
                arr.readFile();
                Boolean found = false;
                for(store nt : arr.getArr()) {
                    if(nv.getManhathuoc().equals(nt.getMant())) {
                        new storeGUI(nt);
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    JOptionPane.showMessageDialog(null, 
                    "Không tìm thấy thông tin nhà thuốc.");
                }
            }
        });

        //Tự động cập nhật thông tin hóa đơn bán
        orderArr arr = new orderArr();
        arr.readFile();
        for(order dh : arr.getArr()) {
            if(nv.getManv().equals(dh.getManv())) {
                JLabel statusImg;
                if(dh.getTinhtrang().equals("true")) {
                    statusImg = new JLabel(resize_check);
                } else {
                    statusImg = new JLabel(resize_exitIcon);
                }
                JButton eyeButton = new JButton(resize_eye);
                model.addRow(new Object[]{dh.getMadon(),dh.getMakh(),dh.getManv(),
                dh.getNgaydat(),dh.getTongtien(),statusImg,eyeButton});
            }
        }

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

        //đăng xuất
        log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc muốn đăng xuất không?");
                if(choice == 0) {
                    new login();
                    dispose();
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
    }

    public static void main(String[] args) {
        new employGUI(null);
    }
} 
