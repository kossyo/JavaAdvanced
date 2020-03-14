package Lab2._2018;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayDeque;

public class _05_SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, input);

        long num1 = Long.parseLong(stack.pop());
        long result = num1;

        while (stack.size() > 1) {

            String action = stack.pop();
            long num2 = Long.parseLong(stack.pop());

            switch (action) {
                case "+":
                    result += num2;
                    break;

                case "-":
                    result -= num2;
                    break;
            }
        }
        System.out.println(result);
    }
}