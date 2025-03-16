package learning;

import java.awt.*;
import javax.swing.*;

public class Jtextfield {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JButton btn = new JButton("Click Me");

        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(100, 20));
        tf.setFont(new Font(null, Font.PLAIN, 12));
        tf.setForeground(Color.green);
        tf.setBackground(Color.black);
        tf.setText("null");
        tf.setEditable(false);

        frame.add(btn);
        frame.add(tf);
        frame.pack();
        frame.setVisible(true);
    }
}
