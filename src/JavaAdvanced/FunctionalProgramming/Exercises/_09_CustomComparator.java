// това става просто с друг обект от класа компаратор, който се подава на .сорт() за да се използва вместо
// дефолтния

package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class _09_CustomComparator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> compareEvenAndAscending = (x,y) -> {

            boolean aIsEven = x % 2 == 0;
            boolean bIsEven = y % 2 == 0;

            if (aIsEven && !bIsEven) {
                return -1;
            } else if (!aIsEven && bIsEven) {
                return 1;
            } else {
                return x - y;
            }
        };

        Collections.sort(input, compareEvenAndAscending);


        for (Integer x : input) {
            System.out.print(x + " ");
        }

    }
}

