import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Task2 extends JPanel {

    private int buttonNumber = 0;
    private MouseAdapter listener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            ((JButton) e.getSource()).setBackground(Color.PINK);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            ((JButton) e.getSource()).setBackground(Color.WHITE);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            buttonNumber = Integer.parseInt(((JButton) e.getSource()).getText());
            ((JButton) e.getSource()).setText("Clicked!");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            ((JButton) e.getSource()).setText(Integer.toString(buttonNumber));
        }
    };

    Task2(int rows, int colomns) {
        setLayout(new GridLayout(rows, colomns));
        JButton[] buttons = new JButton[rows*colomns];
        for (int i = 0; i < rows*colomns; ++i) {
            buttons[i] = new JButton(Integer.toString(i + 1));
            buttons[i].setBackground(Color.WHITE);
            add(buttons[i]);
            buttons[i].addMouseListener(listener);
        }

    }
}
