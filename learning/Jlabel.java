package learning;
import javax.swing.JFrame; //gọi class JFrame từ thư viện swing
import javax.swing.JLabel; //gọi class JLabel từ thư viện swing

public class Jlabel {
    public static void main(String[] args) {
        JLabel label = new JLabel(); //tạo label
        label.setText("Nhà thuốc Thiện Tâm"); //thiết lập text cho label

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

