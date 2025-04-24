package BUS;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.medicine_DAO;
import DAO.orderSupply_DAO;
import DAO.orderSupply_details_DAO;
import DAO.supplier_DAO;
import DTO.medicine_DTO;
import DTO.orderSupply_DTO;
import DTO.orderSupply_details_DTO;
import DTO.supplier_DTO;
import GUI.orderSupply_GUI.orderSupply_GUI;
import advanceMethod.advance;

public class orderSupply_BUS {
    public static void checkOrderSupply(String mahdnhap, DefaultTableModel modelCollect) {
        ArrayList<orderSupply_details_DTO> osds = new ArrayList<>();
        orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
        osds = osdDAO.selectAll();
        Boolean del = true;
        for (orderSupply_details_DTO osd : osds) {
            if(osd.getMahdnhap().equals(mahdnhap) && osd.getTinhtrang()){
                del = false;
                break;
            }
        }
        if(del) {
            orderSupply_DTO os = new orderSupply_DTO();
            os.setMahdnhap(mahdnhap);
            orderSupply_DAO osDAO = new orderSupply_DAO();
            os = osDAO.selectByID(os);
            os.setTinhtrang(false);
            osDAO.update(os);
            loadData(modelCollect, true);
        }
    }

    //orderSupply trong employee
    public static void loadData(DefaultTableModel modelOrderSupply, Boolean flag) {
        orderSupply_DAO osDAO = new orderSupply_DAO();
        osDAO.loadData(modelOrderSupply, flag);
    }

    public static orderSupply_DTO throwOrderSupplyObj(String mahdnhap) {
        orderSupply_DTO os = new orderSupply_DTO();
        os.setMahdnhap(mahdnhap);
        orderSupply_DAO osDAO = new orderSupply_DAO();
        return osDAO.selectByID(os);
    }

    public static Boolean deleteOrderSupply(JTable tableCollect, DefaultTableModel modelCollect) {
        int selectedRow = tableCollect.getSelectedRow();
        if(selectedRow != -1) {
            String mahdnhap = modelCollect.getValueAt(selectedRow, 0).toString();
            orderSupply_DTO os = throwOrderSupplyObj(mahdnhap);
            if(os.getTinhtrang()) {
                int choice = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn xóa đơn hàng nhập này không?");
                if (choice == 0) {
                    os.setTinhtrang(false);
                    orderSupply_DAO osDAO = new orderSupply_DAO();
                    osDAO.update(os);

                    ArrayList<orderSupply_details_DTO> osds = new ArrayList<>();
                    orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                    osds = osdDAO.selectByCondition("mahdnhap = '" + os.getMahdnhap() + "'");
                    for (orderSupply_details_DTO osd : osds) {
                        osd.setTinhtrang(false);
                        osdDAO.update(osd);
                    }

                    storage_BUS.decreaseStock(osds);
                    orderSupply_BUS.loadData(modelCollect, true);

                    return true;
                }
            } else {
                return false;
            }
        }
        return null;
    }

    public static void findOrderSupplyByID(ArrayList<orderSupply_DTO> orderSupplies, DefaultTableModel modelCollect, JTextField search_bar_2) {
        orderSupplies.clear();
        modelCollect.setRowCount(0);
        String mahdnhap = search_bar_2.getText().toString();
        orderSupply_DTO os = new orderSupply_DTO();
        os.setMahdnhap(mahdnhap);
        orderSupply_DAO osDAO = new orderSupply_DAO();
        os = osDAO.selectByID(os);
        JLabel statusImg;
        if(os.getTinhtrang()) {
            statusImg = new JLabel(data.imagePath.resize_check);
        } else {
            statusImg = new JLabel(data.imagePath.resize_exitIcon);
        }
        JButton eyeButton = new JButton(data.imagePath.resize_eye);
        supplier_DTO sp = new supplier_DTO();
        sp.setMancc(os.getMancc());
        supplier_DAO spDAO = new supplier_DAO();
        sp = spDAO.selectByID(sp);
        modelCollect.addRow(new Object[]{os.getMahdnhap(), sp.getTenncc(), os.getSoloaithuoc(), os.getNgaynhap(), os.getTongtien(), statusImg, eyeButton});
        search_bar_2.setText("");
    }

