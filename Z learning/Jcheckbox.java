package learning;

import java.awt.*;
import javax.swing.*;

public class Jcheckbox {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JCheckBox ckb = new JCheckBox();
        ckb.setText("Tích vào nếu muốn.");

        JButton btn = new JButton("Gửi");
        btn.addActionListener(e -> {
            System.out.println(ckb.isSelected());
        });

        frame.add(btn);
        frame.add(ckb);
        frame.pack();
        frame.setVisible(true);
    }
}
