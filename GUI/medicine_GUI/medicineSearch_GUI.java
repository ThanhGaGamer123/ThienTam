package GUI.medicine_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import BUS.medicine_BUS;
import advanceMethod.advance;

public class medicineSearch_GUI extends JFrame {
    public medicineSearch_GUI(DefaultTableModel modelMedic, DefaultTableModel modelMedicSupply) {
        this.setSize(1000, 800);
        this.setTitle("Tìm kiếm thuốc nâng cao");
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

        JLabel title = new JLabel("Tìm Kiếm Thuốc Nâng Cao");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel mathuoc = new JLabel("Mã thuốc:");
        mathuoc.setForeground(Color.BLACK);
        mathuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(mathuoc, gdc);

        JTextField tf_mathuoc = new JTextField();
        tf_mathuoc.setForeground(Color.BLACK);
        tf_mathuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_mathuoc, gdc);

        JLabel tenthuoc = new JLabel("Tên thuốc:");
        tenthuoc.setForeground(Color.BLACK);
        tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
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
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_tenthuoc, gdc);

        JLabel danhmuc = new JLabel("Danh mục:");
        danhmuc.setForeground(Color.BLACK);
        danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
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
        gdc.gridy = 3;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_danhmuc, gdc);

        JLabel xuatxu = new JLabel("Xuất xứ:");
        xuatxu.setForeground(Color.BLACK);
        xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
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
        gdc.gridy = 4;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_xuatxu, gdc);

        JLabel doituong = new JLabel("Đối tượng sử dụng:");
        doituong.setForeground(Color.BLACK);
        doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
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
        gdc.gridy = 5;
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
        gdc.gridy = 5;
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
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(btn_xoa_doituong, gdc);

        JLabel ds_doituong = new JLabel("Danh sách đối tượng sử dụng:");
        ds_doituong.setForeground(Color.BLACK);
        ds_doituong.setFont(new Font(null, Font.PLAIN, 20));

        JPanel dsdt = new JPanel(new FlowLayout());
        dsdt.setBackground(Color.white);
        dsdt.add(ds_doituong);
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 100);
        main.add(dsdt, gdc);

        JLabel hansd = new JLabel("Hạn sử dụng:");
        hansd.setForeground(Color.BLACK);
        hansd.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(hansd, gdc);

        SpinnerNumberModel sp_model = new SpinnerNumberModel(0, 0, 36, 1);
        JSpinner sp_hansd = new JSpinner(sp_model);
        sp_hansd.setForeground(Color.BLACK);
        sp_hansd.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(sp_hansd, gdc);

        String[] time = {"tháng", "năm"};
        JComboBox cb_hansd = new JComboBox(time);
        cb_hansd.setForeground(Color.BLACK);
        cb_hansd.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(cb_hansd, gdc);

        JLabel gia_hop = new JLabel("Giá hộp:");
        gia_hop.setForeground(Color.BLACK);
        gia_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(gia_hop, gdc);

        SpinnerNumberModel sp_hop = new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 1000.0);
        JSpinner sp_gia_hop = new JSpinner(sp_hop);
        sp_gia_hop.setForeground(Color.BLACK);
        sp_gia_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 8;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(sp_gia_hop, gdc);

        JLabel gia_vi = new JLabel("Giá vỉ:");
        gia_vi.setForeground(Color.BLACK);
        gia_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(gia_vi, gdc);

        SpinnerNumberModel sp_vi = new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 1000.0);
        JSpinner sp_gia_vi = new JSpinner(sp_vi);
        sp_gia_vi.setForeground(Color.BLACK);
        sp_gia_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 9;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(sp_gia_vi, gdc);

        JLabel gia_vien = new JLabel("Giá viên:");
        gia_vien.setForeground(Color.BLACK);
        gia_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 10;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(gia_vien, gdc);

        SpinnerNumberModel sp_vien = new SpinnerNumberModel(0.0, 0.0, 10000000000.0, 1000.0);
        JSpinner sp_gia_vien = new JSpinner(sp_vien);
        sp_gia_vien.setForeground(Color.BLACK);
        sp_gia_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 10;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(sp_gia_vien, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tinhtrang, gdc);

        String[] dstinhtrang =  {"Không có", "Đang hoạt động", "Ngừng hoạt động"};
        JComboBox cb_tinhtrang = new JComboBox(dstinhtrang);
        cb_tinhtrang.setForeground(Color.BLACK);
        cb_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 11;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(cb_tinhtrang, gdc);

        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 12;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(finish, gdc);

        JButton reset = new JButton("Đặt lại");
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 12;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(reset, gdc);

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
                medicine_BUS.findMedicine(sp_gia_hop, sp_gia_vi, sp_gia_vien, 
                tf_mathuoc, tf_tenthuoc, tf_danhmuc, tf_xuatxu, chosen, cb_tinhtrang, 
                modelMedic, modelMedicSupply, sp_hansd, cb_hansd);
            }
        });

        //reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine_BUS.resetFind(tf_mathuoc, tf_tenthuoc, tf_danhmuc, sp_gia_hop, 
                sp_gia_vi, sp_gia_vien, tf_xuatxu, cb_doituong, ds_doituong, chosen,
                sp_hansd, cb_hansd, cb_tinhtrang);
            }
        });
    }

    public static void main(String[] args) {
        new medicineSearch_GUI(null, null);
    }
}
