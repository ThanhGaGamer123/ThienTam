package customer;

import cart.cartArr;
import cart.cartGUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import javax.swing.*;
import login.signup.login;
import medicine.medicine;
import medicine.medicineArr;

public class customerGUI extends JFrame implements MouseListener, ActionListener {

    JLabel title, hotline, sdt, price, nameuser;
    JPanel p1, p2, p0, p3, cartPanel, logo, top_panel, bot_panel, mid_panel;
    JTextField timkiem;
    JScrollPane scr;
    JButton search, cart, logout, user;
    JComboBox cb1, cb2, cb3, cb4;

    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color xam = new Color(207, 207, 207);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xamnhat = new Color(237, 240, 243);
    private static final Color dodo = new Color(232, 58, 72);

    private static int totalHeight;

    private customer khachhang;
    private medicineArr sanpham;
    private customer khachCurrent;
    private cartArr giohang;

    public customerGUI(customer kh) {

        this.khachhang = kh;
        this.khachCurrent = kh;
        this.sanpham = new medicineArr();

        this.giohang = new cartArr();
        giohang.readCartDatabase(giohang.getA(), khachCurrent.getMakh());

        sanpham.readDatabase();
        ArrayList<medicine> ds = sanpham.getSp();
        create(ds);
    }

    public customer getKhachHangDangNhap() {
        if (khachCurrent == null) {
            System.out.println("Lỗi: khachCurrent đang null!");
        } else {
            System.out.println("Thông tin khách hàng đang đăng nhập: " + khachCurrent);
        }
        return this.khachCurrent;
    }

