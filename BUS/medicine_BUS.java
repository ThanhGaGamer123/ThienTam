package BUS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.medicine_DAO;
import DAO.orderSupply_details_DAO;
import DAO.storage_DAO;
import DTO.medicine_DTO;
import DTO.orderSupply_details_DTO;
import DTO.storage_DTO;
import GUI.medicine_GUI.medicineUpdate_GUI;
import GUI.medicine_GUI.medicine_GUI;
import advanceMethod.advance;

public class medicine_BUS {
    public static void updateSellPrice() {
        ArrayList<orderSupply_details_DTO> osds = new ArrayList<>();
        orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
        osds = osdDAO.selectAll();
        for (orderSupply_details_DTO osd : osds) {
            if(osd.getTinhtrang()) {
                medicine_DTO med = throwMedicineObj(osd.getMathuoc());
                ArrayList<Double> giaban = med.getGiaban();
                if(giaban.get(0) == 0.0 && osd.getGianhap().get(0) != 0.0)
                    giaban.set(0, osd.getGianhap().get(0) * 1.2);
                if(giaban.get(1) == 0.0 && osd.getGianhap().get(1) != 0.0)
                    giaban.set(1, osd.getGianhap().get(1) * 1.2);
                if(giaban.get(2) == 0.0 && osd.getGianhap().get(2) != 0.0)
                    giaban.set(2, osd.getGianhap().get(2) * 1.2);
                med.setGiaban(giaban);
                medicine_DAO medDAO = new medicine_DAO();
                medDAO.update(med);
            }
        }
    }

