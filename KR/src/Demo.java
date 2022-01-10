import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {
	    LampCollection<Lightbulb> collection = new LampCollection<>();
        try {
            collection.readDataOfType1("src/input1.txt");
            System.out.println("Starter collection of type 1 with their cost");
            for (Lightbulb bulb:
                 collection) {
                System.out.println(bulb.toString() + " Cost - " + bulb.calculateCost());
            }
            System.out.println();

            LampCollection<Lightbulb> tmp = collection.getLampsInDescendingOrderOfPrice();
            System.out.println("Collection of type 1 bulbs in descending order of price with their cost");
            for (Lightbulb bulb:
                    tmp) {
                System.out.println(bulb.toString() + " Cost - " + bulb.calculateCost());
            }
            System.out.println();

            tmp = collection.getLampsInDescendingOrderCostToPower();
            System.out.println("Collection of type 1 bulbs in descending order of price to power with their price to power");
            for (Lightbulb bulb:
                    tmp) {
                System.out.println(bulb.toString() + " Price to power - " + bulb.calculateCost()/bulb.getPower());
            }
            System.out.println();

            Set<Manufacturer> manufacturerSet = collection.getManufacturers();
            System.out.println("Set of manufacturers");
            for (Manufacturer manufacturer:
                    manufacturerSet) {
                System.out.println(manufacturer.toString());
            }
            System.out.println();

            System.out.println("Average cost of manufacturer IKEA");
            System.out.println(collection.averageCostOfManufacturer("IKEA"));
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (EnumIncorrectException | NegativeNumberException | ManufacturerException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Error data");
        }

        collection.clear();
        try {
            collection.readDataOfType1("src/input2.txt");
            System.out.println("Starter collection of type 2 with their cost");
            for (Lightbulb bulb:
                    collection) {
                System.out.println(bulb.toString() + " Cost - " + bulb.calculateCost());
            }
            System.out.println();

            LampCollection<Lightbulb> tmp = collection.getLampsInDescendingOrderOfPrice();
            System.out.println("Collection of type 2 bulbs in descending order of price with their cost");
            for (Lightbulb bulb:
                    tmp) {
                System.out.println(bulb.toString() + " Cost - " + bulb.calculateCost());
            }
            System.out.println();

            tmp = collection.getLampsInDescendingOrderCostToPower();
            System.out.println("Collection of type 2 bulbs in descending order of price to power with their price to power");
            for (Lightbulb bulb:
                    tmp) {
                System.out.println(bulb.toString() + " Price to power - " + bulb.calculateCost()/bulb.getPower());
            }
            System.out.println();

            Set<Manufacturer> manufacturerSet = collection.getManufacturers();
            System.out.println("Set of manufacturers");
            for (Manufacturer manufacturer:
                    manufacturerSet) {
                System.out.println(manufacturer.toString());
            }
            System.out.println();

            System.out.println("Average cost of manufacturer IKEA");
            System.out.println(collection.averageCostOfManufacturer("IKEA"));
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (EnumIncorrectException | NegativeNumberException | ManufacturerException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Error data");
        }
    }

}

