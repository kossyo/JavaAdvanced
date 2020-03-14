package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _13_OfficeStuff {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Map<String, Long>> map = new HashMap<>();

        while (n-- > 0) {

            String line = reader.readLine().replace("|", "");
            String[] tokens = line.split(" - ");
            String company = tokens[0];
            long amount = Long.parseLong(tokens[1]);
            String product = tokens[2];

            if (!map.containsKey(company)) {
                Map<String, Long> innerMap = new LinkedHashMap<>();
                innerMap.put(product, amount);
                map.put(company, innerMap);
            } else {
                if (!map.get(company).containsKey(product)) {
                    map.get(company).put(product, amount);
                } else {

                    map.get(company).put(product, map.get(company).get(product) + amount);
                }
            }
        }

        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(kvp -> {

                    System.out.printf("%s: ", kvp.getKey());
                    System.out.println(kvp.getValue().entrySet().stream()
                            .map(innerKvp -> String.format("%s-%d", innerKvp.getKey(), innerKvp.getValue()))
                            .collect(Collectors.joining(", ")));

                });
    }
}