    public void create(ArrayList<medicine> foundProductsFilter) {
        setTitle("Customer");
        setSize(1280, 720);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p0.setLayout(new BorderLayout());

        int productCount = foundProductsFilter.size();
        int rows = (int) Math.ceil(productCount / 4.0); // 4sp 1 dòng //*********** */
        int productHeight = 320; // Chiều cao mỗi ô sản phẩm
        totalHeight = 300 + rows * productHeight + 100; // Tổng chiều cao p0

        p0.setPreferredSize(new Dimension(1280, totalHeight));
        p0.revalidate(); // set lai height cho p0
        p0.repaint();

        top_panel = new JPanel();
        top_panel.setBackground(xanhla);
        top_panel.setPreferredSize(new Dimension(0, 230));
        top_panel.setLayout(new BorderLayout());
        p0.add(top_panel, BorderLayout.NORTH);

        mid_panel = new JPanel();
        mid_panel.setLayout(new GridLayout(0, 4, 20, 20));
        mid_panel.setBackground(xamnhat);

        p0.add(mid_panel, BorderLayout.CENTER);

        createPanel_1();
        createPanel_2();
        createPanel_3();
        ArrayList<medicine> ds = sanpham.getSp();
        createProductGrid(ds);

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
        scr.getVerticalScrollBar().setUnitIncrement(20);

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
        khach.readDatabase();

        // Hiển thị tên người dùng
        nameuser = new JLabel("Xin chào, " + khachhang.getTenkh());
        nameuser.setForeground(Color.WHITE);
        nameuser.setFont(new Font("Bookman", Font.PLAIN, 17));
        nameuser.setHorizontalAlignment(SwingConstants.RIGHT);
        nameuser.setBounds(0, 20, 250, 48); // Điều chỉnh chiều rộng để không tràn ra ngoài
        p1_right.add(nameuser);

        // Nút đăng xuất
        ImageIcon icon_logout = new ImageIcon(getClass().getResource("/customer/img_xt/icons8-log-out-40.png"));
        Image img = icon_logout.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        logout = new JButton(scaledIcon);
        logout.setBounds(260, 20, 40, 40);
        logout.setBackground(xanhla);
        logout.setBorder(null);
        logout.setFocusPainted(false);
        p1_right.add(logout);

        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            }
        });

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
        timkiem.setFont(new Font("Bookman", Font.ITALIC, 18));
        timkiem.setBounds(80, 20, 610, 40);
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

        ImageIcon icon_search = new ImageIcon(
                "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-search-40.png");
        Image img = icon_search.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon search_btn = new ImageIcon(img);

        search = new JButton(search_btn);
        search.setBounds(720, 20, 80, 40);
        search.setForeground(Color.white);
        search.setBackground(hong);
        search.setFocusPainted(false);
        p2.add(search);
        search.addMouseListener(this);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                search.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            }
        });

        ImageIcon icon_cart = new ImageIcon(
                "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-shopping-cart-40.png");
        Image img_cart = icon_cart.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon cart_btn = new ImageIcon(img_cart);

        cart = new JButton(cart_btn);
        cart.setBounds(830, 20, 80, 40);
        cart.setForeground(Color.white);
        cart.setBackground(hong);
        cart.addActionListener(this);
        cart.setFocusPainted(false);
        p2.add(cart);

        cart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cart.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            }
        });

        ImageIcon icon_user = new ImageIcon(
                "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-user-40.png");
        Image img_user = icon_user.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon user_btn = new ImageIcon(img_user);

        user = new JButton(user_btn);
        user.setBounds(940, 20, 80, 40);
        user.setForeground(Color.white);
        user.setBackground(hong);
        user.addActionListener(this);
        user.setFocusPainted(false);
        p2.add(user);

        user.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                user.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
            }

            @Override
            public void mouseExited(MouseEvent e) {
                user.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            }
        });

        hotline = new JLabel("Hotline (8:00 - 21:30)");
        hotline.setBounds(1080, 20, 150, 14);
        hotline.setFont(new Font("Bookman", Font.BOLD, 14));
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

        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        String[] cb1_item = { "              Đối tượng sử dụng", "Mọi lứa tuổi", "Trẻ em", "Người lớn",
                "Người cao tuổi",
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

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        filterPanel.setBackground(xanhla);

        price = new JLabel("Lọc:");
        price.setFont(new Font("Bookman", Font.PLAIN, 18));
        price.setForeground(Color.BLACK);
        filterPanel.add(price);

        String[] cb4_item = { "                        Giá bán", "              Giá từ thấp đến cao",
                "              Giá từ cao đến thấp" };
        cb4 = new JComboBox<>(cb4_item);
        cb4.setPreferredSize(new Dimension(220, 30));
        filterPanel.add(cb4);

        p3.add(filterPanel);

        top_panel.add(p3, BorderLayout.SOUTH);
    }

    private void themVaoGioHang(medicine thuoc) {
        String makh = khachCurrent.getMakh();
        String magio = "GH_" + makh;
        int sl = 1;
        int dongia = thuoc.getGiaban().get(0);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Thientam;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";

            try (Connection con = DriverManager.getConnection(url, username, password)) {

                String checkSql = "SELECT SoLuong FROM GioHang WHERE MaKH = ? AND MaThuoc = ?";
                PreparedStatement checkStmt = con.prepareStatement(checkSql);
                checkStmt.setString(1, makh);
                checkStmt.setString(2, thuoc.getMathuoc());
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {

                    int currentSL = rs.getInt("SoLuong");
                    int newSL = currentSL + sl;
                    int newThanhTien = newSL * dongia;

                    String updateSql = "UPDATE GioHang SET SoLuong = ?, ThanhTien = ? WHERE MaKH = ? AND MaThuoc = ?";
                    PreparedStatement updateStmt = con.prepareStatement(updateSql);
                    updateStmt.setInt(1, newSL);
                    updateStmt.setInt(2, newThanhTien);
                    updateStmt.setString(3, makh);
                    updateStmt.setString(4, thuoc.getMathuoc());
                    updateStmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Đã thêm vào giỏ hàng!");
                } else {

                    int thanhtien = sl * dongia;
                    String insertSql = "INSERT INTO GioHang (MaKH, MaThuoc, SoLuong, ThanhTien, DonGia) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = con.prepareStatement(insertSql);
                    insertStmt.setString(1, makh); // Sử dụng MaKH
                    insertStmt.setString(2, thuoc.getMathuoc());
                    insertStmt.setInt(3, sl);
                    insertStmt.setInt(4, thanhtien);
                    insertStmt.setInt(5, dongia);

                    insertStmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Đã thêm vào giỏ hàng!");
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm vào giỏ hàng.");
        }
    }

    public void createProductGrid(ArrayList<medicine> foundProductsFilter) {
        ArrayList<medicine> productArr = foundProductsFilter;

        mid_panel.removeAll();
        mid_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        int productCount = productArr.size();

        for (int i = 0; i < productCount; i++) {

            JPanel productPanel = new JPanel();
            productPanel.setLayout(new BorderLayout());
            productPanel.setPreferredSize(new Dimension(250, 300));
            productPanel.setBorder(BorderFactory.createLineBorder(xanhla, 1));

            // center ô san pham
            JPanel chinhgiua = new JPanel();
            chinhgiua.setLayout(new BorderLayout());
            chinhgiua.setBackground(linen);
            productPanel.add(chinhgiua, BorderLayout.CENTER);

            JPanel main_center = new JPanel();
            main_center.setBackground(hong);
            main_center.setLayout(new BorderLayout());
            main_center.setPreferredSize(new Dimension(0, 0));
            main_center.setBorder(BorderFactory.createLineBorder(xanhla, 1));
            chinhgiua.add(main_center, BorderLayout.CENTER);

            JLabel test = new JLabel("" + (i + 1), SwingConstants.CENTER);
            test.setFont(new Font("Bookman", Font.PLAIN, 60));
            test.setForeground(xanhla);
            main_center.add(test, BorderLayout.CENTER);

            chinhgiua.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    chinhgiua.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
                    main_center.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    main_center.setBorder(BorderFactory.createLineBorder(hong, 2));

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    chinhgiua.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
                    main_center.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
                    main_center.setBorder(BorderFactory.createLineBorder(xanhla, 1));
                }
            });

            // TEN SAN PHAM------------------
            JPanel main_center_tensp = new JPanel();
            main_center_tensp.setBackground(linen);
            main_center_tensp.setPreferredSize(new Dimension(0, 30));
            main_center.add(main_center_tensp, BorderLayout.SOUTH);

            JLabel tensp = new JLabel(foundProductsFilter.get(i).getTenthuoc(), SwingConstants.CENTER);

            tensp.setFont(new Font("Bookman", Font.PLAIN | Font.ITALIC, 13));
            main_center_tensp.add(tensp, BorderLayout.CENTER);

            JPanel main_center_trai = new JPanel();
            main_center_trai.setBackground(linen);
            main_center_trai.setPreferredSize(new Dimension(0, 0));
            main_center_tensp.add(main_center_trai, BorderLayout.WEST);

            JPanel main_center_phai = new JPanel();
            main_center_phai.setBackground(linen);
            main_center_phai.setPreferredSize(new Dimension(0, 0));
            main_center_tensp.add(main_center_phai, BorderLayout.EAST);

            // ------------------------------

            // Hiển thị tên sản phẩm
            JPanel main_north = new JPanel();
            main_north.setBackground(xamnhat);
            main_north.setPreferredSize(new Dimension(0, 10));
            chinhgiua.add(main_north, BorderLayout.NORTH);

            JPanel main_east = new JPanel();
            main_east.setBackground(xamnhat);
            main_east.setPreferredSize(new Dimension(10, 0));
            chinhgiua.add(main_east, BorderLayout.EAST);

            JPanel main_west = new JPanel();
            main_west.setBackground(xamnhat);
            main_west.setPreferredSize(new Dimension(10, 0));
            chinhgiua.add(main_west, BorderLayout.WEST);

            JPanel main_south = new JPanel();
            main_south.setBackground(xamnhat);
            main_south.setPreferredSize(new Dimension(0, 25));
            chinhgiua.add(main_south, BorderLayout.SOUTH);

            // gia tien
            NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
            medicine product = foundProductsFilter.get(i);
            int price = product.getGiaban().get(0);
            String donvi = product.getDonvi().get(0);
            String formattedPrice = nf.format(price) + " / " + donvi;

            System.out.println(formattedPrice);
            JLabel price_sp = new JLabel(formattedPrice, SwingConstants.LEFT);
            price_sp.setFont(new Font("Bookman", Font.PLAIN | Font.BOLD, 17));
            price_sp.setForeground(dodo);
            main_south.add(price_sp);
            // nut mua hang
            JPanel buy_panel = new JPanel();
            buy_panel.setPreferredSize(new Dimension(0, 50));
            buy_panel.setBackground(xamnhat);
            productPanel.add(buy_panel, BorderLayout.SOUTH);

            JButton buy_btn = new JButton("Chọn mua");
            buy_btn.setFont(new Font("Bookman", Font.BOLD, 17));
            buy_btn.setForeground(Color.WHITE);
            buy_btn.setFocusPainted(false);
            buy_btn.setPreferredSize(new Dimension(170, 35));
            buy_btn.setBackground(xanhla);

            buy_panel.add(buy_btn);

            buy_btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    buy_btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    buy_btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
                }
            });

            // main_center.addMouseListener(new MouseAdapter() {
            // @Override
            // public void mouseEntered(MouseEvent e) {
            // main_center.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // main_center.setBorder(BorderFactory.createLineBorder(hong, 2));
            // }

            // @Override
            // public void mouseExited(MouseEvent e) {
            // main_center.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            // main_center.setBorder(BorderFactory.createLineBorder(xanhla, 1));
            // }
            // });

            final medicine thuoc = productArr.get(i);

            buy_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    themVaoGioHang(thuoc);
                }
            });

            // Thêm vào mid_panel
            mid_panel.add(productPanel);

            final int index = i;
            chinhgiua.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Tạo panel chi tiết
                    JPanel detailPanel = new JPanel(new BorderLayout());
                    detailPanel.setPreferredSize(new Dimension(900, 530));
                    detailPanel.setBackground(hong);
                    detailPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

                    // Tạo dialog
                    JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(mid_panel),
                            "Chi tiết sản phẩm", true);
                    dialog.setUndecorated(true);
                    dialog.getContentPane().add(detailPanel);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);

                    JPanel content_detail = new JPanel();
                    content_detail.setPreferredSize(new Dimension(900, 500));
                    content_detail.setBackground(linen);
                    content_detail.setLayout(new BorderLayout());
                    detailPanel.add(content_detail, BorderLayout.NORTH);

                    // change1
                    JPanel o_ben_phai_detail = new JPanel();
                    o_ben_phai_detail.setLayout(new BorderLayout());
                    content_detail.add(o_ben_phai_detail, BorderLayout.EAST);

                    // Panel chứa nút thoát (không đặt chiều cao cố định nữa)
                    JPanel o_chua_nut_thoat = new JPanel();
                    o_chua_nut_thoat.setLayout(new BorderLayout());
                    o_chua_nut_thoat.setBackground(xamnhat);
                    o_ben_phai_detail.add(o_chua_nut_thoat, BorderLayout.NORTH);

                    // Tạo nút "Thoát"
                    ImageIcon icon_exit = new ImageIcon(
                            "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-close-20.png");
                    Image img_exit = icon_exit.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    ImageIcon exit_btn = new ImageIcon(img_exit);
                    JButton close_btn = new JButton(exit_btn);
                    close_btn.setBackground(dodo);
                    close_btn.setFocusPainted(false);
                    close_btn.setPreferredSize(new Dimension(30, 30));
                    o_chua_nut_thoat.add(close_btn, BorderLayout.EAST);

                    // Panel chứa nội dung phía dưới và các panel khác
                    JPanel test_duoi = new JPanel();
                    test_duoi.setPreferredSize(new Dimension(400, 0));
                    o_ben_phai_detail.add(test_duoi, BorderLayout.SOUTH);

                    JPanel test_phai = new JPanel();
                    test_phai.setPreferredSize(new Dimension(0, 600));
                    o_ben_phai_detail.add(test_phai, BorderLayout.EAST);

                    JPanel test_trai = new JPanel();
                    test_trai.setPreferredSize(new Dimension(0, 500));
                    o_ben_phai_detail.add(test_trai, BorderLayout.EAST);

                    //

                    JPanel phai_content_pn = new JPanel();
                    phai_content_pn.setBackground(xamnhat);
                    phai_content_pn.setPreferredSize(new Dimension(400, 0));
                    // phai_content_pn.setBorder(new LineBorder(xam, 5));
                    phai_content_pn.setLayout(new GridBagLayout());
                    o_ben_phai_detail.add(phai_content_pn, BorderLayout.CENTER);

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(0, 0, 10, 0);
                    gbc.gridx = 0;
                    gbc.anchor = GridBagConstraints.WEST;

                    // Tên sản phẩm
                    JLabel tensp_detail = new JLabel(productArr.get(index).getTenthuoc(), SwingConstants.CENTER);
                    tensp_detail.setFont(new Font("Bookman", Font.BOLD, 19));
                    gbc.gridy = 1; // Dòng đầu tiên
                    phai_content_pn.add(tensp_detail, gbc);

                    // Giá sản phẩm
                    JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                    pricePanel.setBackground(xamnhat);
                    JLabel giaLB = new JLabel("Giá: ");
                    giaLB.setFont(new Font("Bookman", Font.BOLD, 17));
                    giaLB.setForeground(Color.BLACK);
                    pricePanel.add(giaLB);

                    // Định dạng giá
                    int price = productArr.get(index).getGiaban().get(0);
                    String formattedPrice = nf.format(price) + " / " + productArr.get(index).getDonvi().get(0);
                    JLabel price_detail = new JLabel(formattedPrice);
                    price_detail.setFont(new Font("Bookman", Font.PLAIN, 25));
                    price_detail.setForeground(dodo);
                    pricePanel.add(price_detail);

                    gbc.gridy = 2;
                    phai_content_pn.add(pricePanel, gbc);

                    // Thành phần
                    JPanel thanhphanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                    thanhphanPanel.setBackground(xamnhat);
                    JLabel thanhphanLB = new JLabel("Thành phần: ");
                    thanhphanLB.setFont(new Font("Bookman", Font.BOLD, 17));
                    thanhphanLB.setForeground(Color.BLACK);
                    thanhphanPanel.add(thanhphanLB);

                    // Thành phần chi tiết
                    JLabel thanhphan_detail = new JLabel(productArr.get(index).getThanhphan(), SwingConstants.LEFT);
                    thanhphan_detail.setFont(new Font("Bookman", Font.PLAIN, 17));
                    thanhphan_detail.setForeground(Color.BLACK);
                    thanhphanPanel.add(thanhphan_detail);

                    // Thêm panel thành phần vào phai_content_pn
                    gbc.gridy = 3;
                    phai_content_pn.add(thanhphanPanel, gbc);

                    // Thông tin sản phẩm
                    JLabel ttspLB = new JLabel("Mô tả sản phẩm: ");
                    ttspLB.setFont(new Font("Bookman", Font.BOLD, 17));
                    ttspLB.setForeground(Color.BLACK);
                    gbc.gridy = 4;
                    phai_content_pn.add(ttspLB, gbc);

                    // Thông tin sản phẩm chi tiết
                    JTextArea ttsp_detail = new JTextArea(productArr.get(index).getThongtin());
                    ttsp_detail.setFont(new Font("Bookman", Font.PLAIN, 17));
                    ttsp_detail.setForeground(Color.BLACK);
                    ttsp_detail.setLineWrap(true);
                    ttsp_detail.setWrapStyleWord(true);
                    ttsp_detail.setEditable(false);
                    ttsp_detail.setBackground(xamnhat);
                    ttsp_detail.setPreferredSize(new Dimension(380, 100));
                    ttsp_detail.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

                    gbc.gridy = 5;
                    phai_content_pn.add(ttsp_detail, gbc);

                    JPanel sanxuatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                    sanxuatPanel.setBackground(xamnhat);
                    JLabel sanxuatLB = new JLabel("Nước sản xuất: ");
                    sanxuatLB.setFont(new Font("Bookman", Font.BOLD, 17));
                    sanxuatLB.setForeground(Color.BLACK);
                    sanxuatPanel.add(sanxuatLB);

                    // Thành phần chi tiết
                    JLabel sanxuat_detail = new JLabel(productArr.get(index).getXuatxu(), SwingConstants.LEFT);
                    sanxuat_detail.setFont(new Font("Bookman", Font.PLAIN, 17));
                    sanxuat_detail.setForeground(Color.BLACK);
                    sanxuatPanel.add(sanxuat_detail);

                    gbc.gridy = 6;
                    phai_content_pn.add(sanxuatPanel, gbc);

                    // cach dung
                    JPanel cachdungPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                    cachdungPanel.setBackground(xamnhat);
                    JLabel cachdungLB = new JLabel("Cách dùng :");
                    cachdungLB.setFont(new Font("Bookman", Font.BOLD, 17));
                    cachdungLB.setForeground(Color.BLACK);
                    cachdungPanel.add(cachdungLB);

                    // Thành phần chi tiết
                    JLabel cachdung_detail = new JLabel("Xem trên bao bì");
                    cachdung_detail.setFont(new Font("Bookman", Font.PLAIN, 17));
                    cachdung_detail.setForeground(Color.BLACK);
                    cachdungPanel.add(cachdung_detail);
                    gbc.gridy = 7;
                    phai_content_pn.add(cachdungPanel, gbc);

                    // nut chon mua
                    JButton buy_btn_detail = new JButton("Chọn mua");
                    buy_btn_detail.setFont(new Font("Bookman", Font.BOLD, 17));
                    buy_btn_detail.setForeground(Color.WHITE);
                    buy_btn_detail.setFocusPainted(false);
                    buy_btn_detail.setPreferredSize(new Dimension(170, 35));
                    buy_btn_detail.setBackground(xanhla);
                    gbc.gridy = 8;
                    phai_content_pn.add(buy_btn_detail, gbc);

                    buy_btn_detail.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            buy_btn_detail.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            buy_btn_detail.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }
                    });

                    buy_btn_detail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            themVaoGioHang(thuoc);
                        }
                    });

                    // ------------------------
                    // label hinh anh
                    JPanel trai_content_pn = new JPanel();
                    trai_content_pn.setBackground(hong);
                    trai_content_pn.setPreferredSize(new Dimension(500, 0));
                    trai_content_pn.setLayout(new BorderLayout());
                    // trai_content_pn.setBorder(new LineBorder(xam, 5));
                    content_detail.add(trai_content_pn, BorderLayout.WEST);

                    JPanel img_medicine = new JPanel();
                    img_medicine.setBackground(linen);
                    trai_content_pn.add(img_medicine, BorderLayout.CENTER);

                    JPanel img_tren = new JPanel();
                    img_tren.setBackground(xamnhat);
                    img_tren.setPreferredSize(new Dimension(0, 80));
                    trai_content_pn.add(img_tren, BorderLayout.NORTH);
                    JPanel img_duoi = new JPanel();
                    img_duoi.setBackground(xamnhat);
                    img_duoi.setPreferredSize(new Dimension(0, 80));
                    trai_content_pn.add(img_duoi, BorderLayout.SOUTH);
                    JPanel img_phai = new JPanel();
                    img_phai.setBackground(xamnhat);
                    img_phai.setPreferredSize(new Dimension(30, 0));
                    trai_content_pn.add(img_phai, BorderLayout.EAST);
                    JPanel img_trai = new JPanel();
                    img_trai.setBackground(xamnhat);
                    img_trai.setPreferredSize(new Dimension(30, 0));
                    trai_content_pn.add(img_trai, BorderLayout.WEST);

                    // footer detail
                    JPanel footer_detail = new JPanel();
                    footer_detail.setPreferredSize(new Dimension(300, 30));
                    footer_detail.setBackground(xanhla);
                    detailPanel.add(footer_detail, BorderLayout.SOUTH);

                    JLabel detail_tail = new JLabel("nhathuocthientam@gmail.com.vn");
                    detail_tail.setFont(new Font("Bookman", Font.ITALIC, 13));
                    detail_tail.setForeground(Color.BLACK);

                    GridBagConstraints testgcc = new GridBagConstraints();
                    testgcc.gridx = 0;
                    testgcc.gridy = 0;
                    testgcc.insets = new Insets(2, 0, 0, 0);

                    footer_detail.add(detail_tail, testgcc);

                    close_btn.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            close_btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            close_btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
                        }
                    });

                    close_btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.dispose();
                        }
                    });

                    dialog.setVisible(true);
                }
            });

        }

        int rows = (int) Math.ceil(productCount / 4.0); // 4 sp mỗi dòng
        int productHeight = 320;
        int totalHeight = 300 + rows * productHeight + 50;

        p0.setPreferredSize(new Dimension(1280, totalHeight));
        p0.revalidate();
        p0.repaint();

        mid_panel.revalidate();
        mid_panel.repaint();
    }

    private void create_footer() {
        JPanel tail = new JPanel(new GridBagLayout());
        tail.setBackground(xanhla);
        tail.setPreferredSize(new Dimension(0, 80));

        JLabel detail_tail = new JLabel("nhathuocthientam@gmail.com.vn");
        detail_tail.setFont(new Font("Bookman", Font.ITALIC, 13));
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
            String temp = timkiem.getText().trim();
            String temp_dtsd = cb1.getSelectedItem().toString().trim();
            String temp_chidinh = cb2.getSelectedItem().toString().trim();
            String temp_xuatxu = cb3.getSelectedItem().toString().trim();

            ArrayList<medicine> foundProducts = temp.equals("Nhập tên sản phẩm thuốc ...") ? sanpham.getSp()
                    : sanpham.findName(temp);
            ArrayList<medicine> foundProductsFilter = new ArrayList<>();

            for (medicine p : foundProducts) {
                boolean hople = true;

                // Kiểm tra đối tượng sử dụng
                if (temp_dtsd != null && !temp_dtsd.isEmpty() && !temp_dtsd.equals("Đối tượng sử dụng")) {
                    boolean found = false;
                    for (String item : p.getDoituongsudung()) {
                        if (item.equals(temp_dtsd)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        hople = false;
                    }
                }

                if (!temp_chidinh.equals("Chỉ định") && !p.getDanhmuc().contains(temp_chidinh)) {
                    hople = false;
                }

                // Kiểm tra xuất xứ
                if (!temp_xuatxu.equals("Xuất xứ thương hiệu") && !p.getXuatxu().contains(temp_xuatxu)) {
                    hople = false;
                }

                if (hople) {
                    foundProductsFilter.add(p);
                }
            }

            // Kiểm tra nếu không tìm thấy sản phẩm nào
            if (foundProductsFilter.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm phù hợp");
            } else {
                String selectedSortOption = cb4.getSelectedItem().toString().trim();
                System.out.println("Selected Sort Option: " + selectedSortOption);

                if (!selectedSortOption.equals("Giá bán")) {
                    Collections.sort(foundProductsFilter, new Comparator<medicine>() {
                        @Override
                        public int compare(medicine m1, medicine m2) {

                            int price1 = (m1.getGiaban() != null && !m1.getGiaban().isEmpty()) ? m1.getGiaban().get(0)
                                    : Integer.MAX_VALUE;
                            int price2 = (m2.getGiaban() != null && !m2.getGiaban().isEmpty()) ? m2.getGiaban().get(0)
                                    : Integer.MAX_VALUE;

                            System.out.println("Comparing Prices: " + price1 + " and " + price2);

                            if (selectedSortOption.equals("Giá từ thấp đến cao")) {
                                return Integer.compare(price1, price2);
                            } else if (selectedSortOption.equals("Giá từ cao đến thấp")) {
                                return Integer.compare(price2, price1);
                            }
                            return 0;
                        }
                    });
                }
                createProductGrid(foundProductsFilter);
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
            new cartGUI(this, khachCurrent);
            dispose();
        }
        if (e.getSource() == user) {
            new trangCaNhan(this, khachCurrent);
            dispose();
        }
    }

}
