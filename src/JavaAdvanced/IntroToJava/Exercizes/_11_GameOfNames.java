package IntroToJava.Exercizes;

import java.util.*;

public class _11_GameOfNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 3;//Integer.parseInt(scanner.nextLine());

        Map<String, Integer> info = new LinkedHashMap<>();

        info.put("a4o", 5);
        info.put("bibi", 10);
        info.put("ceco", 15);

        for (Map.Entry<String, Integer> kvp : info.entrySet()) {

            System.out.println("key: " + kvp.getKey() + "\tvalue: " + kvp.getValue());

        }


    }
}
