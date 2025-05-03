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

import DAO.medicine_DAO;
import DTO.medicine_DTO;
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
}
