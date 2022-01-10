import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;

public class Window extends JFrame {
    Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        JPanel mainPanel = new JPanel();
        JTextField textField1 = new JTextField("Aboba");
        JTextField textField2 = new JTextField("Aboba2");
        JButton editButton = new JButton("Edit");
        mainPanel.setLayout(new BorderLayout(50, 50));
        mainPanel.add(textField1, BorderLayout.NORTH);
        mainPanel.add(editButton, BorderLayout.CENTER);
        mainPanel.add(textField2, BorderLayout.SOUTH);
        add(mainPanel);
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String string = new String(textField1.getText());
                boolean isFoundNumber = false;
                double result = 0;
                StringTokenizer tokenizer = new StringTokenizer(string, " ,;\n");
                while (tokenizer.hasMoreTokens()) {
                    try {
                        result += Double.parseDouble(tokenizer.nextToken());
                        isFoundNumber = true;
                    } catch (NumberFormatException ex) {
                        //do nothing
                    }
                }
                if (isFoundNumber) {
                    textField2.setText(String.valueOf(result));
                }
            }
        });

        setVisible(true);
    }
}
