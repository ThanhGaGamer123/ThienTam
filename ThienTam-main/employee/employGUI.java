package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import login.signup.login;
import store.store;
import store.storeArr;
import store.storeGUI;

public class employGUI extends JFrame {
    public employGUI(employee nv) {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        this.setTitle("Nhân viên");
        ImageIcon logo = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        //Tạo Tab Panel
        JTabbedPane tab = new JTabbedPane();
        tab.setBounds(0, 10, 1280, 710);
        tab.setForeground(Color.BLACK);
        tab.setFont(new Font(null, Font.BOLD, 20));

        //Lấy các icon
        ImageIcon statusIcon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\info.png");
        ImageIcon resize_statusIcon = new ImageIcon(statusIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon logOut = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\img\\log_out.png");
        ImageIcon resize_logOut = new ImageIcon(logOut.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        //Panel Thông tin nhân viên
        JPanel employeeStatus = new JPanel();
        employeeStatus.setBackground(Color.white);
        employeeStatus.setLayout(null);

        JLabel title = new JLabel("Thông Tin Nhân Viên");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setBounds(200,80,500,50);
        employeeStatus.add(title);

        JLabel manv = new JLabel("Mã nhân viên: ");
        manv.setForeground(Color.BLACK);
        manv.setFont(new Font(null, Font.PLAIN, 20));
        manv.setBounds(200,140,300,30);
        employeeStatus.add(manv);

        JLabel tennv = new JLabel("Tên nhân viên: ");
        tennv.setForeground(Color.BLACK);
        tennv.setFont(new Font(null, Font.PLAIN, 20));
        tennv.setBounds(200,180,300,30);
        employeeStatus.add(tennv);

        JLabel chucvu = new JLabel("Chức vụ: ");
        chucvu.setForeground(Color.BLACK);
        chucvu.setFont(new Font(null, Font.PLAIN, 20));
        chucvu.setBounds(200,220,300,30);
        employeeStatus.add(chucvu);

        JLabel sdt = new JLabel("Số điện thoại: ");
        sdt.setForeground(Color.BLACK);
        sdt.setFont(new Font(null, Font.PLAIN, 20));
        sdt.setBounds(200,260,300,30);
        employeeStatus.add(sdt);

        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setForeground(Color.BLACK);
        diachi.setFont(new Font(null, Font.PLAIN, 20));
        diachi.setBounds(200,300,700,30);
        employeeStatus.add(diachi);

        JLabel nhathuoc = new JLabel("Mã nhà thuốc: ");
        nhathuoc.setForeground(Color.BLACK);
        nhathuoc.setFont(new Font(null, Font.PLAIN, 20));
        nhathuoc.setBounds(200,340,300,30);
        employeeStatus.add(nhathuoc);

        JButton btn_nhathuoc = new JButton("Xem chi tiết");
        btn_nhathuoc.setForeground(Color.BLACK);
        btn_nhathuoc.setFont(new Font(null, Font.PLAIN, 16));
        btn_nhathuoc.setBounds(440,340,120,30);
        employeeStatus.add(btn_nhathuoc);

        //nút đăng xuất
        JButton dangXuat = new JButton("Đăng xuất");
        dangXuat.setForeground(Color.BLACK);
        dangXuat.setFont(new Font(null, Font.PLAIN, 16));
        dangXuat.setBounds(1100,2,140,42);
        dangXuat.setIcon(resize_logOut);
        this.add(dangXuat);

        tab.addTab("Thông tin", resize_statusIcon, employeeStatus);
        this.add(tab);
        
        this.setVisible(true);

        //xử lý các tính năng

        //Tự động điền thông tin khi đăng nhập:
        manv.setText(manv.getText() + nv.getManv());
        tennv.setText(tennv.getText() + nv.getTennv());
        chucvu.setText(chucvu.getText() + nv.getChucvu());
        sdt.setText(sdt.getText() + nv.getSdt());
        diachi.setText(diachi.getText() + nv.getMasonha() + ", " + nv.getDuong() + ", "
        + nv.getPhuong() + ", " + nv.getQuan() + ", " + nv.getTinh());
        nhathuoc.setText(nhathuoc.getText() + nv.getManhathuoc());

        //Hiển thị thông tin nhà thuốc
        btn_nhathuoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeArr arr = new storeArr();
                arr.readFile();
                Boolean found = false;
                for(store nt : arr.getArr()) {
                    if(nv.getManhathuoc().equals(nt.getMant())) {
                        new storeGUI(nt);
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    JOptionPane.showMessageDialog(null, 
                    "Không tìm thấy thông tin nhà thuốc.");
                }
            }
        });

        //đăng xuất
        dangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc muốn đăng xuất không?");
                if(choice == 0) {
                    new login();
                    dispose();
                }
            }
        });
    }
} 
