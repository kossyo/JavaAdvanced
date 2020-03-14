package FunctionalProgramming.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class SortOuterMapByInner {
    public static void main(String[] args) {

        Map<String, Map<String, Double>> map = new LinkedHashMap<>();
        Map<String, Double> inner = new LinkedHashMap<>();
        inner.put("Sofia", 300d);
        inner.put("Varna", 600d);
        inner.put("Burgas", 900d);

        map.put("Bulgaria", inner);//600
        inner = new LinkedHashMap<>();

        inner.put("Beograd", 500d);
        inner.put("Pozarevac", 550d);
        inner.put("Cacak", 25d);
        inner.put("Krusevac", 925d);

        map.put("Srbija", inner);//500
        inner = new LinkedHashMap<>();

        inner.put("Rotterdam", 300d);
        inner.put("Utrecht", 400d);
        inner.put("Den Haag", 500d);

        map.put("Nederland", inner);//400


        map.entrySet().stream().sorted((x, y) -> {

            OptionalDouble avgXoptional = x.getValue().values().stream().mapToDouble(Double::valueOf).average();
            OptionalDouble avgYoptional = y.getValue().values().stream().mapToDouble(Double::valueOf).average();

            if (avgXoptional.isPresent() && avgYoptional.isPresent())
                return (int) (avgYoptional.getAsDouble() - avgXoptional.getAsDouble());
            else
                return 0;


        }).forEach(country -> {

            OptionalDouble avgXoptional = country.getValue().values().stream().mapToDouble(Double::valueOf).average();

            double avg = (avgXoptional.isPresent()) ? avgXoptional.getAsDouble() : 0;

            System.out.println("Country " + country.getKey()+ " " + (int)avg);
        });
    }
}

