package medicine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

public class medicineUpdateGUI extends JFrame {
    public medicineUpdateGUI(DefaultTableModel modelMedic, String mathuoc){
        this.setSize(1500, 800);
        this.setTitle("Cập nhật thông tin thuốc");
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

        JLabel title = new JLabel("Cập Nhật Thông Tin Thuốc");
        title.setForeground(Color.BLACK);
        title.setFont(new Font(null, Font.BOLD, 30));
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.gridwidth = 5;
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
        gdc.insets = new Insets(0, 10, 30, 10);
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
        gdc.insets = new Insets(0, 10, 30, 10);
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
        gdc.insets = new Insets(0, 10, 30, 10);
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
        gdc.insets = new Insets(0, 10, 30, 10);
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
        gdc.insets = new Insets(0, 10, 30, 10);
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
        gdc.insets = new Insets(0, 10, 30, 10);
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

        JButton finish = new JButton("Hoàn tất");
        finish.setForeground(Color.BLACK);
        finish.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 1;
        gdc.gridy = 9;
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
        gdc.gridy = 9;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 10);
        main.add(reset, gdc);

        JLabel khung_anh = new JLabel();
        khung_anh.setBackground(Color.LIGHT_GRAY);
        khung_anh.setBorder(BorderFactory.createLineBorder(Color.black,3));
        gdc.gridx = 4;
        gdc.gridy = 1;
        gdc.gridwidth = 1;
        gdc.gridheight = 4;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.BOTH;
        gdc.weightx = 1.2;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(khung_anh, gdc);

        JButton chon_anh = new JButton("Chọn ảnh");
        chon_anh.setForeground(Color.BLACK);
        chon_anh.setFont(new Font(null, Font.PLAIN, 20));
        gdc.gridx = 4;
        gdc.gridy = 4;
        gdc.gridwidth = 1;
        gdc.anchor = GridBagConstraints.CENTER;
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.weightx = 1;
        gdc.insets = new Insets(0, 10, 30, 80);
        main.add(chon_anh, gdc);

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

        //hoàn tất
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kiểm tra form
                Boolean found = false;
                if(tf_tenthuoc.getText().isEmpty() || tf_danhmuc.getText().isEmpty()
                || ta_thanhphan.getText().isEmpty() || ta_thongtin.getText().isEmpty()
                || tf_xuatxu.getText().isEmpty()) found = true;

                if(found) JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ tất cả thông tin chính xác!");
                else {
                    //gửi form
                    medicineDAO medDAO = new medicineDAO();
                    medicine med = new medicine();
                    medicine old_med = throwMedicineObj(mathuoc);
                    med.setMathuoc(old_med.getMathuoc());

                    med.setTenthuoc(tf_tenthuoc.getText());
                    med.setDanhmuc(tf_danhmuc.getText());
                    
                    ArrayList<String> donvi = new ArrayList<>();
                    if(hop.isSelected()) donvi.add("hộp");
                    if(vi.isSelected()) donvi.add("vỉ");
                    if(vien.isSelected()) donvi.add("viên");
                    med.setDonvi(donvi);
                    
                    storage old_str = throwStorageObj(old_med.getMaton());
                    med.setMaton(old_str.getMaton());
                    
                    med.setThanhphan(ta_thanhphan.getText());
                    med.setThongtin(ta_thongtin.getText());
                    med.setXuatxu(tf_xuatxu.getText());
                    
                    if(chosen.size() == 0) {
                        ArrayList<String> temp = new ArrayList<>();
                        temp.add("Không có chỉ định");
                        med.setDoituongsudung(temp);
                    } else med.setDoituongsudung(chosen);

                    med.setGiaban(old_med.getGiaban());

                    med.setTinhtrang(true);

                    medDAO.update(med);
                    employGUI.updateTableMedic(modelMedic);
                    dispose();
                }
            }           
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicine med = throwMedicineObj(mathuoc);
                tf_tenthuoc.setText(med.getTenthuoc());
                tf_danhmuc.setText(med.getDanhmuc());
                for (String string : med.getDonvi()) {
                    if(string.equals("hộp")) {
                        hop.setSelected(true);
                    }
                    if(string.equals("vỉ")) {
                        vi.setSelected(true);
                    }
                    if(string.equals("viên")) {
                        vien.setSelected(true);
                    }
                }
                ta_thanhphan.setText(med.getThanhphan());
                ta_thongtin.setText(med.getThongtin());
                tf_xuatxu.setText(med.getXuatxu());
                chosen.clear();
                chosen.addAll(med.getDoituongsudung());
                String result = String.join(", ", chosen);
                Boolean found = false;
                for (String string : chosen) {
                    if(string.equals("Không có chỉ định")) {
                        ds_doituong.setText("Danh sách đối tượng sử dụng: ");
                        chosen.clear();
                        found = true;
                        break;
                    }
                }
                if(!found) ds_doituong.setText("Danh sách đối tượng sử dụng: " + result);
                ImageIcon anh = new ImageIcon(advance.medIMG + mathuoc + ".png");
                Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon anh_scaled = new ImageIcon(anh_scale);
                khung_anh.setIcon(anh_scaled);
            }
        });

        //tự động điền thông tin
        medicine med = throwMedicineObj(mathuoc);
        tf_tenthuoc.setText(med.getTenthuoc());
        tf_danhmuc.setText(med.getDanhmuc());
        for (String string : med.getDonvi()) {
            if(string.equals("hộp")) {
                hop.setSelected(true);
            }
            if(string.equals("vỉ")) {
                vi.setSelected(true);
            }
            if(string.equals("viên")) {
                vien.setSelected(true);
            }
        }
        ta_thanhphan.setText(med.getThanhphan());
        ta_thongtin.setText(med.getThongtin());
        tf_xuatxu.setText(med.getXuatxu());
        chosen.clear();
        chosen.addAll(med.getDoituongsudung());
        String result = String.join(", ", chosen);
        Boolean found = false;
        for (String string : chosen) {
            if(string.equals("Không có chỉ định")) {
                ds_doituong.setText("Danh sách đối tượng sử dụng: ");
                chosen.clear();
                found = true;
                break;
            }
        }
        if(!found) ds_doituong.setText("Danh sách đối tượng sử dụng: " + result);
        ImageIcon anh = new ImageIcon(advance.medIMG + mathuoc + ".png");
        Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon anh_scaled = new ImageIcon(anh_scale);
        khung_anh.setIcon(anh_scaled);

        chon_anh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn ảnh");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

                fileChooser.setCurrentDirectory(new File(advance.file_path));
                int ketQua = fileChooser.showOpenDialog(null);
                if(ketQua == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imgPath = advance.medIMG + mathuoc + ".png";
                    
                    try {
                        Files.copy(selectedFile.toPath(), new File(imgPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        ImageIcon anh = new ImageIcon(imgPath);
                        Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon anh_scaled = new ImageIcon(anh_scale);
                        khung_anh.setIcon(anh_scaled);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Sao chép file thất bại");
                    }
                }
            }
        });
    }

    public static medicine throwMedicineObj(String mathuoc) {
        medicine med = new medicine();
        med.setMathuoc(mathuoc);
        medicineDAO medDAO = new medicineDAO();
        return medDAO.selectByID(med);
    }

    public static storage throwStorageObj(String maton) {
        storage str = new storage();
        str.setMaton(maton);
        storageDAO strDAO = new storageDAO();
        return strDAO.selectByID(str);
    }

    public static void main(String[] args) {
        new medicineUpdateGUI(null, null);
    }
}
