package StringProcessing.Exercises;

import java.util.Scanner;

public class _01_CountSubstringOccurances {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String key  = scanner.nextLine();
        int counter = 0;

        int i = 0 ;
        for(; i <= text.length() - key.length(); i++ ){

            String currentSubstring = text.substring(i, i + key.length());

            if(currentSubstring.equalsIgnoreCase(key)){

                counter++;
            }
        }
        System.out.print(counter);
    }
}
