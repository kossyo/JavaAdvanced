package IntroToJava;

import java.util.*;
import java.util.Scanner;

public class Demo {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        int currentLoserIndex = pickAChild(array, n);

        //май че оттука тряа да почва

        while(array.length != 1) {
            System.out.println(array[currentLoserIndex]);

            List<String> list = new LinkedList<>();

            Collections.addAll(list, array);
            list.remove(currentLoserIndex);

            String[] newArray = new String[list.size()];
            newArray = list.toArray(newArray);
            array = newArray;
        }

       // System.out.println();
        //1вото дете май го маха като хората ама второто - не
    }

    static int pickAChild(String[] array, int n) {

        int steps = array.length;
        int counter = 0;

        for (int i = 0; i < 100; i++) {// 100 be6e n

            if (counter == n - 1) {
                break;
            }
            counter++;
        }

        return counter % steps;
    }
}