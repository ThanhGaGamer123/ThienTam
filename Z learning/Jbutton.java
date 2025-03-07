package learning;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jbutton extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    Jbutton() {
        ImageIcon icon = new ImageIcon("D:\\IT\\GitHub Projects\\ThienTam\\learning\\test.jpg");
        label = new JLabel();
        label.setIcon(icon);
        label.setBounds(160, 200, 300, 300);
        label.setVisible(false);

        button = new JButton("Buy Now!");
        button.setBounds(210, 150, 150, 50);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setForeground(Color.green);
        button.setBackground(Color.black);
        button.setFont(new Font("MV Boli", Font.PLAIN, 15));

        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("-100$ from purchasing product!");
            label.setVisible(true);
            button.setEnabled(false);
        }
    }
}
