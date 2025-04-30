package GUI;

import DTO.customer_DTO;
import DTO.sanphamchonmua_DTO;
import cart.cart_GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

import DAO.orderDAO;
import DAO.orderDetailsDAO;
import medicine.medicineArr;
import order_details.order_details;

public class thanhtoan_GUI extends JFrame {
    private JPanel header, tail, body, giua;
    private JLabel title, cost, costreal, costvc, sosp;
    private JButton back;
    private customer_GUI khach;
    private String ten; // Thêm biến để lưu tên khách hàng
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
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color xam = new Color(207, 207, 207);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xamnhat = new Color(237, 240, 243);
    private static final Color dodo = new Color(232, 58, 72);

    private customer_DTO khachhang;
    private medicineArr sanpham;
    private customer_DTO khachCurrent;

    private ArrayList<sanphamchonmua_DTO> selectedProducts;

    public thanhtoan_GUI(customer_GUI khach, cart_GUI cart, customer_DTO khachCurrent,
            ArrayList<sanphamchonmua_DTO> selectedProducts) {
        this.khach = khach;
        this.cart = cart;
        this.khachhang = khachCurrent;
        this.selectedProducts = selectedProducts;

        setTitle("Thanh toán");
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

        giua = new JPanel();
        giua.setBackground(Color.white);
        giua.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để bố cục gọn gàng
        body.add(giua, BorderLayout.CENTER);

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
        String tempsdtsdt = "+84 " + String.valueOf(khachDangNhap.getSdt());
        sdtNguoiDat.setText(tempsdtsdt);

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
        tenNguoiNhan = new JTextField();
        tenNguoiNhan.setBorder(BorderFactory.createTitledBorder("Họ và tên người nhận"));
        sdtNguoiNhan = new JTextField();
        sdtNguoiNhan.setBorder(BorderFactory.createTitledBorder("SDT người nhận"));
        panelNguoiNhan.add(tenNguoiNhan);
        panelNguoiNhan.add(sdtNguoiNhan);
        giua.add(panelNguoiNhan, gbc1);

        // 3 Combobox cùng 1 hàng
        gbc1.gridy++;
        JPanel panelDiaChi = new JPanel(new GridLayout(1, 3, 10, 0));
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 16);
        tinhThanh = new JComboBox<>(new String[] { "Chọn tỉnh/thành phố", "TP Hồ Chí Minh" });
        tinhThanh.setFont(comboBoxFont);
        quanHuyen = new JComboBox<>(new String[] { "Chọn quận/huyện",
                "Quận 1", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7",
                "Quận 8", "Quận 10", "Quận 11", "Quận 12", "Quận Bình Tân",
                "Quận Bình Thạnh", "Quận Gò Vấp", "Quận Phú Nhuận", "Quận Tân Bình",
                "Quận Tân Phú", "Thành phố Thủ Đức", "Huyện Bình Chánh", "Huyện Cần Giờ",
                "Huyện Củ Chi", "Huyện Hóc Môn", "Huyện Nhà Bè" });
        quanHuyen.setFont(comboBoxFont);
        phuongXa = new JComboBox<>(new String[] { "Chọn phường/xã" });
        phuongXa.setFont(comboBoxFont);

        panelDiaChi.add(tinhThanh);
        panelDiaChi.add(quanHuyen);
        panelDiaChi.add(phuongXa);
        giua.add(panelDiaChi, gbc1);

        // Địa chỉ cụ thể
        gbc1.gridy++;
        gbc1.gridwidth = 2;
        diaChiCuThe = new JTextField();
        diaChiCuThe.setBorder(BorderFactory.createTitledBorder("Nhập địa chỉ cụ thể"));
        giua.add(diaChiCuThe, gbc1);

        // o hien thi san pham
        gbc1.gridy++;

        JPanel danhsach_sp_pn = new JPanel();

        danhsach_sp_pn.setLayout(new BoxLayout(danhsach_sp_pn, BoxLayout.Y_AXIS));
        danhsach_sp_pn.setBackground(Color.WHITE);

