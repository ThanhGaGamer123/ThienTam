package BUS;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.customer_DAO;
import DAO.employee_DAO;
import DAO.medicine_DAO;
import DAO.orderSupply_details_DAO;
import DAO.order_DAO;
import DAO.order_details_DAO;
import DAO.promotion_DAO;
import DAO.promotion_details_DAO;
import DAO.store_DAO;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.medicine_DTO;
import DTO.orderSupply_details_DTO;
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

            if(!ord.getTinhtrang().equals("Đã hủy"))
                model.addRow(new Object[]{ord.getMadon(), cus.getTenkh(), em.getTennv(),
                ord.getNgaydat(), ord.getTongtien(), ord.getTinhtrang(), eyeButton});
        }
    }

    public static int cancelOrder(DefaultTableModel model, JTable table) {
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1) {
            String mahd = model.getValueAt(selectedRow, 0).toString();
            order_DTO ord = new order_DTO();
            ord.setMadon(mahd);
            order_DAO ordDAO = new order_DAO();
            ord = ordDAO.selectByID(ord);
            
            if(!ord.getTinhtrang().equals("Đã hủy")) {
                if(!ord.getTinhtrang().equals("Đã giao")) {
                    int choice = JOptionPane.showConfirmDialog(null, 
                    "Bạn có chắc muốn xóa không?");
                    if(choice == 0) {
                        ord.setTinhtrang("Đã hủy");
                        ordDAO.update(ord);
                        loadData(model);
    
                        return 0;
                    } else return -1;
                } else return 2;
            }
        }

        return 1;
    }

    public static void findOrder(JTextField search, DefaultTableModel model) {
        model.setRowCount(0);
        if(!search.getText().isEmpty()) {
            ArrayList<order_DTO> ord = new order_DAO().selectByCondition("madon like N'%" + search.getText() + "%'");

            customer_DTO cus = new customer_DTO();
            cus.setMakh(ord.get(0).getMakh());
            cus = new customer_DAO().selectByID(cus);

            employee_DTO em = new employee_DTO();
            em.setManv(ord.get(0).getManv());
            em = new employee_DAO().selectByID(em);

            JButton eyeButton = new JButton(data.imagePath.resize_eye);

            model.addRow(new Object[]{ord.get(0).getMadon(), cus.getTenkh(), em.getTennv(),
            ord.get(0).getNgaydat(), ord.get(0).getTongtien(), ord.get(0).getTinhtrang(), eyeButton});
        }
    }

    //order trong orderAdd_GUI
    public static void purchase(customer_DTO cus, employee_DTO em,
    ArrayList<order_details_DTO> ods, JTextField tenkh, JTextField tennv, JTextArea diachi,
    JTextField tongtien) {
        cus = new customer_DAO().selectByID(cus);

        tenkh.setText(cus.getTenkh());
        tennv.setText(em.getTennv());

        store_DTO store = new store_DTO();
        store.setMant(em.getManhathuoc());
        store = new store_DAO().selectByID(store);

        diachi.setText(store.getMasonha() + ", " + store.getDuong() + ", " + store.getPhuong()
        + ", " + store.getQuan() + ", " + store.getTinh());

        double tongtienTT = 0.0;
        for (order_details_DTO od : ods) {
            tongtienTT += od.getThanhtien();
        }
        tongtien.setText("" + tongtienTT);
    }

    public static Boolean completeOrder(customer_DTO cus, employee_DTO em, JTextField tongtien, 
    ArrayList<order_details_DTO> ods, JTextField adkm, DefaultTableModel modelOrder) {
        if(!ods.isEmpty()) {
            //đơn hàng
            order_DTO ord = new order_DTO();
            ArrayList<order_DTO> ords = new ArrayList<>();
            order_DAO ordDAO = new order_DAO();
            ords = ordDAO.selectAll();

            ord.setMadon("DH" + advance.calculateID(ords.size()));
            ord.setMakh(cus.getMakh());
            ord.setManv(em.getManv());
            ord.setDiachicuthe(em.getMasonha() + ", " + em.getDuong());
            ord.setPhuong(em.getPhuong());
            ord.setQuan(em.getQuan());
            ord.setTinh(em.getTinh());
            ord.setNgaydat(advance.currentTime());
            ord.setPttt("Trả bằng tiền mặt");
            ord.setTinhtrang("Đang xử lý");
            ord.setTongtien(Double.parseDouble(tongtien.getText()));
            ord.setGhichu(null);
            ord.setNguoinhan(null);
            ord.setSdt_nguoinhan(null);

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
                
                //trừ điểm tích lũy
                promotion_DTO pr = new promotion_DTO();
                pr.setMakm(adkm.getText());
                pr = new promotion_DAO().selectByID(pr);

                customer_DAO cusDAO = new customer_DAO();
                cus = cusDAO.selectByID(cus);

                if(cus.getDiemKM() - pr.getDiem() >= 0) {
                    cus.setDiemKM(cus.getDiemKM() - pr.getDiem());
                } else cus.setDiemKM(0);
                
                cusDAO.update(cus);
            }

            loadData(modelOrder);

            return true;
        } else return false;
    }

    //order trong orderSearch_GUI
    public static int findAdvance(JTextField madon, JTextField tenkh, JTextField tennv,
    JTextField ngaybatdau, JTextField ngayketthuc, JComboBox pttt, JComboBox tinhtrang,
    int loc, DefaultTableModel model, ArrayList<order_DTO> ords) {
        ArrayList<String> condition = new ArrayList<>();
        if(!madon.getText().isEmpty())
            condition.add("madon like N'%" + madon.getText() + "%' ");
        if(!tenkh.getText().isEmpty()) {
            ArrayList<String> condition2 = new ArrayList<>();
            ArrayList<customer_DTO> cus = new customer_DAO().selectByCondition("tenkh like N'%" + tenkh.getText() + "%' ");
            for (customer_DTO kh : cus) {
                condition2.add("makh like N'%" + kh.getMakh() + "%' ");
            }
            condition.add(String.join("or ", condition2));
        }
        if(!tennv.getText().isEmpty()) {
            ArrayList<String> condition2 = new ArrayList<>();
            ArrayList<employee_DTO> em = new employee_DAO().selectByCondition("tennv like N'%" + tennv.getText() + "%' ");
            for (employee_DTO nv : em) {
                condition2.add("manv like N'%" + nv.getManv() + "%' ");
            }
            condition.add(String.join("or ", condition2));
        }
        if(!pttt.getSelectedItem().equals("Không có"))
            condition.add("pttt like N'%" + pttt.getSelectedItem() + "%' ");
        else condition.add("pttt like N'%%' ");
        if(!tinhtrang.getSelectedItem().equals("Không có"))
            condition.add("tinhtrang like N'%" + tinhtrang.getSelectedItem() + "%' ");
        else condition.add("tinhtrang like N'%%' ");
        String result = String.join("and ", condition);
        System.out.println(result);

        ArrayList<order_DTO> temp = new order_DAO().selectByCondition(result);

        //ktra ngày
        if(ngaybatdau.getText().isEmpty() || advance.checkDate(ngaybatdau.getText())) {
            if(ngayketthuc.getText().isEmpty() || advance.checkDate(ngayketthuc.getText())) {
                ArrayList<order_DTO> ods = new ArrayList<>();
                for (order_DTO od : temp) {
                    String[] time = od.getNgaydat().split(" ");
                    if(((ngaybatdau.getText().isEmpty() || ngaybatdau.getText().equals("dd/MM/yyyy"))
                    && (ngayketthuc.getText().isEmpty() || ngayketthuc.getText().equals("dd/MM/yyyy")))
                    || ((!ngaybatdau.getText().isEmpty() || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                    && (ngayketthuc.getText().isEmpty() || ngayketthuc.getText().equals("dd/MM/yyyy"))
                    && (advance.date1BeforeDate2(ngaybatdau.getText(), time[1]) || advance.date1EqualDate2(ngaybatdau.getText(), time[1])))
                    || ((ngaybatdau.getText().isEmpty() || ngaybatdau.getText().equals("dd/MM/yyyy"))
                    && (!ngayketthuc.getText().isEmpty() || !ngayketthuc.getText().equals("dd/MM/yyyy"))
                    && (advance.date1BeforeDate2(time[1], ngayketthuc.getText()) || advance.date1EqualDate2(ngayketthuc.getText(), time[1])))
                    || ((!ngaybatdau.getText().isEmpty() || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                    && (!ngayketthuc.getText().isEmpty() || !ngayketthuc.getText().equals("dd/MM/yyyy"))
                    && (advance.date1BeforeDate2(time[1], ngayketthuc.getText()) || advance.date1EqualDate2(ngayketthuc.getText(), time[1]))
                    && (advance.date1BeforeDate2(ngaybatdau.getText(), time[1]) || advance.date1EqualDate2(ngaybatdau.getText(), time[1])))) {
                        ods.add(od);
                    }
                }

                //lọc
                System.out.println(loc);
                if(loc == 1) {
                    for(int i = 0; i < ods.size() - 1; i++) {
                        for(int j = i + 1; j < ods.size(); j++) {
                            if(ods.get(i).getTongtien() < ods.get(j).getTongtien()) {
                                order_DTO TEMP = ods.get(i);
                                ods.set(i, ods.get(j));
                                ods.set(j, TEMP);
                            }
                        }
                    }
                } else if(loc == 2) {
                    for(int i = 0; i < ods.size() - 1; i++) {
                        for(int j = i + 1; j < ods.size(); j++) {
                            if(ods.get(i).getTongtien() > ods.get(j).getTongtien()) {
                                order_DTO TEMP = ods.get(i);
                                ods.set(i, ods.get(j));
                                ods.set(j, TEMP);
                            }
                        }
                    }
                } else if(loc == 3) {
                    for(int i = 0; i < ods.size() - 1; i++) {
                        for(int j = i + 1; j < ods.size(); j++) {
                            if(advance.fulldate1BeforeFullDate2(ods.get(i).getNgaydat(), ods.get(j).getNgaydat())) {
                                order_DTO TEMP = ods.get(i);
                                ods.set(i, ods.get(j));
                                ods.set(j, TEMP);
                            }
                        }
                    }
                } else if(loc == 4) {
                    for(int i = 0; i < ods.size() - 1; i++) {
                        for(int j = i + 1; j < ods.size(); j++) {
                            if(!advance.fulldate1BeforeFullDate2(ods.get(i).getNgaydat(), ods.get(j).getNgaydat())) {
                                order_DTO TEMP = ods.get(i);
                                ods.set(i, ods.get(j));
                                ods.set(j, TEMP);
                            }
                        }
                    }
                }

                //lưu vào bảng
                model.setRowCount(0);
                ords.addAll(ods);
                for (order_DTO ord : ods) {
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

                return 1;
            } else return 3;
        } else return 2;
    }

    public static void resetFind(JTextField madon, JTextField tenkh, JTextField tennv,
    JTextField ngaybatdau, JTextField ngayketthuc, JComboBox pttt, JComboBox tinhtrang,
    DefaultTableModel model) {
        madon.setText("");
        tenkh.setText("");
        tennv.setText("");
        ngaybatdau.setText("");
        ngayketthuc.setText("");
        pttt.setSelectedIndex(0);
        tinhtrang.setSelectedIndex(0);
    }

    public static void filter(ArrayList<order_DTO> ords, DefaultTableModel model, int loc) {
        ArrayList<order_DTO> temp = new ArrayList<>();
        if(!ords.isEmpty()) {
            temp.addAll(ords);
        } else {
            temp = new order_DAO().selectAll();
        }
        System.out.println(ords.size());
        System.out.println(temp.size());

        //lọc
        System.out.println(loc);
        if(loc == 1) {
            for(int i = 0; i < temp.size() - 1; i++) {
                for(int j = i + 1; j < temp.size(); j++) {
                    if(temp.get(i).getTongtien() < temp.get(j).getTongtien()) {
                        order_DTO TEMP = temp.get(i);
                        temp.set(i, temp.get(j));
                        temp.set(j, TEMP);
                    }
                }
            }
        } else if(loc == 2) {
            for(int i = 0; i < temp.size() - 1; i++) {
                for(int j = i + 1; j < temp.size(); j++) {
                    if(temp.get(i).getTongtien() > temp.get(j).getTongtien()) {
                        order_DTO TEMP = temp.get(i);
                        temp.set(i, temp.get(j));
                        temp.set(j, TEMP);
                    }
                }
            }
        } else if(loc == 3) {
            for(int i = 0; i < temp.size() - 1; i++) {
                for(int j = i + 1; j < temp.size(); j++) {
                    if(advance.fulldate1BeforeFullDate2(temp.get(i).getNgaydat(), temp.get(j).getNgaydat())) {
                        order_DTO TEMP = temp.get(i);
                        temp.set(i, temp.get(j));
                        temp.set(j, TEMP);
                    }
                }
            }
        } else if(loc == 4) {
            for(int i = 0; i < temp.size() - 1; i++) {
                for(int j = i + 1; j < temp.size(); j++) {
                    if(!advance.fulldate1BeforeFullDate2(temp.get(i).getNgaydat(), temp.get(j).getNgaydat())) {
                        order_DTO TEMP = temp.get(i);
                        temp.set(i, temp.get(j));
                        temp.set(j, TEMP);
                    }
                }
            }
        }

        //lưu vào bảng
        model.setRowCount(0);
        for (order_DTO ord : temp) {
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

    //order trong orderGUI
    public static void loadOrder(String madh, JTextField madon, JTextField makh,
    JTextField tenkh, JTextField manv, JTextField tennv, JTextArea diachi, JTextField ngaydat,
    JComboBox tinhtrang, JTextField tongtien, JTextField pttt, JTextArea ghichu,
    JTextField nguoinhan, JTextField sdt_nguoinhan, DefaultTableModel model, JTextField makm,
    JTextField tenkm) {
        order_DTO ord = new order_DTO();
        ord.setMadon(madh);
        order_DAO ordDAO = new order_DAO();
        ord = ordDAO.selectByID(ord);

        madon.setText(ord.getMadon());
        
        customer_DTO cus = new customer_DTO();
        cus.setMakh(ord.getMakh());
        customer_DAO cusDAO = new customer_DAO();
        cus = cusDAO.selectByID(cus);

        if(cus.getMakh() != null && !cus.getMakh().isEmpty()) makh.setText(cus.getMakh());
        else makh.setText("Không có");
        if(cus.getTenkh() != null && !cus.getTenkh().isEmpty()) tenkh.setText(cus.getTenkh());
        else tenkh.setText("Không có");

        employee_DTO em = new employee_DTO();
        em.setManv(ord.getManv());
        employee_DAO emDAO = new employee_DAO();
        em = emDAO.selectByID(em);

        manv.setText(em.getManv());
        tennv.setText(em.getTennv());

        diachi.setText(ord.getDiachicuthe() + ", " + ord.getPhuong()
        + ", " + ord.getQuan() + ", " + ord.getTinh());

        ngaydat.setText(ord.getNgaydat());

        if(ord.getTinhtrang().equals("Đang xử lý")) 
            tinhtrang.setSelectedIndex(0);
        if(ord.getTinhtrang().equals("Đã xử lý")) 
            tinhtrang.setSelectedIndex(1);
        if(ord.getTinhtrang().equals("Đã giao")) 
            tinhtrang.setSelectedIndex(2);
        if(ord.getTinhtrang().equals("Đã hủy")) 
            tinhtrang.setSelectedIndex(3);

        tongtien.setText("" + ord.getTongtien());
        pttt.setText(ord.getPttt());
        if(ord.getGhichu() != null && !ord.getGhichu().isEmpty()) ghichu.setText(ord.getGhichu());
        else ghichu.setText("Không có");

        if(ord.getNguoinhan() != null && !ord.getNguoinhan().isEmpty()) nguoinhan.setText(ord.getNguoinhan());
        else nguoinhan.setText("Không có");

        if(ord.getSdt_nguoinhan() != null) sdt_nguoinhan.setText(ord.getSdt_nguoinhan());
        else sdt_nguoinhan.setText("Không có");

        Boolean flag = false;
        ArrayList<promotion_details_DTO> prods = new promotion_details_DAO().selectAll();
        for (promotion_details_DTO prod : prods) {
            if(prod.getMadon().equals(ord.getMadon())) {
                promotion_DTO pro = new promotion_DTO();
                pro.setMakm(prod.getMakm());
                pro = new promotion_DAO().selectByID(pro);

                makm.setText(pro.getMakm());
                tenkm.setText(pro.getTenkm());

                flag = true;
                break;
            }
        }
        if(!flag) {
            makm.setText("Không có");
            tenkm.setText("Không có");
        }

        ArrayList<order_details_DTO> ods = new order_details_DAO().selectByCondition("madon like N'%" + ord.getMadon() + "%' ");
        model.setRowCount(0);
        for (order_details_DTO od : ods) {
            orderSupply_details_DTO osd = new orderSupply_details_DTO();
            osd.setMacthdnhap(od.getMacthdnhap());
            orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
            osd = osdDAO.selectByID(osd);

            medicine_DTO med = new medicine_DTO();
            med.setMathuoc(osd.getMathuoc());
            medicine_DAO medDAO = new medicine_DAO();
            med = medDAO.selectByID(med);

            JLabel statusImg;
            if(osd.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            JButton delete = new JButton("Thu hồi");
            delete.setForeground(Color.black);
            delete.setFont(new Font(null, Font.PLAIN, 18));

            model.addRow(new Object[]{od.getMactdh(), med.getTenthuoc(), od.getDonvi(),
            od.getSl(), od.getDongia(), od.getThanhtien(), od.getMacthdnhap(), statusImg,
            delete});
        }
    }

    public static int updateStatus(JComboBox capnhat, String mahd) {
        order_DTO ord = new order_DTO();
        ord.setMadon(mahd);
        order_DAO ordDAO = new order_DAO();
        ord = ordDAO.selectByID(ord);

        if(ord.getTinhtrang().equals("Đang xử lý")) {
            if(capnhat.getSelectedItem().equals("Đã giao")) {
                //Tăng điểm tích lũy
                double diem = ord.getTongtien() * 1 / 100;

                customer_DTO cus = new customer_DTO();
                cus.setMakh(ord.getMakh());
                cus = new customer_DAO().selectByID(cus);
                cus.setDiemKM(cus.getDiemKM() + (int) Math.round(diem));
                customer_DAO cusDAO = new customer_DAO();
                cusDAO.update(cus);

                System.out.println(ord.getTongtien());
                System.out.println(diem);
                System.out.println(cus.getDiemKM());
            }
            ord.setTinhtrang(capnhat.getSelectedItem().toString());
        } else if(ord.getTinhtrang().equals("Đã xử lý")) {
            if(!capnhat.getSelectedItem().equals("Đang xử lý")) {
                if(capnhat.getSelectedItem().equals("Đã giao")) {
                    //Tăng điểm tích lũy
                    double diem = ord.getTongtien() * (1 / 100);

                    customer_DTO cus = new customer_DTO();
                    cus.setMakh(ord.getMakh());
                    cus = new customer_DAO().selectByID(cus);
                    cus.setDiemKM(cus.getDiemKM() + (int) Math.round(diem));
                    customer_DAO cusDAO = new customer_DAO();
                    cusDAO.update(cus);
                }
                ord.setTinhtrang(capnhat.getSelectedItem().toString());
            }
            else {
                capnhat.setSelectedItem(1);
                return 3;
            };
        } else if(ord.getTinhtrang().equals("Đã giao")) {
            capnhat.setSelectedIndex(2);
            return 4;
        } else {
            capnhat.setSelectedIndex(3);
            return 2;
        }

        ordDAO.update(ord);
        return 1;
    }

    public static Boolean deleteOrderDetail(DefaultTableModel model, JTable table,
    DefaultTableModel modelCollect) {
        int selectedColumn = table.getSelectedColumn();
        if(selectedColumn == 8) {
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1) {
                String mactdh = model.getValueAt(selectedRow, 0).toString();
                order_details_DTO od = new order_details_DTO();
                od.setMactdh(mactdh);
                order_details_DAO odDAO = new order_details_DAO();
                od = odDAO.selectByID(od);

                if(od.getTinhtrang()) {
                    int choice = JOptionPane.showConfirmDialog(null, 
                    "Bạn có chắc muốn thu hồi không?");
                    if(choice == 0) {
                        od.setTinhtrang(false);
                        odDAO.update(od);

                        orderSupply_details_BUS.deleteOrderSupplyDetail(od.getMacthdnhap(),
                        modelCollect);

                        order_DTO ord = new order_DTO();
                        ord.setMadon(od.getMadon());
                        ord = new order_DAO().selectByID(ord);

                        customer_DTO cus = new customer_DTO();
                        cus.setMakh(ord.getMakh());
                        cus = new customer_DAO().selectByID(cus);

                        //bồi thường cho khách (10%)
                        double diem = od.getThanhtien() * 10 / 100;
                        cus.setDiemKM(cus.getDiemKM() + (int) Math.round(diem));
                        customer_DAO cusDAO = new customer_DAO();
                        cusDAO.update(cus);
                    
                        return true;
                    }
                } else return false;
            }
        }

        return null;
    }
}
