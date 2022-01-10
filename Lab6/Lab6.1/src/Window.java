import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    Window(String str) {
        super(str);
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        JButton button = new JButton("Button");
        panel.setLayout(null);
        panel.add(button);
        button.setBounds(10,10, 100, 30);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                button.setLocation(e.getX() - button.getBounds().width / 2, e.getY() - button.getBounds().height / 2);
            }
        });
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                setCoordinates(e.getX(), e.getY());
            }
            public void mouseDragged(MouseEvent e){
                super.mouseMoved(e);
                setCoordinates(e.getX(), e.getY());
            }
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                xCoordinates = e.getX();
                yCoordinates = e.getY();
            }
        });

        button.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                setCoordinates(button.getLocation().x + e.getX(), button.getLocation().y + e.getY());
            }
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                mouseMoved(e);
                if (e.isControlDown()) {
                    button.setLocation(e.getX() + button.getLocation().x - xCoordinates, e.getY() + button.getLocation().y - yCoordinates);
                }
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (button.getText().length() >= 1) {
                        button.setText(button.getText().substring(0, button.getText().length() - 1));
                    } else {
                        button.setText("");
                    }
                } else if (e.getKeyChar() == KeyEvent.VK_DELETE){
                    if (button.getText().length() >= 1) {
                        button.setText(button.getText().substring(1, button.getText().length()));
                    } else {
                        button.setText("");
                    }
                } else {
                    button.setText(button.getText() + e.getKeyChar());
                }
            }
        });
    }
    void setCoordinates(int x, int y) {
        statusBar.setText("x = " + Integer.toString(x) + " y = " + Integer.toString(y));
    }

    JLabel statusBar = new JLabel("QQ");

    private int xCoordinates = 0;
    private int yCoordinates = 0;
}
