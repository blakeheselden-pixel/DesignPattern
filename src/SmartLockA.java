public class SmartLockA implements SmartLock{

    private double battery;

    @Override
    public void setBattery(double battery) {
        this.battery = battery;
    }

    @Override
    public double getBattery() {
        return this.battery;
    }
}
