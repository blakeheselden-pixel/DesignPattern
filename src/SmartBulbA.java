public class SmartBulbA implements SmartBulb {
    @Override
    public void createSmartBulb(){ //Wondering about encapsulation, could it be protected?
        System.out.println("Created smart bulb from Brand A");
    }

    @Override
    public void setPower(double power){}
}
