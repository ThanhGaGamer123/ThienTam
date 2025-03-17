import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Adminframe extends JFrame implements MouseListener, ActionListener {
    JLabel lbsp, lbnv, lbkh, lbdonhang, lbhoadonnhap, lbkho, lbncc, lbthongke;
    JPanel panelsp, panelnv, panelkh, paneldonhang, panelshowsp;
    JButton btn_themsp;
    int sl = 9;
    int rows = 3;

    public Adminframe() {
        // Panel san pham
        panelsp = new JPanel();
        panelsp.setLayout(null);
        panelsp.setBackground(Color.red);
        panelsp.setBounds(200, 0, 800, 800);

        // San pham nagigator
        JPanel panel_navigator = new JPanel();
        panel_navigator.setBounds(0, 0, 800, 40);
        panel_navigator.setLayout(new FlowLayout());
        panel_navigator.setBackground(Color.pink);
        JLabel lb_searchlogo = new JLabel("LOGO");
        lb_searchlogo.setSize(40, 40);
        JTextField tf_search = new JTextField("Search");
        tf_search.setPreferredSize(new Dimension(450, 30));
        panel_navigator.add(lb_searchlogo);
        panel_navigator.add(tf_search);
        JButton btn_loc = new JButton("Loc");
        btn_loc.setSize(40, 40);
        btn_themsp = new JButton("Them san pham");
        btn_themsp.setSize(40, 40);
        btn_themsp.addActionListener(this);
        panel_navigator.add(btn_loc);
        panel_navigator.add(btn_themsp);

        // Hien thi san pham
        panelshowsp = new JPanel();
        panelshowsp.setLayout(new GridLayout(3, 3));
        panelshowsp.setBackground(Color.blue);

        JPanel lb_sp1 = new JPanel();
        lb_sp1.setLayout(null);
        lb_sp1.setPreferredSize(new Dimension(260, 230));
        JButton btn_xoa1 = new JButton("Xoa");
        btn_xoa1.setBounds(30, 200, 80, 20);
        JButton btn_sua1 = new JButton("Sua");
        btn_sua1.setBounds(155, 200, 80, 20);
        lb_sp1.add(btn_xoa1);
        lb_sp1.add(btn_sua1);

        JPanel lb_sp2 = new JPanel();
        lb_sp2.setLayout(null);
        lb_sp2.setPreferredSize(new Dimension(260, 230));
        JButton btn_xoa2 = new JButton("Xoa");
        btn_xoa2.setBounds(30, 200, 80, 20);
        JButton btn_sua2 = new JButton("Sua");
        btn_sua2.setBounds(155, 200, 80, 20);
        lb_sp2.add(btn_xoa2);
        lb_sp2.add(btn_sua2);

        JPanel lb_sp3 = new JPanel();
        lb_sp3.setLayout(null);
        lb_sp3.setPreferredSize(new Dimension(260, 230));
        lb_sp3.setBackground(Color.yellow);
        lb_sp3.setOpaque(true);
        JButton btn_xoa3 = new JButton("Xoa");
        btn_xoa3.setBounds(30, 200, 80, 20);
        JButton btn_sua3 = new JButton("Sua");
        btn_sua3.setBounds(155, 200, 80, 20);
        lb_sp3.add(btn_xoa3);
        lb_sp3.add(btn_sua3);

        JPanel lb_sp4 = new JPanel();
        lb_sp4.setLayout(null);
        lb_sp4.setPreferredSize(new Dimension(260, 230));
        JButton btn_xoa4 = new JButton("Xoa");
        btn_xoa4.setBounds(30, 200, 80, 20);
        JButton btn_sua4 = new JButton("Sua");
        btn_sua4.setBounds(155, 200, 80, 20);
        lb_sp4.add(btn_xoa4);
        lb_sp4.add(btn_sua4);

        JPanel lb_sp5 = new JPanel();
        lb_sp5.setLayout(null);
        lb_sp5.setPreferredSize(new Dimension(260, 230));
        lb_sp5.setBackground(Color.yellow);
        lb_sp5.setOpaque(true);
        JButton btn_xoa5 = new JButton("Xoa");
        btn_xoa5.setBounds(30, 200, 80, 20);
        JButton btn_sua5 = new JButton("Sua");
        btn_sua5.setBounds(155, 200, 80, 20);
        lb_sp5.add(btn_xoa5);
        lb_sp5.add(btn_sua5);

        JPanel lb_sp6 = new JPanel();
        lb_sp6.setLayout(null);
        lb_sp6.setPreferredSize(new Dimension(260, 230));
        JButton btn_xoa6 = new JButton("Xoa");
        btn_xoa6.setBounds(30, 200, 80, 20);
        JButton btn_sua6 = new JButton("Sua");
        btn_sua6.setBounds(155, 200, 80, 20);
        lb_sp6.add(btn_xoa6);
        lb_sp6.add(btn_sua6);

        JPanel lb_sp7 = new JPanel();
        lb_sp7.setLayout(null);
        lb_sp7.setPreferredSize(new Dimension(260, 230));
        lb_sp7.setBackground(Color.yellow);
        lb_sp7.setOpaque(true);
        JButton btn_xoa7 = new JButton("Xoa");
        btn_xoa7.setBounds(30, 200, 80, 20);
        JButton btn_sua7 = new JButton("Sua");
        btn_sua7.setBounds(155, 200, 80, 20);
        lb_sp7.add(btn_xoa7);
        lb_sp7.add(btn_sua7);

        JPanel lb_sp8 = new JPanel();
        lb_sp8.setLayout(null);
        lb_sp8.setPreferredSize(new Dimension(260, 230));
        JButton btn_xoa8 = new JButton("Xoa");
        btn_xoa8.setBounds(30, 200, 80, 20);
        JButton btn_sua8 = new JButton("Sua");
        btn_sua8.setBounds(155, 200, 80, 20);
        lb_sp8.add(btn_xoa8);
        lb_sp8.add(btn_sua8);

        JPanel lb_sp9 = new JPanel();
        lb_sp9.setLayout(null);
        lb_sp9.setPreferredSize(new Dimension(260, 230));
        JButton btn_xoa9 = new JButton("Xoa");
        btn_xoa9.setBounds(30, 200, 80, 20);
        JButton btn_sua9 = new JButton("Sua");
        btn_sua9.setBounds(155, 200, 80, 20);
        lb_sp9.add(btn_xoa9);
        lb_sp9.add(btn_sua9);

        panelshowsp.add(lb_sp1);
        panelshowsp.add(lb_sp2);
        panelshowsp.add(lb_sp3);
        panelshowsp.add(lb_sp4);
        panelshowsp.add(lb_sp5);
        panelshowsp.add(lb_sp6);
        panelshowsp.add(lb_sp7);
        panelshowsp.add(lb_sp8);
        panelshowsp.add(lb_sp9);

        JScrollPane scrollPane = new JScrollPane(panelshowsp);
        scrollPane.setBounds(0, 40, 800, 690);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelsp.add(panel_navigator);
        panelsp.add(scrollPane);

        panelnv = new JPanel();
        panelnv.setBackground(Color.blue);
        panelnv.setBounds(200, 0, 800, 800);

        panelkh = new JPanel();
        panelkh.setBackground(Color.black);
        panelkh.setBounds(200, 0, 800, 800);

        paneldonhang = new JPanel();
        paneldonhang.setBackground(Color.cyan);
        paneldonhang.setBounds(200, 0, 800, 800);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 200, 800);
        panel1.setBackground(Color.green);
        panel1.setLayout(new FlowLayout());

        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/logo.jpg"));
        ImageIcon logo1 = ImageResizer.resizeImageIcon(logo, 30, 30);
        JLabel lblogo = new JLabel("Nha thuoc Thien Tam");
        lblogo.setPreferredSize(new Dimension(200, 40));
        lblogo.setFont(new Font(null, Font.BOLD, 16));
        lblogo.setIcon(logo1);
        panel1.add(lblogo);

        lbsp = new JLabel("San pham");
        lbsp.setPreferredSize(new Dimension(200, 40));
        lbsp.setFont(new Font(null, Font.BOLD, 16));
        lbsp.addMouseListener(this);
        panel1.add(lbsp);

        lbnv = new JLabel("Nhan vien");
        lbnv.setPreferredSize(new Dimension(200, 40));
        lbnv.setFont(new Font(null, Font.BOLD, 16));
        lbnv.addMouseListener(this);
        panel1.add(lbnv);

        lbkh = new JLabel("Khach hang");
        lbkh.setPreferredSize(new Dimension(200, 40));
        lbkh.setFont(new Font(null, Font.BOLD, 16));
        lbkh.addMouseListener(this);
        panel1.add(lbkh);

        lbdonhang = new JLabel("Don hang");
        lbdonhang.setPreferredSize(new Dimension(200, 40));
        lbdonhang.setFont(new Font(null, Font.BOLD, 16));
        lbdonhang.addMouseListener(this);
        panel1.add(lbdonhang);

        lbhoadonnhap = new JLabel("Hoa don nhap");
        lbhoadonnhap.setPreferredSize(new Dimension(200, 40));
        lbhoadonnhap.setFont(new Font(null, Font.BOLD, 16));
        panel1.add(lbhoadonnhap);

        lbkho = new JLabel("Kho");
        lbkho.setPreferredSize(new Dimension(200, 40));
        lbkho.setFont(new Font(null, Font.BOLD, 16));
        panel1.add(lbkho);

        lbncc = new JLabel("Nha cung cap");
        lbncc.setPreferredSize(new Dimension(200, 40));
        lbncc.setFont(new Font(null, Font.BOLD, 16));
        panel1.add(lbncc);

        lbthongke = new JLabel("Thong ke");
        lbthongke.setPreferredSize(new Dimension(200, 40));
        lbthongke.setFont(new Font(null, Font.BOLD, 16));
        panel1.add(lbthongke);

        add(panel1);

        setLayout(null);
        setSize(1014, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lbsp) {
            remove(panelnv);
            remove(panelkh);
            remove(paneldonhang);
            remove(panelsp);
            add(panelsp);
            revalidate(); // Cập nhật layout
            repaint(); // Vẽ lại giao diện
        } else if (e.getSource() == lbnv) {
            remove(panelkh);
            remove(paneldonhang);
            remove(panelsp);
            add(panelnv);
            revalidate(); // Cập nhật layout
            repaint(); // Vẽ lại giao diện
        } else if (e.getSource() == lbkh) {
            remove(panelnv);
            remove(paneldonhang);
            remove(panelsp);
            add(panelkh);
            revalidate(); // Cập nhật layout
            repaint(); // Vẽ lại giao diện
        } else if (e.getSource() == lbdonhang) {
            remove(panelnv);
            remove(panelkh);
            remove(panelsp);
            add(paneldonhang);
            revalidate(); // Cập nhật layout
            repaint(); // Vẽ lại giao diện
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
        if (e.getSource() == btn_themsp) {
            new Themsp(this);
        }
    }
}