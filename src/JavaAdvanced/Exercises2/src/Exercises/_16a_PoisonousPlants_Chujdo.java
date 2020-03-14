package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _16a_PoisonousPlants_Chujdo {
    public static void main(String[] args) throws IOException{

        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(buffer.readLine());

        String[] input = buffer.readLine().split(" ");

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(0);

        int[] days = new int[n];

        for (int i = 0; i < n; i++) {

            int maxDays = 0;


            while (deque.size() > 0 && Integer.valueOf(input[deque.peek()]) >= Integer.valueOf(input[i])) {
                maxDays = Math.max(maxDays, days[deque.pop()]);
            }

            if (deque.size() > 0) {
                days[i] = maxDays + 1;
            }

            deque.push(i);
        }
        System.out.println(maximum(days));
    }

    private static int maximum(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
}
