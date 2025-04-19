package GUI.medicine_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BUS.medicine_BUS;
import advanceMethod.advance;

public class medicine_GUI extends JFrame {
    public medicine_GUI(String mathuoc){
        this.setSize(1500, 800);
        this.setTitle("Thông tin thuốc");
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

        JLabel title = new JLabel("Thông Tin Thuốc");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel maThuoc = new JLabel("Mã thuốc:");
        maThuoc.setForeground(Color.BLACK);
        maThuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(maThuoc, gdc);

        JTextField tf_maThuoc = new JTextField();
        tf_maThuoc.setForeground(Color.BLACK);
        tf_maThuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_maThuoc, gdc);

        JLabel tenthuoc = new JLabel("Tên thuốc:");
        tenthuoc.setForeground(Color.BLACK);
        tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenthuoc, gdc);

        JTextField tf_tenthuoc = new JTextField();
        tf_tenthuoc.setForeground(Color.BLACK);
        tf_tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_tenthuoc, gdc);

        JLabel danhmuc = new JLabel("Danh mục:");
        danhmuc.setForeground(Color.BLACK);
        danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(danhmuc, gdc);

        JTextField tf_danhmuc = new JTextField();
        tf_danhmuc.setForeground(Color.BLACK);
        tf_danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_danhmuc, gdc);

        JLabel donvi = new JLabel("Đơn vị:");
        donvi.setForeground(Color.BLACK);
        donvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(donvi, gdc);

        JTextField tf_donvi = new JTextField();
        tf_donvi.setForeground(Color.BLACK);
        tf_donvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_donvi, gdc);

        JLabel thanhphan = new JLabel("Thành phần:");
        thanhphan.setForeground(Color.BLACK);
        thanhphan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(thanhphan, gdc);

        JTextArea ta_thanhphan = new JTextArea();
        ta_thanhphan.setForeground(Color.BLACK);
        ta_thanhphan.setFont(new Font(null, Font.PLAIN, 20));
        ta_thanhphan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        ta_thanhphan.setPreferredSize(new Dimension(0, 100));
        
        JScrollPane scroll_thanhphan = new JScrollPane();
        scroll_thanhphan.setViewportView(ta_thanhphan);

        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(scroll_thanhphan, gdc);

        JLabel thongtin = new JLabel("Thông tin:");
        thongtin.setForeground(Color.BLACK);
        thongtin.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(thongtin, gdc);

        JTextArea ta_thongtin = new JTextArea();
        ta_thongtin.setForeground(Color.BLACK);
        ta_thongtin.setFont(new Font(null, Font.PLAIN, 20));
        ta_thongtin.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        ta_thongtin.setPreferredSize(new Dimension(0, 100));
        
        JScrollPane scroll_thongtin = new JScrollPane();
        scroll_thongtin.setViewportView(ta_thongtin);

        gdc.gridx = 1;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(scroll_thongtin, gdc);

        JLabel xuatxu = new JLabel("Xuất xứ:");
        xuatxu.setForeground(Color.BLACK);
        xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(xuatxu, gdc);

        JTextField tf_xuatxu = new JTextField();
        tf_xuatxu.setForeground(Color.BLACK);
        tf_xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_xuatxu, gdc);

        JLabel dsdt = new JLabel("Danh sách đối tượng sử dụng:");
        dsdt.setForeground(Color.BLACK);
        dsdt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(dsdt, gdc);

        JTextField tf_dsdt = new JTextField();
        tf_dsdt.setForeground(Color.BLACK);
        tf_dsdt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_dsdt, gdc);

        JLabel giahop = new JLabel("Giá bán hộp:");
        giahop.setForeground(Color.BLACK);
        giahop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(giahop, gdc);

        JTextField tf_giahop = new JTextField();
        tf_giahop.setForeground(Color.BLACK);
        tf_giahop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_giahop, gdc);

        JLabel giavi = new JLabel("Giá bán vỉ:");
        giavi.setForeground(Color.BLACK);
        giavi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 10;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(giavi, gdc);

        JTextField tf_giavi = new JTextField();
        tf_giavi.setForeground(Color.BLACK);
        tf_giavi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 10;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_giavi, gdc);

        JLabel giavien = new JLabel("Giá bán viên:");
        giavien.setForeground(Color.BLACK);
        giavien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(giavien, gdc);

        JTextField tf_giavien = new JTextField();
        tf_giavien.setForeground(Color.BLACK);
        tf_giavien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_giavien, gdc);

        JLabel slhop = new JLabel("Số lượng hộp:");
        slhop.setForeground(Color.BLACK);
        slhop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 12;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(slhop, gdc);

        JTextField tf_slhop = new JTextField();
        tf_slhop.setForeground(Color.BLACK);
        tf_slhop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 12;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_slhop, gdc);

        JLabel slvi = new JLabel("Số lượng vỉ:");
        slvi.setForeground(Color.BLACK);
        slvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(slvi, gdc);

        JTextField tf_slvi = new JTextField();
        tf_slvi.setForeground(Color.BLACK);
        tf_slvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_slvi, gdc);

        JLabel slvien = new JLabel("Số lượng viên:");
        slvien.setForeground(Color.BLACK);
        slvien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(slvien, gdc);

        JTextField tf_slvien = new JTextField();
        tf_slvien.setForeground(Color.BLACK);
        tf_slvien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 14;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_slvien, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 15;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.EAST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(tinhtrang, gdc);

        JTextField tf_tinhtrang = new JTextField();
        tf_tinhtrang.setForeground(Color.BLACK);
        tf_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 15;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(tf_tinhtrang, gdc);

        JLabel khung_anh = new JLabel();
        khung_anh.setBackground(Color.LIGHT_GRAY);
        khung_anh.setBorder(BorderFactory.createLineBorder(Color.black,3));
        gdc.gridx = 2;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.gridheight = 5;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 100, 30, 80);
        main.add(khung_anh, gdc);
        
        //ko thay đổi trường nhập liệu
        tf_maThuoc.setEditable(false);
        tf_maThuoc.setBackground(Color.white);
        tf_maThuoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_tenthuoc.setEditable(false);
        tf_tenthuoc.setBackground(Color.white);
        tf_tenthuoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_danhmuc.setEditable(false);
        tf_danhmuc.setBackground(Color.white);
        tf_danhmuc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_donvi.setEditable(false);
        tf_donvi.setBackground(Color.white);
        tf_donvi.setBorder(BorderFactory.createLineBorder(Color.black,1));
        ta_thanhphan.setEditable(false);
        ta_thanhphan.setBackground(Color.white);
        ta_thanhphan.setBorder(BorderFactory.createLineBorder(Color.black,1));
        ta_thongtin.setEditable(false);
        ta_thongtin.setBackground(Color.white);
        ta_thongtin.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_xuatxu.setEditable(false);
        tf_xuatxu.setBackground(Color.white);
        tf_xuatxu.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_dsdt.setEditable(false);
        tf_dsdt.setBackground(Color.white);
        tf_dsdt.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_giahop.setEditable(false);
        tf_giahop.setBackground(Color.white);
        tf_giahop.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_giavi.setEditable(false);
        tf_giavi.setBackground(Color.white);
        tf_giavi.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_giavien.setEditable(false);
        tf_giavien.setBackground(Color.white);
        tf_giavien.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_slhop.setEditable(false);
        tf_slhop.setBackground(Color.white);
        tf_slhop.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_slvi.setEditable(false);
        tf_slvi.setBackground(Color.white);
        tf_slvi.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_slvien.setEditable(false);
        tf_slvien.setBackground(Color.white);
        tf_slvien.setBorder(BorderFactory.createLineBorder(Color.black,1));
        tf_tinhtrang.setEditable(false);
        tf_tinhtrang.setBackground(Color.white);
        tf_tinhtrang.setBorder(BorderFactory.createLineBorder(Color.black,1));

        this.setVisible(true);

        //xử lý các tính năng
        medicine_BUS.loadDetailsMedicine(mathuoc, tf_maThuoc, tf_tenthuoc, 
        tf_danhmuc, tf_donvi, ta_thanhphan, ta_thongtin, tf_xuatxu, tf_dsdt, 
        tf_tinhtrang, khung_anh, tf_giahop, tf_giavi, tf_giavien, tf_slhop, 
        tf_slvi, tf_slvien);
    }

    public static void main(String[] args) {
        new medicine_GUI(null);
    }
}
