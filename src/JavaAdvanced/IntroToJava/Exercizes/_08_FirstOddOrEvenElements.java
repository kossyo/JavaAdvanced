package IntroToJava.Exercizes;

import java.util.Arrays;
import java.util.Scanner;

public class _08_FirstOddOrEvenElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] instructions = scanner.nextLine().split(" ");
        int amount = Integer.parseInt(instructions[1]);
        int printCount = 0;
        String command = instructions[2];

        for(int i = 0; i <= numbers.length && printCount < amount; i++){

            if(i > numbers.length - 1){break;}

            switch(command){
                case "even":

                    if(numbers[i] % 2==0){
                        System.out.print(numbers[i] + " ");
                        printCount++;
                    }
                    break;

                case "odd":
                    if(numbers[i] % 2!=0){
                        System.out.print(numbers[i] + " ");
                        printCount++;

                    }
                    break;
            }
        }
    }
}
