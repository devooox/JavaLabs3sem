package Sweetness;

public class Chocolate extends Sweetness{
    private int choclateContent;

    public Chocolate(int weight, int sugarContent, int choclateContent) {
        super(weight, sugarContent);
        this.choclateContent = choclateContent;
    }

    public int getChoclateContent() {
        return choclateContent;
    }

    public void setChoclateContent(int choclateContent) {
        this.choclateContent = choclateContent;
    }

    @Override
    public String toString() {
        return super.toString() + " Chocolate content - " + getChoclateContent() + "; Sweetness type - Chocolate;";
    }
}
