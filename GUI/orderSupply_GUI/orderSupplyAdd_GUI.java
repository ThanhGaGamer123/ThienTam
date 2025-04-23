package GUI.orderSupply_GUI;

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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.medicine_BUS;
import BUS.orderSupply_BUS;
import BUS.orderSupply_details_BUS;
import DTO.orderSupply_details_DTO;
import GUI.medicine_GUI.medicineSearch_GUI;
import advanceMethod.advance;

public class orderSupplyAdd_GUI extends JFrame{   
    public orderSupplyAdd_GUI(DefaultTableModel modelSupplier) {
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

        JTextField search_bar = new JTextField("Nhập tên thuốc...");
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

        String[] columns = {"Mã thuốc", "Tên thuốc", "Tình trạng"};
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

        SpinnerNumberModel sp_slhop = new SpinnerNumberModel(0, 0, null, 1000);
        JSpinner sp_slnhap_hop = new JSpinner(sp_slhop);
        sp_slnhap_hop.setForeground(Color.BLACK);
        sp_slnhap_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_slnhap_hop, gdc);
        
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

        SpinnerNumberModel sp_giahop = new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 1000.0);
        JSpinner sp_gianhap_hop = new JSpinner(sp_giahop);
        sp_gianhap_hop.setForeground(Color.BLACK);
        sp_gianhap_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_gianhap_hop, gdc);

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

        SpinnerNumberModel sp_slvi = new SpinnerNumberModel(0, 0, null, 1000);
        JSpinner sp_slnhap_vi = new JSpinner(sp_slvi);
        sp_slnhap_vi.setForeground(Color.BLACK);
        sp_slnhap_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_slnhap_vi, gdc);

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

        SpinnerNumberModel sp_giavi = new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 1000.0);
        JSpinner sp_gianhap_vi = new JSpinner(sp_giavi);
        sp_gianhap_vi.setForeground(Color.BLACK);
        sp_gianhap_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_gianhap_vi, gdc);

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

        SpinnerNumberModel sp_slvien = new SpinnerNumberModel(0, 0, null, 1000);
        JSpinner sp_slnhap_vien = new JSpinner(sp_slvien);
        sp_slnhap_vien.setForeground(Color.BLACK);
        sp_slnhap_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_slnhap_vien, gdc);

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

        SpinnerNumberModel sp_giavien = new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 1000.0);
        JSpinner sp_gianhap_vien = new JSpinner(sp_giavien);
        sp_gianhap_vien.setForeground(Color.BLACK);
        sp_gianhap_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 5;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1.5;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_gianhap_vien, gdc);
        
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
        
        JButton reset_all = new JButton("Đặt lại");
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
    
        //tìm thuốc
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.searchMedicineOther(search_bar, modelMedic);
            }
        });
    
        //tìm thuốc nâng cao
        search_advance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new medicineSearch_GUI(null, modelMedic);
            }
        });
    
        //reset thuốc
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.resetOther(search_bar, tf_tenthuoc, sp_gianhap_hop, 
                sp_gianhap_vi, sp_gianhap_vien, sp_slnhap_hop, sp_slnhap_vi, 
                sp_slnhap_vien, modelMedic);
            }
        });
    
        //chọn thuốc
        tableMedic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                medicine_BUS.chooseMedicine(tableMedic, modelMedic, tf_tenthuoc);
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
        ArrayList<orderSupply_details_DTO> osds = new ArrayList<>();
        themMedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderSupply_details_BUS.addOrderSupplyDetails(osds, modelMedic, 
                tableMedic, sp_slnhap_hop, sp_slnhap_vi, sp_slnhap_vien, sp_gianhap_hop, 
                sp_gianhap_vi, sp_gianhap_vien, modelSupply, tf_tenthuoc);
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
                orderSupply_details_BUS.deleteOrderSupplyDetails(tableSupply, modelSupply, osds);
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
                orderSupply_BUS.addOrderSupply(tf_nhacc, osds, modelSupplier, 
                modelMedic, modelSupply, sp_gianhap_hop, sp_gianhap_vi, sp_gianhap_vien, 
                sp_slnhap_hop, sp_slnhap_vi, sp_slnhap_vien, tf_tenthuoc, search_bar);
            }
        });
    
        //reset all
        reset_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderSupply_BUS.resetAdd(tf_nhacc, modelMedic, modelSupply, 
                sp_gianhap_hop, sp_gianhap_vi, sp_gianhap_vien, sp_slnhap_hop, 
                sp_slnhap_vi, sp_slnhap_vien, tf_tenthuoc, search_bar, osds);
            }
        });
    }

    public static void main(String[] args) {
        new orderSupplyAdd_GUI(null);
    }
}