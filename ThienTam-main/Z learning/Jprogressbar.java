package learning;

import java.awt.*;
import javax.swing.*;

public class Jprogressbar {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JProgressBar pro = new JProgressBar();
        pro.setSize(500,50);
        pro.setStringPainted(true);
        pro.setForeground(Color.green);

        frame.add(pro);
        frame.setVisible(true);
        
        int counter = 0;
        while(counter <= 100) {
            pro.setValue(counter);
            pro.setString(counter + "%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        pro.setString("Done :D");
    }
}
