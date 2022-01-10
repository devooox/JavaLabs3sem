public class Liner extends Series {
    public Liner(){
        super();
    }
    public Liner(double f, double c, int a){
        super(f, c, a);
    }

    public double calcElement(int elementNumber) {
        return first + coefficent * (elementNumber-1);
    }
}
