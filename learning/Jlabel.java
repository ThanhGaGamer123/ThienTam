package learning;
import javax.swing.JFrame; //gọi class JFrame từ thư viện swing
import javax.swing.JLabel; //gọi class JLabel từ thư viện swing
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon; //gọi class ImageIcon từ thư viện swing

public class Jlabel {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("D:/IT/GitHub Projects/ThienTam/learning/test.jpg"); //tạo icon từ file test.jpg

        JLabel label = new JLabel(); //tạo label
        label.setText("UwU... I need some medicines :<"); //thiết lập text cho label
        label.setIcon(icon); //thiết lập icon cho label
        label.setHorizontalTextPosition(JLabel.CENTER); //vị trí text theo chiều ngang
        label.setVerticalTextPosition(JLabel.TOP); //vị trí text theo chiều dọc
        label.setForeground(Color.orange); //màu chữ
        label.setFont(new Font("MV Boli", Font.BOLD, 20)); //font chữ

        JFrame frame = new JFrame(); //tạo cửa sổ
        frame.setSize(600, 600); //kích thước cửa sổ
        frame.setResizable(false); //không thể thay đổi kích thước cửa sổ
        frame.setTitle("Nhà thuốc Thiện Tâm"); //tiêu đề cửa sổ
        frame.setVisible(true); //hiển thị cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng cửa sổ khi nhấn nút đỏ

        //warning: thay đổi image icon sẽ làm mất text của label
        frame.add(label); //thêm label vào cửa sổ
    }
}

