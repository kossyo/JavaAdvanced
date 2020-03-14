package ExamPreparation._03Jan2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _TryToFix_DHARMASupplies {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputLines = 0;
        List<String> crates = new LinkedList<>();

        String line;
        while (!"Collect".equals((line = reader.readLine()))) {

            inputLines++;
            Pattern patternIsThereCrate = Pattern.compile("(\\[.*?\\])");
            Matcher matcher = patternIsThereCrate.matcher(line);
            while (matcher.find()) {

                crates.add(matcher.group(0));
            }
        }

        int n = crates.size()/ inputLines;

        long food = 0;
        long drinks = 0;
        int validCratesCount = 0;
        for (String crate : crates) {

            Pattern matcherIsValidCrate = Pattern.compile(String.format("\\[#([a-z\\d]{%d})([A-Za-z\\d\\s]+)#\\1\\]", n));
            Matcher matcher = matcherIsValidCrate.matcher(crate);
            while(matcher.find()){
                validCratesCount++;

                //for (int i = 0; i < matcher.group(1).length(); i++) {

                    String tag = matcher.group(1);
                    String body = matcher.group(2);

                    if (Character.isDigit(tag.charAt(0))) {

                        Set<Character> bodySet = new HashSet<>();
                        for (int j = 0; j < body.length(); j++) {
                            bodySet.add(body.charAt(j));
                        }
                        long sum = 0;
                        for (Character ch : bodySet) {
                            sum += ch;
                        }

                        food += sum * tag.length();
                    }
                    else if (Character.isLowerCase(matcher.group(1).charAt(0))) {
                        drinks += getDrinksAmount(matcher.group(0) ,n);
                    }
                //}
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
    private static long getFoodAmounts(String fragment, int n) {

        Pattern pattern = Pattern.compile(String.format("\\[#([a-z\\d]{%d})([A-Za-z\\d\\s]+)#\\1\\]", n));
        Matcher matcher = pattern.matcher(fragment);

        matcher.find();
        String tag = matcher.group(1);
        String body = matcher.group(2);

        Set<Character> bodySet = new HashSet<>();
        for (int i = 0; i < body.length(); i++) {
            bodySet.add(body.charAt(i));
        }
        long sum = 0;
        for (Character ch : bodySet) {
            sum += ch;
        }

        return sum * tag.length();
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

}
