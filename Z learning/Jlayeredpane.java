package learning;

import java.awt.*;
import javax.swing.*;

public class Jlayeredpane {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lbl1 = new JLabel();
        lbl1.setBounds(50, 50, 200, 200);
        lbl1.setOpaque(true);
        lbl1.setBackground(Color.red);
        
        JLabel lbl2 = new JLabel();
        lbl2.setBounds(100, 100, 200, 200);
        lbl2.setOpaque(true);
        lbl2.setBackground(Color.green);
        
        JLabel lbl3 = new JLabel();
        lbl3.setBounds(150, 150, 200, 200);
        lbl3.setOpaque(true);
        lbl3.setBackground(Color.blue);
        
        JLayeredPane layer = new JLayeredPane();
        layer.setBounds(0,0,500,500);

        layer.add(lbl1, Integer.valueOf(0));
        layer.add(lbl2, Integer.valueOf(1));
        layer.add(lbl3, Integer.valueOf(0));

        frame.add(layer);
    }
}
