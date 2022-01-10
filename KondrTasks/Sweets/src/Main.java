import Sweetness.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Sweetness> sweetnesses = new ArrayList<Sweetness>();
        sweetnesses.add(new Marmalade(150, 30, 5));
        sweetnesses.add(new Chocolate(200, 10, 150));
        sweetnesses.add(new Lolipop(100, 40, "Spiral"));

        Present present = new Present(sweetnesses);
        Iterator it = present.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        present.sort();
        System.out.println();
        it = present.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        try {
            System.out.println(present.findSweetness(75, 125));
            System.out.println(present.findSweetness(150, 200));
            System.out.println(present.findSweetness(750, 825));
        } catch (Present.ContentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println(present.getWeight());
    }
}
