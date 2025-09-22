import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartLockTest {

    @Test
    void smartLockA_isCorrectSubtypeAndBrand() {
        SmartLock lock = new FactoryBrandA().createSmartLock();
        assertTrue(lock instanceof SmartLockA);
        assertEquals("Brand A", lock.getManufacturer());
    }

    @Test
    void smartLockB_isCorrectSubtypeAndBrand() {
        SmartLock lock = new FactoryBrandB().createSmartLock();
        assertTrue(lock instanceof SmartLockB);
        assertEquals("Brand B", lock.getManufacturer());
    }

}
