package StreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _08_BoundedNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] limits = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lowerLimit = Math.min(limits[0], limits[1]);
        int upperLimit = Math.max(limits[0], limits[1]);

        Arrays.stream(numbers).filter(number -> {

            if (number >= lowerLimit && number <= upperLimit){
                return true;
            }
            return false;
        }).forEach(number -> System.out.print(number + " "));
    }
}
