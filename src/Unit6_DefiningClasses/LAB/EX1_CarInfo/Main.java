package Unit6_DefiningClasses.LAB.EX1_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String [] arr = scanner.nextLine().split(" ");
            String carName = arr[0];
            String model = arr[1];
            int hp = Integer.parseInt(arr[2]);
            Car car = new Car();
            car.setBrand(carName);
            car.setModel(model);
            car.setHorsePower(hp);
            System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsePower());
        }
    }
}
