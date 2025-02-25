package learning;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Jmouselistener extends JFrame implements MouseListener {
    JLabel lb;

    Jmouselistener() {
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        lb = new JLabel();
        lb.setOpaque(true);
        lb.setBackground(Color.red);
        lb.setSize(50,50);
        lb.addMouseListener(this);

        this.add(lb);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        lb.setBackground(Color.green);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lb.setBackground(Color.yellow);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        lb.setBackground(Color.orange);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        lb.setBackground(Color.black);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        lb.setBackground(Color.GRAY);
    }
}
