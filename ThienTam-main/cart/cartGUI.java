package cart;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import customer.customerGUI;

public class cartGUI extends JFrame {
    private JPanel header, tail, body;
    private JLabel title;
    private JButton back;
    private customerGUI khach;
    private String ten; // Thêm biến để lưu tên khách hàng

    // Màu sắc tùy chỉnh
    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);

    public cartGUI(customerGUI khach, String ten) {
        this.khach = khach;
        this.ten = ten; // Lưu tên khách hàng

        setTitle("Giỏ hàng");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        create_header();
        create_body();
        create_footer();

        setVisible(true);
    }

    private void create_header() {
        header = new JPanel();
        header.setBackground(xanhla);
        header.setPreferredSize(new Dimension(0, 100));
        header.setLayout(null);

        title = new JLabel("Giỏ hàng");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(600, 30, 300, 40);
        header.add(title);

        back = new JButton("Quay lai");
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setBounds(10, 10, 80, 20);
        back.setForeground(Color.white);
        back.setBackground(hong);
        header.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khach.setVisible(true);
                dispose();
            }
        });

        add(header, BorderLayout.NORTH);
    }

    private void create_body() {
        body = new JPanel();
        body.setBackground(Color.white);
        body.setPreferredSize(new Dimension(0, 500));
        body.setLayout(null);
        add(body, BorderLayout.CENTER);

        JTextField t1 = new JTextField();
        t1.setBounds(10, 40, 200, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 16));
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.WHITE);
        t1.setText(ten);
        t1.setEditable(false);

        body.add(t1);
    }

    private void create_footer() {
        tail = new JPanel(new GridBagLayout());
        tail.setBackground(xanhla);
        tail.setPreferredSize(new Dimension(0, 80));

        JLabel detail_tail = new JLabel("nhathuocthientam@gmail.com.vn");
        detail_tail.setFont(new Font("Arial", Font.ITALIC, 13));
        detail_tail.setForeground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);

        tail.add(detail_tail, gbc);
        add(tail, BorderLayout.SOUTH);
    }
}
