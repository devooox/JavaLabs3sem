import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        try {
            DataKeeper<Double> doubleDataKeeper = new DataKeeper<Double>(DataReader.readDouble("src/in.txt"));
            Iterator it = doubleDataKeeper.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println(doubleDataKeeper.getSize());
            System.out.println(doubleDataKeeper.getMaximum());
            System.out.println(doubleDataKeeper.getMinimum());
        } catch (NumberFormatException e) {
            System.out.println("Error data");
        } catch (FileNotFoundException e) {
            System.out.println("Error file path");
        } catch (SizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            DataKeeper<Student> studentDataKeeper = new DataKeeper<Student>(DataReader.readStudents("src/in1.txt"));
            Iterator it = studentDataKeeper.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println(studentDataKeeper.getSize());
            System.out.println(studentDataKeeper.getMaximum());
            System.out.println(studentDataKeeper.getMinimum());
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Error data");
        } catch (FileNotFoundException e) {
            System.out.println("Error file path");
        } catch (SizeException e) {
            System.out.println(e.getMessage());
        }

    }
}
