package Unit6_DefiningClasses.LAB.EX1_CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setHorsePower (int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String carInfo () {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(),this.getModel(), this.getHorsePower());
    }



@Override //чрез този овъррайд ние презаписваме базовия метод toString
    public String toString() {
        return String.format("The car is: %s %s - %d HP", this.getBrand(), this.getModel(), this.getHorsePower());
    }

}
