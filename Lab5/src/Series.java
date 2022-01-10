import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    double first;
    double coefficent;
    int amount;

    public Series(double f, double c, int a){
        first = f;
        coefficent = c;
        if (a >= 0) {
            amount = a;
        } else {
            amount = 0;
        }
    }

    public Series(){
        this(0, 0, 0);
    }

    public abstract double calcElement(int elementNumber);

    public double calcSeries()  {
        double sum = 0;
        for (int i = 0; i < amount; ++i) {
            sum +=  calcElement(i+1);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < amount; ++i) {
            str.append(Double.toString(calcElement(i+1)));
            str.append(" ");
        }
        str.append("\n");
        str.append(Double.toString(calcSeries()));
        return str.toString();
    }

    public String toElements() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < amount; ++i) {
            str.append(Double.toString(calcElement(i+1)));
            str.append(" ");
        }
        return str.toString();
    }

    public void writeToFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(toString());
        writer.close();
    }
}

