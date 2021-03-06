package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AddVat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Double> list = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Function<Double, Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        list.stream().forEach(x -> System.out.printf("%.2f%n",addVat.apply(x)));


    }
}
