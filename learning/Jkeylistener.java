package learning;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Jkeylistener extends JFrame implements KeyListener {
    JLabel lb;

    Jkeylistener() {
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.addKeyListener(this);

        lb = new JLabel();
        lb.setOpaque(true);
        lb.setBackground(Color.red);
        lb.setSize(50,50);

        this.add(lb);
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());

        switch (e.getKeyChar()) {
            case 'a':
                lb.setLocation(lb.getX()-20, lb.getY());
                break;
            case 'd':
                lb.setLocation(lb.getX()+20, lb.getY());
                break;
            case 'w':
                lb.setLocation(lb.getX(), lb.getY()-20);
                break;
            case 's':
                lb.setLocation(lb.getX(), lb.getY()+20);
                break;
            default:
                break;
        }

        switch (e.getKeyCode()) {
            case 37:
                lb.setLocation(lb.getX()-20, lb.getY());
                break;
            case 39:
                lb.setLocation(lb.getX()+20, lb.getY());
                break;
            case 38:
                lb.setLocation(lb.getX(), lb.getY()-20);
                break;
            case 40:
                lb.setLocation(lb.getX(), lb.getY()+20);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
