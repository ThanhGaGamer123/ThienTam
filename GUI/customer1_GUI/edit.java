package GUI.customer1_GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import BUS.customer_BUS;
import DTO.customer_DTO;

public class edit extends JFrame implements ActionListener {
    JLabel lb_makh, lb_tenkh, lb_sdt, lb_sonha, lb_duong, lb_phuong, lb_quan, lb_tinh, lb_tt, lb_email, lb_pass,
            lb_diemkm;
    JTextField tf_makh, tf_tenkh, tf_sdt, tf_sonha, tf_duong, tf_phuong, tf_quan, tf_tinh, tf_email, tf_pass;
    JButton btn_xacnhan, btn_huy;
    JComboBox<String> cb_tinhtrang;
    JSpinner spinner_diemkm = null;
    DefaultTableModel model;
    JTable table;

    public edit(customer_DTO kh, DefaultTableModel modelCustomer, JTable tableCustomer) {
        this.model = modelCustomer;
        this.table = tableCustomer;
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        lb_makh = new JLabel("Mã KH:");
        lb_makh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_makh, gbc);
        tf_makh = new JTextField(30);
        tf_makh.setFont(new Font(null, Font.PLAIN, 20));
        tf_makh.setText(kh.getMakh());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_makh, gbc);

        lb_tenkh = new JLabel("Tên KH:");
        lb_tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_tenkh, gbc);
        tf_tenkh = new JTextField(30);
        tf_tenkh.setText(kh.getTenkh());
        tf_tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_tenkh, gbc);

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
        tf_sdt.setText(kh.getSdt());
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
        tf_sonha.setText(kh.getMasonha());
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
        tf_duong.setText(kh.getDuong());
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
        tf_phuong.setText(kh.getPhuong());
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
        tf_quan.setText(kh.getQuan());
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
        tf_tinh.setText(kh.getTinh());
        tf_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_tinh, gbc);

        lb_tt = new JLabel("Tình trạng:");
        lb_tt.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_tt, gbc);
        String item[] = { "Đang hoạt động", "Đã tạm dừng" };
        cb_tinhtrang = new JComboBox<>(item);
        cb_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        if (kh.getTinhtrang()) {
            cb_tinhtrang.setSelectedIndex(0);
        } else {
            cb_tinhtrang.setSelectedIndex(1);
        }
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(cb_tinhtrang, gbc);

        lb_email = new JLabel("Email:");
        lb_email.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_email, gbc);
        tf_email = new JTextField(30);
        tf_email.setText(kh.getEmail());
        tf_email.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_email, gbc);

        lb_pass = new JLabel("Mật khẩu:");
        lb_pass.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_pass, gbc);
        tf_pass = new JTextField(30);
        tf_pass.setText(kh.getPassword());
        tf_pass.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_pass, gbc);

        lb_diemkm = new JLabel("Điểm khuyến mãi:");
        lb_diemkm.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_diemkm, gbc);
        SpinnerModel listModel = new SpinnerNumberModel(0, 0, null, 100);
        spinner_diemkm = new JSpinner(listModel);
        spinner_diemkm.setFont(new Font(null, Font.PLAIN, 20));
        spinner_diemkm.setValue(kh.getDiemKM());
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(spinner_diemkm, gbc);

        JPanel panel_btn = new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        gbc.gridx = 0;
        gbc.gridy = 12;
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
            String makh = tf_makh.getText();
            String tenkh = tf_tenkh.getText();
            String sdt = tf_sdt.getText();
            String masonha = tf_sonha.getText();
            String duong = tf_duong.getText();
            String phuong = tf_phuong.getText();
            String quan = tf_quan.getText();
            String tinh = tf_tinh.getText();
            String email = tf_email.getText();
            ArrayList<customer_DTO> cuslist = customer_BUS.getAll();
            for (customer_DTO cus : cuslist) {
                if (cus.getEmail().equals(email)) {
                    JOptionPane.showMessageDialog(this, "Email khách hàng đã tồn tại", "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String pass = tf_pass.getText();
            String diemKM = String.valueOf(spinner_diemkm.getValue());
            Boolean tt = false;
            if (cb_tinhtrang.getSelectedItem().equals("Đang hoạt động")) {
                tt = true;
            }

            if (makh.isEmpty() || tenkh.isEmpty() || sdt.isEmpty() || masonha.isEmpty() || duong.isEmpty()
                    || phuong.isEmpty() || quan.isEmpty() || tinh.isEmpty() || email.isEmpty() || pass.isEmpty()
                    || diemKM.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            customer_BUS.edit(new customer_DTO(makh, tenkh, sdt, masonha, duong, phuong, quan, tinh, email, pass,
                    Integer.parseInt(diemKM), tt));
            JOptionPane.showMessageDialog(null, "Sửa thành công", "Sửa khách hàng", JOptionPane.PLAIN_MESSAGE);
            customer_BUS.loadTable(model);
            table.setModel(model);
            dispose();
        } else if (e.getSource() == btn_huy) {
            dispose();
        }
    }
}
