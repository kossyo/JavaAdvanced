package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _07_ReverseNumberWithAStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < input.length; i++){

                stack.push(input[i]);
        }

        int initialSize = stack.size();

        for(int i = 0; i < initialSize; i++){

            System.out.print(stack.pop() + " ");
        }
    }
}
