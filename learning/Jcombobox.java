package learning;

import java.awt.*;
import javax.swing.*;

public class Jcombobox {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        String[] animals = {"dog", "cat", "bird"};
        JComboBox cb = new JComboBox(animals);
        cb.addItem("horse");
        cb.insertItemAt("fish", 0);
        cb.removeItem("cat");
        cb.removeItemAt(2);
        cb.setEditable(true);

        
        JButton btn = new JButton("Done");
        btn.addActionListener(e -> {
            System.out.println(cb.getSelectedItem());
            System.out.println(cb.getSelectedIndex());
        });

        frame.add(btn);
        frame.add(cb);
        frame.pack();
        frame.setVisible(true);
    }
}
