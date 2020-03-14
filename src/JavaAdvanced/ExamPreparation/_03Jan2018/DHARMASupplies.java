//40/100

package ExamPreparation._03Jan2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DHARMASupplies {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputLines = 0;
        List<String> validMatchesOfCrates = new LinkedList<>();

        String line;
        Pattern pattern = Pattern.compile("(\\[.*?\\])");
        while (!"Collect".equals((line = reader.readLine()))) {

            inputLines++;
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {

                validMatchesOfCrates.add(matcher.group(0));
            }
        }

        int n = validMatchesOfCrates.size() / inputLines;

        long food = 0;
        long drinks = 0;
        int validCratesCount = 0;
        for (String validMatchOfCrate : validMatchesOfCrates) {

            pattern = Pattern.compile(String.format("\\[#([a-z\\d]{%d})([A-Za-z\\d\\s]+)#\\1\\]", n));
            Matcher matcher = pattern.matcher(validMatchOfCrate);
            while (matcher.find()) {
                validCratesCount++;

                if (Character.isDigit(matcher.group(1).charAt(0))) {
                    food += getFoodAmounts(matcher.group(0), n);
                } else if (Character.isLowerCase(matcher.group(1).charAt(0))) {
                    drinks += getDrinksAmount(matcher.group(0), n);
                }
            }
        }

        if (validCratesCount > 0) {
            System.out.println("Number of supply crates: " + validCratesCount);
            System.out.println("Amount of food collected: " + food);
            System.out.println("Amount of drinks collected: " + drinks);
        } else {
            System.out.println("No supplies found!");
        }
    }

    private static long getDrinksAmount(String fragment, int n) {

        Pattern pattern = Pattern.compile(String.format("\\[#([a-z\\d]{%d})([A-Za-z\\d\\s]+)#\\1\\]", n));
        Matcher matcher = pattern.matcher(fragment);

        matcher.find();
        String tag = matcher.group(1);
        String body = matcher.group(2);

        long sumBody = 0;
        for (int i = 0; i < body.length(); i++) {

            sumBody += body.charAt(i);
        }
        long sumTag = 0;
        for (int i = 0; i < tag.length(); i++) {
            sumTag += tag.charAt(i);
        }

        return sumBody * sumTag;
    }

    private static long getFoodAmounts(String fragment, int n) {

        Pattern pattern = Pattern.compile(String.format("\\[#([a-z\\d]{%d})([A-Za-z\\d\\s]+)#\\1\\]", n));
        Matcher matcher = pattern.matcher(fragment);

        matcher.find();
        String tag = matcher.group(1);
        String body = matcher.group(2);

        List<String> bodyList = Arrays.stream(body.split("")).distinct().collect(Collectors.toList());
        long sum = 0;
        for (int i = 0; i < bodyList.size(); i++) {

            sum += bodyList.get(i).charAt(0);
        }

        return sum * tag.length();
    }
}
