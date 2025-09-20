public class FactoryBrandA implements SmartDeviceFactory {
    @Override
    public SmartBulb createSmartBulb() {
        return new SmartBulbA();
    }
    @Override
    public SmartLock createSmartLock() {
        return new SmartLockA();
    }
}
