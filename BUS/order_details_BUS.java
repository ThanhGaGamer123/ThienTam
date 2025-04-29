package BUS;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.medicine_DAO;
import DAO.orderSupply_DAO;
import DAO.orderSupply_details_DAO;
import DAO.order_details_DAO;
import DTO.medicine_DTO;
import DTO.orderSupply_DTO;
import DTO.orderSupply_details_DTO;
import DTO.order_details_DTO;
import advanceMethod.advance;

public class order_details_BUS {
    //order detail trong orderAdd
    public static void loadData(ArrayList<order_details_DTO> ods, DefaultTableModel model) {
        model.setRowCount(0);
        for (order_details_DTO od : ods) {
            JButton xoa = new JButton("Xóa");
            xoa.setForeground(Color.black);
            xoa.setFont(new Font(null, Font.PLAIN, 18));

            orderSupply_details_DTO osd = new orderSupply_details_DTO();
            osd.setMacthdnhap(od.getMacthdnhap());
            osd = new orderSupply_details_DAO().selectByID(osd);
        
            medicine_DTO med = new medicine_DTO();
            med.setMathuoc(osd.getMathuoc());
            med = new medicine_DAO().selectByID(med);

            model.addRow(new Object[]{od.getMactdh(), med.getTenthuoc(), od.getDonvi(),
            od.getSl(), od.getDongia(), od.getThanhtien(), xoa});
        }
    }

