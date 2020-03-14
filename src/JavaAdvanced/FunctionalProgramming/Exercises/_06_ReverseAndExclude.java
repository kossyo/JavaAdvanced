package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_ReverseAndExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int parameter = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        numbers.removeIf(getPredicate(parameter));
        numbers.forEach(x -> System.out.print(x + " "));
    }
    private static Predicate<Integer> getPredicate(int parameter){

       return x -> x % parameter == 0;
    }
}