        for (int i = 0; i < selectedProducts.size(); i++) {
            sanphamchonmua_DTO temp_medicine = selectedProducts.get(i);

            JPanel rowsp = new JPanel(new GridLayout(1, 3)); // 1 dòng 3 cột bằng nhau
            rowsp.setBorder(new LineBorder(xam, 1));
            rowsp.setPreferredSize(new Dimension(500, 22));

            JLabel tenthuoc = new JLabel("             " + (i + 1) + ")    " + temp_medicine.getTenthuoc(),
                    SwingConstants.LEFT);
            tenthuoc.setFont(new Font("Bookmap", Font.PLAIN, 13));
            JLabel dongia = new JLabel(String.valueOf(temp_medicine.getDonGia()) + " đ", SwingConstants.CENTER);
            dongia.setFont(new Font("Bookmap", Font.BOLD, 12));
            JLabel soluong = new JLabel("x" + temp_medicine.getSoLuong(), SwingConstants.CENTER);
            soluong.setFont(new Font("Arial", Font.BOLD, 12));

            rowsp.add(tenthuoc);
            rowsp.add(dongia);
            rowsp.add(soluong);

            danhsach_sp_pn.add(rowsp);
        }

        JScrollPane scrollPane = new JScrollPane(danhsach_sp_pn);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Panel bao ngoài có kích thước 500x50
        JPanel sp_pn = new JPanel(new BorderLayout());

        sp_pn.setPreferredSize(new Dimension(500, 55));
        sp_pn.setBackground(hong); // Màu nền tùy ý
        sp_pn.add(scrollPane, BorderLayout.CENTER);

        // Thêm vào bố cục chính
        giua.add(sp_pn, gbc1);

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
        customer_DTO khachDangNhap = getKhachHangDangNhap();
        String makh = khachDangNhap.getMakh();
        int sdt = khachDangNhap.getSdt();

        String manv = "1"; // ************ chua sua lailai

        String tennguoinhan = tenNguoiNhan.getText().trim();
        String sdtnguoinhan = sdtNguoiNhan.getText().trim();
        String phuong = "phường 10";
        String quan = quanHuyen.getSelectedItem().toString();
        String tinh = tinhThanh.getSelectedItem().toString();
        String diachicuthe = diaChiCuThe.getText().trim();
        String ghichu = ghiChu.getText().trim();

        String pttt = "";
        if (momoRadio.isSelected()) {
            pttt = momoRadio.getText();
        } else if (cashRadio.isSelected()) {
            pttt = cashRadio.getText();
        } else if (qrRadio.isSelected()) {
            pttt = qrRadio.getText();
        }

        String ngaydat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

        int tongtien = 0;
        ArrayList<String> danhSachSanPham = new ArrayList<>();
        int tongSoLuong = 0;

        for (sanphamchonmua_DTO sp : selectedProducts) {
            int thanhTienSanPham = sp.getDonGia() * sp.getSoLuong();
            tongtien += thanhTienSanPham;
            tongSoLuong += sp.getSoLuong();

            String spString = sp.getTenthuoc() + "      x" + sp.getSoLuong() + "      - "
                    + sp.getDonvi() + "      - " + sp.getDonGia();
            danhSachSanPham.add(spString);
        }

        String madon = orderDAO.taoMaHDMoi();

        String mactdh = "CT_" + madon;

        String tinhtrang = "Chờ xác nhận";

        orderDAO.taodonhangmoi(madon, makh, sdt, manv, tennguoinhan, sdtnguoinhan,
                phuong, quan, tinh, diachicuthe, danhSachSanPham, ngaydat, ghichu, pttt, tongtien, tinhtrang);

        order_details ct = new order_details(
                mactdh,
                madon,
                "",
                danhSachSanPham,
                diachicuthe,
                tongSoLuong,
                tongtien,
                tinhtrang);

        orderDetailsDAO.themChiTietDonHang(ct);

        // Xóa các sản phẩm trong giỏ hàng
        for (sanphamchonmua_DTO sp : selectedProducts) {
            String mathuoc = sp.getMathuoc();
            DAO.cartDAO.xoaSanPhamTrongGio(makh, mathuoc);
        }

        // 11. Thông báo
        JOptionPane.showMessageDialog(null, "Đặt hàng thành công!", "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);

        // 12. Xóa giỏ hàng
        selectedProducts.clear();
    }

    private void updateSummary() {
        int totalAmount = 0; // Tổng tiền
        int totalProducts = 0; // Tổng số sản phẩm

        for (sanphamchonmua_DTO sp : selectedProducts) {
            totalAmount += sp.getDonGia() * sp.getSoLuong(); // Tính tiền từng sản phẩm
            totalProducts += sp.getSoLuong(); // Tính tổng số lượng sản phẩm
        }

        // Cập nhật vào các JLabel
        cost.setText(totalAmount + " đ"); // Hiển thị tổng tiền
        sosp.setText(String.valueOf(totalProducts)); // Hiển thị tổng số sản phẩm
        costreal.setText(totalAmount + " đ"); // Hiển thị thành tiền (nếu cần)
    }

}
