package Unit3_SetsAndMaps.EX;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EX1_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> usernameSet = new LinkedHashSet<>();

        while (n-- > 0) {
            String username = scanner.nextLine();
            usernameSet.add(username);
        }

        for (String element: usernameSet) {
            System.out.println(element);
        }
    }
}
