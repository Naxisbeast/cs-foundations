package abstraction;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Corolla", 4);
        Vehicle motorcycle = new Motorcycle("Honda", "CB125", true);

        Vehicle[] vehicles = {car, motorcycle};

        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
            vehicle.describeMovement();
            System.out.println(vehicle);
            System.out.println();
        }
    }
}
