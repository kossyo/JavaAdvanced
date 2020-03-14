package Exercises;


import java.util.*;

public class _11_LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountOfLogs = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> logs = new TreeMap<>();

        for (int i = 0; i < amountOfLogs; i++) {
            String user = input[1];
            String ip = input[0];
            long duration = Integer.parseInt(input[2]);

            if (!logs.containsKey(user)) {
                LinkedHashMap<String, Long> currentMap = new LinkedHashMap<>();
                currentMap.put(ip, duration);
                logs.put(user, currentMap);
            } else {
                //if (!logs[user].ContainsKey(ip))
                if (!logs.get(user).containsKey(ip)) {
                    //logs[user][ip] = duration;
                    logs.get(user).put(ip, duration);
                } else {
                    ////logs[user][ip] += duration;
                    logs.get(user).put(ip, logs.get(user).get(ip) + duration);
                }
            }
            input = scanner.nextLine().split(" ");
        }


        for (Map.Entry<String, LinkedHashMap<String, Long>> log : logs.entrySet()) {

            Set<String> ips = new TreeSet(log.getValue().keySet());


            System.out.printf("%s: %d %s\n",
                    log.getKey(),
                    log.getValue().values().stream().reduce(0L, Long::sum),
                    ips
            );



        }
//        logs.entrySet()
//                .forEach(log -> {
//                    Set<String> ips = new TreeSet(log.getValue().keySet());
//
//
//                    System.out.printf("%s: %d %s\n",
//                            log.getKey(),
//                            log.getValue().values().stream().reduce(0L, Long::sum),
//                            ips
//                            );
//
//
//                });
//        System.out.println();
    }
}
