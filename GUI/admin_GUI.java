package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.customer_BUS;
import BUS.employee_BUS;
import BUS.promotion_BUS;
import BUS.storage_BUS;
import BUS.store_BUS;
import BUS.supplier_BUS;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.promotion_DTO;
import DTO.store_DTO;
import DTO.supplier_DTO;
import advanceMethod.advance;

public class admin_GUI extends JFrame {
    DefaultTableModel modelSupplier, modelStorage, modelCustomer, modelEmployee, modelPromotion, modelStore;
    JTable tableSupplier, tableStorage, tableCustomer, tableEmployee, tablePromotion, tableStore;

    private void searchTableSupplier(String query) {
        DefaultTableModel model = (DefaultTableModel) tableSupplier.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableSupplier.setRowSorter(sorter);
        if (query.trim().isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị tất cả nếu không có từ khóa
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Lọc theo từ khóa (không phân biệt hoa thường)
        }
    }

    private void searchTableStorage(String query) {
        DefaultTableModel model = (DefaultTableModel) tableStorage.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableStorage.setRowSorter(sorter);
        if (query.trim().isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị tất cả nếu không có từ khóa
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Lọc theo từ khóa (không phân biệt hoa thường)
        }
    }

    private void searchTableCustomer(String query) {
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableCustomer.setRowSorter(sorter);
        if (query.trim().isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị tất cả nếu không có từ khóa
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Lọc theo từ khóa (không phân biệt hoa thường)
        }
    }

    private void searchTableEmployee(String query) {
        DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableEmployee.setRowSorter(sorter);
        if (query.trim().isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị tất cả nếu không có từ khóa
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Lọc theo từ khóa (không phân biệt hoa thường)
        }
    }

    private void searchTablePromotion(String query) {
        DefaultTableModel model = (DefaultTableModel) tablePromotion.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tablePromotion.setRowSorter(sorter);
        if (query.trim().isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị tất cả nếu không có từ khóa
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Lọc theo từ khóa (không phân biệt hoa thường)
        }
    }

    private void searchTableStore(String query) {
        DefaultTableModel model = (DefaultTableModel) tableStore.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tableStore.setRowSorter(sorter);
        if (query.trim().isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị tất cả nếu không có từ khóa
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Lọc theo từ khóa (không phân biệt hoa thường)
        }
    }

    public admin_GUI(employee_DTO nv) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        this.setTitle("Quản lý");
        ImageIcon logo = new ImageIcon(advance.img + "logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        // Tạo Tab Panel
        JTabbedPane tab = new JTabbedPane();
        tab.setForeground(Color.BLACK);
        tab.setFont(new Font(null, Font.BOLD, 20));
        tab.setBackground(Color.white);
        // tab.setBounds(0, 10, 1280, 710);
        this.add(tab, BorderLayout.CENTER);

        // Panel Thông tin quản lý
        JPanel employeeStatus = new JPanel();
        employeeStatus.setBackground(Color.white);
        employeeStatus.setLayout(new GridBagLayout());

        JScrollPane employeeScroll = new JScrollPane();
        employeeScroll.setViewportView(employeeStatus);

        GridBagConstraints gdc_employee = new GridBagConstraints();

        gdc_employee.gridwidth = 1;
        gdc_employee.gridheight = 1;

        JLabel title = new JLabel("Thông Tin Quản Lý");
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

        JLabel manv = new JLabel("Mã quản lý: ");
        manv.setForeground(Color.BLACK);
        manv.setFont(new Font(null, Font.PLAIN, 22));
        // manv.setBounds(200,140,300,30);
        gdc_employee.gridy = 1;
        gdc_employee.gridx = 0;
        gdc_employee.anchor = GridBagConstraints.WEST;
        gdc_employee.insets = new Insets(0, 0, 30, 0);
        employeeStatus.add(manv, gdc_employee);

        JLabel tennv = new JLabel("Tên quản lý: ");
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

        // Panel nha cung cap
        JPanel supplier = new JPanel();
        supplier.setBackground(Color.white);
        supplier.setLayout(new GridBagLayout());

        JScrollPane supplierScroll = new JScrollPane();
        supplierScroll.setViewportView(supplier);
        
        GridBagConstraints gdc_supplier = new GridBagConstraints();

        JLabel titleSup = new JLabel("Danh Sách Nhà Cung Cấp");
        titleSup.setForeground(Color.BLACK);
        titleSup.setFont(new Font(null, Font.BOLD, 30));
        gdc_supplier.gridx = 0;
        gdc_supplier.gridy = 0;
        gdc_supplier.gridwidth = 5;
        gdc_supplier.anchor = GridBagConstraints.CENTER;
        gdc_supplier.insets = new Insets(20, 0, 20, 0);
        supplier.add(titleSup, gdc_supplier);

        JPanel panel_btn_supplier = new JPanel();
        panel_btn_supplier.setPreferredSize(new Dimension(0, 50));
        panel_btn_supplier.setBackground(Color.white);
        panel_btn_supplier.setLayout(new BorderLayout());
        gdc_supplier.gridx = 0;
        gdc_supplier.gridy = 1;
        gdc_supplier.gridwidth = 5;
        gdc_supplier.fill = GridBagConstraints.HORIZONTAL;
        gdc_supplier.weightx = 1.0;
        supplier.add(panel_btn_supplier, gdc_supplier);

        JPanel panel_btn_supplier_1 = new JPanel();
        panel_btn_supplier.add(panel_btn_supplier_1, BorderLayout.CENTER);
        panel_btn_supplier_1.setBackground(Color.BLUE);
        panel_btn_supplier_1.setLayout(new BorderLayout());

        JPanel panel_btn_supplier_2 = new JPanel();
        panel_btn_supplier_2.setPreferredSize(new Dimension(600, 50));
        panel_btn_supplier.add(panel_btn_supplier_2, BorderLayout.EAST);
        panel_btn_supplier_2.setBackground(Color.YELLOW);
        panel_btn_supplier_2.setLayout(new GridLayout(1, 4));

        JTextField search_bar_sup = new JTextField("Tìm kiếm");
        search_bar_sup.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTableSupplier(search_bar_sup.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTableSupplier(search_bar_sup.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTableSupplier(search_bar_sup.getText());
            }

        });
        search_bar_sup.setForeground(Color.BLACK);
        search_bar_sup.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_1.add(search_bar_sup, BorderLayout.CENTER);

        JButton search_advance_sup = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_sup.setPreferredSize(new Dimension(200, 50));
        search_advance_sup.setForeground(Color.BLACK);
        search_advance_sup.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_1.add(search_advance_sup, BorderLayout.EAST);

        JButton reset_sup = new JButton();
        reset_sup.setIcon(data.imagePath.resize_reset);
        reset_sup.setForeground(Color.BLACK);
        reset_sup.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2.add(reset_sup);

        JButton add_sup = new JButton("Thêm");
        add_sup.setIcon(data.imagePath.resize_addButton);
        add_sup.setForeground(Color.BLACK);
        add_sup.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2.add(add_sup);

        JButton edit_sup = new JButton("Sửa");
        edit_sup.setIcon(data.imagePath.resize_fixButton);
        edit_sup.setForeground(Color.BLACK);
        edit_sup.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2.add(edit_sup);

