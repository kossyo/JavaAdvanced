package StringProcessing.Exercises;

import java.util.Scanner;

public class _07_LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (int i = 0; i < input.length; i++)
        {
            String currentString = input[i];
            char firstLetter = currentString.charAt(0);
            char lastLetter = currentString.charAt(currentString.length() - 1);

            double number = Double.parseDouble(currentString.substring(1, currentString.length() - 1));
            double currentResult = 0;

            if (isUpperCase(firstLetter))
            {
                currentResult = number / (firstLetter-64);
            }
            else
            {
                currentResult = number * (firstLetter-96);
            }

            if (isUpperCase(lastLetter))
            {
                currentResult = currentResult - (lastLetter-64);
            }
            else
            {
                currentResult = currentResult + (lastLetter-96);
            }

            sum += currentResult;
        }

        System.out.printf("%.2f", sum);
    }

    static boolean isUpperCase(char letter)
    {
        return (letter >= 65 && letter <= 90);
    }
}
