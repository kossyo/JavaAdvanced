package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _04_FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String evenOrOdd = scanner.nextLine();

        Predicate<String> testEvenOrOdd = "even"::equals;
        print(testEvenOrOdd, evenOrOdd, bounds);
    }

    private static void print(Predicate<String> testEvenOrOdd, String evenOrOdd, int[] bounds) {

        if (testEvenOrOdd.test(evenOrOdd)) {

            for (int i = bounds[0]; i <= bounds[1]; i++) {

                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            for (int i = bounds[0]; i <= bounds[1]; i++) {

                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }


}
