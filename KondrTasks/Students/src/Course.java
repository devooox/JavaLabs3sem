import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class Course implements Iterable<Student> {
    private Set<Student> students;
    private String name;

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    Set<Postgraduate> getPostgraduates(String nameOfSupervisor) {
        Set<Postgraduate> result = new HashSet<Postgraduate>();
//        Iterator it = students.iterator();
//        while (it.hasNext()) {
//            Student tmp = (Student) it.next();
//            if (tmp instanceof Postgraduate) {
//                if (((Postgraduate) tmp).getSupervisor().getName() == nameOfSupervisor) {
//                    result.add((Postgraduate) tmp);
//                }
//            }
//        }
        for (Student student : students) {
            if (student instanceof Postgraduate) {
                if (((Postgraduate) student).getSupervisor().getName() == nameOfSupervisor) {
                    result.add((Postgraduate) student);
                }
            }
        }
        return result;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public Set<Student> predStudents(Predicate<Student> predicate) {
        HashSet<Student> result = new HashSet<Student>();
        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public Iterator<Student> iterator()
    {
        return students.iterator();
    }
}
