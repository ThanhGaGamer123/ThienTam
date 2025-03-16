package store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class storeGUI extends JFrame {
    public storeGUI(store nt) {
        this.setSize(700, 580);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        this.setTitle("Cửa hàng");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        JLabel title = new JLabel("Thông tin cửa hàng");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setBounds(200, 80, 300, 50);
        this.add(title);

        JLabel mant = new JLabel("Mã nhà thuốc: ");
        mant.setForeground(Color.BLACK);
        mant.setFont(new Font(null, Font.PLAIN, 20));
        mant.setBounds(100, 180, 500, 20);
        this.add(mant);

        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        diachi.setBounds(100, 240, 700, 25);
        this.add(diachi);

        JLabel manql = new JLabel("Mã quản lý: ");
        manql.setForeground(Color.BLACK);
        manql.setFont(new Font(null, Font.PLAIN, 20));
        manql.setBounds(100, 300, 500, 20);
        this.add(manql);

        JButton thoat = new JButton("Thoát");
        thoat.setForeground(Color.BLACK);
        thoat.setFont(new Font(null, Font.BOLD, 20));
        thoat.setBounds(280, 400, 120, 40);
        this.add(thoat);

        this.setVisible(true);

        //xử lý các tính năng

        //tự động điền thông tin
        mant.setText(mant.getText() + nt.getMant());
        diachi.setText(diachi.getText() + nt.getMasonha() + ", " + nt.getDuong() + ", " + nt.getPhuong() + ", " + nt.getQuan() + ", " + nt.getTinh());
        manql.setText(manql.getText() + nt.getManql());

        //thoát
        thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
