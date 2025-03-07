package learning;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Jmenubar {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JMenuBar mnbar = new JMenuBar();
        mnbar.setBounds(0,0,600,20);

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(e -> {
            System.out.println("File has been saved successfully.");
        });
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(e -> {
            System.out.println("File has been loaded successfully.");
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> {System.exit(0);});

        file.setMnemonic(KeyEvent.VK_F);
        edit.setMnemonic(KeyEvent.VK_E);
        help.setMnemonic(KeyEvent.VK_H);
        save.setMnemonic(KeyEvent.VK_S);
        load.setMnemonic(KeyEvent.VK_L);
        exit.setMnemonic(KeyEvent.VK_X);

        file.add(save);
        file.add(load);
        file.add(exit);

        mnbar.add(file);
        mnbar.add(edit);
        mnbar.add(help);
        
        frame.add(mnbar);
        frame.setVisible(true);
    }
}
