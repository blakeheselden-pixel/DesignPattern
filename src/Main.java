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

    private static void orderAssembler(String itemBrand, String itemType) {
        if(itemBrand.equalsIgnoreCase("BRANDA") && itemType.equalsIgnoreCase("BULB")) {
            orderBulb.add(factoryBrandA.createSmartBulb());
        }else if(itemBrand.equalsIgnoreCase("BRANDA") && itemType.equalsIgnoreCase("LOCK")) {
            orderLock.add(factoryBrandA.createSmartLock());
        }else if(itemBrand.equalsIgnoreCase("BRANDB") && itemType.equalsIgnoreCase("BULB")) {
            orderBulb.add(factoryBrandB.createSmartBulb());
        }else if(itemBrand.equalsIgnoreCase("BRANDB") && itemType.equalsIgnoreCase("LOCK")) {
            orderLock.add(factoryBrandB.createSmartLock());
        }
    }

    public static void main(String[] args) {

        Scanner userFileScanner = new Scanner(System.in);
        Scanner userInputScanner = new Scanner(System.in);
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

                if (lineParts.length == 2 && (lineParts[0].equalsIgnoreCase("BRANDA") ||
                        lineParts[0].equalsIgnoreCase("BRANDB")) &&
                        (lineParts[1].equalsIgnoreCase("BULB") || lineParts[1].equalsIgnoreCase("LOCK"))) {

                    orderAssembler(lineParts[0], lineParts[1]);
                }else{
                    System.out.println("Invalid line. Skipping.");
                }
            }
            //Finished reading file.
            System.out.println("Done reading file: " + fileToRead.getName() + "\n\n");
        } catch (FileNotFoundException e) {
            System.err.println("File: " + fileToRead.getName() + " does not exist");
        }

        //Adding Battery/Power levels to products AFTER initialization
        for (SmartBulb bulb : orderBulb) {
            System.out.println("Please add a power level to your " + bulb.getManufacturer() + " bulb:");
            double power;
            if(userInputScanner.hasNextDouble()) {
                power = userInputScanner.nextDouble();
            }else{
                power = 0;
            }
            bulb.setPower(power);
        }
        for (SmartLock lock : orderLock) {
            System.out.println("Please add a battery level to your " + lock.getManufacturer() + " lock:");
            double battery;
            if(userInputScanner.hasNextDouble()) {
                battery = userInputScanner.nextDouble();
            }else{
                battery = 0;
            }
            lock.setBattery(battery);
        }
        userInputScanner.close();

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