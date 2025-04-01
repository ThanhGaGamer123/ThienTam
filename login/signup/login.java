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
        this.setResizable(true);
        
        this.setTitle("Đăng Nhập");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
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
        // form.setBounds(370, 85, 500, 500);
        form.setLayout(new GridBagLayout());
        this.add(form, BorderLayout.CENTER);
        
        GridBagConstraints gdc = new GridBagConstraints();

        JLabel title = new JLabel();
        title.setText("ĐĂNG NHẬP");
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        // title.setBounds(155, 80, 350, 50);gdc.gridx = 0;
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 2;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 50, 40, 50);
        form.add(title, gdc);

        // reset
        gdc.gridwidth = 1;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        JLabel username = new JLabel();
        username.setText("Tài khoản:");
        username.setFont(new Font(null, Font.PLAIN, 20));
        username.setForeground(Color.BLACK);
        // username.setBounds(65, 160, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.insets = new Insets(0, 50, 20, 5);
        form.add(username, gdc);
        
        JTextField user_field = new JTextField();
        user_field.setFont(new Font(null, Font.PLAIN, 20));
        user_field.setForeground(Color.BLACK);
        // user_field.setBounds(170, 172, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 20, 50);
        form.add(user_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        JLabel password = new JLabel();
        password.setText("Mật khẩu:");
        password.setFont(new Font(null, Font.PLAIN, 20));
        password.setForeground(Color.BLACK);
        // password.setBounds(70, 220, 350, 50);
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.insets = new Insets(0, 50, 40, 5);
        form.add(password, gdc);

        JPasswordField pass_field = new JPasswordField();
        pass_field.setFont(new Font(null, Font.PLAIN, 20));
        pass_field.setForeground(Color.BLACK);
        // pass_field.setBounds(170, 232, 230, 30);
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 5, 40, 50);
        form.add(pass_field, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;

        JButton login = new JButton();
        login.setText("Đăng Nhập");
        login.setFont(new Font(null, Font.PLAIN, 18));
        login.setForeground(Color.BLACK);
        login.setBackground(new Color(76, 175, 80));
        // login.setBounds(170, 300, 150, 50);
        login.setPreferredSize(new Dimension(0, 50));
        gdc.gridx = 0;
        gdc.gridy = 3;
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
                String username = user_field.getText();
                String password = String.valueOf(pass_field.getPassword());
                employeeArr employ = new employeeArr();
                // employ.readFile();
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
        signup.setForeground(Color.blue);
        signup.setBorderPainted(false);
        signup.setBackground(Color.white);
        // signup.setBounds(100, 400, 300, 20);
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 2;
        gdc.insets = new Insets(0, 50, 50, 50);
        form.add(signup, gdc);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lien ket toi sign up page
                new signup();
                dispose();
            }
        });

        this.setVisible(true);
    }
}
