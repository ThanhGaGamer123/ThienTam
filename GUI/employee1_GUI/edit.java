package GUI.employee1_GUI;

import java.util.Arrays;
import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import BUS.employee_BUS;
import BUS.store_BUS;
import DTO.employee_DTO;
import DTO.store_DTO;

public class edit extends JFrame implements ActionListener {
    JLabel lb_manv, lb_tennv, lb_sdt, lb_sonha, lb_duong, lb_phuong, lb_quan, lb_tinh, lb_cccd, lb_username, lb_pass,
            lb_nhathuoc, lb_cv, lb_gioitinh, lb_tt;
    JTextField tf_manv, tf_tennv, tf_sdt, tf_sonha, tf_duong, tf_phuong, tf_quan, tf_tinh, tf_cccd, tf_username,
            tf_pass;
    JButton btn_xacnhan, btn_huy;
    JComboBox<String> cb_cv, cb_gioitinh, cb_nhathuoc, cb_tinhtrang;

    public edit(employee_DTO nv) {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        lb_manv = new JLabel("Mã NV:");
        lb_manv.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_manv, gbc);
        tf_manv = new JTextField(30);
        tf_manv.setFont(new Font(null, Font.PLAIN, 20));
        tf_manv.setText(nv.getManv());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_manv, gbc);

        lb_tennv = new JLabel("Tên NV:");
        lb_tennv.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_tennv, gbc);
        tf_tennv = new JTextField(30);
        tf_tennv.setText(nv.getTennv());
        tf_tennv.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_tennv, gbc);

        lb_cv = new JLabel("Chức vụ:");
        lb_cv.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_cv, gbc);
        String[] cv = { "Nhân viên", "Quản lý" };
        cb_cv = new JComboBox<>(cv);
        cb_cv.setFont(new Font(null, Font.PLAIN, 20));
        cb_cv.setSelectedItem(nv.getChucvu());
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(cb_cv, gbc);

        lb_gioitinh = new JLabel("Giới tính:");
        lb_gioitinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_gioitinh, gbc);
        String[] gt = { "Nam", "Nữ" };
        cb_gioitinh = new JComboBox<>(gt);
        cb_gioitinh.setFont(new Font(null, Font.PLAIN, 20));
        cb_gioitinh.setSelectedItem(nv.getGioitinh());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(cb_gioitinh, gbc);

        lb_cccd = new JLabel("CCCD:");
        lb_cccd.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_cccd, gbc);
        tf_cccd = new JTextField(30);
        tf_cccd.setText(nv.getCccd());
        tf_cccd.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_cccd, gbc);

        lb_sdt = new JLabel("SDT:");
        lb_sdt.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_sdt, gbc);
        tf_sdt = new JTextField(30);
        tf_sdt.setText(nv.getSdt());
        tf_sdt.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_sdt, gbc);

        lb_sonha = new JLabel("Số nhà:");
        lb_sonha.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_sonha, gbc);
        tf_sonha = new JTextField(30);
        tf_sonha.setText(nv.getMasonha());
        tf_sonha.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_sonha, gbc);

        lb_duong = new JLabel("Tên đường:");
        lb_duong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_duong, gbc);
        tf_duong = new JTextField(30);
        tf_duong.setText(nv.getDuong());
        tf_duong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_duong, gbc);

        lb_phuong = new JLabel("Phường:");
        lb_phuong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_phuong, gbc);
        tf_phuong = new JTextField(30);
        tf_phuong.setText(nv.getPhuong());
        tf_phuong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_phuong, gbc);

        lb_quan = new JLabel("Quận:");
        lb_quan.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_quan, gbc);
        tf_quan = new JTextField(30);
        tf_quan.setText(nv.getQuan());
        tf_quan.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_quan, gbc);

        lb_tinh = new JLabel("Tỉnh:");
        lb_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_tinh, gbc);
        tf_tinh = new JTextField(30);
        tf_tinh.setText(nv.getTinh());
        tf_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_tinh, gbc);

        lb_username = new JLabel("Tài khoản:");
        lb_username.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_username, gbc);
        tf_username = new JTextField(30);
        tf_username.setText(nv.getUsername());
        tf_username.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_username, gbc);

        lb_pass = new JLabel("Mật khẩu:");
        lb_pass.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_pass, gbc);
        tf_pass = new JTextField(30);
        tf_pass.setText(nv.getPassword());
        tf_pass.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(tf_pass, gbc);

        lb_nhathuoc = new JLabel("Công tác tại:");
        lb_nhathuoc.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_nhathuoc, gbc);
        String[] nhathuoc = new String[0];
        ArrayList<store_DTO> storelist = new ArrayList<>();
        storelist = store_BUS.getAll();
        for (store_DTO st : storelist) {
            String dc = st.getMasonha() + "," + st.getDuong() + "," + st.getPhuong() + "," + st.getQuan() + ","
                    + st.getTinh();
            nhathuoc = Arrays.copyOf(nhathuoc, nhathuoc.length + 1);
            nhathuoc[nhathuoc.length - 1] = dc;
        }
        cb_nhathuoc = new JComboBox<>(nhathuoc);
        cb_nhathuoc.setFont(new Font(null, Font.PLAIN, 20));

        String mant = nv.getManhathuoc();
        ArrayList<store_DTO> ntlist = store_BUS.getAll();
        for (store_DTO st : ntlist) {
            String dc = st.getMasonha() + "," + st.getDuong() + "," + st.getPhuong() + "," + st.getQuan() + ","
                    + st.getTinh();
            if (mant.equals(st.getMant())) {
                cb_nhathuoc.setSelectedItem(dc);
            }
        }

        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(cb_nhathuoc, gbc);

        lb_tt = new JLabel("Tình trạng:");
        lb_tt.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        contentPanel.add(lb_tt, gbc);
        String item[] = { "Đang hoạt động", "Đã tạm dừng" };
        cb_tinhtrang = new JComboBox<>(item);
        cb_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        if (nv.getTinhtrang()) {
            cb_tinhtrang.setSelectedIndex(0);
        } else {
            cb_tinhtrang.setSelectedIndex(1);
        }
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        contentPanel.add(cb_tinhtrang, gbc);

        JPanel panel_btn = new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        gbc.gridx = 0;
        gbc.gridy = 15;
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
        contentPanel.add(panel_btn, gbc);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_xacnhan) {
            String manv = tf_manv.getText();
            String tennv = tf_tennv.getText();
            String chucvu = (String) cb_cv.getSelectedItem();
            String gioitinh = (String) cb_gioitinh.getSelectedItem();
            String cccd = tf_cccd.getText();
            String sdt = tf_sdt.getText();
            String masonha = tf_sonha.getText();
            String duong = tf_duong.getText();
            String phuong = tf_phuong.getText();
            String quan = tf_quan.getText();
            String tinh = tf_tinh.getText();
            String tk = tf_username.getText();
            String pass = tf_pass.getText();
            String nhathuoc = (String) cb_nhathuoc.getSelectedItem();
            Boolean tt = false;
            if (cb_tinhtrang.getSelectedItem().equals("Đang hoạt động")) {
                tt = true;
            }
            if (manv.isEmpty() || tennv.isEmpty() || sdt.isEmpty() || masonha.isEmpty() || duong.isEmpty()
                    || phuong.isEmpty() || quan.isEmpty() || tinh.isEmpty() || cccd.isEmpty() || tk.isEmpty()
                    || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String mant = null;
            ArrayList<store_DTO> ntlist = store_BUS.getAll();
            for (store_DTO st : ntlist) {
                String dc = st.getMasonha() + "," + st.getDuong() + "," + st.getPhuong() + "," + st.getQuan() + ","
                        + st.getTinh();
                if (dc.equals(nhathuoc)) {
                    mant = st.getMant();
                }
            }

            employee_BUS.edit(new employee_DTO(manv, tennv, chucvu, gioitinh, cccd, sdt, masonha, duong, phuong, quan,
                    tinh, tk, pass, mant, tt));
            JOptionPane.showMessageDialog(null, "Sửa thành công", "Sửa nhân viên", JOptionPane.PLAIN_MESSAGE);
            dispose();
        } else if (e.getSource() == btn_huy) {
            dispose();
        }
    }
}
