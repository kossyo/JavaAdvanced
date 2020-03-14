package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _10_ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] divisors = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        BiPredicate<Integer, Integer> biPredicate = (x,y) -> x % y != 0;

        for (int i = 1; i <= n; i++) {

            boolean divisibleByAll = true;

            for (int divisor : divisors) {

                if (biPredicate.test(i, divisor)) {
                    divisibleByAll = false;
                    break;
                }
            }
            if (divisibleByAll){
                System.out.print(i + " ");
            }
        }
    }
}
