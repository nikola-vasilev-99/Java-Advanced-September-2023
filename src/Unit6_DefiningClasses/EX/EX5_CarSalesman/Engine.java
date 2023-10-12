package Unit6_DefiningClasses.EX.EX5_CarSalesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;   // optional
    private String efficiency;  // optional

    // {Model} {Power} {Displacement} {Efficiency}
    public Engine (String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
