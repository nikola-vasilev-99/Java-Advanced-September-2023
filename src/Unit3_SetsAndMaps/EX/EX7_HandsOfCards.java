package Unit3_SetsAndMaps.EX;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class EX7_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, LinkedHashSet<String>> playersMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while(!input.equals("JOKER")) {
            input = input.replaceAll(",", "");
            String name = input.split(":")[0];
            String [] cardsArr = (input.split(": ")[1]).replaceAll(",", "").split("\\s+");

            if (!playersMap.containsKey(name)) {
                playersMap.put(name, new LinkedHashSet<>());
            }

            for (int i = 0; i < cardsArr.length ;i++) {
                playersMap.get(name).add(cardsArr[i]);
            }

            input = scanner.nextLine();
        }
        Map <String, Integer> resultMap = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashSet<String>> entry : playersMap.entrySet()) {
            int totalValue = 0;
            for (String currentCard: entry.getValue()) {
                totalValue += getTypeValue(currentCard) * getPowerNum(currentCard);
            }
            resultMap.put(entry.getKey(), totalValue);
        }

        for (Map.Entry <String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + " " + entry.getValue());
        }
    }
    private static int getTypeValue (String card) {
        char type = card.charAt(card.length() - 1);
        int typeNum = 0;
        if (type == 'S') {
            typeNum = 4;
        } else if (type == 'H') {
            typeNum = 3;
        } else if (type == 'D') {
            typeNum = 2;
        } else if (type == 'C') {
            typeNum = 1;
        }
        return typeNum;
    }
    private static int getPowerNum (String card) {
        String power = card.substring(0, card.length() - 1);
        int powerNum = 0;
        if (power.equals("J")) {
            powerNum = 11;
        }else if (power.equals("Q")) {
            powerNum = 12;
        } else if (power.equals("K")) {
            powerNum = 13;
        } else if (power.equals("A")) {
            powerNum = 14;
        } else {
            powerNum = Integer.parseInt(power);
        }
        return powerNum;
    }
}
