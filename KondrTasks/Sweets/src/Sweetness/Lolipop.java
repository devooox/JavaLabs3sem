package Sweetness;

public class Lolipop extends Sweetness{
    private String form;

    public Lolipop(int weight, int sugarContent, String form) {
        super(weight, sugarContent);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return super.toString() + " Form - " + getForm() + "; Sweetness type - Lolipop;";
    }
}
