package BUS;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import DAO.medicine_DAO;
import DAO.orderSupply_DAO;
import DAO.order_DAO;
import DTO.customer_DTO;
import DTO.employee_DTO;
import DTO.medicine_DTO;
import DTO.orderSupply_DTO;
import DTO.order_DTO;
import DTO.promotion_DTO;
import DTO.store_DTO;
import DTO.supplier_DTO;
import advanceMethod.advance;

public class export_BUS {
    public static void pathData(JTextField tf_path) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn đường dẫn");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int choice = fileChooser.showSaveDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File pathFile = fileChooser.getSelectedFile();
            tf_path.setText(pathFile.getAbsolutePath());
        }
    }

    public static int exportFile(JComboBox xuatas, JComboBox data, JTextField filename,
            JTextField path) {
        if (!filename.getText().isEmpty()) {
            if (!path.getText().isEmpty()) {
                String exportPath = path.getText() + File.separator + filename.getText();

                // Xuất excel
                if (xuatas.getSelectedIndex() == 0) {
                    exportPath += ".xlsx";
                    File isexist = new File(exportPath);
                    if (!isexist.exists()) {
                        try {
                            XSSFWorkbook workbook = new XSSFWorkbook();

                            if (data.getSelectedIndex() == 0) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách thuốc");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã thuốc");
                                row.createCell(1).setCellValue("Tên thuốc");
                                row.createCell(2).setCellValue("Đơn vị");
                                row.createCell(3).setCellValue("Thành phần");
                                row.createCell(4).setCellValue("Thông tin");
                                row.createCell(5).setCellValue("Xuất xứ");
                                row.createCell(6).setCellValue("Danh mục");
                                row.createCell(7).setCellValue("Giá Bán");
                                row.createCell(8).setCellValue("Mã tồn");
                                row.createCell(9).setCellValue("Đối tượng sử dụng");
                                row.createCell(10).setCellValue("Hạn sử dụng");
                                row.createCell(11).setCellValue("Tình trạng");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<medicine_DTO> meds = new medicine_DAO().selectAll();
                                int i = 1;
                                for (medicine_DTO med : meds) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(med.getMathuoc());
                                    row.createCell(1).setCellValue(med.getTenthuoc());
                                    row.createCell(2).setCellValue(advance.StringArrayListToString(med.getDonvi()));
                                    row.createCell(3).setCellValue(med.getThanhphan());
                                    row.createCell(4).setCellValue(med.getThongtin());
                                    row.createCell(5).setCellValue(med.getXuatxu());
                                    row.createCell(6).setCellValue(med.getDanhmuc());
                                    row.createCell(7).setCellValue(advance.DoubleArrayListToString(med.getGiaban()));
                                    row.createCell(8).setCellValue(med.getMaton());
                                    row.createCell(9)
                                            .setCellValue(advance.StringArrayListToString(med.getDoituongsudung()));
                                    row.createCell(10).setCellValue(med.getHansudung());
                                    row.createCell(11).setCellValue(med.getTinhtrang());
                                    i++;
                                }
                            } else if (data.getSelectedIndex() == 1) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách đơn hàng");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã đơn hàng");
                                row.createCell(1).setCellValue("Mã khách hàng");
                                row.createCell(2).setCellValue("Mã nhân viên");
                                row.createCell(3).setCellValue("Địa chỉ nhà");
                                row.createCell(4).setCellValue("Phường");
                                row.createCell(5).setCellValue("Quận");
                                row.createCell(6).setCellValue("Tỉnh");
                                row.createCell(7).setCellValue("Thời gian đặt");
                                row.createCell(8).setCellValue("Phương thức thanh toán");
                                row.createCell(9).setCellValue("Tình trạng");
                                row.createCell(10).setCellValue("Tổng tiền");
                                row.createCell(11).setCellValue("Ghi chú");
                                row.createCell(12).setCellValue("Người nhận");
                                row.createCell(13).setCellValue("Số điện thoại người nhận");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<order_DTO> ords = new order_DAO().selectAll();
                                int i = 1;
                                for (order_DTO ord : ords) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(ord.getMadon());
                                    row.createCell(1).setCellValue(ord.getMakh());
                                    row.createCell(2).setCellValue(ord.getManv());
                                    row.createCell(3).setCellValue(ord.getDiachicuthe());
                                    row.createCell(4).setCellValue(ord.getPhuong());
                                    row.createCell(5).setCellValue(ord.getQuan());
                                    row.createCell(6).setCellValue(ord.getTinh());
                                    row.createCell(7).setCellValue(ord.getNgaydat());
                                    row.createCell(8).setCellValue(ord.getPttt());
                                    row.createCell(9).setCellValue(ord.getTinhtrang());
                                    row.createCell(10).setCellValue(ord.getTongtien());
                                    row.createCell(11).setCellValue(ord.getGhichu());
                                    row.createCell(12).setCellValue(ord.getNguoinhan());
                                    row.createCell(13).setCellValue(ord.getSdt_nguoinhan());
                                    i++;
                                }
                            } else if (data.getSelectedIndex() == 2) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách đơn hàng nhập");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã đơn hàng nhập");
                                row.createCell(1).setCellValue("Mã nhà cung cấp");
                                row.createCell(2).setCellValue("Số loại thuốc");
                                row.createCell(3).setCellValue("Thời gian nhập");
                                row.createCell(4).setCellValue("Tổng tiền");
                                row.createCell(5).setCellValue("Tình trạng");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<orderSupply_DTO> oss = new orderSupply_DAO().selectAll();
                                int i = 1;
                                for (orderSupply_DTO os : oss) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(os.getMahdnhap());
                                    row.createCell(1).setCellValue(os.getMancc());
                                    row.createCell(2).setCellValue(os.getSoloaithuoc());
                                    row.createCell(3).setCellValue(os.getNgaynhap());
                                    row.createCell(4).setCellValue(os.getTongtien());
                                    row.createCell(5).setCellValue(os.getTinhtrang());
                                    i++;
                                }
                            }

                            // xuất file
                            try {
                                System.out.println(exportPath);
                                FileOutputStream fileOut = new FileOutputStream(exportPath);
                                workbook.write(fileOut);
                            } finally {
                                workbook.close();
                            }

                            filename.setText("");
                            path.setText("");

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else
                        return 3;
                }

                // Xuất PDF
                if (xuatas.getSelectedIndex() == 1) {
                    exportPath += ".pdf";
                    File isexist = new File(exportPath);
                    if (!isexist.exists()) {
                        try {
                            PdfWriter writer = new PdfWriter(exportPath);
                            PdfDocument pdf = new PdfDocument(writer);

                            PdfFont font = PdfFontFactory.createFont(advance.data_path +
                                    "dejavu-sans\\ttf\\DejaVuSans-Bold.ttf", PdfEncodings.IDENTITY_H,
                                    pdf);

                            PdfFont font2 = PdfFontFactory.createFont(advance.data_path +
                                    "dejavu-sans\\ttf\\DejaVuSans.ttf", PdfEncodings.IDENTITY_H,
                                    pdf);

                            if (data.getSelectedIndex() == 0) {
                                Document document = new Document(pdf, PageSize.A3);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Thuốc")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(12);
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã thuốc", "Tên thuốc", "Đơn vị", "Thành phần",
                                        "Thông tin", "Xuất xứ", "Danh mục", "Giá Bán",
                                        "Mã tồn", "Đối tượng sử dụng", "Hạn sử dụng",
                                        "Tình trạng"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<medicine_DTO> meds = new medicine_DAO().selectAll();
                                for (medicine_DTO med : meds) {
                                    table.addCell(med.getMathuoc());
                                    table.addCell(med.getTenthuoc());
                                    table.addCell(advance.StringArrayListToString(med.getDonvi()));
                                    table.addCell(med.getThanhphan());
                                    table.addCell(med.getThongtin());
                                    table.addCell(med.getXuatxu());
                                    table.addCell(med.getDanhmuc());
                                    table.addCell(advance.DoubleArrayListToString(med.getGiaban()));
                                    table.addCell(med.getMaton());
                                    table.addCell(advance.StringArrayListToString(med.getDoituongsudung()));
                                    table.addCell(med.getHansudung());
                                    table.addCell(String.valueOf(med.getTinhtrang()));
                                }

                                document.add(table);
                                document.close();
                            } else if (data.getSelectedIndex() == 1) {
                                Document document = new Document(pdf, PageSize.A3);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Đơn Hàng")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(11);
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã đơn hàng", "Mã khách hàng", "Mã nhân viên", "Địa chỉ",
                                        "Thời gian đặt", "Phương thức thanh toán", "Tình trạng",
                                        "Tổng tiền", "Ghi chú", "Người nhận", "Số điện thoại người nhận"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header)
                                                    .setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<order_DTO> ords = new order_DAO().selectAll();
                                for (order_DTO ord : ords) {
                                    table.addCell(new Paragraph(ord.getMadon()));
                                    table.addCell(new Paragraph(ord.getMakh() == null ? "Không có" : ord.getMakh()));
                                    table.addCell(new Paragraph(ord.getManv()));
                                    table.addCell(new Paragraph(ord.getDiachicuthe() + ", " + ord.getPhuong()
                                            + ", " + ord.getQuan() + ", " + ord.getTinh()));
                                    table.addCell(new Paragraph(ord.getNgaydat()));
                                    table.addCell(new Paragraph(ord.getPttt()));
                                    table.addCell(new Paragraph(ord.getTinhtrang()));
                                    table.addCell(new Paragraph(String.valueOf(ord.getTongtien())));
                                    table.addCell(
                                            new Paragraph(ord.getGhichu() == null ? "Không có" : ord.getGhichu()));
                                    table.addCell(new Paragraph(
                                            ord.getNguoinhan() == null ? "Không có" : ord.getNguoinhan()));
                                    table.addCell(new Paragraph(
                                            ord.getSdt_nguoinhan() == null ? "Không có" : ord.getSdt_nguoinhan()));
                                }

                                document.add(table);
                                document.close();
                            } else if (data.getSelectedIndex() == 2) {
                                Document document = new Document(pdf, PageSize.A4);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Đơn Hàng Nhập")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(6);
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã đơn hàng nhập", "Mã nhà cung cấp", "Số loại thuốc",
                                        "Thời gian nhập", "Tổng tiền", "Tình trạng"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header)
                                                    .setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<orderSupply_DTO> oss = new orderSupply_DAO().selectAll();
                                for (orderSupply_DTO os : oss) {
                                    table.addCell(os.getMahdnhap());
                                    table.addCell(os.getMancc());
                                    table.addCell(String.valueOf(os.getSoloaithuoc()));
                                    table.addCell(os.getNgaynhap());
                                    table.addCell(String.valueOf(os.getTongtien()));
                                    table.addCell(String.valueOf(os.getTinhtrang()));
                                }

                                document.add(table);
                                document.close();
                            }

                            filename.setText("");
                            path.setText("");

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else
                        return 3;
                }
            } else
                return 2;
        } else
            return 1;

        return -1;
    }

    public static int exportFile1(JComboBox xuatas, JComboBox data, JTextField filename,
            JTextField path) {
        if (!filename.getText().isEmpty()) {
            if (!path.getText().isEmpty()) {
                String exportPath = path.getText() + File.separator + filename.getText();

                // Xuất excel
                if (xuatas.getSelectedIndex() == 0) {
                    exportPath += ".xlsx";
                    File isexist = new File(exportPath);
                    if (!isexist.exists()) {
                        try {
                            XSSFWorkbook workbook = new XSSFWorkbook();

                            if (data.getSelectedIndex() == 0) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách nhà cung cấp");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã NCC");
                                row.createCell(1).setCellValue("Tên NCC");
                                row.createCell(2).setCellValue("SĐT");
                                row.createCell(3).setCellValue("Địa chỉ");
                                row.createCell(4).setCellValue("Tình trạng");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<supplier_DTO> suplist = supplier_BUS.getAll();
                                int i = 1;
                                for (supplier_DTO sup : suplist) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(sup.getMancc());
                                    row.createCell(1).setCellValue(sup.getTenncc());
                                    row.createCell(2).setCellValue(sup.getSdt());
                                    String dc = sup.getMasonha() + "," + sup.getDuong() + "," + sup.getPhuong()
                                            + ","
                                            + sup.getQuan() + "," + sup.getTinh();
                                    row.createCell(3).setCellValue(dc);
                                    row.createCell(4).setCellValue(sup.getTinhtrang());
                                    i++;
                                }
                            } else if (data.getSelectedIndex() == 1) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách khách hàng");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã KH");
                                row.createCell(1).setCellValue("Tên KH");
                                row.createCell(2).setCellValue("SĐT");
                                row.createCell(3).setCellValue("Email");
                                row.createCell(4).setCellValue("Địa chỉ");
                                row.createCell(5).setCellValue("Mật khẩu");
                                row.createCell(6).setCellValue("Điểm khuyến mãi");
                                row.createCell(7).setCellValue("Tình trạng");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<customer_DTO> cuslist = customer_BUS.getAll();
                                int i = 1;
                                for (customer_DTO cus : cuslist) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(cus.getMakh());
                                    row.createCell(1).setCellValue(cus.getTenkh());
                                    row.createCell(2).setCellValue(cus.getSdt());
                                    row.createCell(3).setCellValue(cus.getEmail());
                                    String dc = cus.getMasonha() + "," + cus.getDuong() + "," + cus.getPhuong()
                                            + ","
                                            + cus.getQuan() + "," + cus.getTinh();
                                    row.createCell(4).setCellValue(dc);
                                    row.createCell(5).setCellValue(cus.getPassword());
                                    row.createCell(6).setCellValue(cus.getDiemKM());
                                    row.createCell(7).setCellValue(cus.getTinhtrang());
                                    i++;
                                }
                            } else if (data.getSelectedIndex() == 2) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách nhân viên");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã NV");
                                row.createCell(1).setCellValue("Tên NV");
                                row.createCell(2).setCellValue("Chức vụ");
                                row.createCell(3).setCellValue("Giới tính");
                                row.createCell(4).setCellValue("CCCD");
                                row.createCell(5).setCellValue("SĐT");
                                row.createCell(6).setCellValue("Địa chỉ");
                                row.createCell(7).setCellValue("Tài khoản");
                                row.createCell(8).setCellValue("Mật khẩu");
                                row.createCell(9).setCellValue("Công tác tại");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<employee_DTO> emplist = employee_BUS.getAll();
                                int i = 1;
                                for (employee_DTO emp : emplist) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(emp.getManv());
                                    row.createCell(1).setCellValue(emp.getTennv());
                                    row.createCell(2).setCellValue(emp.getChucvu());
                                    row.createCell(3).setCellValue(emp.getGioitinh());
                                    row.createCell(4).setCellValue(emp.getCccd());
                                    row.createCell(5).setCellValue(emp.getSdt());
                                    String dc = emp.getMasonha() + "," + emp.getDuong() + "," + emp.getPhuong()
                                            + ","
                                            + emp.getQuan() + "," + emp.getTinh();
                                    row.createCell(6).setCellValue(dc);
                                    row.createCell(7).setCellValue(emp.getUsername());
                                    row.createCell(8).setCellValue(emp.getPassword());
                                    String dc1 = null;
                                    ArrayList<store_DTO> stolist = store_BUS.getAll();
                                    for (store_DTO sto : stolist) {
                                        if (sto.getMant().equals(emp.getManhathuoc())) {
                                            dc1 = sto.getMasonha() + "," + sto.getDuong() + ","
                                                    + sto.getPhuong()
                                                    + ","
                                                    + sto.getQuan() + "," + sto.getTinh();
                                        }
                                    }
                                    row.createCell(9).setCellValue(dc1);
                                    i++;
                                }
                            } else if (data.getSelectedIndex() == 3) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách khuyến mãi");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã KM");
                                row.createCell(1).setCellValue("Tên KM");
                                row.createCell(2).setCellValue("Ngày bắt đầu");
                                row.createCell(3).setCellValue("Ngày kết thúc");
                                row.createCell(4).setCellValue("Giảm");
                                row.createCell(5).setCellValue("Nội dung");
                                row.createCell(6).setCellValue("Điểm yêu cầu");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<promotion_DTO> prolist = promotion_BUS.getAll();
                                int i = 1;
                                for (promotion_DTO pro : prolist) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(pro.getMakm());
                                    row.createCell(1).setCellValue(pro.getTenkm());
                                    row.createCell(2).setCellValue(pro.getNgaybatdau());
                                    row.createCell(3).setCellValue(pro.getNgayketthuc());
                                    row.createCell(4).setCellValue(pro.getGiam());
                                    row.createCell(5).setCellValue(pro.getNoidung());
                                    row.createCell(6).setCellValue(pro.getDiem());
                                    i++;
                                }
                            } else if (data.getSelectedIndex() == 4) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách nhà thuốc");

                                // tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã NT");
                                row.createCell(1).setCellValue("Địa chỉ");
                                row.createCell(2).setCellValue("Tên người quản lí");

                                // lưu dữ liệu thành từng dòng
                                ArrayList<store_DTO> stolist = store_BUS.getAll();
                                int i = 1;
                                for (store_DTO sto : stolist) {
                                    row = sheet.createRow(i);
                                    row.createCell(0).setCellValue(sto.getMant());
                                    String dc = sto.getMasonha() + "," + sto.getDuong() + "," + sto.getPhuong()
                                            + ","
                                            + sto.getQuan() + "," + sto.getTinh();
                                    row.createCell(1).setCellValue(dc);
                                    String tenql = null;
                                    ArrayList<employee_DTO> emplist = employee_BUS.getAll();
                                    for (employee_DTO emp : emplist) {
                                        if (sto.getManql().equals(emp.getManv())) {
                                            tenql = emp.getTennv();
                                        }
                                    }
                                    row.createCell(2).setCellValue(tenql);
                                    i++;
                                }
                            }

                            // xuất file
                            try {
                                System.out.println(exportPath);
                                FileOutputStream fileOut = new FileOutputStream(exportPath);
                                workbook.write(fileOut);
                            } finally {
                                workbook.close();
                            }

                            filename.setText("");
                            path.setText("");

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else
                        return 3;
                }

                // Xuất PDF
                if (xuatas.getSelectedIndex() == 1) {
                    exportPath += ".pdf";
                    File isexist = new File(exportPath);
                    if (!isexist.exists()) {
                        try {
                            PdfWriter writer = new PdfWriter(exportPath);
                            PdfDocument pdf = new PdfDocument(writer);

                            PdfFont font = PdfFontFactory.createFont(advance.data_path +
                                    "dejavu-sans\\ttf\\DejaVuSans-Bold.ttf", PdfEncodings.IDENTITY_H,
                                    pdf);

                            PdfFont font2 = PdfFontFactory.createFont(advance.data_path +
                                    "dejavu-sans\\ttf\\DejaVuSans.ttf", PdfEncodings.IDENTITY_H,
                                    pdf);

                            if (data.getSelectedIndex() == 0) {
                                Document document = new Document(pdf, PageSize.A4);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Nhà Cung Cấp")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(4);
                                table.setWidth(UnitValue.createPercentValue(100));
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã NCC", "Tên NCC", "SĐT", "Địa chỉ"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<supplier_DTO> suplist = supplier_BUS.getAll();
                                for (supplier_DTO sup : suplist) {
                                    if (sup.getTinhtrang()) {
                                        String dc = sup.getMasonha() + "," + sup.getDuong() + "," + sup.getPhuong()
                                                + ","
                                                + sup.getQuan() + "," + sup.getTinh();
                                        table.addCell(new Paragraph(sup.getMancc()));
                                        table.addCell(new Paragraph(sup.getTenncc()));
                                        table.addCell(new Paragraph(sup.getSdt()));
                                        table.addCell(new Paragraph(dc));
                                    }
                                }

                                document.add(table);
                                document.close();
                            } else if (data.getSelectedIndex() == 1) {
                                Document document = new Document(pdf, PageSize.A3);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Khách Hàng")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(7);
                                table.setWidth(UnitValue.createPercentValue(100));
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã KH", "Tên KH", "SĐT", "Email", "Địa chỉ", "Mật khẩu", "Điểm khuyến mãi"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<customer_DTO> cuslist = customer_BUS.getAll();
                                for (customer_DTO cus : cuslist) {
                                    if (cus.getTinhtrang()) {
                                        String dc = cus.getMasonha() + "," + cus.getDuong() + "," + cus.getPhuong()
                                                + ","
                                                + cus.getQuan() + "," + cus.getTinh();
                                        table.addCell(new Paragraph(cus.getMakh()));
                                        table.addCell(new Paragraph(cus.getTenkh()));
                                        table.addCell(new Paragraph(cus.getSdt()));
                                        table.addCell(new Paragraph(cus.getEmail()));
                                        table.addCell(new Paragraph(dc));
                                        table.addCell(new Paragraph(cus.getPassword()));
                                        table.addCell(new Paragraph(String.valueOf(cus.getDiemKM())));
                                    }
                                }

                                document.add(table);
                                document.close();
                            } else if (data.getSelectedIndex() == 2) {
                                Document document = new Document(pdf, PageSize.A2);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Nhân Viên")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(10);
                                table.setWidth(UnitValue.createPercentValue(100));
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã NV", "Tên NV", "Chức vụ", "Giới tính", "CCCD", "SĐT", "Địa chỉ",
                                        "Tài khoản", "Mật khẩu", "Công tác tại"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<employee_DTO> emplist = employee_BUS.getAll();
                                for (employee_DTO emp : emplist) {
                                    if (emp.getTinhtrang()) {
                                        String dc = emp.getMasonha() + "," + emp.getDuong() + "," + emp.getPhuong()
                                                + ","
                                                + emp.getQuan() + "," + emp.getTinh();
                                        table.addCell(new Paragraph(emp.getManv()));
                                        table.addCell(new Paragraph(emp.getTennv()));
                                        table.addCell(new Paragraph(emp.getChucvu()));
                                        table.addCell(new Paragraph(emp.getGioitinh()));
                                        table.addCell(new Paragraph(emp.getCccd()));
                                        table.addCell(new Paragraph(emp.getSdt()));
                                        table.addCell(new Paragraph(dc));
                                        table.addCell(new Paragraph(emp.getUsername()));
                                        table.addCell(new Paragraph(emp.getPassword()));
                                        String dc1 = null;
                                        ArrayList<store_DTO> stolist = store_BUS.getAll();
                                        for (store_DTO sto : stolist) {
                                            if (sto.getMant().equals(emp.getManhathuoc())) {
                                                dc1 = sto.getMasonha() + "," + sto.getDuong() + ","
                                                        + sto.getPhuong()
                                                        + ","
                                                        + sto.getQuan() + "," + sto.getTinh();
                                            }
                                        }
                                        table.addCell(new Paragraph(dc1));
                                    }
                                }

                                document.add(table);
                                document.close();
                            } else if (data.getSelectedIndex() == 3) {
                                Document document = new Document(pdf, PageSize.A3);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Khuyến Mãi")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(7);
                                table.setWidth(UnitValue.createPercentValue(100));
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã KM", "Tên KM", "Ngày bắt đầu", "Ngày kết thúc", "Giảm", "Nội dung",
                                        "Điểm yêu cầu"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<promotion_DTO> prolist = promotion_BUS.getAll();
                                for (promotion_DTO pro : prolist) {
                                    if (pro.getTinhtrang()) {
                                        table.addCell(new Paragraph(pro.getMakm()));
                                        table.addCell(new Paragraph(pro.getTenkm()));
                                        table.addCell(new Paragraph(pro.getNgaybatdau()));
                                        table.addCell(new Paragraph(pro.getNgayketthuc()));
                                        table.addCell(new Paragraph(String.valueOf(pro.getGiam())));
                                        table.addCell(new Paragraph(pro.getNoidung()));
                                        table.addCell(new Paragraph(String.valueOf(pro.getDiem())));
                                    }
                                }

                                document.add(table);
                                document.close();
                            } else if (data.getSelectedIndex() == 4) {
                                Document document = new Document(pdf, PageSize.A4);
                                document.setLeftMargin(10);
                                document.setRightMargin(10);

                                document.add(new Paragraph("Nhà Thuốc Thiện Tâm")
                                        .setFont(font).setFontSize(18)
                                        .setTextAlignment(TextAlignment.CENTER))
                                        .setBackgroundColor(ColorConstants.GREEN);

                                document.add(new Paragraph("Danh Sách Nhà Thuốc")
                                        .setFont(font).setFontSize(14));

                                document.add(new Paragraph("Thời gian: " + advance.currentTime())
                                        .setFont(font).setFontSize(12));

                                Table table = new Table(3);
                                table.setWidth(UnitValue.createPercentValue(100));
                                table.setFont(font2).setFontSize(12);

                                // tiêu đề
                                String[] headers = {
                                        "Mã NT", "Địa chỉ", "Tên người quản lý"
                                };

                                for (String header : headers) {
                                    Cell headerCell = new Cell()
                                            .add(new Paragraph(header).setTextAlignment(TextAlignment.CENTER))
                                            .setBackgroundColor(ColorConstants.GREEN)
                                            .setFont(font)
                                            .setFontSize(12);

                                    table.addHeaderCell(headerCell);
                                }

                                // lưu dữ liệu thành từng dòng
                                ArrayList<store_DTO> storelist = store_BUS.getAll();
                                for (store_DTO sto : storelist) {
                                    if (sto.getTinhtrang()) {
                                        String dc = sto.getMasonha() + "," + sto.getDuong() + "," + sto.getPhuong()
                                                + ","
                                                + sto.getQuan() + "," + sto.getTinh();
                                        table.addCell(new Paragraph(sto.getMant()));
                                        table.addCell(new Paragraph(dc));
                                        String tenql = null;
                                        ArrayList<employee_DTO> emplist = employee_BUS.getAll();
                                        for (employee_DTO emp : emplist) {
                                            if (sto.getManql().equals(emp.getManv())) {
                                                tenql = emp.getTennv();
                                            }
                                        }
                                        table.addCell(new Paragraph(tenql));
                                    }
                                }

                                document.add(table);
                                document.close();
                            }

                            filename.setText("");
                            path.setText("");

                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 4;
                        }
                    } else
                        return 3;
                }
            } else
                return 2;
        } else
            return 1;

        return -1;
    }

}
