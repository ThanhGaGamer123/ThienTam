package customer;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import cart.Cart;
import cart.cartGUI;
import login.signup.login;
import products.product;
import products.productsArr;

public class customerGUI extends JFrame implements MouseListener, ActionListener {

    JLabel title, hotline, sdt, price, nameuser, logo1;
    JPanel p1, p2, p0, p3, cartPanel, logo;
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
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p0.setLayout(null);
        p0.setPreferredSize(new Dimension(1280, 1500));

        // Header
        createPanel_1();
        createPanel_2();
        createPanel_3();

        scr = new JScrollPane(p0);
        scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scr.getVerticalScrollBar().setUnitIncrement(16);

        setContentPane(scr);

        create_tail();
        setVisible(true);
    }

    // HEADER
    // panel1 => height 100
    public void createPanel_1() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1280, 100);
        p1.setBackground(xanhla);

        p0.add(p1);
        int logoWidth = 50;
        int logoHeight = 50;
        int p1Height = p1.getHeight();
        int y = (p1Height - logoHeight) / 2;

        logo1 = new JLabel(new ImageIcon("D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\logo (1).png"));

        logo = new JPanel();
        logo.setLayout(null);
        logo.setBounds(50, y, logoWidth, logoHeight);
        logo1.setBounds(0, 0, logoWidth, logoHeight);
        logo.add(logo1);
        p1.add(logo);

        title = new JLabel("NHÀ THUỐC THIỆN TÂM");
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setBounds(380, 30, 500, 40);
        p1.add(title);

        customerArr khach = new customerArr();
        khach.readFile();
        nameuser = new JLabel();

        nameuser = new JLabel("Xin chào, " + khachhang.getUserkh());
        nameuser.setForeground(Color.WHITE);
        nameuser.setFont(new Font("Arial", Font.BOLD, 18));
        nameuser.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nameuser.setBounds(840, 15, 350, 48);

        p1.add(nameuser);

        ImageIcon icon_logout = new ImageIcon(
                "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-log-out-48.png");

        Image img = icon_logout.getImage();
        Image scaledImg = img.getScaledInstance(48, 48, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        logout = new JButton(scaledIcon);

        logout.setBounds(1190, 15, 48, 48);
        logout.setBackground(xanhla);
        logout.setBorder(null);
        p1.add(logout);

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
        p2.setBounds(0, 100, 1280, 80);
        p2.setBackground(xanhla);
        p2.setLayout(null);
        p0.add(p2);

        timkiem = new JTextField("Nhập tên sản phẩm thuốc ...");
        timkiem.setFont(new java.awt.Font("Ariel", 2, 14));
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
        p2.add(search);
        search.addMouseListener(this);

        cart = new JButton("GIỎ HÀNG");
        cart.setBounds(900, 20, 100, 40);
        cart.setForeground(Color.white);
        cart.setBackground(hong);
        cart.addActionListener(this);
        p2.add(cart);

        hotline = new JLabel("Hotline (8:00 - 21:30)");
        hotline.setBounds(1080, 20, 150, 14);
        hotline.setFont(new Font("Ariel", Font.BOLD, 14));
        hotline.setForeground(Color.black);
        p2.add(hotline);

        sdt = new JLabel("1900 1572");
        sdt.setBounds(1080, 40, 150, 16);
        sdt.setHorizontalAlignment(SwingConstants.CENTER);
        sdt.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        sdt.setForeground(vang);
        p2.add(sdt);

    }

    public void createPanel_3() {
        p3 = new JPanel();
        p3.setBounds(0, 180, 1280, 60);
        p3.setBackground(xanhla);

        p3.setLayout(null);
        p0.add(p3);

        int cbb_weight = 200;
        int cbb_height = 30;
        int x_cbb = 50;
        int y_cbb = (60 - cbb_height) / 2; // 60 la height cua panel

        String[] cb1_item = { "          Đối tượng sử dụng", "Trẻ em", "Người lớn", "Người cao tuổi",
                "Phụ nữ có thai",
                "Phụ nữ cho con bú", "Người bị loét dạ dày" };
        cb1 = new JComboBox<>(cb1_item);
        cb1.setBounds(x_cbb, y_cbb, cbb_weight, cbb_height);
        p3.add(cb1);

        String[] cb2_item = { "                    Chỉ định ", "Mất ngủ", "Rối loạn tiêu hóa", "Suy giảm hệ miễn dịch",
                "Táo bón", "Biếng ăn", "Suy giảm trí nhớ", "Bệnh tim mạch", "Mệt mỏi", "Đau đầu", "Ho có đàm" };
        cb2 = new JComboBox<>(cb2_item);
        cb2.setBounds(x_cbb * 2 + cbb_weight, y_cbb, cbb_weight, cbb_height);
        p3.add(cb2);

        String[] cb3_item = { "         Xuất sứ thương hiệu", "Anh", "Pháp", "Mỹ", "Úc", "Việt Nam",
                "Hà Lan" };
        cb3 = new JComboBox<>(cb3_item);
        cb3.setBounds(x_cbb * 3 + 2 * cbb_weight, y_cbb, cbb_weight, cbb_height);
        p3.add(cb3);

        price = new JLabel();
        price.setText("Lọc: ");
        price.setFont(new Font("Ariel", Font.BOLD, 18));
        price.setForeground(Color.WHITE);
        price.setBounds(x_cbb * 4 + 3 * cbb_weight - 5, y_cbb, 100, cbb_height);
        p3.add(price);

        String[] cb4_item = { "Giá từ thấp đến cao", "Giá từ cao đến thấp " };
        cb4 = new JComboBox<>(cb4_item);
        cb4.setBounds(x_cbb * 4 + 3 * cbb_weight + 50, y_cbb, cbb_weight,
                cbb_height);
        p3.add(cb4);

    }

    // GIO HANG

    public void create_tail() {
        JPanel tail_pn = new JPanel();
        tail_pn.setBounds(0, 1450, 1280, 50);
        tail_pn.setBackground(xanhla);
        tail_pn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        JLabel detail_tail = new JLabel(
                "nhathuocthientam@gmail.com.vn");

        detail_tail.setFont(new Font("Arial", Font.ITALIC, 13));
        detail_tail.setForeground(Color.BLACK);

        tail_pn.add(detail_tail);
        p0.add(tail_pn);
    }

    @Override
    public void mousePressed(MouseEvent e) {

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