    //medicine trong employee
    public static void loadData(DefaultTableModel modelMedic, Boolean flag) {
        modelMedic.setRowCount(0);
        medicine_DAO medDAO = new medicine_DAO();
        ArrayList<medicine_DTO> medicines = medDAO.selectAll();
        for (medicine_DTO medicine : medicines) {
            JLabel statusImg;
            if(medicine.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton eyeButton = new JButton(data.imagePath.resize_eye);
            if(flag && medicine.getTinhtrang()) 
                modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), medicine.getDanhmuc(),
                statusImg, eyeButton});
            if(!flag)
                modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), medicine.getDanhmuc(),
                statusImg, eyeButton});
        }
    }

    public static void showDetails(JTable tableMedic, DefaultTableModel modelMedic) {
        int selectColumn = tableMedic.getSelectedColumn();
        if(selectColumn == 4) {
            int selectedRow = tableMedic.getSelectedRow();
            if(selectedRow != -1) {
                String mathuoc = String.valueOf(modelMedic.getValueAt(selectedRow, 0));
                new medicine_GUI(mathuoc);
            }
        }
    }
    
    public static medicine_DTO throwMedicineObj(String mathuoc) {
        medicine_DTO med = new medicine_DTO();
        med.setMathuoc(mathuoc);
        medicine_DAO medDAO = new medicine_DAO();
        return medDAO.selectByID(med);
    }

    public static Boolean rectifyMedicine(JTable tableMedic, DefaultTableModel modelMedic) {
        int selectedRow = tableMedic.getSelectedRow();
        if(selectedRow != -1) {
            String mathuoc = String.valueOf(modelMedic.getValueAt(selectedRow, 0));
            medicine_DTO med = throwMedicineObj(mathuoc);
            if(med.getTinhtrang()) {
                new medicineUpdate_GUI(modelMedic, mathuoc);
                return true;
            }
            else return false;
        }
        return null;
    }

    public static storage_DTO throwStorageObj(String maton) {
        storage_DTO str = new storage_DTO();
        str.setMaton(maton);
        storage_DAO strDAO = new storage_DAO();
        return strDAO.selectByID(str);
    }

    public static Boolean deleteMedicine(JTable tableMedic, DefaultTableModel modelMedic, DefaultTableModel modelCollect) {
        int selectedRow = tableMedic.getSelectedRow();
        if(selectedRow != -1) {
            String mathuoc = String.valueOf(modelMedic.getValueAt(selectedRow, 0));
            medicine_DTO med = throwMedicineObj(mathuoc);
            if(med.getTinhtrang()) {
                int choice = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn xóa thông tin thuốc này không?");
                if (choice == 0) {
                    med.setTinhtrang(false);
                    medicine_DAO medDAO = new medicine_DAO();
                    medDAO.update(med);

                    storage_BUS.deleteStock(med);

                    ArrayList<orderSupply_details_DTO> osds = new ArrayList<>();
                    orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                    osds = osdDAO.selectByCondition("mathuoc = '" + med.getMathuoc() + "'");
                    for (orderSupply_details_DTO osd : osds) {
                        osd.setTinhtrang(false);
                        osdDAO.update(osd);
                        orderSupply_BUS.checkOrderSupply(osd.getMahdnhap(), modelCollect);
                    }

                    storage_BUS.decreaseStock(osds);
                    loadData(modelMedic, true);
                    orderSupply_BUS.loadData(modelCollect, true);

                    return true;
                }
            } else return false;
        }
        return null;
    }

    public static void searchMedicine(JTextField search_bar_3, DefaultTableModel modelMedic) {
        ArrayList<medicine_DTO> meds = new ArrayList<>();
        medicine_DAO medDAO = new medicine_DAO();
        meds = medDAO.selectByCondition("tenthuoc like N'%" + search_bar_3.getText() + "%'");
        modelMedic.setRowCount(0);
        for (medicine_DTO med : meds) {
            JLabel statusImg;
            System.out.println(med.getTinhtrang());
            if(med.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton eyeButton = new JButton(data.imagePath.resize_eye);
            modelMedic.addRow(new Object[]{med.getMathuoc(), 
            med.getTenthuoc(), med.getDanhmuc(),
            statusImg, eyeButton});
        }
    }

    public static void reset(JTextField search_bar_3, DefaultTableModel modelMedic) {
        search_bar_3.setText("Nhập tên thuốc...");
        loadData(modelMedic, true);
    }

    //medicine chi tiết
    public static void loadDetailsMedicine(String mathuoc, JTextField tf_maThuoc,
    JTextField tf_tenthuoc, JTextField tf_danhmuc, JTextField tf_donvi,
    JTextArea ta_thanhphan, JTextArea ta_thongtin, JTextField tf_xuatxu,
    JTextField tf_dsdt, JTextField tf_tinhtrang, JLabel khung_anh,
    JTextField tf_giahop, JTextField tf_giavi, JTextField tf_giavien,
    JTextField tf_slhop, JTextField tf_slvi, JTextField tf_slvien, JTextField tf_hansd) {
        ArrayList<String> chosen = new ArrayList<>(); //ds đối tượng sử dụng

        medicine_DTO med = throwMedicineObj(mathuoc);
        tf_maThuoc.setText(med.getMathuoc());
        tf_tenthuoc.setText(med.getTenthuoc());
        tf_danhmuc.setText(med.getDanhmuc());
        String dsdonvi = String.join(", ", med.getDonvi());
        tf_donvi.setText(dsdonvi);
        ta_thanhphan.setText(med.getThanhphan());
        ta_thongtin.setText(med.getThongtin());
        tf_xuatxu.setText(med.getXuatxu());
        chosen.clear();
        chosen.addAll(med.getDoituongsudung());
        String dsdtsd = String.join(", ", chosen);
        tf_dsdt.setText(dsdtsd);
        tf_hansd.setText(med.getHansudung());
        if(med.getTinhtrang()) tf_tinhtrang.setText("Đang hoạt động");
        else tf_tinhtrang.setText("Ngừng hoạt động");

        ImageIcon anh = new ImageIcon(advance.medIMG + mathuoc + ".png");
        Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon anh_scaled = new ImageIcon(anh_scale);
        khung_anh.setIcon(anh_scaled);

        ArrayList<String> giaban = advance.DoubleArrayListToStringArrayList(med.getGiaban());
        tf_giahop.setText(giaban.get(0));
        tf_giavi.setText(giaban.get(1));
        tf_giavien.setText(giaban.get(2));

        storage_DTO str = throwStorageObj(med.getMaton());
        ArrayList<String> sl = advance.IntArrayListToStringArrayList(str.getSlton());
        tf_slhop.setText(sl.get(0));
        tf_slvi.setText(sl.get(1));
        tf_slvien.setText(sl.get(2));
    }

    //medicine thêm
    public static void addUser(ArrayList<String> chosen, JComboBox cb_doituong, JLabel ds_doituong) {
        if (cb_doituong.getSelectedIndex() != 0 
        && !chosen.contains(String.valueOf(cb_doituong.getSelectedItem()))) {
            chosen.add(String.valueOf(cb_doituong.getSelectedItem()));
            String result = String.join(", ", chosen);
            ds_doituong.setText("Danh sách đối tượng sử dụng: " + result);
        }
    }

    public static void deleteUser(ArrayList<String> chosen, JComboBox cb_doituong, JLabel ds_doituong) {
        if (cb_doituong.getSelectedIndex() != 0 
        && chosen.contains(String.valueOf(cb_doituong.getSelectedItem()))) {
            chosen.remove(String.valueOf(cb_doituong.getSelectedItem()));
            String result = String.join(", ", chosen);
            ds_doituong.setText("Danh sách đối tượng sử dụng: " + result);
        }
    }

    public static Boolean addMedicine(JTextField tf_tenthuoc, JTextField tf_danhmuc,
    JTextArea ta_thanhphan, JTextArea ta_thongtin, JTextField tf_xuatxu,
    JCheckBox hop, JCheckBox vi, JCheckBox vien, ArrayList<String> chosen,
    DefaultTableModel modelMedic, JSpinner sp_hansd, JComboBox cb_hansd) {
        //kiểm tra form
        Boolean found = false;
        if(tf_tenthuoc.getText().isEmpty() || tf_danhmuc.getText().isEmpty()
        || ta_thanhphan.getText().isEmpty() || ta_thongtin.getText().isEmpty()
        || tf_xuatxu.getText().isEmpty() || sp_hansd.getValue().toString().equals("0")) 
            found = true;

        if(found) return false;
        else {
            //gửi form
            medicine_DAO medDAO = new medicine_DAO();
            ArrayList<medicine_DTO> temp_1 = medDAO.selectAll();
            medicine_DTO med = new medicine_DTO();
            med.setMathuoc("MTH"+advance.calculateID(temp_1.size()));

            //tạo dữ liệu tồn trong kho
            storage_BUS.createStock(med);

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

            String hansudung = sp_hansd.getValue().toString() + " " + cb_hansd.getSelectedItem().toString();
            med.setHansudung(hansudung);

            ArrayList<Double> giaban = new ArrayList<>();
            giaban.add(0.0);
            giaban.add(0.0);
            giaban.add(0.0);
            med.setGiaban(giaban);

            med.setTinhtrang(true);

            medDAO.add(med);
            loadData(modelMedic, true);
            return true;
        }
    }

    public static void resetAdd(JTextField tf_tenthuoc, JTextField tf_danhmuc,
    JTextArea ta_thanhphan, JTextArea ta_thongtin, JCheckBox hop, JCheckBox vi,
    JCheckBox vien, JTextField tf_xuatxu, JComboBox cb_doituong, JLabel ds_doituong,
    ArrayList<String> chosen, JLabel khung_anh, JSpinner sp_hansd, JComboBox cb_hansd) {
        tf_tenthuoc.setText("");
        tf_danhmuc.setText("");
        hop.setSelected(false);
        vi.setSelected(false);
        vien.setSelected(false);
        ta_thanhphan.setText("");
        ta_thongtin.setText("");
        tf_xuatxu.setText("");
        cb_doituong.setSelectedIndex(0);
        ds_doituong.setText("Danh sách đối tượng sử dụng: ");
        chosen.clear();
        sp_hansd.setValue(0);
        cb_hansd.setSelectedIndex(0);
        khung_anh.setIcon(null);
    }

    public static void uploadImage(JLabel khung_anh) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn ảnh");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

        fileChooser.setCurrentDirectory(new File(advance.file_path));
        int ketQua = fileChooser.showOpenDialog(null);
        if(ketQua == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            medicine_DAO medDAO = new medicine_DAO();
            ArrayList<medicine_DTO> temp = medDAO.selectAll();
            String imgPath = advance.medIMG + "MTH" + advance.calculateID(temp.size()) + ".png";
            
            try {
                Files.copy(selectedFile.toPath(), new File(imgPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                ImageIcon anh = new ImageIcon(imgPath);
                Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon anh_scaled = new ImageIcon(anh_scale);
                khung_anh.setIcon(anh_scaled);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Sao chép ảnh thất bại");
            }
        }
    }

    //medicine tìm kiếm
    public static void findMedicine(JSpinner sp_gia_hop, JSpinner sp_gia_vi,
    JSpinner sp_gia_vien, JTextField tf_mathuoc, JTextField tf_tenthuoc,
    JTextField tf_danhmuc, JTextField tf_xuatxu, ArrayList<String> chosen,
    JComboBox cb_tinhtrang, DefaultTableModel modelMedic, DefaultTableModel modelMedicSupply,
    JSpinner sp_hansd, JComboBox cb_hansd) {
        ArrayList<String> allPrice = new ArrayList<>();
        if(!sp_gia_hop.getValue().toString().equals("0.0"))
            allPrice.add(sp_gia_hop.getValue().toString());
        if(!sp_gia_vi.getValue().toString().equals("0.0"))
            allPrice.add(sp_gia_vi.getValue().toString());
        if(!sp_gia_vien.getValue().toString().equals("0.0"))
            allPrice.add(sp_gia_vien.getValue().toString());
        ArrayList<String> condition = new ArrayList<>();
        if(!tf_mathuoc.getText().isEmpty()) condition.add("mathuoc like N'%" + tf_mathuoc.getText() + "%' ");
        if(!tf_tenthuoc.getText().isEmpty()) condition.add("tenthuoc like N'%" + tf_tenthuoc.getText() + "%' ");
        if(!tf_danhmuc.getText().isEmpty()) condition.add("danhmuc like N'%" + tf_danhmuc.getText() + "%' ");
        if(!tf_xuatxu.getText().isEmpty()) condition.add("xuatxu like N'%" + tf_xuatxu.getText() + "%' ");
        if(!chosen.isEmpty()) condition.add("doituongsudung like N'%" + advance.StringArrayListToString(chosen) + "%' ");
        condition.add("giaban like N'%" + advance.StringArrayListToString(allPrice) + "%' ");
        String tt = String.valueOf(cb_tinhtrang.getSelectedItem());
        if(tt.equals("Đang hoạt động")) {
            condition.add("tinhtrang = 1 ");
        } else if (tt.equals("Ngừng hoạt động")) {
            condition.add("tinhtrang = 0 ");
        }
        if(!sp_hansd.getValue().toString().equals("0")) {
            condition.add("hansudung like N'%" + sp_hansd.getValue().toString() + " " + cb_hansd.getSelectedItem().toString() + "%' ");
        }
        String result = String.join("and ", condition);
        System.out.println(result);

        medicine_DAO medDAO = new medicine_DAO();
        ArrayList<medicine_DTO> medicines = medDAO.selectByCondition(result);

        if(modelMedic == null) {
            modelMedicSupply.setRowCount(0);
            for (medicine_DTO medicine : medicines) {
                JLabel statusImg;
                System.out.println(medicine.getTinhtrang());
                if(medicine.getTinhtrang()) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                JButton chooseButton = new JButton("Chọn");
                chooseButton.setForeground(Color.BLACK);
                chooseButton.setFont(new Font(null, Font.PLAIN, 18));
                modelMedicSupply.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), statusImg, chooseButton});
            }
        } else {
            modelMedic.setRowCount(0);
            for (medicine_DTO medicine : medicines) {
                JLabel statusImg;
                System.out.println(medicine.getTinhtrang());
                if(medicine.getTinhtrang()) {
                    statusImg = new JLabel(data.imagePath.resize_check);
                } else {
                    statusImg = new JLabel(data.imagePath.resize_exitIcon);
                }
                JButton eyeButton = new JButton(data.imagePath.resize_eye);
                modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), medicine.getDanhmuc(),
                statusImg, eyeButton});
            }
        }
    }

    public static void resetFind(JTextField tf_mathuoc ,JTextField tf_tenthuoc, 
    JTextField tf_danhmuc, JSpinner sp_gia_hop, JSpinner sp_gia_vi, 
    JSpinner sp_gia_vien, JTextField tf_xuatxu, JComboBox cb_doituong, 
    JLabel ds_doituong, ArrayList<String> chosen, JSpinner sp_hansd, JComboBox cb_hansd) {
        tf_mathuoc.setText("");
        tf_tenthuoc.setText("");
        tf_danhmuc.setText("");
        tf_xuatxu.setText("");
        sp_gia_hop.setValue(0.0);
        sp_gia_vi.setValue(0.0);
        sp_gia_vien.setValue(0.0);
        cb_doituong.setSelectedIndex(0);
        ds_doituong.setText("Danh sách đối tượng sử dụng: ");
        chosen.clear();
        sp_hansd.setValue(0);
        cb_hansd.setSelectedIndex(0);
    }

    //medicine cập nhật
    public static void loadUpdateMedicine(String mathuoc, JTextField tf_tenthuoc,
    JTextField tf_danhmuc, JCheckBox hop, JCheckBox vi, JCheckBox vien,
    JTextArea ta_thanhphan, JTextArea ta_thongtin, JTextField tf_xuatxu,
    ArrayList<String> chosen, JLabel ds_doituong, JLabel khung_anh, JSpinner sp_hansd,
    JComboBox cb_hansd) {
        medicine_DTO med = throwMedicineObj(mathuoc);
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
        String[] time = med.getHansudung().split(" ");
        sp_hansd.setValue(Integer.parseInt(time[0]));
        System.out.println(Integer.parseInt(time[0]));
        if(time[1].equals("tháng")) cb_hansd.setSelectedItem("tháng");
        else cb_hansd.setSelectedItem("năm");
        ImageIcon anh = new ImageIcon(advance.medIMG + mathuoc + ".png");
        Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon anh_scaled = new ImageIcon(anh_scale);
        khung_anh.setIcon(anh_scaled);
    }

    public static Boolean updateMedicine(JTextField tf_tenthuoc, JTextField tf_danhmuc,
    JTextArea ta_thanhphan, JTextArea ta_thongtin, JTextField tf_xuatxu,
    String mathuoc, JCheckBox hop, JCheckBox vi, JCheckBox vien,
    ArrayList<String> chosen, DefaultTableModel modelMedic, JSpinner sp_hansd,
    JComboBox cb_hansd) {
        //kiểm tra form
        Boolean found = false;
        if(tf_tenthuoc.getText().isEmpty() || tf_danhmuc.getText().isEmpty()
        || ta_thanhphan.getText().isEmpty() || ta_thongtin.getText().isEmpty()
        || tf_xuatxu.getText().isEmpty() || sp_hansd.getValue().toString() == "0") found = true;

        if(found) return false;
        else {
            //gửi form
            medicine_DAO medDAO = new medicine_DAO();
            medicine_DTO med = new medicine_DTO();
            medicine_DTO old_med = throwMedicineObj(mathuoc);
            med.setMathuoc(old_med.getMathuoc());

            med.setTenthuoc(tf_tenthuoc.getText());
            med.setDanhmuc(tf_danhmuc.getText());
            
            ArrayList<String> donvi = new ArrayList<>();
            if(hop.isSelected()) donvi.add("hộp");
            if(vi.isSelected()) donvi.add("vỉ");
            if(vien.isSelected()) donvi.add("viên");
            med.setDonvi(donvi);
            
            storage_DTO old_str = throwStorageObj(old_med.getMaton());
            med.setMaton(old_str.getMaton());
            
            med.setThanhphan(ta_thanhphan.getText());
            med.setThongtin(ta_thongtin.getText());
            med.setXuatxu(tf_xuatxu.getText());
            
            if(chosen.size() == 0) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add("Không có chỉ định");
                med.setDoituongsudung(temp);
            } else med.setDoituongsudung(chosen);

            String hansudung = sp_hansd.getValue().toString() + " " + cb_hansd.getSelectedItem().toString();
            med.setHansudung(hansudung);

            med.setGiaban(old_med.getGiaban());

            med.setTinhtrang(true);

            medDAO.update(med);
            loadData(modelMedic, true);
            return true;
        }
    }

    public static void resetUpdate(String mathuoc, JTextField tf_tenthuoc, JTextField tf_danhmuc,
    JCheckBox hop, JCheckBox vi, JCheckBox vien, JTextArea ta_thanhphan,
    JTextArea ta_thongtin, JTextField tf_xuatxu, ArrayList<String> chosen,
    JLabel ds_doituong, JLabel khung_anh, JSpinner sp_hansd, JComboBox cb_hansd) {
        medicine_DTO med = throwMedicineObj(mathuoc);
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
        sp_hansd.setValue(0);
        cb_hansd.setSelectedIndex(0);
        ImageIcon anh = new ImageIcon(advance.medIMG + mathuoc + ".png");
        Image anh_scale = anh.getImage().getScaledInstance(khung_anh.getWidth(), khung_anh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon anh_scaled = new ImageIcon(anh_scale);
        khung_anh.setIcon(anh_scaled);
    }

    //medicine trong orderSupplyAdd
    public static void loadDataOther(DefaultTableModel modelMedic, Boolean flag) {
        modelMedic.setRowCount(0);
        medicine_DAO medDAO = new medicine_DAO();
        ArrayList<medicine_DTO> medicines = medDAO.selectAll();
        for (medicine_DTO medicine : medicines) {
            JLabel statusImg;
            if(medicine.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton chooseButton = new JButton("Chọn");
            chooseButton.setForeground(Color.BLACK);
            chooseButton.setFont(new Font(null, Font.PLAIN, 18));
            if(flag && medicine.getTinhtrang()) 
                modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), statusImg, chooseButton});
            if(!flag)
                modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), statusImg, chooseButton});
        }
    }

    public static void searchMedicineOther(JTextField search_bar, DefaultTableModel modelMedic) {
        ArrayList<medicine_DTO> meds = new ArrayList<>();
        medicine_DAO medDAO = new medicine_DAO();
        meds = medDAO.selectByCondition("tenthuoc like N'%" + search_bar.getText() + "%'");
        modelMedic.setRowCount(0);
        for (medicine_DTO med : meds) {
            JLabel statusImg;
            if(med.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton chooseButton = new JButton("Chọn");
            chooseButton.setForeground(Color.BLACK);
            chooseButton.setFont(new Font(null, Font.PLAIN, 18));
            modelMedic.addRow(new Object[]{med.getMathuoc(), 
            med.getTenthuoc(), statusImg, chooseButton});
        }
    }

    public static void resetOther(JTextField search_bar, JTextField tf_tenthuoc,
    JSpinner sp_gianhap_hop, JSpinner sp_gianhap_vi, JSpinner sp_gianhap_vien,
    JSpinner sp_slnhap_hop, JSpinner sp_slnhap_vi, JSpinner sp_slnhap_vien,
    DefaultTableModel modelMedic) {
        search_bar.setText("Nhập tên thuốc...");
        tf_tenthuoc.setText("");
        sp_gianhap_hop.setValue(0);
        sp_slnhap_hop.setValue(0);
        sp_gianhap_vi.setValue(0);
        sp_slnhap_vi.setValue(0);
        sp_gianhap_vien.setValue(0);
        sp_slnhap_vien.setValue(0);
        loadDataOther(modelMedic, true);
    }

    public static Boolean chooseMedicine(JTable tableMedic, DefaultTableModel modelMedic, JTextField tf_tenthuoc) {
        int selectedRow = tableMedic.getSelectedRow();
        if(selectedRow != -1) {
            String mathuoc = modelMedic.getValueAt(selectedRow, 0).toString();
            medicine_DTO med = throwMedicineObj(mathuoc);
            if(med.getTinhtrang()) {
                tf_tenthuoc.setText(med.getTenthuoc());
                return true;
            } else {
                return false;
            }
        }
        return null;
    }
}
