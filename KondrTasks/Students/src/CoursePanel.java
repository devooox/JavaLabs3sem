import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class CoursePanel extends JPanel {
    public CoursePanel(Course course) {
        super();
        setLayout(new BorderLayout());
        JPanel nameCoursePanel = new JPanel();
        nameCoursePanel.add(new JLabel(course.getName()));
        add(nameCoursePanel, BorderLayout.NORTH);
        JPanel dataPanel = new JPanel();
        Iterator it = course.iterator();
        int counter = 0;
        while (it.hasNext()) {
            counter++;
            Student tmp = (Student) it.next();
            String studentInfo = new String();
            String academicName;
            if (tmp instanceof Postgraduate) {
                studentInfo += "Postgraduate ";
                academicName = ((Postgraduate) tmp).getSupervisor().getName();
            } else {
                studentInfo += "Undergraduate ";
                academicName = ((Undergraduate)tmp).getTutor().getName();
            }
            studentInfo += tmp.getName() + " " + tmp.getLogin() + " " + tmp.getEmail() + " " + academicName;
            dataPanel.add(new JLabel(studentInfo));
        }
        dataPanel.setLayout(new GridLayout(counter, 1));
        add(dataPanel, BorderLayout.CENTER);
    }
}
