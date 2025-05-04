package Arr_xt;

import DAO.medicineDAO;
import DTO.medicine_DTO;
import java.util.ArrayList;

public class medicineArr {
    private ArrayList<medicine_DTO> sp;

    public medicineArr() {
        this.sp = new ArrayList<>();
    }

    public ArrayList<medicine_DTO> getSp() {
        return sp;
    }

    public void setSp(ArrayList<medicine_DTO> sp) {
        this.sp = sp;
    }

    // Hàm in danh sách thuốc
    public void printMedicines() {
        if (sp.isEmpty()) {
            System.out.println("Danh sách thuốc trống.");
            return;
        }

        System.out.println("Danh sách thuốc:");
        for (medicine_DTO m : sp) {
            System.out.println(m); // toString() trong medicine sẽ giúp in gọn
        }
    }

    // Tìm kiếm thuốc theo tên
    public ArrayList<medicine_DTO> findName(String timkiem) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            if (m.getTenthuoc().toLowerCase().contains(timkiem.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    // Tìm theo đối tượng sử dụng
    public ArrayList<medicine_DTO> findDTuongSD(String s) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            for (String dt : m.getDoituongsudung()) {
                if (dt.toLowerCase().contains(s.toLowerCase())) {
                    result.add(m);
                    break;
                }
            }
        }
        return result;
    }

    // Tìm theo xuất xứ
    public ArrayList<medicine_DTO> findXuatXu(String x) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            if (m.getXuatxu().toLowerCase().contains(x.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    // Tìm theo thông tin thuốc
    public ArrayList<medicine_DTO> findChiDinh(String c) {
        ArrayList<medicine_DTO> result = new ArrayList<>();
        for (medicine_DTO m : sp) {
            if (m.getThongtin().toLowerCase().contains(c.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    public void readDatabase() {
        try {
            medicineDAO dao = new medicineDAO();
            sp = dao.selectAll();

            System.out.println("Dữ liệu đã tải từ bảng Thuoc.");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu từ database: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
