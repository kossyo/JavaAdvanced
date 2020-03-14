package StringProcessing.Lab;

import java.util.Scanner;

public class _04_SeriesOfLetters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int i = 0;
        int state = 0;

        while (i < sb.length() - 1) {

            switch (state) {
                case 0:

                    if (sb.charAt(i) == sb.charAt(i + 1)) {
                        sb.deleteCharAt(i+1);
                    } else {
                        state = 1;
                    }
                    break;

                case 1:

                    state = 0;
                    i++;
                    break;
            }
        }
        System.out.println(sb.toString());

    }

}

