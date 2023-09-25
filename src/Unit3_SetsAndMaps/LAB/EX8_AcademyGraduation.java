package Unit3_SetsAndMaps.LAB;

import java.util.*;

public class EX8_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, double []> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double [] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            map.put(name, grades);
        }
        for (Map.Entry<String, double[]> entry : map.entrySet()) {
        double gradesSum = 0;
        double [] currentArr = entry.getValue();
            for (int i = 0; i < currentArr.length; i++) {
                gradesSum += currentArr[i];
            }
            double averageGrade = gradesSum / currentArr.length;
            System.out.println(entry.getKey() + " is graduated with " + averageGrade);
        }
    }
}
