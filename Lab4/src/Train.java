import java.io.PrintStream;

public class Train implements Comparable<Train> {
    int vagoni;
    int number;
    Train() {
        vagoni = 0;
        number = -1;
    }
    Train(int vagoni, int number){
        this.vagoni = vagoni;
        this.number = number;
    }
    public int compareTo(Train train) {
        if(vagoni > train.vagoni) {
            return 1;
        } else if (vagoni < train.vagoni){
            return -1;
        } else if (number > train.number) {
            return 1;
        } else if (number < train.number) {
            return  -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Vagoni: ");
        str.append(vagoni);
        str.append(" Number: ");
        str.append(number);
        return str.toString();
    }
}
