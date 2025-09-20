public class BrandA extends Company{
    @Override
    public SmartDeviceFactory createSmartDevice(String type){
        SmartDeviceFactory smartDeviceFactory = null;
        if("LOCK".equalsIgnoreCase(type)){
            smartDeviceFactory = new SmartLockA();
        }else{
            smartDeviceFactory = new SmartBulbA();
        }
        return smartDeviceFactory;
    }
}
