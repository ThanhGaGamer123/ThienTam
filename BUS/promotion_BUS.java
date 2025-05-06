package BUS;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.customer_DAO;
import DAO.promotion_DAO;
import DTO.customer_DTO;
import DTO.promotion_DTO;
import advanceMethod.advance;

public class promotion_BUS {
    // promotion trong orderAdd_GUI
    public static void loadData(DefaultTableModel model) {
        model.setRowCount(0);
        ArrayList<promotion_DTO> prs = new promotion_DAO().selectAll();
        for (promotion_DTO pr : prs) {
            JLabel statusImg;
            if (pr.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            if (pr.getTinhtrang())
                model.addRow(new Object[] { pr.getMakm(), pr.getTenkm(), pr.getGiam(),
                        pr.getDiem(), statusImg });
        }
    }

    public static void search(DefaultTableModel model, JTextField search) {
        model.setRowCount(0);
        ArrayList<promotion_DTO> prs = new promotion_DAO()
                .selectByCondition(" tenkm like N'%" + search.getText() + "%'");
        for (promotion_DTO pr : prs) {
            JLabel statusImg;
            if (pr.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            model.addRow(new Object[] { pr.getMakm(), pr.getTenkm(), pr.getGiam(), statusImg });
        }
    }

    public static int choosePromotion(DefaultTableModel model, JTable table,
            JTextField tenkh, JTextField adkm, customer_DTO cus, JTextField tongtien) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String makm = model.getValueAt(selectedRow, 0).toString();
            promotion_DTO pro = new promotion_DTO();
            pro.setMakm(makm);
            promotion_DAO proDAO = new promotion_DAO();
            pro = proDAO.selectByID(pro);

            if (pro.getTinhtrang()) {
                if (pro.getDiem() == 0 || !tenkh.getText().isEmpty()) {
                    cus = new customer_DAO().selectByID(cus);
                    if (cus.getDiemKM() >= pro.getDiem()) {
                        adkm.setText(pro.getMakm());
                        double money = Double.parseDouble(tongtien.getText());
                        money = money - money * pro.getGiam() / 100;
                        tongtien.setText(money + "");
                        return 1;
                    } else
                        return 3;
                } else
                    return 4;
            }
        }
        return 2;
    }

    // promotion trong promotionAdd_GUI
    public static void searchAdvance(JTextField makm, JTextField tenkm, JTextField ngaybatdau,
            JTextField ngayketthuc, JTextArea noidung, JSpinner giam, JSpinner diem, JComboBox tinhtrang,
            DefaultTableModel model) {
        ArrayList<String> condition = new ArrayList<>();
        if (!makm.getText().isEmpty())
            condition.add("makm like N'%" + makm.getText() + "%' ");
        if (!tenkm.getText().isEmpty())
            condition.add("tenkm like N'%" + tenkm.getText() + "%' ");
        if (!noidung.getText().isEmpty())
            condition.add("noidung like N'%" + noidung.getText() + "%' ");
        if (!giam.getValue().toString().equals("0"))
            condition.add("giam = " + Integer.parseInt(giam.getValue().toString()) + " ");
        condition.add("diem = " + Integer.parseInt(diem.getValue().toString()) + " ");
        if (tinhtrang.getSelectedItem().equals("Đang hoạt động"))
            condition.add("tinhtrang = 1 ");
        if (tinhtrang.getSelectedItem().equals("Ngừng hoạt động"))
            condition.add("tinhtrang = 0 ");
        String results = String.join("and ", condition);
        System.out.println(results);

        ArrayList<promotion_DTO> prs = new promotion_DAO().selectByCondition(results);
        if (ngaybatdau.getText().isEmpty() || advance.checkDate(ngaybatdau.getText())) {
            if (ngayketthuc.getText().isEmpty() || advance.checkDate(ngayketthuc.getText())) {
                model.setRowCount(0);
                for (promotion_DTO pr : prs) {
                    if ((ngaybatdau.getText().isEmpty() && ngayketthuc.getText().isEmpty())
                            || (!ngaybatdau.getText().isEmpty() && ngayketthuc.getText().isEmpty()
                                    && (!advance.date1BeforeDate2(pr.getNgaybatdau(), ngaybatdau.getText())
                                            || advance.date1EqualDate2(pr.getNgaybatdau(), ngaybatdau.getText())))
                            || (ngaybatdau.getText().isEmpty() && !ngayketthuc.getText().isEmpty()
                                    && (advance.date1BeforeDate2(pr.getNgayketthuc(), ngayketthuc.getText())
                                            || advance.date1EqualDate2(pr.getNgayketthuc(), ngayketthuc.getText())))
                            || ((!advance.date1BeforeDate2(pr.getNgaybatdau(), ngaybatdau.getText())
                                    || advance.date1EqualDate2(pr.getNgaybatdau(), ngaybatdau.getText()))
                                    && (advance.date1BeforeDate2(pr.getNgayketthuc(), ngayketthuc.getText())
                                            || advance.date1EqualDate2(pr.getNgayketthuc(), ngayketthuc.getText())))) {
                        JLabel statusImg;
                        if (pr.getTinhtrang()) {
                            statusImg = new JLabel(data.imagePath.resize_check);
                        } else {
                            statusImg = new JLabel(data.imagePath.resize_exitIcon);
                        }
                        model.addRow(new Object[] { pr.getMakm(), pr.getTenkm(),
                                pr.getGiam(), statusImg });
                    }
                }
            } else
                JOptionPane.showMessageDialog(null,
                        "Ngày kết thúc không hợp lệ");
        } else
            JOptionPane.showMessageDialog(null,
                    "Ngày bắt đầu không hợp lệ");
    }

    public static void checkExpired(promotion_DTO pro) {
        String[] current = advance.currentTime().split(" ");
        String ngayketthuc = pro.getNgayketthuc();

        if (advance.date1BeforeDate2(ngayketthuc, current[1])) {
            pro.setTinhtrang(false);
            promotion_DAO proDAO = new promotion_DAO();
            proDAO.update(pro);

            System.out.println("XÓA!!!");
        }
    }

    public static void autoCheckExpired() {
        ArrayList<promotion_DTO> pros = new promotion_DAO().selectAll();
        for (promotion_DTO pro : pros) {
            if (pro.getTinhtrang())
                checkExpired(pro);
        }
    }

    // Tuấn
    public static String getLastID() {
        promotion_DAO dao = new promotion_DAO();
        String lastID = dao.autoUpdateMaKM();
        return lastID;
    }

    public static void insert(promotion_DTO pro) {
        promotion_DAO dao = new promotion_DAO();
        dao.add(pro);
    }

    public static void edit(promotion_DTO pro) {
        promotion_DAO dao = new promotion_DAO();
        dao.update(pro);
    }

    public static void delete(promotion_DTO pro) {
        promotion_DAO dao = new promotion_DAO();
        dao.update1(pro);
    }

    public static void loadTable(DefaultTableModel table) {
        promotion_DAO dao = new promotion_DAO();
        table.setRowCount(0);
        for (promotion_DTO pro : dao.selectAll()) {
            JLabel statusImg;
            if (pro.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            table.addRow(new Object[] { pro.getMakm(), pro.getTenkm(), pro.getNgaybatdau(), pro.getNgayketthuc(),
                    pro.getGiam(), pro.getNoidung(), pro.getDiem(), statusImg });
        }
    }

    public static ArrayList<promotion_DTO> getAll() {
        promotion_DAO dao = new promotion_DAO();
        return dao.selectAll();
    }
}
