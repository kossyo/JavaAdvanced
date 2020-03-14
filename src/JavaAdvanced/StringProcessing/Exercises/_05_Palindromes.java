package StringProcessing.Exercises;

import java.util.*;

public class _05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textStr = scanner.nextLine();

        Set <String> palindromes = new TreeSet<>();

        String[] text = textStr.split("[\\.\\,\\s+!?]+");

        for (String s : text) {

            StringBuilder sb = new StringBuilder(s);
            sb.reverse();

            if (sb.toString().equals(s)){
                palindromes.add(s);
            }
        }

        System.out.println(palindromes);


    }
}
