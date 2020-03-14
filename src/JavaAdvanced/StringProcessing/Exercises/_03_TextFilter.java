package StringProcessing.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _03_TextFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bannedWordsArray = scanner.nextLine().split(", ");
        ArrayList<String> bannedWords = new ArrayList<>(Arrays.asList(bannedWordsArray));

        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {

            String replacement = generateFrom('*', bannedWord.length());
            String newText = text.replaceAll(bannedWord, replacement);
            text = newText;
        }

        System.out.println(text);
    }

    private static String generateFrom(Character input, int times) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            builder.append(input);
        }

        return builder.toString();
    }
}
