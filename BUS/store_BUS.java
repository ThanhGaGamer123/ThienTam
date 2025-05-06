package BUS;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import DAO.store_DAO;
import DTO.employee_DTO;
import DTO.store_DTO;

public class store_BUS {
    public static void loadData(store_DTO nt, JLabel mant, JLabel manql, JLabel diachi, JLabel tinhtrang) {
        mant.setText(mant.getText() + nt.getMant());
        diachi.setText(diachi.getText() + nt.getMasonha() + ", " + nt.getDuong() + ", " + nt.getPhuong() + ", "
                + nt.getQuan() + ", " + nt.getTinh());
        manql.setText(manql.getText() + nt.getManql());
        if (nt.getTinhtrang())
            tinhtrang.setText(tinhtrang.getText() + "Đang hoạt động");
        else
            tinhtrang.setText(tinhtrang.getText() + "Ngừng hoạt động");
    }

    // Tuấn
    public static ArrayList<store_DTO> getAll() {
        store_DAO dao = new store_DAO();
        return dao.selectAll();
    }

    public static void insert(store_DTO st) {
        store_DAO dao = new store_DAO();
        dao.add(st);
    }

    public static void edit(store_DTO st) {
        store_DAO dao = new store_DAO();
        dao.update(st);
    }

    public static void delete(store_DTO st) {
        store_DAO dao = new store_DAO();
        dao.update1(st);
    }

    public static void loadTable(DefaultTableModel table) {
        store_DAO dao = new store_DAO();
        table.setRowCount(0);
        for (store_DTO kh : dao.selectAll()) {
            String diaChi = kh.getMasonha() + "," + kh.getDuong() + "," + kh.getPhuong() + ","
                    + kh.getQuan() + "," + kh.getTinh();
            String nql = null;
            ArrayList<employee_DTO> employeelist = new ArrayList<>();
            employeelist = employee_BUS.getAll();
            for (employee_DTO st : employeelist) {
                if (st.getManv().equals(kh.getManql())) {
                    nql = st.getTennv();
                }
            }
            JLabel statusImg;
            if (kh.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            table.addRow(new Object[] { kh.getMant(), diaChi, nql, statusImg });
        }
    }

    public static String getLastID() {
        store_DAO dao = new store_DAO();
        String lastID = dao.autoUpdateMaNT();
        return lastID;
    }
}
