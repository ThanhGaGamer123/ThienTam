package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.customer_BUS;
import advanceMethod.advance;

public class customerSearch_GUI extends JFrame {
    public customerSearch_GUI(DefaultTableModel model) {
        this.setSize(1000, 800);
        this.setTitle("Tìm kiếm nâng cao");
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

        JLabel title = new JLabel("Tìm Kiếm Nâng Cao");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 11;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel makh = new JLabel("Mã khách hàng:");
        makh.setForeground(Color.BLACK);
        makh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(makh, gdc);

        JTextField tf_makh = new JTextField();
        tf_makh.setForeground(Color.BLACK);
        tf_makh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_makh, gdc);

        JLabel tenkh = new JLabel("Tên khách hàng:");
        tenkh.setForeground(Color.BLACK);
        tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenkh, gdc);

        JTextField tf_tenkh = new JTextField();
        tf_tenkh.setForeground(Color.BLACK);
        tf_tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_tenkh, gdc);

        JLabel sdt = new JLabel("Số điện thoại:");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(sdt, gdc);

        JTextField tf_sdt = new JTextField();
        tf_sdt.setForeground(Color.BLACK);
        tf_sdt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_sdt, gdc);

        JLabel email = new JLabel("Email:");
        email.setForeground(Color.BLACK);
        email.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(email, gdc);

        JTextField tf_email = new JTextField();
        tf_email.setForeground(Color.BLACK);
        tf_email.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_email, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
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
        gdc.gridy = 5;
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
        gdc.gridy = 6;
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
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(reset, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //tìm
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer_BUS.findAdvance(model, tf_makh, tf_tenkh, tf_sdt, tf_email, 
                cb_tinhtrang);
            }
        });

        //reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer_BUS.reset(model, tf_makh, tf_tenkh, tf_sdt, tf_email, cb_tinhtrang);
            }
        });
    }

    public static void main(String[] args) {
        new customerSearch_GUI(null);
    }
}
