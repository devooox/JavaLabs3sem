import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class DataKeeper<T extends Comparable<T>> implements Iterable {
    private ArrayList<T> data;

    public DataKeeper(ArrayList<T> data) {
        this.data = data;
    }

    public void addElement(T element) {
        data.add(element);
    }

    public int getSize() {
        return data.size();
    }

    public T getMaximum() throws SizeException {
        if (getSize() == 0) {
            throw new SizeException("No data");
        }
        Iterator it = iterator();
        T tmp1 = (T) it.next();
        while (it.hasNext()) {
            T tmp2 = (T) it.next();
            if (tmp1.compareTo(tmp2) < 0) {
                tmp1 = tmp2;
            }
        }
        return tmp1;
    }

    public T getMinimum() throws SizeException {
        if (getSize() == 0) {
            throw new SizeException("No data");
        }
        Iterator it = iterator();
        T tmp1 = (T) it.next();
        while (it.hasNext()) {
            T tmp2 = (T) it.next();
            if (tmp1.compareTo(tmp2) > 0) {
                tmp1 = tmp2;
            }
        }
        return tmp1;
    }

    @Override
    public Iterator iterator() {
        return data.iterator();
    }
}
