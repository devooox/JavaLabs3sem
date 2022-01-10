public abstract class Lightbulb {
    protected Manufacturer manufacturer;
    protected Double power;
    public Lightbulb(Manufacturer manufacturer, Double power) {
        this.manufacturer = manufacturer;
        this.power = power;
    }

    public Double getPower() {
        return power;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public abstract Double calculateCost();

    @Override
    public String toString() {
        return "Lightbulb: Manufacturer - " + manufacturer.toString() + ", Power - " + power + ";";
    }
}
