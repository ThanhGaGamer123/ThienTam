package BUS;

import javax.swing.table.DefaultTableModel;

import DAO.supplier_DAO;
import DTO.supplier_DTO;

public class supplier_BUS {
    //Tuấn
    public static void loadTable(DefaultTableModel table) {
        supplier_DAO dao = new supplier_DAO();
        table.setRowCount(0);
        for (supplier_DTO supplier : dao.selectAll()) {
            String diaChi = supplier.getMasonha() + "," + supplier.getDuong() + "," + supplier.getPhuong() + ","
                    + supplier.getQuan() + "," + supplier.getTinh();
            table.addRow(new Object[] { supplier.getMancc(), supplier.getTenncc(), supplier.getSdt(),
                    diaChi, supplier.getTinhtrang() });
        }
    }

    public static String getLastID() {
        supplier_DAO dao = new supplier_DAO();
        String lastID = dao.autoUpdateMaNCC();
        return lastID;
    }

    public static void insert(supplier_DTO sup) {
        supplier_DAO dao = new supplier_DAO();
        dao.add(sup);
    }

    public static void delete(supplier_DTO sup) {
        supplier_DAO dao = new supplier_DAO();
        dao.update1(sup);
    }

    public static void edit(supplier_DTO sup) {
        supplier_DAO dao = new supplier_DAO();
        dao.update(sup);
    }
}
