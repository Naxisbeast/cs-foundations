public class SmartWatch extends SmartDevice {
    private boolean heartRateSensor;

    public SmartWatch(String brand, String model, int batteryLife, boolean heartRateSensor) {
        super(brand, model, batteryLife);
        this.heartRateSensor = heartRateSensor;
    }

    @Override
    public void activateFeature() {
        System.out.println("SmartWatch activated: Tracking steps and heart rate...");
    }

    public boolean hasHeartRateSensor() {
        return heartRateSensor;
    }

    public void setHeartRateSensor(boolean heartRateSensor) {
        this.heartRateSensor = heartRateSensor;
    }

    @Override
    public String toString() {
        return "SmartWatch [Brand=" + brand + ", Model=" + model + ", Battery Life=" + batteryLife +
                "h, Heart Rate Sensor=" + heartRateSensor + "]";
    }
}
