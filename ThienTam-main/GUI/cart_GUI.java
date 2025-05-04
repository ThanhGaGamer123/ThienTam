package GUI;

import DAO.cartDAO;
import DAO.medicineDAO;
import DTO.cart_DTO;
import DTO.customer_DTO;
import DTO.medicine_DTO;
import DTO.sanphamchonmua_DTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;

import Arr_xt.cartArr;
import Arr_xt.medicineArr;

public class cart_GUI extends JFrame {
    private JPanel header, tail, body, giua;
    private JLabel title, cost, costreal, costvc, sosp;
    private JButton back;
    // public JRadioButton checkbuy;
    private customer_GUI khach;
    private customer_DTO khachCurrent;
    private medicineArr sanpham;

    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color xanhla_btn = new Color(48, 156, 62);
    private static final Color xanhbien = new Color(27, 101, 197);
    private static final Color vang = new Color(252, 212, 59);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color xam = new Color(207, 207, 207);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xamnhat = new Color(237, 240, 243);
    private static final Color dodo = new Color(232, 58, 72);
    private cartArr giohang;
    private ArrayList<sanphamchonmua_DTO> selectedProducts = new ArrayList<>();
    private ArrayList<JRadioButton> checkboxes = new ArrayList<>();

    private double dongia;

    public cart_GUI(customer_GUI khach, customer_DTO khachCurrent) {
        this.khach = khach;
        this.khachCurrent = khachCurrent;
        this.sanpham = new medicineArr();
        this.giohang = new cartArr();
        giohang.readCartDatabase(khachCurrent.getMakh());

        customer_DTO khachDangnhap = getKhachHangDangNhap();

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

    public customer_DTO getKhachHangDangNhap() {
        return this.khachCurrent;
    }

    private void create_header() {
        header = new JPanel();
        header.setBackground(xanhla);
        header.setPreferredSize(new Dimension(0, 100));
        header.setLayout(null);

        title = new JLabel("GIỎ HÀNG");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(600, 30, 300, 40);
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
        customer_DTO khachDangnhap = getKhachHangDangNhap();
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
        giua.setLayout(new BoxLayout(giua, BoxLayout.Y_AXIS));
        giua.setBackground(xamnhat);
        giua.setAlignmentY(Component.TOP_ALIGNMENT);

        giua.setPreferredSize(new Dimension(400, 0));

        // Gói giua vào scroll pane
        JScrollPane scrollPane = new JScrollPane(giua);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        body.add(scrollPane, BorderLayout.CENTER);

        showSP_incart();

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

        mainPanel.add(pay, BorderLayout.EAST);
        // THANH TOÁN (Tiêu đề)
        JLabel paid = new JLabel("MUA HÀNG", SwingConstants.CENTER);
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
        costreal.setFont(new Font("Arial", Font.PLAIN, 14));
        thanhtienPanel.add(thantienthantien);
        thanhtienPanel.add(costreal);
        gbc2.gridy = 4;
        pay.add(thanhtienPanel, gbc2);

        // Nút mua hàng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(xamnhat);
        JButton thanhtoan_btn = new JButton("MUA HÀNG");
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
                System.out.println("Khách hàng trong CartGUI: " + khachDangnhap);
                String nametemp = khachDangnhap.getTenkh();
                System.out.println("Khách hàng trong CartGUI: " + nametemp);

                if (selectedProducts.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất một sản phẩm để thanh toán.");
                    return;
                }

                System.out.println("Các sản phẩm đã chọn để thanh toán:");
                for (sanphamchonmua_DTO product : selectedProducts) {
                    System.out.println("Mã thuốc: " + product.getMathuoc() +
                            ", Tên thuốc: " + product.getTenthuoc() +
                            ", Số lượng: " + product.getSoLuong());
                }

                new thanhtoan_GUI(khach, cart_GUI.this, khachDangnhap, selectedProducts);

                dispose();
            }
        });

    }

    private void showSP_incart() {
        // refreshCart(khachCurrent.getMakh());

        giua.removeAll(); // Xóa tất cả các thành phần hiện có trong panel giua
        checkboxes.clear(); // Xóa danh sách checkboxes đã chọn
        ArrayList<cart_DTO> danhsachSPtronggio = giohang.getA(); // Lấy danh sách sản phẩm từ giỏ hàng
        System.out.println("Số sản phẩm trong giỏ: " + danhsachSPtronggio.size());

        JPanel pn_contain_btn = new JPanel();
        pn_contain_btn.setLayout(new BoxLayout(pn_contain_btn, BoxLayout.X_AXIS));
        pn_contain_btn.setBackground(linen);

        Dimension fixedSize = new Dimension(Integer.MAX_VALUE, 20);
        pn_contain_btn.setPreferredSize(fixedSize);
        pn_contain_btn.setMaximumSize(fixedSize);
        pn_contain_btn.setMinimumSize(new Dimension(0, 20));

        // Chỉ hiển thị nút "Chọn tất cả" nếu giỏ hàng không rỗng
        if (!danhsachSPtronggio.isEmpty()) {
            // showSP_incart();
            JPanel nutChonTatCa = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 1));
            JButton select_all_btn = new JButton("Chọn tất cả");
            select_all_btn.setBackground(hong);
            select_all_btn.setForeground(Color.black);
            select_all_btn.setFont(new Font("Bookman", Font.BOLD, 12));
            select_all_btn.setBorder(BorderFactory.createLineBorder(xanhla, 1));
            select_all_btn.setPreferredSize(new Dimension(140, 18));
            select_all_btn.setFocusPainted(false);

            select_all_btn.setFocusable(false);
            nutChonTatCa.add(select_all_btn);
            pn_contain_btn.add(nutChonTatCa);
            giua.add(pn_contain_btn);

            // Thêm hiệu ứng hover cho nút "Chọn tất cả"
            select_all_btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    select_all_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    select_all_btn.setBorder(BorderFactory.createLineBorder(hong, 2));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    select_all_btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    select_all_btn.setBorder(BorderFactory.createLineBorder(xanhla, 1));
                }
            });

            // Duyệt qua danh sách sản phẩm trong giỏ hàng
            for (cart_DTO c : danhsachSPtronggio) {
                medicine_DTO thuoc = medicineDAO.timThuocTheoMa(c.getMathuoc());

                // Tạo panel cho từng sản phẩm
                JPanel spPanel = new JPanel(new GridLayout(1, 4));
                spPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
                spPanel.setBorder(BorderFactory.createLineBorder(xam, 5));
                spPanel.setBackground(linen);

                // ---- Cột 1: Checkbox + Hình ảnh ----
                JPanel cot1 = new JPanel();
                cot1.setLayout(new BoxLayout(cot1, BoxLayout.X_AXIS));
                cot1.setOpaque(false);

                JRadioButton checkbuy = new JRadioButton();
                checkboxes.add(checkbuy);

                checkbuy.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        checkbuy.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        checkbuy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
                    }
                });

                JPanel hinhsp = new JPanel();
                hinhsp.setPreferredSize(new Dimension(60, 50));
                hinhsp.setBackground(vang);

                cot1.add(Box.createHorizontalStrut(5));
                cot1.add(checkbuy);
                cot1.add(Box.createHorizontalStrut(10));
                cot1.add(hinhsp);
                cot1.add(Box.createHorizontalGlue());

                // Sự kiện cho checkbox
                checkbuy.addActionListener(e -> {
                    if (checkbuy.isSelected()) {
                        selectedProducts.add(new sanphamchonmua_DTO(
                                c.getMathuoc(),
                                thuoc.getTenthuoc(),
                                c.getSl(),
                                String.join(", ", thuoc.getDonvi()),
                                (int) c.getDongia()));
                    } else {
                        selectedProducts.removeIf(product -> product.getMathuoc().equals(c.getMathuoc()));
                    }
                    updateTongTien(); // Cập nhật tổng tiền
                });

                // ---- Cột 2: Tên thuốc ----
                JPanel cot2 = new JPanel(new GridBagLayout());
                cot2.setOpaque(false);
                JLabel tenThuoc = new JLabel(thuoc.getTenthuoc(), SwingConstants.LEFT);
                tenThuoc.setPreferredSize(new Dimension(220, 50));
                cot2.add(tenThuoc);

                // ---- Cột 3: Số lượng ----
                JPanel cot3 = new JPanel(new GridBagLayout());
                JLabel soLuong = new JLabel("Số lượng: ");
                int tempSL = c.getSl();
                JTextField soluongnhap = new JTextField(Integer.toString(tempSL), SwingConstants.CENTER);
                soluongnhap.setPreferredSize(new Dimension(40, 30));
                soluongnhap.setForeground(Color.BLACK);
                soluongnhap.setFont(new Font("Bookman", Font.PLAIN, 15));

                soluongnhap.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        try {
                            int newSL = Integer.parseInt(soluongnhap.getText());
                            if (newSL <= 0) {
                                JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0.");
                                soluongnhap.setText(String.valueOf(tempSL));
                                return;
                            }

                            // Cập nhật số lượng vào cơ sở dữ liệu
                            if (newSL != tempSL) {
                                cartDAO dao = new cartDAO();
                                dao.capNhatSoLuong(khachCurrent.getMakh(), c.getMathuoc(), newSL);

                                giohang.readCartDatabase(khachCurrent.getMakh());
                                updateTongTien();
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ!");
                            soluongnhap.setText(String.valueOf(tempSL));
                        }
                    }
                });

                cot3.add(soLuong);
                cot3.add(soluongnhap);

                // ---- Cột 4: Đơn giá + Nút xóa ----
                JPanel cot4 = new JPanel(new GridBagLayout());
                cot4.setOpaque(false);

                NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
                nf.setMaximumFractionDigits(2);

                String formattedNumber = nf.format(c.getDongia());
                String formattedPrice = (c.getDongia() % 1 == 0)
                        ? String.format("Đơn giá: %sđ", nf.format((long) c.getDongia()))

                        : String.format("Đơn giá: %sđ", formattedNumber);

                JLabel donGiaLabel = new JLabel(formattedPrice);
                cot4.add(donGiaLabel);

                // Nút xóa
                ImageIcon icon_delete = new ImageIcon(
                        "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-waste-40.png");
                Image img_delete = icon_delete.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon delete_btn = new ImageIcon(img_delete);
                JButton xoasp = new JButton(delete_btn);
                xoasp.setBackground(linen);
                xoasp.setPreferredSize(new Dimension(40, 40));
                cot4.add(xoasp);

                // Sự kiện cho nút xóa
                xoasp.addActionListener(e -> {
                    int result = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn xoá sản phẩm này khỏi giỏ hàng?",
                            "Xác nhận xoá",
                            JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {
                        cartDAO dao = new cartDAO();
                        dao.xoaSanPhamTrongGio(khachCurrent.getMakh(), c.getMathuoc());
                        selectedProducts.removeIf(product -> product.getMathuoc().equals(c.getMathuoc()));
                        giohang.readCartDatabase(khachCurrent.getMakh());
                        if (giohang.getA().isEmpty()) {
                            System.out.println("Giỏ hàng đã trống.");
                        }

                        showSP_incart(); // Refresh giao diện
                        updateTongTien();
                        refreshCart(khachCurrent.getMakh());
                    }
                });

                xoasp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        back.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Chuyển thành bàn tay
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Trở về mặc định
                    }
                });

                // Thêm các cột vào spPanel
                spPanel.add(cot1);
                spPanel.add(cot2);
                spPanel.add(cot3);
                spPanel.add(cot4);

                giua.add(Box.createRigidArea(new Dimension(0, 10)));
                giua.add(spPanel);
            }

            // Xử lý chọn tất cả
            boolean[] allSelected = { false }; // Dùng mảng để cho phép thay đổi bên trong listener
            select_all_btn.addActionListener(e -> {
                allSelected[0] = !allSelected[0]; // Đảo trạng thái

                for (int i = 0; i < checkboxes.size(); i++) {
                    JRadioButton checkbox = checkboxes.get(i);
                    checkbox.setSelected(allSelected[0]);

                    cart_DTO c = danhsachSPtronggio.get(i);
                    medicine_DTO thuoc = medicineDAO.timThuocTheoMa(c.getMathuoc());

                    if (allSelected[0]) {
                        selectedProducts.add(new sanphamchonmua_DTO(
                                c.getMathuoc(),
                                thuoc.getTenthuoc(),
                                c.getSl(),
                                String.join(", ", thuoc.getDonvi()),
                                (int) c.getDongia()));
                    } else {
                        selectedProducts.removeIf(product -> product.getMathuoc().equals(c.getMathuoc()));
                    }
                }

                updateTongTien();

                if (allSelected[0]) {
                    select_all_btn.setText("Bỏ chọn tất cả");
                    select_all_btn.setPreferredSize(new Dimension(180, 18));
                } else {
                    select_all_btn.setText("Chọn tất cả");
                    select_all_btn.setPreferredSize(new Dimension(120, 18));
                }
            });

            giua.setPreferredSize(new Dimension(400, danhsachSPtronggio.size() * 90));
            giua.revalidate(); // Cập nhật lại giao diện
            giua.repaint();
        } else {
            JLabel emptyCartLabel = new JLabel("Giỏ hàng của bạn đang trống.", SwingConstants.CENTER);
            emptyCartLabel.setFont(new Font("Bookman", Font.ITALIC, 16));
            emptyCartLabel.setForeground(Color.GRAY);
            giua.add(emptyCartLabel);
        }
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

    private void updateTongTien() {
        int tongTien = 0;

        int sumsp = 0;

        Component[] components = giua.getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel spPanel) {
                Component[] columns = spPanel.getComponents();
                if (columns.length == 4) {
                    JPanel cot1 = (JPanel) columns[0];
                    JPanel cot3 = (JPanel) columns[2];
                    JPanel cot4 = (JPanel) columns[3];

                    // Lấy checkbox
                    JRadioButton checkbox = null;
                    for (Component child : cot1.getComponents()) {
                        if (child instanceof JRadioButton cb) {
                            checkbox = cb;
                            break;
                        }
                    }

                    // Lấy số lượng từ JTextField
                    JTextField soluongField = null;
                    for (Component child : cot3.getComponents()) {
                        if (child instanceof JTextField tf) {
                            soluongField = tf;
                            break;
                        }
                    }

                    // Lấy đơn giá từ JLabel
                    dongia = 0;
                    for (Component child : cot4.getComponents()) {
                        if (child instanceof JLabel label && label.getText().startsWith("Đơn giá: ")) {
                            String text = label.getText().replaceAll("[^0-9]", "");
                            if (!text.isEmpty())
                                dongia = Integer.parseInt(text);
                            break;
                        }
                    }

                    // Nếu checkbox được chọn -> tính tiền
                    if (checkbox != null && checkbox.isSelected() && soluongField != null) {
                        try {
                            int sl = Integer.parseInt(soluongField.getText());
                            tongTien += sl * dongia;
                            sumsp += sl;
                        } catch (NumberFormatException ex) {
                            // Bỏ qua nếu người dùng nhập không hợp lệ
                        }
                    }
                }
            }
        }

        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        nf.setMaximumFractionDigits(2); // Tối đa 2 chữ số sau dấu phẩy

        String formattedTongTien = (tongTien % 1 == 0)
                ? nf.format((long) tongTien)
                : nf.format(tongTien);

        cost.setText(formattedTongTien + " đ");
        costreal.setText(formattedTongTien + "đ");
        costreal.setFont(new Font("Bookman", Font.PLAIN, 17));
        sosp.setText(Integer.toString(sumsp));

    }

    public void refreshCart(String makh) {
        giohang.readCartDatabase(makh);
        showSP_incart();
    }
}
