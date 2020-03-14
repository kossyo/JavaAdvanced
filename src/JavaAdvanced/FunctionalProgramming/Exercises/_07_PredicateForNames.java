package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _07_PredicateForNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int border = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        names.removeIf(getPredicate(border));
        names.forEach(System.out::println);
    }

    private static Predicate<String> getPredicate(int border){

        return x -> x.length() > border;
    }
}
