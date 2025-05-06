package BUS;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import DAO.customer_DAO;
import DAO.employee_DAO;
import DAO.medicine_DAO;
import DAO.promotion_DAO;
import DAO.store_DAO;
import DAO.supplier_DAO;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.medicine_DTO;
import DTO.promotion_DTO;
import DTO.store_DTO;
import DTO.supplier_DTO;
import advanceMethod.advance;

public class import_BUS {
    public static void pathData(JTextField path) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn file cần nhập");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter(null, 
        "xlsx"));

        int choice = fileChooser.showSaveDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path.setText(file.getAbsolutePath());
        }
    }

    public static int importData(JComboBox nhapas, JComboBox data, JTextField path) {
        if(!path.getText().isEmpty()) {
            File file = new File(path.getText());
            if(file.exists()) {
                //excel
                if(nhapas.getSelectedIndex() == 0 && path.getText().contains(".xlsx")) {
                    if(data.getSelectedIndex() == 0) {
                        try {
                            FileInputStream fileInput = new FileInputStream(file);
                            Workbook workbook = WorkbookFactory.create(fileInput);
                            Sheet sheet = workbook.getSheet("Danh sách thuốc");

                            if(sheet == null) return 5;

                            for (Row row : sheet) {
                                medicine_DTO med = new medicine_DTO();
                                ArrayList<medicine_DTO> meds = new ArrayList<>();
                                medicine_DAO medDAO = new medicine_DAO();
                                meds = medDAO.selectAll();
                                med.setMathuoc("MTH"+advance.calculateID(meds.size()));
                                med.setTenthuoc(String.valueOf(row.getCell(0)));
                                med.setDonvi(advance.StringconvertToStringArrayList(row.getCell(1).toString()));
                                med.setThanhphan(String.valueOf(row.getCell(2)));
                                med.setThongtin(String.valueOf(row.getCell(3)));
                                med.setXuatxu(row.getCell(4).toString());
                                med.setDanhmuc(row.getCell(5).toString());
                                med.setGiaban(advance.StringArrayListToDoubleArrayList(
                                    advance.StringconvertToStringArrayList(row.getCell(6).toString())
                                ));
                                storage_BUS.createStock(med);
                                med.setDoituongsudung(advance.StringconvertToStringArrayList(row.getCell(7).toString()));
                                med.setHansudung(row.getCell(8).toString());
                                med.setTinhtrang(Boolean.parseBoolean(row.getCell(9).toString()));
                                medDAO.add(med);

                                workbook.close();
                                path.setText("");
                            }

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    }
                } else return 3;

                //...
            } else return 2;
        } else return 1;

        return -1;
    }

    public static int importDataAdmin(JComboBox nhapas, JComboBox data, JTextField path) {
        if(!path.getText().isEmpty()) {
            File file = new File(path.getText());
            if(file.exists()) {
                //excel
                if(nhapas.getSelectedIndex() == 0 && path.getText().contains(".xlsx")) {
                    if(data.getSelectedIndex() == 0) {
                        try {
                            FileInputStream fileInput = new FileInputStream(file);
                            Workbook workbook = WorkbookFactory.create(fileInput);
                            Sheet sheet = workbook.getSheet("Danh sách nhà cung cấp");

                            if(sheet == null) return 5;

                            for (Row row : sheet) {
                                supplier_DTO sup = new supplier_DTO();
                                ArrayList<supplier_DTO> sups = new ArrayList<>();
                                supplier_DAO supDAO = new supplier_DAO();
                                sups = supDAO.selectAll();

                                Boolean flag = false;
                                for (supplier_DTO sp : sups) {
                                    if(sp.getTenncc().equals(row.getCell(0).toString())) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if(flag) continue;

                                sup.setMancc("NCC"+advance.calculateID(sups.size()));
                                sup.setTenncc(row.getCell(0).toString());
                                sup.setSdt(row.getCell(1).toString());
                                String[] diachi = row.getCell(2).toString().split(",");
                                sup.setMasonha(diachi[0]);
                                sup.setDuong(diachi[1]);
                                sup.setPhuong(diachi[2]);
                                sup.setQuan(diachi[3]);
                                sup.setTinh(diachi[4]);
                                sup.setTinhtrang(Boolean.parseBoolean(String.valueOf(row.getCell(3))));
                                supDAO.add(sup);

                                workbook.close();
                                path.setText("");
                            }

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else if(data.getSelectedIndex() == 1) {
                        try {
                            FileInputStream fileInput = new FileInputStream(file);
                            Workbook workbook = WorkbookFactory.create(fileInput);
                            Sheet sheet = workbook.getSheet("Danh sách khách hàng");

                            if(sheet == null) return 5;

                            for (Row row : sheet) {
                                customer_DTO cus = new customer_DTO();
                                ArrayList<customer_DTO> cuss = new ArrayList<>();
                                customer_DAO cusDAO = new customer_DAO();
                                cuss = cusDAO.selectAll();

                                Boolean flag = false;
                                for (customer_DTO cuS : cuss) {
                                    if(cuS.getEmail().equals(row.getCell(2).toString())) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if(flag) continue;

                                cus.setMakh("KH"+advance.calculateID(cuss.size()));
                                cus.setTenkh(row.getCell(0).toString());
                                cus.setSdt(row.getCell(1).toString());
                                cus.setEmail(row.getCell(2).toString());
                                String[] diachi = row.getCell(3).toString().split(",");
                                cus.setMasonha(diachi[0]);
                                cus.setDuong(diachi[1]);
                                cus.setPhuong(diachi[2]);
                                cus.setQuan(diachi[3]);
                                cus.setTinh(diachi[4]);
                                cus.setPassword(row.getCell(4).toString());
                                cus.setDiemKM((int) Double.parseDouble(row.getCell(5).toString()));
                                cus.setTinhtrang(Boolean.parseBoolean(String.valueOf(row.getCell(6))));
                                cusDAO.add(cus);

                                workbook.close();
                                path.setText("");
                            }

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else if(data.getSelectedIndex() == 2) {
                        try {
                            FileInputStream fileInput = new FileInputStream(file);
                            Workbook workbook = WorkbookFactory.create(fileInput);
                            Sheet sheet = workbook.getSheet("Danh sách nhân viên");

                            if(sheet == null) return 5;

                            for (Row row : sheet) {
                                employee_DTO em = new employee_DTO();
                                ArrayList<employee_DTO> ems = new ArrayList<>();
                                employee_DAO emDAO = new employee_DAO();
                                ems = emDAO.selectAll();

                                Boolean flag = false;
                                for (employee_DTO emS : ems) {
                                    if(emS.getUsername().equals(row.getCell(6).toString())) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if(flag) continue;

                                em.setManv("NV"+advance.calculateID(ems.size()));
                                em.setTennv(row.getCell(0).toString());
                                em.setChucvu(row.getCell(1).toString());
                                em.setGioitinh(row.getCell(2).toString());
                                em.setCccd(row.getCell(3).toString());
                                em.setSdt(row.getCell(4).toString());
                                String[] diachi = row.getCell(5).toString().split(",");
                                em.setMasonha(diachi[0]);
                                em.setDuong(diachi[1]);
                                em.setPhuong(diachi[2]);
                                em.setQuan(diachi[3]);
                                em.setTinh(diachi[4]);
                                em.setUsername(row.getCell(6).toString());
                                em.setPassword(row.getCell(7).toString());
                                em.setTinhtrang(true);
                                emDAO.add(em);

                                workbook.close();
                                path.setText("");
                            }

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else if(data.getSelectedIndex() == 3) {
                        try {
                            FileInputStream fileInput = new FileInputStream(file);
                            Workbook workbook = WorkbookFactory.create(fileInput);
                            Sheet sheet = workbook.getSheet("Danh sách khuyến mãi");

                            if(sheet == null) return 5;

                            for (Row row : sheet) {
                                promotion_DTO pro = new promotion_DTO();
                                ArrayList<promotion_DTO> pros = new ArrayList<>();
                                promotion_DAO proDAO = new promotion_DAO();
                                pros = proDAO.selectAll();
                                pro.setMakm("KM"+advance.calculateID(pros.size()));
                                pro.setTenkm(row.getCell(0).toString());
                                pro.setNgaybatdau(row.getCell(1).toString());
                                pro.setNgayketthuc(row.getCell(2).toString());
                                pro.setGiam((int) Double.parseDouble(row.getCell(3).toString()));
                                pro.setNoidung(row.getCell(4).toString());
                                pro.setDiem((int) Double.parseDouble(row.getCell(5).toString()));
                                pro.setTinhtrang(true);
                                proDAO.add(pro);

                                workbook.close();
                                path.setText("");
                            }

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else if(data.getSelectedIndex() == 4) {
                        try {
                            FileInputStream fileInput = new FileInputStream(file);
                            Workbook workbook = WorkbookFactory.create(fileInput);
                            Sheet sheet = workbook.getSheet("Danh sách nhà thuốc");

                            if(sheet == null) return 5;

                            for (Row row : sheet) {
                                store_DTO store = new store_DTO();
                                ArrayList<store_DTO> stores = new ArrayList<>();
                                store_DAO storeDAO = new store_DAO();
                                stores = storeDAO.selectAll();

                                store.setMant("NT"+advance.calculateID(stores.size()));
                                String[] diachi = row.getCell(0).toString().split(",");
                                store.setMasonha(diachi[0]);
                                store.setDuong(diachi[1]);
                                store.setPhuong(diachi[2]);
                                store.setQuan(diachi[3]);
                                store.setTinh(diachi[4]);
                                store.setTinhtrang(true);
                                storeDAO.add(store);

                                workbook.close();
                                path.setText("");
                            }

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    }
                    
                } else return 3;

                //...
            } else return 2;
        } else return 1;

        return -1;
    }
}
