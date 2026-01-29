package sk.spse.counter;

import javax.swing.*;
import java.awt.*;

public class SwingCounterSimple {

    private int counter = 0;

    public SwingCounterSimple() {
        JFrame frame = new JFrame("Swing Counter Simple");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        Font bigFont = new Font("SansSerif", Font.PLAIN, 48);

        JLabel label = new JLabel("Counter:");
        label.setFont(bigFont);
        panel.add(label);

        JTextField textField = new JTextField("0", 5);
        textField.setFont(bigFont);
        textField.setEditable(false);

        // padding textu v edit boxe
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        panel.add(textField);

        JButton button = new JButton("+");
        button.setFont(bigFont);
        button.addActionListener(e -> {
            counter++;
            textField.setText(String.valueOf(counter));
        });
        panel.add(button);

        frame.setContentPane(panel);
        frame.setSize(700, 180);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingCounterSimple::new);
    }
}
