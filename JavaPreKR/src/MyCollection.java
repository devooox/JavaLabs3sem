import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MyCollection<T extends Comparable<T>> extends ArrayList<T> {
    public T getMinimum() {
        if (isEmpty()) {
            throw new NoSuchElementException("Container is empty");
        }
        T min = get(0);
        for (T elem : this) {
            if (elem.compareTo(min) < 0) {
                min = elem;
            }
        }
        return min;
    }

    public T getMinimum2() {
        if (isEmpty()) {
            throw new NoSuchElementException("Conatiner is empty");
        }
        return Collections.min(this);
    }
}
