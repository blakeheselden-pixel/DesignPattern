public class Main {
    static public void main(String[] args) {
        Company brandA = new FactoryBrandA();
        SmartDeviceFactory smartLockA = new SmartLockA();
        Company brandB = new FactoryBrandB();
        SmartDeviceFactory smartLockB = new SmartLockB();
    }
}
