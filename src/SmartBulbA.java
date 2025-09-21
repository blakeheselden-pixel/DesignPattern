public class SmartBulbA implements SmartBulb {

    private double power;

    @Override
    public void setPower(double power) {
        if (power > 1000) {
            this.power = 1000;
        } else if (power < 0) {
            this.power = 0;
        } else {
            this.power = power;
        }
    }

    @Override
    public double getPower() {
        return this.power;
    }

    @Override
    public String getManufacturer() {
        return "Brand A";
    }
}
