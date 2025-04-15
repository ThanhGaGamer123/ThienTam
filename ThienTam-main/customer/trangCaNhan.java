package customer;

import customer.customer;
import customer.customerGUI;
import login.signup.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// import cart.cartGUI;
// import cart.thanhtoanGUI;

public class trangCaNhan extends JFrame {
    private JPanel header, tail, body, tab1_left, tab1_right, tab1_center, tab1_tren, tab1_duoi;
    private JLabel title;
    private JButton back;
    private customerGUI khach;
    private customer khachCurrent;
    private JFrame f;
    private float chieurong;

    // private String ten; // Thêm biến để lưu tên khách hàng

    // Màu sắc tùy chỉnh
    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color xam = new Color(207, 207, 207);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xamnhat = new Color(237, 240, 243);
    private static final Color dodo = new Color(232, 58, 72);

    // public trangCaNhan(customerGUI khach, customer khachCurrent) {

    public trangCaNhan(customerGUI khach, customer khachCurrent) {
        this.khach = khach;
        this.khachCurrent = khachCurrent;

        customer khachDangNhap = getKhachHangDangNhap();

        setTitle("Cá nhân");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        chieurong = getWidth();
        create_header();
        create_body();
        create_footer();

        setVisible(true);
    }

    public customer getKhachHangDangNhap() {
        return this.khachCurrent;
    }

    private void create_header() {
        header = new JPanel();
        header.setBackground(xanhla);
        header.setPreferredSize(new Dimension(0, 100));
        header.setLayout(null);

        title = new JLabel("THÔNG TIN CÁ NHÂN");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(500, 30, 300, 40);
        header.add(title);

        ImageIcon icon_back = new ImageIcon("D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\back.png");
        Image img = icon_back.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon back_btn = new ImageIcon(img);

        back = new JButton(back_btn);
        back.setFont(new Font("Arial", Font.BOLD, 12));
        back.setBounds(10, 10, 100, 20);
        back.setForeground(Color.white);
        back.setBackground(hong);
        back.setFocusPainted(false);
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
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER); // Thêm vào frame

        // ========= Body =========
        body = new JPanel();
        body.setBackground(xam);
        body.setPreferredSize(new Dimension(400, 400));
        body.setLayout(new BorderLayout());
        mainPanel.add(body, BorderLayout.CENTER);

        JTabbedPane tb = new JTabbedPane();
        tb.setPreferredSize(new Dimension(400, 400));

        JPanel tab1 = new JPanel();
        tab1.setBackground(xamnhat);
        tab1.setLayout(new BorderLayout());

        tab1_left = new JPanel();
        tab1_left.setPreferredSize(new Dimension(300, 0));
        tab1_left.setLayout(new GridBagLayout());
        tab1_left.setBackground(xamnhat);
        tab1.add(tab1_left, BorderLayout.WEST);

        tab1_right = new JPanel();
        tab1_right.setPreferredSize(new Dimension((int) (chieurong - 300), 0));
        tab1_right.setLayout(new GridBagLayout());
        tab1_right.setBackground(linen);
        tab1.add(tab1_right, BorderLayout.EAST);

        tab1_center = new JPanel();
        tab1_center.setPreferredSize(new Dimension(0, 0));
        tab1_center.setLayout(new GridBagLayout());
        tab1_center.setBackground(xam);
        tab1.add(tab1_center, BorderLayout.CENTER);

        tab1_tren = new JPanel();
        tab1_tren.setPreferredSize(new Dimension(0, 0));
        tab1_tren.setLayout(new GridBagLayout());
        tab1_tren.setBackground(xam);
        tab1.add(tab1_tren, BorderLayout.NORTH);

        tab1_duoi = new JPanel();
        tab1_duoi.setPreferredSize(new Dimension(0, 0));
        tab1_duoi.setLayout(new GridBagLayout());
        tab1_duoi.setBackground(xam);
        tab1.add(tab1_duoi, BorderLayout.SOUTH);

        create_tab1();
        JPanel tab2 = new JPanel();

