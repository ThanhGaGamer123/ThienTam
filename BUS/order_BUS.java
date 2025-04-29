package BUS;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.customer_DAO;
import DAO.employee_DAO;
import DAO.order_DAO;
import DAO.order_details_DAO;
import DAO.promotion_DAO;
import DAO.promotion_details_DAO;
import DAO.store_DAO;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.order_DTO;
import DTO.order_details_DTO;
import DTO.promotion_DTO;
import DTO.promotion_details_DTO;
import DTO.store_DTO;
import advanceMethod.advance;

public class order_BUS {
    //order trong employee_GUI
    public static void loadData(DefaultTableModel model) {
        ArrayList<order_DTO> ords = new order_DAO().selectAll();
        model.setRowCount(0);
        for (order_DTO ord : ords) {
            customer_DTO cus = new customer_DTO();
            cus.setMakh(ord.getMakh());
            cus = new customer_DAO().selectByID(cus);

            employee_DTO em = new employee_DTO();
            em.setManv(ord.getManv());
            em = new employee_DAO().selectByID(em);

            JButton eyeButton = new JButton(data.imagePath.resize_eye);
            model.addRow(new Object[]{ord.getMadon(), cus.getTenkh(), em.getTennv(),
            ord.getNgaydat(), ord.getTongtien(), ord.getTinhtrang(), eyeButton});
        }
    }

    //order trong orderAdd_GUI
    public static Boolean purchase(customer_DTO cus, employee_DTO em, DefaultTableModel model,
    ArrayList<order_details_DTO> ods, JTextField tenkh, JTextField tennv, JTextArea diachi,
    JTextField adkm, JTextField tongtien, JTable table) {
        cus = new customer_DAO().selectByID(cus);

        tenkh.setText(cus.getTenkh());
        tennv.setText(em.getTennv());

        store_DTO store = new store_DTO();
        store.setMant(em.getManhathuoc());
        store = new store_DAO().selectByID(store);

        diachi.setText(store.getMasonha() + ", " + store.getDuong() + ", " + store.getPhuong()
        + ", " + store.getQuan() + ", " + store.getTinh());

        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1) {
            String makm = model.getValueAt(selectedRow, 0).toString();
            adkm.setText(makm);
        }

        double tongtienTT = 0.0;
        for (order_details_DTO od : ods) {
            tongtienTT += od.getThanhtien();
        }
        tongtien.setText("" + tongtienTT);
        
        
        if(!tenkh.getText().isEmpty() && !adkm.getText().isEmpty()) {
            promotion_DTO pr = new promotion_DTO();
            pr.setMakm(adkm.getText());
            pr = new promotion_DAO().selectByID(pr);
            if(cus.getDiemKM() >= pr.getDiem()) {
                tongtienTT = tongtienTT - (tongtienTT * pr.getGiam() / 100);
                tongtien.setText("" + tongtienTT);
            } else if(cus.getDiemKM() < pr.getDiem()) {
                adkm.setText("");
                return false;
            }
        }

        return true;
    }

    public static Boolean completeOrder(customer_DTO cus, employee_DTO em, JTextField tongtien, 
    ArrayList<order_details_DTO> ods, JTextField adkm, DefaultTableModel modelOrder) {
        if(!ods.isEmpty()) {
            //đơn hàng
            order_DTO ord = new order_DTO();
            ArrayList<order_DTO> ords = new ArrayList<>();
            order_DAO ordDAO = new order_DAO();
            ords = ordDAO.selectAll();

            ord.setMadon("ĐH" + advance.calculateID(ords.size()));
            ord.setMakh(cus.getMakh());
            ord.setManv(em.getManv());
            ord.setMasonha(em.getMasonha());
            ord.setDuong(em.getDuong());
            ord.setQuan(em.getQuan());
            ord.setTinh(em.getTinh());
            ord.setNgaydat(advance.currentTime());
            ord.setTinhtrang("Đang xử lý");
            ord.setTongtien(Double.parseDouble(tongtien.getText()));
            ord.setGhichu(null);
            ord.setNguoinhan(null);
            ord.setSdt_nguoinhan(0);

            ordDAO.add(ord);

            //chi tiết đơn hàng
            order_details_DAO odDAO = new order_details_DAO();
            for (order_details_DTO od : ods) {
                od.setMadon(ord.getMadon());
                odDAO.add(od);
            }

            //chi tiết khuyến mãi
            if(!adkm.getText().isEmpty()) {
                promotion_details_DTO proD = new promotion_details_DTO();
                ArrayList<promotion_details_DTO> proDs = new ArrayList<>();
                promotion_details_DAO proDDAO = new promotion_details_DAO();
                proDs = proDDAO.selectAll();

                proD.setMactkm("CTKM" + advance.calculateID(proDs.size()));
                proD.setMadon(ord.getMadon());
                proD.setMakm(adkm.getText());
                proD.setNgayapdung(advance.currentTime());
                proD.setTinhtrang(true);

                proDDAO.add(proD);
            }

            //trừ điểm tích lũy
            if(!adkm.getText().isEmpty()) {
                promotion_DTO pr = new promotion_DTO();
                pr.setMakm(adkm.getText());
                pr = new promotion_DAO().selectByID(pr);
                if(cus.getDiemKM() - pr.getDiem() >= 0) {
                    cus.setDiemKM(cus.getDiemKM() - pr.getDiem());
                } else cus.setDiemKM(0);
            }

            loadData(modelOrder);

            return true;
        } else return false;
    }
}
