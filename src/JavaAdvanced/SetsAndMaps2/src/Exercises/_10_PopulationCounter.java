package Exercises;

import java.util.*;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\|");

        while (!"report".equals(input[0])) {
            LinkedHashMap<String, Long> cityAndPopulation = new LinkedHashMap<>();

            String city = input[0];
            String country = input[1];
            long population = Long.parseLong(input[2]);


            if (!cityAndPopulation.containsKey(city)) {
                cityAndPopulation.put(city, population);
            } else {
                cityAndPopulation.put(city, cityAndPopulation.get(city) + population);
            }

            if (!data.containsKey(country)) {
                data.put(country, cityAndPopulation);
            } else {
                data.get(country).put(city, population);
            }

            input = scanner.nextLine().split("\\|");
        }


        data.entrySet()
                .stream().sorted((a, b) ->
                b.getValue().values().stream().reduce(0L, Long::sum).compareTo(
                                a.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country__city_population -> {
                            System.out.printf("%s (total population: %d)\n"
                                    , country__city_population.getKey(),
                                    country__city_population.getValue().values().stream().reduce(0L, Long::sum)
                            );

                            country__city_population.getValue().entrySet().stream()
                                    .sorted((city_pop1, city_pop2) ->
                                            city_pop2.getValue().compareTo(city_pop1.getValue())
                                    )
                                    .forEach(city_population -> System.out.printf("=>%s: %d\n",
                                            city_population.getKey(),
                                            city_population.getValue()));
                        }
                );


    }
}
