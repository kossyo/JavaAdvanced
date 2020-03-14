package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _08_BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input[0]; i++) {

            stack.push(numbers[i]);
        }

        for (int i = 0; i < input[1]; i++) {
            stack.pop();
        }

        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {

            if (stack.contains(input[2])) {
                System.out.println("true");
                break;
            } else if (stackSize > 0) {
                System.out.println(Collections.min(stack));
                break;
            }
        }

        if (stackSize == 0) {
            System.out.println(0);
        }
    }
}
