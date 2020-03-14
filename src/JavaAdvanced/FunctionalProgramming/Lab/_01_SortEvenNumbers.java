package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(x -> x % 2 != 0);
        System.out.println(numbers.toString().substring(1, numbers.toString().length() - 1));

        numbers.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();

        numbers.stream().forEach(x -> sb.append(x.toString() + ", "));
        if(sb.toString().length() == 0){
            return;
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 2));

    }
}
