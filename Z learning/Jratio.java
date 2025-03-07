package learning;

import java.awt.*;
import javax.swing.*;

public class Jratio {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JButton btn = new JButton("Done");

        JRadioButton rad1 = new JRadioButton("Rad1");
        JRadioButton rad2 = new JRadioButton("Rad2");
        JRadioButton rad3 = new JRadioButton("Rad3");

        ButtonGroup gr_btn = new ButtonGroup();
        gr_btn.add(rad1);
        gr_btn.add(rad2);
        gr_btn.add(rad3);

        btn.addActionListener(e -> {
            if(rad1.isSelected()) System.out.println(rad1.getText());
            if(rad2.isSelected()) System.out.println(rad2.getText());
            if(rad3.isSelected()) System.out.println(rad3.getText());
        });
        
        frame.add(btn);
        frame.add(rad1); frame.add(rad2); frame.add(rad3);
        frame.pack();
        frame.setVisible(true);
    }
}
