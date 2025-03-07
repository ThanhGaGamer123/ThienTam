package learning;

import java.awt.*;
import javax.swing.*;

public class Jcolorchooser {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JButton btn = new JButton("Pick a Color");
        btn.setBounds(0, 100, 150, 20);
        JLabel lbl = new JLabel("This is a TEXT");
        lbl.setBounds(100, 0, 600, 100);
        lbl.setOpaque(true);
        lbl.setFont(new Font(null, Font.PLAIN, 60));

        btn.addActionListener(e -> {
            JColorChooser choose = new JColorChooser();
            Color color = choose.showDialog(null, "Pick a color", Color.black);
            lbl.setForeground(color);
        });

        frame.add(btn);
        frame.add(lbl);
        frame.setVisible(true);
    }
}
