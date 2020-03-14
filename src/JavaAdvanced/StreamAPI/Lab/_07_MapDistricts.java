package StreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _07_MapDistricts {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        Map<String, List<Long>> map = new HashMap<>();
        long minimum = Long.parseLong(reader.readLine());

        input.forEach(town_population -> {

            String[] tokens = town_population.split(":");
            String town = tokens[0];
            Long currentPopulation = Long.parseLong(tokens[1]);

            if (!map.containsKey(town)) {
                List population = new ArrayList();
                population.add(currentPopulation);
                map.put(town, population);
            } else {
                map.get(town).add(currentPopulation);
            }
        });

        map.entrySet().stream().filter(kvp -> {

            Optional<Long> currentCitySum = kvp.getValue().stream().reduce(Long::sum);
            if (currentCitySum.isPresent() && currentCitySum.get() >= minimum) {
                return true;

            }
            return false;

        }).sorted((kvp1, kvp2) -> {

            long city1pop = kvp1.getValue().stream().mapToLong(Long::valueOf).sum();
            long city2pop = kvp2.getValue().stream().mapToLong(Long::valueOf).sum();

            return Long.compare(city2pop, city1pop);

        }).forEach(kvp -> {

            System.out.printf("%s: ", kvp.getKey());
            kvp.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(population -> System.out.print(population + " "));
            System.out.println();
        });
    }
}
