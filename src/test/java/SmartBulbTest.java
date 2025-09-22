import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartBulbTest {

    @Test
    void smartBulbA_isCorrectSubtypeAndBrand() {
        SmartBulb bulb = new FactoryBrandA().createSmartBulb();
        assertTrue(bulb instanceof SmartBulbA);
        assertEquals("Brand A", bulb.getManufacturer());
    }

    @Test
    void smartBulbB_isCorrectSubtypeAndBrand() {
        SmartBulb bulb = new FactoryBrandB().createSmartBulb();
        assertTrue(bulb instanceof SmartBulbB);
        assertEquals("Brand B", bulb.getManufacturer());
    }

}