        JButton delete_sup = new JButton("Xóa");
        delete_sup.setIcon(data.imagePath.resize_deleteButton);
        delete_sup.setForeground(Color.BLACK);
        delete_sup.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2.add(delete_sup);

        String columnsSup[] = { "Mã NCC", "Tên NCC", "SDT", "Địa chỉ", "Tình trạng" };
        modelSupplier = new DefaultTableModel(columnsSup, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableSupplier = new JTable(modelSupplier);
        tableSupplier.setRowHeight(30);
        tableSupplier.setFont(new Font(null, Font.PLAIN, 18));
        tableSupplier.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableSupplier.getTableHeader().setForeground(Color.WHITE);
        tableSupplier.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableSupplier.getColumnCount(); i++) {
            tableSupplier.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollSup = new JScrollPane(tableSupplier);
        gdc_supplier.gridx = 0;
        gdc_supplier.gridy = 2;
        gdc_supplier.fill = GridBagConstraints.BOTH;
        gdc_supplier.gridwidth = 5;
        gdc_supplier.gridheight = 3;
        gdc_supplier.weightx = 1.0;
        gdc_supplier.weighty = 1.0;
        supplier.add(scrollSup, gdc_supplier);

        supplier_BUS.loadTable(modelSupplier);
        tableSupplier.setModel(modelSupplier);

        // Panel kho
        JPanel storage = new JPanel();
        storage.setBackground(Color.white);
        storage.setLayout(new GridBagLayout());

        JScrollPane storageScroll = new JScrollPane();
        storageScroll.setViewportView(storage);
        
        GridBagConstraints gdc_storage = new GridBagConstraints();

        JLabel titleStorage = new JLabel("Danh sách tồn kho");
        titleStorage.setForeground(Color.BLACK);
        titleStorage.setFont(new Font(null, Font.BOLD, 30));
        gdc_storage.gridx = 0;
        gdc_storage.gridy = 0;
        gdc_storage.gridwidth = 5;
        gdc_storage.anchor = GridBagConstraints.CENTER;
        gdc_storage.insets = new Insets(20, 0, 20, 0);
        storage.add(titleStorage, gdc_storage);

        JPanel panel_btn_storage = new JPanel();
        panel_btn_storage.setPreferredSize(new Dimension(0, 50));
        panel_btn_storage.setBackground(Color.white);
        panel_btn_storage.setLayout(new BorderLayout());
        gdc_storage.gridx = 0;
        gdc_storage.gridy = 1;
        gdc_storage.gridwidth = 5;
        gdc_storage.fill = GridBagConstraints.HORIZONTAL;
        gdc_storage.weightx = 1.0;
        storage.add(panel_btn_storage, gdc_storage);

        JTextField search_bar_storage = new JTextField("Tìm kiếm");
        search_bar_storage.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTableStorage(search_bar_storage.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTableStorage(search_bar_storage.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTableStorage(search_bar_storage.getText());
            }

        });
        search_bar_storage.setForeground(Color.BLACK);
        search_bar_storage.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_storage.add(search_bar_storage, BorderLayout.CENTER);

        String columnsStorage[] = { "Mã tồn", "Tên sản phẩm", "Hộp", "Vỉ", "Viên" };
        modelStorage = new DefaultTableModel(columnsStorage, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableStorage = new JTable(modelStorage);
        tableStorage.setRowHeight(30);
        tableStorage.setFont(new Font(null, Font.PLAIN, 18));
        tableStorage.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableStorage.getTableHeader().setForeground(Color.WHITE);
        tableStorage.getTableHeader().setFont(new Font(null, Font.BOLD, 18));
        JScrollPane scrollStorage = new JScrollPane(tableStorage);
        gdc_storage.gridx = 0;
        gdc_storage.gridy = 2;
        gdc_storage.fill = GridBagConstraints.BOTH;
        gdc_storage.gridwidth = 5;
        gdc_storage.gridheight = 3;
        gdc_storage.weightx = 1.0;
        gdc_storage.weighty = 1.0;
        storage.add(scrollStorage, gdc_storage);

        storage_BUS.loadDataTable(modelStorage);
        tableStorage.setModel(modelStorage);

        // Panel khach hang
        JPanel panel_customer = new JPanel();
        panel_customer.setBackground(Color.white);
        panel_customer.setLayout(new GridBagLayout());

        JScrollPane customerScroll = new JScrollPane();
        customerScroll.setViewportView(panel_customer);
        
        GridBagConstraints gdc_customer = new GridBagConstraints();

        JLabel titleCustomer = new JLabel("Danh sách khách hàng");
        titleCustomer.setForeground(Color.BLACK);
        titleCustomer.setFont(new Font(null, Font.BOLD, 30));
        gdc_customer.gridx = 0;
        gdc_customer.gridy = 0;
        gdc_customer.gridwidth = 5;
        gdc_customer.anchor = GridBagConstraints.CENTER;
        gdc_customer.insets = new Insets(20, 0, 20, 0);
        panel_customer.add(titleCustomer, gdc_customer);

        JPanel panel_btn_supplier_kh = new JPanel();
        panel_btn_supplier_kh.setPreferredSize(new Dimension(0, 50));
        panel_btn_supplier_kh.setBackground(Color.white);
        panel_btn_supplier_kh.setLayout(new BorderLayout());
        gdc_customer.gridx = 0;
        gdc_customer.gridy = 1;
        gdc_customer.gridwidth = 5;
        gdc_customer.fill = GridBagConstraints.HORIZONTAL;
        gdc_customer.weightx = 1.0;
        panel_customer.add(panel_btn_supplier_kh, gdc_customer);

        JPanel panel_btn_supplier_1_kh = new JPanel();
        panel_btn_supplier_kh.add(panel_btn_supplier_1_kh, BorderLayout.CENTER);
        panel_btn_supplier_1_kh.setBackground(Color.BLUE);
        panel_btn_supplier_1_kh.setLayout(new BorderLayout());

        JPanel panel_btn_supplier_2_kh = new JPanel();
        panel_btn_supplier_2_kh.setPreferredSize(new Dimension(600, 50));
        panel_btn_supplier_kh.add(panel_btn_supplier_2_kh, BorderLayout.EAST);
        panel_btn_supplier_2_kh.setBackground(Color.YELLOW);
        panel_btn_supplier_2_kh.setLayout(new GridLayout(1, 4));

        JTextField search_bar_sup_kh = new JTextField("Tìm kiếm");
        search_bar_sup_kh.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTableCustomer(search_bar_sup_kh.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTableCustomer(search_bar_sup_kh.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTableCustomer(search_bar_sup_kh.getText());
            }

        });
        search_bar_sup_kh.setForeground(Color.BLACK);
        search_bar_sup_kh.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_1_kh.add(search_bar_sup_kh, BorderLayout.CENTER);

        JButton search_advance_sup_kh = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_sup_kh.setPreferredSize(new Dimension(200, 50));
        search_advance_sup_kh.setForeground(Color.BLACK);
        search_advance_sup_kh.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_1_kh.add(search_advance_sup_kh, BorderLayout.EAST);

        JButton reset_sup_kh = new JButton();
        reset_sup_kh.setIcon(data.imagePath.resize_reset);
        reset_sup_kh.setForeground(Color.BLACK);
        reset_sup_kh.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_kh.add(reset_sup_kh);

