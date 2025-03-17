import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Themsp extends JFrame implements ActionListener {
    JButton btnThem, btnHuy;
    Adminframe adminframe;

    public Themsp(Adminframe adminframe) {
        this.adminframe = adminframe;
        setTitle("Thêm sản phẩm");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        btnThem = new JButton("Thêm");
        btnThem.setBounds(0, 0, 90, 40);
        btnThem.addActionListener(this);
        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(90, 0, 90, 40);
        add(btnThem);
        add(btnHuy);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThem) {
            if (adminframe.sl % 3 == 0) {
                adminframe.rows += 1;
                adminframe.panelshowsp.setLayout(new GridLayout(adminframe.rows, 3));
            }
            adminframe.sl++;
            JPanel productPanel = new JPanel();
            productPanel.setLayout(null);
            productPanel.setPreferredSize(new Dimension(260, 230));

            JLabel lb_sp = new JLabel("San pham " + adminframe.sl);
            lb_sp.setBounds(10, 10, 240, 20);
            productPanel.add(lb_sp);

            JButton btn_xoa = new JButton("Xoa");
            btn_xoa.setBounds(30, 200, 80, 20);
            productPanel.add(btn_xoa);

            JButton btn_sua = new JButton("Sua");
            btn_sua.setBounds(155, 200, 80, 20);
            productPanel.add(btn_sua);

            adminframe.panelshowsp.add(productPanel);
            adminframe.panelshowsp.revalidate();
            adminframe.panelshowsp.repaint();
            dispose();
            JOptionPane.showMessageDialog(null, "Them thanh cong");
        }
    }
}
