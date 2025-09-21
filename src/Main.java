public class Main {
    static public void main(String[] args) {
        //Instantiate brand factories to allow usage of its methods
        SmartDeviceFactory factoryBrandA = new FactoryBrandA();

        //Use methods from instantiated factory to create product
        SmartBulb brandABulb = factoryBrandA.createSmartBulb(2.1);

        //Instantiate brand factories to create product
        SmartDeviceFactory factoryBrandB = new FactoryBrandB();
        SmartLock brandBLock = factoryBrandB.createSmartLock(1);
    }
}
