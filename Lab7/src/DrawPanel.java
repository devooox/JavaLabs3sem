import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private int xStartDrawing;
    private int yStartDrawing;
    private BufferedImage image;
    private Color color;

    DrawPanel() {
        image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_ARGB);
        color = new Color(0, 0,0);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                xStartDrawing = e.getX();
                yStartDrawing = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Graphics g1;
                g1 = image.getGraphics();
                g1.setColor(color);
                g1.drawLine(xStartDrawing, yStartDrawing, e.getX(), e.getY());
                xStartDrawing = e.getX();
                yStartDrawing = e.getY();
                repaint();
            }
        });
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(2000, 2000);
    }
}
