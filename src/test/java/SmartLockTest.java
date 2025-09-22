import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartLockTest {

    @Test
    void smartLockA_isCorrectSubtypeAndBrand() {
        SmartLock lock = new FactoryBrandA().createSmartLock();
        assertInstanceOf(SmartLockA.class, lock);
        assertEquals("Brand A", lock.getManufacturer());
    }

    @Test
    void smartLockB_isCorrectSubtypeAndBrand() {
        SmartLock lock = new FactoryBrandB().createSmartLock();
        assertInstanceOf(SmartLockB.class, lock);
        assertEquals("Brand B", lock.getManufacturer());
    }

}
