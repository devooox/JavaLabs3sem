import javax.swing.*;
import java.awt.*;

public class CourseFrame extends JFrame {
    public CourseFrame(Course course){
        setSize(600, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new CoursePanel(course), BorderLayout.CENTER);
        setVisible(true);
    }
}
