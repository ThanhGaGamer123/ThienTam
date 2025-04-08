package cart;

import customer.customer;
import customer.customerGUI;
import login.signup.login;
// import medicine.productsArr; // Removed as the class does not exist or is not needed
import medicine.medicineArr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class thanhtoanGUI extends JFrame {
    private JPanel header, tail, body;
    private JLabel title;
    private JButton back;
    private customerGUI khach;
    private String ten; // Thêm biến để lưu tên khách hàng
    private cartGUI cart;

    // Màu sắc tùy chỉnh
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

    private customer khachhang;
    private medicineArr sanpham;
    private customer khachCurrent;

    public thanhtoanGUI(customerGUI khach, cartGUI cart, customer khachCurrent) {
        this.khach = khach;
        this.cart = cart;
        this.khachhang = khachCurrent;

        setTitle("Thanh toán");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        create_header();
        create_body();
        create_footer();

        setVisible(true);
    }

    public customer getKhachHangDangNhap() {
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
                if (cart != null) {
                    cart.setVisible(true);
                }
                dispose();
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

        JPanel giua = new JPanel();
        giua.setBackground(Color.white);
        giua.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để bố cục gọn gàng
        body.add(giua, BorderLayout.CENTER);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 10, 5, 10); // Khoảng cách giữa các thành phần
        gbc1.fill = GridBagConstraints.HORIZONTAL; // Giúp các ô giãn theo chiều ngang
        gbc1.weightx = 1; // Giúp các thành phần kéo dài theo chiều ngang

        // ===== THÔNG TIN NGƯỜI ĐẶT =====
        customer khachDangNhap = getKhachHangDangNhap();
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
        JTextField tenNguoiDat = new JTextField();
        tenNguoiDat.setBorder(BorderFactory.createTitledBorder("Tên người đặt"));

        String temp = khachDangNhap.getTenkh();
        tenNguoiDat.setText(temp);

        JTextField sdtNguoiDat = new JTextField();
        sdtNguoiDat.setBorder(BorderFactory.createTitledBorder("SDT người đặt"));
        panelNguoiDat.add(tenNguoiDat);
        panelNguoiDat.add(sdtNguoiDat);
        giua.add(panelNguoiDat, gbc1);

        // ===== ĐỊA CHỈ NHẬN HÀNG =====
        gbc1.gridy++;
        gbc1.gridwidth = 2;
        JLabel diaChiLabel = new JLabel("                     ĐỊA CHỈ NHẬN HÀNG:");
        diaChiLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        giua.add(diaChiLabel, gbc1);

        // Người nhận và số điện thoại cùng 1 hàng
        gbc1.gridy++;
        gbc1.gridwidth = 1;
        JPanel panelNguoiNhan = new JPanel(new GridLayout(1, 2, 10, 0));
        panelNguoiNhan.setBackground(Color.WHITE);
        JTextField tenNguoiNhan = new JTextField();
        tenNguoiNhan.setBorder(BorderFactory.createTitledBorder("Họ và tên người nhận"));
        JTextField sdtNguoiNhan = new JTextField();
        sdtNguoiNhan.setBorder(BorderFactory.createTitledBorder("SDT người nhận"));
        panelNguoiNhan.add(tenNguoiNhan);
        panelNguoiNhan.add(sdtNguoiNhan);
        giua.add(panelNguoiNhan, gbc1);

        // 3 Combobox cùng 1 hàng
        gbc1.gridy++;
        JPanel panelDiaChi = new JPanel(new GridLayout(1, 3, 10, 0));
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 16);
        JComboBox<String> tinhThanh = new JComboBox<>(new String[] { "Chọn tỉnh/thành phố", "TP Hồ Chí Minh" });
        tinhThanh.setFont(comboBoxFont);
        JComboBox<String> quanHuyen = new JComboBox<>(new String[] { "Chọn quận/huyện",
                "Quận 1", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7",
                "Quận 8", "Quận 10", "Quận 11", "Quận 12", "Quận Bình Tân",
                "Quận Bình Thạnh", "Quận Gò Vấp", "Quận Phú Nhuận", "Quận Tân Bình",
                "Quận Tân Phú", "Thành phố Thủ Đức", "Huyện Bình Chánh", "Huyện Cần Giờ",
                "Huyện Củ Chi", "Huyện Hóc Môn", "Huyện Nhà Bè" });
        quanHuyen.setFont(comboBoxFont);
        JComboBox<String> phuongXa = new JComboBox<>(new String[] { "Chọn phường/xã" });
        phuongXa.setFont(comboBoxFont);

        panelDiaChi.add(tinhThanh);
        panelDiaChi.add(quanHuyen);
        panelDiaChi.add(phuongXa);
        giua.add(panelDiaChi, gbc1);

        // Địa chỉ cụ thể
        gbc1.gridy++;
        gbc1.gridwidth = 2;
        JTextField diaChiCuThe = new JTextField();
        diaChiCuThe.setBorder(BorderFactory.createTitledBorder("Nhập địa chỉ cụ thể"));
        giua.add(diaChiCuThe, gbc1);

        // Ghi chú
        gbc1.gridy++;
        JTextArea ghiChu = new JTextArea(3, 20);
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

        JRadioButton momoRadio = new JRadioButton("Thanh toán bằng ví MoMo");
        JRadioButton cashRadio = new JRadioButton("Thanh toán tiền mặt khi nhận hàng");
        JRadioButton qrRadio = new JRadioButton("Thanh toán bằng chuyển khoản (QR Code)");

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
        paid.setFont(new Font("Arial", Font.BOLD, 20));
        paid.setForeground(Color.BLACK);
        gbc2.gridy = 0;
        pay.add(paid, gbc2);

        // Tổng tiền
        JPanel totalPanel = new JPanel(new GridLayout(1, 2));
        totalPanel.setBackground(xamnhat);
        JLabel tt = new JLabel("Tổng tiền: ");
        tt.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel cost = new JLabel("---");
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
        JLabel costvc = new JLabel("---");
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
        JLabel sosp = new JLabel("---");
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
        JLabel costreal = new JLabel("---");
        costreal.setFont(new Font("Arial", Font.PLAIN, 14));
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

        thanhtoan_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (diaChiCuThe.getText().equals("") && tenNguoiNhan.getText().equals("")
                        && sdtNguoiNhan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin nhận hàng!");
                    return;

                } else if (diaChiCuThe.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập địa chỉ nhận hàng!");
                    return;
                } else if (tenNguoiNhan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên người nhận!");
                    return;
                } else if (sdtNguoiNhan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập SĐT người nhận!");
                    return;
                }

                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn xác nhận thanh toán không ?");
                if (choice == 0) {

                }

            }
        });

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
