package Unit6_DefiningClasses.EX.EX5_CarSalesman;

public class Car {
    private String model;
    private Engine engineInf;
    private int weight;
    private String color;

    public Car (String model, Engine engineInf, int weight, String color) {
        this.model = model;
        this.engineInf = engineInf;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //""

        sb.append(this.model).append(":").append(System.lineSeparator()); //модел на колата
        sb.append(this.engineInf.getModel()).append(":").append(System.lineSeparator()); //модел на двигателя на колата
        sb.append("Power: ").append(this.engineInf.getPower()).append(System.lineSeparator());

        //Displacement: {EngineDisplacement}
        sb.append("Displacement: ");
        //нямаме = 0; имаме = цяло число
        if (this.engineInf.getDisplacement() == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engineInf.getDisplacement()).append(System.lineSeparator());
        }

        //Efficiency: {EngineEfficiency}
        sb.append("Efficiency: ");
        //нямаме = null; имаме = текст
        if (this.engineInf.getEfficiency() == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.engineInf.getEfficiency()).append(System.lineSeparator());
        }

        //Weight: {CarWeight}
        sb.append("Weight: ");
        //нямаме = 0; имаме = цяло число
        if (this.weight == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.weight).append(System.lineSeparator());
        }

        //Color: {CarColor}"
        sb.append("Color: ");
        //нямаме = null; имаме = текст
        if (this.color == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.color).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
