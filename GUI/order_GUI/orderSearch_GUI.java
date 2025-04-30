package GUI.order_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.order_BUS;
import DTO.order_DTO;
import advanceMethod.advance;

public class orderSearch_GUI extends JFrame {
    public orderSearch_GUI(DefaultTableModel model, int loc, ArrayList<order_DTO> ords) {
        this.setSize(1000, 800);
        this.setTitle("Tìm kiếm đơn hàng");
        ImageIcon logo = new ImageIcon(advance.img+"logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel main = new JPanel();
        main.setBackground(Color.white);
        main.setLayout(new GridBagLayout());

        JScrollPane scroll_frame = new JScrollPane();
        scroll_frame.setViewportView(main);

        this.getContentPane().add(scroll_frame, BorderLayout.CENTER);

        GridBagConstraints gdc = new GridBagConstraints();

        JLabel title = new JLabel("Tìm Kiếm Đơn Hàng");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel mandon = new JLabel("Mã đơn:");
        mandon.setForeground(Color.BLACK);
        mandon.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(mandon, gdc);

        JTextField tf_mandon = new JTextField();
        tf_mandon.setForeground(Color.BLACK);
        tf_mandon.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_mandon, gdc);

        JLabel tenkh = new JLabel("Tên khách hàng:");
        tenkh.setForeground(Color.BLACK);
        tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenkh, gdc);

        JTextField tf_tenkh = new JTextField();
        tf_tenkh.setForeground(Color.BLACK);
        tf_tenkh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenkh, gdc);

        JLabel tennv = new JLabel("Tên nhân viên:");
        tennv.setForeground(Color.BLACK);
        tennv.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tennv, gdc);

        JTextField tf_tennv = new JTextField();
        tf_tennv.setForeground(Color.BLACK);
        tf_tennv.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tennv, gdc);

        JLabel ngaydat = new JLabel("Ngày đặt:");
        ngaydat.setForeground(Color.BLACK);
        ngaydat.setFont(new Font(null, Font.BOLD, 22));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngaydat, gdc);

        JLabel ngaybatdau = new JLabel("Từ ngày:");
        ngaybatdau.setForeground(Color.BLACK);
        ngaybatdau.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngaybatdau, gdc);

        JTextField tf_ngaybatdau = new JTextField("dd/MM/yyyy");
        tf_ngaybatdau.setForeground(Color.BLACK);
        tf_ngaybatdau.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_ngaybatdau, gdc);

        JLabel ngayketthuc = new JLabel("Đến ngày:");
        ngayketthuc.setForeground(Color.BLACK);
        ngayketthuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngayketthuc, gdc);

        JTextField tf_ngayketthuc = new JTextField("dd/MM/yyyy");
        tf_ngayketthuc.setForeground(Color.BLACK);
        tf_ngayketthuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 6;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_ngayketthuc, gdc);

        JLabel pttt = new JLabel("Phương thức thanh toán:");
        pttt.setForeground(Color.BLACK);
        pttt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(pttt, gdc);

        String[] op_pttt = {"Không có", "Trả bằng tiền mặt", "Chuyển khoản"};
        JComboBox cb_pttt = new JComboBox(op_pttt);
        cb_pttt.setForeground(Color.BLACK);
        cb_pttt.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(cb_pttt, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng đơn hàng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tinhtrang, gdc);

        String[] op_tinhtrang = {"Không có", "Đang xử lý", "Đã xử lý", "Đã giao", "Đã hủy"};
        JComboBox cb_tinhtrang = new JComboBox(op_tinhtrang);
        cb_tinhtrang.setForeground(Color.BLACK);
        cb_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 8;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(cb_tinhtrang, gdc);

        JButton tim = new JButton("Tìm");
        tim.setForeground(Color.BLACK);
        tim.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tim, gdc);

        JButton reset = new JButton("Đặt lại");
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(reset, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //tìm
        tim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ketQua = order_BUS.findAdvance(tf_mandon, tf_tenkh, tf_tennv, 
                tf_ngaybatdau, tf_ngayketthuc, cb_pttt, cb_tinhtrang, loc, model, ords);
                if(ketQua == 2) {
                    JOptionPane.showMessageDialog(null, 
                    "Ngày bắt đầu không hợp lệ!");
                } 
                if(ketQua == 3) {
                    JOptionPane.showMessageDialog(null, 
                    "Ngày kết thúc không hợp lệ!");
                }
            }
        });
    
        //reset
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order_BUS.resetFind(tf_mandon, tf_tenkh, tf_tennv, tf_ngaybatdau, 
                tf_ngayketthuc, cb_pttt, cb_tinhtrang, model);
            }
        });
    }

    public static void main(String[] args) {
        new orderSearch_GUI(null, 0, null);
    }
}
