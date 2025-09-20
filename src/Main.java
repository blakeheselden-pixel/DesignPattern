public class Main {
    static public void main(String[] args) {
        SmartDeviceFactory brandA = new FactoryBrandA();
        SmartBulb brandABulb = new SmartBulbA();

        SmartDeviceFactory brandB = new FactoryBrandB();
        SmartLock brandBLock = new SmartLockB();
    }
}
