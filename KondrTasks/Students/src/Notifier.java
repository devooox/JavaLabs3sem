import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Notifier {
    private Set<Student> notifiables;

    public Notifier(Set<Student> notifiables) {
        this.notifiables = notifiables;
    }

    public void doNotifyAll(String message) {
        for (Student student : notifiables) {
            student.notify(message);
        }
    }

}
