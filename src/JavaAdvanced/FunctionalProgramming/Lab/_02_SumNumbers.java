package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class _02_SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.asList(scanner.nextLine().split(", "));

        System.out.println("Count = "+numbers.size());

        Function<String, Integer> parser = x -> Integer.parseInt(x);
        int sum = 0;

        for(String s : numbers){
            sum += parser.apply(s);
        }


        System.out.println("Sum = "+sum);

    }
}
