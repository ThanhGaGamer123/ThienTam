package orderSupply;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import advanceMethod.advance;

public class searchAdvance2 extends JFrame {
    public searchAdvance2(DefaultTableModel modelSupplier, int loc, ArrayList<orderSupply> orderSupplies) {
        this.setSize(1000, 800);
        this.setTitle("Tìm kiếm hóa đơn nhập");
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

        JLabel title = new JLabel("Tìm Kiếm Hóa Đơn Nhập");
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

        JLabel tenncc = new JLabel("Tên nhà cung cấp:");
        tenncc.setForeground(Color.BLACK);
        tenncc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenncc, gdc);

        JTextField tf_tenncc = new JTextField();
        tf_tenncc.setForeground(Color.BLACK);
        tf_tenncc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tenncc, gdc);

        JLabel ngaynhap = new JLabel("Ngày nhập:");
        ngaynhap.setForeground(Color.BLACK);
        ngaynhap.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(ngaynhap, gdc);

        JTextField tf_ngaynhap = new JTextField("dd/MM/yyyy");
        tf_ngaynhap.setForeground(Color.BLACK);
        tf_ngaynhap.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_ngaynhap, gdc);

        JLabel tinhtrang = new JLabel("Tình trạng:");
        tinhtrang.setForeground(Color.BLACK);
        tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tinhtrang, gdc);

        String[] option = {"Không có", "Đang hoạt động", "Ngừng hoạt động"};
        JComboBox tf_tinhtrang = new JComboBox(option);
        tf_tinhtrang.setForeground(Color.BLACK);
        tf_tinhtrang.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 100);
        main.add(tf_tinhtrang, gdc);

        JButton tim = new JButton("Tìm");
        tim.setForeground(Color.BLACK);
        tim.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 5;
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
        gdc.gridy = 5;
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
                //kiểm tra
                String madon = tf_mandon.getText().toString();
                String tenncc = tf_tenncc.getText().toString();
                String ngaynhap = tf_ngaynhap.getText().toString();

                if(tf_ngaynhap.getText().isEmpty() || (!tf_ngaynhap.getText().isEmpty() && advance.checkDate(ngaynhap))) {
                    String command = "select mahdnhap, HoaDonNhap.mancc,tenncc, soloaithuoc, ngaynhap, tongtien, HoaDonNhap.tinhtrang "
                    + "from HoaDonNhap, NhaCungCap where HoaDonNhap.mancc = NhaCungCap.mancc and "
                    + "mahdnhap like N'%" + madon + "%' and tenncc like N'%" + tenncc + "%' and "
                    + "ngaynhap like N'%" + ngaynhap + "%'";
                    Connection sql = data.SQL.createConnection();
                    orderSupplies.clear();

                    try {
                        PreparedStatement pst = sql.prepareStatement(command);
                        ResultSet rs = pst.executeQuery();
                        while (rs.next()) {
                            orderSupply orderSupply = new orderSupply();
                            orderSupply.setMahdnhap(rs.getString("mahdnhap"));
                            orderSupply.setMancc("mancc");
                            tenncc = rs.getString("tenncc");
                            orderSupply.setNgaynhap(rs.getString("ngaynhap"));
                            orderSupply.setSoloaithuoc(rs.getInt("soloaithuoc"));
                            orderSupply.setTinhtrang(rs.getBoolean("tinhtrang"));
                            orderSupply.setTongtien(rs.getInt("tongtien"));
                            if((tf_tinhtrang.getSelectedItem().toString().equals("Đang hoạt động")
                            && orderSupply.getTinhtrang()) 
                            || (tf_tinhtrang.getSelectedItem().toString().equals("Ngừng hoạt động")
                            && !orderSupply.getTinhtrang())
                            || (tf_tinhtrang.getSelectedItem().toString().equals("Không có"))) {
                                orderSupplies.add(orderSupply);
                            }
                        }
                        System.out.println("Truy vấn thành công");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        data.SQL.closeConnection(sql);
                    }
                    
                    //xử lý lọc
                    System.out.println(loc);
                    if(loc == 1) {
                        for(int i = 0; i < orderSupplies.size() - 1; i++) {
                            for(int j = i + 1; j < orderSupplies.size(); j++) {
                                if(orderSupplies.get(i).getTongtien() < orderSupplies.get(j).getTongtien()) {
                                    orderSupply temp = orderSupplies.get(i);
                                    orderSupplies.set(i, orderSupplies.get(j));
                                    orderSupplies.set(j, temp);
                                }
                            }
                        }
                    } else if(loc == 2) {
                        for(int i = 0; i < orderSupplies.size() - 1; i++) {
                            for(int j = i + 1; j < orderSupplies.size(); j++) {
                                if(orderSupplies.get(i).getTongtien() > orderSupplies.get(j).getTongtien()) {
                                    orderSupply temp = orderSupplies.get(i);
                                    orderSupplies.set(i, orderSupplies.get(j));
                                    orderSupplies.set(j, temp);
                                }
                            }
                        }
                    } else if(loc == 3) {
                        for(int i = 0; i < orderSupplies.size() - 1; i++) {
                            for(int j = i + 1; j < orderSupplies.size(); j++) {
                                if(advance.fulldate1BeforeFullDate2(orderSupplies.get(i).getNgaynhap(), orderSupplies.get(j).getNgaynhap())) {
                                    orderSupply temp = orderSupplies.get(i);
                                    orderSupplies.set(i, orderSupplies.get(j));
                                    orderSupplies.set(j, temp);
                                }
                            }
                        }
                    } else if(loc == 4) {
                        for(int i = 0; i < orderSupplies.size() - 1; i++) {
                            for(int j = i + 1; j < orderSupplies.size(); j++) {
                                if(!advance.fulldate1BeforeFullDate2(orderSupplies.get(i).getNgaynhap(), orderSupplies.get(j).getNgaynhap())) {
                                    orderSupply temp = orderSupplies.get(i);
                                    orderSupplies.set(i, orderSupplies.get(j));
                                    orderSupplies.set(j, temp);
                                }
                            }
                        }
                    }

                    //lưu vào bảng
                    modelSupplier.setRowCount(0);
                    for (orderSupply orderSupply : orderSupplies) {
                        JLabel statusImg;
                        if(orderSupply.getTinhtrang()) {
                            statusImg = new JLabel(data.imagePath.resize_check);
                        } else {
                            statusImg = new JLabel(data.imagePath.resize_exitIcon);
                        }
                        JButton eyeButton = new JButton(data.imagePath.resize_eye);
                        modelSupplier.addRow(new Object[]{orderSupply.getMahdnhap(), tenncc,
                        orderSupply.getSoloaithuoc(), orderSupply.getNgaynhap(),
                        orderSupply.getTongtien(), statusImg, eyeButton});
                    }

                    //reset
                    tf_mandon.setText("");
                    tf_tenncc.setText("");
                    tf_ngaynhap.setText("");
                    tf_tinhtrang.setSelectedItem(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Ngày nhập không hợp lệ!");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_mandon.setText("");
                tf_tenncc.setText("");
                tf_ngaynhap.setText("");
                tf_tinhtrang.setSelectedItem(0);
            }
        });
    }

    public static void main(String[] args) {
        new searchAdvance2(null, 0, null);
    }
}
