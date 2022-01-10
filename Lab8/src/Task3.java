import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class Task3 extends JPanel {
    private JRadioButton[] radioButtons = new JRadioButton[5];
    private ButtonGroup radioButtonGroup = new ButtonGroup();
    private Icon redIcon = new ImageIcon("src/red.png");
    private Icon greenIcon = new ImageIcon("src/green.png");
    private Icon rolloverIcon = new ImageIcon("src/smile.png");
    private Icon pressedIcon = new ImageIcon("src/pressed.png");
    Task3() {
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        for (int i = 0; i < 5; ++i) {
            radioButtons[i] = new JRadioButton(Integer.toString(i+1));
            radioButtons[i].setIcon(redIcon);
            radioButtons[i].setSelectedIcon(greenIcon);
            radioButtons[i].setRolloverIcon(rolloverIcon);
            radioButtons[i].setPressedIcon(pressedIcon);
            radioButtonGroup.add(radioButtons[i]);
            buttonPanel.add(radioButtons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }
}
