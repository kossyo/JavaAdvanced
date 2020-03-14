package Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> hashmap = new TreeMap<>();

        char[] input = scanner.nextLine().toCharArray();

        for (char c : input) {

            if (!hashmap.containsKey(c)){
                hashmap.put(c,1);
            }
            else {
                hashmap.put(c, hashmap.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> kvp : hashmap.entrySet()) {

            System.out.printf("%c: %d time/s\n", kvp.getKey(), kvp.getValue());
        }
    }
}
