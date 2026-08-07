public abstract class SmartDevice implements Comparable<SmartDevice> {
    protected String brand;
    protected String model;
    protected int batteryLife;

    public SmartDevice(String brand, String model, int batteryLife) {
        this.brand = brand;
        this.model = model;
        this.batteryLife = batteryLife;
    }

    public abstract void activateFeature();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return "SmartDevice [Brand=" + brand + ", Model=" + model + ", Battery Life=" + batteryLife + "h]";
    }

    @Override
    public int compareTo(SmartDevice other) {
        return Integer.compare(this.batteryLife, other.batteryLife);
    }
}
