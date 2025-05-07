package GUI.medicine_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import BUS.medicine_BUS;
import advanceMethod.advance;

public class medicineAdd_GUI extends JFrame {
    public medicineAdd_GUI(DefaultTableModel modelMedic){
        this.setSize(1500, 800);
        this.setTitle("Lập thông tin thuốc");
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

        JLabel title = new JLabel("Lập Thông Tin Thuốc Mới");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 5;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel tenthuoc = new JLabel("Tên thuốc:");
        tenthuoc.setForeground(Color.BLACK);
        tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenthuoc, gdc);

        JTextField tf_tenthuoc = new JTextField();
        tf_tenthuoc.setForeground(Color.BLACK);
        tf_tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_tenthuoc, gdc);

        JLabel danhmuc = new JLabel("Danh mục:");
        danhmuc.setForeground(Color.BLACK);
        danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(danhmuc, gdc);

        JTextField tf_danhmuc = new JTextField();
        tf_danhmuc.setForeground(Color.BLACK);
        tf_danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_danhmuc, gdc);

        JLabel donvi = new JLabel("Đơn vị:");
        donvi.setForeground(Color.BLACK);
        donvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(donvi, gdc);

        JCheckBox hop = new JCheckBox("Hộp");
        hop.setBackground(Color.white);
        hop.setForeground(Color.BLACK);
        hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.NONE;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(hop, gdc);

        JCheckBox vi = new JCheckBox("Vỉ");
        vi.setBackground(Color.white);
        vi.setForeground(Color.BLACK);
        vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.NONE;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(vi, gdc);
        
        JCheckBox vien = new JCheckBox("Viên");
        vien.setBackground(Color.white);
        vien.setForeground(Color.BLACK);
        vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.NONE;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(vien, gdc);

        JLabel thanhphan = new JLabel("Thành phần:");
        thanhphan.setForeground(Color.BLACK);
        thanhphan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(thanhphan, gdc);

        JTextArea ta_thanhphan = new JTextArea();
        ta_thanhphan.setForeground(Color.BLACK);
        ta_thanhphan.setFont(new Font(null, Font.PLAIN, 20));
        ta_thanhphan.setAutoscrolls(true);
        ta_thanhphan.setLineWrap(true);
        
        JScrollPane scroll_thanhphan = new JScrollPane();
        scroll_thanhphan.setViewportView(ta_thanhphan);
        scroll_thanhphan.setPreferredSize(new Dimension(0, 100));

        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(scroll_thanhphan, gdc);

        JLabel thongtin = new JLabel("Thông tin:");
        thongtin.setForeground(Color.BLACK);
        thongtin.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(thongtin, gdc);

        JTextArea ta_thongtin = new JTextArea();
        ta_thongtin.setForeground(Color.BLACK);
        ta_thongtin.setFont(new Font(null, Font.PLAIN, 20));
        ta_thongtin.setAutoscrolls(true);
        ta_thongtin.setLineWrap(true);
        
        JScrollPane scroll_thongtin = new JScrollPane();
        scroll_thongtin.setViewportView(ta_thongtin);
        scroll_thongtin.setPreferredSize(new Dimension(0, 100));

        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(scroll_thongtin, gdc);

        JLabel xuatxu = new JLabel("Xuất xứ:");
        xuatxu.setForeground(Color.BLACK);
        xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(xuatxu, gdc);

        JTextField tf_xuatxu = new JTextField();
        tf_xuatxu.setForeground(Color.BLACK);
        tf_xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 6;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_xuatxu, gdc);

        JLabel doituong = new JLabel("Đối tượng sử dụng:");
        doituong.setForeground(Color.BLACK);
        doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(doituong, gdc);

        String[] doituongsudung = {"không có chỉ định", "trẻ em", "người cao tuổi", "phụ nữ đang mang thai"}; //etc...
        JComboBox cb_doituong = new JComboBox(doituongsudung);
        cb_doituong.setForeground(Color.BLACK);
        cb_doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(cb_doituong, gdc);

        JButton btn_them_doituong = new JButton("Thêm");
        btn_them_doituong.setForeground(Color.BLACK);
        btn_them_doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(btn_them_doituong, gdc);

        JButton btn_xoa_doituong = new JButton("Xóa");
        btn_xoa_doituong.setForeground(Color.BLACK);
        btn_xoa_doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(btn_xoa_doituong, gdc);

        JLabel ds_doituong = new JLabel("Danh sách đối tượng sử dụng:");
        ds_doituong.setForeground(Color.BLACK);
        ds_doituong.setFont(new Font(null, Font.PLAIN, 20));

        JPanel dsdt = new JPanel(new FlowLayout());
        dsdt.setBackground(Color.white);
        dsdt.add(ds_doituong);
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 100);
        main.add(dsdt, gdc);

        JLabel hansudung = new JLabel("Hạn sử dụng:");
        hansudung.setForeground(Color.BLACK);
        hansudung.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(hansudung, gdc);

        SpinnerNumberModel sp_model = new SpinnerNumberModel(0, 0, 36, 1);
        JSpinner sp_hansudung = new JSpinner(sp_model);
        sp_hansudung.setForeground(Color.BLACK);
        sp_hansudung.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(sp_hansudung, gdc);

        String[] time = {"tháng", "năm"};
        JComboBox cb_hansudung = new JComboBox(time);
        cb_hansudung.setForeground(Color.BLACK);
        cb_hansudung.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(cb_hansudung, gdc);
        
        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 10;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(finish, gdc);

        JButton reset = new JButton("Đặt lại");
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 10;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(reset, gdc);

        JLabel khung_anh = new JLabel();
        khung_anh.setBackground(Color.LIGHT_GRAY);
        khung_anh.setBorder(BorderFactory.createLineBorder(Color.black,3));
        gdc.gridx = 4;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.gridheight = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 1.2;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(khung_anh, gdc);

        JButton chon_anh = new JButton("Chọn ảnh");
        chon_anh.setForeground(Color.BLACK);
        chon_anh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(chon_anh, gdc);

        this.setVisible(true);

        //xử lý các tính năng

        ArrayList<String> chosen = new ArrayList<>(); //ds đối tượng

        //thêm đối tượng
        btn_them_doituong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.addUser(chosen, cb_doituong, ds_doituong);
            }
        });

        //xóa đối tượng
        btn_xoa_doituong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.deleteUser(chosen, cb_doituong, ds_doituong);
            }
        });

        //hoàn tất
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(medicine_BUS.addMedicine(tf_tenthuoc, tf_danhmuc, ta_thanhphan, 
                ta_thongtin, tf_xuatxu, hop, vi, vien, chosen, modelMedic, sp_hansudung,
                cb_hansudung)) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ tất cả thông tin chính xác!");
                }
            }           
        });

        //reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.resetAdd(tf_tenthuoc, tf_danhmuc, ta_thanhphan, 
                ta_thongtin, hop, vi, vien, tf_xuatxu, cb_doituong, ds_doituong, 
                chosen, khung_anh, sp_hansudung, cb_hansudung);
            }
        });

        //up ảnh
        chon_anh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.uploadImage(khung_anh, null);
            }
        });
    }

    public static void main(String[] args) {
        new medicineAdd_GUI(null);
    }
}
