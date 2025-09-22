import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentExamplesTest {

    @Test
    void demoBrandABulbAndBrandBLock() {
        // Example 1: Bulb from Brand A
        SmartBulb aBulb = new FactoryBrandA().createSmartBulb();
        assertNotNull(aBulb);
        assertInstanceOf(SmartBulbA.class, aBulb);
        assertEquals("Brand A", aBulb.getManufacturer());

        // Example 2: Lock from Brand B
        SmartLock bLock = new FactoryBrandB().createSmartLock();
        assertNotNull(bLock);
        assertInstanceOf(SmartLockB.class, bLock);
        assertEquals("Brand B", bLock.getManufacturer());

        //Example 2.1: Setting values of power and battery after instantiation
        aBulb.setPower(100);
        assertEquals(100, aBulb.getPower());
        bLock.setBattery(60);
        assertEquals(60, bLock.getBattery());
    }
}
