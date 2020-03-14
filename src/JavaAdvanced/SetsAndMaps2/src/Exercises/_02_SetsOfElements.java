package Exercises;

import java.util.*;

public class _02_SetsOfElements {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Set<String> list1 = new LinkedHashSet<>();
        Set<String> list2 = new LinkedHashSet<>();
        Set<String> common = new LinkedHashSet<>();

        int[] sizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size1 = sizes[0];
        int size2 = sizes[1];

        for (int i = 0; i < size1; i++) {

            String current = scanner.nextLine();
            list1.add(current);
        }

        for (int i = 0; i < size2; i++) {

            String current = scanner.nextLine();
            list2.add(current);
        }

        for (String s1 : list1) {

            if (list2.contains(s1)){
                common.add(s1);
            }
        }

        for (String s : common) {
            System.out.print(s + " ");
        }

    }
}
