package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import BUS.promotion_BUS;
import advanceMethod.advance;

public class promotionSearch_GUI extends JFrame{
    public promotionSearch_GUI(DefaultTableModel model) {
        this.setSize(1000, 800);
        this.setTitle("Tìm kiếm chương trình khuyến mãi");
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

        JLabel title = new JLabel("Tìm Kiếm Chương Trình Khuyến Mãi");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel makm = new JLabel("Mã khuyến mãi:");
        makm.setForeground(Color.BLACK);
        makm.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(makm, gdc);

        JTextField tf_makm = new JTextField();
        tf_makm.setForeground(Color.BLACK);
        tf_makm.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_makm, gdc);

        JLabel tenkm = new JLabel("Tên khuyến mãi:");
        tenkm.setForeground(Color.BLACK);
        tenkm.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenkm, gdc);

        JTextField tf_tenkm = new JTextField();
        tf_tenkm.setForeground(Color.BLACK);
        tf_tenkm.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenkm, gdc);

        JLabel ngaybatdau = new JLabel("Ngày bắt đầu:");
        ngaybatdau.setForeground(Color.BLACK);
        ngaybatdau.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngaybatdau, gdc);

        JTextField tf_ngaybatdau = new JTextField("dd/MM/yyyy");
        tf_ngaybatdau.setForeground(Color.BLACK);
        tf_ngaybatdau.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_ngaybatdau, gdc);

        JLabel ngayketthuc = new JLabel("Ngày kết thúc:");
        ngayketthuc.setForeground(Color.BLACK);
        ngayketthuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngayketthuc, gdc);

        JTextField tf_ngayketthuc = new JTextField("dd/MM/yyyy");
        tf_ngayketthuc.setForeground(Color.BLACK);
        tf_ngayketthuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_ngayketthuc, gdc);

        JLabel noidung = new JLabel("Nội dung:");
        noidung.setForeground(Color.BLACK);
        noidung.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(noidung, gdc);

        JTextArea ta_noidung = new JTextArea();
        ta_noidung.setForeground(Color.BLACK);
        ta_noidung.setFont(new Font(null, Font.PLAIN, 20));
        ta_noidung.setAutoscrolls(true);
        ta_noidung.setLineWrap(true);
        ta_noidung.setPreferredSize(new Dimension(0, 100));

        JScrollPane noidung_scroll = new JScrollPane();
        noidung_scroll.setViewportView(ta_noidung);

        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(noidung_scroll, gdc);

        JLabel giam = new JLabel("Giảm (%):");
        giam.setForeground(Color.BLACK);
        giam.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(giam, gdc);

        SpinnerNumberModel SP_giam = new SpinnerNumberModel(0, 0, 50, 1);
        JSpinner sp_giam = new JSpinner(SP_giam);
        sp_giam.setForeground(Color.BLACK);
        sp_giam.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 6;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_giam, gdc);

        JLabel diem = new JLabel("Điểm:");
        diem.setForeground(Color.BLACK);
        diem.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(diem, gdc);

        SpinnerNumberModel SP_diem = new SpinnerNumberModel(0, 0, null, 100);
        JSpinner sp_diem = new JSpinner(SP_diem);
        sp_diem.setForeground(Color.BLACK);
        sp_diem.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(sp_diem, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tinhtrang, gdc);

        String[] options = {"Không có", "Đang hoạt động", "Ngừng hoạt động"};
        JComboBox cb_tinhtrang = new JComboBox(options);
        cb_tinhtrang.setForeground(Color.BLACK);
        cb_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 8;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(cb_tinhtrang, gdc);

        JButton tim = new JButton("Tìm");
        tim.setForeground(Color.BLACK);
        tim.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tim, gdc);

        JButton reset = new JButton("Đặt lại");
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(reset, gdc);

        this.setVisible(true);

        //xử lý tính năng
        
        //tìm
        tim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promotion_BUS.searchAdvance(tf_makm, tf_tenkm, tf_ngaybatdau, tf_ngayketthuc, 
                ta_noidung, sp_giam, sp_diem, cb_tinhtrang, model);
            }
        });

        //reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_makm.setText("");
                tf_tenkm.setText("");
                tf_ngaybatdau.setText("");
                tf_ngayketthuc.setText("");
                ta_noidung.setText("");
                sp_giam.setValue(0);
                sp_diem.setValue(0);
                cb_tinhtrang.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        new promotionSearch_GUI(null);
    }
}
