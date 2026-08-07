public class SmartSpeaker extends SmartDevice {
    private String voiceAssistant;

    public SmartSpeaker(String brand, String model, int batteryLife, String voiceAssistant) {
        super(brand, model, batteryLife);
        this.voiceAssistant = voiceAssistant;
    }

    @Override
    public void activateFeature() {
        System.out.println("SmartSpeaker activated: Playing music via " + voiceAssistant + "...");
    }

    public String getVoiceAssistant() {
        return voiceAssistant;
    }

    public void setVoiceAssistant(String voiceAssistant) {
        this.voiceAssistant = voiceAssistant;
    }

    @Override
    public String toString() {
        return "SmartSpeaker [Brand=" + brand + ", Model=" + model + ", Battery Life=" + batteryLife +
                "h, Voice Assistant=" + voiceAssistant + "]";
    }
}
