package IntroToJava.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ModifyABit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input =scanner.nextLine();
        int[] array = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = array[0];
        int position = array[1];
        int desiredValue = array[2];

        if(desiredValue == 0){

            int mask = ~(1 << position);
            int result = x & mask;
            System.out.println(result);
        }
        else{


            int mask = 1 << position;
            int result = x | mask;
            System.out.println(result);

        }
    }
}
