package Unit6_DefiningClasses.LAB.EX2_CarConstructors;

public class Car2 {
    private String brand;
    private String model;
    private int horsePower;


    public Car2 (String brand) {
        this(brand, "unknown", -1);
    }

    public Car2 (String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }

    //най-големия конструктор. Ако трябва да правим промени ги пратим тук и ще се отразят и в другите конструктори
    public Car2 (String brand, String model, int horsePower) {
        setBrand(brand);
        setModel(model);
        setHorsePower(horsePower);
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }

}






