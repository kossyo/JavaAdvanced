package StringProcessing.Exercises;

import java.util.*;

public class _06_MagicExchangeableWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        String word1 = words[0];
        String word2 = words[1];
        Map<Character, Character> map = new HashMap<>();

        boolean isLengthDifferent = word1.length() != word2.length();
        int lengthOfShorterWord = Math.min(words[0].length(), words[1].length());

        boolean areExchangeable = true;

        for (int i = 0; i < lengthOfShorterWord; i++) {
            if (map.containsKey(word1.charAt(i)))//if there is such a letter already
            {
                if (map.get(word1.charAt(i)) != word2.charAt(i)) {
                    areExchangeable = false;
                }
            } else if (!map.containsKey(word1.charAt(i))//if current letter hasn't occurred yet && there is already a value which is equals to the second word
                    && map.containsValue(word2.charAt(i))) {
                areExchangeable = false;
            } else {
                map.put(word1.charAt(i), word2.charAt(i));
            }
        }

        if (isLengthDifferent) {
            Arrays.sort(words, Comparator.comparingInt(String::length));

            String hangingPart = words[1].substring(words[0].length());
            String remainingPart = words[1].replace(hangingPart, "");

            for (int i = 0; i < hangingPart.length(); i++) {
                if (!remainingPart.contains(hangingPart.charAt(i) + "")) {
                    areExchangeable = false;
                    break;
                }
            }
        }
        System.out.println(areExchangeable);
    }
}

