package IntroToJava.Exercizes;

import java.util.Arrays;
import java.util.Scanner;

public class _05_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if (numbers.length % 2 == 1) {
            System.out.println("invalid length");

        } else {
            for (int i = 0; i < numbers.length; i += 2) {

                int current1 = numbers[i];
                int current2 = numbers[i + 1];
                String relation = "";

                if (current1 % 2 == 0 && current2 % 2 == 0) {
                    relation = "both are even";
                } else if (current1 % 2 == 1 && current2 % 2 == 1) {
                    relation = "both are odd";
                } else {
                    relation = "different";
                }

                System.out.printf("%d, %d -> %s\r\n", current1, current2, relation);

            }
        }
    }
}
