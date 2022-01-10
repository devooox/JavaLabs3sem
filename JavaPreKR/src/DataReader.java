import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataReader {
    public static ArrayList<Double> readDouble(String filePath) throws FileNotFoundException, NumberFormatException {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<Double> result = new ArrayList<Double>();
        while (scanner.hasNext()) {
            result.add(Double.parseDouble(scanner.next()));
        }
        return result;
    }

    public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException, NumberFormatException, NoSuchElementException {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<Student> result = new ArrayList<Student>();
        while (scanner.hasNext()) {
            String surname = scanner.next();
            int course = scanner.nextInt();
            double averageScore = Double.parseDouble(scanner.next());
            result.add(new Student(surname, course, averageScore));
        }
        return result;
    }
}
