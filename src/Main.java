import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    //For storing the user's order.
    private static final ArrayList<SmartBulb> orderBulb = new ArrayList<>();
    private static final ArrayList<SmartLock> orderLock = new ArrayList<>();

    //Initializing factories.
    private static final SmartDeviceFactory factoryBrandA = new FactoryBrandA();
    private static final SmartDeviceFactory factoryBrandB = new FactoryBrandB();

    private static void orderAssembler(String itemBrand, String itemType, double usageLevel) {
        if (itemType.equalsIgnoreCase("BULB")) {
            SmartBulb bulb;
            if (itemBrand.equalsIgnoreCase("BRANDA")) {
                bulb = factoryBrandA.createSmartBulb();
            } else {
                bulb = factoryBrandB.createSmartBulb();
            }
            bulb.setPower(usageLevel);
            orderBulb.add(bulb);
        } else if (itemType.equalsIgnoreCase("LOCK")) {
            SmartLock lock;
            if (itemBrand.equalsIgnoreCase("BRANDA")) {
                lock = factoryBrandA.createSmartLock();
            } else {
                lock = factoryBrandB.createSmartLock();
            }
            lock.setBattery(usageLevel);
            orderLock.add(lock);
        }
    }

    public static void main(String[] args) {

        Scanner userFileScanner = new Scanner(System.in);
        //Scanner userInputScanner = new Scanner(System.in);
        File fileToRead;

        //Ensure correct user input through continuous prompting.
        do {
            System.out.println("\nPlease enter the name of the file you want to read: ");
            String fileName = userFileScanner.nextLine();
            fileToRead = new File(fileName);

            if (!fileToRead.exists()) {
                System.out.println("File: " + fileName + " does not exist");
            }
        } while (!fileToRead.exists());


        //Reading file with exception handling just in case.
        System.out.println("Reading file: " + fileToRead.getName());

        try (Scanner fileScanner = new Scanner(fileToRead)) {

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] lineParts = line.split("\\s+");

                if (lineParts.length == 3 && (lineParts[0].equalsIgnoreCase("BRANDA") ||
                        lineParts[0].equalsIgnoreCase("BRANDB")) &&
                        (lineParts[1].equalsIgnoreCase("BULB") || lineParts[1].equalsIgnoreCase("LOCK"))) {

                    String brand = lineParts[0];
                    String product = lineParts[1];
                    double level;

                    try {
                        level = Double.parseDouble(lineParts[2]);
                    } catch (NumberFormatException e) {
                        level = 0;
                    }

                    orderAssembler(brand, product, level);

                }else{
                    System.out.println("Invalid line. Skipping.");
                }
            }
            //Finished reading file.
            System.out.println("Done reading file: " + fileToRead.getName() + "\n\n");
        } catch (FileNotFoundException e) {
            System.err.println("File: " + fileToRead.getName() + " does not exist");
        }

        //Printing both lists of Bulbs and Locks
        int i = 1, j = 1;
        System.out.println("\n\nPrinting all smart bulbs:");
        for (SmartBulb bulb : orderBulb) {
            System.out.println("Power level of bulb " + i + " from " + bulb.getManufacturer()
                    + ": " + bulb.getPower() + "W");
            i++;
        }
        System.out.println("\nPrinting all smart locks:");
        for (SmartLock lock : orderLock) {
            System.out.println("Battery level of lock " + j + " from " + lock.getManufacturer()
                    + ": " + lock.getBattery() + "%");
            j++;
        }
    }
}