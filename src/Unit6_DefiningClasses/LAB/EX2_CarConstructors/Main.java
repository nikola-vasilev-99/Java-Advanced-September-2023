package Unit6_DefiningClasses.LAB.EX2_CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car2> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String [] arr = scanner.nextLine().split(" ");
            String brand = arr[0];
            Car2 car;
            if (arr.length == 1) {
                //имаме само brand
                car = new Car2(brand);
            } else {
                //имаме всички елементи
                String model = arr[1];
                int horsePower = Integer.parseInt(arr[2]);
                car = new Car2(brand, model, horsePower);
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);

    }
}
