package GUI;

import DAO.cartDAO;
import DAO.employee_DAO;
import DAO.orderDAO;
import DAO.orderDetailsDAO;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.order_details_DTO;
import DTO.sanphamchonmua_DTO;
import advanceMethod.advance;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class thanhtoan_GUI extends JFrame implements MouseListener, ActionListener {

    private JPanel header, tail, body, giua;
    private JLabel title, cost, costreal, costvc, sosp;
    private JButton back;
    private customer_GUI khach;
    private cart_GUI cart;
    private JTextField tenNguoiDat, sdtNguoiDat, tenNguoiNhan, sdtNguoiNhan, diaChiCuThe;
    private JTextArea ghiChu;
    private JRadioButton momoRadio, cashRadio, qrRadio;
    private JComboBox<String> tinhThanh;
    private JComboBox<String> quanHuyen;
    private JComboBox<String> phuongXa;

    // Màu sắc tùy chỉnh
    // Màu sắc tùy chỉnh
    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color xam = new Color(207, 207, 207);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xamnhat = new Color(237, 240, 243);
    private static final Color dodo = new Color(232, 58, 72);

    private customer_DTO khachhang;

    private ArrayList<sanphamchonmua_DTO> selectedProducts;

    public thanhtoan_GUI(customer_GUI khach, cart_GUI cart, customer_DTO khachCurrent,
            ArrayList<sanphamchonmua_DTO> selectedProducts) {
        this.khach = khach;
        this.cart = cart;
        this.khachhang = khachCurrent;
        this.selectedProducts = selectedProducts;

        setTitle("Trang thanh toán");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        create_header();
        create_body();
        create_footer();

        setVisible(true);
        updateSummary();
    }

    public customer_DTO getKhachHangDangNhap() {
        return this.khachhang;
    }

    private void create_header() {
        header = new JPanel();
        header.setBackground(xanhla);
        header.setPreferredSize(new Dimension(0, 100));
        header.setLayout(null);

        title = new JLabel("TRANG THANH TOÁN", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(500, 30, 300, 40);
        header.add(title);

        ImageIcon icon_back = new ImageIcon(advance.img + "\\img_xt\\back.png");
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
                if (cart != null) {
                    cart.setVisible(true);
                }
                dispose();
            }
        });

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            }
        });

        add(header, BorderLayout.NORTH);
    }

    private void create_body() {
        // Panel chính chứa cả body và pay
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER); // Thêm vào frame

        // ========= Body =========
        body = new JPanel();
        body.setBackground(xamnhat);
        body.setPreferredSize(new Dimension(400, 400));
        body.setLayout(new BorderLayout());
        mainPanel.add(body, BorderLayout.CENTER);

        JPanel trai = new JPanel();
        trai.setBackground(linen);
        trai.setPreferredSize(new Dimension(20, 400));
        trai.setLayout(null);
        body.add(trai, BorderLayout.WEST);

        JPanel phai = new JPanel();
        phai.setBackground(linen);
        phai.setPreferredSize(new Dimension(20, 400));
        phai.setLayout(null);
        body.add(phai, BorderLayout.EAST);

        JPanel duoi = new JPanel();
        duoi.setBackground(linen);
        duoi.setPreferredSize(new Dimension(400, 20));
        duoi.setLayout(null);
        body.add(duoi, BorderLayout.SOUTH);

        JPanel tren = new JPanel();
        tren.setBackground(linen);
        tren.setPreferredSize(new Dimension(400, 20));
        tren.setLayout(null);
        body.add(tren, BorderLayout.NORTH);

        giua = new JPanel();
        giua.setBackground(Color.white);
        giua.setLayout(new GridBagLayout());

        JScrollPane scrollpane_giua = new JScrollPane();
        // scrollpane_giua.setPreferredSize(new Dimension(400, 200));
        // scrollpane_giua.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // scrollpane_giua.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scrollpane_giua.getVerticalScrollBar().setUnitIncrement(16);
        scrollpane_giua.setViewportView(giua);
        body.add(scrollpane_giua, BorderLayout.CENTER);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 10, 5, 10); // Khoảng cách giữa các thành phần
        gbc1.fill = GridBagConstraints.HORIZONTAL; // Giúp các ô giãn theo chiều ngang
        gbc1.weightx = 1; // Giúp các thành phần kéo dài theo chiều ngang

        // ===== THÔNG TIN NGƯỜI ĐẶT =====
        customer_DTO khachDangNhap = getKhachHangDangNhap();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 2; // Dài hết hàng
        JLabel thongTinLabel = new JLabel("                     THÔNG TIN NGƯỜI ĐẶT:");
        thongTinLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        giua.add(thongTinLabel, gbc1);

        // Tạo panel chứa 2 text field cùng 1 hàng
        gbc1.gridy++;
        gbc1.gridwidth = 1;
        JPanel panelNguoiDat = new JPanel(new GridLayout(1, 2, 10, 0)); // GridLayout: 1 hàng, 2 cột
        panelNguoiDat.setBackground(Color.WHITE);
        tenNguoiDat = new JTextField();
        tenNguoiDat.setBorder(BorderFactory.createTitledBorder("Tên người đặt"));

        String temp = khachDangNhap.getTenkh();
        tenNguoiDat.setText(temp);

        sdtNguoiDat = new JTextField();
        sdtNguoiDat.setBorder(BorderFactory.createTitledBorder("SDT người đặt"));
        String tempsdtsdt = String.valueOf(khachDangNhap.getSdt());
        sdtNguoiDat.setText(tempsdtsdt);

        panelNguoiDat.add(tenNguoiDat);
        panelNguoiDat.add(sdtNguoiDat);
        giua.add(panelNguoiDat, gbc1);

        // JScrollPane scollpane_giuaPN = new JScrollPane(giua);
        // scollpane_giuaPN.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // scollpane_giuaPN.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scollpane_giuaPN.getVerticalScrollBar().setUnitIncrement(16);

        // ===== ĐỊA CHỈ NHẬN HÀNG =====
        gbc1.gridy++;
        gbc1.gridwidth = 2;
        JLabel diaChiLabel = new JLabel("                     ĐỊA CHỈ NHẬN HÀNG:");
        // diaChiLabel.setPreferredSize(new Dimension(0, 200));
        diaChiLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        giua.add(diaChiLabel, gbc1);

        // Người nhận và số điện thoại cùng 1 hàng
        gbc1.gridy++;
        gbc1.gridwidth = 1;
        JPanel panelNguoiNhan = new JPanel(new GridLayout(1, 2, 10, 0));
        panelNguoiNhan.setBackground(Color.WHITE);
        tenNguoiNhan = new JTextField();
        tenNguoiNhan.setText(temp);
        tenNguoiNhan.setBorder(BorderFactory.createTitledBorder("Họ và tên người nhận"));
        sdtNguoiNhan = new JTextField();
        sdtNguoiNhan.setBorder(BorderFactory.createTitledBorder("SDT người nhận"));

        String sdtnguoinhan = String.valueOf(khachDangNhap.getSdt());
        sdtNguoiNhan.setText(sdtnguoinhan);

        panelNguoiNhan.add(tenNguoiNhan);
        panelNguoiNhan.add(sdtNguoiNhan);
        giua.add(panelNguoiNhan, gbc1);

        // 3 Combobox cùng 1 hàng
        gbc1.gridy++;
        JPanel panelDiaChi = new JPanel(new GridLayout(1, 3, 10, 0));
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 16);

        // Tỉnh/Thành Phố
        tinhThanh = new JComboBox<>(new String[] { "Chọn tỉnh/thành phố", "TP Hồ Chí Minh" });
        tinhThanh.setFont(comboBoxFont);

        // Quận/Huyện
        quanHuyen = new JComboBox<>(new String[] { "Chọn quận/huyện" });
        quanHuyen.setFont(comboBoxFont);

        // Phường/Xã
        phuongXa = new JComboBox<>(new String[] { "Chọn phường/xã" });
        phuongXa.setFont(comboBoxFont);

        // Action listener cho tỉnh/thành phố
        tinhThanh.addActionListener(e -> {
            if (tinhThanh.getSelectedItem().equals("TP Hồ Chí Minh")) {
                quanHuyen.removeAllItems();
                quanHuyen.addItem("Chọn quận/huyện");
                quanHuyen.addItem("Quận 1");
                quanHuyen.addItem("Quận 2");
                quanHuyen.addItem("Quận 3");
                quanHuyen.addItem("Quận 4");
                quanHuyen.addItem("Quận 5");
                quanHuyen.addItem("Quận 6");
                quanHuyen.addItem("Quận 7");
                quanHuyen.addItem("Quận 8");
                quanHuyen.addItem("Quận 10");
                quanHuyen.addItem("Quận 11");
                quanHuyen.addItem("Quận 12");
                quanHuyen.addItem("Quận Bình Tân");
                quanHuyen.addItem("Quận Bình Thạnh");
                quanHuyen.addItem("Quận Gò Vấp");
                quanHuyen.addItem("Quận Phú Nhuận");
                quanHuyen.addItem("Quận Tân Bình");
                quanHuyen.addItem("Quận Tân Phú");
                quanHuyen.addItem("Thành phố Thủ Đức");
                quanHuyen.addItem("Huyện Bình Chánh");
                quanHuyen.addItem("Huyện Cần Giờ");
                quanHuyen.addItem("Huyện Củ Chi");
                quanHuyen.addItem("Huyện Hóc Môn");
                quanHuyen.addItem("Huyện Nhà Bè");
            } else {
                quanHuyen.removeAllItems();
                quanHuyen.addItem("Chọn quận/huyện");
            }
            phuongXa.removeAllItems();
            phuongXa.addItem("Chọn phường/xã");
        });

        // Action listener cho quận/huyện
        quanHuyen.addActionListener(e -> {
            phuongXa.removeAllItems();
            phuongXa.addItem("Chọn phường/xã");

            if (quanHuyen.getSelectedItem() != null) {
                switch (quanHuyen.getSelectedItem().toString()) {
                    case "Quận 1":
                        phuongXa.addItem("Phường Bến Nghé");
                        phuongXa.addItem("Phường Bến Thành");
                        phuongXa.addItem("Phường Cô Giang");
                        phuongXa.addItem("Phường Cầu Kho");
                        phuongXa.addItem("Phường Cầu Ông Lãnh");
                        phuongXa.addItem("Phường Đa Kao");
                        phuongXa.addItem("Phường Nguyễn Cư Trinh");
                        phuongXa.addItem("Phường Nguyễn Thái Bình");
                        phuongXa.addItem("Phường Phạm Ngũ Lão");
                        phuongXa.addItem("Phường Tân Định");
                        break;
                    case "Quận 2":
                        phuongXa.addItem("Phường An Khánh");
                        phuongXa.addItem("Phường An Lợi Đông");
                        phuongXa.addItem("Phường An Phú");
                        phuongXa.addItem("Phường Bình An");
                        phuongXa.addItem("Phường Bình Khánh");
                        phuongXa.addItem("Phường Bình Trưng Đông");
                        phuongXa.addItem("Phường Bình Trưng Tây");
                        phuongXa.addItem("Phường Cát Lái");
                        phuongXa.addItem("Phường Thạnh Mỹ Lợi");
                        phuongXa.addItem("Phường Thảo Điền");
                        phuongXa.addItem("Phường Thủ Thiêm");
                        break;
                    case "Quận 3":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường Võ Thị Sáu");
                        break;
                    case "Quận 4":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");
                        phuongXa.addItem("Phường 16");
                        phuongXa.addItem("Phường 18");

                        break;
                    case "Quận 5":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");

                        break;
                    case "Quận 6":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");

                        break;
                    case "Quận 7":
                        phuongXa.addItem("Phường Tân Thuận Đông");
                        phuongXa.addItem("Phường Tân Thuận Tây");
                        phuongXa.addItem("Phường Tân Kiểng");
                        phuongXa.addItem("Phường Tân Hưng");
                        phuongXa.addItem("Phường Tân Phong");
                        phuongXa.addItem("Phường Phú Mỹ");
                        phuongXa.addItem("Phường Phú Thuận");
                        phuongXa.addItem("Phường Bình Thuận");
                        phuongXa.addItem("Phường Tân Phú");
                        phuongXa.addItem("Phường Tân Quy");

                        break;
                    case "Quận 8":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");
                        phuongXa.addItem("Phường 16");

                        break;
                    case "Quận 10":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");

                        break;
                    case "Quận 11":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");
                        phuongXa.addItem("Phường 16");

                        break;
                    case "Quận 12":
                        phuongXa.addItem("Phường An Phú Đông");
                        phuongXa.addItem("Phường Đông Hưng Thuận");
                        phuongXa.addItem("Phường Hiệp Thành");
                        phuongXa.addItem("Phường Tân Chánh Hiệp");
                        phuongXa.addItem("Phường Tân Hưng Thuận");
                        phuongXa.addItem("Phường Tân Thới Hiệp");
                        phuongXa.addItem("Phường Tân Thới Nhất");
                        phuongXa.addItem("Phường Thạnh Lộc");
                        phuongXa.addItem("Phường Thạnh Xuân");
                        phuongXa.addItem("Phường Thới An");
                        phuongXa.addItem("Phường Trung Mỹ Tây");

                        break;
                    case "Quận Bình Tân":
                        phuongXa.addItem("Phường An Lạc");
                        phuongXa.addItem("Phường An Lạc A");
                        phuongXa.addItem("Phường Bình Hưng Hòa");
                        phuongXa.addItem("Phường Bình Hưng Hòa A");
                        phuongXa.addItem("Phường Bình Hưng Hòa B");
                        phuongXa.addItem("Phường Bình Trị Đông");
                        phuongXa.addItem("Phường Bình Trị Đông A");
                        phuongXa.addItem("Phường Bình Trị Đông B");
                        phuongXa.addItem("Phường Tân Tạo");
                        phuongXa.addItem("Phường Tân Tạo A");

                        break;
                    case "Quận Bình Thạnh":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");
                        phuongXa.addItem("Phường 17");
                        phuongXa.addItem("Phường 19");
                        phuongXa.addItem("Phường 21");
                        phuongXa.addItem("Phường 22");
                        phuongXa.addItem("Phường 24");
                        phuongXa.addItem("Phường 25");
                        phuongXa.addItem("Phường 26");
                        phuongXa.addItem("Phường 27");
                        phuongXa.addItem("Phường 28");

                        break;
                    case "Quận Gò Vấp":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");
                        phuongXa.addItem("Phường 16");
                        phuongXa.addItem("Phường 17");

                        break;
                    case "Quận Phú Nhuận":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 15");
                        phuongXa.addItem("Phường 17");
                        break;
                    case "Quận Tân Bình":
                        phuongXa.addItem("Phường 1");
                        phuongXa.addItem("Phường 2");
                        phuongXa.addItem("Phường 3");
                        phuongXa.addItem("Phường 4");
                        phuongXa.addItem("Phường 5");
                        phuongXa.addItem("Phường 6");
                        phuongXa.addItem("Phường 7");
                        phuongXa.addItem("Phường 8");
                        phuongXa.addItem("Phường 9");
                        phuongXa.addItem("Phường 10");
                        phuongXa.addItem("Phường 11");
                        phuongXa.addItem("Phường 12");
                        phuongXa.addItem("Phường 13");
                        phuongXa.addItem("Phường 14");
                        phuongXa.addItem("Phường 15");
                        break;
                    case "Quận Tân Phú":
                        phuongXa.addItem("Phường Hiệp Tân");
                        phuongXa.addItem("Phường Hòa Thạnh");
                        phuongXa.addItem("Phường Phú Thạnh");
                        phuongXa.addItem("Phường Phú Thọ Hòa");
                        phuongXa.addItem("Phường Phú Trung");
                        phuongXa.addItem("Phường Sơn Kỳ");
                        phuongXa.addItem("Phường Tân Quý");
                        phuongXa.addItem("Phường Tân Sơn Nhì");
                        phuongXa.addItem("Phường Tân Thành");
                        phuongXa.addItem("Phường Tây Thạnh");
                        break;
                    case "Thành phố Thủ Đức":
                        phuongXa.addItem("Phường An Khánh");
                        phuongXa.addItem("Phường An Lợi Đông");
                        phuongXa.addItem("Phường An Phú");
                        phuongXa.addItem("Phường Bình Chiểu");
                        phuongXa.addItem("Phường Bình Thọ");
                        phuongXa.addItem("Phường Cát Lái");
                        phuongXa.addItem("Phường Hiệp Bình Chánh");
                        phuongXa.addItem("Phường Hiệp Bình Phước");
                        phuongXa.addItem("Phường Linh Chiểu");
                        phuongXa.addItem("Phường Linh Đông");
                        phuongXa.addItem("Phường Linh Tây");
                        phuongXa.addItem("Phường Linh Trung");
                        phuongXa.addItem("Phường Linh Xuân");
                        phuongXa.addItem("Phường Long Bình");
                        phuongXa.addItem("Phường Long Phước");
                        phuongXa.addItem("Phường Long Thạnh Mỹ");
                        phuongXa.addItem("Phường Long Trường");
                        phuongXa.addItem("Phường Phú Hữu");
                        phuongXa.addItem("Phường Phước Bình");
                        phuongXa.addItem("Phường Phước Long A");
                        phuongXa.addItem("Phường Phước Long B");
                        phuongXa.addItem("Phường Tăng Nhơn Phú A");
                        phuongXa.addItem("Phường Tăng Nhơn Phú B");
                        phuongXa.addItem("Phường Tam Bình");
                        phuongXa.addItem("Phường Tam Phú");
                        phuongXa.addItem("Phường Thạnh Mỹ Lợi");
                        phuongXa.addItem("Phường Thảo Điền");
                        phuongXa.addItem("Phường Thủ Thiêm");
                        phuongXa.addItem("Phường Trường Thạnh");
                        break;
                    case "Huyện Bình Chánh":
                        phuongXa.addItem("Xã An Phú Tây");
                        phuongXa.addItem("Xã Bình Chánh");
                        phuongXa.addItem("Xã Bình Hưng");
                        phuongXa.addItem("Xã Bình Lợi");
                        phuongXa.addItem("Xã Đa Phước");
                        phuongXa.addItem("Xã Hưng Long");
                        phuongXa.addItem("Xã Lê Minh Xuân");
                        phuongXa.addItem("Xã Phạm Văn Hai");
                        phuongXa.addItem("Xã Phong Phú");
                        phuongXa.addItem("Xã Quy Đức");
                        phuongXa.addItem("Xã Tân Kiên");
                        phuongXa.addItem("Xã Tân Nhựt");
                        phuongXa.addItem("Xã Tân Quý Tây");
                        phuongXa.addItem("Xã Vĩnh Lộc A");
                        phuongXa.addItem("Xã Vĩnh Lộc B");
                        break;
                    case "Huyện Cần Giờ":
                        phuongXa.addItem("Xã An Thới Đông");
                        phuongXa.addItem("Xã Bình Khánh");
                        phuongXa.addItem("Xã Long Hòa");
                        phuongXa.addItem("Xã Lý Nhơn");
                        phuongXa.addItem("Xã Tam Thôn Hiệp");
                        phuongXa.addItem("Xã Thạnh An");
                        phuongXa.addItem("Thị trấn Cần Thạnh");
                        break;
                    case "Huyện Củ Chi":
                        phuongXa.addItem("Xã An Nhơn Tây");
                        phuongXa.addItem("Xã An Phú");
                        phuongXa.addItem("Xã Bình Mỹ");
                        phuongXa.addItem("Xã Hòa Phú");
                        phuongXa.addItem("Xã Nhuận Đức");
                        phuongXa.addItem("Xã Phạm Văn Cội");
                        phuongXa.addItem("Xã Phú Hòa Đông");
                        phuongXa.addItem("Xã Phú Mỹ Hưng");
                        phuongXa.addItem("Xã Phước Hiệp");
                        phuongXa.addItem("Xã Phước Thạnh");
                        phuongXa.addItem("Xã Phước Vĩnh An");
                        phuongXa.addItem("Xã Tân An Hội");
                        phuongXa.addItem("Xã Tân Phú Trung");
                        phuongXa.addItem("Xã Tân Thông Hội");
                        phuongXa.addItem("Xã Thái Mỹ");
                        phuongXa.addItem("Xã Trung An");
                        phuongXa.addItem("Xã Trung Lập Hạ");
                        phuongXa.addItem("Xã Trung Lập Thượng");
                        phuongXa.addItem("Thị trấn Củ Chi");
                        break;
                    case "Huyện Hóc Môn":
                        phuongXa.addItem("Xã Bà Điểm");
                        phuongXa.addItem("Xã Đông Thạnh");
                        phuongXa.addItem("Xã Nhị Bình");
                        phuongXa.addItem("Xã Tân Hiệp");
                        phuongXa.addItem("Xã Tân Thới Nhì");
                        phuongXa.addItem("Xã Thới Tam Thôn");
                        phuongXa.addItem("Xã Trung Chánh");
                        phuongXa.addItem("Xã Xuân Thới Đông");
                        phuongXa.addItem("Xã Xuân Thới Sơn");
                        phuongXa.addItem("Xã Xuân Thới Thượng");
                        phuongXa.addItem("Thị trấn Hóc Môn");
                        break;
                    case "Huyện Nhà Bè":
                        phuongXa.addItem("Xã Hiệp Phước");
                        phuongXa.addItem("Xã Long Thới");
                        phuongXa.addItem("Xã Nhơn Đức");
                        phuongXa.addItem("Xã Phú Xuân");
                        phuongXa.addItem("Xã Phước Kiển");
                        phuongXa.addItem("Xã Phước Lộc");
                        phuongXa.addItem("Thị trấn Nhà Bè");
                        break;
                    default:
                        phuongXa.addItem("Chọn phường/xã");
                        break;
                }
            }
        });

        // Thêm các combo box vào panel
        panelDiaChi.add(tinhThanh);
        panelDiaChi.add(quanHuyen);
        panelDiaChi.add(phuongXa);
        giua.add(panelDiaChi, gbc1);

        // Địa chỉ cụ thể
        gbc1.gridy++;
        gbc1.gridwidth = 2;
        diaChiCuThe = new JTextField();
        diaChiCuThe.setBorder(BorderFactory.createTitledBorder("Nhập địa chỉ cụ thể (Số nhà + Tên đường)"));
        giua.add(diaChiCuThe, gbc1);

        // o hien thi san pham
        gbc1.gridy++;

        JPanel danhsach_sp_pn = new JPanel();

        danhsach_sp_pn.setLayout(new BoxLayout(danhsach_sp_pn, BoxLayout.Y_AXIS));
        // danhsach_sp_pn.setPreferredSize(new Dimension(0, 1050));
        danhsach_sp_pn.setBackground(Color.WHITE);

        for (int i = 0; i < selectedProducts.size(); i++) {
            sanphamchonmua_DTO temp_medicine = selectedProducts.get(i);

            JPanel rowsp = new JPanel(new GridLayout(1, 3)); // 1 dòng 3 cột bằng nhau
            rowsp.setBorder(new LineBorder(xam, 1));
            // rowsp.setPreferredSize(new Dimension(500, ));

            JLabel tenthuoc = new JLabel(
                    "             " + (i + 1) + ")    " + temp_medicine.getTenthuoc(), SwingConstants.LEFT);
            tenthuoc.setFont(new Font("Bookmap", Font.PLAIN, 13));
            JLabel dongia = new JLabel(String.valueOf(temp_medicine.getDonGia()) + " đ", SwingConstants.CENTER);
            dongia.setFont(new Font("Bookmap", Font.BOLD, 12));
            JLabel soluong = new JLabel(temp_medicine.getDonvi() + "x" + temp_medicine.getSoLuong(),
                    SwingConstants.CENTER);
            soluong.setFont(new Font("Arial", Font.BOLD, 12));

            rowsp.add(tenthuoc);
            rowsp.add(dongia);
            rowsp.add(soluong);

            danhsach_sp_pn.add(rowsp);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(danhsach_sp_pn);
        scrollPane.setPreferredSize(new Dimension(0, 200));

        giua.add(scrollPane, gbc1);

        // Ghi chú
        gbc1.gridy++;
        ghiChu = new JTextArea(3, 20);
        ghiChu.setBorder(BorderFactory.createTitledBorder("Ghi chú (không bắt buộc)"));
        giua.add(ghiChu, gbc1);
        // ========= PAY =========
        JPanel pay = new JPanel();
        pay.setBackground(xamnhat);
        pay.setPreferredSize(new Dimension(300, 400));
        pay.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.weightx = 1;
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.insets = new Insets(10, 10, 10, 10);

        // ===== Phương thức thanh toán =====
        gbc1.gridy++;
        JPanel paymentPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Phương thức thanh toán"));
        paymentPanel.setBackground(Color.WHITE); // Đặt màu nền trắng

        momoRadio = new JRadioButton("Thanh toán bằng ví MoMo");
        cashRadio = new JRadioButton("Thanh toán tiền mặt khi nhận hàng");
        qrRadio = new JRadioButton("Thanh toán bằng chuyển khoản (QR Code)");

        momoRadio.setBackground(Color.white);
        cashRadio.setBackground(Color.white);
        qrRadio.setBackground(Color.white);

        momoRadio.setFocusPainted(false);
        cashRadio.setFocusPainted(false);
        qrRadio.setFocusPainted(false);

        // Nhóm các radio button lại với nhau
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(momoRadio);
        paymentGroup.add(cashRadio);
        paymentGroup.add(qrRadio);

        paymentPanel.add(momoRadio);
        paymentPanel.add(cashRadio);
        paymentPanel.add(qrRadio);

        giua.add(paymentPanel, gbc1);

        mainPanel.add(pay, BorderLayout.EAST);
        // THANH TOÁN (Tiêu đề)
        JLabel paid = new JLabel("ĐƠN HÀNG", SwingConstants.CENTER);
        paid.setForeground(dodo);
        paid.setFont(new Font("Bookman", Font.BOLD, 23));
        gbc2.gridy = 0;
        pay.add(paid, gbc2);

        // Tổng tiền
        JPanel totalPanel = new JPanel(new GridLayout(1, 2));
        totalPanel.setBackground(xamnhat);
        JLabel tt = new JLabel("Tổng tiền: ");
        tt.setFont(new Font("Arial", Font.PLAIN, 14));
        cost = new JLabel("---");
        cost.setFont(new Font("Arial", Font.PLAIN, 14));
        totalPanel.add(tt);
        totalPanel.add(cost);
        gbc2.gridy = 1;
        pay.add(totalPanel, gbc2);

        // Giảm giá voucher
        JPanel voucherPanel = new JPanel(new GridLayout(1, 2));
        voucherPanel.setBackground(xamnhat);
        JLabel vc = new JLabel("Giảm giá voucher: ");
        vc.setFont(new Font("Arial", Font.PLAIN, 14));
        costvc = new JLabel("---");
        costvc.setFont(new Font("Arial", Font.PLAIN, 14));
        voucherPanel.add(vc);
        voucherPanel.add(costvc);
        gbc2.gridy = 2;
        pay.add(voucherPanel, gbc2);

        // Tổng số sản phẩm
        JPanel tongspPanel = new JPanel(new GridLayout(1, 2));
        tongspPanel.setBackground(xamnhat);
        JLabel count = new JLabel("Tổng số sản phẩm: ");
        count.setFont(new Font("Arial", Font.PLAIN, 14));
        sosp = new JLabel("---");
        sosp.setFont(new Font("Arial", Font.PLAIN, 14));
        tongspPanel.add(count);
        tongspPanel.add(sosp);
        gbc2.gridy = 3;
        pay.add(tongspPanel, gbc2);

        // Thành tiền
        JPanel thanhtienPanel = new JPanel(new GridLayout(1, 2));
        thanhtienPanel.setBackground(xamnhat);
        JLabel thantienthantien = new JLabel("Thành tiền: ");
        thantienthantien.setFont(new Font("Arial", Font.BOLD, 18));

        costreal = new JLabel("---");
        // costreal.setFont(new Font("Arial", Font.BOLD, 18));
        costreal.setFont(new Font("Arial", Font.PLAIN, 17));

        thanhtienPanel.add(thantienthantien);
        thanhtienPanel.add(costreal);
        gbc2.gridy = 4;
        pay.add(thanhtienPanel, gbc2);

        // Nút mua hàng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(xamnhat);
        JButton thanhtoan_btn = new JButton("Xác nhận thanh toán");
        thanhtoan_btn.setBackground(hong);
        thanhtoan_btn.setFocusPainted(false);
        thanhtoan_btn.setFont(new Font("Arial", Font.BOLD, 20));
        thanhtoan_btn.setPreferredSize(new Dimension(250, 50));
        buttonPanel.add(thanhtoan_btn);
        gbc2.gridy = 5;
        pay.add(buttonPanel, gbc2);

        thanhtoan_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                thanhtoan_btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
            }

            @Override
            public void mouseExited(MouseEvent e) {
                thanhtoan_btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
            }
        });

        thanhtoan_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra các trường nhập liệu
                if (diaChiCuThe.getText().trim().isEmpty() ||
                        tenNguoiNhan.getText().trim().isEmpty() ||

                        sdtNguoiNhan.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin nhận hàng!");
                    return;
                }

                if (paymentGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn phương thức thanh toán!");

                    return;
                }

                // Hiển thị hộp thoại xác nhận
                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn xác nhận thanh toán không?",
                        "Xác nhận thanh toán",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    // Gọi phương thức xử lý thanh toán
                    xacNhanThanhToan();
                }
            }
        });

        // body.add(scrollpane_giua, BorderLayout.CENTER);

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

    public void xacNhanThanhToan() {

        String madon = taoDonHang();

        if (madon != null) {

            updateSummary();

            selectedProducts.clear();
            JOptionPane.showMessageDialog(null, "Đặt hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Đặt hàng không thành công. Vui lòng thử lại.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }

        khach.setVisible(true);
        dispose();
    }

    private String getSelectedPaymentMethod() {
        if (momoRadio.isSelected()) {
            return momoRadio.getText();
        } else if (cashRadio.isSelected()) {
            return cashRadio.getText();
        } else if (qrRadio.isSelected()) {
            return qrRadio.getText();
        }
        return "";
    }

    public String taoDonHang() {
        customer_DTO khachDangNhap = getKhachHangDangNhap();
        String makh = khachDangNhap.getMakh();
        String sdtnguoidat = khachDangNhap.getSdt();

        employee_DTO em = new employee_DTO();
        em.setManv(em.getManv());
        employee_DAO emDAO = new employee_DAO();
        em = emDAO.selectByID(em);

        String manv = em.getManv(); // Mã nhân viên giả định
        String tennguoinhan = tenNguoiNhan.getText().trim();
        String sdtnguoinhan = sdtNguoiNhan.getText().trim();
        String phuong = phuongXa.getSelectedItem().toString().trim();
        String quan = quanHuyen.getSelectedItem().toString();
        String tinh = tinhThanh.getSelectedItem().toString();
        String diachicuthe = diaChiCuThe.getText().trim();
        String ghichu = ghiChu.getText().trim();
        String pttt = getSelectedPaymentMethod();
        String ngaydat = advance.currentTime();

        // Tạo mã đơn hàng
        String madon = orderDAO.taoMaHDMoi();
        String tinhtrang = "Đang xử lý";

        // Tạo đơn hàng chính
        boolean isSuccess = orderDAO.taodonhangmoi(madon, makh, sdtnguoidat, manv, diachicuthe, phuong, quan, tinh,
                ngaydat, pttt,
                tinhtrang, 0, ghichu, tennguoinhan, sdtnguoinhan); // Tổng tiền tạm thời là 0

        if (isSuccess) {
            // Tạo chi tiết đơn hàng
            double tongtien = taoChiTietDonHang(madon); // Lấy tổng tiền từ việc tạo chi tiết

            // Cập nhật tổng tiền vào hóa đơn
            orderDAO.capNhatTongTien(madon, tongtien);

            return madon; // Trả về mã đơn hàng nếu thành công
        } else {
            return null; // Trả về null nếu có lỗi
        }
    }

    public double taoChiTietDonHang(String madon) {
        double tongtien = 0;
        customer_DTO khachDangNhap = getKhachHangDangNhap();

        for (sanphamchonmua_DTO sp : selectedProducts) {
            double thanhTienSanPham = sp.getDonGia() * sp.getSoLuong(); // Tính thành tiền cho sản phẩm
            tongtien += thanhTienSanPham;

            String macthd = orderDetailsDAO.taoMaCTHDMoi();

            String macthdnhap = cartDAO.laythongtinMacthdnhap(khachDangNhap.getMakh(), sp.getMathuoc());

            // Kiểm tra xem macthdnhap có hợp lệ không
            if (macthdnhap == null) {
                System.out.println("Không tìm thấy mã chi tiết hóa đơn nhập cho sản phẩm: " + sp.getMathuoc());
                continue; // Bỏ qua sản phẩm này
            }

            // Khởi tạo đối tượng order_details_DTO với đúng thứ tự tham số
            order_details_DTO ct = new order_details_DTO(
                    macthd,
                    madon,
                    macthdnhap,
                    sp.getSoLuong(),
                    sp.getDonvi(),
                    sp.getDonGia(),
                    thanhTienSanPham,
                    true // 8. tinhtrang
            );

            orderDetailsDAO.themChiTietDonHang(ct);
        }

        return tongtien;
    }

    private void updateSummary() {
        double totalAmount = 0; // Tổng tiền
        int totalProducts = 0; // Tổng số sản phẩm

        for (sanphamchonmua_DTO sp : selectedProducts) {
            double thanhTienSanPham = sp.getDonGia() * sp.getSoLuong(); // Tính tiền từng sản phẩm
            totalAmount += thanhTienSanPham; // Cộng dồn vào tổng tiền
            totalProducts += sp.getSoLuong(); // Tính tổng số lượng sản phẩm
        }

        // Định dạng và cập nhật giao diện
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        nf.setMaximumFractionDigits(2);
        String fmTongtien = nf.format(totalAmount);

        // Cập nhật vào các JLabel
        cost.setText(fmTongtien + " đ"); // Hiển thị tổng tiền
        sosp.setText(String.valueOf(totalProducts)); // Hiển thị tổng số sản phẩm
        costreal.setText(fmTongtien + " đ"); // Hiển thị thành tiền (nếu cần)
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // Add your implementation here if needed
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // Add your implementation here if needed
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // Add your implementation here if needed
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // Add your implementation here if needed
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // Add your implementation here if needed
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
