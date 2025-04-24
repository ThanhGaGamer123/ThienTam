package BUS;

import java.util.ArrayList;

import javax.swing.JLabel;

import DAO.store_DAO;
import DTO.employee_DTO;
import DTO.store_DTO;
import GUI.store_GUI;

public class employee_BUS {
    public static void loadData(employee_DTO nv, JLabel manv, JLabel tennv, JLabel chucvu,
    JLabel gioitinh, JLabel cccd, JLabel sdt, JLabel diachi, JLabel nhathuoc, JLabel tinhtrang) {
        manv.setText(manv.getText() + nv.getManv());
        tennv.setText(tennv.getText() + nv.getTennv());
        chucvu.setText(chucvu.getText() + nv.getChucvu());
        gioitinh.setText(gioitinh.getText() + nv.getGioitinh());
        cccd.setText(cccd.getText() + nv.getCccd());
        sdt.setText(sdt.getText() + nv.getSdt());
        diachi.setText(diachi.getText() + nv.getMasonha() + ", " + nv.getDuong() + ", "
        + nv.getPhuong() + ", " + nv.getQuan() + ", " + nv.getTinh());
        nhathuoc.setText(nhathuoc.getText() + nv.getManhathuoc());
        if(nv.getTinhtrang()) tinhtrang.setText(tinhtrang.getText() + "Đang hoạt động");
        else tinhtrang.setText(tinhtrang.getText() + "Ngừng hoạt động");
    }

    public static Boolean showStore(employee_DTO nv) {
        store_DAO strDAO = new store_DAO();
        ArrayList<store_DTO> storeArr = strDAO.selectAll();
        for(store_DTO nt : storeArr) {
            if(nv.getManhathuoc().equals(nt.getMant())) {
                new store_GUI(nt);
                return true;
            }
        }
        return false;
    }
}
