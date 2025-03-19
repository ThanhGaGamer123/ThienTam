package login.signup;

//them vào
import customer.customer;
import customer.customerArr;
import customer.customerGUI;
import employee.employGUI;
import employee.employee;
import employee.employeeArr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login extends JFrame {
    public login() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        this.setTitle("Đăng Nhập");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(0, 153, 102));

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
        login.setBounds(170, 300, 150, 50);
        login.setForeground(Color.BLACK);
        login.setBackground(new Color(76, 175, 80));
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
                employ.readFile();
                Boolean flag = false;
                System.out.println("Username nhập: " + username);
                System.out.println("Password nhập: " + password);
                for (employee nv : employ.getArr()) {
                    if (username.equals(nv.getUsername()) &&
                            password.equals(nv.getPassword())) {
                        flag = true;
                        JOptionPane.showMessageDialog(null,
                                "Đăng nhập thành công!");
                        new employGUI(nv);
                        dispose();
                    }
                }

                // start fix
                customerArr khach = new customerArr();
                khach.readFile();
                // System.out.println("Danh sách khách hàng: " + employ.getArr().size());

                khach.printCustomers();

                for (customer kh : khach.getA()) {
                    if (username.equals(kh.getUserkh()) && password.equals(kh.getPassword())) {
                        flag = true;
                        JOptionPane.showMessageDialog(null,
                                "Đăng nhập thành công với tư cách khách hàng!");
                        new customerGUI(kh);
                        dispose();

                    }
                }
                // end

                if (!flag) {
                    JOptionPane.showMessageDialog(null,
                            "Tài khoản hoặc mật khẩu không chính xác. Vui lòng nhập lại!");
                    user_field.requestFocus(true);
                }
                pass_field.setText("");
            }
        });

        /*
         * // Kiểm tra đăng nhập cho khách hàng
         * for (customer kh : customer.getA()) {
         * if (username.equals(kh.getUserkh()) && password.equals(kh.getPassword())) {
         * isAuthenticated = true;
         * JOptionPane.showMessageDialog(null,
         * "Đăng nhập thành công với tư cách khách hàng!");
         * new customerGUI(kh);
         * dispose();
         * return; // Thoát khi đã đăng nhập thành công
         * }
         * }
         */
        // Nếu không tìm thấy tài khoản

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
                // lien ket toi sign up page
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
