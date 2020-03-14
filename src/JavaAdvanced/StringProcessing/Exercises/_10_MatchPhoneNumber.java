package StringProcessing.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _10_MatchPhoneNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regexPattern = "^\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}$";
        Pattern pattern = Pattern.compile(regexPattern);

        String line = "";
        while (!(line = scanner.nextLine()).equals("end")){

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()){
                System.out.println(matcher.group(0));
            }
        }

    }
}
