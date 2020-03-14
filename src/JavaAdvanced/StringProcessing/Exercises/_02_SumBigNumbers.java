package StringProcessing.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class _02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();

        String[] numbers = {num1, num2};
        String number1equalized = "";//so that numbers have same amount of digits
        String number2equalized = "";//so that numbers have same amount of digits
        StringBuilder sb = new StringBuilder();

        if (num1.length() != num2.length())//ако са различни по дължина
        {
            List<String> shorterNumber = Arrays.stream(numbers)
                    .filter(x -> x.length() < Math.max(num1.length(), num2.length()))
                    .collect(Collectors.toList());

            number1equalized = generateFrom('0', Math.max(num1.length(), num2.length())
                    - Math.min(num1.length(), num2.length()))
                    + String.join("", shorterNumber);

            List<String> longerNumber = Arrays.stream(numbers)
                    .filter(x -> x.length() > Math.min(num1.length(), num2.length()))
                    .collect(Collectors.toList());

            number2equalized = String.join("", longerNumber);
        }

        else {
            number1equalized = num1;
            number2equalized = num2;
        }

        int memory = 0;
        int sum = 0;

        for (int i = number1equalized.length() - 1; i >= 0; i--)//цикъл, който обхожда 2те числа от последната им цифра към първата

        {
            sum += Integer.parseInt(number1equalized.charAt(i) + "") + Integer.parseInt(number2equalized.charAt(i) + "")
                    + memory ;
            //всеки път двете числа се събират
            memory = 0;

            if (sum > 9) {
                memory = 1;
                sum -= 10;
            }
            sb.append(sum);

            if (i > 0) {
                sum = 0;
            }
        }

        if (memory != 0) {
            sb.append(memory);
        }
        sb.reverse();

        while(sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        System.out.println(sb.toString());
    }

    private static String generateFrom(Character input, int times) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            builder.append(input);
        }

        return builder.toString();
    }
}
