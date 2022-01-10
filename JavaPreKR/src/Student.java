public class Student implements Comparable<Student> {
    private String surname;
    private int course;
    private double averageScore;

    public Student(String surname, int course, double averageScore) {
        this.surname = surname;
        this.course = course;
        this.averageScore = averageScore;
    }


    @Override
    public int compareTo(Student o) {
        return surname.compareTo(o.surname);
    }

    @Override
    public String toString() {
        return "Student: Surname - " + surname + "; Course - " + course + "; Average score - " + averageScore + ";";
    }
}
