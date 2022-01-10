import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CourseWriter {
    public static void writeCourseToFile(String filepath, Course course) throws IOException {
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(course.getName() + "\n");
            Iterator it = course.iterator();
            while (it.hasNext()) {
                Student tmp = (Student) it.next();
                String academicName;
                if (tmp instanceof Postgraduate) {
                    writer.write("Postgraduate ");
                    academicName = ((Postgraduate) tmp).getSupervisor().getName() + "\n";
                } else {
                    writer.write("Undergraduate ");
                    academicName = ((Undergraduate)tmp).getTutor().getName() + "\n";
                }
                writer.write(tmp.getName() + " " + tmp.getLogin() + " " + tmp.getEmail() + " " + academicName);
            }
        }
    }
}