    public static int addOrderDetails(medicine_DTO med, JRadioButton hop, 
    JRadioButton vi, JRadioButton vien, JTextField slhop, JTextField slvi, 
    JTextField slvien, JTextField giaban, JSpinner slmua, ArrayList<order_details_DTO> ods,
    DefaultTableModel model, DefaultTableModel modelCollect, JTextField tf_tenthuoc) {
        if(tf_tenthuoc.getText().isEmpty()) {
            return -1;
        }
        
        if(!hop.isSelected() && !vi.isSelected() && !vien.isSelected()) {
            return -2;
        }

        int slcon = 0;
        medicine_DAO medDAO = new medicine_DAO();
        med = medDAO.selectByID(med);
        ArrayList<String> dsctdhnhap = medicine_BUS.updateSellPrice(med);
        String ctdhnhap = new String();
        String donvi = new String();
        if(hop.isSelected()) {
            slcon = Integer.parseInt(slhop.getText());
            ctdhnhap = dsctdhnhap.get(0);
            donvi = "hộp";
        }
        if(vi.isSelected()) {
            slcon = Integer.parseInt(slvi.getText());
            ctdhnhap = dsctdhnhap.get(1);
            donvi = "vỉ";
        }
        if(vien.isSelected()) {
            slcon = Integer.parseInt(slvien.getText());
            ctdhnhap = dsctdhnhap.get(2);
            donvi = "viên";
        }
        if(Integer.parseInt(slmua.getValue().toString()) <= slcon) {
            ArrayList<order_details_DTO> ods2 = new ArrayList<>();
            order_details_DAO odDAO = new order_details_DAO();
            ods2 = odDAO.selectAll();

            order_details_DTO od = new order_details_DTO();
            od.setMactdh("CTĐH" + advance.calculateID(0 + ods.size() + ods2.size()));
            od.setSl(Integer.parseInt(slmua.getValue().toString()));
            od.setDonvi(donvi);
            od.setDongia(Double.parseDouble(giaban.getText()));
            od.setThanhtien(od.getSl() * od.getDongia());
            od.setMacthdnhap(ctdhnhap);
            od.setMadon(null);
            od.setTinhtrang(true);

            //giảm sl trong cthdn -> ktra hdn -> xóa hdn nếu cần
            orderSupply_details_BUS.checkOrderSupplyDetail(od.getMacthdnhap(), donvi, 
            Integer.parseInt(slmua.getValue().toString()), modelCollect);

            ods.add(od);
            loadData(ods, model);

            dsctdhnhap.clear();
            dsctdhnhap = medicine_BUS.updateSellPrice(med);
            for (int i = 0; i < 3; i++) {
                if(!dsctdhnhap.get(i).equals("null")) {
                    orderSupply_details_DTO osd = new orderSupply_details_DTO();
                    osd.setMacthdnhap(dsctdhnhap.get(i));
                    orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                    osd = osdDAO.selectByID(osd);

                    if(i == 0) slhop.setText(osd.getSlcon().get(i).toString());
                    if(i == 1) slvi.setText(osd.getSlcon().get(i).toString());
                    if(i == 2) slvien.setText(osd.getSlcon().get(i).toString());
                } else {
                    if(i == 0) slhop.setText("0");
                    if(i == 1) slvi.setText("0");
                    if(i == 2) slvien.setText("0");
                }
            }

            if(hop.isSelected())
                    medicine_BUS.radioDonVi(med, giaban, 0);
            if(vi.isSelected())
                    medicine_BUS.radioDonVi(med, giaban, 1);
            if(vien.isSelected())
                    medicine_BUS.radioDonVi(med, giaban, 2);

            return 2;
        } else if(slcon == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void deleteOrderDetails(ArrayList<order_details_DTO> ods, 
    DefaultTableModel model, JTable table, JRadioButton hop, 
    JRadioButton vi, JRadioButton vien, JTextField slhop, JTextField slvi, 
    JTextField slvien, JTextField giaban) {
        int selectedColumn = table.getSelectedColumn();
        if(selectedColumn == 6) {
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1) {
                String macthd = model.getValueAt(selectedRow, 0).toString();
                order_details_DTO temp = new order_details_DTO();
                for (order_details_DTO od : ods) {
                    if(od.getMactdh().equals(macthd)) temp = od;
                }
                ods.remove(temp);
                ArrayList<order_details_DTO> ods2 = new ArrayList<>();
                order_details_DAO odDAO = new order_details_DAO();
                ods2 = odDAO.selectAll();
                int i = 0 + ods2.size();
                for (order_details_DTO od : ods) {
                    od.setMactdh("CTĐH" + advance.calculateID(i));
                    i++;
                }

                //khôi phục lại trạng thái và sl
                orderSupply_details_DTO osd = new orderSupply_details_DTO();
                osd.setMacthdnhap(temp.getMacthdnhap());
                orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
                osd = osdDAO.selectByID(osd);

                if(!osd.getTinhtrang()) osd.setTinhtrang(true);
                if(temp.getDonvi().equals("hộp")) 
                    osd.getSlcon().set(0, osd.getSlcon().get(0) + temp.getSl());
                if(temp.getDonvi().equals("vỉ")) 
                    osd.getSlcon().set(1, osd.getSlcon().get(1) + temp.getSl());
                if(temp.getDonvi().equals("viên")) 
                    osd.getSlcon().set(2, osd.getSlcon().get(2) + temp.getSl());
                osdDAO.update(osd);
                storage_BUS.loadQuantity(osd);

                orderSupply_DTO os = new orderSupply_DTO();
                os.setMahdnhap(osd.getMahdnhap());
                orderSupply_DAO osDAO = new orderSupply_DAO();
                os = osDAO.selectByID(os);

                if(!os.getTinhtrang()) os.setTinhtrang(true);
                osDAO.update(os);
                
                medicine_DTO med = new medicine_DTO();
                med.setMathuoc(osd.getMathuoc());
                medicine_DAO medDAO = new medicine_DAO();
                med = medDAO.selectByID(med);
                ArrayList<String> dsctdhnhap = medicine_BUS.updateSellPrice(med);
                
                loadData(ods, model);

                for (int j = 0; j < 3; j++) {
                    if(!dsctdhnhap.get(j).equals("null")) {
                        osd = new orderSupply_details_DTO();
                        osd.setMacthdnhap(dsctdhnhap.get(j));
                        osdDAO = new orderSupply_details_DAO();
                        osd = osdDAO.selectByID(osd);
    
                        if(j == 0) slhop.setText(osd.getSlcon().get(j).toString());
                        if(j == 1) slvi.setText(osd.getSlcon().get(j).toString());
                        if(j == 2) slvien.setText(osd.getSlcon().get(j).toString());
                    } else {
                        if(j == 0) slhop.setText("0");
                        if(j == 1) slvi.setText("0");
                        if(j == 2) slvien.setText("0");
                    }
                }
    
                if(hop.isSelected())
                        medicine_BUS.radioDonVi(med, giaban, 0);
                if(vi.isSelected())
                        medicine_BUS.radioDonVi(med, giaban, 1);
                if(vien.isSelected())
                        medicine_BUS.radioDonVi(med, giaban, 2);
            }
        }
    }
}
