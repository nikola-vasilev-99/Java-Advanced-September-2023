package Unit3_SetsAndMaps;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class SortingMaps_CheatSheet {

    public static void main(String[] args) {

        //Сортиране на map съгласно броя на оценките в List-а
        // key -> student name  value -> list with all theirs grades


        Map<String, List<Double>> studentsMap = new LinkedHashMap<>();

        studentsMap.put("Nikola", new ArrayList<>());
        studentsMap.get("Nikola").addAll(Arrays.asList(4.50, 4.45, 3.50, 5.56));

        studentsMap.put("Velin", new ArrayList<>());
        studentsMap.get("Velin").addAll(Arrays.asList(5.50, 4.40, 3.20, 5.70, 3.65, 6.00, 6.00));

        studentsMap.put("Simona", new ArrayList<>());
        studentsMap.get("Simona").addAll(Arrays.asList(3.65, 6.00, 6.00));

        //Сортиране във descending order -> ученик с най-голям брой оценки се подрежда
        // на първо място и запазването му в същия мап
        studentsMap = studentsMap.entrySet().stream().sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        // при първото сравняване s1 е Nikola, а s2 е Velin
        // sorted размества записи на база на цяло число, което се получава при сравнение
        // sorted > 0 -> разменя двата записа (s1 и s2)
        // sorted <= 0 -> не разменя записите

        System.out.println("descending order:");
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Double el: entry.getValue()) {
                System.out.print(el + " ");
            }
            System.out.println();
        }

        System.out.println("ascending order:");
        //Сортиране във ascending order -> ученик с най-малък брой оценки се подрежда
        // на първо място и запаззването му в същия мап

        studentsMap = studentsMap.entrySet().stream().sorted((s1, s2) -> s1.getValue().size() - s2.getValue().size())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        // при първото сравняване s1 е Nikola, а s2 е Velin
        // sorted размества записи на база на цяло число, което се получава при сравнение
        // sorted > 0 -> разменя двата записа (s1 и s2)
        // sorted <= 0 -> не разменя записите

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Double el: entry.getValue()) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
