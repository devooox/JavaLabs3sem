import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentCollection {
    public List<Student> starterStudentsData;
    public List<Student> processedStudentData;

    StudentCollection() {
        starterStudentsData = new ArrayList<>();
        processedStudentData = new ArrayList<>();
    }

    void addStudent(int cardNumber, String surname, String subject, Integer grade) {
        boolean isFound = false;
        for (Student i : starterStudentsData) {
            if (i.getCardNumber() == cardNumber && i.getSurname().equals(surname)) {
                isFound = true;
                if (i.isSmart() && grade < 9) {
                    processedStudentData.remove(i);
                    i.setSmart(false);
                }
                i.getGrades().put(subject, grade);
                break;
            }
        }
        if (!isFound) {
            HashMap<String, Integer> grades = new HashMap<>();
            grades.put(subject, grade);
            Student tmp = new Student(cardNumber, surname, grades);
            starterStudentsData.add(tmp);
            if (grade > 8) {
                tmp.setSmart(true);
                processedStudentData.add(tmp);
                processedStudentData.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return  o1.getSurname().compareTo(o2.getSurname());
                    }
                });
            }
        }
    }

    void loadStudents(File inputFile) throws IOException, InputMismatchException {
        Scanner reader = new Scanner(inputFile);
        while (reader.hasNext()) {
            int cardNumber = reader.nextInt();
            String surname = reader.next();
            String subject = reader.next();
            Integer grade = reader.nextInt();
            addStudent(cardNumber, surname, subject, grade);
        }
    }

    void clear() {
        starterStudentsData.clear();
        processedStudentData.clear();
    }
}
