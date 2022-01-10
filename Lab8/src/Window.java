import javax.swing.*;
import java.awt.*;

public class Window  extends JFrame {
    JTabbedPane mainPanel;

    Window() {
        setLayout(new BorderLayout());
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel = new JTabbedPane();
        mainPanel.addTab("Task1", new Task1());
        mainPanel.addTab("Task2", new Task2(4, 5));
        mainPanel.addTab("Task3", new Task3());
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
