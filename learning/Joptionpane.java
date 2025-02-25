package learning;

import java.awt.*;
import javax.swing.*;

public class Joptionpane {
    public static void main(String[] args) {
        JOptionPane.showConfirmDialog(null, "Bạn chắc chắn chứ?", "Câu hỏi?", 0);
        JOptionPane.showInputDialog(null, "Điền vào chỗ trống: ", "Phiếu điền");
        JOptionPane.showMessageDialog(null, "Đây là một thông báo", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
    }
}
