package Lab2._2018;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Arrays;

public class _02_SplitByWordCasing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String[] array = inputStr.split("[\\\\,;:.!()'\"/\\[\\] ]");

        ArrayList<String> upperCaseWords = new ArrayList<>();
        ArrayList<String> lowerCaseWords = new ArrayList<>();
        ArrayList<String> mixedCaseWords = new ArrayList<>();


        //array = removeEmptyEntries(array);
        //array.removeAll(Arrays.asList("", null));

        for (String word : array) {

            if (isLowerCase(word) && areAllLetters(word)) {
                lowerCaseWords.add(word);
            } else if (isUpperCase(word) && areAllLetters(word)) {
                upperCaseWords.add(word);
            } else {
                mixedCaseWords.add(word);
            }
        }

        lowerCaseWords.removeAll(Arrays.asList("", null));
        upperCaseWords.removeAll(Arrays.asList("", null));
        mixedCaseWords.removeAll(Arrays.asList("", null));
        System.out.printf("Lower-case: %s\n", printLists(lowerCaseWords));//list.removeAll(Arrays.asList("", null));
        System.out.printf("Mixed-case: %s\n", printLists(mixedCaseWords));
        System.out.printf("Upper-case: %s\n", printLists(upperCaseWords));
    }

    static boolean isLowerCase(String word) {
        if (word.equals(word.toLowerCase()))
            return true;
        return false;
    }

    static boolean isUpperCase(String word) {
        if (word.equals(word.toUpperCase()))
            return true;
        return false;
    }

    static boolean areAllLetters(String word) {

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static String[] removeEmptyEntries(String[] array) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        ArrayList<String> newList = new ArrayList<>();
        for (String s : list) {
            if (s.length() != 0) {
                newList.add(s);
            }
        }

        String[] newArray = new String[newList.size()];
        newArray = newList.toArray(newArray);

        return newArray;
    }

    static String printLists(ArrayList<String> list) {
        String words = "";
        for (String word : list) {
            words += word + ", ";
        }
        return words.substring(0, words.length() - 2);
    }
}
