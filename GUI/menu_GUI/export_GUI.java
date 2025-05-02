package GUI.menu_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import BUS.export_BUS;
import advanceMethod.advance;

public class export_GUI extends JFrame {
    public export_GUI() {
        this.setSize(700, 400);
        this.setTitle("Xuất dữ liệu");
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

        JLabel xuatas = new JLabel("Xuất dưới dạng: ");
        xuatas.setForeground(Color.BLACK);
        xuatas.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(xuatas, gdc);

        String[] option1 = {"Excel", "PDF"};
        JComboBox cb_xuatas = new JComboBox(option1);
        cb_xuatas.setForeground(Color.BLACK);
        cb_xuatas.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 0;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(cb_xuatas, gdc);

        JLabel data = new JLabel("Dữ liệu cần xuất: ");
        data.setForeground(Color.BLACK);
        data.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(data, gdc);

        String[] option2 = {"Danh sách thuốc", "Danh sách đơn hàng", "Danh sách đơn hàng nhập"};
        JComboBox cb_data = new JComboBox(option2);
        cb_data.setForeground(Color.BLACK);
        cb_data.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(cb_data, gdc);

        JLabel filename = new JLabel("Nhập tên file: ");
        filename.setForeground(Color.BLACK);
        filename.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(filename, gdc);

        JTextField tf_filename = new JTextField();
        tf_filename.setForeground(Color.BLACK);
        tf_filename.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 2;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(tf_filename, gdc);

        JLabel path = new JLabel("Chọn đường dẫn: ");
        path.setForeground(Color.BLACK);
        path.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 50, 30, 0);
        main.add(path, gdc);

        JTextField tf_path = new JTextField();
        tf_path.setForeground(Color.BLACK);
        tf_path.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 0);
        main.add(tf_path, gdc);

        JButton btn_path = new JButton("Chọn");
        btn_path.setForeground(Color.BLACK);
        btn_path.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0.01;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(btn_path, gdc);

        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 50);
        main.add(finish, gdc);

        this.setVisible(true);

        //xử lý tính năng

        //chọn export path
        btn_path.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                export_BUS.pathData(tf_path);
            }
        });
    
        //export file
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ketQua = export_BUS.exportFile(cb_xuatas, cb_data, 
                tf_filename, tf_path);
                if(ketQua == 0) 
                    JOptionPane.showMessageDialog(null, 
                    "Xuất file thành công.");
                if(ketQua == 1) 
                    JOptionPane.showMessageDialog(null, 
                    "Vui lòng nhập tên file.");
                if(ketQua == 2) 
                    JOptionPane.showMessageDialog(null, 
                    "Vui lòng chọn đường dẫn.");
                if(ketQua == 3) 
                    JOptionPane.showMessageDialog(null, 
                    "File đã tồn tại.");
                if(ketQua == 4) 
                    JOptionPane.showMessageDialog(null, 
                    "Xuất file không thành công.");
            }
        });
    }

    public static void main(String[] args) {
        new export_GUI();
    }
}
