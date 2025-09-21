public class SmartLockA implements SmartLock{
    @Override
    public void createSmartLock(){
        System.out.println("Created smart lock from Brand A");
    }

    @Override
    public void setBattery(double battery) {}
}
