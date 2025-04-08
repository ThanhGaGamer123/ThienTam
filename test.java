import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Input Example");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            String inputText = textField.getText();
            System.out.println(inputText); // In ra văn bản nhập vào
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(textField);
        frame.add(button);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}