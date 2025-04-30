package GUI;

import advanceMethod.advance;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class signup_GUI extends JFrame {
    public signup_GUI() {
        // this.setSize(1280, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);

        this.setTitle("Đăng Ký");
        ImageIcon logo = new ImageIcon(advance.img + "logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(0, 153, 102));
        this.setLayout(new BorderLayout());

        JPanel bg_north = new JPanel();
        bg_north.setBackground(new Color(0, 153, 102));
        bg_north.setPreferredSize(new Dimension(0, 100));
        this.add(bg_north, BorderLayout.NORTH);

        JPanel bg_south = new JPanel();
        bg_south.setBackground(new Color(0, 153, 102));
        bg_south.setPreferredSize(new Dimension(0, 100));
        this.add(bg_south, BorderLayout.SOUTH);

        JPanel bg_east = new JPanel();
        bg_east.setBackground(new Color(0, 153, 102));
        bg_east.setPreferredSize(new Dimension(400, 0));
        this.add(bg_east, BorderLayout.EAST);

        JPanel bg_west = new JPanel();
        bg_west.setBackground(new Color(0, 153, 102));
        bg_west.setPreferredSize(new Dimension(400, 0));
        this.add(bg_west, BorderLayout.WEST);

        JPanel form = new JPanel();
        form.setBackground(Color.white);
        // form.setBounds(340, 85, 550, 500);
        form.setLayout(new GridBagLayout());
        this.add(form, BorderLayout.CENTER);

        GridBagConstraints gdc = new GridBagConstraints();

        JLabel title = new JLabel();
        title.setText("ĐĂNG KÝ");
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        // title.setBounds(205, 80, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 2;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(80, 50, 40, 50);
        form.add(title, gdc);

        // reset
        gdc.gridwidth = 1;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        gdc.anchor = GridBagConstraints.WEST;
        // ----------------------------------1)
        JLabel username = new JLabel();
        username.setText("Tên khách hàng :");
        username.setFont(new Font(null, Font.PLAIN, 20));
        username.setForeground(Color.BLACK);
        // username.setBounds(95, 140, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.insets = new Insets(0, 50, 30, 5);
        form.add(username, gdc);

        JTextField user_field = new JTextField();
        user_field.setFont(new Font(null, Font.PLAIN, 20));
        user_field.setForeground(Color.BLACK);
        // user_field.setBounds(200, 152, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 30, 50);
        form.add(user_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        // ----------------------------------2)

        JLabel email = new JLabel();
        email.setText("Email :");
        email.setFont(new Font(null, Font.PLAIN, 20));
        email.setForeground(Color.BLACK);
        // email.setBounds(132, 200, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.insets = new Insets(0, 50, 30, 5);
        form.add(email, gdc);

        JTextField email_field = new JTextField();
        email_field.setFont(new Font(null, Font.PLAIN, 20));
        email_field.setForeground(Color.BLACK);
        // email_field.setBounds(200, 212, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 30, 50);
        form.add(email_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        // ----------------------------------3)

        JLabel sdt = new JLabel();
        sdt.setText("Số điện thoại :");
        sdt.setFont(new Font(null, Font.PLAIN, 20));
        sdt.setForeground(Color.BLACK);
        // sdt.setBounds(132, 200, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.insets = new Insets(0, 50, 30, 5);
        form.add(sdt, gdc);

        JTextField sdt_field = new JTextField();
        sdt_field.setFont(new Font(null, Font.PLAIN, 20));
        sdt_field.setForeground(Color.BLACK);
        // sdt_field.setBounds(200, 212, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 30, 50);
        form.add(sdt_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        // ----------------------------------4)

        JLabel dchi = new JLabel();
        dchi.setText("Địa chỉ :");
        dchi.setFont(new Font(null, Font.PLAIN, 20));
        dchi.setForeground(Color.BLACK);
        // dchi.setBounds(100, 260, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.insets = new Insets(0, 50, 30, 5);
        form.add(dchi, gdc);

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new GridLayout(1, 3, 5, 0));

        // Address Field
        JTextField sonha_field = new JTextField();

        sonha_field.setBorder(BorderFactory.createTitledBorder("Số nhà"));
        sonha_field.setFont(new Font(null, Font.PLAIN, 20));
        sonha_field.setForeground(Color.BLACK);
        addressPanel.add(sonha_field); // Add to address panel

        JTextField duong_field = new JTextField();
        duong_field.setFont(new Font(null, Font.PLAIN, 20));
        duong_field.setBorder(BorderFactory.createTitledBorder("Đường"));
        duong_field.setForeground(Color.BLACK);
        addressPanel.add(duong_field);

        JTextField phuong_field = new JTextField();
        phuong_field.setFont(new Font(null, Font.PLAIN, 20));
        phuong_field.setBorder(BorderFactory.createTitledBorder("Phường"));
        phuong_field.setForeground(Color.BLACK);
        addressPanel.add(phuong_field); // Add to address panel

        // District Field
        JTextField quan_field = new JTextField();
        quan_field.setFont(new Font(null, Font.PLAIN, 20));
        quan_field.setBorder(BorderFactory.createTitledBorder("Quận/Xã"));
        quan_field.setForeground(Color.BLACK);
        addressPanel.add(quan_field); // Add to address panel

        // City Field
        JTextField tinh_field = new JTextField();
        tinh_field.setFont(new Font(null, Font.PLAIN, 20));
        tinh_field.setBorder(BorderFactory.createTitledBorder("Tỉnh/TP"));
        tinh_field.setForeground(Color.BLACK);
        addressPanel.add(tinh_field);

        gdc.gridx = 1; // Adjust grid position accordingly
        gdc.gridy = 4;
        gdc.gridwidth = 2; // Span across two columns if needed
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 30, 50);
        form.add(addressPanel, gdc);
        gdc.gridwidth = 1;

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        // ----------------------------------5)
        JLabel password = new JLabel();
        password.setText("Mật khẩu:");
        password.setFont(new Font(null, Font.PLAIN, 20));
        password.setForeground(Color.BLACK);
        // password.setBounds(100, 260, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.insets = new Insets(0, 50, 30, 5);
        form.add(password, gdc);

        JTextField pass_field = new JTextField();
        pass_field.setFont(new Font(null, Font.PLAIN, 20));
        pass_field.setForeground(Color.BLACK);
        // pass_field.setBounds(200, 272, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 30, 50);
        form.add(pass_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        // ----------------------------------6) Nhãn cho "Nhập lại mật khẩu:"
        JLabel re_password = new JLabel("Nhập lại mật khẩu:");
        re_password.setFont(new Font(null, Font.PLAIN, 20));
        re_password.setForeground(Color.BLACK);
        gdc.gridx = 0;
        gdc.gridy = 6; // Đảm bảo vị trí này đúng
        gdc.insets = new Insets(0, 50, 40, 5);
        form.add(re_password, gdc);

        // Trường văn bản để nhập lại mật khẩu
        JTextField re_pass_field = new JTextField();
        re_pass_field.setFont(new Font(null, Font.PLAIN, 20));
        re_pass_field.setForeground(Color.BLACK);
        gdc.gridx = 1; // Đảm bảo vị trí này đúng
        gdc.gridy = 6; // Cùng hàng với nhãn
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 40, 50);
        form.add(re_pass_field, gdc);

        // Đặt lại cho thành phần tiếp theo
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.anchor = GridBagConstraints.CENTER;
        // ----------------------------------7)

        JButton login = new JButton();
        login.setText("Đăng Ký");
        login.setFont(new Font(null, Font.PLAIN, 18));
        login.setForeground(Color.BLACK);
        login.setBackground(new Color(76, 175, 80));
        // login.setBounds(200, 390, 150, 30);
        login.setPreferredSize(new Dimension(0, 50));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 2;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 50, 40, 50);
        form.add(login, gdc);
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setBackground(new Color(100, 221, 23)); // Màu khi di chuột vào
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setBackground(new Color(76, 175, 80)); // Màu trở lại
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenkh = user_field.getText().trim();
                String email = email_field.getText().trim();
                String sdt = sdt_field.getText().trim();
                String masonha = sonha_field.getText().trim();
                String duong = duong_field.getText().trim();
                String phuong = phuong_field.getText().trim();
                String quan = quan_field.getText().trim();
                String tinh = tinh_field.getText().trim();
                String password = pass_field.getText().trim();
                String re_password = re_pass_field.getText().trim();

                // Kiểm tra các trường có bị bỏ trống
                if (tenkh.isEmpty() || email.isEmpty() || sdt.isEmpty() || masonha.isEmpty()
                        || duong.isEmpty() || phuong.isEmpty() || quan.isEmpty() || tinh.isEmpty()
                        || password.isEmpty() || re_password.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Vui lòng nhập đầy đủ tất cả các trường.",
                            "Thiếu thông tin",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Kiểm tra mật khẩu nhập lại
                if (!password.equals(re_password)) {
                    JOptionPane.showMessageDialog(null,
                            "Mật khẩu nhập lại không khớp.",
                            "Lỗi mật khẩu",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Gọi DAO để thêm khách hàng
                DAO.customerDAO dao = new DAO.customerDAO();
                dao.themKhachhang(tenkh, email, sdt, masonha, duong, phuong, quan, tinh, password);

                // Thông báo thành công
                JOptionPane.showMessageDialog(null,
                        "Đăng ký thành công!",
                        "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);

                // Đóng cửa sổ đăng ký nếu cần
                dispose();
                new login_GUI();
            }
        });
        JButton signup = new JButton();
        signup.setText("Đã có tài khoản? Đăng nhập ngay!");
        signup.setFont(new Font(null, Font.PLAIN, 14));
        signup.setForeground(Color.blue);
        signup.setBorderPainted(false);
        signup.setBackground(Color.white);
        // signup.setBounds(120, 440, 300, 20);
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 2;
        gdc.insets = new Insets(0, 50, 80, 50);
        form.add(signup, gdc);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // lien ket toi log in page
                new login_GUI();
                dispose();
            }
        });

        this.setVisible(true);
    }
}
