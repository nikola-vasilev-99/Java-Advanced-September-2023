package Unit6_DefiningClasses.EX.EX5_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // "{Model} {Power} ({Displacement} -> int) ({Efficiency} -> String)".
            // 1. {Model} {Power}
            // 2. {Model} {Power} ({Displacement} -> int)
            // 3. {Model} {Power} ({Efficiency} -> String)
            // 4. {Model} {Power} {Displacement} {Efficiency}

            String [] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficiency = null;

            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else if (Character.isLetter(engineData[2].charAt(0))) {
                    efficiency = engineData[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= m; i++) {
            // "{Model} ({Engine} -> from engine class) ({Weight} -> int) ({Color} -> String)"
             String [] carData = scanner.nextLine().split("\\s+");
             String carModel = carData[0];
             String engineModel = carData[1];
             int weight = 0;
             String color = null;
             if (carData.length == 4) {
                 weight = Integer.parseInt(carData[2]);
                 color = carData[3];
             } else if (carData.length == 3) {
                 if (Character.isLetter(carData[2].charAt(0))) {
                     color = carData[2];
                 } else if (Character.isDigit(carData[2].charAt(0))) {
                     weight = Integer.parseInt(carData[2]);
                 }
             }

             Engine currentEngineInf = null;
             for (Engine engine: enginesList) {
                 if (engineModel.equals(engine.getModel())) {
                     currentEngineInf = engine;
                     break;
                 }
             }
             Car currentCar = new Car(carModel, currentEngineInf, weight, color);
            System.out.print(currentCar.toString());
        }
    }
}
