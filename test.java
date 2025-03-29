import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ví dụ về Weight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Tạo JButton 1
        JButton button1 = new JButton("Button 1");
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 0; // Hàng 0
        gbc.weightx = 1.0; // Tỉ lệ co giãn chiều ngang
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mở rộng theo chiều ngang
        frame.add(button1, gbc);

        // Tạo JButton 2
        JButton button2 = new JButton("Button 2");
        gbc.gridx = 1; // Cột 1
        gbc.gridy = 0; // Hàng 0
        gbc.weightx = 2.0; // Tỉ lệ co giãn chiều ngang
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mở rộng theo chiều ngang
        frame.add(button2, gbc);

        // Tạo JButton 3
        JButton button3 = new JButton("Button 3");
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 1; // Hàng 1
        gbc.weightx = 0.5; // Tỉ lệ co giãn chiều ngang
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mở rộng theo chiều ngang
        frame.add(button3, gbc);

        // Hiển thị frame
        frame.setVisible(true);
    }
}