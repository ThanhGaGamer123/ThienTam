import java.awt.*;
import javax.swing.*;

public class LayeredPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JLayeredPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel 1 - Màu đỏ
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setBounds(100, 100, 200, 150);

        panel1.setOpaque(false);

        // Panel 2 - Màu xanh, nằm chồng lên panel1
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setBounds(100, 100, 200, 150);

        frame.setVisible(true);
    }
}
