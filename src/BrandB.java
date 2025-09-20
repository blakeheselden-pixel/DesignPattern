public class BrandB extends Company{
    @Override
    public SmartDeviceFactory createSmartDevice(String type){
        SmartDeviceFactory smartDeviceFactory = null;
        if("LOCK".equalsIgnoreCase(type)){
            smartDeviceFactory = new SmartLockB();
        }else{
            smartDeviceFactory = new SmartBulbB();
        }
        return smartDeviceFactory;
    }
}
