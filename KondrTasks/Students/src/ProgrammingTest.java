import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class ProgrammingTest {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<Student>();
        students.add(new Undergraduate("Peter", "gg4", "mir@bsu.by", "Paul Deitel"));
        students.add(new Undergraduate("Michael", "pr3", "spike@bsu.by", "Cay Horstmann"));
        students.add(new Postgraduate("Aksel", "te2", "paiper@bsu.by", "Paul Deitel"));
        students.add(new Postgraduate("Jotaro", "yj34", "zawarudo@bsu.by", "Cay Horstmann"));
        students.add(new Postgraduate("Dio", "jj8", "pepsi@bsu.by", "Cay Horstmann"));
        Course famcsCourse = new Course("FAMCS", students);

        Set<Postgraduate> cleverStudents = famcsCourse.getPostgraduates("Cay Horstmann");
        System.out.println("Postgraduates that have Cay Horstmann as supervisor:");
        for (Postgraduate stud : cleverStudents) {
            System.out.println(stud.getName());
        }
        System.out.println();

        Notifier notifier = new Notifier(students);
        notifier.doNotifyAll("Hello, students");
        System.out.println();

        famcsCourse.addStudent(new Postgraduate("Eren", "er3", "killTitans@bsu.by", "Cay Horstmann"));
        System.out.println("All students after adding Eren:");
        Iterator it = famcsCourse.iterator();
        while (it.hasNext()) {
            System.out.println(((Student)it.next()).getName());
        }
        System.out.println();

        cleverStudents = famcsCourse.getPostgraduates("Cay Horstmann");
        System.out.println("Postgraduates that have Cay Horstmann as supervisor:");
        for (Postgraduate stud : cleverStudents) {
            System.out.println(stud.getName());
        }
        System.out.println();

        System.out.println("Students that have name longer than 5 symbols:");
        Predicate<Student> predicate = (stud) -> stud.getName().length() > 5;
        Set<Student> longStudents = famcsCourse.predStudents(predicate);
        for (Student stud : longStudents) {
            System.out.println(stud.getName());
        }
        System.out.println();

        try {
            CourseWriter.writeCourseToFile("src/courseinfo.txt", famcsCourse);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        CourseFrame frame = new CourseFrame(famcsCourse);
    }
}
