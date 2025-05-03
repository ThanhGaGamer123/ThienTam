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

import DAO.medicine_DAO;
import DAO.orderSupply_DAO;
import DAO.order_DAO;
import DTO.medicine_DTO;
import DTO.orderSupply_DTO;
import DTO.order_DTO;
import advanceMethod.advance;

public class export_BUS {
    public static void pathData(JTextField tf_path) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn đường dẫn");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int choice = fileChooser.showSaveDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION) {
            File pathFile = fileChooser.getSelectedFile();
            tf_path.setText(pathFile.getAbsolutePath());
        }
    }

    public static int exportFile(JComboBox xuatas, JComboBox data, JTextField filename,
    JTextField path) {
        if(!filename.getText().isEmpty()) {
            if(!path.getText().isEmpty()) {
                String exportPath = path.getText() + File.separator + filename.getText();

                //Xuất excel
                if(xuatas.getSelectedIndex() == 0) {
                    exportPath += ".xlsx";
                    File isexist = new File(exportPath);
                    if(!isexist.exists()) {
                        try {
                            XSSFWorkbook workbook = new XSSFWorkbook();

                            if(data.getSelectedIndex() == 0) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách thuốc");

                                //tiêu đề
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

                                //lưu dữ liệu thành từng dòng
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
                                    row.createCell(9).setCellValue(advance.StringArrayListToString(med.getDoituongsudung()));
                                    row.createCell(10).setCellValue(med.getHansudung());
                                    row.createCell(11).setCellValue(med.getTinhtrang());
                                    i++;
                                }
                            }
                            else if(data.getSelectedIndex() == 1) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách đơn hàng");

                                //tiêu đề
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

                                //lưu dữ liệu thành từng dòng
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
                            }
                            else if(data.getSelectedIndex() == 2) {
                                XSSFSheet sheet = workbook.createSheet("Danh sách đơn hàng nhập");

                                //tiêu đề
                                Row row = sheet.createRow(0);
                                row.createCell(0).setCellValue("Mã đơn hàng nhập");
                                row.createCell(1).setCellValue("Mã nhà cung cấp");
                                row.createCell(2).setCellValue("Số loại thuốc");
                                row.createCell(3).setCellValue("Thời gian nhập");
                                row.createCell(4).setCellValue("Tổng tiền");
                                row.createCell(5).setCellValue("Tình trạng");

                                //lưu dữ liệu thành từng dòng
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

                            //xuất file
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
                    } else return 3;
                }

                //Xuất PDF
                if(xuatas.getSelectedIndex() == 1) {
                    exportPath += ".pdf";
                    File isexist = new File(exportPath);
                    if(!isexist.exists()) {
                        try {
                            PdfWriter writer = new PdfWriter(exportPath);
                            PdfDocument pdf = new PdfDocument(writer);

                            PdfFont font = PdfFontFactory.createFont(advance.data_path + 
                            "dejavu-sans\\ttf\\DejaVuSans-Bold.ttf", PdfEncodings.IDENTITY_H,
                            pdf);

                            PdfFont font2 = PdfFontFactory.createFont(advance.data_path + 
                            "dejavu-sans\\ttf\\DejaVuSans.ttf", PdfEncodings.IDENTITY_H,
                            pdf);

                            if(data.getSelectedIndex() == 0) {
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

                                //tiêu đề
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

                                //lưu dữ liệu thành từng dòng
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
                            }
                            else if(data.getSelectedIndex() == 1) {
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

                                //tiêu đề
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

                                //lưu dữ liệu thành từng dòng
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
                                    table.addCell(new Paragraph(ord.getGhichu() == null ? "Không có" : ord.getGhichu()));
                                    table.addCell(new Paragraph(ord.getNguoinhan() == null ? "Không có" : ord.getNguoinhan()));
                                    table.addCell(new Paragraph(ord.getSdt_nguoinhan() == null ? "Không có" : ord.getSdt_nguoinhan()));
                                }
                                
                                document.add(table);
                                document.close();   
                            }
                            else if(data.getSelectedIndex() == 2) {
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

                                //tiêu đề
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

                                //lưu dữ liệu thành từng dòng
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
                    } else return 3;
                }
            } else return 2;
        } else return 1;

        return -1;
    }
}
