import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryBrandBTest {
    @Test
    void creatingSmartBulbBShouldNotReturnNull() {
        SmartDeviceFactory testFactoryBrandB = new FactoryBrandB();
        SmartBulb testSmartBulbB = testFactoryBrandB.createSmartBulb();
        assertNotNull(testSmartBulbB);
    }
    @Test
    void creatingSmartLockBShouldNotReturnNull() {
        SmartDeviceFactory testFactoryBrandB = new FactoryBrandB();
        SmartLock testSmartLockB = testFactoryBrandB.createSmartLock();
        assertNotNull(testSmartLockB);
    }
    @Test
    void createSmartBulbBShouldBeBrandB() {
        SmartDeviceFactory testFactoryBrandB = new FactoryBrandB();
        SmartBulb testSmartBulbB = testFactoryBrandB.createSmartBulb();
        assertEquals("Brand B", testSmartBulbB.getManufacturer());
    }
    @Test
    void createSmartLockBShouldBeBrandB() {
        SmartDeviceFactory testFactoryBrandB = new FactoryBrandB();
        SmartLock testSmartLockB = testFactoryBrandB.createSmartLock();
        assertEquals("Brand B", testSmartLockB.getManufacturer());
    }
}

