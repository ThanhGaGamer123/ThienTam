package learning;
import javax.swing.JFrame; //gọi container JFrame từ thư viện swing
import javax.swing.ImageIcon; //gọi class ImageIcon từ thư viện swing
import java.awt.Color; //gọi class color từ thư viện awt


public class Jframe extends JFrame {
    Jframe() {
        this.setSize(600, 600); //kích thước cửa sổ
        this.setResizable(false); //không thể thay đổi kích thước cửa sổ
        this.setTitle("Nhà thuốc Thiện Tâm"); //tiêu đề cửa sổ
        this.setVisible(true); //hiển thị cửa sổ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng cửa sổ khi nhấn nút đỏ
    
        ImageIcon icon = new ImageIcon("D:/IT/GitHub Projects/ThienTam/logo.png"); //tạo icon
        this.setIconImage(icon.getImage()); //thiết lập icon cho cửa sổ
        this.getContentPane().setBackground(new Color(0,0,0)); //thiết lập màu nền cho cửa sổ
    }
}