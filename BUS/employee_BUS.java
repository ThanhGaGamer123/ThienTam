package BUS;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import DAO.employee_DAO;
import DAO.orderSupply_DAO;
import DAO.order_DAO;
import DAO.store_DAO;
import DTO.employee_DTO;
import DTO.orderSupply_DTO;
import DTO.order_DTO;
import DTO.store_DTO;
import GUI.store_GUI;
import advanceMethod.advance;

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
        if (nv.getTinhtrang())
            tinhtrang.setText(tinhtrang.getText() + "Đang hoạt động");
        else
            tinhtrang.setText(tinhtrang.getText() + "Ngừng hoạt động");
    }

    public static Boolean showStore(employee_DTO nv) {
        store_DAO strDAO = new store_DAO();
        ArrayList<store_DTO> storeArr = strDAO.selectAll();
        for (store_DTO nt : storeArr) {
            if (nv.getManhathuoc().equals(nt.getMant())) {
                new store_GUI(nt);
                return true;
            }
        }
        return false;
    }

    // thống kê
    public static int loadStatistic(JTextField ngaybatdau, JTextField ngayketthuc,
            JLabel wallet, JLabel customer, employee_DTO em, JComboBox loai) {
        ArrayList<order_DTO> ords = new order_DAO().selectAll();
        double money = 0.0;
        int slkhach = 0;

        for (order_DTO ord : ords) {
            if (ord.getTinhtrang().equals("Đã giao")
                    && ord.getManv().equals(em.getManv())) {
                if (ngaybatdau.getText().isEmpty() || ngaybatdau.getText().equals("dd/MM/yyyy")
                        || advance.checkDate(ngaybatdau.getText())) {
                    if (ngayketthuc.getText().isEmpty() || ngayketthuc.getText().equals("dd/MM/yyyy")
                            || advance.checkDate(ngayketthuc.getText())) {
                        String[] time = ord.getNgaydat().split(" ");
                        if (((ngaybatdau.getText().isEmpty() || ngaybatdau.getText().equals("dd/MM/yyyy"))
                                && (ngayketthuc.getText().isEmpty() || ngayketthuc.getText().equals("dd/MM/yyyy")))
                                || ((!ngaybatdau.getText().isEmpty() || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                                        && (ngayketthuc.getText().isEmpty()
                                                || ngayketthuc.getText().equals("dd/MM/yyyy"))
                                        && (advance.date1BeforeDate2(ngaybatdau.getText(), time[1])
                                                || advance.date1EqualDate2(ngaybatdau.getText(), time[1])))
                                || ((ngaybatdau.getText().isEmpty() || ngaybatdau.getText().equals("dd/MM/yyyy"))
                                        && (!ngayketthuc.getText().isEmpty()
                                                || !ngayketthuc.getText().equals("dd/MM/yyyy"))
                                        && (advance.date1BeforeDate2(time[1], ngayketthuc.getText())
                                                || advance.date1EqualDate2(ngayketthuc.getText(), time[1])))
                                || ((!ngaybatdau.getText().isEmpty() || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                                        && (!ngayketthuc.getText().isEmpty()
                                                || !ngayketthuc.getText().equals("dd/MM/yyyy"))
                                        && (advance.date1BeforeDate2(time[1], ngayketthuc.getText())
                                                || advance.date1EqualDate2(ngayketthuc.getText(), time[1]))
                                        && (advance.date1BeforeDate2(ngaybatdau.getText(), time[1])
                                                || advance.date1EqualDate2(ngaybatdau.getText(), time[1])))) {
                            slkhach++;
                            money += ord.getTongtien();
                        }
                    } else
                        return 2;
                } else
                    return 1;
            }
        }

        String tien = advance.formatNumber((int) Math.round(money));
        wallet.setText(tien + " VND");
        String khach = advance.formatNumber(slkhach);
        customer.setText(khach);

        return 0;
    }

    public static void loadMap(DefaultCategoryDataset dataset, JComboBox loai,
            JTextField ngaybatdau, JTextField ngayketthuc, employee_DTO em) {
        String ngaybd = "-1", ngaykt = "-1";
        String thangbatdau = "-1", thangketthuc = "-1";
        String nambatdau = "-1", namketthuc = "-1";

        if (ngaybatdau.getText().isEmpty()
                || ngaybatdau.getText().equals("dd/MM/yyyy")
                || advance.checkDate(ngaybatdau.getText())) {
            System.out.println(1);
            if (ngayketthuc.getText().isEmpty()
                    || ngayketthuc.getText().equals("dd/MM/yyyy")
                    || advance.checkDate(ngayketthuc.getText())) {
                System.out.println(2);

                System.out.println(ngaybatdau.getText());
                System.out.println(ngayketthuc.getText());

                if ((ngaybatdau.getText().isEmpty()
                        || ngaybatdau.getText().equals("dd/MM/yyyy"))
                        && (ngayketthuc.getText().isEmpty()
                                || ngayketthuc.getText().equals("dd/MM/yyyy"))) {
                    ArrayList<order_DTO> ords = new order_DAO().selectAll();
                    for (order_DTO ord : ords) {
                        if (ord.getTinhtrang().equals("Đã giao") &&
                                ord.getManv().equals(em.getManv())) {
                            String[] time = ord.getNgaydat().split(" ");
                            String[] time2 = time[1].split("/");
                            ngaybd = time2[0];
                            thangbatdau = time2[1];
                            nambatdau = time2[2];

                            break;
                        }
                    }

                    String[] time = advance.currentDate().split("/");
                    ngaykt = time[0];
                    thangketthuc = time[1];
                    namketthuc = time[2];

                    System.out.println(3);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                } else if ((!ngaybatdau.getText().isEmpty()
                        || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                        && (ngayketthuc.getText().isEmpty()
                                || ngayketthuc.getText().equals("dd/MM/yyyy"))) {
                    String[] time = ngaybatdau.getText().split("/");
                    ngaybd = time[0];
                    thangbatdau = time[1];
                    nambatdau = time[2];

                    String[] time2 = advance.currentDate().split("/");
                    ngaykt = time2[0];
                    thangketthuc = time2[1];
                    namketthuc = time2[2];

                    System.out.println(4);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                } else if ((!ngayketthuc.getText().isEmpty()
                        || !ngayketthuc.getText().equals("dd/MM/yyyy"))
                        && (ngaybatdau.getText().isEmpty()
                                || ngaybatdau.getText().equals("dd/MM/yyyy"))) {
                    ArrayList<order_DTO> ords = new order_DAO().selectAll();
                    for (order_DTO ord : ords) {
                        if (ord.getTinhtrang().equals("Đã giao") &&
                                ord.getManv().equals(em.getManv())) {
                            String[] time = ord.getNgaydat().split(" ");
                            String[] time2 = time[1].split("/");
                            ngaybd = time2[0];
                            thangbatdau = time2[1];
                            nambatdau = time2[2];

                            break;
                        }
                    }

                    String[] time = ngayketthuc.getText().split("/");
                    ngaykt = time[0];
                    thangketthuc = time[1];
                    namketthuc = time[2];

                    System.out.println(5);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                } else if ((!ngaybatdau.getText().isEmpty()
                        || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                        && (!ngayketthuc.getText().isEmpty()
                                || !ngayketthuc.getText().equals("dd/MM/yyyy"))) {
                    String[] time = ngaybatdau.getText().split("/");
                    ngaybd = time[0];
                    thangbatdau = time[1];
                    nambatdau = time[2];

                    String[] time2 = ngayketthuc.getText().split("/");
                    ngaykt = time2[0];
                    thangketthuc = time2[1];
                    namketthuc = time2[2];

                    System.out.println(6);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                }
            }
        }

        dataset.clear();
        if (ngaybd.equals("-1")) {
            loai.setSelectedIndex(0);
            ngaybatdau.setText("dd/MM/yyyy");
            ngayketthuc.setText("dd/MM/yyyy");
            return;
        }

        for (int i = Integer.parseInt(nambatdau); i <= Integer.parseInt(namketthuc); i++) {
            String thang = "12";
            if (nambatdau.equals(namketthuc))
                thang = thangketthuc;
            int batdauthang = 1;
            if (i == Integer.parseInt(nambatdau))
                batdauthang = Integer.parseInt(thangbatdau);
            for (int j = batdauthang; j <= Integer.parseInt(thang); j++) {
                int batdaungay = 1;
                if (j == Integer.parseInt(thangbatdau))
                    batdaungay = Integer.parseInt(ngaybd);
                String ketthucngay = new String();
                switch (j) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        ketthucngay = "31";
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        ketthucngay = "30";
                        break;
                    case 2:
                        if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                            ketthucngay = "29";
                        } else {
                            ketthucngay = "28";
                        }
                        break;
                    default:
                        ketthucngay = "01";
                        break;
                }

                if (j == Integer.parseInt(thangketthuc))
                    ketthucngay = ngaykt;

                String start = String.format("%02d/%02d/%d", batdaungay, j, i);
                String end = String.format("%s/%02d/%d", ketthucngay, j, i);

                System.out.println(start);
                System.out.println(end);

                double money = 0.0;
                int slkhach = 0;
                ArrayList<order_DTO> ords = new order_DAO().selectAll();
                for (order_DTO ord : ords) {
                    if (ord.getTinhtrang().equals("Đã giao")
                            && ord.getManv().equals(em.getManv())) {
                        String[] time = ord.getNgaydat().split(" ");
                        if (((advance.date1BeforeDate2(start, time[1])
                                || advance.date1EqualDate2(start, time[1]))
                                && (advance.date1BeforeDate2(time[1], end)
                                        || advance.date1EqualDate2(end, time[1])))) {
                            slkhach++;
                            money += ord.getTongtien();
                        }
                    }
                }

                System.out.println(slkhach);

                // System.out.println(loai.getSelectedItem());

                if (loai.getSelectedItem().equals("Không có")) {
                    dataset.addValue(money, "Doanh thu năm " + i, "Tháng " + j);
                    dataset.addValue(slkhach, "Lượng khách năm " + i, "Tháng " + j);
                } else if (loai.getSelectedItem().equals("Theo doanh thu")) {
                    dataset.addValue(money, "Doanh thu năm " + i, "Tháng " + j);
                } else {
                    dataset.addValue(slkhach, "Lượng khách năm " + i, "Tháng " + j);
                }
            }
        }

        loai.setSelectedIndex(0);
        ngaybatdau.setText("dd/MM/yyyy");
        ngayketthuc.setText("dd/MM/yyyy");
    }

    // Tuấn
    public static String getLastID() {
        employee_DAO dao = new employee_DAO();
        String lastID = dao.autoUpdateMaNV();
        return lastID;
    }

    public static void insert(employee_DTO nv) {
        employee_DAO dao = new employee_DAO();
        dao.add(nv);
    }

    public static void edit(employee_DTO nv) {
        employee_DAO dao = new employee_DAO();
        dao.update(nv);
    }

    public static void delete(employee_DTO nv) {
        employee_DAO dao = new employee_DAO();
        dao.update1(nv);
    }

    public static void loadTable(DefaultTableModel table) {
        employee_DAO dao = new employee_DAO();
        table.setRowCount(0);
        for (employee_DTO nv : dao.selectAll()) {
            String diaChi = nv.getMasonha() + "," + nv.getDuong() + "," + nv.getPhuong() + ","
                    + nv.getQuan() + "," + nv.getTinh();

            String nhathuoc = null;
            String mant = nv.getManhathuoc();
            ArrayList<store_DTO> ntlist = store_BUS.getAll();
            for (store_DTO st : ntlist) {
                String dc = st.getMasonha() + "," + st.getDuong() + "," + st.getPhuong() + "," + st.getQuan() + ","
                        + st.getTinh();
                if (mant.equals(st.getMant())) {
                    nhathuoc = dc;
                }
            }
            JLabel statusImg;
            if (nv.getTinhtrang()) {
                statusImg = new JLabel(data.imagePath.resize_check);
            } else {
                statusImg = new JLabel(data.imagePath.resize_exitIcon);
            }
            table.addRow(new Object[] { nv.getManv(), nv.getTennv(), nv.getChucvu(), nv.getGioitinh(), nv.getCccd(),
                    nv.getSdt(),
                    diaChi, nv.getUsername(), nv.getPassword(), nhathuoc, statusImg });
        }
    }

    public static ArrayList<employee_DTO> getAll() {
        employee_DAO dao = new employee_DAO();
        return dao.selectAll();
    }

    public static int loadMapAdmin(DefaultCategoryDataset dataset, JComboBox loai,
        JTextField ngaybatdau, JTextField ngayketthuc, employee_DTO em,
        ChartPanel chartpanel, JComboBox bieudo) {
        String ngaybd = "-1", ngaykt = "-1";
        String thangbatdau = "-1", thangketthuc = "-1";
        String nambatdau = "-1", namketthuc = "-1";

        if (ngaybatdau.getText().isEmpty()
                || ngaybatdau.getText().equals("dd/MM/yyyy")
                || advance.checkDate(ngaybatdau.getText())) {
            System.out.println(1);
            if (ngayketthuc.getText().isEmpty()
                    || ngayketthuc.getText().equals("dd/MM/yyyy")
                    || advance.checkDate(ngayketthuc.getText())) {
                System.out.println(2);

                System.out.println(ngaybatdau.getText());
                System.out.println(ngayketthuc.getText());

                if ((ngaybatdau.getText().isEmpty()
                        || ngaybatdau.getText().equals("dd/MM/yyyy"))
                        && (ngayketthuc.getText().isEmpty()
                                || ngayketthuc.getText().equals("dd/MM/yyyy"))) {
                    ArrayList<order_DTO> ords = new order_DAO().selectAll();
                    for (order_DTO ord : ords) {
                        if (ord.getTinhtrang().equals("Đã giao")) {
                            String[] time = ord.getNgaydat().split(" ");
                            String[] time2 = time[1].split("/");
                            ngaybd = time2[0];
                            thangbatdau = time2[1];
                            nambatdau = time2[2];

                            break;
                        }
                    }

                    String[] time = advance.currentDate().split("/");
                    ngaykt = time[0];
                    thangketthuc = time[1];
                    namketthuc = time[2];

                    System.out.println(3);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                } else if ((!ngaybatdau.getText().isEmpty()
                        || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                        && (ngayketthuc.getText().isEmpty()
                                || ngayketthuc.getText().equals("dd/MM/yyyy"))) {
                    String[] time = ngaybatdau.getText().split("/");
                    ngaybd = time[0];
                    thangbatdau = time[1];
                    nambatdau = time[2];

                    String[] time2 = advance.currentDate().split("/");
                    ngaykt = time2[0];
                    thangketthuc = time2[1];
                    namketthuc = time2[2];

                    System.out.println(4);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                } else if ((!ngayketthuc.getText().isEmpty()
                        || !ngayketthuc.getText().equals("dd/MM/yyyy"))
                        && (ngaybatdau.getText().isEmpty()
                                || ngaybatdau.getText().equals("dd/MM/yyyy"))) {
                    ArrayList<order_DTO> ords = new order_DAO().selectAll();
                    for (order_DTO ord : ords) {
                        if (ord.getTinhtrang().equals("Đã giao")) {
                            String[] time = ord.getNgaydat().split(" ");
                            String[] time2 = time[1].split("/");
                            ngaybd = time2[0];
                            thangbatdau = time2[1];
                            nambatdau = time2[2];

                            break;
                        }
                    }

                    String[] time = ngayketthuc.getText().split("/");
                    ngaykt = time[0];
                    thangketthuc = time[1];
                    namketthuc = time[2];

                    System.out.println(5);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                } else if ((!ngaybatdau.getText().isEmpty()
                        || !ngaybatdau.getText().equals("dd/MM/yyyy"))
                        && (!ngayketthuc.getText().isEmpty()
                                || !ngayketthuc.getText().equals("dd/MM/yyyy"))) {
                    String[] time = ngaybatdau.getText().split("/");
                    ngaybd = time[0];
                    thangbatdau = time[1];
                    nambatdau = time[2];

                    String[] time2 = ngayketthuc.getText().split("/");
                    ngaykt = time2[0];
                    thangketthuc = time2[1];
                    namketthuc = time2[2];

                    System.out.println(6);
                    System.out.println(ngaybd + "/" + thangbatdau + "/" + nambatdau);
                    System.out.println(ngaykt + "/" + thangketthuc + "/" + namketthuc);
                }
            }
        }

        dataset.clear();
        if (ngaybd.equals("-1")) {
            loai.setSelectedIndex(0);
            bieudo.setSelectedIndex(0);
            ngaybatdau.setText("dd/MM/yyyy");
            ngayketthuc.setText("dd/MM/yyyy");
            return -1;
        }

        DefaultPieDataset dataset2 = new DefaultPieDataset();
        for (int i = Integer.parseInt(nambatdau); i <= Integer.parseInt(namketthuc); i++) {
            String thang = "12";
            if (nambatdau.equals(namketthuc))
                thang = thangketthuc;
            int batdauthang = 1;
            if (i == Integer.parseInt(nambatdau))
                batdauthang = Integer.parseInt(thangbatdau);
            for (int j = batdauthang; j <= Integer.parseInt(thang); j++) {
                int batdaungay = 1;
                if (j == Integer.parseInt(thangbatdau))
                    batdaungay = Integer.parseInt(ngaybd);
                String ketthucngay = new String();
                switch (j) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        ketthucngay = "31";
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        ketthucngay = "30";
                        break;
                    case 2:
                        if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                            ketthucngay = "29";
                        } else {
                            ketthucngay = "28";
                        }
                        break;
                    default:
                        ketthucngay = "01";
                        break;
                }

                if (j == Integer.parseInt(thangketthuc))
                    ketthucngay = ngaykt;

                String start = String.format("%02d/%02d/%d", batdaungay, j, i);
                String end = String.format("%s/%02d/%d", ketthucngay, j, i);

                System.out.println(start);
                System.out.println(end);

                double money = 0.0;
                int slkhach = 0;
                int hoadonnhap = 0;
                ArrayList<order_DTO> ords = new order_DAO().selectAll();
                for (order_DTO ord : ords) {
                    if (ord.getTinhtrang().equals("Đã giao")) {
                        String[] time = ord.getNgaydat().split(" ");
                        if (((advance.date1BeforeDate2(start, time[1])
                                || advance.date1EqualDate2(start, time[1]))
                                && (advance.date1BeforeDate2(time[1], end)
                                        || advance.date1EqualDate2(end, time[1])))) {
                            slkhach++;
                            money += ord.getTongtien();
                        }
                    }
                }

                ArrayList<orderSupply_DTO> oss = new orderSupply_DAO().selectAll();
                for (orderSupply_DTO os : oss) {
                    if (os.getTinhtrang()) {
                        String[] time = os.getNgaynhap().split(" ");
                        if (((advance.date1BeforeDate2(start, time[1])
                                || advance.date1EqualDate2(start, time[1]))
                                && (advance.date1BeforeDate2(time[1], end)
                                        || advance.date1EqualDate2(end, time[1])))) {
                            hoadonnhap++;
                        }
                    }
                }

                System.out.println(slkhach);
                System.out.println(hoadonnhap);
                System.out.println(loai.getSelectedItem());
                System.out.println(bieudo.getSelectedItem());

                if(bieudo.getSelectedItem().equals("Biểu đồ cột")) {
                    JFreeChart chart = ChartFactory.createBarChart3D("", "", "", dataset,
                    PlotOrientation.VERTICAL, true, false, false);
                    
                    if (loai.getSelectedItem().equals("Theo đơn hàng nhập")) {
                        dataset.addValue(hoadonnhap, "Đơn hàng nhập năm " + i, "Tháng " + j);
                    } else if (loai.getSelectedItem().equals("Theo doanh thu")) {
                        dataset.addValue(money, "Doanh thu năm " + i, "Tháng " + j);
                    } else {
                        dataset.addValue(slkhach, "Lượng khách năm " + i, "Tháng " + j);
                    }

                    chartpanel.setChart(chart);
                } else if(bieudo.getSelectedItem().equals("Biều đồ miền")) {
                    JFreeChart chart = ChartFactory.createAreaChart("", "", "", dataset,
                    PlotOrientation.VERTICAL, true, false, false);

                    if (loai.getSelectedItem().equals("Theo đơn hàng nhập")) {
                        dataset.addValue(hoadonnhap, "Đơn hàng nhập năm " + i, "Tháng " + j);
                    } else if (loai.getSelectedItem().equals("Theo doanh thu")) {
                        dataset.addValue(money, "Doanh thu năm " + i, "Tháng " + j);
                    } else {
                        dataset.addValue(slkhach, "Lượng khách năm " + i, "Tháng " + j);
                    }

                    chartpanel.setChart(chart);
                } else if(bieudo.getSelectedItem().equals("Biều đồ tròn")) {
                    if(Integer.parseInt(namketthuc) - i + 1 > 1) {
                        return 1;
                    }

                    if (loai.getSelectedItem().equals("Theo đơn hàng nhập")) {
                        dataset2.setValue("Đơn hàng nhập tháng " + j, 100);
                    } else if (loai.getSelectedItem().equals("Theo doanh thu")) {
                        dataset2.setValue("Doanh thu tháng " + j, 100);
                    } else {
                        dataset2.setValue("Lượng khách tháng " + j, 100);
                    }

                    JFreeChart chart = ChartFactory.createPieChart3D("", dataset2,
                    true, false, false);

                    chartpanel.setChart(chart);
                }
            }
        }

        loai.setSelectedIndex(0);
        bieudo.setSelectedIndex(0);
        ngaybatdau.setText("dd/MM/yyyy");
        ngayketthuc.setText("dd/MM/yyyy");

        return 0;
    }
}
