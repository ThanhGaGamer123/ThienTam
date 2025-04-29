package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.orderSupply_details_DAO;
import DTO.medicine_DTO;
import DTO.orderSupply_details_DTO;
import advanceMethod.advance;

public class orderSupply_details_BUS {
    //orderSupply_details của medicine trong orderSupplyAdd
    public static Boolean addOrderSupplyDetails(ArrayList<orderSupply_details_DTO> osds,
    DefaultTableModel modelMedic, JTable tableMedic, JSpinner sp_slnhap_hop,
    JSpinner sp_slnhap_vi, JSpinner sp_slnhap_vien, JSpinner sp_gianhap_hop,
    JSpinner sp_gianhap_vi, JSpinner sp_gianhap_vien, DefaultTableModel modelSupply,
    JTextField tf_tenthuoc) {
        orderSupply_details_DTO osd = new orderSupply_details_DTO();
        ArrayList<orderSupply_details_DTO> osds2 = new ArrayList<>();
        orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
        osds2 = osdDAO.selectAll();

        String macthdnhap = "CTN" + advance.calculateID(osds.size() + osds2.size());
        osd.setMacthdnhap(macthdnhap);

        int selectedRow = tableMedic.getSelectedRow();
        if(selectedRow != -1) {
            String mathuoc = modelMedic.getValueAt(selectedRow, 0).toString();
            osd.setMathuoc(mathuoc);
        }

        ArrayList<Double> gianhap = new ArrayList<>();
        ArrayList<Integer> sl = new ArrayList<>();
        sl.add(Integer.parseInt(sp_slnhap_hop.getValue().toString()));
        sl.add(Integer.parseInt(sp_slnhap_vi.getValue().toString()));
        sl.add(Integer.parseInt(sp_slnhap_vien.getValue().toString()));
        osd.setSlnhap(sl);
        osd.setSlcon(sl);

        gianhap.add(Double.parseDouble(sp_gianhap_hop.getValue().toString()));
        gianhap.add(Double.parseDouble(sp_gianhap_vi.getValue().toString()));
        gianhap.add(Double.parseDouble(sp_gianhap_vien.getValue().toString()));
        osd.setGianhap(gianhap);

        double thanhtien = 0;
        for(int i = 0; i < 3; i++) {
            thanhtien = thanhtien + osd.getGianhap().get(i) * osd.getSlnhap().get(i);
        }
        osd.setThanhtien(thanhtien);

        osd.setTinhtrang(true);

        if(!tf_tenthuoc.getText().isEmpty()) {
            osds.add(osd);

            orderSupply_BUS.updateTableSupply(modelSupply, osds);
    
            sp_gianhap_hop.setValue(0);
            sp_slnhap_hop.setValue(0);
            sp_gianhap_vi.setValue(0);
            sp_slnhap_vi.setValue(0);
            sp_gianhap_vien.setValue(0);
            sp_slnhap_vien.setValue(0);

            return true;
        }
        else {
            orderSupply_BUS.updateTableSupply(modelSupply, osds);
    
            sp_gianhap_hop.setValue(0);
            sp_slnhap_hop.setValue(0);
            sp_gianhap_vi.setValue(0);
            sp_slnhap_vi.setValue(0);
            sp_gianhap_vien.setValue(0);
            sp_slnhap_vien.setValue(0);

            return false;
        }
    }

    public static void deleteOrderSupplyDetails(JTable tableSupply,
    DefaultTableModel modelSupply, ArrayList<orderSupply_details_DTO> osds) {
        int selectedColumn = tableSupply.getSelectedColumn();
        if(selectedColumn == 6) {
            int selectedRow = tableSupply.getSelectedRow();
            if(selectedRow != -1) {
                String macthdnhap = modelSupply.getValueAt(selectedRow, 0).toString();
                orderSupply_details_DTO temp = new orderSupply_details_DTO();
                for (orderSupply_details_DTO osd : osds) {
                    if(osd.getMacthdnhap().equals(macthdnhap)) {
                        temp = osd;
                    }
                }
                osds.remove(temp);

                ArrayList<orderSupply_details_DTO> osds2 = new ArrayList<>();
                orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                osds2 = osdDAO.selectAll();
                int i = 0 + osds2.size();
                for (orderSupply_details_DTO osd : osds) {
                    osd.setMacthdnhap("CTN" + advance.calculateID(i));
                    i++;
                }

                orderSupply_BUS.updateTableSupply(modelSupply, osds);
            }
        }
    }

    //orderSupply_details trong oderSupply chi tiết
    public static Boolean deleteOrderSupplyDetail(DefaultTableModel modelSupply, 
    JTable tableSupply, String mahdnhap, DefaultTableModel modelCollect) {
        int selectedColumn = tableSupply.getSelectedColumn();
        if(selectedColumn == 7) {
            int selectedRow = tableSupply.getSelectedRow();
            if(selectedRow != -1) {
                int choice = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn xóa thông tin thuốc này không?");
                if(choice == 0) {
                    String macthdnhap = modelSupply.getValueAt(selectedRow, 0).toString();
                    orderSupply_details_DTO osd = new orderSupply_details_DTO();
                    osd.setMacthdnhap(macthdnhap);
                    orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                    osd = osdDAO.selectByID(osd);
                    if(osd.getTinhtrang()) {
                        osd.setTinhtrang(false);
                        osdDAO.update(osd);
                        
                        storage_BUS.decreaseStock(osd);
                        orderSupply_BUS.checkOrderSupply(mahdnhap, modelCollect);

                        medicine_DTO med = medicine_BUS.throwMedicineObj(osd.getMathuoc());
                        medicine_BUS.updateSellPrice(med);

                        orderSupply_BUS.loadOrderDetails(modelSupply, mahdnhap);

                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return null;
        }
        return null;
    }

    //orderSupply_details trong order_details_BUS
    public static void deleteOrderSupplyDetail(String macthdnhap, DefaultTableModel modelCollect) {
        orderSupply_details_DTO osd = new orderSupply_details_DTO();
        osd.setMacthdnhap(macthdnhap);
        orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
        osd = osdDAO.selectByID(osd);
        if(osd.getTinhtrang()) {
            osd.setTinhtrang(false);
            osdDAO.update(osd);
            
            storage_BUS.loadQuantity(osd);
            orderSupply_BUS.checkOrderSupply(osd.getMahdnhap(), modelCollect);

            medicine_DTO med = medicine_BUS.throwMedicineObj(osd.getMathuoc());
            medicine_BUS.updateSellPrice(med);
        }
    }

    public static void checkOrderSupplyDetail(String mactdhnhap, String donvi, int sl,
    DefaultTableModel modelCollect) {
        orderSupply_details_DTO osd = new orderSupply_details_DTO();
        osd.setMacthdnhap(mactdhnhap);
        orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
        osd = osdDAO.selectByID(osd);

        if(donvi.equals("hộp"))
            osd.getSlcon().set(0, osd.getSlcon().get(0) - sl);
        if(donvi.equals("vỉ"))
            osd.getSlcon().set(1, osd.getSlcon().get(1) - sl);
        if(donvi.equals("viên"))
            osd.getSlcon().set(2, osd.getSlcon().get(2) - sl);

        osdDAO.update(osd);

        if(osd.getSlcon().get(0) == 0 && osd.getSlcon().get(1) == 0
        && osd.getSlcon().get(2) == 0) {
            deleteOrderSupplyDetail(osd.getMacthdnhap(), modelCollect);
        }
    } 
}
