package Exercises;

import java.util.Scanner;

public class _13_RecursiveFibonacci {

    static long[] dict = new long[100];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFib(n));
        System.out.println();

    }

    static long getFib(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        dict[0] = 1;
        dict[1] = 1;


        if (dict[n] != 0) {
            return dict[n];
        }
        dict[n] = getFib(n - 1) + getFib(n - 2);
        return dict[n];
    }

}
