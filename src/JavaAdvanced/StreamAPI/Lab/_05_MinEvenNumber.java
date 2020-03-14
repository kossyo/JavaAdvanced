package StreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class _05_MinEvenNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<Double> numbers = new ArrayList<>();

        if (!"".equals(input)) {
            numbers = Arrays.stream(input.split("\\s+"))
                    .filter(x -> !"".equals(x))
                    .map(Double::parseDouble).collect(Collectors.toList());
        }

        OptionalDouble result = numbers.stream().filter(x -> x % 2 == 0)
                .mapToDouble(Double::valueOf).min();


        if (result.isPresent())
            System.out.printf("%.2f", result.getAsDouble());
        else
            System.out.println("No match");

    }
}
