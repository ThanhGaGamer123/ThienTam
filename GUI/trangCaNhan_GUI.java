package GUI;

import DAO.orderDAO;
import DAO.orderDetailsDAO;
import DTO.customer_DTO;
import DTO.order_DTO;
import advanceMethod.advance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class trangCaNhan_GUI extends JFrame {
    private JPanel header, tail, body, tab1_left, tab1_right, tab1_center, tab1_tren, tab1_duoi, tab2_left, tab2_right,
            tab2_center, tab2_tren, tab2_duoi;

    private JLabel title;
    private JButton back;
    private customer_GUI khach;
    private customer_DTO khachCurrent;
    private float chieurong;

    // private String ten; // Thêm biến để lưu tên khách hàng

    // Màu sắc tùy chỉnh
    private static final Color xanhla = new Color(76, 181, 81);
    private static final Color hong = new Color(234, 185, 170);
    private static final Color xam = new Color(207, 207, 207);
    private static final Color linen = new Color(250, 240, 230);
    private static final Color xamnhat = new Color(237, 240, 243);
    private static final Color dodo = new Color(232, 58, 72);

    // public trangCaNhan(customerGUI khach, customer khachCurrent) {

    public trangCaNhan_GUI(customer_GUI khach, customer_DTO khachCurrent) {
        this.khach = khach;
        this.khachCurrent = khachCurrent;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("Cá nhân");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        chieurong = getWidth();
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

        title = new JLabel("THÔNG TIN CÁ NHÂN");
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
        body.setBackground(linen);
        body.setPreferredSize(new Dimension(400, 400));
        body.setLayout(new BorderLayout());
        mainPanel.add(body, BorderLayout.CENTER);

        JTabbedPane tb = new JTabbedPane();
        tb.setPreferredSize(new Dimension(400, 400));

        JPanel tab1 = new JPanel();
        tab1.setBackground(xamnhat);
        tab1.setLayout(new BorderLayout());

        tab1_left = new JPanel();
        tab1_left.setPreferredSize(new Dimension(300, 0));
        tab1_left.setLayout(new GridBagLayout());
        tab1_left.setBackground(xamnhat);
        tab1.add(tab1_left, BorderLayout.WEST);

        tab1_right = new JPanel();
        tab1_right.setPreferredSize(new Dimension((int) (chieurong - 300), 0));
        tab1_right.setLayout(new GridBagLayout());
        tab1_right.setBackground(linen);
        tab1.add(tab1_right, BorderLayout.EAST);

        tab1_center = new JPanel();
        tab1_center.setPreferredSize(new Dimension(0, 0));
        tab1_center.setLayout(new GridBagLayout());
        tab1_center.setBackground(linen);
        tab1.add(tab1_center, BorderLayout.CENTER);

        tab1_tren = new JPanel();
        tab1_tren.setPreferredSize(new Dimension(0, 0));
        tab1_tren.setLayout(new GridBagLayout());
        tab1_tren.setBackground(xam);
        tab1.add(tab1_tren, BorderLayout.NORTH);

        tab1_duoi = new JPanel();
        tab1_duoi.setPreferredSize(new Dimension(0, 0));
        tab1_duoi.setLayout(new GridBagLayout());
        tab1_duoi.setBackground(xam);
        tab1.add(tab1_duoi, BorderLayout.SOUTH);

        create_tab1();
        JPanel tab2 = new JPanel();

        tab2.setBackground(linen);
        tab2.setLayout(new BorderLayout());

        tab2_left = new JPanel();
        tab2_left.setPreferredSize(new Dimension(300, 0));
        tab2_left.setLayout(new GridBagLayout());
        tab2_left.setBackground(xamnhat);
        tab2.add(tab2_left, BorderLayout.WEST);

        tab2_right = new JPanel();
        tab2_right.setPreferredSize(new Dimension((int) (chieurong - 300), 0));
        tab2_right.setLayout(new GridBagLayout());
        tab2_right.setBackground(linen);
        tab2.add(tab2_right, BorderLayout.EAST);

        tab2_center = new JPanel();
        tab2_center.setPreferredSize(new Dimension(0, 0));
        tab2_center.setLayout(new GridBagLayout());
        tab2_center.setBackground(linen);
        tab2.add(tab2_center, BorderLayout.CENTER);

        tab2_tren = new JPanel();
        tab2_tren.setPreferredSize(new Dimension(0, 0));
        tab2_tren.setLayout(new GridBagLayout());
        tab2_tren.setBackground(xam);
        tab2.add(tab2_tren, BorderLayout.NORTH);

        tab2_duoi = new JPanel();
        tab2_duoi.setPreferredSize(new Dimension(0, 0));
        tab2_duoi.setLayout(new GridBagLayout());
        tab2_duoi.setBackground(xam);
        tab2.add(tab2_duoi, BorderLayout.SOUTH);

        create_tab2();

        // Thêm các tab vào JTabbedPane
        tb.addTab("Thông tin cá nhân", tab1);
        tb.addTab("Xem đơn hàng", tab2);
        body.add(tb, BorderLayout.CENTER);
    }

    public void create_tab1() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel tieudekh = new JLabel("THÔNG TIN KHÁCH HÀNG");
        tieudekh.setForeground(dodo);
        tieudekh.setFont(new Font("Bookman", Font.PLAIN, 22));
        gbc.gridy = 0;
        tab1_left.add(tieudekh, gbc);

        JButton ttnd = new JButton("Thông tin");
        ttnd.setBackground(xanhla);
        ttnd.setPreferredSize(new Dimension(220, 50));
        ttnd.setFont(new Font("Bookman", Font.PLAIN, 20));
        ttnd.setForeground(Color.WHITE);
        gbc.gridy = 1;
        tab1_left.add(ttnd, gbc);

        JButton logout_btn = new JButton("Đăng xuất");
        logout_btn.setForeground(Color.WHITE);
        logout_btn.setPreferredSize(new Dimension(220, 50));
        logout_btn.setFont(new Font("Bookman", Font.PLAIN, 20));
        logout_btn.setBackground(xanhla);
        gbc.gridy = 2;
        tab1_left.add(logout_btn, gbc);

        logout_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn đăng xuất không?");
                if (choice == 0) {
                    new login_GUI();
                    dispose();
                }
            }
        });

        // Nhập thông tin khách hàng
        GridBagConstraints gbcc = new GridBagConstraints();
        gbcc.insets = new Insets(0, 0, 20, 0);
        gbcc.gridx = 0;
        gbcc.anchor = GridBagConstraints.CENTER;
        gbcc.fill = GridBagConstraints.HORIZONTAL; // Để các dòng chiếm hết chiều ngang

        // Dòng 1
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line1.setBackground(linen);
        JLabel name = new JLabel("Tên người dùng:");
        name.setPreferredSize(new Dimension(120, 30));
        String namekh = khachCurrent.getTenkh();
        JTextField fillName = new JTextField(namekh);
        fillName.setPreferredSize(new Dimension(300, 30));
        fillName.setFont(new Font("Arial", Font.PLAIN, 18));
        line1.add(name);
        line1.add(fillName);
        gbcc.gridy = 0;
        tab1_right.add(line1, gbcc);

        // Dòng 2
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line2.setBackground(linen);
        JLabel sdtkh = new JLabel("SĐT người dùng:");
        sdtkh.setPreferredSize(new Dimension(120, 30));
        String sdtkhachdangsd = khachCurrent.getSdt();
        JTextField fillsdtkh = new JTextField(sdtkhachdangsd);
        fillsdtkh.setPreferredSize(new Dimension(300, 30));
        fillsdtkh.setFont(new Font("Arial", Font.PLAIN, 18));
        line2.add(sdtkh);
        line2.add(fillsdtkh);
        gbcc.gridy = 1;
        tab1_right.add(line2, gbcc);

        // Dòng 3
        JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        line3.setBackground(linen);
        JLabel email = new JLabel("Email người dùng:");
        email.setPreferredSize(new Dimension(120, 30));
        String email_khach = khachCurrent.getEmail();
        JTextField fillemail = new JTextField(email_khach);
        fillemail.setPreferredSize(new Dimension(300, 30));
        fillemail.setFont(new Font("Arial", Font.PLAIN, 18));
        line3.add(email);
        line3.add(fillemail);
        gbcc.gridy = 2;
        tab1_right.add(line3, gbcc);

        // Dòng 6
        JPanel line6 = new JPanel();
        line6.setBackground(linen);
        JButton edit_in4 = new JButton("Cập nhật thông tin");
        edit_in4.setPreferredSize(new Dimension(320, 50));
        edit_in4.setBackground(xanhla);
        edit_in4.setFont(new Font("Bookman", Font.PLAIN, 20));
        edit_in4.setForeground(Color.white);
        line6.add(edit_in4);
        gbcc.gridy = 3;
        tab1_right.add(line6, gbcc);

        edit_in4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị hộp thoại xác nhận
                int choice = JOptionPane.showConfirmDialog(null, "Xác nhận thay đổi thông tin?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                // Nếu người dùng chọn "Có"
                if (choice == JOptionPane.YES_OPTION) {
                    // Lấy thông tin từ các JTextField
                    String tenkh = fillName.getText();
                    String sdt = String.valueOf(khachCurrent.getSdt());
                    String email = fillemail.getText();
                    String makh = khachCurrent.getMakh();

                    // Kiểm tra dữ liệu hợp lệ
                    if (tenkh.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                        return;
                    }

                    DAO.customerDAO.capNhatThongtinKH(tenkh, sdt, email, makh);
                    JOptionPane.showMessageDialog(null, "Thông tin đã được cập nhật thành công.");
                }
            }
        });
    }

    /*
     * private void create_tab2() {
     * GridBagConstraints gbc = new GridBagConstraints();
     * gbc.insets = new Insets(0, 0, 20, 0);
     * gbc.gridx = 0;
     * gbc.anchor = GridBagConstraints.CENTER;
     * 
     * JLabel tieudekh = new JLabel("ĐƠN HÀNG");
     * tieudekh.setForeground(dodo);
     * tieudekh.setFont(new Font("Bookman", Font.PLAIN, 22));
     * gbc.gridy = 0;
     * tab2_left.add(tieudekh, gbc);
     * 
     * JButton ttnd = new JButton("Thông tin đơn hàng");
     * 
     * ttnd.setBackground(xanhla);
     * ttnd.setPreferredSize(new Dimension(220, 50));
     * ttnd.setFont(new Font("Bookman", Font.PLAIN, 20));
     * 
     * ttnd.setForeground(Color.WHITE);
     * gbc.gridy = 1;
     * tab2_left.add(ttnd, gbc);
     * 
     * JButton tttc = new JButton("Giỏ hàng");
     * tttc.setBackground(xanhla);
     * tttc.setPreferredSize(new Dimension(220, 50));
     * tttc.setFont(new Font("Bookman", Font.PLAIN, 20));
     * tttc.setForeground(Color.WHITE);
     * gbc.gridy = 2;
     * tab2_left.add(tttc, gbc);
     * 
     * tttc.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * new cart_GUI(khach, khachCurrent);
     * dispose();
     * }
     * });
     * ArrayList<order_DTO> danhSachDonHang =
     * orderDAO.layTatCaDonHangTheoKhachHang(khachCurrent.getMakh());
     * orderArr donHangArr = new orderArr(danhSachDonHang);
     * 
     * if (danhSachDonHang.isEmpty()) {
     * JLabel lblEmpty = new JLabel("Bạn chưa có đơn hàng nào.");
     * lblEmpty.setFont(new Font("Bookman", Font.ITALIC, 18));
     * lblEmpty.setForeground(Color.GRAY);
     * tab2_right.add(lblEmpty, gbc);
     * } else {
     * 
     * 
     * JPanel orderDetailsPanel = new JPanel();
     * orderDetailsPanel.setLayout(new GridLayout(0, 1, 10, 10));
     * orderDetailsPanel.setBackground(linen);
     * orderDetailsPanel.setBorder(BorderFactory.createLineBorder(xanhla, 2));
     * 
     * for (order_DTO : danhSachDonHang) {
     * JPanel orderPanel = new JPanel(new GridLayout(1, 4));
     * orderPanel.setBackground(Color.WHITE);
     * orderPanel.setPreferredSize(new Dimension((int) (chieurong - 400), 80));
     * orderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
     * 
     * JLabel orderLabel = new JLabel(" Mã đơn: " + od.getMadon());
     * orderPanel.add(orderLabel);
     * 
     * JLabel ngaydat = new JLabel("Ngày đặt: " + od.getNgaydat());
     * orderPanel.add(ngaydat);
     * 
     * JLabel diachi = new JLabel("Địa chỉ: " + od.getDiachicuthe());
     * orderPanel.add(diachi);
     * 
     * JLabel sotien = new JLabel(("Tổng tiền: " + od.getThanhtien() + " đ"),
     * SwingConstants.CENTER);
     * orderPanel.add(sotien);
     * 
     * orderPanel.addMouseListener(new MouseAdapter() {
     * 
     * @Override
     * public void mouseClicked(MouseEvent e) {
     * // Tạo panel chi tiết
     * JPanel detailPanel = new JPanel(new BorderLayout());
     * detailPanel.setPreferredSize(new Dimension(900, 530));
     * detailPanel.setBackground(hong);
     * detailPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
     * 
     * // Tạo dialog
     * JDialog dialog = new JDialog((JFrame)
     * SwingUtilities.getWindowAncestor(tab2_right),
     * "Chi tiết đơn hàng", true);
     * dialog.setUndecorated(true);
     * dialog.getContentPane().add(detailPanel);
     * dialog.pack();
     * dialog.setLocationRelativeTo(null);
     * 
     * // Tạo nút "Thoát"
     * JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
     * JButton close_btn = new JButton("Thoát");
     * close_btn.setBackground(dodo);
     * close_btn.setFocusPainted(false);
     * topPanel.add(close_btn);
     * detailPanel.add(topPanel, BorderLayout.NORTH);
     * 
     * JPanel duoiPanel = new JPanel();
     * JLabel namelabel = new JLabel("nhathuocthientam@gmail.com.vn");
     * namelabel.setHorizontalAlignment(SwingConstants.CENTER);
     * namelabel.setFont(new Font("Arial", Font.ITALIC, 12));
     * duoiPanel.add(namelabel);
     * duoiPanel.setPreferredSize(new Dimension(0, 30));
     * duoiPanel.setBackground(xanhla);
     * detailPanel.add(duoiPanel, BorderLayout.SOUTH);
     * 
     * JPanel traiPanel = new JPanel();
     * traiPanel.setPreferredSize(new Dimension(0, 0));
     * detailPanel.add(traiPanel, BorderLayout.WEST);
     * 
     * JPanel phaiPanel = new JPanel(new BorderLayout());
     * phaiPanel.setPreferredSize(new Dimension(600, 400));
     * phaiPanel.setBorder(BorderFactory.createTitledBorder(
     * BorderFactory.createLineBorder(xam, 1),
     * "Sản phẩm đã mua",
     * 0,
     * 0,
     * new Font("Bookman", Font.BOLD, 18),
     * Color.BLACK));
     * phaiPanel.setBackground(linen);
     * detailPanel.add(phaiPanel, BorderLayout.EAST);
     * JTextArea sanphamTextArea = new JTextArea();
     * ArrayList<String> sanPhamMuaList = od.getSanphammua();
     * StringBuilder sanPhamMua = new StringBuilder();
     * for (String sanPham : sanPhamMuaList) {
     * sanPhamMua.append(sanPham).append("\n");
     * }
     * sanphamTextArea.setText(sanPhamMua.toString());
     * sanphamTextArea.setEditable(false);
     * sanphamTextArea.setLineWrap(false); // Disable line wrapping
     * sanphamTextArea.setWrapStyleWord(false); // Disable word wrapping
     * sanphamTextArea.setBackground(Color.WHITE);
     * sanphamTextArea.setFont(new Font("Bookman", Font.PLAIN, 16));
     * sanphamTextArea.setMargin(new Insets(10, 10, 10, 10));
     * 
     * // Đưa JTextArea vào JScrollPane
     * JScrollPane scrollPane = new JScrollPane(sanphamTextArea);
     * scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     * scrollPane.setBorder(BorderFactory.createEmptyBorder());
     * phaiPanel.add(scrollPane, BorderLayout.CENTER);
     * 
     * // Panel giữa với GridBagLayout
     * JPanel centerPanel = new JPanel(new GridBagLayout());
     * centerPanel.setPreferredSize(new Dimension(100, 200));
     * centerPanel.setBorder(BorderFactory.createLineBorder(xam, 2));
     * 
     * centerPanel.setBackground(linen);
     * detailPanel.add(centerPanel, BorderLayout.CENTER);
     * 
     * // Cấu hình GridBagConstraints
     * GridBagConstraints gbc = new GridBagConstraints();
     * gbc.fill = GridBagConstraints.HORIZONTAL;
     * gbc.weightx = 1;
     * gbc.insets = new Insets(10, 50, 10, 10);
     * gbc.anchor = GridBagConstraints.CENTER;
     * 
     * gbc.gridx = 0;
     * gbc.gridy = 0;
     * JLabel tieude = new JLabel("HÓA ĐƠN MUA HÀNG", SwingConstants.CENTER);
     * tieude.setFont(new Font("Bookman", Font.PLAIN, 17));
     * tieude.setForeground(dodo);
     * centerPanel.add(tieude, gbc);
     * 
     * gbc.gridy++;
     * centerPanel.add(new JLabel("Người đặt: " + khachCurrent.getTenkh()), gbc);
     * 
     * // Thêm địa chỉ đặt vé
     * gbc.gridy++;
     * centerPanel.add(new JLabel("Địa chỉ: " + od.getDiachicuthe()), gbc);
     * 
     * // Thêm mã đơn
     * gbc.gridy++;
     * centerPanel.add(new JLabel("Mã đơn: " + od.getMadon()), gbc);
     * 
     * // Thêm ngày đặt
     * gbc.gridy++;
     * centerPanel.add(new JLabel("Ngày đặt: " + od.getNgaydat()), gbc);
     * 
     * gbc.gridy++;
     * centerPanel.add(new JLabel("Tổng số sản phẩm : " + od.getSl()), gbc);
     * 
     * gbc.gridy++;
     * centerPanel.add(new JLabel("Tổng hóa đơn : " + od.getThanhtien() + " đ"),
     * gbc);
     * 
     * // Sự kiện cho nút "Thoát"
     * close_btn.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * dialog.dispose();
     * }
     * });
     * 
     * dialog.setVisible(true);
     * }
     * });
     * orderDetailsPanel.add(orderPanel);
     * }
     * 
     * JScrollPane scrollPane = new JScrollPane(orderDetailsPanel);
     * scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     * scrollPane.setHorizontalScrollBarPolicy(JScrollPane.
     * HORIZONTAL_SCROLLBAR_NEVER);
     * scrollPane.setPreferredSize(new Dimension((int) (chieurong - 400), 400));
     * tab2_right.add(scrollPane, gbc);
     * 
     * tab2_right.revalidate();
     * tab2_right.repaint();
     * 
     * }
     * 
     * tab2_right.revalidate();
     * tab2_right.repaint();
     * 
     * }
     */

    // Phương thức hiển thị chi tiết đơn hàng

    // *
    // ArrayList<order_DTO> danhSachDonHang =
    // orderDAO.layTatCaDonHangTheoKhachHang(khachCurrent.getMakh());

    // if (danhSachDonHang.isEmpty()) {
    // JLabel lblEmpty = new JLabel("Bạn chưa có đơn hàng nào.");
    // lblEmpty.setFont(new Font("Bookman", Font.ITALIC, 18));
    // lblEmpty.setForeground(Color.GRAY);
    // tab2_right.add(lblEmpty, gbc);
    // } else { *//

    // private void create_tab2() {
    // GridBagConstraints gbc = new GridBagConstraints();
    // gbc.insets = new Insets(0, 0, 20, 0);
    // gbc.gridx = 0;
    // gbc.anchor = GridBagConstraints.CENTER;

    // JLabel tieudekh = new JLabel("ĐƠN HÀNG");
    // tieudekh.setForeground(dodo);
    // tieudekh.setFont(new Font("Bookman", Font.PLAIN, 22));
    // gbc.gridy = 0;
    // tab2_left.add(tieudekh, gbc);

    // JButton ttnd = new JButton("Thông tin đơn hàng");
    // ttnd.setBackground(xanhla);
    // ttnd.setPreferredSize(new Dimension(220, 50));
    // ttnd.setFont(new Font("Bookman", Font.PLAIN, 20));
    // ttnd.setForeground(Color.WHITE);
    // gbc.gridy = 1;
    // tab2_left.add(ttnd, gbc);

    // JButton tttc = new JButton("Giỏ hàng");
    // tttc.setBackground(xanhla);
    // tttc.setPreferredSize(new Dimension(220, 50));
    // tttc.setFont(new Font("Bookman", Font.PLAIN, 20));
    // tttc.setForeground(Color.WHITE);
    // gbc.gridy = 2;
    // tab2_left.add(tttc, gbc);

    // tttc.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // new cart_GUI(khach, khachCurrent);
    // dispose();
    // }
    // });

    // ArrayList<order_DTO> danhSachDonHang =
    // orderDAO.layTatCaDonHangTheoKhachHang(khachCurrent.getMakh());

    // if (danhSachDonHang.isEmpty()) {
    // JLabel lblEmpty = new JLabel("Bạn chưa có đơn hàng nào.");
    // lblEmpty.setFont(new Font("Bookman", Font.ITALIC, 18));
    // lblEmpty.setForeground(Color.GRAY);
    // tab2_right.add(lblEmpty, gbc);
    // } else {
    // JPanel orderDetailsPanel = new JPanel();
    // orderDetailsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    // orderDetailsPanel.setBackground(linen);
    // orderDetailsPanel.setBorder(BorderFactory.createLineBorder(xanhla, 2));

    // for (order_DTO od : danhSachDonHang) {
    // JPanel orderPanel = new JPanel(new GridLayout(1, 4));
    // orderPanel.setBackground(Color.WHITE);
    // orderPanel.setPreferredSize(new Dimension((int) (chieurong - 400), 80));
    // orderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    // JLabel orderLabel = new JLabel(" Mã đơn: " + od.getMadon());
    // orderPanel.add(orderLabel);

    // JLabel ngaydat = new JLabel("Ngày đặt: " + od.getNgaydat());
    // orderPanel.add(ngaydat);

    // JLabel diachi = new JLabel("Địa chỉ: " + od.getDiachicuthe());
    // orderPanel.add(diachi);

    // JLabel sotien = new JLabel("Tổng tiền: " + od.getTongtien() + " đ",
    // SwingConstants.LEFT);
    // orderPanel.add(sotien);

    // orderPanel.addMouseListener(new MouseAdapter() {
    // @Override
    // public void mouseClicked(MouseEvent e) {
    // // Tạo panel chi tiết
    // JPanel detailPanel = new JPanel(new BorderLayout());
    // detailPanel.setPreferredSize(new Dimension(900, 530));
    // detailPanel.setBackground(hong);
    // detailPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

    // // Tạo dialog
    // JDialog dialog = new JDialog((JFrame)
    // SwingUtilities.getWindowAncestor(tab2_right),
    // "Chi tiết đơn hàng", true);
    // dialog.setUndecorated(true);
    // dialog.getContentPane().add(detailPanel);
    // dialog.pack();
    // dialog.setLocationRelativeTo(null);

    // // Tạo nút "Thoát"
    // JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    // JButton close_btn = new JButton("Thoát");
    // close_btn.setBackground(dodo);
    // close_btn.setFocusPainted(false);
    // topPanel.add(close_btn);
    // detailPanel.add(topPanel, BorderLayout.NORTH);

    // JPanel duoiPanel = new JPanel();
    // JLabel namelabel = new JLabel("nhathuocthientam@gmail.com.vn");
    // namelabel.setHorizontalAlignment(SwingConstants.CENTER);
    // namelabel.setFont(new Font("Arial", Font.ITALIC, 12));
    // duoiPanel.add(namelabel);
    // duoiPanel.setPreferredSize(new Dimension(0, 30));
    // duoiPanel.setBackground(xanhla);
    // detailPanel.add(duoiPanel, BorderLayout.SOUTH);

    // JPanel traiPanel = new JPanel();
    // traiPanel.setPreferredSize(new Dimension(0, 0));
    // detailPanel.add(traiPanel, BorderLayout.WEST);

    // JPanel phaiPanel = new JPanel(new BorderLayout());
    // phaiPanel.setPreferredSize(new Dimension(600, 400));
    // phaiPanel.setBorder(BorderFactory.createTitledBorder(
    // BorderFactory.createLineBorder(xam, 1),
    // "Sản phẩm đã mua",
    // 0,
    // 0,
    // new Font("Bookman", Font.BOLD, 18),
    // Color.BLACK));
    // phaiPanel.setBackground(linen);
    // detailPanel.add(phaiPanel, BorderLayout.EAST);
    // JPanel sanphammua = new JPanel();

    // // Đưa JTextArea vào JScrollPane
    // // JScrollPane scrollPane = new JScrollPane(sanphamTextArea);
    // //
    // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    // // scrollPane.setBorder(BorderFactory.createEmptyBorder());
    // phaiPanel.add(sanphammua, BorderLayout.CENTER);

    // DefaultTableModel model = new DefaultTableModel();
    // model.addColumn("Tên Sản Phẩm");
    // model.addColumn("Số Lượng Mua");
    // model.addColumn("Đơn Giá");
    // model.addColumn("Thành Tiền");

    // // Tạo JTable
    // JTable table = new JTable(model);
    // JScrollPane tableScroll = new JScrollPane(table);
    // sanphammua.add(tableScroll); // Thêm JTable vào sanphammua

    // // Lấy chi tiết đơn hàng từ DAO
    // orderDetailsDAO.hienThiChiTietDonHang(od.getMadon(), model);

    // ArrayList<order_details_DTO> chiTietDonHang = orderDetailsDAO
    // .layChiTietDonHangTheoMaDon(od.getMadon());
    // for (order_details_DTO ct : chiTietDonHang) {
    // model.addRow(new Object[] {
    // ct.getMadon(), // <-- cái này là lỗi (bạn không muốn dùng field tenSanPham
    // nữa)
    // ct.getSl(),
    // ct.getDongia(),
    // ct.getThanhtien()
    // });
    // }

    // // Panel giữa với GridBagLayout
    // JPanel centerPanel = new JPanel(new GridBagLayout());
    // centerPanel.setPreferredSize(new Dimension(100, 200));
    // centerPanel.setBorder(BorderFactory.createLineBorder(xam, 2));

    // centerPanel.setBackground(linen);
    // detailPanel.add(centerPanel, BorderLayout.CENTER);

    // // Cấu hình GridBagConstraints
    // GridBagConstraints gbc = new GridBagConstraints();
    // gbc.fill = GridBagConstraints.HORIZONTAL;
    // gbc.weightx = 1;
    // gbc.insets = new Insets(10, 50, 10, 10);
    // gbc.anchor = GridBagConstraints.CENTER;

    // gbc.gridx = 0;
    // gbc.gridy = 0;
    // JLabel tieude = new JLabel("HÓA ĐƠN MUA HÀNG", SwingConstants.CENTER);
    // tieude.setFont(new Font("Bookman", Font.PLAIN, 17));
    // tieude.setForeground(dodo);
    // centerPanel.add(tieude, gbc);

    // gbc.gridy++;
    // centerPanel.add(new JLabel("Người đặt: " + khachCurrent.getTenkh()), gbc);

    // // Thêm địa chỉ đặt vé
    // gbc.gridy++;
    // centerPanel.add(new JLabel("Địa chỉ: " + od.getDiachicuthe()), gbc);

    // // Thêm mã đơn
    // gbc.gridy++;
    // centerPanel.add(new JLabel("Mã đơn: " + od.getMadon()), gbc);

    // // Thêm ngày đặt
    // gbc.gridy++;
    // centerPanel.add(new JLabel("Ngày đặt: " + od.getNgaydat()), gbc);

    // gbc.gridy++;
    // // centerPanel.add(new JLabel("Tổng số sản phẩm: " + od.getSl()), gbc);

    // gbc.gridy++;
    // // centerPanel.add(new JLabel("Tổng hóa đơn: " + od.getThanhtien() + " đ"),
    // // gbc);

    // // Sự kiện cho nút "Thoát"
    // close_btn.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // dialog.dispose();
    // }
    // });

    // dialog.setVisible(true);
    // }
    // });
    // orderDetailsPanel.add(orderPanel);
    // }

    // JScrollPane scrollPane = new JScrollPane(orderDetailsPanel);
    // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    // scrollPane.setPreferredSize(new Dimension((int) (chieurong - 400), 400)); //
    // Điều chỉnh kích thước

    // tab2_right.add(scrollPane, gbc);

    // tab2_right.revalidate();
    // tab2_right.repaint();
    // }

    // tab2_right.revalidate();
    // tab2_right.repaint();
    // }

    private void create_tab2() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel tieudekh = new JLabel("ĐƠN HÀNG");
        tieudekh.setForeground(dodo);
        tieudekh.setFont(new Font("Bookman", Font.PLAIN, 22));
        gbc.gridy = 0;
        tab2_left.add(tieudekh, gbc);

        JButton ttnd = new JButton("Thông tin đơn hàng");
        ttnd.setBackground(xanhla);
        ttnd.setPreferredSize(new Dimension(220, 50));
        ttnd.setFont(new Font("Bookman", Font.PLAIN, 20));
        ttnd.setForeground(Color.WHITE);
        gbc.gridy = 1;
        tab2_left.add(ttnd, gbc);

        JButton tttc = new JButton("Giỏ hàng");
        tttc.setBackground(xanhla);
        tttc.setPreferredSize(new Dimension(220, 50));
        tttc.setFont(new Font("Bookman", Font.PLAIN, 20));
        tttc.setForeground(Color.WHITE);
        gbc.gridy = 2;
        tab2_left.add(tttc, gbc);

        tttc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cart_GUI(khach, khachCurrent);
                dispose();
            }
        });

        ArrayList<order_DTO> danhSachDonHang = orderDAO.layTatCaDonHangTheoKhachHang(khachCurrent.getMakh());

        if (danhSachDonHang.isEmpty()) {
            JLabel lblEmpty = new JLabel("Bạn chưa có đơn hàng nào.");
            lblEmpty.setFont(new Font("Bookman", Font.ITALIC, 18));
            lblEmpty.setForeground(Color.GRAY);
            tab2_right.add(lblEmpty, gbc);
        } else {
            JPanel orderDetailsPanel = new JPanel();
            orderDetailsPanel.setLayout(new GridLayout(0, 1, 10, 10));
            orderDetailsPanel.setBackground(linen);
            orderDetailsPanel.setBorder(BorderFactory.createLineBorder(xanhla, 2));

            for (order_DTO od : danhSachDonHang) {
                JPanel orderPanel = new JPanel(new GridLayout(1, 4));
                orderPanel.setBackground(Color.WHITE);
                orderPanel.setPreferredSize(new Dimension((int) (chieurong - 400), 80));
                orderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                JLabel orderLabel = new JLabel("        Mã đơn: " + od.getMadon());
                orderPanel.add(orderLabel);

                JLabel ngaydat = new JLabel("Ngày đặt: " + od.getNgaydat());
                orderPanel.add(ngaydat);

                JLabel diachi = new JLabel("Địa chỉ: " + od.getDiachicuthe());
                orderPanel.add(diachi);

                JLabel sotien = new JLabel("Tổng tiền: " + od.getTongtien() + " đ", SwingConstants.LEFT);
                orderPanel.add(sotien);

                orderPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // Tạo panel chi tiết
                        JPanel detailPanel = new JPanel(new BorderLayout());
                        detailPanel.setPreferredSize(new Dimension(900, 530));
                        detailPanel.setBackground(hong);
                        detailPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

                        // Tạo dialog
                        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(tab2_right),
                                "Chi tiết đơn hàng", true);
                        dialog.setUndecorated(true);
                        dialog.getContentPane().add(detailPanel);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);

                        // Tạo nút "Thoát"
                        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JButton close_btn = new JButton("Thoát");
                        close_btn.setBackground(dodo);
                        close_btn.setFocusPainted(false);
                        topPanel.add(close_btn);
                        detailPanel.add(topPanel, BorderLayout.NORTH);

                        // Panel dưới
                        JPanel duoiPanel = new JPanel();
                        JLabel namelabel = new JLabel("nhathuocthientam@gmail.com.vn");
                        namelabel.setHorizontalAlignment(SwingConstants.CENTER);
                        namelabel.setFont(new Font("Arial", Font.ITALIC, 12));
                        duoiPanel.add(namelabel);
                        duoiPanel.setPreferredSize(new Dimension(0, 30));
                        duoiPanel.setBackground(xanhla);
                        detailPanel.add(duoiPanel, BorderLayout.SOUTH);

                        JPanel traiPanel = new JPanel();
                        traiPanel.setPreferredSize(new Dimension(0, 0));
                        detailPanel.add(traiPanel, BorderLayout.WEST);

                        // Bảng chi tiết sản phẩm
                        JPanel phaiPanel = new JPanel(new BorderLayout());
                        phaiPanel.setPreferredSize(new Dimension(600, 400));
                        phaiPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(xam, 1),
                                "Sản phẩm đã mua", 0, 0, new Font("Bookman", Font.BOLD, 18), Color.BLACK));
                        phaiPanel.setBackground(linen);
                        detailPanel.add(phaiPanel, BorderLayout.EAST);
                        JPanel sanphammua = new JPanel();
                        sanphammua.setPreferredSize(new Dimension(phaiPanel.getWidth(), 100));

                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Tên Sản Phẩm");
                        model.addColumn("Số Lượng Mua");
                        model.addColumn("Đơn vị");
                        model.addColumn("Đơn Giá");
                        model.addColumn("Thành Tiền");

                        JTable table = new JTable(model);
                        // table.setPreferredSize(new Dimension(sanphammua.getWidth(), 200));
                        JScrollPane tableScroll = new JScrollPane(table);
                        sanphammua.add(tableScroll); // Thêm JTable vào sanphammua

                        // Lấy chi tiết đơn hàng từ DAO
                        orderDetailsDAO.hienThiChiTietDonHang(od.getMadon(), model);

                        phaiPanel.add(tableScroll, BorderLayout.CENTER);

                        // Panel giữa với GridBagLayout
                        JPanel centerPanel = new JPanel(new GridBagLayout());
                        centerPanel.setPreferredSize(new Dimension(100, 200));
                        centerPanel.setBorder(BorderFactory.createLineBorder(xam, 2));
                        centerPanel.setBackground(linen);
                        detailPanel.add(centerPanel, BorderLayout.CENTER);

                        // Cấu hình GridBagConstraints
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        gbc.weightx = 1;
                        gbc.insets = new Insets(10, 50, 10, 10);
                        gbc.anchor = GridBagConstraints.CENTER;

                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        JLabel tieude = new JLabel("HÓA ĐƠN MUA HÀNG", SwingConstants.CENTER);
                        tieude.setFont(new Font("Bookman", Font.PLAIN, 17));
                        tieude.setForeground(dodo);
                        centerPanel.add(tieude, gbc);

                        gbc.gridy++;
                        centerPanel.add(new JLabel("Người đặt: " + khachCurrent.getTenkh()), gbc);

                        gbc.gridy++;
                        centerPanel.add(new JLabel("Địa chỉ: " + od.getDiachicuthe() + "," + od.getQuan()), gbc);

                        gbc.gridy++;
                        centerPanel.add(new JLabel("Mã đơn: " + od.getMadon()), gbc);

                        gbc.gridy++;
                        centerPanel.add(new JLabel("Ngày đặt: " + od.getNgaydat()), gbc);

                        gbc.gridy++;
                        centerPanel.add(new JLabel(od.getPttt()), gbc);

                        gbc.gridy++;
                        centerPanel.add(new JLabel("Tổng tiền: " + od.getTongtien()), gbc);

                        // Sự kiện cho nút "Thoát"
                        close_btn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialog.dispose();
                            }
                        });

                        dialog.setVisible(true);
                    }
                });
                orderDetailsPanel.add(orderPanel);
            }

            JScrollPane scrollPane = new JScrollPane(orderDetailsPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setPreferredSize(new Dimension((int) (chieurong - 400), 400)); // Điều chỉnh kích thước
            scrollPane.getVerticalScrollBar().setUnitIncrement(18);

            tab2_right.add(scrollPane, gbc);

            tab2_right.revalidate();
            tab2_right.repaint();
        }

        tab2_right.revalidate();
        tab2_right.repaint();
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
