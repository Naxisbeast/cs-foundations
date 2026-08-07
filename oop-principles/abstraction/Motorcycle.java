package abstraction;

public class Motorcycle extends Vehicle {
    private boolean hasCarrierBox;

    public Motorcycle(String brand, String model, boolean hasCarrierBox) {
        super(brand, model);
        this.hasCarrierBox = hasCarrierBox;
    }

    public boolean hasCarrierBox() {
        return hasCarrierBox;
    }

    public void setHasCarrierBox(boolean hasCarrierBox) {
        this.hasCarrierBox = hasCarrierBox;
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " " + getModel() + " starts with a handlebar ignition.");
    }

    @Override
    public void describeMovement() {
        System.out.println("A motorcycle moves on two wheels and is lighter than a car.");
    }

    @Override
    public String toString() {
        return "Motorcycle{brand='" + getBrand() + "', model='" + getModel()
                + "', hasCarrierBox=" + hasCarrierBox + "}";
    }
}
