package Exercises;

import java.util.Scanner;
import java.util.Arrays;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char row = 97;
        char col = 97;

        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {

                System.out.print(row);
                System.out.print(col);
                System.out.print(row);
                System.out.print(" ");
                col++;
            }
            col = (char)((int)row + 1);
            row++;
            System.out.println();
        }
    }
}
