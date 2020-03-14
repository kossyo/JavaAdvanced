package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _09_StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> data = new LinkedHashMap<>();
        String input;

        while (!"END".equals(input = reader.readLine())){

            String[] tokens = input.split(" ", 2);
            String number = tokens[0];
            String grades = tokens[1];

            data.put(number, grades);
        }

        data.entrySet().stream()
                .filter(kvp -> kvp.getKey().endsWith("14") || kvp.getKey().endsWith("15"))
                .forEach(x-> System.out.println(x.getValue()));
    }
}
