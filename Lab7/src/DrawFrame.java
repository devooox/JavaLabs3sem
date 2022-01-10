import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class DrawFrame extends JFrame {
    DrawPanel drawPanel;
    JScrollPane panel;

    DrawFrame() {
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();

        panel = new JScrollPane(drawPanel);
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton colorButton = new JButton("Color");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        buttonPanel.add(colorButton, BorderLayout.SOUTH);
        buttonPanel.add(saveButton, BorderLayout.SOUTH);
        buttonPanel.add(loadButton, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

        colorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                drawPanel.setColor(JColorChooser.showDialog(null, "Choose color", Color.BLACK));
            }
        });
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(DrawFrame.this) == JFileChooser.APPROVE_OPTION) {
                    File outputFile = chooser.getSelectedFile();
                    try {
                        ImageIO.write(drawPanel.getImage(), "png", outputFile);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(DrawFrame.this, "Error when writing to file");
                    }
                }
            }
        });
        loadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(DrawFrame.this) == JFileChooser.APPROVE_OPTION) {
                    File outputFile = chooser.getSelectedFile();
                    try {
                        drawPanel.setImage(ImageIO.read(chooser.getSelectedFile()));
                        repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(DrawFrame.this, "Error when opening file");
                    }
                }
            }
        });
    }
}
