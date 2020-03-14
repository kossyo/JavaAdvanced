package StringProcessing.Lab;

import java.util.Scanner;

public class _05_VowelCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String vowels = "aeiouyAEIOUY";
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (vowels.contains(input.charAt(i) + "")){
                count++;
            }
        }
        System.out.println("Vowels: "+count);

    }
}
