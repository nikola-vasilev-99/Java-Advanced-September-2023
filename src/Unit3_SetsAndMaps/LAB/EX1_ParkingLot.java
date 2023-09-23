package Unit3_SetsAndMaps.LAB;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EX1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set <String> set = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String [] tokens = input.split(", ");
            String direction = tokens[0];
            String registration = tokens[1];

            if (direction.equals("IN")) {
                set.add(registration);
            } else {
                set.remove(registration);
            }
            input = scanner.nextLine();
        }

        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String element: set) {
                System.out.println(element);
            }
        }

    }
}
