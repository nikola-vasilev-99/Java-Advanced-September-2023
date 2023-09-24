package Unit3_SetsAndMaps.LAB;

import java.util.*;

public class EX5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap <String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] inputArr = scanner.nextLine().split(" ");
            String name = inputArr[0];
            double grade = Double.parseDouble(inputArr[1]);

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
                studentsMap.get(name).add(grade);
            } else {
                studentsMap.get(name).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double sumGrades = 0;
            for (double el: entry.getValue()) {
                sumGrades += el;
                System.out.printf("%.2f ", el);
            }
            double avg = sumGrades / entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", avg);
        }
    }
}
