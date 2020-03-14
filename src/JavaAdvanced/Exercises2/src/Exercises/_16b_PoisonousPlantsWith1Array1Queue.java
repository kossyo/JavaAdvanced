//77/100
//пробвай да я решиш с 1 масив и една опашка!!!
//това е чуждо, минава на 66/100 с една грешка и пак двата грешни за време

package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16b_PoisonousPlantsWith1Array1Queue{
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int plantsCount = Integer.parseInt(bufferedReader.readLine());

        int[] input = Arrays
                .stream(bufferedReader.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedHashMap<Integer, Boolean> dictionary = new LinkedHashMap<>();

        for (int plant : input) {
            dictionary.put(plant, true);
        }

        boolean hasDied = true;
        int daysCount = 0;

        while (hasDied) {
            hasDied = false;

            int leftPlant = Integer.MAX_VALUE;

            for (Map.Entry<Integer, Boolean> kvp : dictionary.entrySet()) {
                if (kvp.getKey() > leftPlant) {
                    kvp.setValue(false);
                    hasDied = true;
                }

                leftPlant = kvp.getKey();
            }

            if (hasDied) {
                dictionary.values().removeIf(val -> !val);
                daysCount++;
            }
        }

        System.out.println(daysCount);
    }
}
