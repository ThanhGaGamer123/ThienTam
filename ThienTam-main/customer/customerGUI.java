package customer;

import cart.cartGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import login.signup.login;
import products.product;
import products.productsArr;

public class customerGUI extends JFrame implements MouseListener, ActionListener {

    JLabel title, hotline, sdt, price, nameuser, logo1;
    JPanel p1, p2, p0, p3, cartPanel, logo, top_panel, bot_panel;
    JTextField timkiem;
    JScrollPane scr;
    JButton search, cart, logout;
    JComboBox cb1, cb2, cb3, cb4;

    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);
    private customer khachhang;
    private productsArr sanpham;

    public customerGUI(customer kh) {

        this.khachhang = kh;
        this.sanpham = new productsArr(); // Khởi tạo
        sanpham.readFile(); // Đọc dữ liệu
        create();
    }

    public void create() {
        setTitle("Customer");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p0.setLayout(new BorderLayout());
        p0.setPreferredSize(new Dimension(1280, 1500)); // Kích thước lớn hơn cửa sổ chính để thử nghiệm thanh cuộn

        top_panel = new JPanel();
        top_panel.setBackground(xanhla);
        top_panel.setPreferredSize(new Dimension(0, 230));

        top_panel.setLayout(new BorderLayout());
        p0.add(top_panel, BorderLayout.NORTH);

        createPanel_1();
        createPanel_2();
        createPanel_3();
        bot_panel = new JPanel();
        bot_panel.setBackground(vang);
        bot_panel.setLayout(new BorderLayout());
        bot_panel.setPreferredSize(new Dimension(0, 50));
        p0.add(bot_panel, BorderLayout.SOUTH);
        create_footer();
        // Đặt p0 vào JScrollPane
        scr = new JScrollPane(p0);
        scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scr.getVerticalScrollBar().setUnitIncrement(16);

        // *** Thêm JScrollPane vào JFrame ***
        getContentPane().add(scr);

        setVisible(true);
    }

    public void createPanel_1() {
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setPreferredSize(new Dimension(1280, 90)); // Đặt chiều rộng bằng với frame
        p1.setBackground(hong);
        top_panel.add(p1, BorderLayout.NORTH);

        JPanel p1_center = new JPanel();
        p1_center.setLayout(null);
        p1_center.setBackground(xanhla);
        p1.add(p1_center, BorderLayout.CENTER);

        title = new JLabel("NHÀ THUỐC THIỆN TÂM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));

        int titleWidth = 500;
        int titleHeight = 40;
        int x = (1280 - titleWidth) / 2;
        int y = (90 - titleHeight) / 2;
        title.setBounds(x, y, titleWidth, titleHeight);
        p1_center.add(title);

        JPanel p1_right = new JPanel();
        p1_right.setLayout(null);
        p1_right.setPreferredSize(new Dimension(350, 90)); // Kích thước panel
        p1_right.setBackground(xanhla);
        p1.add(p1_right, BorderLayout.EAST);

        customerArr khach = new customerArr();
        khach.readFile();

        // Hiển thị tên người dùng
        nameuser = new JLabel("Xin chào, " + khachhang.getTenkh());
        nameuser.setForeground(Color.WHITE);
        nameuser.setFont(new Font("Arial", Font.BOLD, 18));
        nameuser.setHorizontalAlignment(SwingConstants.RIGHT);
        nameuser.setBounds(0, 15, 250, 48); // Điều chỉnh chiều rộng để không tràn ra ngoài
        p1_right.add(nameuser);

        // Nút đăng xuất
        ImageIcon icon_logout = new ImageIcon(getClass().getResource("/customer/img_xt/icons8-log-out-48.png"));
        Image img = icon_logout.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        logout = new JButton(scaledIcon);
        logout.setBounds(250, 20, 48, 48);
        logout.setBackground(xanhla);
        logout.setBorder(null);
        logout.setFocusPainted(false);
        p1_right.add(logout);
        logout.addActionListener(new ActionListener() {
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

    }

    public void createPanel_2() {
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(1280, 80));
        p2.setBackground(xanhla);
        p2.setLayout(null);
        top_panel.add(p2, BorderLayout.CENTER);

        timkiem = new JTextField("Nhập tên sản phẩm thuốc ...");
        timkiem.setFont(new Font("Arial", Font.ITALIC, 14));
        timkiem.setBounds(88, 20, 610, 40);
        timkiem.addMouseListener(this);
        p2.add(timkiem);

        timkiem.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (timkiem.getText().equals("Nhập tên sản phẩm thuốc ...")) {
                    timkiem.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (timkiem.getText().isEmpty()) {
                    timkiem.setText("Nhập tên sản phẩm thuốc ...");
                }
            }

        });

        search = new JButton("TÌM KIẾM");
        search.setBounds(750, 20, 100, 40);
        search.setForeground(Color.white);
        search.setBackground(hong);
        search.setFocusPainted(false);
        p2.add(search);
        search.addMouseListener(this);

        cart = new JButton("GIỎ HÀNG");
        cart.setBounds(900, 20, 100, 40);
        cart.setForeground(Color.white);
        cart.setBackground(hong);
        cart.addActionListener(this);
        cart.setFocusPainted(false);
        p2.add(cart);

        hotline = new JLabel("Hotline (8:00 - 21:30)");
        hotline.setBounds(1080, 20, 150, 14);
        hotline.setFont(new Font("Arial", Font.BOLD, 14));
        hotline.setForeground(Color.black);
        p2.add(hotline);

        sdt = new JLabel("1900 1572");
        sdt.setBounds(1080, 40, 150, 16);
        sdt.setHorizontalAlignment(SwingConstants.CENTER);
        sdt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        sdt.setForeground(vang);
        p2.add(sdt);
    }

    public void createPanel_3() {
        p3 = new JPanel();
        p3.setBounds(0, 100, 1280, 60);
        p3.setBackground(xanhla);

        // Sử dụng FlowLayout căn giữa để các phần tử được căn chỉnh đẹp hơn
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        String[] cb1_item = { "              Đối tượng sử dụng", "Trẻ em", "Người lớn", "Người cao tuổi",
                "Phụ nữ có thai", "Phụ nữ cho con bú", "Người bị loét dạ dày" };
        cb1 = new JComboBox<>(cb1_item);
        cb1.setPreferredSize(new Dimension(220, 30));
        p3.add(cb1);

        String[] cb2_item = { "                          Chỉ định", "Mất ngủ", "Rối loạn tiêu hóa",
                "Suy giảm hệ miễn dịch",
                "Táo bón", "Biếng ăn", "Suy giảm trí nhớ", "Bệnh tim mạch", "Mệt mỏi", "Đau đầu", "Ho có đàm" };
        cb2 = new JComboBox<>(cb2_item);
        cb2.setPreferredSize(new Dimension(220, 30));
        p3.add(cb2);

        String[] cb3_item = { "            Xuất xứ thương hiệu", "Anh", "Pháp", "Mỹ", "Úc", "Việt Nam", "Hà Lan" };
        cb3 = new JComboBox<>(cb3_item);
        cb3.setPreferredSize(new Dimension(220, 30));
        p3.add(cb3);

        // Tạo JPanel để chứa "Lọc" và cb4, giúp giữ bố cục hợp lý
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        filterPanel.setBackground(xanhla);

        price = new JLabel("Lọc:");
        price.setFont(new Font("Arial", Font.PLAIN, 18));
        price.setForeground(Color.BLACK);
        filterPanel.add(price);

        String[] cb4_item = { "              Giá từ thấp đến cao", "              Giá từ cao đến thấp" };
        cb4 = new JComboBox<>(cb4_item);
        cb4.setPreferredSize(new Dimension(220, 30));
        filterPanel.add(cb4);

        p3.add(filterPanel);

        // Thêm p3 vào top_panel ngay dưới p2
        top_panel.add(p3, BorderLayout.SOUTH);
    }

    private void create_footer() {
        JPanel tail = new JPanel(new GridBagLayout());
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
        bot_panel.add(tail, BorderLayout.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == search) {
            String temp = timkiem.getText();
            ArrayList<product> foundProducts = sanpham.findName(temp); // Tìm tất cả sản phẩm chứa từ khóa

            if (foundProducts.isEmpty()) {
                System.out.println("Không tìm thấy sản phẩm nào chứa: " + temp);
            } else {
                System.out.println("Danh sách sản phẩm chứa: " + temp);
                for (product p : foundProducts) {
                    System.out.println("Mã thuốc: " + p.getMathuoc());
                    System.out.println("Tên thuốc: " + p.getTenthuoc());
                    System.out.println("Giá bán: " + p.getGiaban());
                    System.out.println("Xuất xứ: " + p.getXuatxu());
                    System.out.println("----------------------------------");
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cart) {
            new cartGUI(this, khachhang.getTenkh());
        }
    }

}