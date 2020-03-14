
package StringProcessing.Exercises;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _14_SumAllValues {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regexPatternKeys = "(^[A-Za-z_]+)(?:[\\d]+?([A-Za-z_]+)+)+";

        String keys = scanner.nextLine();

        Pattern pattern = Pattern.compile(regexPatternKeys);
        Matcher matcher = pattern.matcher(keys);
        String startKey = "";
        String endKey = "";

        if (matcher.find()) {
             startKey = matcher.group(1);
             endKey = matcher.group(2);
        }

        if (startKey.equals("") || endKey.equals("")) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String regexPatternValues = String.format("%s([\\d]*(?:\\.[\\d]+)*)%s", startKey, endKey);//there is a test which considers .5 a valid number
        String text = scanner.nextLine();
        Pattern pattern2 = Pattern.compile(regexPatternValues);
        Matcher matcher2 = pattern2.matcher(text);

        BigDecimal sum = new BigDecimal(0);
        while (matcher2.find()) {

            BigDecimal current = new BigDecimal(matcher2.group(1));
            sum = sum.add(current);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        if ("0".equals(df.format(sum))){
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
        else {
            System.out.printf("<p>The total value is: <em>%s</em></p>", df.format(sum));
        }
    }
}
