public class Main {
    static public void main(String[] args) {

        //Instantiate brand factories to allow usage of its methods
        SmartDeviceFactory factoryBrandA = new FactoryBrandA();

        //Use methods from instantiated factory to create product
        SmartBulb brandABulb = factoryBrandA.createSmartBulb();

        //Set value of power of a bulb from BrandA
        brandABulb.setPower(15);

        //Instantiate brand factories to create product with values
        SmartDeviceFactory factoryBrandB = new FactoryBrandB();
        SmartLock brandBLock = factoryBrandB.createSmartLock();
        brandBLock.setBattery(12);
    }
}
