package GUI.supplier_GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.supplier_BUS;
import DTO.supplier_DTO;

public class add extends JFrame implements ActionListener {
    JLabel lb_mancc, lb_tenncc, lb_sdt, lb_sonha, lb_duong, lb_phuong, lb_quan, lb_tinh;
    JTextField tf_mancc, tf_tenncc, tf_sdt, tf_sonha, tf_duong, tf_phuong, tf_quan, tf_tinh;
    JButton btn_xacnhan, btn_huy;
    DefaultTableModel model;
    JTable table;

    public add(DefaultTableModel modelSupplier, JTable tableSupplier) {
        this.model = modelSupplier;
        this.table = tableSupplier;
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        lb_mancc = new JLabel("Mã NCC:");
        lb_mancc.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_mancc, gbc);
        tf_mancc = new JTextField(30);
        tf_mancc.setFont(new Font(null, Font.PLAIN, 20));
        tf_mancc.setText(supplier_BUS.getLastID());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_mancc, gbc);

        lb_tenncc = new JLabel("Tên NCC:");
        lb_tenncc.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_tenncc, gbc);
        tf_tenncc = new JTextField(30);
        tf_tenncc.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_tenncc, gbc);

        lb_sdt = new JLabel("SDT:");
        lb_sdt.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_sdt, gbc);
        tf_sdt = new JTextField(30);
        tf_sdt.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_sdt, gbc);

        lb_sonha = new JLabel("Số nhà:");
        lb_sonha.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_sonha, gbc);
        tf_sonha = new JTextField(30);
        tf_sonha.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_sonha, gbc);

        lb_duong = new JLabel("Tên đường:");
        lb_duong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_duong, gbc);
        tf_duong = new JTextField(30);
        tf_duong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_duong, gbc);

        lb_phuong = new JLabel("Phường:");
        lb_phuong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_phuong, gbc);
        tf_phuong = new JTextField(30);
        tf_phuong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_phuong, gbc);

        lb_quan = new JLabel("Quận:");
        lb_quan.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_quan, gbc);
        tf_quan = new JTextField(30);
        tf_quan.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_quan, gbc);

        lb_tinh = new JLabel("Tỉnh:");
        lb_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_tinh, gbc);
        tf_tinh = new JTextField(30);
        tf_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_tinh, gbc);

        JPanel panel_btn = new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        btn_xacnhan = new JButton("Xác nhận");
        btn_xacnhan.setFont(new Font(null, Font.PLAIN, 20));
        btn_xacnhan.addActionListener(this);
        panel_btn.add(btn_xacnhan);
        btn_huy = new JButton("Hủy");
        btn_huy.setFont(new Font(null, Font.PLAIN, 20));
        btn_huy.addActionListener(this);
        panel_btn.add(btn_huy);
        add(panel_btn, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_xacnhan) {
            String mancc = tf_mancc.getText();
            String tenncc = tf_tenncc.getText();
            ArrayList<supplier_DTO> suplis = supplier_BUS.getAll();
            for (supplier_DTO sup : suplis) {
                if (sup.getTenncc().equals(tenncc)) {
                    JOptionPane.showMessageDialog(this, "Tên nhà cung cấp đã tồn tại", "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String sdt = tf_sdt.getText();
            String masonha = tf_sonha.getText();
            String duong = tf_duong.getText();
            String phuong = tf_phuong.getText();
            String quan = tf_quan.getText();
            String tinh = tf_tinh.getText();

            if (mancc.isEmpty() || tenncc.isEmpty() || sdt.isEmpty() || masonha.isEmpty() || duong.isEmpty()
                    || phuong.isEmpty() || quan.isEmpty() || tinh.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            supplier_BUS.insert(new supplier_DTO(mancc, tenncc, sdt, masonha, duong, phuong, quan, tinh, true));
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thêm nhà cung cấp", JOptionPane.PLAIN_MESSAGE);
            supplier_BUS.loadTable(model);
            table.setModel(model);
            dispose();
        } else if (e.getSource() == btn_huy) {
            dispose();
        }
    }
}
