package Exercises;

import java.util.*;

public class _09_UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
        String[] input = scanner.nextLine().split(" ");
        String ip;
        String user;

        while (!"end".equals(input[0])) {
            ip = input[0].replace("IP=", "");
            user = input[2].replace("user=", "");

            if (!logs.containsKey(user)) {

                LinkedHashMap<String, Integer> currentDict = new LinkedHashMap<>();
                currentDict.put(ip, 1);
                logs.put(user, currentDict);

            } else {

                if (!logs.get(user).containsKey(ip)) {

                    logs.get(user).put(ip, 1);

                } else {

                    logs.get(user).put(ip, logs.get(user).get(ip) + 1);
                }
            }
            input = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> logPair : logs.entrySet()) {

            System.out.printf("%s: \n", logPair.getKey());
            List<String> helper = new LinkedList<>();

            for (Map.Entry<String, Integer> ipAndCountPair : logPair.getValue().entrySet()) {

                String string = String.format("%s => %d", ipAndCountPair.getKey(), ipAndCountPair.getValue());
                helper.add(string);
            }

            String joined = String.join(", ", helper) + ".";

            System.out.println(joined);
        }
    }
}
