package IntroToJava.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _10_ExtractABitFromAnInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int position = array[1];

        int mask = n >> position;

        System.out.println(mask & 1);


    }
}
