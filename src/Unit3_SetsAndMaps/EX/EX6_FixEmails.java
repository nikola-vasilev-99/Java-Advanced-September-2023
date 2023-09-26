package Unit3_SetsAndMaps.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX6_FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map <String, String> emailsMap = new LinkedHashMap<>();

        while(!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            String emailType = "";

            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
                emailsMap.put(name, email);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emailsMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
