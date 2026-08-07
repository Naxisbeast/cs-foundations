public class SmartDeviceTest {
    public static void main(String[] args) {

        SmartDevice device1 = new SmartWatch("FitBit", "Versa 3", 72, true);
        SmartDevice device2 = new SmartSpeaker("Amazon", "Echo Dot", 48, "Alexa");

        device1.activateFeature();
        device2.activateFeature();

        System.out.println(device1.toString());

        System.out.println(device2);

        device1.setBatteryLife(80);
        System.out.println("Updated Battery Life (device1): " + device1.getBatteryLife());
    }
}
