package Unit6_DefiningClasses.EX.EX3_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelConsumptionPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.distanceTraveled = 0;
    }

    public boolean drive (int kmDrive) {
        double neededFuel = this.fuelConsumptionPerKm * kmDrive;
        if (neededFuel <= this.fuelAmount) {
            this.fuelAmount -= neededFuel;
            this.distanceTraveled += kmDrive;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
