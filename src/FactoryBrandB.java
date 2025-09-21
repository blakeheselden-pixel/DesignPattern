public class FactoryBrandB implements SmartDeviceFactory {
    @Override
    public SmartBulb createSmartBulb(double power) {
        return new SmartBulbB();
    }
    @Override
    public SmartLock createSmartLock(double battery) {
        return new SmartLockB();
    }
}
