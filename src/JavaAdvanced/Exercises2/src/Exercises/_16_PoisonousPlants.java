//77/100
//пробвай да я решиш с 1 масив и една опашка!!!

package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class _16_PoisonousPlants {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfFlowers = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> flowers = new ArrayDeque<>();
        Deque<Integer> survivors = new ArrayDeque<>();
        int counter = 0;

        for (int i : array) {

            flowers.add(i);
        }

        int lastNumberOfFlowers = numberOfFlowers;

        while (true) {

            int leftNumber = flowers.pop();
            survivors.add(leftNumber);

            for (int i = 0; i < numberOfFlowers - 1; i++) {

                int rightNumber = flowers.pop();

                if (rightNumber <= leftNumber) {
                    survivors.add(rightNumber);
                }
                leftNumber = rightNumber;
            }
            flowers = survivors;
            numberOfFlowers = survivors.size();

            if (numberOfFlowers < lastNumberOfFlowers) {
                lastNumberOfFlowers = numberOfFlowers;
            } else {
                break;
            }
            survivors = new ArrayDeque<>();
            counter++;
        }

        System.out.println(counter);
    }
}
