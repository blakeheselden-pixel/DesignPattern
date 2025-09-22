import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentExamplesTest {

    @Test
    void demo_brandABulb_and_brandBLock() {
        // Example 1: Bulb from Brand A
        SmartBulb aBulb = new FactoryBrandA().createSmartBulb(); // or createBulb()
        assertNotNull(aBulb);
        assertTrue(aBulb instanceof SmartBulbA);
        assertEquals("Brand A", aBulb.getManufacturer());

        // Example 2: Lock from Brand B
        SmartLock bLock = new FactoryBrandB().createSmartLock(); // or createLock()
        assertNotNull(bLock);
        assertTrue(bLock instanceof SmartLockB);
        assertEquals("Brand B", bLock.getManufacturer());
    }
}