        JButton add_sup_kh = new JButton("Thêm");
        add_sup_kh.setIcon(data.imagePath.resize_addButton);
        add_sup_kh.setForeground(Color.BLACK);
        add_sup_kh.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_kh.add(add_sup_kh);

        JButton edit_sup_kh = new JButton("Sửa");
        edit_sup_kh.setIcon(data.imagePath.resize_fixButton);
        edit_sup_kh.setForeground(Color.BLACK);
        edit_sup_kh.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_kh.add(edit_sup_kh);

        JButton delete_sup_kh = new JButton("Xóa");
        delete_sup_kh.setIcon(data.imagePath.resize_deleteButton);
        delete_sup_kh.setForeground(Color.BLACK);
        delete_sup_kh.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_kh.add(delete_sup_kh);

        String columnsCustomer[] = { "Mã KH", "Tên KH", "SDT", "Email", "Địa chỉ", "Mật khẩu", "Điểm khuyến mãi",
                "Tình trạng" };
        modelCustomer = new DefaultTableModel(columnsCustomer, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableCustomer = new JTable(modelCustomer);
        tableCustomer.setRowHeight(30);
        tableCustomer.setFont(new Font(null, Font.PLAIN, 18));
        tableCustomer.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableCustomer.getTableHeader().setForeground(Color.WHITE);
        tableCustomer.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableCustomer.getColumnCount(); i++) {
            tableCustomer.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollCustomer = new JScrollPane(tableCustomer);
        gdc_customer.gridx = 0;
        gdc_customer.gridy = 2;
        gdc_customer.fill = GridBagConstraints.BOTH;
        gdc_customer.gridwidth = 5;
        gdc_customer.gridheight = 3;
        gdc_customer.weightx = 1.0;
        gdc_customer.weighty = 1.0;
        panel_customer.add(scrollCustomer, gdc_customer);

        customer_BUS.loadTable(modelCustomer);
        tableCustomer.setModel(modelCustomer);

        // Panel nhan vien
        JPanel panel_employee = new JPanel();
        panel_employee.setBackground(Color.white);
        panel_employee.setLayout(new GridBagLayout());

        JScrollPane employeeScroll_1 = new JScrollPane();
        employeeScroll_1.setViewportView(panel_employee);
        
        GridBagConstraints gdc_employee_1 = new GridBagConstraints();

        JLabel titleEmployee = new JLabel("Danh sách nhân viên");
        titleEmployee.setForeground(Color.BLACK);
        titleEmployee.setFont(new Font(null, Font.BOLD, 30));
        gdc_employee_1.gridx = 0;
        gdc_employee_1.gridy = 0;
        gdc_employee_1.gridwidth = 5;
        gdc_employee_1.anchor = GridBagConstraints.CENTER;
        gdc_employee_1.insets = new Insets(20, 0, 20, 0);
        panel_employee.add(titleEmployee, gdc_employee_1);

        JPanel panel_btn_supplier_nv = new JPanel();
        panel_btn_supplier_nv.setPreferredSize(new Dimension(0, 50));
        panel_btn_supplier_nv.setBackground(Color.white);
        panel_btn_supplier_nv.setLayout(new BorderLayout());
        gdc_employee_1.gridx = 0;
        gdc_employee_1.gridy = 1;
        gdc_employee_1.gridwidth = 5;
        gdc_employee_1.fill = GridBagConstraints.HORIZONTAL;
        gdc_employee_1.weightx = 1.0;
        panel_employee.add(panel_btn_supplier_nv, gdc_employee_1);

        JPanel panel_btn_supplier_1_nv = new JPanel();
        panel_btn_supplier_nv.add(panel_btn_supplier_1_nv, BorderLayout.CENTER);
        panel_btn_supplier_1_nv.setBackground(Color.BLUE);
        panel_btn_supplier_1_nv.setLayout(new BorderLayout());

        JPanel panel_btn_supplier_2_nv = new JPanel();
        panel_btn_supplier_2_nv.setPreferredSize(new Dimension(600, 50));
        panel_btn_supplier_nv.add(panel_btn_supplier_2_nv, BorderLayout.EAST);
        panel_btn_supplier_2_nv.setBackground(Color.YELLOW);
        panel_btn_supplier_2_nv.setLayout(new GridLayout(1, 4));

        JTextField search_bar_sup_nv = new JTextField("Tìm kiếm");
        search_bar_sup_nv.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTableEmployee(search_bar_sup_nv.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTableEmployee(search_bar_sup_nv.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTableEmployee(search_bar_sup_nv.getText());
            }

        });
        search_bar_sup_nv.setForeground(Color.BLACK);
        search_bar_sup_nv.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_1_nv.add(search_bar_sup_nv, BorderLayout.CENTER);

        JButton search_advance_sup_nv = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_sup_nv.setPreferredSize(new Dimension(200, 50));
        search_advance_sup_nv.setForeground(Color.BLACK);
        search_advance_sup_nv.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_1_nv.add(search_advance_sup_nv, BorderLayout.EAST);

        JButton reset_sup_nv = new JButton();
        reset_sup_nv.setIcon(data.imagePath.resize_reset);
        reset_sup_nv.setForeground(Color.BLACK);
        reset_sup_nv.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_nv.add(reset_sup_nv);

        JButton add_sup_nv = new JButton("Thêm");
        add_sup_nv.setIcon(data.imagePath.resize_addButton);
        add_sup_nv.setForeground(Color.BLACK);
        add_sup_nv.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_nv.add(add_sup_nv);

        JButton edit_sup_nv = new JButton("Sửa");
        edit_sup_nv.setIcon(data.imagePath.resize_fixButton);
        edit_sup_nv.setForeground(Color.BLACK);
        edit_sup_nv.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_nv.add(edit_sup_nv);

        JButton delete_sup_nv = new JButton("Xóa");
        delete_sup_nv.setIcon(data.imagePath.resize_deleteButton);
        delete_sup_nv.setForeground(Color.BLACK);
        delete_sup_nv.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_supplier_2_nv.add(delete_sup_nv);

