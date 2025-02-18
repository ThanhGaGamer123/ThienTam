package learning;
import javax.swing.JFrame;

public class Jframe {
    public Jframe() {
        JFrame frame = new JFrame("Hello");
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Jframe();
    }
}