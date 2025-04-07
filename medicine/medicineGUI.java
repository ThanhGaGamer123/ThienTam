package medicine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import advanceMethod.advance;
import dataAccessObj.medicineDAO;
import dataAccessObj.storageDAO;
import employee.employGUI;
import storage.storage;

public class medicineGUI extends JFrame {
    public medicineGUI(DefaultTableModel modelMedic){
        this.setSize(1000, 800);
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

        JLabel title = new JLabel("Lập Thông Tin Thuốc Mới");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.insets = new Insets(20, 0, 30, 0);
        main.add(title, gdc);

        JLabel tenthuoc = new JLabel("Tên thuốc:");
        tenthuoc.setForeground(Color.BLACK);
        tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(tenthuoc, gdc);

        JTextField tf_tenthuoc = new JTextField();
        tf_tenthuoc.setForeground(Color.BLACK);
        tf_tenthuoc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 1;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_tenthuoc, gdc);

        JLabel danhmuc = new JLabel("Danh mục:");
        danhmuc.setForeground(Color.BLACK);
        danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(danhmuc, gdc);

        JTextField tf_danhmuc = new JTextField();
        tf_danhmuc.setForeground(Color.BLACK);
        tf_danhmuc.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 2;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_danhmuc, gdc);

        JLabel donvi = new JLabel("Đơn vị:");
        donvi.setForeground(Color.BLACK);
        donvi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(donvi, gdc);

        JCheckBox hop = new JCheckBox("Hộp");
        hop.setBackground(Color.white);
        hop.setForeground(Color.BLACK);
        hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.NONE;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(hop, gdc);

        JCheckBox vi = new JCheckBox("Vỉ");
        vi.setBackground(Color.white);
        vi.setForeground(Color.BLACK);
        vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.NONE;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(vi, gdc);
        
        JCheckBox vien = new JCheckBox("Viên");
        vien.setBackground(Color.white);
        vien.setForeground(Color.BLACK);
        vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.NONE;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(vien, gdc);

        JLabel thanhphan = new JLabel("Thành phần:");
        thanhphan.setForeground(Color.BLACK);
        thanhphan.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(thanhphan, gdc);

        JTextArea ta_thanhphan = new JTextArea();
        ta_thanhphan.setForeground(Color.BLACK);
        ta_thanhphan.setFont(new Font(null, Font.PLAIN, 20));
        ta_thanhphan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        ta_thanhphan.setPreferredSize(new Dimension(0, 100));
        
        JScrollPane scroll_thanhphan = new JScrollPane();
        scroll_thanhphan.setViewportView(ta_thanhphan);

        gdc.gridx = 1;
        gdc.gridy = 4;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(scroll_thanhphan, gdc);

        JLabel thongtin = new JLabel("Thông tin:");
        thongtin.setForeground(Color.BLACK);
        thongtin.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 5;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.NORTHWEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(thongtin, gdc);

        JTextArea ta_thongtin = new JTextArea();
        ta_thongtin.setForeground(Color.BLACK);
        ta_thongtin.setFont(new Font(null, Font.PLAIN, 20));
        ta_thongtin.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        ta_thongtin.setPreferredSize(new Dimension(0, 100));
        
        JScrollPane scroll_thongtin = new JScrollPane();
        scroll_thongtin.setViewportView(ta_thongtin);

        gdc.gridx = 1;
        gdc.gridy = 5;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(scroll_thongtin, gdc);

        JLabel xuatxu = new JLabel("Xuất xứ:");
        xuatxu.setForeground(Color.BLACK);
        xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 6;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(xuatxu, gdc);

        JTextField tf_xuatxu = new JTextField();
        tf_xuatxu.setForeground(Color.BLACK);
        tf_xuatxu.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 6;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(tf_xuatxu, gdc);

        JLabel doituong = new JLabel("Đối tượng sử dụng:");
        doituong.setForeground(Color.BLACK);
        doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(doituong, gdc);

        String[] doituongsudung = {"không có chỉ định", "trẻ em", "người cao tuổi", "phụ nữ đang mang thai"}; //etc...
        JComboBox cb_doituong = new JComboBox(doituongsudung);
        cb_doituong.setForeground(Color.BLACK);
        cb_doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(cb_doituong, gdc);

        JButton btn_them_doituong = new JButton("Thêm");
        btn_them_doituong.setForeground(Color.BLACK);
        btn_them_doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(btn_them_doituong, gdc);

        JButton btn_xoa_doituong = new JButton("Xóa");
        btn_xoa_doituong.setForeground(Color.BLACK);
        btn_xoa_doituong.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 3;
        gdc.gridy = 7;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(btn_xoa_doituong, gdc);

        JLabel ds_doituong = new JLabel("Danh sách đối tượng sử dụng:");
        ds_doituong.setForeground(Color.BLACK);
        ds_doituong.setFont(new Font(null, Font.PLAIN, 20));

        JPanel dsdt = new JPanel(new FlowLayout());
        dsdt.setBackground(Color.white);
        dsdt.add(ds_doituong);
        gdc.gridx = 0;
        gdc.gridy = 8;
        gdc.gridwidth = 4;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 100);
        main.add(dsdt, gdc);

        JLabel giaban = new JLabel("Giá bán:");
        giaban.setForeground(Color.BLACK);
        giaban.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(giaban, gdc);

        JLabel gia_hop = new JLabel("Giá hộp:");
        gia_hop.setForeground(Color.BLACK);
        gia_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 10;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(gia_hop, gdc);

        JTextField tf_gia_hop = new JTextField();
        tf_gia_hop.setForeground(Color.BLACK);
        tf_gia_hop.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 10;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 0, 30, 80);
        main.add(tf_gia_hop, gdc);

        JLabel gia_vi = new JLabel("Giá vỉ:");
        gia_vi.setForeground(Color.BLACK);
        gia_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 11;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(gia_vi, gdc);

        JTextField tf_gia_vi = new JTextField();
        tf_gia_vi.setForeground(Color.BLACK);
        tf_gia_vi.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 11;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 0, 30, 80);
        main.add(tf_gia_vi, gdc);

        JLabel gia_vien = new JLabel("Giá viên:");
        gia_vien.setForeground(Color.BLACK);
        gia_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 0;
        gdc.gridy = 12;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.WEST;
        gdc.fill = GridBagConstraints.NONE;
        gdc.weightx = 0;
        gdc.insets = new Insets(0, 100, 30, 0);
        main.add(gia_vien, gdc);

        JTextField tf_gia_vien = new JTextField();
        tf_gia_vien.setForeground(Color.BLACK);
        tf_gia_vien.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 12;
        gdc.gridwidth = 3;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 0, 30, 80);
        main.add(tf_gia_vien, gdc);

        tf_gia_hop.setEnabled(false);
        tf_gia_vi.setEnabled(false);
        tf_gia_vien.setEnabled(false);

        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 0, 30, 0);
        main.add(finish, gdc);

        JButton reset = new JButton("Đặt lại");
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 2;
        gdc.gridy = 13;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(reset, gdc);

        this.setVisible(true);

        //xử lý các tính năng

        ArrayList<String> chosen = new ArrayList<>(); //ds đối tượng

        //thêm đối tượng
        btn_them_doituong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb_doituong.getSelectedIndex() != 0 
                && !chosen.contains(String.valueOf(cb_doituong.getSelectedItem()))) {
                    chosen.add(String.valueOf(cb_doituong.getSelectedItem()));
                    String result = String.join(", ", chosen);
                    ds_doituong.setText("Danh sách đối tượng sử dụng: " + result);
                }
            }
        });

        //xóa đối tượng
        btn_xoa_doituong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb_doituong.getSelectedIndex() != 0 
                && chosen.contains(String.valueOf(cb_doituong.getSelectedItem()))) {
                    chosen.remove(String.valueOf(cb_doituong.getSelectedItem()));
                    String result = String.join(", ", chosen);
                    ds_doituong.setText("Danh sách đối tượng sử dụng: " + result);
                }
            }
        });

        //mở khóa giá bán
        hop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hop.isSelected()) tf_gia_hop.setEnabled(true);
                else tf_gia_hop.setEnabled(false);
            }
        });

        vi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vi.isSelected()) tf_gia_vi.setEnabled(true);
                else tf_gia_vi.setEnabled(false);
            }
        });

        vien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vien.isSelected()) tf_gia_vien.setEnabled(true);
                else tf_gia_vien.setEnabled(false);
            }
        });

        //hoàn tất
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kiểm tra form
                Boolean found = false;
                Boolean price = true;
                if(tf_tenthuoc.getText().isEmpty() || tf_danhmuc.getText().isEmpty()
                || ta_thanhphan.getText().isEmpty() || ta_thongtin.getText().isEmpty()
                || tf_xuatxu.getText().isEmpty()) found = true;

                int checkbox = 0;
                if(hop.isSelected()) {
                    checkbox++;
                    if(tf_gia_hop.getText().isEmpty()) found = true;
                    if(!advance.checkTextField(tf_gia_hop.getText())) price = false;
                }
                if(vi.isSelected()) {
                    checkbox++;
                    if(tf_gia_vi.getText().isEmpty()) found = true;
                    if(!advance.checkTextField(tf_gia_vi.getText())) price = false;
                }
                if(vien.isSelected()) {
                    checkbox++;
                    if(tf_gia_vien.getText().isEmpty()) found = true;
                    if(!advance.checkTextField(tf_gia_vien.getText())) price = false;
                }
                if(checkbox == 0) found = true;

                if(found) JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ tất cả thông tin chính xác!");
                if(!price) JOptionPane.showMessageDialog(null, "Giá bán phải là số. Vui lòng nhập lại!");

                //gửi form
                medicineDAO medDAO = new medicineDAO();
                ArrayList<medicine> temp_1 = medDAO.selectAll();
                medicine med = new medicine();
                med.setMathuoc("MTH"+advance.calculateID(temp_1.size()));

                //tạo dữ liệu tồn trong kho
                storageDAO strDAO = new storageDAO();
                ArrayList<storage> temp_2 = strDAO.selectAll();
                storage str = new storage();
                med.setMaton("MTO"+advance.calculateID(temp_2.size()));
                str.setMaton(med.getMaton());

                ArrayList<Integer> slton = new ArrayList<>();
                if(hop.isSelected()) slton.add(0);
                if(vi.isSelected()) slton.add(0);
                if(vien.isSelected()) slton.add(0);
                str.setSlton(slton);

                str.setTinhtrang(true);

                strDAO.add(str);

                med.setTenthuoc(tf_tenthuoc.getText());
                med.setDanhmuc(tf_danhmuc.getText());
                
                ArrayList<String> donvi = new ArrayList<>();
                if(hop.isSelected()) donvi.add("hộp");
                if(vi.isSelected()) donvi.add("vỉ");
                if(vien.isSelected()) donvi.add("viên");
                med.setDonvi(donvi);
                
                med.setThanhphan(ta_thanhphan.getText());
                med.setThongtin(ta_thongtin.getText());
                med.setXuatxu(tf_xuatxu.getText());
                
                if(chosen.size() == 0) {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add("Không có chỉ định");
                    med.setDoituongsudung(temp);
                } else med.setDoituongsudung(chosen);

                ArrayList<Integer> giaban = new ArrayList<>();
                if(hop.isSelected()) giaban.add(Integer.parseInt(tf_gia_hop.getText()));
                if(vi.isSelected()) giaban.add(Integer.parseInt(tf_gia_vi.getText()));
                if(vien.isSelected()) giaban.add(Integer.parseInt(tf_gia_vien.getText()));
                med.setGiaban(giaban);

                med.setTinhtrang(true);

                medDAO.add(med);
                employGUI.updateTableMedic(modelMedic);
                dispose();
            }           
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_tenthuoc.setText("");
                tf_danhmuc.setText("");
                hop.setSelected(false);
                vi.setSelected(false);
                vien.setSelected(false);
                tf_gia_hop.setEnabled(false);
                tf_gia_vi.setEnabled(false);
                tf_gia_vien.setEnabled(false);
                tf_gia_hop.setText("");
                tf_gia_vi.setText("");
                tf_gia_vien.setText("");
                ta_thanhphan.setText("");
                ta_thongtin.setText("");
                tf_xuatxu.setText("");
                cb_doituong.setSelectedIndex(0);
                ds_doituong.setText("Danh sách đối tượng sử dụng: ");
            }
        });
    }

    public static void main(String[] args) {
        new medicineGUI(null);
    }
}
