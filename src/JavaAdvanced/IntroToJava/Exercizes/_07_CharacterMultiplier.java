package IntroToJava.Exercizes;

import java.util.Scanner;

public class _07_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String[] input = inputStr.split("\\s+");
        String word1 = input[0];
        String word2 = input[1];
        int sum = 0;

        for(int i = 0; i < Math.max(word1.length(), word2.length()); i++){

            if(i < Math.min(word1.length(), word2.length())){
                sum += word1.charAt(i) * word2.charAt(i);
            }
            else{
                if(word1.length()> word2.length()){
                    sum += word1.charAt(i);
                }

                else{
                    sum += word2.charAt(i);
                }
            }
        }

        System.out.println(sum);
    }
}
