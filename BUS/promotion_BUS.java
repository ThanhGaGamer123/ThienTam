package BUS;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.promotion_DAO;
import DTO.promotion_DTO;
import advanceMethod.advance;

public class promotion_BUS {
    //promotion trong orderAdd_GUI
    public static void loadData(DefaultTableModel model) {
        model.setRowCount(0);
        ArrayList<promotion_DTO> prs = new promotion_DAO().selectAll();
        for (promotion_DTO pr : prs) {
            JLabel statusImg;
            if(pr.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            model.addRow(new Object[]{pr.getMakm(), pr.getTenkm(), pr.getGiam(), statusImg});
        }
    }

    public static void search(DefaultTableModel model, JTextField search) {
        model.setRowCount(0);
        ArrayList<promotion_DTO> prs = new promotion_DAO().selectByCondition(" tenkm like N'%" + search.getText() + "%'");
        for (promotion_DTO pr : prs) {
            JLabel statusImg;
            if(pr.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            model.addRow(new Object[]{pr.getMakm(), pr.getTenkm(), pr.getGiam(), statusImg});
        }
    }

    //promotion trong promotionAdd_GUI
    public static void searchAdvance(JTextField makm, JTextField tenkm, JTextField ngaybatdau,
    JTextField ngayketthuc, JTextArea noidung, JSpinner giam, JSpinner diem, JComboBox tinhtrang,
    DefaultTableModel model) {
        ArrayList<String> condition = new ArrayList<>();
        if(!makm.getText().isEmpty()) condition.add("makm like N'%" + makm.getText() + "%' ");
        if(!tenkm.getText().isEmpty()) condition.add("tenkm like N'%" + tenkm.getText() + "%' ");
        if(!noidung.getText().isEmpty()) condition.add("noidung like N'%" + noidung.getText() + "%' ");
        if(!giam.getValue().toString().equals("0")) 
            condition.add("giam = " + Integer.parseInt(giam.getValue().toString()) + " ");
        condition.add("diem = " + Integer.parseInt(diem.getValue().toString()) + " ");
        if(tinhtrang.getSelectedItem().equals("Đang hoạt động"))
            condition.add("tinhtrang = 1 ");
        if(tinhtrang.getSelectedItem().equals("Ngừng hoạt động"))
            condition.add("tinhtrang = 0 ");
        String results = String.join("and ", condition);
        System.out.println(results);

        ArrayList<promotion_DTO> prs = new promotion_DAO().selectByCondition(results);
        if(ngaybatdau.getText().isEmpty() || advance.checkDate(ngaybatdau.getText())) {
            if(ngayketthuc.getText().isEmpty() || advance.checkDate(ngayketthuc.getText())) {
                model.setRowCount(0);
                for (promotion_DTO pr : prs) {
                    if((ngaybatdau.getText().isEmpty() && ngayketthuc.getText().isEmpty())
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
                        if(pr.getTinhtrang()) {
                            statusImg = new JLabel(data.imagePath.resize_check);
                        } else {
                            statusImg = new JLabel(data.imagePath.resize_exitIcon);
                        }
                        model.addRow(new Object[]{pr.getMakm(), pr.getTenkm(), 
                        pr.getGiam(), statusImg});
                    }
                }
            } else 
                JOptionPane.showMessageDialog(null, 
                "Ngày kết thúc không hợp lệ");
        } else 
            JOptionPane.showMessageDialog(null, 
            "Ngày bắt đầu không hợp lệ");
    }
}
