package customer;

import cart.cartGUI;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
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
    JButton search, cart, logout;
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

    private customer khachhang;
    private medicineArr sanpham;
    private customer khachCurrent;

    public customerGUI(customer kh) {

        this.khachhang = kh;
        this.khachCurrent = kh;
        this.sanpham = new medicineArr(); // Khởi tạo
        sanpham.readDatabase(); // Đọc dữ liệu
        create();
    }

    public customer getKhachHangDangNhap() {
        if (khachCurrent == null) {
            System.out.println("Lỗi: khachCurrent đang null!");
        } else {
            System.out.println("Thông tin khách hàng đang đăng nhập: " + khachCurrent);
        }
        return this.khachCurrent;
    }

    public void create() {
        setTitle("Customer");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p0.setLayout(new BorderLayout());

        int productCount = sanpham.getSp().size();
        int rows = (int) Math.ceil(productCount / 4.0); // 4sp 1 dòng
        int productHeight = 320; // Chiều cao mỗi ô sản phẩm
        int totalHeight = 300 + rows * productHeight + 100; // Tổng chiều cao p0

        p0.setPreferredSize(new Dimension(1280, totalHeight));

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
        createProductGrid();

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
        nameuser.setFont(new Font("Arial", Font.PLAIN, 17));
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

        ImageIcon icon_search = new ImageIcon(
                "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-search-40.png");
        Image img = icon_search.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon search_btn = new ImageIcon(img);

        search = new JButton(search_btn);
        search.setBounds(750, 20, 80, 40);
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
        cart.setBounds(900, 20, 80, 40);
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

    public void createProductGrid() {
        ArrayList<medicine> productArr = sanpham.getSp();
        int productCount = productArr.size();

        // mid_panel.removeAll(); // Xóa các sản phẩm cũ trước khi cập nhật mới
        mid_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

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
            chinhgiua.add(main_center, BorderLayout.CENTER);

            JLabel test = new JLabel("" + (i + 1), SwingConstants.CENTER);
            test.setFont(new Font("Arial", Font.PLAIN, 60));
            test.setForeground(xanhla);
            main_center.add(test, BorderLayout.CENTER);

            // TEN SAN PHAM------------------
            JPanel main_center_tensp = new JPanel();
            main_center_tensp.setBackground(linen);
            main_center_tensp.setPreferredSize(new Dimension(0, 30));
            main_center.add(main_center_tensp, BorderLayout.SOUTH);

            JLabel tensp = new JLabel(productArr.get(i).getTenthuoc(), SwingConstants.CENTER);

            tensp.setFont(new Font("Arial", Font.PLAIN | Font.ITALIC, 13));
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
            NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE); // Dùng dấu cách thay vì dấu phẩy
            int price = productArr.get(i).getGiaban()[0]; // Lấy giá trị đầu tiên trong mảng giaban
            String formattedPrice = nf.format(price) + " / " + productArr.get(i).getDonvi()[0]; // Định dạng giá và đơn
                                                                                                // vị

            System.out.println(formattedPrice); // In ra kết quả
            JLabel price_sp = new JLabel(formattedPrice, SwingConstants.LEFT);
            price_sp.setFont(new Font("Arial", Font.PLAIN | Font.BOLD, 17));
            price_sp.setForeground(dodo);
            main_south.add(price_sp);
            // nut mua hang
            JPanel buy_panel = new JPanel();
            buy_panel.setPreferredSize(new Dimension(0, 50));
            buy_panel.setBackground(xamnhat);
            productPanel.add(buy_panel, BorderLayout.SOUTH);

            JButton buy_btn = new JButton("Chọn mua");
            buy_btn.setFont(new Font("Arial", Font.BOLD, 17));
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

            // Thêm vào mid_panel
            mid_panel.add(productPanel);
        }

        mid_panel.revalidate();
        mid_panel.repaint();
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
            String temp = timkiem.getText().trim(); // Lấy từ khóa tìm kiếm
            String temp_dtsd = cb1.getSelectedItem().toString().trim();
            String temp_chidinh = cb2.getSelectedItem().toString().trim();
            String temp_xuatxu = cb3.getSelectedItem().toString().trim();

            ArrayList<medicine> foundProducts = temp.equals("Nhập tên sản phẩm thuốc ...") ? sanpham.getSp()
                    : sanpham.findName(temp);

            ArrayList<medicine> foundProductsFilter = new ArrayList<>();
            for (medicine p : foundProducts) {
                boolean hople = true;

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
                if (!temp_xuatxu.equals("Xuất xứ thương hiệu") && !p.getXuatxu().contains(temp_xuatxu)) {
                    hople = false;
                }

                if (hople) {
                    foundProductsFilter.add(p);
                }
            }

            if (foundProductsFilter.isEmpty()) {
                System.out.println("Không tìm thấy sản phẩm phù hợp.");
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm phù hợp");
            } else {
                System.out.println("Danh sách sản phẩm phù hợp:");

                for (medicine p : foundProductsFilter) {
                    // Lấy giá bán đầu tiên và đơn vị đầu tiên
                    int price = p.getGiaban()[0]; // Lấy giá đầu tiên trong mảng giaban
                    String unit = p.getDonvi()[0]; // Lấy đơn vị đầu tiên trong mảng donvi

                    // Định dạng giá bán (thêm dấu cách theo kiểu tiền tệ)
                    NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE); // Dùng dấu cách thay vì dấu phẩy
                    String formattedPrice = nf.format(price) + " / " + unit; // Định dạng giá bán và đơn vị

                    System.out.println("Mã thuốc: " + p.getMathuoc());
                    System.out.println("Tên thuốc: " + p.getTenthuoc());
                    System.out.println("Giá bán: " + formattedPrice); // In ra giá bán theo đơn vị
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
            new cartGUI(this, khachCurrent);
            dispose();
        }
    }

}