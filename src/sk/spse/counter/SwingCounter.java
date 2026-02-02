package sk.spse.counter;

import javax.swing.*;
import java.awt.*;

public class SwingCounter {

    private int counter = 0;

    public SwingCounter() {
        JFrame frame = new JFrame("Swing Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        Font bigFont = new Font("SansSerif", Font.PLAIN, 16);

        JLabel label = new JLabel("Počítadlo:");
        label.setFont(bigFont);
        panel.add(label);

        JTextField textField = new JTextField("0", 5);
        textField.setFont(bigFont);

        panel.add(textField);

        JButton button = new JButton("Plus 1");
        button.setFont(bigFont);
        button.addActionListener(e -> {
            counter++;
            textField.setText(String.valueOf(counter));
        });
        panel.add(button);

        frame.setContentPane(panel);
        frame.setSize(280, 90);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingCounter::new);
    }
}
