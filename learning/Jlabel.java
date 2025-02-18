package learning;
import javax.swing.JFrame; //gọi class JFrame từ thư viện swing
import javax.swing.JLabel; //gọi class JLabel từ thư viện swing
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon; //gọi class ImageIcon từ thư viện swing

public class Jlabel {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("D:/IT/GitHub Projects/ThienTam/learning/test.jpg"); //tạo icon từ file test.jpg
        Border border = BorderFactory.createLineBorder(Color.orange,3); //tạo border cho label


        JLabel label = new JLabel(); //tạo label
        label.setText("UwU... I need some medicines :<"); //thiết lập text cho label
        label.setIcon(icon); //thiết lập icon cho label
        label.setHorizontalTextPosition(JLabel.CENTER); //vị trí text theo chiều ngang
        label.setVerticalTextPosition(JLabel.TOP); //vị trí text theo chiều dọc
        label.setForeground(Color.orange); //màu chữ
        label.setFont(new Font("MV Boli", Font.BOLD, 20)); //font chữ
        label.setIconTextGap(25); //khoảng cách giữa icon và text
        label.setBackground(Color.gray); //màu nền của label
        label.setOpaque(true); //tạo màu nền cho label
        label.setBorder(border); //thiết lập border cho label
        label.setVerticalAlignment(JLabel.CENTER); //vị trí text theo chiều dọc
        label.setHorizontalAlignment(JLabel.CENTER); //vị trí text theo chiều ngang\
        // label.setBounds(0,0,400,400); //vị trí và kích thước của label

        JFrame frame = new JFrame(); //tạo cửa sổ
        // frame.setSize(600, 600); //kích thước cửa sổ
        frame.setResizable(false); //không thể thay đổi kích thước cửa sổ
        frame.setTitle("Nhà thuốc Thiện Tâm"); //tiêu đề cửa sổ
        frame.setVisible(true); //hiển thị cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng cửa sổ khi nhấn nút đỏ
        // frame.setLayout(null); //tắt layout mặc định của cửa sổ

        //warning: thay đổi image icon sẽ làm mất text của label
        frame.add(label); //thêm label vào cửa sổ
        frame.pack(); //tự động thay đổi kích thước cửa sổ theo label
    }
}

