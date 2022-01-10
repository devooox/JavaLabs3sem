public class IncandescentLamp extends Lightbulb{
    private Integer operatingTime;
    private final Double CONSTANT_1 = 23.5;
    IncandescentLamp(Manufacturer manufacturer, Double power, Integer operatingTime) {
        super(manufacturer, power);
        this.operatingTime = operatingTime;
    }

    public Integer getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(Integer operatingTime) {
        this.operatingTime = operatingTime;
    }

    @Override
    public Double calculateCost() {
        return Double.valueOf(Math.round(power * CONSTANT_1 * operatingTime * 100)) / 100;
    }

    @Override
    public String toString() {
        return super.toString() + " Incandescent lamp: Operating time - " + operatingTime + ".";
    }
}
