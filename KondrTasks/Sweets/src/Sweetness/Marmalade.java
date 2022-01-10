package Sweetness;

public class Marmalade extends Sweetness{
    private int length;

    public Marmalade(int weight, int sugarContent, int length) {
        super(weight, sugarContent);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + " Length - " + getLength() + "; Sweetness type - Marmalade;";
    }
}
