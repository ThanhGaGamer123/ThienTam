package GUI.store1_GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BUS.employee_BUS;
import BUS.store_BUS;
import DTO.employee_DTO;
import DTO.store_DTO;

public class add extends JFrame implements ActionListener {
    JLabel lb_mant, lb_sonha, lb_duong, lb_phuong, lb_quan, lb_tinh, lb_nql;
    JTextField tf_mant, tf_sonha, tf_duong, tf_phuong, tf_quan, tf_tinh;
    JButton btn_xacnhan, btn_huy;
    JComboBox<String> cb_nql;

    public add() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        lb_mant = new JLabel("Mã NT:");
        lb_mant.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_mant, gbc);
        tf_mant = new JTextField(30);
        tf_mant.setFont(new Font(null, Font.PLAIN, 20));
        tf_mant.setText(store_BUS.getLastID());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_mant, gbc);

        lb_sonha = new JLabel("Số nhà:");
        lb_sonha.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_sonha, gbc);
        tf_sonha = new JTextField(30);
        tf_sonha.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_sonha, gbc);

        lb_duong = new JLabel("Tên đường:");
        lb_duong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_duong, gbc);
        tf_duong = new JTextField(30);
        tf_duong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_duong, gbc);

        lb_phuong = new JLabel("Phường:");
        lb_phuong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_phuong, gbc);
        tf_phuong = new JTextField(30);
        tf_phuong.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_phuong, gbc);

        lb_quan = new JLabel("Quận:");
        lb_quan.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_quan, gbc);
        tf_quan = new JTextField(30);
        tf_quan.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_quan, gbc);

        lb_tinh = new JLabel("Tỉnh:");
        lb_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_tinh, gbc);
        tf_tinh = new JTextField(30);
        tf_tinh.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(tf_tinh, gbc);

        lb_nql = new JLabel("Người quản lý:");
        lb_nql.setFont(new Font(null, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(lb_nql, gbc);
        String[] ql = new String[0];
        ArrayList<employee_DTO> employeelist = new ArrayList<>();
        employeelist = employee_BUS.getAll();
        for (employee_DTO st : employeelist) {
            if (st.getChucvu().equals("Quản lý")) {
                ql = Arrays.copyOf(ql, ql.length + 1);
                ql[ql.length - 1] = st.getTennv();
            }
        }
        ql = Arrays.copyOf(ql, ql.length + 1);
        ql[ql.length - 1] = "Không";
        cb_nql = new JComboBox<>(ql);
        cb_nql.setFont(new Font(null, Font.PLAIN, 20));
        cb_nql.setSelectedItem("Không");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(cb_nql, gbc);

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
            if (tf_mant.getText().isEmpty() || tf_sonha.getText().isEmpty() || tf_duong.getText().isEmpty()
                    || tf_phuong.getText().isEmpty() || tf_quan.getText().isEmpty() || tf_tinh.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            String mant = tf_mant.getText();
            String masonha = tf_sonha.getText();
            String duong = tf_duong.getText();
            String phuong = tf_phuong.getText();
            String quan = tf_quan.getText();
            String tinh = tf_tinh.getText();
            String nql = String.valueOf(cb_nql.getSelectedItem());
            String manql = null;
            ArrayList<employee_DTO> employeelist = new ArrayList<>();
            employeelist = employee_BUS.getAll();
            for (employee_DTO st : employeelist) {
                if (st.getTennv().equals(nql)) {
                    manql = st.getManv();
                }
            }
            store_BUS.insert(new store_DTO(mant, masonha, duong, phuong, quan, tinh, manql, true));
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thêm nhà thuốc", JOptionPane.PLAIN_MESSAGE);
            dispose();

        } else if (e.getSource() == btn_huy) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new add();
    }
}
