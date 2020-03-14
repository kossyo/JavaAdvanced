package StreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _06_FindAndSumIntegers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .filter(x -> {

                    try {
                        Integer.parseInt(x);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(Integer::valueOf).collect(Collectors.toList());

        Optional<Integer> result = numbers.stream().reduce((x, y) -> x + y);

        if (result.isPresent())
            System.out.println(result.get());
        else
            System.out.println("No match");
    }
}
