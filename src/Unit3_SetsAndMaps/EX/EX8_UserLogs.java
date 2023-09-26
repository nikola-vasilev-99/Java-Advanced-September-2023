package Unit3_SetsAndMaps.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EX8_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        TreeMap <String, LinkedHashMap<String, Integer>> userlogsMap = new TreeMap<>();

        while (!input.equals("end")) {
            String ipAddress = (input.split(" ")[0]).split("=")[1];
            String user = (input.split(" ")[2]).split("=")[1];
            if (!userlogsMap.containsKey(user)) {
                userlogsMap.put(user, new LinkedHashMap<>());
                userlogsMap.get(user).put(ipAddress, 1);
            } else if (!userlogsMap.get(user).containsKey(ipAddress)) {
                userlogsMap.get(user).put(ipAddress, 1);
            } else {
                int currentMessages = userlogsMap.get(user).get(ipAddress);
                userlogsMap.get(user).put(ipAddress, currentMessages + 1);
            }
            input = scanner.nextLine();
        }

        for (String username: userlogsMap.keySet()) {
            System.out.println(username + ": ");

            Map <String, Integer> nestedMap = userlogsMap.get(username);
            int countIps = nestedMap.size();
            for (String ip: nestedMap.keySet()) {
                if (countIps == 1) {
                    System.out.print(ip + " => " + nestedMap.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + nestedMap.get(ip) + ", ");
                }
                countIps--;
            }
            System.out.println();
        }
    }
}
