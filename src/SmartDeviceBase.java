public abstract class SmartDeviceBase implements SmartDevice {
    protected final String brand;  
    protected final String type;    
    protected double usage;

    protected SmartDeviceBase(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    protected abstract UsageReader createUsageReader();

    @Override
    public void loadUsage() {
        this.usage = createUsageReader().readUsage(brand, type);
    }

    @Override public void setUsage(double usage) { this.usage = usage; }
    @Override public double getUsage() { return usage; }

    @Override
    public String info() {
        String metric = type.equals("Bulb") ? "W (power)" : "mA (battery)";
        return String.format("Brand %s %s → usage: %.2f %s", brand, type, usage, metric);
    }
}
