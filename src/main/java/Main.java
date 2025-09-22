import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    //For storing the user's items.
    private static final ArrayList<SmartBulb> orderBulb = new ArrayList<>();
    private static final ArrayList<SmartLock> orderLock = new ArrayList<>();

    //Initializing factories.
    private static final SmartDeviceFactory factoryBrandA = new FactoryBrandA();
    private static final SmartDeviceFactory factoryBrandB = new FactoryBrandB();

    private static void orderAssembler(String itemBrand, String itemType) {
        if (itemType.equalsIgnoreCase("BULB")) {
            SmartBulb bulb;
            if (itemBrand.equalsIgnoreCase("BRANDA")) {
                bulb = factoryBrandA.createSmartBulb();
            } else {
                bulb = factoryBrandB.createSmartBulb();
            }
            orderBulb.add(bulb);
        } else if (itemType.equalsIgnoreCase("LOCK")) {
            SmartLock lock;
            if (itemBrand.equalsIgnoreCase("BRANDA")) {
                lock = factoryBrandA.createSmartLock();
            } else {
                lock = factoryBrandB.createSmartLock();
            }
            orderLock.add(lock);
        }
    }

    public static void main(String[] args) {

        Scanner userFileScanner = new Scanner(System.in);
        Scanner userInputScanner = new Scanner(System.in);
        String brandName, smartItemType, flag;
        File fileToRead;

        ArrayList<Character> bulbOrLock = new ArrayList<>();
        ArrayList<Double> valuesPowerBattery = new ArrayList<>();

        //Ensure correct user input of item and brand through continuous prompting.
        do {
            do {
                System.out.println("\nPlease enter the name of the brand you want the item from (BRANDA or BRANDB): ");
                brandName = userInputScanner.nextLine();

                if (brandName.equalsIgnoreCase("BRANDA") || brandName.equalsIgnoreCase("BRANDB")) {
                    System.out.println("You have chosen: " + brandName);
                } else {
                    System.out.println("The brand you have chosen does not exist. Please try again.");
                }
            } while (!(brandName.equalsIgnoreCase("BRANDA") || brandName.equalsIgnoreCase("BRANDB")));

            do {
                System.out.println("Please enter the item type of the item (BULB or LOCK): ");
                smartItemType = userInputScanner.nextLine();
                if (smartItemType.equalsIgnoreCase("BULB")) {
                    bulbOrLock.add('B');
                    System.out.println("You have chosen: Bulb");
                } else if (smartItemType.equalsIgnoreCase("LOCK")){
                    bulbOrLock.add('L');
                    System.out.println("You have chosen: Lock");
                }else {
                    System.out.println("The item type you have chosen does not exist. Please try again.");
                }
            } while (!(smartItemType.equalsIgnoreCase("BULB") || smartItemType.equalsIgnoreCase("LOCK")));

            orderAssembler(brandName, smartItemType);
            System.out.print("If you wish to end your powerandbattery of items, type q. Hit any key+enter to continue");
            flag = userInputScanner.nextLine();

        } while (!flag.equalsIgnoreCase("q"));

        //Ensure correct user input of file name through continuous prompting.
        do {
            System.out.println("\nPlease enter the name of the file you want to read(This file will give your items" +
                    "their power or battery values): ");
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
                //Reading Power/Battery
                String line = fileScanner.nextLine();
                double level;
                //Catch any non-double
                try {
                    level = Double.parseDouble(line);
                } catch (NumberFormatException e) {
                    level = -1;
                }
                if (level <= 1000 || level > 0) {
                    valuesPowerBattery.add(level);
                } else {
                    System.out.println("Invalid line. Skipping.");
                }
            }
            //Finished reading file.
            System.out.println("Done reading file: " + fileToRead.getName() + "\n\n");
        } catch (FileNotFoundException e) {
            System.err.println("File: " + fileToRead.getName() + " does not exist");
        }

        //Sets the power or battery of the bulb or lock.
        int iBulb = 0;
        int jLock = 0;
        while ((iBulb+jLock) < valuesPowerBattery.size() && (iBulb+jLock) < bulbOrLock.size()) {
            if((bulbOrLock.get(iBulb).equals('B'))) {
                orderBulb.get(iBulb).setPower(valuesPowerBattery.get(iBulb+jLock));
                iBulb++;
            }else{
                orderLock.get(jLock).setBattery(valuesPowerBattery.get(iBulb+jLock));
                jLock++;
            }
        }

        //Printing both lists of Bulbs and Locks
        int i = 1, j = 1;
        System.out.println("\n\nPrinting all smart bulbs:");
        for (SmartBulb bulb : orderBulb) {
            if(bulb.getPower() == -1){
                System.out.println("Power level of bulb " + i + " from " + bulb.getManufacturer() +
                        ": Uninitialized. " + "Try adding more values to your data file.");
            }else {
                System.out.println("Power level of bulb " + i + " from " + bulb.getManufacturer()
                        + ": " + bulb.getPower() + "W");
            }
            i++;
        }
        System.out.println("\nPrinting all smart locks:");
        for (SmartLock lock : orderLock) {
            if(lock.getBattery() == -1){
                System.out.println("Power level of lock " + j + " from " + lock.getManufacturer() +
                        ": Uninitialized. " + "Try adding more values to your data file.");
            }else {
                System.out.println("Battery level of lock " + j + " from " + lock.getManufacturer()
                        + ": " + lock.getBattery() + "%");
            }
            j++;
        }
    }
}