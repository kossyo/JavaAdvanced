package ExamPreparation._10june2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genome {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> data = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("^([a-z!@#$?]+)=(\\d+)--(\\d+)<<([A-Za-z]+)$");

        String line;
        while (!"Stop!".equals((line = reader.readLine()))) {

            Matcher matcher = pattern.matcher(line);

            String nameNotCleaned = "";
            int lengthOfName = 0;
            long countOfGenes = 0;
            String owner = "";

            if (matcher.find()) {
                nameNotCleaned = matcher.group(1);
                lengthOfName = Integer.parseInt(matcher.group(2));
                countOfGenes = Long.parseLong(matcher.group(3));
                owner = matcher.group(4);

                String name = getCleanName(nameNotCleaned);

                if (name.length() == lengthOfName){

                    if (!data.containsKey(owner)){

                        data.put(owner, countOfGenes);
                    }
                    else {
                        data.put(owner, data.get(owner) + countOfGenes);
                    }
                }
            }
        }
        data.entrySet().stream()
                .sorted((a,b)-> b.getValue().compareTo(a.getValue()))
                .forEach(kvp -> System.out.printf("%s has genome size of %d%n", kvp.getKey(), kvp.getValue()));
    }

    private static String getCleanName(String nameNotCleaned) {

        List<Character> charsToClean = Arrays.asList('!','@','#','$','?');//;{'!','@','#','$','?'};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameNotCleaned.length(); i++) {

            if (!charsToClean.contains(nameNotCleaned.charAt(i)) ){
                sb.append(nameNotCleaned.charAt(i));
            }

        }

        return sb.toString();


    }
}
