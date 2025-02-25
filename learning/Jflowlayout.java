package learning;

import java.awt.*;
import javax.swing.*;

public class Jflowlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JPanel pnl1 = new JPanel();
        pnl1.setBackground(Color.gray);
        pnl1.setPreferredSize(new Dimension(150, 250));
        pnl1.setLayout(new FlowLayout());

        pnl1.add(new JButton("1"));
        pnl1.add(new JButton("2"));
        pnl1.add(new JButton("3"));
        pnl1.add(new JButton("4"));
        pnl1.add(new JButton("5"));
        pnl1.add(new JButton("6"));
        pnl1.add(new JButton("7"));
        pnl1.add(new JButton("8"));
        pnl1.add(new JButton("9"));
        pnl1.add(new JButton("10"));

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));
        frame.add(new JButton("10"));
        frame.add(pnl1);
    }
}
