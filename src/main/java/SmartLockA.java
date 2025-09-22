public class SmartLockA implements SmartLock{

    private double battery = -1;

    @Override
    public void setBattery(double battery) {
        if (battery > 100) {
            this.battery = 100;
        } else if (battery < 0) {
            this.battery = 0;
        } else {
            this.battery = battery;
        }
    }

    @Override
    public double getBattery() {
        return this.battery;
    }

    @Override
    public String getManufacturer() {
        return "Brand A";
    }
}
