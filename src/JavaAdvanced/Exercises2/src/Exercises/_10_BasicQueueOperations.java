package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class _10_BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input[0]; i++) {

            queue.add(numbers[i]);
        }

        for (int i = 0; i < input[1]; i++) {
            queue.poll();
        }

        int queueSize = queue.size();

        for (int i = 0; i < queueSize; i++) {

            if(queue.contains(input[2])){
                System.out.println("true");
                break;
            }

            else if(queueSize > 0){
                System.out.println(Collections.min(queue));
                break;
            }
        }

        if(queueSize == 0){
            System.out.println(0);
        }
    }
}
