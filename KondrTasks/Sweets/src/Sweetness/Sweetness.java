package Sweetness;

public abstract class Sweetness {
    private int weight;
    private int sugarContent;

    public Sweetness(int weight, int sugarContent) {
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public int getWeight() {
        return weight;
    }

    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Sweetness: Weight - " + getWeight() + "; Sugar content - " + getSugarContent() +";";
    }
}
