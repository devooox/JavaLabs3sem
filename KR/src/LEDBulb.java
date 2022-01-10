public class LEDBulb extends Lightbulb{
    private Integer numberOfLEDs;
    private final Double CONSTANT_2 = 15.5;
    LEDBulb(Manufacturer manufacturer, Double power, Integer numberOfLEDs) {
        super(manufacturer, power);
        this.numberOfLEDs = numberOfLEDs;
    }

    public Integer getNumberOfLEDs() {
        return numberOfLEDs;
    }

    public void setNumberOfLEDs(Integer numberOfLEDs) {
        numberOfLEDs = numberOfLEDs;
    }

    @Override
    public Double calculateCost() {
        return Double.valueOf(Math.round(power * numberOfLEDs / CONSTANT_2 * 100)) / 100;
    }

    @Override
    public String toString() {
        return super.toString() + " LED Bulb: Number of LEDs - " + numberOfLEDs + ".";
    }
}
