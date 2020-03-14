package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _05_AppliedArithmetics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command;

        while (!(command = scanner.nextLine()).equals("end")) {

            if ("print".equals(command)) {
                numbers.forEach(x -> System.out.print(x + " "));
                System.out.println();
            }
            else {
                numbers = numbers.stream().map(getFunction(command)).collect(Collectors.toList());
            }
        }
    }

    private static Function<Integer, Integer> getFunction(String command) {

        switch (command) {
            case "add":
                return number -> number + 1;
            case "multiply":
                return number -> number * 2;
            case "subtract":
                return number -> number - 1;
        }
        return null;
    }
}
