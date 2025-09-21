public class FactoryBrandB implements SmartDeviceFactory {
    @Override
    public SmartBulb createSmartBulb() {
        return new SmartBulbB();
    }
    @Override
    public SmartLock createSmartLock() {
        return new SmartLockB();
    }
}
