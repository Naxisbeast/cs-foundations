package abstraction;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " " + getModel() + " starts with a key or start button.");
    }

    @Override
    public void describeMovement() {
        System.out.println("A car moves on four wheels and is useful for carrying passengers.");
    }

    @Override
    public String toString() {
        return "Car{brand='" + getBrand() + "', model='" + getModel()
                + "', numberOfDoors=" + numberOfDoors + "}";
    }
}