        String columnsEmployee[] = { "Mã NV", "Tên NV", "Chức vụ", "Giới tính", "CCCD", "SDT", "Địa chỉ",
                "Tài khoản", "Mật khẩu", "Công tác tại", "Tình trạng" };
        modelEmployee = new DefaultTableModel(columnsEmployee, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableEmployee = new JTable(modelEmployee);
        tableEmployee.setRowHeight(30);
        tableEmployee.setFont(new Font(null, Font.PLAIN, 18));
        tableEmployee.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableEmployee.getTableHeader().setForeground(Color.WHITE);
        tableEmployee.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableEmployee.getColumnCount(); i++) {
            tableEmployee.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollEmployee = new JScrollPane(tableEmployee);
        gdc_employee_1.gridx = 0;
        gdc_employee_1.gridy = 2;
        gdc_employee_1.fill = GridBagConstraints.BOTH;
        gdc_employee_1.gridwidth = 5;
        gdc_employee_1.gridheight = 3;
        gdc_employee_1.weightx = 1.0;
        gdc_employee_1.weighty = 1.0;
        panel_employee.add(scrollEmployee, gdc_employee_1);

        employee_BUS.loadTable(modelEmployee);
        tableEmployee.setModel(modelEmployee);

        // Panel khuyen mai
        JPanel panel_promotion = new JPanel();
        panel_promotion.setBackground(Color.white);
        panel_promotion.setLayout(new GridBagLayout());

        JScrollPane promotionScroll = new JScrollPane();
        promotionScroll.setViewportView(panel_promotion);
        
        GridBagConstraints gdc_promotion = new GridBagConstraints();

        JLabel titlePromotion = new JLabel("Danh sách khuyến mãi");
        titlePromotion.setForeground(Color.BLACK);
        titlePromotion.setFont(new Font(null, Font.BOLD, 30));
        gdc_promotion.gridx = 0;
        gdc_promotion.gridy = 0;
        gdc_promotion.gridwidth = 5;
        gdc_promotion.anchor = GridBagConstraints.CENTER;
        gdc_promotion.insets = new Insets(20, 0, 20, 0);
        panel_promotion.add(titlePromotion, gdc_promotion);

        JPanel panel_btn_promotion = new JPanel();
        panel_btn_promotion.setPreferredSize(new Dimension(0, 50));
        panel_btn_promotion.setBackground(Color.white);
        panel_btn_promotion.setLayout(new BorderLayout());
        gdc_promotion.gridx = 0;
        gdc_promotion.gridy = 1;
        gdc_promotion.gridwidth = 5;
        gdc_promotion.fill = GridBagConstraints.HORIZONTAL;
        gdc_promotion.weightx = 1.0;
        panel_promotion.add(panel_btn_promotion, gdc_promotion);

        JPanel panel_btn_promotion_1 = new JPanel();
        panel_btn_promotion.add(panel_btn_promotion_1, BorderLayout.CENTER);
        panel_btn_promotion_1.setBackground(Color.BLUE);
        panel_btn_promotion_1.setLayout(new BorderLayout());

        JPanel panel_btn_promotion_2 = new JPanel();
        panel_btn_promotion_2.setPreferredSize(new Dimension(600, 50));
        panel_btn_promotion.add(panel_btn_promotion_2, BorderLayout.EAST);
        panel_btn_promotion_2.setBackground(Color.YELLOW);
        panel_btn_promotion_2.setLayout(new GridLayout(1, 4));

        JTextField search_bar_promotion = new JTextField("Tìm kiếm");
        search_bar_promotion.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTablePromotion(search_bar_promotion.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTablePromotion(search_bar_promotion.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTablePromotion(search_bar_promotion.getText());
            }

        });
        search_bar_promotion.setForeground(Color.BLACK);
        search_bar_promotion.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_promotion_1.add(search_bar_promotion, BorderLayout.CENTER);

        JButton search_advance_promotion = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_promotion.setPreferredSize(new Dimension(200, 50));
        search_advance_promotion.setForeground(Color.BLACK);
        search_advance_promotion.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_promotion_1.add(search_advance_promotion, BorderLayout.EAST);

        JButton reset_promotion = new JButton();
        reset_promotion.setIcon(data.imagePath.resize_reset);
        reset_promotion.setForeground(Color.BLACK);
        reset_promotion.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_promotion_2.add(reset_promotion);

        JButton add_promotion = new JButton("Thêm");
        add_promotion.setIcon(data.imagePath.resize_addButton);
        add_promotion.setForeground(Color.BLACK);
        add_promotion.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_promotion_2.add(add_promotion);

        JButton edit_promotion = new JButton("Sửa");
        edit_promotion.setIcon(data.imagePath.resize_fixButton);
        edit_promotion.setForeground(Color.BLACK);
        edit_promotion.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_promotion_2.add(edit_promotion);

        JButton delete_promotion = new JButton("Xóa");
        delete_promotion.setIcon(data.imagePath.resize_deleteButton);
        delete_promotion.setForeground(Color.BLACK);
        delete_promotion.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_promotion_2.add(delete_promotion);

        String columnsPromotion[] = { "Mã KM", "Tên KM", "Ngày bắt đầu", "Ngày kết thúc", "Giảm", "Nội dung",
                "Điểm yêu cầu", "Tình trạng" };
        modelPromotion = new DefaultTableModel(columnsPromotion, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablePromotion = new JTable(modelPromotion);
        tablePromotion.setRowHeight(30);
        tablePromotion.setFont(new Font(null, Font.PLAIN, 18));
        tablePromotion.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tablePromotion.getTableHeader().setForeground(Color.WHITE);
        tablePromotion.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablePromotion.getColumnCount(); i++) {
            tablePromotion.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPromotion = new JScrollPane(tablePromotion);
        gdc_promotion.gridx = 0;
        gdc_promotion.gridy = 2;
        gdc_promotion.fill = GridBagConstraints.BOTH;
        gdc_promotion.gridwidth = 5;
        gdc_promotion.gridheight = 3;
        gdc_promotion.weightx = 1.0;
        gdc_promotion.weighty = 1.0;
        panel_promotion.add(scrollPromotion, gdc_promotion);

        promotion_BUS.loadTable(modelPromotion);
        tablePromotion.setModel(modelPromotion);

        // Panel nha thuoc
        JPanel panel_store = new JPanel();
        panel_store.setBackground(Color.white);
        panel_store.setLayout(new GridBagLayout());

        JScrollPane storeScroll = new JScrollPane();
        storeScroll.setViewportView(panel_store);
        
        GridBagConstraints gdc_store = new GridBagConstraints();

        JLabel titleStore = new JLabel("Danh sách nhà thuốc");
        titleStore.setForeground(Color.BLACK);
        titleStore.setFont(new Font(null, Font.BOLD, 30));
        gdc_store.gridx = 0;
        gdc_store.gridy = 0;
        gdc_store.gridwidth = 5;
        gdc_store.anchor = GridBagConstraints.CENTER;
        gdc_store.insets = new Insets(20, 0, 20, 0);
        panel_store.add(titleStore, gdc_store);

        JPanel panel_btn_store = new JPanel();
        panel_btn_store.setPreferredSize(new Dimension(0, 50));
        panel_btn_store.setBackground(Color.white);
        panel_btn_store.setLayout(new BorderLayout());
        gdc_store.gridx = 0;
        gdc_store.gridy = 1;
        gdc_store.gridwidth = 5;
        gdc_store.fill = GridBagConstraints.HORIZONTAL;
        gdc_store.weightx = 1.0;
        panel_store.add(panel_btn_store, gdc_store);

        JPanel panel_btn_store_1 = new JPanel();
        panel_btn_store.add(panel_btn_store_1, BorderLayout.CENTER);
        panel_btn_store_1.setBackground(Color.BLUE);
        panel_btn_store_1.setLayout(new BorderLayout());

        JPanel panel_btn_store_2 = new JPanel();
        panel_btn_store_2.setPreferredSize(new Dimension(600, 50));
        panel_btn_store.add(panel_btn_store_2, BorderLayout.EAST);
        panel_btn_store_2.setBackground(Color.YELLOW);
        panel_btn_store_2.setLayout(new GridLayout(1, 4));

        JTextField search_bar_store = new JTextField("Tìm kiếm");
        search_bar_store.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchTableStore(search_bar_store.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchTableStore(search_bar_store.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchTableStore(search_bar_store.getText());
            }

        });
        search_bar_store.setForeground(Color.BLACK);
        search_bar_store.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_store_1.add(search_bar_store, BorderLayout.CENTER);

