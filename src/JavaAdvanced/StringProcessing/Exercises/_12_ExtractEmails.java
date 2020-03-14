package StringProcessing.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_ExtractEmails {
    public static void main(String[] args) {

        //  can there be more than one [.-_] in a row? i assume yes.

        Scanner scanner = new Scanner(System.in);
        String line;
        StringBuilder sb = new StringBuilder();

        while(!(line = scanner.nextLine()).equals("end")){
            sb.append(line);
        }
        String input = sb.toString();
        String regexPattern = "(?<=^| )[A-Za-z0-9][\\w-\\.]+[A-Za-z0-9]@[A-Za-z][A-Za-z-]+[A-Za-z](?:\\.[A-Za-z]+)+(?=\\.|,| |$)";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

       while (matcher.find()){
           String email = matcher.group();
           System.out.println(email);
       }



    }
}
