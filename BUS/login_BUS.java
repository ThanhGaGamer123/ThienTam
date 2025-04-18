package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.employee_DAO;
import DTO.employee_DTO;
import GUI.employee_GUI;

public class login_BUS {
    public static Boolean checkLogin(String username, String password, JTextField user_field, JTextField pass_field) {
        employee_DAO emDAO = new employee_DAO();
        ArrayList<employee_DTO> nvArr = emDAO.selectAll();
        for(employee_DTO nv : nvArr) {
            if(username.equals(nv.getUsername()) && password.equals(nv.getPassword())) {
                JOptionPane.showMessageDialog(null, 
                "Đăng nhập thành công!");
                new employee_GUI(nv);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, 
        "Tài khoản hoặc mật khẩu không chính xác. Vui lòng nhập lại!");
        user_field.requestFocus(true);
        pass_field.setText("");
        return false;
    }
}
