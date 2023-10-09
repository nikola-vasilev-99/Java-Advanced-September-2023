package Unit6_DefiningClasses.EX.EX3_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String [] arr = scanner.nextLine().split("\\s+");
            String model = arr[0];
            double fuelAmount = Double.parseDouble(arr[1]);
            double fuelCostPerKm = Double.parseDouble(arr[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);

            carsMap.put(model, car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String [] commandArr = input.split("\\s+");
            String  modelToDrive = commandArr[1];
            int amountOfKmToDrive = Integer.parseInt(commandArr[2]);
            Car currentCar = carsMap.get(modelToDrive);

            // програмата влиза в метода, извършва операциите вътре в него и връща true, или false.
            // Ако е true -> тя ще е извършила всички необходими действия по обекта Car
            if (!currentCar.drive(amountOfKmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        for (Car car: carsMap.values()) {
            System.out.println(car);
        }
    }
}
