package Unit3_SetsAndMaps.EX;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EX5_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inf = scanner.nextLine();
        Map<String, String> phonebookMap = new HashMap<>();

        while (!inf.equals("search")) {
            String name = inf.split("-")[0];
            String number = inf.split("-")[1];
            phonebookMap.put(name, number);
            inf = scanner.nextLine();
        }

        inf = scanner.nextLine();
        while (!inf.equals("stop")) {
            if (phonebookMap.containsKey(inf)) {
                System.out.printf("%s -> %s%n", inf, phonebookMap.get(inf));
            } else {
                System.out.printf("Contact %s does not exist.%n", inf);
            }
            inf = scanner.nextLine();
        }

    }
}
