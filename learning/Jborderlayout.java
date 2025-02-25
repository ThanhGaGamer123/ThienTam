package learning;

import java.awt.*;
import javax.swing.*;

public class Jborderlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));

        JPanel lbl1 = new JPanel();
        JPanel lbl2 = new JPanel();
        JPanel lbl3 = new JPanel();
        JPanel lbl4 = new JPanel();
        JPanel lbl5 = new JPanel();

        //----------------sub panel-------------------
        
        lbl5.setLayout(new BorderLayout());

        JPanel lbl6 = new JPanel();
        JPanel lbl7 = new JPanel();
        JPanel lbl8 = new JPanel();
        JPanel lbl9 = new JPanel();
        JPanel lbl10 = new JPanel();

        lbl6.setBackground(Color.black);
        lbl7.setBackground(Color.DARK_GRAY);
        lbl8.setBackground(Color.GRAY);
        lbl9.setBackground(Color.LIGHT_GRAY);
        lbl10.setBackground(Color.WHITE);

        lbl6.setPreferredSize(new Dimension(100, 100));
        lbl7.setPreferredSize(new Dimension(100, 100));
        lbl8.setPreferredSize(new Dimension(100, 100));
        lbl9.setPreferredSize(new Dimension(100, 100));
        lbl10.setPreferredSize(new Dimension(100, 100));

        lbl5.add(lbl6, BorderLayout.NORTH);
        lbl5.add(lbl7, BorderLayout.SOUTH);
        lbl5.add(lbl8, BorderLayout.WEST);
        lbl5.add(lbl9, BorderLayout.EAST);
        lbl5.add(lbl10, BorderLayout.CENTER);
        
        //----------------sub panel-------------------

        lbl1.setBackground(Color.red);
        lbl2.setBackground(Color.green);
        lbl3.setBackground(Color.yellow);
        lbl4.setBackground(Color.blue);
        lbl5.setBackground(Color.pink);

        lbl1.setPreferredSize(new Dimension(100, 100));
        lbl2.setPreferredSize(new Dimension(100, 100));
        lbl3.setPreferredSize(new Dimension(100, 100));
        lbl4.setPreferredSize(new Dimension(100, 100));
        lbl5.setPreferredSize(new Dimension(100, 100));

        frame.add(lbl1, BorderLayout.NORTH);
        frame.add(lbl2, BorderLayout.SOUTH);
        frame.add(lbl3, BorderLayout.WEST);
        frame.add(lbl4, BorderLayout.EAST);
        frame.add(lbl5, BorderLayout.CENTER);
    }
}
