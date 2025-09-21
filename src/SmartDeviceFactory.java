interface SmartDeviceFactory{
    SmartBulb createSmartBulb(double power);

    SmartLock createSmartLock(double battery);
}