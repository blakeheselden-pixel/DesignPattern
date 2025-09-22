import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartBulbTest {

    @Test
    void smartBulbAisCorrectSubtypeAndBrand() {
        SmartBulb bulb = new FactoryBrandA().createSmartBulb();
        assertInstanceOf(SmartBulbA.class, bulb);
        assertEquals("Brand A", bulb.getManufacturer());
    }

    @Test
    void smartBulbBisCorrectSubtypeAndBrand() {
        SmartBulb bulb = new FactoryBrandB().createSmartBulb();
        assertInstanceOf(SmartBulbB.class, bulb);
        assertEquals("Brand B", bulb.getManufacturer());
    }

    @Test
    void smartBulbAHasCorrectPowerAfterSetting(){
        SmartBulb bulb = new FactoryBrandA().createSmartBulb();
        bulb.setPower(100);
        assertEquals(100, bulb.getPower());
        bulb.setPower(1500);
        assertEquals(1000, bulb.getPower());
        bulb.setPower(-10);
        assertEquals(0, bulb.getPower());
    }

    @Test
    void smartBulbBHasCorrectPowerAfterSetting(){
        SmartBulb bulb = new FactoryBrandB().createSmartBulb();
        bulb.setPower(100);
        assertEquals(100, bulb.getPower());
        bulb.setPower(1500);
        assertEquals(1000, bulb.getPower());
        bulb.setPower(-10);
        assertEquals(0, bulb.getPower());
    }
}