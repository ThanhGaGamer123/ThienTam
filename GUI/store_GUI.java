package GUI;

import javax.swing.*;

import BUS.store_BUS;
import DTO.store_DTO;
import advanceMethod.advance;

import java.awt.*;

public class store_GUI extends JFrame {
    public store_GUI(store_DTO nt) {
        this.setSize(1000, 580);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        
        this.setTitle("Cửa hàng");
        ImageIcon logo = new ImageIcon(advance.img+"logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gdc = new GridBagConstraints();

        JLabel title = new JLabel("Thông tin cửa hàng");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(50, 0, 50, 0);
        this.add(title, gdc);

        // reset
        gdc.anchor = GridBagConstraints.NONE;

        JLabel mant = new JLabel("Mã nhà thuốc: ");
        mant.setForeground(Color.BLACK);
        mant.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(0, 0, 30, 0);
        this.add(mant, gdc);

        JPanel tf_diachi = new JPanel();
        tf_diachi.setBackground(Color.white);
        tf_diachi.setLayout(new FlowLayout());
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(0, 0, 30, 0);
        this.add(tf_diachi, gdc);

        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        tf_diachi.add(diachi);

        JLabel manql = new JLabel("Mã quản lý: ");
        manql.setForeground(Color.BLACK);
        manql.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(0, 0, 50, 0);
        this.add(manql, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng: ");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(0, 0, 50, 0);
        this.add(tinhtrang, gdc);

        this.setVisible(true);

        store_BUS.loadData(nt, mant, manql, diachi, tinhtrang);
    }

    public static void main(String[] args) {
        new store_GUI(null);
    }
}
