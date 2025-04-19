package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import advanceMethod.advance;

public class signup_GUI extends JFrame {
    public signup_GUI() {
        // this.setSize(1280, 720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        
        this.setTitle("Đăng Ký");
        ImageIcon logo = new ImageIcon(advance.img+"logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(0,153,102));
        this.setLayout(new BorderLayout());

        JPanel bg_north = new JPanel();
        bg_north.setBackground(new Color(0,153,102));
        bg_north.setPreferredSize(new Dimension(0, 100));
        this.add(bg_north, BorderLayout.NORTH);

        JPanel bg_south = new JPanel();
        bg_south.setBackground(new Color(0,153,102));
        bg_south.setPreferredSize(new Dimension(0, 100));
        this.add(bg_south, BorderLayout.SOUTH);

        JPanel bg_east = new JPanel();
        bg_east.setBackground(new Color(0,153,102));
        bg_east.setPreferredSize(new Dimension(400, 0));
        this.add(bg_east, BorderLayout.EAST);

        JPanel bg_west = new JPanel();
        bg_west.setBackground(new Color(0,153,102));
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

        JLabel username = new JLabel();
        username.setText("Tài khoản:");
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

        JLabel email = new JLabel();
        email.setText("Email:");
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

        JLabel password = new JLabel();
        password.setText("Mật khẩu:");
        password.setFont(new Font(null, Font.PLAIN, 20));
        password.setForeground(Color.BLACK);
        // password.setBounds(100, 260, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.insets = new Insets(0, 50, 30, 5);
        form.add(password, gdc);

        JTextField pass_field = new JTextField();
        pass_field.setFont(new Font(null, Font.PLAIN, 20));
        pass_field.setForeground(Color.BLACK);
        // pass_field.setBounds(200, 272, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 30, 50);
        form.add(pass_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        JLabel re_password = new JLabel();
        re_password.setText("Nhập lại mật khẩu:");
        re_password.setFont(new Font(null, Font.PLAIN, 20));
        re_password.setForeground(Color.BLACK);
        // re_password.setBounds(30, 320, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.insets = new Insets(0, 50, 40, 5);
        form.add(re_password, gdc);

        JTextField re_pass_field = new JTextField();
        re_pass_field.setFont(new Font(null, Font.PLAIN, 20));
        re_pass_field.setForeground(Color.BLACK);
        // re_pass_field.setBounds(200, 332, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 40, 50);
        form.add(re_pass_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.anchor = GridBagConstraints.CENTER;

        JButton login = new JButton();
        login.setText("Đăng Ký");
        login.setFont(new Font(null, Font.PLAIN, 18));
        login.setForeground(Color.BLACK);
        login.setBackground(new Color(76, 175, 80));
        // login.setBounds(200, 390, 150, 30);
        login.setPreferredSize(new Dimension(0, 50));
        gdc.gridx = 0;
        gdc.gridy = 5;
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
                JOptionPane.showMessageDialog(null,
                 user_field.getText() + " " +
                 email_field.getText() + " " +
                 pass_field.getText() + " " +
                 re_pass_field.getText(),
                  "Thông báo",
                   JOptionPane.INFORMATION_MESSAGE);

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
        gdc.gridy = 6;
        gdc.gridwidth = 2;
        gdc.insets = new Insets(0, 50, 80, 50);
        form.add(signup, gdc);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lien ket toi log in page
                new login_GUI();
                dispose();
            }
        });

        this.setVisible(true);
    }
}
