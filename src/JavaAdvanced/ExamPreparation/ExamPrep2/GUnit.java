package ExamPreparation.ExamPrep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Set<String>>> data = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+)$");

        String line;
        while (!"It's testing time!".equals((line = reader.readLine()))) {

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {

                String classs = matcher.group(1);
                String method = matcher.group(2);
                String test = matcher.group(3);

                data.putIfAbsent(classs, new LinkedHashMap<>());
                data.get(classs).putIfAbsent(method, new LinkedHashSet<>());
                data.get(classs).get(method).add(test);
            }
        }
        data
                .entrySet()
                .stream()
                .sorted((class1, class2) -> {

                    final int[] numberOfTests1 = {0};
                    final int[] numberOfTests2 = {0};
                    class1
                            .getValue()
                            .values()
                            .forEach(set -> numberOfTests1[0] += set.size());
                    class2
                            .getValue()
                            .values()
                            .forEach(set -> numberOfTests2[0] += set.size());

                    if (numberOfTests1[0] - numberOfTests2[0] != 0) {

                        return numberOfTests2[0] - numberOfTests1[0];

                    } else {

                        if (class1.getValue().keySet().size() - class2.getValue().keySet().size() != 0) {
                            return class1.getValue().keySet().size() - class2.getValue().keySet().size();
                        } else {
                            return class1.getKey().compareTo(class2.getKey());
                        }
                    }

                })
                .forEach(classs ->
                        {
                            System.out.println(classs.getKey() + ":");
                            classs
                                    .getValue()
                                    .entrySet()
                                    .stream()
                                    .sorted((method1, method2) -> {

                                        if (method2.getValue().size() - method1.getValue().size() != 0) {

                                            return method2.getValue().size() - method1.getValue().size();
                                        } else {
                                            return method1.getKey().compareTo(method2.getKey());
                                        }
                                    })
                                    .forEach(method -> {

                                        System.out.printf("##%s%n", method.getKey());
                                        method
                                                .getValue()
                                                .stream()
                                                .sorted((test1, test2) -> {//ascending

                                                    if (test1.length() - test2.length() != 0) {
                                                        return test1.length() - test2.length();
                                                    } else {
                                                        return test1.compareTo(test2);
                                                    }

                                                })
                                                .forEach(test -> System.out.printf("####%s%n", test));
                                    });
                        }
                );
    }
}
