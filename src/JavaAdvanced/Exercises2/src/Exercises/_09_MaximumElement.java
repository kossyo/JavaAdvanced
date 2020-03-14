//75/100

package Exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;


public class _09_MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // тука ти трая още един дек да пазиш максовете

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "1":
                    stack.push(Integer.parseInt(input[1]));

                    break;

                case "2":

                    if (!stack.isEmpty())
                        stack.pop();
                    break;

                case "3":
                    if (!stack.isEmpty())
                        System.out.println(Collections.max(stack));// ей тва бави най-вероятно
                    break;
            }
        }
    }


}