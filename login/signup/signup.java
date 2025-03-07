package login.signup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class signup extends JFrame {
    public signup() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setTitle("Đăng Ký");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        this.setLayout(null);
        JPanel form = new JPanel();
        form.setBackground(Color.white);
        form.setBounds(340, 85, 550, 500);
        form.setLayout(null);
        
        JLabel title = new JLabel();
        title.setText("ĐĂNG KÝ");
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setBounds(205, 80, 350, 50);
        title.setForeground(Color.BLACK);

        JLabel username = new JLabel();
        username.setText("Tài khoản:");
        username.setFont(new Font(null, Font.PLAIN, 20));
        username.setBounds(95, 140, 350, 50);
        username.setForeground(Color.BLACK);

        JLabel email = new JLabel();
        email.setText("Email:");
        email.setFont(new Font(null, Font.PLAIN, 20));
        email.setBounds(132, 200, 350, 50);
        email.setForeground(Color.BLACK);

        JLabel password = new JLabel();
        password.setText("Mật khẩu:");
        password.setFont(new Font(null, Font.PLAIN, 20));
        password.setBounds(100, 260, 350, 50);
        password.setForeground(Color.BLACK);

        JLabel re_password = new JLabel();
        re_password.setText("Nhập lại mật khẩu:");
        re_password.setFont(new Font(null, Font.PLAIN, 20));
        re_password.setBounds(30, 320, 350, 50);
        re_password.setForeground(Color.BLACK);

        JTextField user_field = new JTextField();
        user_field.setFont(new Font(null, Font.PLAIN, 20));
        user_field.setBounds(200, 152, 230, 30);
        user_field.setForeground(Color.BLACK);

        JTextField email_field = new JTextField();
        email_field.setFont(new Font(null, Font.PLAIN, 20));
        email_field.setBounds(200, 212, 230, 30);
        email_field.setForeground(Color.BLACK);

        JTextField pass_field = new JTextField();
        pass_field.setFont(new Font(null, Font.PLAIN, 20));
        pass_field.setBounds(200, 272, 230, 30);
        pass_field.setForeground(Color.BLACK);

        JTextField re_pass_field = new JTextField();
        re_pass_field.setFont(new Font(null, Font.PLAIN, 20));
        re_pass_field.setBounds(200, 332, 230, 30);
        re_pass_field.setForeground(Color.BLACK);

        JButton login = new JButton();
        login.setText("Đăng Ký");
        login.setFont(new Font(null, Font.PLAIN, 18));
        login.setBounds(200, 390, 150, 30);
        login.setForeground(Color.BLACK);
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
        signup.setBounds(120, 440, 300, 20);
        signup.setForeground(Color.blue);
        signup.setBorderPainted(false);
        signup.setBackground(Color.white);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lien ket toi log in page
                new login();
                dispose();
            }
        });
        
        form.add(title);
        form.add(username);
        form.add(email);
        form.add(password);
        form.add(re_password);
        form.add(user_field);
        form.add(email_field);
        form.add(pass_field);
        form.add(re_pass_field);
        form.add(login);
        form.add(signup);

        this.add(form);
        this.setVisible(true);
    }
}
