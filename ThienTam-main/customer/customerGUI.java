package customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class customerGUI extends JFrame implements MouseListener, ActionListener {
    JLabel logoLabel, title, hotline, sdt;
    JPanel p1, p2, p0, p3, cartPanel;
    JTextField ten, timkiem;
    JScrollPane scr;
    JButton search, cart, omega, canxi, tnm, ddvs, siro;

    public customerGUI() {
        create();
    }

    public void create() {
        // Thiết lập JFrame
        setTitle("Customer");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tạo JPanel chứa toàn bộ nội dung (để cuộn)
        p0 = new JPanel();
        p0.setLayout(null);
        p0.setPreferredSize(new Dimension(1280, 1500)); // Cao hơn JFrame để có thể cuộn

        // Tạo JPanel header
        p1 = new JPanel();
        p1.setBounds(0, 0, 1280, 100);
        p1.setBackground(new Color(1, 147, 103));
        p1.setLayout(null);
        p0.add(p1);

        // Tạo tiêu đề
        title = new JLabel("NHÀ THUỐC THIỆN TÂM");
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setBounds(380, 30, 500, 40);
        p1.add(title);

        // Tạo JPanel thứ hai
        p2 = new JPanel();
        p2.setBounds(0, 100, 1280, 80);
        p2.setBackground(Color.blue);
        p2.setLayout(null);
        p0.add(p2);

        timkiem = new JTextField();
        timkiem.setBounds(88, 20, 610, 40);
        timkiem.setToolTipText("");
        p2.add(timkiem);

        search = new JButton("TÌM KIẾM");
        search.setBounds(750, 20, 100, 40);
        p2.add(search);

        cart = new JButton("GIỎ HÀNG");
        cart.setBounds(900, 20, 100, 40);
        cart.addActionListener(this);
        p2.add(cart);

        hotline = new JLabel("Hotline (8:00 - 21:30)");
        hotline.setBounds(1080, 20, 150, 14);
        hotline.setFont(new Font("Ariel", Font.BOLD, 14));
        hotline.setForeground(Color.WHITE);
        p2.add(hotline);

        sdt = new JLabel("1900 1572");
        sdt.setBounds(1080, 40, 150, 16);
        sdt.setHorizontalAlignment(SwingConstants.CENTER);
        sdt.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        sdt.setForeground(Color.white);
        p2.add(sdt);

        p3 = new JPanel();
        p3.setBounds(0, 180, 1280, 80);
        p3.setBackground(Color.pink);
        p3.setLayout(null);

        // Kích thước của nút
        int buttonWidth = 150;
        int buttonHeight = 40;
        int gap = 88;
        int yPosition = (80 - buttonHeight) / 2;

        omega = new JButton("omega");
        omega.setBounds(gap, yPosition, buttonWidth, buttonHeight);
        p3.add(omega);

        canxi = new JButton("canxi");
        canxi.setBounds(gap * 2 + buttonWidth, yPosition, buttonWidth, buttonHeight);
        p3.add(canxi);

        tnm = new JButton("tnm");
        tnm.setBounds(gap * 3 + buttonWidth * 2, yPosition, buttonWidth, buttonHeight);
        p3.add(tnm);

        ddvs = new JButton("ddvs");
        ddvs.setBounds(gap * 4 + buttonWidth * 3, yPosition, buttonWidth, buttonHeight);
        p3.add(ddvs);

        siro = new JButton("siro");
        siro.setBounds(gap * 5 + buttonWidth * 4, yPosition, buttonWidth, buttonHeight);
        p3.add(siro);

        omega.setBackground(Color.PINK);
        canxi.setBackground(Color.PINK);
        tnm.setBackground(Color.PINK);
        ddvs.setBackground(Color.PINK);
        siro.setBackground(Color.PINK);

        omega.addMouseListener(this);
        canxi.addMouseListener(this);
        tnm.addMouseListener(this);
        ddvs.addMouseListener(this);
        siro.addMouseListener(this);

        p0.add(p3);

        // Tạo JScrollPane để bọc p0
        scr = new JScrollPane(p0);
        scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scr.getVerticalScrollBar().setUnitIncrement(16);

        setContentPane(scr);
        setVisible(true);

        // Tạo panel giỏ hàng
        createCartPanel();
    }

    // Tạo JPanel giỏ hàng có nền màu vàng
    public void createCartPanel() {
        cartPanel = new JPanel();
        cartPanel.setBackground(Color.GRAY);
        cartPanel.setLayout(null);

        JLabel cartLabel = new JLabel("Giỏ Hàng");
        cartLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        cartLabel.setBounds(500, 30, 300, 40);
        cartPanel.add(cartLabel);

        JButton backButton = new JButton("Quay Lại");
        backButton.setBounds(100, 600, 150, 40);
        backButton.addActionListener(e -> switchToMainPanel());
        cartPanel.add(backButton);
    }

    // Chuyển sang panel giỏ hàng
    public void switchToCartPanel() {
        setContentPane(cartPanel);
        revalidate();
        repaint();
    }

    // Quay lại giao diện chính
    public void switchToMainPanel() {
        setContentPane(scr);
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getBackground().equals(Color.PINK)) {
            clickedButton.setBackground(Color.BLUE);
        } else if (clickedButton.getBackground().equals(Color.BLUE)) {
            clickedButton.setBackground(Color.PINK);
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
            switchToCartPanel();
        }
    }

    public static void main(String[] args) {
        new customerGUI();
    }
}
