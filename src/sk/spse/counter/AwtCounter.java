package sk.spse.counter;

import java.awt.*;
import java.awt.event.*;

public class AwtCounter extends Frame {

    private int counter = 0;
    private TextField textField;

    public AwtCounter() {
        super("AWT Counter");

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // hgap, vgap

        Font bigFont = new Font("SansSerif", Font.PLAIN, 36);

        Label label = new Label("Počítadlo:");
        label.setFont(bigFont);
        add(label);

        textField = new TextField("0", 5);
        textField.setFont(bigFont);
        add(textField);

        Button button = new Button("Plus 1");
        button.setFont(bigFont);
        add(button);
        button.addActionListener(e -> {
            counter++;
            textField.setText(String.valueOf(counter));
        });

        setSize(500, 180);
        setResizable(true);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new AwtCounter();
    }
}
