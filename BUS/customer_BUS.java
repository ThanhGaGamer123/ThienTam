package BUS;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.customer_DAO;
import DTO.customer_DTO;

public class customer_BUS {
    //customer trong orderAdd
    public static void loadData(DefaultTableModel model_kh, Boolean flag) {
        ArrayList<customer_DTO> customers = new customer_DAO().selectAll();
        model_kh.setRowCount(0);
        for (customer_DTO customer : customers) {
            JLabel statusImg;
            if(customer.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            if(flag && customer.getTinhtrang()) {
                model_kh.addRow(new Object[]{customer.getMakh(), customer.getTenkh(),
                customer.getSdt(), statusImg});
            }
            if(!flag) {
                model_kh.addRow(new Object[]{customer.getMakh(), customer.getTenkh(),
                customer.getSdt(), statusImg});
            }
        }
    }

    public static void findCustomer(DefaultTableModel model_kh, JTextField tenkh) {
        String condition = "tenkh like N'%" + tenkh.getText() + "%'";
        System.out.println(condition);
        ArrayList<customer_DTO> customers = new customer_DAO().selectByCondition(condition);
        model_kh.setRowCount(0);
        for (customer_DTO customer : customers) {
            JLabel statusImg;
            if(customer.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            model_kh.addRow(new Object[]{customer.getMakh(), customer.getTenkh(),
            customer.getSdt(), statusImg});
        }
    }

    public static Boolean upData(JTable table, DefaultTableModel model,
    JTextField tenkh, JTextField email, JTextField sdt, JTextArea diachi,
    JTextField diemkm) {
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1) {
            String makh = model.getValueAt(selectedRow, 0).toString();

            customer_DTO customer = new customer_DTO();
            customer.setMakh(makh);
            customer = new customer_DAO().selectByID(customer);

            if(customer.getTinhtrang()) {
                tenkh.setText(customer.getTenkh());
                email.setText(customer.getEmail());
                sdt.setText(customer.getSdt());
                diachi.setText(customer.getMasonha() + ", " + customer.getDuong()+ ", " + 
                customer.getPhuong() + ", " + customer.getQuan() + ", " + customer.getTinh());
                diemkm.setText(String.valueOf(customer.getDiemKM()));

                return true;
            }
        }
        return false;
    }

    public static Boolean chooseCus(JTextField email, customer_DTO cus) {
        if(!email.getText().isEmpty()) {
            ArrayList<customer_DTO> customer = new customer_DAO().selectByCondition(
            "email = N'" + email.getText() + "'");
            cus.setMakh(customer.get(0).getMakh());

            return true;
        } else return false;
    }

    //customer trong customerSearch
    public static void findAdvance(DefaultTableModel model_kh, JTextField makh,
    JTextField tenkh, JTextField sdt, JTextField email, JComboBox tinhtrang) {
        ArrayList<String> condition = new ArrayList<>();
        if(!makh.getText().isEmpty()) condition.add("makh like N'%" + makh.getText() + "%' ");
        if(!tenkh.getText().isEmpty()) condition.add("tenkh like N'%" + tenkh.getText() + "%' ");
        if(!sdt.getText().isEmpty()) condition.add("sdt like N'%" + sdt.getText() + "%' ");
        if(!email.getText().isEmpty()) condition.add("email like N'%" + email.getText() + "%' ");
        if(tinhtrang.getSelectedItem().equals("Đang hoạt động"))
            condition.add("tinhtrang = 1");
        if(tinhtrang.getSelectedItem().equals("Ngừng hoạt động"))
            condition.add("tinhtrang = 0");
        if(tinhtrang.getSelectedItem().equals("Không có"))
            condition.add("makh like N'%%' ");
        String result = String.join("and ", condition);
        System.out.println(result);
        ArrayList<customer_DTO> customers = new customer_DAO().selectByCondition(result);
        model_kh.setRowCount(0);
        for (customer_DTO customer : customers) {
            JLabel statusImg;
            if(customer.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            model_kh.addRow(new Object[]{customer.getMakh(), customer.getTenkh(),
            customer.getSdt(), statusImg});
        }
    }

    public static void reset(DefaultTableModel model_kh, JTextField makh,
    JTextField tenkh, JTextField sdt, JTextField email, JComboBox tinhtrang) {
        makh.setText("");
        tenkh.setText("");
        sdt.setText("");
        email.setText("");
        tinhtrang.setSelectedIndex(0);
        loadData(model_kh, true);
    }

    //Tuấn
    public static String getLastID() {
        customer_DAO dao = new customer_DAO();
        String lastID = dao.autoUpdateMaKH();
        return lastID;
    }

    public static void loadTable(DefaultTableModel table) {
        customer_DAO dao = new customer_DAO();
        table.setRowCount(0);
        for (customer_DTO kh : dao.selectAll()) {
            String diaChi = kh.getMasonha() + "," + kh.getDuong() + "," + kh.getPhuong() + ","
                    + kh.getQuan() + "," + kh.getTinh();
            table.addRow(new Object[] { kh.getMakh(), kh.getTenkh(), kh.getSdt(), kh.getEmail(),
                    diaChi, kh.getPassword(), kh.getDiemKM(), kh.getTinhtrang() });
        }
    }

    public static void insert(customer_DTO kh) {
        customer_DAO dao = new customer_DAO();
        dao.add(kh);
    }

    public static void edit(customer_DTO kh) {
        customer_DAO dao = new customer_DAO();
        dao.update(kh);
    }

    public static void delete(customer_DTO kh) {
        customer_DAO dao = new customer_DAO();
        dao.update1(kh);
    }
}
