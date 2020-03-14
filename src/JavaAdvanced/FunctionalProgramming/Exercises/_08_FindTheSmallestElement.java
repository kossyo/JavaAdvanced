package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _08_FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallest = collection ->{

            long minValue = Long.MAX_VALUE;
            int minIndex = 0;

            for (int i = 0; i < collection.size(); i++) {

                if (collection.get(i) <= minValue){

                    minValue = collection.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };

        System.out.println(getSmallest.apply(numbers));

    }
}
