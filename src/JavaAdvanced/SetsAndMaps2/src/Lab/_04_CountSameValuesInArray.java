package Lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountSameValuesInArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");


        Map<String, Integer> hashmap = new HashMap<>();

        for (String s : input) {

            if (hashmap.containsKey(s)){

                hashmap.put(s, hashmap.get(s) + 1);
            }

            else {
                hashmap.put(s, 1);
            }
        }

        for (String s : hashmap.keySet()) {
            System.out.printf("%s - %d times\n", s, hashmap.get(s));
        }


    }
}
