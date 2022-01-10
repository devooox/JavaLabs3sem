import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    Window(String str) {
        super(str);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        JLabel questionLabel = new JLabel("Do you like java?");
        JButton yesButton = new JButton("I like it");
        JButton noButton = new JButton("No, please");
        panel.setLayout(null);
        panel.add(questionLabel);
        panel.add(yesButton);
        panel.add(noButton);
        questionLabel.setBounds(250, 75, 100, 25);
        yesButton.setBounds(125, 250, 100, 30);
        noButton.setBounds(375, 250, 100, 30);
        yesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(Window.this, "FAMCS proud of you", "Good job", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                xCoordinates = e.getX();
                yCoordinates = e.getY();
            }
        });
        noButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                int buttonCenterX = noButton.getX() + noButton.getWidth()/2;
                int buttonCenterY = noButton.getY() + noButton.getHeight()/2;
                int vectorX = buttonCenterX - xCoordinates;
                int vectorY = buttonCenterY - yCoordinates;
                int newLocationX = noButton.getX() + vectorX/2;
                int newLocationY = noButton.getY() + vectorY;
                if (newLocationY > 0 && newLocationY + 2*noButton.getHeight() < WINDOW_HEIGHT && newLocationX > 0 && newLocationX + noButton.getWidth() < WINDOW_WIDTH) {
                    noButton.setLocation(newLocationX, newLocationY);
                } else {
                    noButton.setLocation(375, 250);
                }
            }
        });
    }

    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = 600;

    private int xCoordinates = 0;
    private int yCoordinates = 0;
}
