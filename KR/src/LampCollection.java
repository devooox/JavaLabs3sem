import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LampCollection<T extends Lightbulb> extends ArrayList<T> {
    public void readDataOfType1(String filePath) throws FileNotFoundException, NumberFormatException, NoSuchElementException, EnumIncorrectException, NegativeNumberException {
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            Manufacturer manufacturer = Manufacturer.toType(scanner.next());
            Double power = Double.parseDouble(scanner.next());
            if (power <= 0 ) {
                throw new NegativeNumberException("Power can't be 0 or lower");
            }
            Integer operatingTime = scanner.nextInt();
            if (operatingTime < 0) {
                throw new NegativeNumberException("Time can't be negative");
            }
            add((T) new IncandescentLamp(manufacturer, power, operatingTime));
        }
    }

    public void readDataOfType2(String filePath) throws FileNotFoundException, NumberFormatException, NoSuchElementException, EnumIncorrectException, NegativeNumberException {
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            Manufacturer manufacturer = Manufacturer.toType(scanner.next());
            Double power = Double.parseDouble(scanner.next());
            if (power <= 0 ) {
                throw new NegativeNumberException("Power can't be 0 or lower");
            }
            Integer numberOfLEDs = scanner.nextInt();
            if (numberOfLEDs < 0) {
                throw new NegativeNumberException("Number of LEDs can't be negative");
            }
            add((T) new LEDBulb(manufacturer, power, numberOfLEDs));
        }
    }

    public LampCollection<T> getLampsInDescendingOrderOfPrice() {
        LampCollection<T> result = (LampCollection<T>) this.clone();
        result.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o2.calculateCost().compareTo(o1.calculateCost());
            }
        });
        return result;
    }

    public LampCollection<T> getLampsInDescendingOrderCostToPower() {
        LampCollection<T> result = (LampCollection<T>) this.clone();
        result.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Double)(o2.calculateCost()/o2.getPower())).compareTo((Double)(o1.calculateCost()/ o1.getPower()));
            }
        });
        return result;
    }

    public Set<Manufacturer> getManufacturers() {
        Set<Manufacturer> result = new HashSet<>();
        for (T lamp:
             this) {
            result.add(lamp.getManufacturer());
        }
        return result;
    }

    public Double averageCostOfManufacturer(String manufacturer) throws EnumIncorrectException, ManufacturerException {
        Manufacturer manufacturer1 = Manufacturer.toType(manufacturer);
        double cost = 0;
        int amount = 0;
        for (T lamp:
             this) {
            if (lamp.getManufacturer() == manufacturer1) {
                cost += lamp.calculateCost();
                amount++;
            }
        }
        if (amount == 0) {
            throw new ManufacturerException("This collection does not contain bulbs from this manufacturer");
        }
        return cost/amount;
    }
}
