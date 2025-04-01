package customer;

// import customer.customer;
// import customer.customerGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.tree.TreeNode;

// import cart.cartGUI;
// import cart.thanhtoanGUI;

public class trangCaNhan extends JFrame {
    private JPanel header, tail, body;
    private JLabel title;
    private JButton back;
    private customerGUI khach;
    private customer khachCurrent;

    // private String ten; // Thêm biến để lưu tên khách hàng

    // Màu sắc tùy chỉnh
    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xam = new Color(207, 207, 207);

    // public trangCaNhan(customerGUI khach, customer khachCurrent) {

    public trangCaNhan() {
        // this.khach = khach;
        // this.khachCurrent = khachCurrent;

        // customer khachDangNhap = getKhachHangDangNhap();

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

    // public customer getKhachHangDangNhap() {
    // return this.khachCurrent;
    // }

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
        tab1.setBackground(hong);
        tab1.setLayout(new BorderLayout());

        JPanel tab1_left = new JPanel();
        tab1_left.setPreferredSize(new Dimension(300, 0));
        tab1_left.setLayout(new FlowLayout());
        tab1_left.setBackground(vang);
        tab1.add(tab1_left, BorderLayout.WEST);

        JPanel tab2 = new JPanel();

        // Thêm các tab vào JTabbedPane
        tb.addTab("Thông tin cá nhân", tab1);
        tb.addTab("Xem đơn hàng", tab2);
        body.add(tb, BorderLayout.CENTER);
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

    public static void main(String[] args) {
        new trangCaNhan();
    }
}
