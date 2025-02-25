package learning;

import java.awt.*;
import javax.swing.*;

public class Jslider {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JLabel lb = new JLabel();

        JSlider slider = new JSlider(0,100,50);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(25);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(e -> {
            lb.setText(slider.getValue() + "");
        });

        frame.add(slider);
        frame.add(lb);
        frame.pack();
        frame.setVisible(true);
    }
}
