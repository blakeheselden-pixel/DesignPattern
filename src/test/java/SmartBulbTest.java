import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartBulbTest {

    @Test
    void smartBulbA_isCorrectSubtypeAndBrand() {
        SmartBulb bulb = new FactoryBrandA().createSmartBulb();
        assertInstanceOf(SmartBulbA.class, bulb);
        assertEquals("Brand A", bulb.getManufacturer());
    }

    @Test
    void smartBulbB_isCorrectSubtypeAndBrand() {
        SmartBulb bulb = new FactoryBrandB().createSmartBulb();
        assertInstanceOf(SmartBulbB.class, bulb);
        assertEquals("Brand B", bulb.getManufacturer());
    }

}