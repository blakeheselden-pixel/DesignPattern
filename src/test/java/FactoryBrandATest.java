import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryBrandATest {
    @Test
    void creatingSmartBulbAShouldNotReturnNull() {
        SmartDeviceFactory testFactoryBrandA = new FactoryBrandA();
        SmartBulb testSmartBulbA = testFactoryBrandA.createSmartBulb();
        assertNotNull(testSmartBulbA);
    }
    @Test
    void creatingSmartLockAShouldNotReturnNull() {
        SmartDeviceFactory testFactoryBrandA = new FactoryBrandA();
        SmartLock testSmartLockA = testFactoryBrandA.createSmartLock();
        assertNotNull(testSmartLockA);
    }
    @Test
    void createSmartBulbAShouldBeBrandA() {
        SmartDeviceFactory testFactoryBrandA = new FactoryBrandA();
        SmartBulb testSmartBulbA = testFactoryBrandA.createSmartBulb();
        assertEquals("Brand A", testSmartBulbA.getManufacturer());
    }
    @Test
    void createSmartLockAShouldBeBrandA() {
        SmartDeviceFactory testFactoryBrandA = new FactoryBrandA();
        SmartLock testSmartLockA = testFactoryBrandA.createSmartLock();
        assertEquals("Brand A", testSmartLockA.getManufacturer());
    }
}