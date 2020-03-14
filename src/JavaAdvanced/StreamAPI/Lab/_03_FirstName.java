package StreamAPI.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class _03_FirstName {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        List<String> letters = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        Optional<String> result =  names.stream().sorted()

                .filter(name -> {

                    boolean mustRemain = false;

                    for (String letter : letters) {

                        if (letter.equalsIgnoreCase(String.valueOf(name.charAt(0))))
                            mustRemain = true;
                    }
                    return mustRemain;
                })
                .findFirst();


        if (result.isPresent())
            System.out.println(result.get());
        else
            System.out.println("No match");

    }
}
