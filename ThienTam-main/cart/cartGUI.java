package cart;

import customer.customer;
import customer.customerGUI;
import dao.cartDAO;
import dao.medicineDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentListener;

import medicine.medicine;
import medicine.medicineArr;

public class cartGUI extends JFrame {
    private JPanel header, tail, body, giua;
    private JLabel title, cost, costreal, costvc, sosp;
    private JButton back;
    private customerGUI khach;
    private customer khachCurrent;
    private medicineArr sanpham;

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
    private cartArr giohang;

    public cartGUI(customerGUI khach, customer khachCurrent) {
        this.khach = khach;
        this.khachCurrent = khachCurrent;
        this.sanpham = new medicineArr(); // Khởi tạo
        this.giohang = new cartArr();
        giohang.readCartDatabase(giohang.getA(), khachCurrent.getMakh());

        customer khachDangnhap = getKhachHangDangNhap();

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

    public customer getKhachHangDangNhap() {
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

        add(header, BorderLayout.NORTH);
    }

    private void create_body() {
        // Panel chính chứa cả body và pay
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER); // Thêm vào frame
        customer khachDangnhap = getKhachHangDangNhap();
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
                System.out.println("Khách hàng trong CartGUI " + khachDangnhap);
                String nametemp = khachDangnhap.getTenkh();
                System.out.println("Khách hàng trong CartGUI: " + nametemp);

                new thanhtoanGUI(khach, cartGUI.this, khachDangnhap);

                dispose();
            }
        });

    }

    private void showSP_incart() {
        giua.removeAll();
        ArrayList<cart> danhsachSPtronggio = giohang.getA();

        for (cart c : danhsachSPtronggio) {
            medicine thuoc = medicineDAO.timThuocTheoMa(c.getMathuoc());

            // Panel chính cho từng dòng
            JPanel spPanel = new JPanel(new GridLayout(1, 4));
            spPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            spPanel.setBorder(BorderFactory.createLineBorder(xam, 5));
            spPanel.setBackground(linen);

            // ==== Cột 1: checkbox + hình ảnh ==== (chiếm 40%)
            JPanel cot1 = new JPanel();
            cot1.setLayout(new BoxLayout(cot1, BoxLayout.X_AXIS));
            cot1.setOpaque(false);

            JRadioButton checkbuy = new JRadioButton();

            JPanel hinhsp = new JPanel();
            hinhsp.setPreferredSize(new Dimension(60, 50));
            hinhsp.setBackground(vang);

            cot1.add(Box.createHorizontalStrut(5));
            cot1.add(checkbuy);
            cot1.add(Box.createHorizontalStrut(10));
            cot1.add(hinhsp);
            cot1.add(Box.createHorizontalGlue());

            checkbuy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateTongTien();
                }
            });

            JPanel cot2 = new JPanel(new GridBagLayout());
            cot2.setOpaque(false);
            JLabel tenThuoc = new JLabel(thuoc.getTenthuoc(), SwingConstants.LEFT);
            tenThuoc.setPreferredSize(new Dimension(220, 50));
            cot2.add(tenThuoc);

            // ==== Cột 3: số lượng ==== (20%)
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

                        // Nếu số lượng thay đổi, thì cập nhật vào database
                        if (newSL != tempSL) {
                            cartDAO dao = new cartDAO();
                            dao.capNhatSoLuong(khachCurrent.getMakh(), c.getMathuoc(), newSL);

                            // Cập nhật lại giỏ hàng trong bộ nhớ
                            giohang.readCartDatabase(giohang.getA(), khachCurrent.getMakh());

                            // Cập nhật giao diện (nếu cần update tổng tiền)
                            showSP_incart();

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ!");
                        soluongnhap.setText(String.valueOf(tempSL));
                    }
                }
            });

            cot3.add(soLuong);
            cot3.add(soluongnhap);

            // ==== Cột 4: đơn giá + thành tiền ==== (20%)
            JPanel cot4 = new JPanel(new GridBagLayout());
            cot4.setOpaque(false);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 0, 5, 0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;

            JLabel donGiaLabel = new JLabel("Đơn giá: " + c.getDongia() + "đ");
            cot4.add(donGiaLabel, gbc);

            // Nút Xóa
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 0, 0); // reset khoảng cách

            ImageIcon icon_delete = new ImageIcon(
                    "D:\\ThienTam-main\\ThienTam-main\\customer\\img_xt\\icons8-waste-40.png");
            Image img_delete = icon_delete.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon delete_btn = new ImageIcon(img_delete);
            JButton xoasp = new JButton(delete_btn);
            xoasp.setBackground(linen);
            xoasp.setPreferredSize(new Dimension(40, 40));

            cot4.add(xoasp, gbc);

            spPanel.add(cot1);
            spPanel.add(cot2);
            spPanel.add(cot3);
            spPanel.add(cot4);

            xoasp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có chắc chắn muốn xoá sản phẩm này khỏi giỏ hàng?",
                            "Xác nhận xoá",
                            JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {
                        // 1. Xoá khỏi cơ sở dữ liệu
                        cartDAO dao = new cartDAO();
                        dao.xoaSanPhamTrongGio(khachCurrent.getMakh(), c.getMathuoc());

                        // 2. Cập nhật lại danh sách trong bộ nhớ từ DB
                        giohang.readCartDatabase(giohang.getA(), khachCurrent.getMakh());

                        // 3. Refresh lại giao diện
                        showSP_incart();
                    }
                }
            });

            giua.add(Box.createRigidArea(new Dimension(0, 10)));
            giua.add(spPanel);
        }

        giua.setPreferredSize(new Dimension(400, danhsachSPtronggio.size() * 90));
        giua.revalidate();
        giua.repaint();
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
                    int dongia = 0;
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

        cost.setText(tongTien + " đ");
        costreal.setText(tongTien + "đ");
        costreal.setFont(new Font("Bookman", Font.PLAIN, 17));
        sosp.setText(Integer.toString(sumsp));

    }

}
