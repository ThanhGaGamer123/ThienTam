package orderSupply;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import advanceMethod.advance;
import dataAccessObj.medicineDAO;
import dataAccessObj.orderSupplyDAO;
import dataAccessObj.orderSupply_detailsDAO;
import dataAccessObj.storageDAO;
import dataAccessObj.supplierDAO;
import medicine.medicine;
import medicine.searchAdvance;
import orderSupply_details.orderSupply_details;
import storage.storage;
import supplier.supplier;

public class orderSupplyAddGUI extends JFrame{   
    public orderSupplyAddGUI(DefaultTableModel modelSupplier) {
        this.setSize(1500, 800);
        this.setTitle("Lập hóa đơn nhập");
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

        JLabel title = new JLabel("Lập Hóa Đơn Nhập Mới");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 6;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JTextField search_bar = new JTextField("Nhập mã thuốc...");
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

        String[] columns = {"Mã thuốc", "Tên thuốc", "Tình trạng", ""};
        DefaultTableModel modelMedic = new DefaultTableModel(columns, 0) {
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
        tableMedic.getColumnModel().getColumn(3).setPreferredWidth(10);
        tableMedic.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableMedic.getColumnCount(); i++) {
            tableMedic.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_medic = new JScrollPane();
        scroll_medic.setViewportView(tableMedic);
        gdc.gridx = 0;
        gdc.gridy = 2;
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
        gdc.gridy = 1;
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
        gdc.gridx = 5;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenthuoc, gdc);

        JLabel slnhap_hop = new JLabel("Số lượng hộp:");
        slnhap_hop.setForeground(Color.BLACK);
        slnhap_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(slnhap_hop, gdc);

        JTextField tf_slnhap_hop = new JTextField();
        tf_slnhap_hop.setForeground(Color.BLACK);
        tf_slnhap_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_slnhap_hop, gdc);
        
        JLabel gianhap_hop = new JLabel("Giá nhập hộp:");
        gianhap_hop.setForeground(Color.BLACK);
        gianhap_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(gianhap_hop, gdc);

