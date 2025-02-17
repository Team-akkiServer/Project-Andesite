package akki697222.andesite.interpreter;

import javax.swing.*;
import java.awt.*;

public class AndesiteDebugger extends JFrame {
    private final JTextArea textArea;

    public AndesiteDebugger() {
        setTitle("Andesite Debugger");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(640, 480);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        add(textArea);

        setVisible(true);
    }

    public void update(String text) {
        textArea.setText(text);
    }
}
