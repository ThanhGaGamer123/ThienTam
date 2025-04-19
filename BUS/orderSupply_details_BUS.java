package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.orderSupply_details_DAO;
import DTO.orderSupply_details_DTO;
import advanceMethod.advance;

public class orderSupply_details_BUS {
    //orderSupply_details trong orderSupply
    public static void addOrderSupplyDetails(ArrayList<orderSupply_details_DTO> osds,
    DefaultTableModel modelMedic, JTable tableMedic, JTextField tf_slnhap_hop,
    JTextField tf_slnhap_vi, JTextField tf_slnhap_vien, JTextField tf_gianhap_hop,
    JTextField tf_gianhap_vi, JTextField tf_gianhap_vien, DefaultTableModel modelSupply,
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

        ArrayList<Integer> gianhap = new ArrayList<>();
        Boolean flag = false;
        ArrayList<Integer> sl = new ArrayList<>();
        if (!tf_slnhap_hop.getText().isEmpty() && advance.checkTextField(tf_slnhap_hop.getText())) {
            sl.add(Integer.parseInt(tf_slnhap_hop.getText().toString()));
        } else if (tf_slnhap_hop.getText().isEmpty()) {
            sl.add(0);
        } else flag = true;
        if (!tf_slnhap_vi.getText().isEmpty() && advance.checkTextField(tf_slnhap_vi.getText())) {
            sl.add(Integer.parseInt(tf_slnhap_vi.getText().toString()));
        } else if (tf_slnhap_vi.getText().isEmpty()) {
            sl.add(0);
        } else flag = true;
        if (!tf_slnhap_vien.getText().isEmpty() && advance.checkTextField(tf_slnhap_vien.getText())) {
            sl.add(Integer.parseInt(tf_slnhap_vien.getText().toString()));
        } else if (tf_slnhap_vien.getText().isEmpty()) {
            sl.add(0);
        } else flag = true;
        osd.setSlnhap(sl);
        osd.setSlcon(sl);

        if(!flag) {
            flag = false;
            if (!tf_gianhap_hop.getText().isEmpty() && !tf_slnhap_hop.getText().isEmpty() && advance.checkTextField(tf_gianhap_hop.getText())) {
                gianhap.add(Integer.parseInt(tf_gianhap_hop.getText().toString()));
            } else if (tf_gianhap_hop.getText().isEmpty()) {
                gianhap.add(0);
            } else flag = true;
            if (!tf_gianhap_vi.getText().isEmpty() && !tf_slnhap_vi.getText().isEmpty() && advance.checkTextField(tf_gianhap_vi.getText())) {
                gianhap.add(Integer.parseInt(tf_gianhap_vi.getText().toString()));
            } else if (tf_gianhap_vi.getText().isEmpty()) {
                gianhap.add(0);
            } else flag = true;
            if (!tf_gianhap_vien.getText().isEmpty() && !tf_slnhap_vien.getText().isEmpty() && advance.checkTextField(tf_gianhap_vien.getText())) {
                gianhap.add(Integer.parseInt(tf_gianhap_vien.getText().toString()));
            } else if (tf_gianhap_vien.getText().isEmpty()) {
                gianhap.add(0);
            } else flag = true;
            osd.setGianhap(gianhap);

            if (!flag) {
                int thanhtien = 0;
                for(int i = 0; i < 3; i++) {
                    thanhtien = thanhtien + osd.getGianhap().get(i) * osd.getSlnhap().get(i);
                }
                osd.setThanhtien(thanhtien);

                osd.setTinhtrang(true);

                osds.add(osd);

                orderSupply_BUS.updateTableSupply(modelSupply, osds);

                tf_tenthuoc.setText("");
                tf_gianhap_hop.setText("");
                tf_slnhap_hop.setText("");
                tf_gianhap_vi.setText("");
                tf_slnhap_vi.setText("");
                tf_gianhap_vien.setText("");
                tf_slnhap_vien.setText("");
            } else JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ hoặc không có số lượng!");
        } else JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
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
                int i = 0 + osds2.size() + 1;
                for (orderSupply_details_DTO osd : osds) {
                    osd.setMacthdnhap("CTN" + advance.calculateID(i));
                    i++;
                }

                orderSupply_BUS.updateTableSupply(modelSupply, osds);
            }
        }
    }
}
