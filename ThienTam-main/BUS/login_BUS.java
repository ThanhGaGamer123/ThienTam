package BUS;

import DAO.employee_DAO;
import DTO.customer_DTO;
import DTO.employee_DTO;
import GUI.customer_GUI;
import GUI.employee_GUI;
import customer.customer_DTOArr;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login_BUS {

    public static Boolean checkLogin(String username, String password, JTextField user_field, JTextField pass_field) {
        employee_DAO emDAO = new employee_DAO();
        ArrayList<employee_DTO> nvArr = emDAO.selectAll();
        for (employee_DTO nv : nvArr) {
            if (username.equals(nv.getUsername()) && password.equals(nv.getPassword())) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                new employee_GUI(nv);
                return true;
            }
        }
        return false;
    }

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