    public static void supplyFilter(DefaultTableModel modelSupplier, int loc, ArrayList<orderSupply_DTO> orderSupplies) {
        System.out.println(loc);
        if(loc == 1) {
            for(int i = 0; i < orderSupplies.size() - 1; i++) {
                for(int j = i + 1; j < orderSupplies.size(); j++) {
                    if(orderSupplies.get(i).getTongtien() < orderSupplies.get(j).getTongtien()) {
                        orderSupply_DTO temp = orderSupplies.get(i);
                        orderSupplies.set(i, orderSupplies.get(j));
                        orderSupplies.set(j, temp);
                    }
                }
            }
        } else if(loc == 2) {
            for(int i = 0; i < orderSupplies.size() - 1; i++) {
                for(int j = i + 1; j < orderSupplies.size(); j++) {
                    if(orderSupplies.get(i).getTongtien() > orderSupplies.get(j).getTongtien()) {
                        orderSupply_DTO temp = orderSupplies.get(i);
                        orderSupplies.set(i, orderSupplies.get(j));
                        orderSupplies.set(j, temp);
                    }
                }
            }
        } else if(loc == 3) {
            for(int i = 0; i < orderSupplies.size() - 1; i++) {
                for(int j = i + 1; j < orderSupplies.size(); j++) {
                    if(advance.fulldate1BeforeFullDate2(orderSupplies.get(i).getNgaynhap(), orderSupplies.get(j).getNgaynhap())) {
                        orderSupply_DTO temp = orderSupplies.get(i);
                        orderSupplies.set(i, orderSupplies.get(j));
                        orderSupplies.set(j, temp);
                    }
                }
            }
        } else if(loc == 4) {
            for(int i = 0; i < orderSupplies.size() - 1; i++) {
                for(int j = i + 1; j < orderSupplies.size(); j++) {
                    if(!advance.fulldate1BeforeFullDate2(orderSupplies.get(i).getNgaynhap(), orderSupplies.get(j).getNgaynhap())) {
                        orderSupply_DTO temp = orderSupplies.get(i);
                        orderSupplies.set(i, orderSupplies.get(j));
                        orderSupplies.set(j, temp);
                    }
                }
            }
        }

        //lưu vào bảng
        modelSupplier.setRowCount(0);
        for (orderSupply_DTO orderSupply : orderSupplies) {
            JLabel statusImg;
            if(orderSupply.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton eyeButton = new JButton(data.imagePath.resize_eye);

            orderSupply_DAO osDAO = new orderSupply_DAO();
            orderSupply = osDAO.selectByID(orderSupply);

            supplier_DTO sp = new supplier_DTO();
            sp.setMancc(orderSupply.getMancc());
            supplier_DAO spDAO = new supplier_DAO();
            sp = spDAO.selectByID(sp);

            modelSupplier.addRow(new Object[]{orderSupply.getMahdnhap(), sp.getTenncc(),
            orderSupply.getSoloaithuoc(), orderSupply.getNgaynhap(),
            orderSupply.getTongtien(), statusImg, eyeButton});
        }
    }

    public static void orderSupplyFilter(JComboBox loc_2, ArrayList<orderSupply_DTO> orderSupplies, DefaultTableModel modelCollect) {
        int loC = loc_2.getSelectedIndex();
        if(!orderSupplies.isEmpty()) { //ds tìm nâng cao không rỗng
            supplyFilter(modelCollect, loC, orderSupplies);
        } else {
            orderSupply_DAO osDAO = new orderSupply_DAO();
            osDAO.selectAllToArrayList(orderSupplies);
            supplyFilter(modelCollect, loC, orderSupplies);
        }
    }

    public static void reset(JTextField search_bar_2, JComboBox loc_2,
    ArrayList<orderSupply_DTO> orderSupplies, DefaultTableModel modelCollect) {
        search_bar_2.setText("Nhập mã đơn...");
        loc_2.setSelectedIndex(0);
        orderSupplies.clear();
        loadData(modelCollect, true);
    }

    public static void showDetails(JTable tableCollect, DefaultTableModel modelCollect) {
        int selectColumn = tableCollect.getSelectedColumn();
        if(selectColumn == 6) {
            int selectedRow = tableCollect.getSelectedRow();
            if(selectedRow != -1) {
                String mahdnhap = String.valueOf(modelCollect.getValueAt(selectedRow, 0));
                new orderSupply_GUI(mahdnhap, modelCollect);
            }
        }
    }

    //orderSupply chi tiết
    public static void loadOrderDetails(DefaultTableModel modelSupply, String mahdnhap) {
        orderSupply_details_DAO.selectAllToOrderSupply(modelSupply, mahdnhap);
    }

    //orderSupply thêm
    public static void updateTableSupply(DefaultTableModel modelSupply, ArrayList<orderSupply_details_DTO> osds) {
        modelSupply.setRowCount(0);
        for (orderSupply_details_DTO osd : osds) {
            JLabel statusImg;
            if(osd.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton deleteButton = new JButton("Xóa");
            deleteButton.setForeground(Color.BLACK);
            deleteButton.setFont(new Font(null, Font.PLAIN, 18));
            medicine_DTO med = medicine_BUS.throwMedicineObj(osd.getMathuoc());
            modelSupply.addRow(new Object[]{osd.getMacthdnhap(),
            med.getTenthuoc(), advance.DoubleArrayListToString(osd.getGianhap()),
            advance.IntArrayListToString(osd.getSlnhap()), osd.getThanhtien(),
            statusImg, deleteButton});
        }
    }

    public static int addOrderSupply(JTextField tf_nhacc,
    ArrayList<orderSupply_details_DTO> osds, DefaultTableModel modelSupplier,
    DefaultTableModel modelMedic, DefaultTableModel modelSupply,
    JSpinner sp_gianhap_hop, JSpinner sp_gianhap_vi, JSpinner sp_gianhap_vien,
    JSpinner sp_slnhap_hop, JSpinner sp_slnhap_vi, JSpinner sp_slnhap_vien,
    JTextField tf_tenthuoc, JTextField search_bar) {
        if(!osds.isEmpty()) {
            orderSupply_DTO os = new orderSupply_DTO();

            ArrayList<orderSupply_DTO> oss = new ArrayList<>();
            orderSupply_DAO osDAO = new orderSupply_DAO();
            oss = osDAO.selectAll();
            String mahdnhap = "HDN" + advance.calculateID(oss.size());
            os.setMahdnhap(mahdnhap);

            String tenncc = tf_nhacc.getText().toString();
            ArrayList<supplier_DTO> sps = new ArrayList<>();
            supplier_DTO sp = new supplier_DTO();
            supplier_DAO spDAO = new supplier_DAO();
            sps = spDAO.selectByCondition("tenncc = N'" + tenncc + "'");
            
            if(sps.size() != 0 || !sps.isEmpty()) {
                sp = sps.get(0);
                
                if(sp.getTinhtrang()) {
                    os.setMancc(sp.getMancc());

                    os.setSoloaithuoc(osds.size());

                    os.setNgaynhap(advance.currentTime());

                    int tongtien = 0;
                    for (orderSupply_details_DTO osd : osds) {
                        tongtien += osd.getThanhtien();
                    }
                    os.setTongtien(tongtien);

                    os.setTinhtrang(true);

                    osDAO.add(os);

                    orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                    for (orderSupply_details_DTO osd : osds) {
                        osd.setMahdnhap(os.getMahdnhap());
                        osdDAO.add(osd);
                    }

                    loadData(modelSupplier, true);

                    medicine_BUS.updateSellPrice();

                    //cập nhật lượng tồn
                    storage_BUS.increaseStock(osds);

                    osds.clear();

                    resetAdd(tf_nhacc, modelMedic, modelSupply, sp_gianhap_hop, 
                    sp_gianhap_vi, sp_gianhap_vien, sp_slnhap_hop, sp_slnhap_vi, 
                    sp_slnhap_vien, tf_tenthuoc, search_bar, osds);

                    return 0;
                } else return 1;
            } else return 2;
        } else return 3;
    }

    public static void resetAdd(JTextField tf_nhacc, DefaultTableModel modelMedic, 
    DefaultTableModel modelSupply, JSpinner sp_gianhap_hop, 
    JSpinner sp_gianhap_vi, JSpinner sp_gianhap_vien,
    JSpinner sp_slnhap_hop, JSpinner sp_slnhap_vi, JSpinner sp_slnhap_vien,
    JTextField tf_tenthuoc, JTextField search_bar, ArrayList<orderSupply_details_DTO> osds) {
        modelMedic.setRowCount(0);
        modelSupply.setRowCount(0);
        search_bar.setText("Nhập tên thuốc...");
        tf_tenthuoc.setText("");
        sp_gianhap_hop.setValue(0);
        sp_slnhap_hop.setValue(0);
        sp_gianhap_vi.setValue(0);
        sp_slnhap_vi.setValue(0);
        sp_gianhap_vien.setValue(0);
        sp_slnhap_vien.setValue(0);
        tf_nhacc.setText("");
        osds.clear();
        
        medicine_DAO medDAO = new medicine_DAO();
        ArrayList<medicine_DTO> medicines = medDAO.selectAll();
        for (medicine_DTO medicine : medicines) {
            JLabel statusImg;
            if(medicine.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            if(medicine.getTinhtrang()) 
                modelMedic.addRow(new Object[]{medicine.getMathuoc(), 
                medicine.getTenthuoc(), statusImg});
        }
    }

    //orderSupply tìm kiếm
    public static Boolean findOrderSupply(JTextField tf_mandon, JTextField tf_tenncc,
    JTextField tf_ngaynhap, ArrayList<orderSupply_DTO> orderSupplies,
    JComboBox cb_tinhtrang, int loc, DefaultTableModel modelSupplier) {
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
                    orderSupply_DTO orderSupply = new orderSupply_DTO();
                    orderSupply.setMahdnhap(rs.getString("mahdnhap"));
                    orderSupply.setMancc("mancc");
                    tenncc = rs.getString("tenncc");
                    orderSupply.setNgaynhap(rs.getString("ngaynhap"));
                    orderSupply.setSoloaithuoc(rs.getInt("soloaithuoc"));
                    orderSupply.setTinhtrang(rs.getBoolean("tinhtrang"));
                    orderSupply.setTongtien(rs.getInt("tongtien"));
                    if((cb_tinhtrang.getSelectedItem().toString().equals("Đang hoạt động")
                    && orderSupply.getTinhtrang()) 
                    || (cb_tinhtrang.getSelectedItem().toString().equals("Ngừng hoạt động")
                    && !orderSupply.getTinhtrang())
                    || (cb_tinhtrang.getSelectedItem().toString().equals("Không có"))) {
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
                            orderSupply_DTO temp = orderSupplies.get(i);
                            orderSupplies.set(i, orderSupplies.get(j));
                            orderSupplies.set(j, temp);
                        }
                    }
                }
            } else if(loc == 2) {
                for(int i = 0; i < orderSupplies.size() - 1; i++) {
                    for(int j = i + 1; j < orderSupplies.size(); j++) {
                        if(orderSupplies.get(i).getTongtien() > orderSupplies.get(j).getTongtien()) {
                            orderSupply_DTO temp = orderSupplies.get(i);
                            orderSupplies.set(i, orderSupplies.get(j));
                            orderSupplies.set(j, temp);
                        }
                    }
                }
            } else if(loc == 3) {
                for(int i = 0; i < orderSupplies.size() - 1; i++) {
                    for(int j = i + 1; j < orderSupplies.size(); j++) {
                        if(advance.fulldate1BeforeFullDate2(orderSupplies.get(i).getNgaynhap(), orderSupplies.get(j).getNgaynhap())) {
                            orderSupply_DTO temp = orderSupplies.get(i);
                            orderSupplies.set(i, orderSupplies.get(j));
                            orderSupplies.set(j, temp);
                        }
                    }
                }
            } else if(loc == 4) {
                for(int i = 0; i < orderSupplies.size() - 1; i++) {
                    for(int j = i + 1; j < orderSupplies.size(); j++) {
                        if(!advance.fulldate1BeforeFullDate2(orderSupplies.get(i).getNgaynhap(), orderSupplies.get(j).getNgaynhap())) {
                            orderSupply_DTO temp = orderSupplies.get(i);
                            orderSupplies.set(i, orderSupplies.get(j));
                            orderSupplies.set(j, temp);
                        }
                    }
                }
            }

            //lưu vào bảng
            modelSupplier.setRowCount(0);
            for (orderSupply_DTO orderSupply : orderSupplies) {
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
            resetFind(tf_mandon, tf_tenncc, tf_ngaynhap, cb_tinhtrang);

            return true;
        } else {
            return false;
        }
    }

    public static void resetFind(JTextField tf_mandon, JTextField tf_tenncc,
    JTextField tf_ngaynhap, JComboBox cb_tinhtrang) {
        tf_mandon.setText("");
        tf_tenncc.setText("");
        tf_ngaynhap.setText("");
        cb_tinhtrang.setSelectedItem(0);
    }
}
