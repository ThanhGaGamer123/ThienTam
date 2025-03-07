package login.signup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import employee.employGUI;
import employee.employee;
import employee.employeeArr;

public class login extends JFrame {
    public login() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setTitle("Đăng Nhập");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        this.setLayout(null);
        JPanel form = new JPanel();
        form.setBackground(Color.white);
        form.setBounds(370, 85, 500, 500);
        form.setLayout(null);
        
        JLabel title = new JLabel();
        title.setText("ĐĂNG NHẬP");
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setBounds(155, 80, 350, 50);
        title.setForeground(Color.BLACK);

        JLabel username = new JLabel();
        username.setText("Tài khoản:");
        username.setFont(new Font(null, Font.PLAIN, 20));
        username.setBounds(65, 160, 350, 50);
        username.setForeground(Color.BLACK);

        JLabel password = new JLabel();
        password.setText("Mật khẩu:");
        password.setFont(new Font(null, Font.PLAIN, 20));
        password.setBounds(70, 220, 350, 50);
        password.setForeground(Color.BLACK);

        JTextField user_field = new JTextField();
        user_field.setFont(new Font(null, Font.PLAIN, 20));
        user_field.setBounds(170, 172, 230, 30);
        user_field.setForeground(Color.BLACK);

        JPasswordField pass_field = new JPasswordField();
        pass_field.setFont(new Font(null, Font.PLAIN, 20));
        pass_field.setBounds(170, 232, 230, 30);
        pass_field.setForeground(Color.BLACK);

        JButton login = new JButton();
        login.setText("Đăng Nhập");
        login.setFont(new Font(null, Font.PLAIN, 18));
        login.setBounds(170, 300, 150, 30);
        login.setForeground(Color.BLACK);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = user_field.getText();
                String password = String.valueOf(pass_field.getPassword());
                employeeArr employ = new employeeArr();
                employ.readFile();
                Boolean flag = false;
                for(employee nv : employ.getArr()) {
                    if(username.equals(nv.getUsername()) && password.equals(nv.getPassword())) {
                        flag = true;
                        JOptionPane.showMessageDialog(null, 
                        "Đăng nhập thành công!");
                        new employGUI(nv);
                        dispose();
                    }
                }
                if(!flag) {
                    JOptionPane.showMessageDialog(null, 
                    "Tài khoản hoặc mật khẩu không chính xác. Vui lòng nhập lại!");
                    user_field.requestFocus(true);
                }
                pass_field.setText("");
            }
        });

        JButton signup = new JButton();
        signup.setText("Chưa có tài khoản? Đăng ký ngay!");
        signup.setFont(new Font(null, Font.PLAIN, 14));
        signup.setBounds(100, 400, 300, 20);
        signup.setForeground(Color.blue);
        signup.setBorderPainted(false);
        signup.setBackground(Color.white);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lien ket toi sign up page
                new signup();
                dispose();
            }
        });
        
        form.add(title);
        form.add(username);
        form.add(password);
        form.add(user_field);
        form.add(pass_field);
        form.add(login);
        form.add(signup);

        this.add(form);
        this.setVisible(true);
    }
}
