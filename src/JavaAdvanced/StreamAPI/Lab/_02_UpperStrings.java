package StreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _02_UpperStrings {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        strings.stream().map(x -> x.toUpperCase()).forEach(x-> System.out.print(x + " "));
    }
}