        // Thêm các tab vào JTabbedPane
        tb.addTab("Thông tin cá nhân", tab1);
        tb.addTab("Xem đơn hàng", tab2);
        body.add(tb, BorderLayout.CENTER);
    }

    public void create_tab1() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel tieudekh = new JLabel("THÔNG TIN KHÁCH HÀNG");
        tieudekh.setForeground(dodo);
        tieudekh.setFont(new Font("Bookman", Font.PLAIN, 22));
        gbc.gridy = 0;
        tab1_left.add(tieudekh, gbc);

        JButton ttnd = new JButton("Thông tin");
        ttnd.setBackground(xanhla);
        ttnd.setPreferredSize(new Dimension(220, 50));
        ttnd.setFont(new Font("Bookman", Font.PLAIN, 20));
        ttnd.setForeground(Color.WHITE);
        gbc.gridy = 1;
        tab1_left.add(ttnd, gbc);

        JButton logout_btn = new JButton("Đăng xuất");
        logout_btn.setForeground(Color.WHITE);
        logout_btn.setPreferredSize(new Dimension(220, 50));
        logout_btn.setFont(new Font("Bookman", Font.PLAIN, 20));
        logout_btn.setBackground(xanhla);
        gbc.gridy = 2;
        tab1_left.add(logout_btn, gbc);

        logout_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn đăng xuất không?");
                if (choice == 0) {
                    new login();
                    dispose();
                }
            }
        });

        // Nhập thông tin khách hàng
        GridBagConstraints gbcc = new GridBagConstraints();
        gbcc.insets = new Insets(0, 0, 20, 0);
        gbcc.gridx = 0;
        gbcc.anchor = GridBagConstraints.CENTER;
        gbcc.fill = GridBagConstraints.HORIZONTAL; // Để các dòng chiếm hết chiều ngang

        // Dòng 1
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line1.setBackground(linen);
        JLabel name = new JLabel("Tên người dùng:");
        name.setPreferredSize(new Dimension(120, 30));
        String namekh = khachCurrent.getTenkh();
        JTextField fillName = new JTextField(namekh);
        fillName.setPreferredSize(new Dimension(300, 30));
        fillName.setFont(new Font("Arial", Font.PLAIN, 18));
        line1.add(name);
        line1.add(fillName);
        gbcc.gridy = 0;
        tab1_right.add(line1, gbcc);

        // Dòng 2
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line2.setBackground(linen);
        JLabel sdtkh = new JLabel("SĐT người dùng:");
        sdtkh.setPreferredSize(new Dimension(120, 30));
        int sdtkhachdangsd = khachCurrent.getSdt();
        JTextField fillsdtkh = new JTextField(String.valueOf(sdtkhachdangsd));
        fillsdtkh.setPreferredSize(new Dimension(300, 30));
        fillsdtkh.setFont(new Font("Arial", Font.PLAIN, 18));
        line2.add(sdtkh);
        line2.add(fillsdtkh);
        gbcc.gridy = 1;
        tab1_right.add(line2, gbcc);

        // Dòng 3
        JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line3.setBackground(linen);
        JLabel email = new JLabel("Email người dùng:");
        email.setPreferredSize(new Dimension(120, 30));
        String email_khach = khachCurrent.getEmail();
        JTextField fillemail = new JTextField(email_khach);
        fillemail.setPreferredSize(new Dimension(300, 30));
        fillemail.setFont(new Font("Arial", Font.PLAIN, 18));
        line3.add(email);
        line3.add(fillemail);
        gbcc.gridy = 2;
        tab1_right.add(line3, gbcc);

        JPanel line4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line4.setBackground(linen);
        JLabel passwordLB = new JLabel("Nhập mật khẩu cũ:");
        passwordLB.setPreferredSize(new Dimension(120, 30));
        JPasswordField pwfield = new JPasswordField();
        pwfield.setPreferredSize(new Dimension(300, 30));

        line4.add(passwordLB);
        line4.add(pwfield);

        gbcc.gridy = 3;
        tab1_right.add(line4, gbcc);

        JPanel line5 = new JPanel();
        line5.setBackground(linen);
        JLabel newpasswordLB = new JLabel("Nhập mật khẩu mới:");
        newpasswordLB.setPreferredSize(new Dimension(120, 30));
        JTextField newpwfield = new JTextField();
        newpwfield.setPreferredSize(new Dimension(200, 30));
        JLabel cfnewpasswordLB = new JLabel("Xác nhận mật khẩu mới:");
        JTextField cfnewpwfield = new JTextField();
        cfnewpwfield.setPreferredSize(new Dimension(200, 30));
        line5.add(newpasswordLB);
        line5.add(newpwfield);
        line5.add(cfnewpasswordLB);
        line5.add(cfnewpwfield);
        gbcc.gridy = 4;
        tab1_right.add(line5, gbcc);

        // Dòng 6
        JPanel line6 = new JPanel();
        line6.setBackground(linen);
        JButton edit_in4 = new JButton("Cập nhật thông tin");
        edit_in4.setPreferredSize(new Dimension(320, 50));
        edit_in4.setBackground(xanhla);
        edit_in4.setFont(new Font("Bookman", Font.PLAIN, 20));
        edit_in4.setForeground(Color.white);
        line6.add(edit_in4);
        gbcc.gridy = 5;
        tab1_right.add(line6, gbcc);
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
