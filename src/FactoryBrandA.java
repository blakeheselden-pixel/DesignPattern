public class FactoryBrandA implements SmartDeviceFactory {
    @Override
    public SmartBulb createSmartBulb(double power) {
        return new SmartBulbA();
    }
    @Override
    public SmartLock createSmartLock(double battery) {
        return new SmartLockA();
    }

}
