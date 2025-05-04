package GUI.promotion_GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import BUS.promotion_BUS;
import DTO.promotion_DTO;

public class add extends JFrame implements ActionListener {
    JLabel lb_makm, lb_tenkm, lb_ngaybd, lb_ngaykt, lb_giam, lb_noidung, lb_diemyc;
    JTextField tf_makm, tf_tenkm, tf_giam, tf_noidung, tf_diemyc;
    JButton btn_xacnhan, btn_huy;
    JSpinner dateSpinner, dateSpinner_1;

    public add() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        lb_makm = new JLabel("Mã KM:");
        lb_makm.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_makm, gbc);
        tf_makm = new JTextField(30);
        tf_makm.setFont(new Font(null, Font.PLAIN, 20));
        tf_makm.setText(promotion_BUS.getLastID());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_makm, gbc);

        lb_tenkm = new JLabel("Tên KM:");
        lb_tenkm.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_tenkm, gbc);
        tf_tenkm = new JTextField(30);
        tf_tenkm.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_tenkm, gbc);

        lb_ngaybd = new JLabel("Ngày bắt đầu:");
        lb_ngaybd.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_ngaybd, gbc);
        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
        dateSpinner.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(dateSpinner, gbc);

        lb_ngaybd = new JLabel("Ngày kết thúc:");
        lb_ngaybd.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_ngaybd, gbc);
        SpinnerDateModel dateModel_1 = new SpinnerDateModel();
        dateSpinner_1 = new JSpinner(dateModel_1);
        dateSpinner_1.setEditor(new JSpinner.DateEditor(dateSpinner_1, "dd/MM/yyyy"));
        dateSpinner_1.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(dateSpinner_1, gbc);

        lb_giam = new JLabel("Giá trị giảm:");
        lb_giam.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_giam, gbc);
        tf_giam = new JTextField(30);
        tf_giam.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_giam, gbc);

        lb_noidung = new JLabel("Nội dung:");
        lb_noidung.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_noidung, gbc);
        tf_noidung = new JTextField(30);
        tf_noidung.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_noidung, gbc);

        lb_diemyc = new JLabel("Điểm yêu cầu:");
        lb_diemyc.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_diemyc, gbc);
        tf_diemyc = new JTextField(30);
        tf_diemyc.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_diemyc, gbc);

        JPanel panel_btn = new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        gbc.gridx = 0;
        gbc.gridy = 7;
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
            if (tf_tenkm.getText().isEmpty() || tf_giam.getText().isEmpty() || tf_noidung.getText().isEmpty()
                    || tf_diemyc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (((java.util.Date) dateSpinner_1.getValue())
                    .compareTo((java.util.Date) dateSpinner.getValue()) < 0) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không được nhỏ hơn hoặc bằng ngày bắt đầu", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String makm = tf_makm.getText();
                String tenkm = tf_tenkm.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String ngaybd = (String.valueOf(sdf.format(dateSpinner.getValue())));
                String ngaykt = (String.valueOf(sdf.format(dateSpinner_1.getValue())));
                int giam = Integer.parseInt(tf_giam.getText());
                String noidung = tf_noidung.getText();
                int diemyc = Integer.parseInt(tf_diemyc.getText());
                promotion_BUS.insert(new promotion_DTO(makm, tenkm, ngaybd, ngaykt, noidung, giam, diemyc, true));
                JOptionPane.showMessageDialog(null, "Thêm thành công", "Thêm khuyến mãi", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Giá trị giảm và điểm yêu cầu phải là số", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            dispose();
        } else if (e.getSource() == btn_huy) {
            dispose();
        }

    }

    public static void main(String[] args) {
        new add();
    }
}
