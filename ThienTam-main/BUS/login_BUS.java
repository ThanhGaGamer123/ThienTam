package BUS;

import Arr_xt.customer_DTOArr;
import DTO.customer_DTO;
import GUI.customer_GUI;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login_BUS {



    public static Boolean checkLoginKH(String username, String password, JTextField user_field, JTextField pass_field) {
        customer_DTOArr khArr = new customer_DTOArr();
        khArr.readDatabase();
        for (customer_DTO customer : khArr.getA()) {
            if (username.equals(customer.getEmail()) && password.equals(customer.getPassword())) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                new customer_GUI(customer);
                return true;
            }
        }
        return false;
    }

}
