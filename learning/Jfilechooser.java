package learning;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Jfilechooser {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JButton btn = new JButton("Select File");
        btn.addActionListener(e -> {
            JFileChooser choose = new JFileChooser();
            choose.setCurrentDirectory(new File("."));
            int choice = choose.showOpenDialog(null);
            if(choice == choose.APPROVE_OPTION) {
                File file = new File(choose.getSelectedFile().getAbsolutePath());
                System.out.println("Opening " + file);
            }
        });
        
        frame.add(btn);
        frame.pack();
        frame.setVisible(true);
    }
}
