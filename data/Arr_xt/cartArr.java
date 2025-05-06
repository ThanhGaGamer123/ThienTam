package data.Arr_xt;

import DAO.cartDAO;
import DTO.cart_DTO;
import java.util.ArrayList;

public class cartArr {

    public cartArr() {
    }

    private static ArrayList<cart_DTO> a = new ArrayList<>();

    public ArrayList<cart_DTO> getA() {
        return a;
    }

    public void setA(ArrayList<cart_DTO> c) {
        a = c;
    }

    public void readDatabase(String makh) {
        try {
            cartDAO dao = new cartDAO(); 
            a = dao.readCartDatabase(makh);

            System.out.println("Dữ liệu giỏ hàng đã tải từ bảng GioHang cho khách hàng: " + makh);
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu giỏ hàng từ database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateCartDatabase(ArrayList<cart_DTO> cartList) {
        try {
            cartDAO dao = new cartDAO(); 
            dao.updateCart(cartList); 

            if (!cartList.isEmpty()) {
                System.out.println("Đã cập nhật giỏ hàng cho khách hàng: " + cartList.get(0).getMakh());
            } else {
                System.out.println("Danh sách giỏ hàng trống, không có gì để cập nhật.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật dữ liệu giỏ hàng vào database: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