        JButton search_advance_store = new JButton("Tìm Kiếm Nâng Cao");
        search_advance_store.setPreferredSize(new Dimension(200, 50));
        search_advance_store.setForeground(Color.BLACK);
        search_advance_store.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_store_1.add(search_advance_store, BorderLayout.EAST);

        JButton reset_store = new JButton();
        reset_store.setIcon(data.imagePath.resize_reset);
        reset_store.setForeground(Color.BLACK);
        reset_store.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_store_2.add(reset_store);

        JButton add_store = new JButton("Thêm");
        add_store.setIcon(data.imagePath.resize_addButton);
        add_store.setForeground(Color.BLACK);
        add_store.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_store_2.add(add_store);

        JButton edit_store = new JButton("Sửa");
        edit_store.setIcon(data.imagePath.resize_fixButton);
        edit_store.setForeground(Color.BLACK);
        edit_store.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_store_2.add(edit_store);

        JButton delete_store = new JButton("Xóa");
        delete_store.setIcon(data.imagePath.resize_deleteButton);
        delete_store.setForeground(Color.BLACK);
        delete_store.setFont(new Font(null, Font.PLAIN, 18));
        panel_btn_store_2.add(delete_store);

        String columnsStore[] = { "Mã NT", "Địa chỉ", "Người quản lí", "Tình trạng" };
        modelStore = new DefaultTableModel(columnsStore, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableStore = new JTable(modelStore);
        tableStore.setRowHeight(30);
        tableStore.setFont(new Font(null, Font.PLAIN, 18));
        tableStore.getTableHeader().setBackground(new Color(0, 154, 102)); // Màu nền tiêu đề
        tableStore.getTableHeader().setForeground(Color.WHITE);
        tableStore.getTableHeader().setFont(new Font(null, Font.BOLD, 18));

        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableStore.getColumnCount(); i++) {
            tableStore.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollStore = new JScrollPane(tableStore);
        gdc_store.gridx = 0;
        gdc_store.gridy = 2;
        gdc_store.fill = GridBagConstraints.BOTH;
        gdc_store.gridwidth = 5;
        gdc_store.gridheight = 3;
        gdc_store.weightx = 1.0;
        gdc_store.weighty = 1.0;
        panel_store.add(scrollStore, gdc_promotion);

        store_BUS.loadTable(modelStore);
        tableStore.setModel(modelStore);

        // panel thong ke
        JPanel panel_tk = new JPanel();
        panel_tk.setBackground(Color.white);
        panel_tk.setLayout(new GridBagLayout());

        JScrollPane tkScroll = new JScrollPane();
        tkScroll.setViewportView(panel_tk);
        
        GridBagConstraints gdc_tk = new GridBagConstraints();

        JLabel titlepanel_tk = new JLabel("Thống Kê Quản lý");
        titlepanel_tk.setForeground(Color.BLACK);
        titlepanel_tk.setFont(new Font(null, Font.BOLD, 36));
        gdc_tk.gridx = 0;
        gdc_tk.gridy = 0;
        gdc_tk.gridwidth = 12;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.insets = new Insets(20, 0, 20, 0);
        panel_tk.add(titlepanel_tk, gdc_tk);

        // reset
        gdc_tk.gridwidth = 1;

        JLabel ngaybatdau = new JLabel("Từ ngày:");
        ngaybatdau.setForeground(Color.BLACK);
        ngaybatdau.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 0;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 1;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.weightx = 0;
        gdc_tk.insets = new Insets(0, 20, 30, 0);
        panel_tk.add(ngaybatdau, gdc_tk);

        JTextField tf_ngaybatdau = new JTextField("dd/MM/yyyy");
        tf_ngaybatdau.setForeground(Color.BLACK);
        tf_ngaybatdau.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 1;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 2;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.weightx = 1;
        gdc_tk.insets = new Insets(0, 20, 30, 10);
        panel_tk.add(tf_ngaybatdau, gdc_tk);

        JLabel ngayketthuc = new JLabel("Đến ngày:");
        ngayketthuc.setForeground(Color.BLACK);
        ngayketthuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 3;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 1;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.weightx = 0;
        gdc_tk.insets = new Insets(0, 20, 30, 0);
        panel_tk.add(ngayketthuc, gdc_tk);

        JTextField tf_ngayketthuc = new JTextField("dd/MM/yyyy");
        tf_ngayketthuc.setForeground(Color.BLACK);
        tf_ngayketthuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 4;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 2;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.weightx = 1;
        gdc_tk.insets = new Insets(0, 20, 30, 10);
        panel_tk.add(tf_ngayketthuc, gdc_tk);

        String[] options = { "Không có", "Theo doanh thu", "Theo lượng khách hàng"
        , "Theo đơn hàng nhập"};
        JComboBox loai = new JComboBox(options);
        loai.setForeground(Color.BLACK);
        loai.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 6;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 2;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.weightx = 1;
        gdc_tk.insets = new Insets(0, 20, 30, 10);
        panel_tk.add(loai, gdc_tk);

        String[] options2 = { "Không có", "Biểu đồ cột", "Biều đồ miền"
        , "Biểu đồ tròn"};
        JComboBox bieudo = new JComboBox(options2);
        bieudo.setForeground(Color.BLACK);
        bieudo.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 8;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 2;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.weightx = 1;
        gdc_tk.insets = new Insets(0, 20, 30, 10);
        panel_tk.add(bieudo, gdc_tk);

        JButton chon = new JButton("Chọn");
        chon.setForeground(Color.BLACK);
        chon.setFont(new Font(null, Font.PLAIN, 20));
        gdc_tk.gridx = 10;
        gdc_tk.gridy = 1;
        gdc_tk.gridwidth = 1;
        gdc_tk.anchor = GridBagConstraints.CENTER;
        gdc_tk.fill = GridBagConstraints.HORIZONTAL;
        gdc_tk.insets = new Insets(0, 20, 30, 70);
        panel_tk.add(chon, gdc_tk);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        JFreeChart chart = ChartFactory.createAreaChart("", "", "", dataset,
        PlotOrientation.VERTICAL, true, false, false);

        ChartPanel columnStatistic = new ChartPanel(chart, false);
        columnStatistic.setMouseWheelEnabled(false);
        columnStatistic.setMouseZoomable(false);
        columnStatistic.setBackground(Color.white);
        gdc_tk.gridx = 0;
        gdc_tk.gridy = 2;
        gdc_tk.gridwidth = 12;
        gdc_tk.gridheight = 2;
        gdc_tk.fill = GridBagConstraints.BOTH;
        gdc_tk.weightx = 1;
        gdc_tk.weighty = 1;
        gdc_tk.insets = new Insets(0, 20, 20, 70);
        panel_tk.add(columnStatistic, gdc_tk);
        
        tab.addTab("Thông tin", data.imagePath.resize_statusIcon, employeeScroll);
        tab.addTab("Nhà thuốc", data.imagePath.resize_storeIcon, storeScroll);
        tab.addTab("Nhân viên", data.imagePath.resize_employeeIcon, employeeScroll_1);
        tab.addTab("Khách hàng", data.imagePath.resize_customer_adminIcon, customerScroll);
        tab.addTab("Nhà cung cấp", data.imagePath.resize_supplierIcon, supplierScroll);
        tab.addTab("Kho", data.imagePath.resize_storageIcon, storageScroll);
        tab.addTab("Khuyến mãi", data.imagePath.resize_promotionIcon, promotionScroll);
        tab.addTab("Thống kê", data.imagePath.resize_statistic_adminIcon, tkScroll);

        // menu
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
        JMenuItem importData = new JMenuItem("Nhập");
        importData.setForeground(Color.BLACK);
        importData.setFont(new Font(null, Font.PLAIN, 16));
        importData.setMnemonic('N');
        importData.setIcon(data.imagePath.resize_importIcon);
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
        file.add(importData);
        file.add(export);
        system.add(log_out);
        system.add(exit);
        menuBar.add(file);
        menuBar.add(system);
        this.setJMenuBar(menuBar);

        this.setVisible(true);

        employee_BUS.loadData(nv, manv, tennv, chucvu, gioitinh, cccd, sdt, diachi, nhathuoc, tinhtrang);

        // đăng xuất
        log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn đăng xuất không?");
                if (choice == 0) {
                    new login_GUI();
                    dispose();
                }
            }
        });

        // thoát
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // chuc nang thong ke
        chon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ketQua = employee_BUS.loadMapAdmin(dataset, loai, tf_ngaybatdau, tf_ngayketthuc, 
                nv, columnStatistic, bieudo);
                if(ketQua == 1) {
                    JOptionPane.showMessageDialog(null, 
                    "Biểu đồ tròn yêu cầu thống kê trong năm.");
                }
                if(ketQua == -1) {
                    JOptionPane.showMessageDialog(null, 
                    "Chưa có dữ liệu để thống kê.");
                }
            }
        });

        // cell tinh trang
        tableEmployee.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
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
        tableSupplier.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
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
        tableCustomer.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
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
        tablePromotion.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
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
        tableStore.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
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
        // chuc nang nha thuoc
        add_store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.store1_GUI.add();
            }
        });
        reset_store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store_BUS.loadTable(modelStore);
                tableStore.setModel(modelStore);
            }

        });
        edit_store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableStore.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà thuốc để sửa");
                    return;
                } else {
                    String maNT = String.valueOf(tableStore.getValueAt(row, 0));
                    String diaChi = String.valueOf(tableStore.getValueAt(row, 1));
                    String diaChiParts[] = diaChi.split(",");
                    String maSoNha = diaChiParts[0];
                    String duong = diaChiParts[1];
                    String phuong = diaChiParts[2];
                    String quan = diaChiParts[3];
                    String tinh = diaChiParts[4];
                    String tennql = String.valueOf(tableStore.getValueAt(row, 2));
                    String manql = null;
                    ArrayList<employee_DTO> employeelist = new ArrayList<>();
                    employeelist = employee_BUS.getAll();
                    for (employee_DTO st : employeelist) {
                        if (st.getTennv().equals(tennql)) {
                            manql = st.getManv();
                        }
                    }
                    Boolean tinhTrang = false;

                    ArrayList<store_DTO> emlist = store_BUS.getAll();
                    for (store_DTO em : emlist) {
                        if (em.getMant().equals(maNT) && em.getTinhtrang()) {
                            tinhTrang = true;
                        }
                    }
                    store_DTO sto = new store_DTO(maNT, maSoNha, duong, phuong, quan, tinh, manql, tinhTrang);
                    new GUI.store1_GUI.edit(sto);
                }
            }
        });

        delete_store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectRow = tableStore.getSelectedRows();
                ArrayList<store_DTO> dsxoa = new ArrayList<>();
                if (selectRow.length > 0) {
                    for (int row : selectRow) {
                        String maNT = String.valueOf(tableStore.getValueAt(row, 0));
                        String diaChi = String.valueOf(tableStore.getValueAt(row, 1));
                        String diaChiParts[] = diaChi.split(",");
                        String maSoNha = diaChiParts[0];
                        String duong = diaChiParts[1];
                        String phuong = diaChiParts[2];
                        String quan = diaChiParts[3];
                        String tinh = diaChiParts[4];
                        String tennql = String.valueOf(tableStore.getValueAt(row, 2));
                        String manql = null;
                        ArrayList<employee_DTO> employeelist = new ArrayList<>();
                        employeelist = employee_BUS.getAll();
                        for (employee_DTO st : employeelist) {
                            if (st.getTennv().equals(tennql)) {
                                manql = st.getManv();
                            }
                        }
                        Boolean tinhTrang = Boolean.parseBoolean(String.valueOf(tableStore.getValueAt(row, 3)));
                        if (tinhTrang == false) {
                            continue;
                        } else {
                            store_DTO sto = new store_DTO(maNT, maSoNha, duong, phuong, quan, tinh, manql, tinhTrang);
                            dsxoa.add(sto);
                        }
                    }
                    if (dsxoa.size() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Nhà thuốc bạn chọn đang bị tạm dừng vui lòng chọn nhà thuốc đang hoạt động",
                                "Xóa nhà thuốc",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    StringBuilder dsxoaStr = new StringBuilder();
                    for (store_DTO sto : dsxoa) {
                        dsxoaStr.append("Mã: ").append(sto.getMant())
                                .append("\n");
                    }
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn tạm dừng các nhà thuốc sau?\n" + dsxoaStr,
                            "Xóa nhà thuốc",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        for (store_DTO sto : dsxoa) {
                            store_BUS.delete(sto);
                        }
                        store_BUS.loadTable(modelStore);
                        tableStore.setModel(modelStore);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà thuốc", "Xóa nhà thuốc",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        // chuc nang khuyen mai
        add_promotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.promotion_GUI.add();
            }
        });
        reset_promotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promotion_BUS.loadTable(modelPromotion);
                tablePromotion.setModel(modelPromotion);
            }

        });
        edit_promotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablePromotion.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khuyến mãi để sửa");
                    return;
                } else {
                    String maKM = String.valueOf(tablePromotion.getValueAt(row, 0));
                    String tenKM = String.valueOf(tablePromotion.getValueAt(row, 1));
                    String ngaybd = String.valueOf(tablePromotion.getValueAt(row, 2));
                    String ngaykt = String.valueOf(tablePromotion.getValueAt(row, 3));
                    int giam = Integer.parseInt(String.valueOf(tablePromotion.getValueAt(row, 4)));
                    String noidung = String.valueOf(tablePromotion.getValueAt(row, 5));
                    int diemyc = Integer.parseInt(String.valueOf(tablePromotion.getValueAt(row, 6)));
                    Boolean tinhTrang = false;

                    ArrayList<promotion_DTO> emlist = promotion_BUS.getAll();
                    for (promotion_DTO em : emlist) {
                        if (em.getMakm().equals(maKM) && em.getTinhtrang()) {
                            tinhTrang = true;
                        }
                    }
                    promotion_DTO pro = new promotion_DTO(maKM, tenKM, ngaybd, ngaykt, noidung, giam, diemyc,
                            tinhTrang);
                    try {
                        new GUI.promotion_GUI.edit(pro);
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });

        delete_promotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectRow = tablePromotion.getSelectedRows();
                ArrayList<promotion_DTO> dsxoa = new ArrayList<>();
                if (selectRow.length > 0) {
                    for (int row : selectRow) {
                        String maKM = String.valueOf(tablePromotion.getValueAt(row, 0));
                        String tenKM = String.valueOf(tablePromotion.getValueAt(row, 1));
                        String ngaybd = String.valueOf(tablePromotion.getValueAt(row, 2));
                        String ngaykt = String.valueOf(tablePromotion.getValueAt(row, 3));
                        int giam = Integer.parseInt(String.valueOf(tablePromotion.getValueAt(row, 4)));
                        String noidung = String.valueOf(tablePromotion.getValueAt(row, 5));
                        int diemyc = Integer.parseInt(String.valueOf(tablePromotion.getValueAt(row, 6)));
                        Boolean tinhTrang = Boolean.parseBoolean(String.valueOf(tablePromotion.getValueAt(row, 7)));
                        if (tinhTrang == false) {
                            continue;
                        } else {
                            promotion_DTO pro = new promotion_DTO(maKM, tenKM, ngaybd, ngaykt, noidung, giam, diemyc,
                                    tinhTrang);
                            dsxoa.add(pro);
                        }
                    }
                    if (dsxoa.size() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Khuyến mãi bạn chọn đang bị tạm dừng vui lòng chọn khuyến mãi đang hoạt động",
                                "Xóa khuyến mãi",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    StringBuilder dsxoaStr = new StringBuilder();
                    for (promotion_DTO pro : dsxoa) {
                        dsxoaStr.append("Mã: ").append(pro.getMakm())
                                .append(", Tên: ").append(pro.getTenkm())
                                .append("\n");
                    }
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn tạm dừng các khuyến mãi sau?\n" + dsxoaStr,
                            "Xóa khuyến mãi",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        for (promotion_DTO pro : dsxoa) {
                            promotion_BUS.delete(pro);
                        }
                        promotion_BUS.loadTable(modelPromotion);
                        tablePromotion.setModel(modelPromotion);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khuyến mãi", "Xóa khuyến mãi",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        // chuc nang cua supplier
        add_sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.supplier_GUI.add();
            }
        });
        reset_sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supplier_BUS.loadTable(modelSupplier);
                tableSupplier.setModel(modelSupplier);
            }

        });
        edit_sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableSupplier.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp để sửa");
                    return;
                } else {
                    String maNCC = String.valueOf(tableSupplier.getValueAt(row, 0));
                    String tenNCC = String.valueOf(tableSupplier.getValueAt(row, 1));
                    String sdt = String.valueOf(tableSupplier.getValueAt(row, 2));
                    String diaChi = String.valueOf(tableSupplier.getValueAt(row, 3));
                    String diaChiParts[] = diaChi.split(",");
                    String maSoNha = diaChiParts[0];
                    String duong = diaChiParts[1];
                    String phuong = diaChiParts[2];
                    String quan = diaChiParts[3];
                    String tinh = diaChiParts[4];
                    Boolean tinhTrang = false;

                    ArrayList<supplier_DTO> emlist = supplier_BUS.getAll();
                    for (supplier_DTO em : emlist) {
                        if (em.getMancc().equals(maNCC) && em.getTinhtrang()) {
                            tinhTrang = true;
                        }
                    }
                    supplier_DTO sup = new supplier_DTO(maNCC, tenNCC, sdt, maSoNha, duong, phuong, quan, tinh,
                            tinhTrang);
                    new GUI.supplier_GUI.edit(sup);
                }
            }
        });

        delete_sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectRow = tableSupplier.getSelectedRows();
                ArrayList<supplier_DTO> dsxoa = new ArrayList<>();
                if (selectRow.length > 0) {
                    for (int row : selectRow) {
                        String maNCC = String.valueOf(tableSupplier.getValueAt(row, 0));
                        String tenNCC = String.valueOf(tableSupplier.getValueAt(row, 1));
                        String sdt = String.valueOf(tableSupplier.getValueAt(row, 2));
                        String diaChi = String.valueOf(tableSupplier.getValueAt(row, 3));
                        String diaChiParts[] = diaChi.split(",");
                        String maSoNha = diaChiParts[0];
                        String duong = diaChiParts[1];
                        String phuong = diaChiParts[2];
                        String quan = diaChiParts[3];
                        String tinh = diaChiParts[4];
                        Boolean tinhTrang = Boolean.parseBoolean(String.valueOf(tableSupplier.getValueAt(row, 4)));
                        if (tinhTrang == false) {
                            continue;
                        } else {
                            supplier_DTO sup = new supplier_DTO(maNCC, tenNCC, sdt, maSoNha, duong, phuong, quan, tinh,
                                    tinhTrang);
                            dsxoa.add(sup);
                        }
                    }
                    if (dsxoa.size() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Nhà cung cấp bạn chọn đang bị tạm dừng vui lòng chọn nhà cung cấp đang hoạt động",
                                "Xóa nhà cung cấp",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    StringBuilder dsxoaStr = new StringBuilder();
                    for (supplier_DTO sup : dsxoa) {
                        dsxoaStr.append("Mã: ").append(sup.getMancc())
                                .append(", Tên: ").append(sup.getTenncc())
                                .append("\n");
                    }
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn tạm dừng các nhà cung cấp sau?\n" + dsxoaStr,
                            "Xóa nhà cung cấp",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        for (supplier_DTO sup : dsxoa) {
                            supplier_BUS.delete(sup);
                        }
                        supplier_BUS.loadTable(modelSupplier);
                        tableSupplier.setModel(modelSupplier);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp", "Xóa nhà cung cấp",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        // Chuc nang kh
        add_sup_kh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.customer1_GUI.add();
            }
        });
        reset_sup_kh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer_BUS.loadTable(modelCustomer);
                tableCustomer.setModel(modelCustomer);
            }

        });
        edit_sup_kh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableCustomer.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để sửa");
                    return;
                } else {
                    String maKH = String.valueOf(tableCustomer.getValueAt(row, 0));
                    String tenKH = String.valueOf(tableCustomer.getValueAt(row, 1));
                    String sdt = String.valueOf(tableCustomer.getValueAt(row, 2));
                    String email = String.valueOf(tableCustomer.getValueAt(row, 3));
                    String diaChi = String.valueOf(tableCustomer.getValueAt(row, 4));
                    String diaChiParts[] = diaChi.split(",");
                    String maSoNha = diaChiParts[0];
                    String duong = diaChiParts[1];
                    String phuong = diaChiParts[2];
                    String quan = diaChiParts[3];
                    String tinh = diaChiParts[4];
                    String pass = String.valueOf(tableCustomer.getValueAt(row, 5));
                    String diemKM = String.valueOf(tableCustomer.getValueAt(row, 6));
                    Boolean tinhTrang = false;

                    ArrayList<customer_DTO> emlist = customer_BUS.getAll();
                    for (customer_DTO em : emlist) {
                        if (em.getMakh().equals(maKH) && em.getTinhtrang()) {
                            tinhTrang = true;
                        }
                    }
                    customer_DTO kh = new customer_DTO(maKH, tenKH, sdt, maSoNha, duong, phuong, quan, tinh, email,
                            pass,
                            Integer.parseInt(diemKM), tinhTrang);
                    new GUI.customer1_GUI.edit(kh);
                }
            }
        });

        delete_sup_kh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectRow = tableCustomer.getSelectedRows();
                ArrayList<customer_DTO> dsxoa = new ArrayList<>();
                if (selectRow.length > 0) {
                    for (int row : selectRow) {
                        String maKH = String.valueOf(tableCustomer.getValueAt(row, 0));
                        String tenKH = String.valueOf(tableCustomer.getValueAt(row, 1));
                        String sdt = String.valueOf(tableCustomer.getValueAt(row, 2));
                        String email = String.valueOf(tableCustomer.getValueAt(row, 3));
                        String diaChi = String.valueOf(tableCustomer.getValueAt(row, 4));
                        String diaChiParts[] = diaChi.split(",");
                        String maSoNha = diaChiParts[0];
                        String duong = diaChiParts[1];
                        String phuong = diaChiParts[2];
                        String quan = diaChiParts[3];
                        String tinh = diaChiParts[4];
                        String pass = String.valueOf(tableCustomer.getValueAt(row, 5));
                        String diemKM = String.valueOf(tableCustomer.getValueAt(row, 6));
                        Boolean tinhTrang = Boolean.parseBoolean(String.valueOf(tableCustomer.getValueAt(row, 7)));
                        if (tinhTrang == false) {
                            continue;
                        } else {
                            customer_DTO kh = new customer_DTO(maKH, tenKH, sdt, maSoNha, duong, phuong, quan, tinh,
                                    email,
                                    pass,
                                    Integer.parseInt(diemKM), tinhTrang);
                            dsxoa.add(kh);
                        }
                    }
                    if (dsxoa.size() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Khách hàng bạn chọn đang bị tạm dừng vui lòng chọn khách hàng đang hoạt động",
                                "Xóa khách hàng",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    StringBuilder dsxoaStr = new StringBuilder();
                    for (customer_DTO kh : dsxoa) {
                        dsxoaStr.append("Mã: ").append(kh.getMakh())
                                .append(", Tên: ").append(kh.getTenkh())
                                .append("\n");
                    }
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn tạm dừng các khách hàng sau?\n" + dsxoaStr,
                            "Xóa khách hàng",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        for (customer_DTO kh : dsxoa) {
                            customer_BUS.delete(kh);
                        }
                        customer_BUS.loadTable(modelCustomer);
                        tableCustomer.setModel(modelCustomer);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng", "Xóa khách hàng",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        // Chuc nang nhan vien
        add_sup_nv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.employee1_GUI.add();
            }
        });
        reset_sup_nv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employee_BUS.loadTable(modelEmployee);
                tableEmployee.setModel(modelEmployee);
            }

        });
        edit_sup_nv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableEmployee.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để sửa");
                    return;
                } else {
                    String maNV = String.valueOf(tableEmployee.getValueAt(row, 0));
                    String tenNV = String.valueOf(tableEmployee.getValueAt(row, 1));
                    String cv = String.valueOf(tableEmployee.getValueAt(row, 2));
                    String gioitinh = String.valueOf(tableEmployee.getValueAt(row, 3));
                    String cccd = String.valueOf(tableEmployee.getValueAt(row, 4));
                    String sdt = String.valueOf(tableEmployee.getValueAt(row, 5));
                    String diaChi = String.valueOf(tableEmployee.getValueAt(row, 6));
                    String diaChiParts[] = diaChi.split(",");
                    String maSoNha = diaChiParts[0];
                    String duong = diaChiParts[1];
                    String phuong = diaChiParts[2];
                    String quan = diaChiParts[3];
                    String tinh = diaChiParts[4];
                    String tk = String.valueOf(tableEmployee.getValueAt(row, 7));
                    String pass = String.valueOf(tableEmployee.getValueAt(row, 8));
                    String dcnt = String.valueOf(tableEmployee.getValueAt(row, 9));
                    String mant = null;
                    ArrayList<store_DTO> storelist = new ArrayList<>();
                    storelist = store_BUS.getAll();
                    for (store_DTO st : storelist) {
                        String dc = st.getMasonha() + "," + st.getDuong() + "," + st.getPhuong() + "," + st.getQuan()
                                + ","
                                + st.getTinh();
                        if (dc.equals(dcnt)) {
                            mant = st.getMant();
                        }
                    }
                    Boolean tinhTrang = false;

                    ArrayList<employee_DTO> emlist = employee_BUS.getAll();
                    for (employee_DTO em : emlist) {
                        if (em.getManv().equals(maNV) && em.getTinhtrang()) {
                            tinhTrang = true;
                        }
                    }

                    employee_DTO nv = new employee_DTO(maNV, tenNV, cv, gioitinh, cccd, sdt, maSoNha, duong, phuong,
                            quan,
                            tinh, tk, pass, mant, tinhTrang);
                    new GUI.employee1_GUI.edit(nv);
                }
            }
        });

        delete_sup_nv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectRow = tableEmployee.getSelectedRows();
                ArrayList<employee_DTO> dsxoa = new ArrayList<>();
                if (selectRow.length > 0) {
                    for (int row : selectRow) {
                        String maNV = String.valueOf(tableCustomer.getValueAt(row, 0));
                        String tenNV = String.valueOf(tableCustomer.getValueAt(row, 1));
                        String cv = String.valueOf(tableCustomer.getValueAt(row, 2));
                        String gioitinh = String.valueOf(tableCustomer.getValueAt(row, 3));
                        String cccd = String.valueOf(tableCustomer.getValueAt(row, 4));
                        String sdt = String.valueOf(tableCustomer.getValueAt(row, 5));
                        String diaChi = String.valueOf(tableCustomer.getValueAt(row, 6));
                        String diaChiParts[] = diaChi.split(",");
                        String maSoNha = diaChiParts[0];
                        String duong = diaChiParts[1];
                        String phuong = diaChiParts[2];
                        String quan = diaChiParts[3];
                        String tinh = diaChiParts[4];
                        String tk = String.valueOf(tableCustomer.getValueAt(row, 7));
                        String pass = String.valueOf(tableCustomer.getValueAt(row, 8));
                        String mant = String.valueOf(tableCustomer.getValueAt(row, 9));
                        Boolean tinhTrang = Boolean.parseBoolean(String.valueOf(tableCustomer.getValueAt(row, 10)));
                        if (tinhTrang == false) {
                            continue;
                        } else {
                            employee_DTO nv = new employee_DTO(maNV, tenNV, cv, gioitinh, cccd, sdt, maSoNha, duong,
                                    phuong,
                                    quan,
                                    tinh, tk, pass, mant, tinhTrang);
                            dsxoa.add(nv);
                        }
                    }
                    if (dsxoa.size() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Nhân viên bạn chọn đang bị tạm dừng vui lòng chọn nhân viên đang hoạt động",
                                "Xóa nhân viên",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    StringBuilder dsxoaStr = new StringBuilder();
                    for (employee_DTO nv : dsxoa) {
                        dsxoaStr.append("Mã: ").append(nv.getManv())
                                .append(", Tên: ").append(nv.getTennv())
                                .append("\n");
                    }
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn tạm dừng các nhân viên sau?\n" + dsxoaStr,
                            "Xóa nhân viên",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        for (employee_DTO nv : dsxoa) {
                            employee_BUS.delete(nv);
                        }
                        employee_BUS.loadTable(modelEmployee);
                        tableEmployee.setModel(modelEmployee);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên", "Xóa nhân viên",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        btn_nhathuoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!employee_BUS.showStore(nv)) {
                    JOptionPane.showMessageDialog(null,
                            "Không tìm thấy thông tin nhà thuốc.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new admin_GUI(null);
    }
}
