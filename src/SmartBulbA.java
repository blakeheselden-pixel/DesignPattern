public class SmartBulbA implements SmartBulb {

    private double power;

    @Override
    public void setPower(double power){
        this.power = power;
    }

    @Override
    public double getPower(){
        return this.power;
    }
}
