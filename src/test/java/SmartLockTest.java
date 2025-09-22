import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartLockTest {

    @Test
    void smartLockAisCorrectSubtypeAndBrand() {
        SmartLock lock = new FactoryBrandA().createSmartLock();
        assertInstanceOf(SmartLockA.class, lock);
        assertEquals("Brand A", lock.getManufacturer());
    }

    @Test
    void smartLockBisCorrectSubtypeAndBrand() {
        SmartLock lock = new FactoryBrandB().createSmartLock();
        assertInstanceOf(SmartLockB.class, lock);
        assertEquals("Brand B", lock.getManufacturer());
    }

    @Test
    void smartLockAHasCorrectBatteryAfterSetting() {
        SmartLock lock = new FactoryBrandA().createSmartLock();
        lock.setBattery(50);
        assertEquals(50, lock.getBattery());
        lock.setBattery(150);
        assertEquals(100, lock.getBattery());
        lock.setBattery(-10);
        assertEquals(0, lock.getBattery());
    }

    @Test
    void smartLockBHasCorrectBatteryAfterSetting() {
        SmartLock lock = new FactoryBrandB().createSmartLock();
        lock.setBattery(50);
        assertEquals(50, lock.getBattery());
        lock.setBattery(150);
        assertEquals(100, lock.getBattery());
        lock.setBattery(-10);
        assertEquals(0, lock.getBattery());
    }
}
