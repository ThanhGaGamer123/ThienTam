package store;

import javax.swing.*;
import java.awt.*;

public class storeGUI extends JFrame {
    public storeGUI(store nt) {
        this.setSize(1000, 580);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        
        this.setTitle("Cửa hàng");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gdc = new GridBagConstraints();

        JLabel title = new JLabel("Thông tin cửa hàng");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        // title.setBounds(340, 80, 300, 50);
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.fill = GridBagConstraints.CENTER;
        gdc.insets = new Insets(50, 0, 50, 0);
        this.add(title, gdc);

        // reset
        gdc.fill = GridBagConstraints.NONE;

        JLabel mant = new JLabel("Mã nhà thuốc: ");
        mant.setForeground(Color.BLACK);
        mant.setFont(new Font(null, Font.PLAIN, 20));
        // mant.setBounds(100, 180, 500, 20);
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.fill = GridBagConstraints.WEST;
        gdc.insets = new Insets(0, 0, 30, 0);
        this.add(mant, gdc);

        JPanel tf_diachi = new JPanel();
        tf_diachi.setBackground(Color.white);
        tf_diachi.setLayout(new FlowLayout());
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.fill = GridBagConstraints.WEST;
        gdc.insets = new Insets(0, 0, 30, 0);
        this.add(tf_diachi, gdc);

        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        // diachi.setBounds(100, 240, 700, 25);
        tf_diachi.add(diachi);

        JLabel manql = new JLabel("Mã quản lý: ");
        manql.setForeground(Color.BLACK);
        manql.setFont(new Font(null, Font.PLAIN, 20));
        // manql.setBounds(100, 300, 500, 25);
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.fill = GridBagConstraints.WEST;
        gdc.insets = new Insets(0, 0, 50, 0);
        this.add(manql, gdc);

        // JButton thoat = new JButton("Thoát");
        // thoat.setForeground(Color.BLACK);
        // thoat.setFont(new Font(null, Font.BOLD, 20));
        // // thoat.setBounds(420, 400, 120, 40);
        // gdc.gridx = 0;
        // gdc.gridy = 4;
        // gdc.fill = GridBagConstraints.HORIZONTAL;
        // this.add(thoat, gdc);

        // JLabel background = new JLabel();
        // background.setIcon(new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\backgrounds.jpg"));
        // background.setBounds(0,0, 1000, 700);
        // this.add(background);

        this.setVisible(true);

        //xử lý các tính năng

        //tự động điền thông tin
        mant.setText(mant.getText() + nt.getMant());
        diachi.setText(diachi.getText() + nt.getMasonha() + ", " + nt.getDuong() + ", " + nt.getPhuong() + ", " + nt.getQuan() + ", " + nt.getTinh());
        manql.setText(manql.getText() + nt.getManql());

        //thoát
        // thoat.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         dispose();
        //     }
        // });
    }

    public static void main(String[] args) {
        new storeGUI(null);
    }
}
