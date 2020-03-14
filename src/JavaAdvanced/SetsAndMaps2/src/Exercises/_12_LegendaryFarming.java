package Exercises;

import java.util.*;
import java.util.Collections;

public class _12_LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> meaningful = new TreeMap<>();
        meaningful.put("shards", 0);
        meaningful.put("fragments", 0);
        meaningful.put("motes", 0);

        Map<String, Integer> junk = new LinkedHashMap<>();

        boolean obtainedShadowmourne = false;
        boolean obtainedValanyr = false;
        boolean obtainedDragonwrath = false;

        while (!obtainedDragonwrath && !obtainedShadowmourne && !obtainedValanyr) {
            String input = scanner.nextLine().toLowerCase();

            List<String> eachWordSplit = new LinkedList<>();
            Collections.addAll(eachWordSplit, input.split(" "));
            List<String> each2WordsSplit = new LinkedList<>();

            for (int i = 0; i < eachWordSplit.size(); i += 2) {
                each2WordsSplit.add(eachWordSplit.get(i) + " " + eachWordSplit.get(i + 1));
            }

            for (String item : each2WordsSplit) {
                String[] materialAndCount = item.split(" ");

                String material = materialAndCount[1];
                int count = Integer.parseInt(materialAndCount[0]);

                if (meaningful.containsKey(material)) {
                    meaningful.put(material, meaningful.get(material) + count);
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, count);
                    } else {
                        junk.put(material, junk.get(material) + count);
                    }
                }
                if (meaningful.get("shards") >= 250) {
                    obtainedShadowmourne = true;
                    System.out.println("Shadowmourne obtained!");
                    meaningful.put("shards", meaningful.get("shards") - 250);
                    break;
                }
                if (meaningful.get("fragments") >= 250) {
                    obtainedValanyr = true;
                    System.out.println("Valanyr obtained!");
                    meaningful.put("fragments", meaningful.get("fragments") - 250);
                    break;

                }
                if (meaningful.get("motes") >= 250) {
                    obtainedDragonwrath = true;
                    System.out.println("Dragonwrath obtained!");
                    meaningful.put("motes", meaningful.get("motes") - 250);
                    break;
                }
            }
        }

        meaningful.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(kvp -> System.out.printf("%s: %d\n", kvp.getKey().toLowerCase(), kvp.getValue()));

        junk.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s: %d\n", kvp.getKey().toLowerCase(), kvp.getValue()));


    }
}

