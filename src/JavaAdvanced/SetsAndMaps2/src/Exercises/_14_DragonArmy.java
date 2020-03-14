package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _14_DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, int[]>> type__name_stats = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        String type = "";
        String name = "";
        int damage = 0;
        int health = 0;
        int armor = 0;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            type = input[0];
            name = input[1];

            damage = (!"null".equals(input[2])) ? Integer.parseInt(input[2]) : 45;
            health = (!"null".equals(input[3])) ? Integer.parseInt(input[3]) : 250;
            armor = (!"null".equals(input[4])) ? Integer.parseInt(input[4]) : 10;

            int[] damage_health_armor = {damage, health, armor};

            if (!type__name_stats.containsKey(type)) {
                TreeMap<String, int[]> currentMap = new TreeMap<>();

                currentMap.put(name, damage_health_armor);
                type__name_stats.put(type, currentMap);

            } else {
                type__name_stats.get(type).put(name, damage_health_armor);
            }
        }

        for (Map.Entry<String, TreeMap<String, int[]>> outerKvp : type__name_stats.entrySet()) {

            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;

            for (Map.Entry<String, int[]> innerKvp : outerKvp.getValue().entrySet()) {
                avgDamage += innerKvp.getValue()[0];
                avgHealth += innerKvp.getValue()[1];
                avgArmor += innerKvp.getValue()[2];
            }

            avgDamage /= outerKvp.getValue().size();
            avgHealth /= outerKvp.getValue().size();
            avgArmor /= outerKvp.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", outerKvp.getKey(),
                    avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, int[]> innerKvp : outerKvp.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", innerKvp.getKey(),
                        innerKvp.getValue()[0],
                        innerKvp.getValue()[1],
                        innerKvp.getValue()[2]
                        );
            }
        }
    }
}
