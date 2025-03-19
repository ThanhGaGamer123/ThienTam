package customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class customerArr {
    private ArrayList<customer> a;

    public customerArr() {
        this.a = new ArrayList<>(); // Khởi tạo danh sách tránh NullPointerException
    }

    public customerArr(ArrayList<customer> a) {
        this.a = a;
    }

    public ArrayList<customer> getA() {
        return a;
    }

    public void setA(ArrayList<customer> a) {
        this.a = a;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("D:\\ThienTam-main\\ThienTam-main\\data\\customer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                if (part.length < 11) {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                    continue; // Bỏ qua dòng lỗi
                }
                try {
                    customer kh = new customer(part[0], part[1], Integer.parseInt(part[2]),
                            part[3], part[4], part[5], part[6], part[7],
                            Integer.parseInt(part[8]), part[9], part[10]);
                    a.add(kh);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi chuyển đổi số: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
    }

    public void printCustomers() {
        if (a == null || a.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        System.out.println("Danh sách khách hàng:");
        for (customer kh : a) {
            System.out.println("Mã KH: " + kh.getMakh() +
                    ", Tên: " + kh.getTenkh() +
                    ", SĐT: " + kh.getSdtkh() +
                    ", Email: " + kh.getEmail() +
                    ", Địa chỉ: " + kh.getSoNhakhach() + ", " + kh.getPhuongkh() + ", " + kh.getQuankh() + ", "
                    + kh.getTinhkh() +
                    ", Điểm KM: " + kh.getDiemkm() +
                    ", Tài khoản: " + kh.getUserkh() +
                    ", Mật khẩu: [ĐÃ ẨN]");
        }
    }
}
