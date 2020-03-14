package Lab2._2018;


import java.util.Arrays;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] names = new String[n];
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {

            int sum = 0;
            names[i] = scanner.nextLine();

            for (int j = 0; j < names[i].length(); j++) {
                if (isVowel(names[i].charAt(j))) {
                    sum += names[i].charAt(j) * names[i].length();
                } else {
                    sum += names[i].charAt(j) / names[i].length();
                }
            }
            sums[i] = sum;


        }
        Arrays.sort(sums);

        printArr(sums);


    }

    static boolean isVowel(char letter) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < vowels.length; i++) {
            if (letter == vowels[i]) {
                return true;
            }
        }

        return false;
    }

    static void printArr(int[] array) {

        for (int i : array) {
            System.out.println(i);
        }
    }
}

