package Unit6_DefiningClasses.EX.EX1_OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, Person> map = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            String currentName = data[0];
            int currentAge = Integer.parseInt(data[1]);
            if (currentAge > 30) {
                Person person = new Person(currentName, currentAge);
                map.put(currentName, person);
            }
        }
        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
