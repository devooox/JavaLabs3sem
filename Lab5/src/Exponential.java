public class Exponential extends Series  {
    public Exponential(){
        super();
    }

    public Exponential(double f, double c, int a){
        super(f, c, a);
    }

    public double calcElement(int elementNumber) {
        return first * Math.pow(coefficent , elementNumber-1);
    }
}
