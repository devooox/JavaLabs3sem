import Sweetness.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


public class Present implements Iterable {
    private ArrayList<Sweetness> sweetnesses;

    public Present(ArrayList<Sweetness> sweetnesses) {
        this.sweetnesses = sweetnesses;
    }

    @Override
    public Iterator iterator() {
        return sweetnesses.iterator();
    }

    public void sort() {
        sweetnesses.sort(new Comparator<Sweetness>() {
            @Override
            public int compare(Sweetness o1, Sweetness o2) {
                return ((Integer)o1.getWeight()).compareTo(o2.getWeight());
            }
        });
    }

    public int getWeight() {
        int result = 0;
        Iterator it = iterator();
        while (it.hasNext()) {
            result += ((Sweetness)it.next()).getWeight();
        }
        return result;
    }

    public Sweetness findSweetness(int minimumSugarContent, int maximumSugarContent) throws ContentException {
        Iterator it = iterator();
        while (it.hasNext()) {
            Sweetness sweetness = (Sweetness) it.next();
            if (sweetness.getWeight() >= minimumSugarContent && sweetness.getWeight() <= maximumSugarContent) {
                return sweetness;
            }
        }
        throw new ContentException("Sweetness with specified content of sugar don't exist");
    }

    public class ContentException extends Exception {
        public ContentException(String message) {
            super(message);
        }
    }
}