        JTextField tf_gianhap_hop = new JTextField();
        tf_gianhap_hop.setForeground(Color.BLACK);
        tf_gianhap_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_gianhap_hop, gdc);

        JLabel slnhap_vi = new JLabel("Số lượng vỉ:");
        slnhap_vi.setForeground(Color.BLACK);
        slnhap_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(slnhap_vi, gdc);

        JTextField tf_slnhap_vi = new JTextField();
        tf_slnhap_vi.setForeground(Color.BLACK);
        tf_slnhap_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_slnhap_vi, gdc);

        JLabel gianhap_vi = new JLabel("Giá nhập vỉ:");
        gianhap_vi.setForeground(Color.BLACK);
        gianhap_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(gianhap_vi, gdc);

        JTextField tf_gianhap_vi = new JTextField();
        tf_gianhap_vi.setForeground(Color.BLACK);
        tf_gianhap_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_gianhap_vi, gdc);

        JLabel slnhap_vien = new JLabel("Số lượng viên:");
        slnhap_vien.setForeground(Color.BLACK);
        slnhap_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(slnhap_vien, gdc);

        JTextField tf_slnhap_vien = new JTextField();
        tf_slnhap_vien.setForeground(Color.BLACK);
        tf_slnhap_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_slnhap_vien, gdc);

        JLabel gianhap_vien = new JLabel("Giá nhập viên:");
        gianhap_vien.setForeground(Color.BLACK);
        gianhap_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(gianhap_vien, gdc);

        JTextField tf_gianhap_vien = new JTextField();
        tf_gianhap_vien.setForeground(Color.BLACK);
        tf_gianhap_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_gianhap_vien, gdc);
        
        JButton themMedic = new JButton("Thêm");
        themMedic.setForeground(Color.BLACK);
        themMedic.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 8;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 0, 30, 100);
        main.add(themMedic, gdc);

        String[] columns2 = {"Mã chi tiết đơn nhập", "Tên thuốc", "Giá nhập", "Số lượng", "Thành tiền", "Tình trạng", ""};
        DefaultTableModel modelSupply = new DefaultTableModel(columns2, 0) {
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
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableSupply.getColumnCount(); i++) {
            tableSupply.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scroll_supply = new JScrollPane();
        scroll_supply.setViewportView(tableSupply);
        gdc.gridx = 0;
        gdc.gridy = 10;
        gdc.gridwidth = 6;
        gdc.gridheight = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(50, 100, 30, 50);
        main.add(scroll_supply, gdc);
        gdc.gridheight = 1;

        JLabel nhacc = new JLabel("Nhà cung cấp:");
        nhacc.setForeground(Color.BLACK);
        nhacc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 15;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(nhacc, gdc);

        JTextField tf_nhacc = new JTextField();
        tf_nhacc.setForeground(Color.BLACK);
        tf_nhacc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 15;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(tf_nhacc, gdc);

        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 16;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(finish, gdc);
        
        JButton reset_all = new JButton("Đặt lại    ");
        reset_all.setForeground(Color.BLACK);
        reset_all.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 16;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 0.1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(reset_all, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //xử lý thuốc
        updateTableMedic(modelMedic);

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

        tableMedic.getColumn("").setCellRenderer(new DefaultTableCellRenderer() {
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
    
        //tìm thuốc
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine med = throwMedicineObj(search_bar.getText());
                modelMedic.setRowCount(0);
                JLabel statusImg;
                if(med.getTinhtrang()) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                JButton chooseButton = new JButton("Chọn");
                chooseButton.setForeground(Color.BLACK);
                chooseButton.setFont(new Font(null, Font.PLAIN, 18));
                modelMedic.addRow(new Object[]{med.getMathuoc(), 
                med.getTenthuoc(), statusImg, chooseButton});
            }
        });
    
        //tìm thuốc nâng cao
        search_advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new searchAdvance(null, modelMedic);
            }
        });
    
        //reset thuốc
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_bar.setText("Nhập mã thuốc...");
                tf_tenthuoc.setText("");
                tf_gianhap_hop.setText("");
                tf_slnhap_hop.setText("");
                tf_gianhap_vi.setText("");
                tf_slnhap_vi.setText("");
                tf_gianhap_vien.setText("");
                tf_slnhap_vien.setText("");
                updateTableMedic(modelMedic);
            }
        });
    
        //chọn thuốc
        tableMedic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedColumn = tableMedic.getSelectedColumn();
                if(selectedColumn == 3) {
                    int selectedRow = tableMedic.getSelectedRow();
                    if(selectedRow != -1) {
                        String mathuoc = modelMedic.getValueAt(selectedRow, 0).toString();
                        medicine med = throwMedicineObj(mathuoc);
                        if(med.getTinhtrang()) {
                            tf_tenthuoc.setText(med.getTenthuoc());
                        } else {
                            JOptionPane.showMessageDialog(null, "Thuốc này đã ngừng hoạt động!");
                        }
                    }
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
    
        //thêm chi tiết đơn
        ArrayList<orderSupply_details> osds = new ArrayList<>();
        themMedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderSupply_details osd = new orderSupply_details();
                ArrayList<orderSupply_details> osds2 = new ArrayList<>();
                orderSupply_detailsDAO osdDAO = new orderSupply_detailsDAO();
                osds2 = osdDAO.selectAll();

                String macthdnhap = "CTN" + advance.calculateID(osds.size() + osds2.size());
                osd.setMacthdnhap(macthdnhap);

                int selectedRow = tableMedic.getSelectedRow();
                if(selectedRow != -1) {
                    String mathuoc = modelMedic.getValueAt(selectedRow, 0).toString();
                    osd.setMathuoc(mathuoc);
                }

                ArrayList<Integer> gianhap = new ArrayList<>();
                Boolean flag = false;
                ArrayList<Integer> sl = new ArrayList<>();
                if (!tf_slnhap_hop.getText().isEmpty() && advance.checkTextField(tf_slnhap_hop.getText())) {
                    sl.add(Integer.parseInt(tf_slnhap_hop.getText().toString()));
                } else if (tf_slnhap_hop.getText().isEmpty()) {
                    sl.add(0);
                } else flag = true;
                if (!tf_slnhap_vi.getText().isEmpty() && advance.checkTextField(tf_slnhap_vi.getText())) {
                    sl.add(Integer.parseInt(tf_slnhap_vi.getText().toString()));
                } else if (tf_slnhap_vi.getText().isEmpty()) {
                    sl.add(0);
                } else flag = true;
                if (!tf_slnhap_vien.getText().isEmpty() && advance.checkTextField(tf_slnhap_vien.getText())) {
                    sl.add(Integer.parseInt(tf_slnhap_vien.getText().toString()));
                } else if (tf_slnhap_vien.getText().isEmpty()) {
                    sl.add(0);
                } else flag = true;
                osd.setSlnhap(sl);
                osd.setSlcon(sl);

                if(!flag) {
                    flag = false;
                    if (!tf_gianhap_hop.getText().isEmpty() && !tf_slnhap_hop.getText().isEmpty() && advance.checkTextField(tf_gianhap_hop.getText())) {
                        gianhap.add(Integer.parseInt(tf_gianhap_hop.getText().toString()));
                    } else if (tf_gianhap_hop.getText().isEmpty()) {
                        gianhap.add(0);
                    } else flag = true;
                    if (!tf_gianhap_vi.getText().isEmpty() && !tf_slnhap_vi.getText().isEmpty() && advance.checkTextField(tf_gianhap_vi.getText())) {
                        gianhap.add(Integer.parseInt(tf_gianhap_vi.getText().toString()));
                    } else if (tf_gianhap_vi.getText().isEmpty()) {
                        gianhap.add(0);
                    } else flag = true;
                    if (!tf_gianhap_vien.getText().isEmpty() && !tf_slnhap_vien.getText().isEmpty() && advance.checkTextField(tf_gianhap_vien.getText())) {
                        gianhap.add(Integer.parseInt(tf_gianhap_vien.getText().toString()));
                    } else if (tf_gianhap_vien.getText().isEmpty()) {
                        gianhap.add(0);
                    } else flag = true;
                    osd.setGianhap(gianhap);

                    if (!flag) {
                        int thanhtien = 0;
                        for(int i = 0; i < 3; i++) {
                            thanhtien = thanhtien + osd.getGianhap().get(i) * osd.getSlnhap().get(i);
                        }
                        osd.setThanhtien(thanhtien);

                        osd.setTinhtrang(true);

                        osds.add(osd);

                        updateTableSupply(modelSupply, osds);

                        tf_tenthuoc.setText("");
                        tf_gianhap_hop.setText("");
                        tf_slnhap_hop.setText("");
                        tf_gianhap_vi.setText("");
                        tf_slnhap_vi.setText("");
                        tf_gianhap_vien.setText("");
                        tf_slnhap_vien.setText("");
                    } else JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ hoặc không có số lượng!");
                } else JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
            }
        });
    
        tableSupply.getColumn("Tình trạng").setCellRenderer(new DefaultTableCellRenderer() {
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

        tableSupply.getColumn("").setCellRenderer(new DefaultTableCellRenderer() {
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
    
        //xóa chi tiết đơn
        tableSupply.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedColumn = tableSupply.getSelectedColumn();
                if(selectedColumn == 6) {
                    int selectedRow = tableSupply.getSelectedRow();
                    if(selectedRow != -1) {
                        String macthdnhap = modelSupply.getValueAt(selectedRow, 0).toString();
                        orderSupply_details temp = new orderSupply_details();
                        for (orderSupply_details osd : osds) {
                            if(osd.getMacthdnhap().equals(macthdnhap)) {
                                temp = osd;
                            }
                        }
                        osds.remove(temp);

                        ArrayList<orderSupply_details> osds2 = new ArrayList<>();
                        int i = 0 + osds2.size() + 1;
                        for (orderSupply_details osd : osds) {
                            osd.setMacthdnhap("CTN" + advance.calculateID(i));
                            i++;
                        }

                        updateTableSupply(modelSupply, osds);
                    }
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
                orderSupply os = new orderSupply();

                ArrayList<orderSupply> oss = new ArrayList<>();
                orderSupplyDAO osDAO = new orderSupplyDAO();
                oss = osDAO.selectAll();
                String mahdnhap = "HDN" + advance.calculateID(oss.size());
                os.setMahdnhap(mahdnhap);

                String tenncc = tf_nhacc.getText().toString();
                ArrayList<supplier> sps = new ArrayList<>();
                supplier sp = new supplier();
                supplierDAO spDAO = new supplierDAO();
                sps = spDAO.selectByCondition("tenncc = '" + tenncc + "'");
                
                if(sps.size() != 0 || !sps.isEmpty()) {
                    sp = sps.get(0);
                    
                    if(sp.getTinhtrang()) {
                        os.setMancc(sp.getMancc());

                        os.setSoloaithuoc(osds.size());

                        os.setNgaynhap(advance.currentTime());

                        int tongtien = 0;
                        for (orderSupply_details osd : osds) {
                            tongtien += osd.getThanhtien();
                        }
                        os.setTongtien(tongtien);

                        os.setTinhtrang(true);

                        osDAO.add(os);

                        orderSupply_detailsDAO osdDAO = new orderSupply_detailsDAO();
                        for (orderSupply_details osd : osds) {
                            osd.setMahdnhap(os.getMahdnhap());
                            osdDAO.add(osd);
                        }

                        updateTableSupplier(modelSupplier);

                        //cập nhật lượng tồn
                        for (orderSupply_details osd : osds) {
                            medicine medicine = new medicine();
                            medicine.setMathuoc(osd.getMathuoc());
                            medicineDAO medicineDAO = new medicineDAO();
                            medicine = medicineDAO.selectByID(medicine);

                            storage storage = new storage();
                            storage.setMaton(medicine.getMaton());
                            storageDAO storageDAO = new storageDAO();
                            storage = storageDAO.selectByID(storage);

                            for (int i = 0; i < 3; i++) {
                                storage.getSlton().set(i, storage.getSlton().get(i) + osd.getSlnhap().get(i));
                                System.out.println(osd.getSlnhap().get(i) + " " + storage.getSlton().get(i));
                            }

                            storageDAO.update(storage);
                        }

                        osds.clear();

                        modelMedic.setRowCount(0);
                        modelSupply.setRowCount(0);
                        search_bar.setText("");
                        tf_tenthuoc.setText("");
                        tf_gianhap_hop.setText("");
                        tf_slnhap_hop.setText("");
                        tf_gianhap_vi.setText("");
                        tf_slnhap_vi.setText("");
                        tf_gianhap_vien.setText("");
                        tf_slnhap_vien.setText("");
                        tf_nhacc.setText("");
                        updateTableMedic(modelMedic);
                    } else JOptionPane.showMessageDialog(null, "Nhà cung cấp này đã ngưng hoạt động!");
                } else JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp!");
            }
        });
    
        //reset all
        reset_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelMedic.setRowCount(0);
                modelSupply.setRowCount(0);
                search_bar.setText("");
                tf_tenthuoc.setText("");
                tf_gianhap_hop.setText("");
                tf_slnhap_hop.setText("");
                tf_gianhap_vi.setText("");
                tf_slnhap_vi.setText("");
                tf_gianhap_vien.setText("");
                tf_slnhap_vien.setText("");
                tf_nhacc.setText("");
                updateTableMedic(modelMedic);
            }
        });
    }

    public static void updateTableSupplier(DefaultTableModel modelSupplier) {
        modelSupplier.setRowCount(0);
        
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
                int tongtien = rs.getInt("tongtien");
                Boolean tinhtrang = rs.getBoolean("tinhtrang");
                JLabel statusImg;
                if(tinhtrang) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                JButton eyeButton = new JButton(data.imagePath.resize_eye);
                modelSupplier.addRow(new Object[]{mahdnhap, tenncc, soloaithuoc, ngaynhap, tongtien, statusImg, eyeButton});
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
    }

    public static void updateTableSupply(DefaultTableModel modelSupply, ArrayList<orderSupply_details> osds) {
        modelSupply.setRowCount(0);
        for (orderSupply_details osd : osds) {
            JLabel statusImg;
            if(osd.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton deleteButton = new JButton("Xóa");
            deleteButton.setForeground(Color.BLACK);
            deleteButton.setFont(new Font(null, Font.PLAIN, 18));
            medicine med = throwMedicineObj(osd.getMathuoc());
            modelSupply.addRow(new Object[]{osd.getMacthdnhap(),
            med.getTenthuoc(), advance.IntArrayListToString(osd.getGianhap()),
            advance.IntArrayListToString(osd.getSlnhap()), osd.getThanhtien(),
            statusImg, deleteButton});
        }
    }

    public static void updateTableMedic(DefaultTableModel modelMedic) {
        modelMedic.setRowCount(0);
        medicineDAO medDAO = new medicineDAO();
        ArrayList<medicine> medicines = medDAO.selectAll();
        for (medicine medicine : medicines) {
            JLabel statusImg;
            if(medicine.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton chooseButton = new JButton("Chọn");
            chooseButton.setForeground(Color.BLACK);
            chooseButton.setFont(new Font(null, Font.PLAIN, 18));
            modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
            medicine.getTenthuoc(), statusImg, chooseButton});
        }
    }

    public static medicine throwMedicineObj(String mathuoc) {
        medicine med = new medicine();
        med.setMathuoc(mathuoc);
        medicineDAO medDAO = new medicineDAO();
        return medDAO.selectByID(med);
    }

    public static void main(String[] args) {
        new orderSupplyAddGUI(null);
    }
}