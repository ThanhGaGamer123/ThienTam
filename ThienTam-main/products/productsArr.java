package products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class productsArr {
    private ArrayList<product> sp;

    public productsArr() {
        this.sp = new ArrayList<>();
    }

    public productsArr(ArrayList<product> sp) {
        this.sp = sp;
    }

    public ArrayList<product> getSp() {
        return sp;
    }

    public void setSp(ArrayList<product> sp) {
        this.sp = sp;
    }

    public void readFile() {
        String filePath = "D:\\ThienTam-main\\ThienTam-main\\data\\products.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                if (part.length < 11) { // Đảm bảo đủ số trường
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue;
                }
                try {
                    float giaban = Float.parseFloat(part[5]);
                    float gianhap = Float.parseFloat(part[6]);
                    product thuoc = new product(part[0], part[1], part[2], part[3], part[4], giaban, gianhap, part[7],
                            part[8], part[9], part[10]);
                    sp.add(thuoc); // Thêm sản phẩm vào danh sách
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi chuyển đổi số tại dòng: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
    }

    public void printProducts() {
        if (sp == null || sp.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (product thuoc : sp) {
            System.out.println("Mã thuốc: " + thuoc.getMathuoc());
            System.out.println("Tên thuốc: " + thuoc.getTenthuoc());
            System.out.println("Đơn vị: " + thuoc.getDonvi());
            System.out.println("Thành phần: " + thuoc.getThanhphan());
            System.out.println("Thông tin sản phẩm: " + thuoc.getThongtinsp());
            System.out.println("Giá bán: " + thuoc.getGiaban());
            System.out.println("Giá nhập: " + thuoc.getGianhap());
            System.out.println("Xuất xứ: " + thuoc.getXuatxu());
            System.out.println("Mã hàng tồn: " + thuoc.getMahangton());
            System.out.println("Doi tuong su dung : " + thuoc.getDoituongsd());
            System.out.println("Chi dinh " + thuoc.getChidinh());
            System.out.println("----------------------------------");
        }
    }

    public ArrayList<product> findName(String timkiem) {
        ArrayList<product> result = new ArrayList<>();
        for (product p : sp) {
            String temp = p.getTenthuoc(); // Lấy tên thuốc
            if (temp.toLowerCase().contains(timkiem.toLowerCase())) { // Tìm gần đúng, không phân biệt hoa thường
                result.add(p); // Thêm vào danh sách kết quả
            }
        }
        return result;
    }

    public int findDTSD(String dt) {
        for (int i = 0; i < sp.size(); i++) {
            String temp = sp.get(i).getDoituongsd(); // Tìm theo đối tượng sử dụng
            if (temp.contains(dt)) {
                return i;
            }
        }
        return -1;
    }

    public int findxuatsu(String xsu) {
        for (int i = 0; i < sp.size(); i++) {
            String temp = sp.get(i).getXuatxu(); // Tìm theo xuất xứ
            if (temp.contains(xsu)) {
                return i;
            }
        }
        return -1;
    }

    public int findChidinh(String cdinh) {
        for (int i = 0; i < sp.size(); i++) {
            String temp = sp.get(i).getChidinh(); // Tìm theo chỉ định
            if (temp.contains(cdinh)) {
                return i;
            }
        }
        return -1;
    }
}