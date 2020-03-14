package Exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set <String> set = new TreeSet<>();



        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] currentArray = scanner.nextLine().split(" ");

            for (String s : currentArray) {
                set.add(s);
            }

        }
        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
