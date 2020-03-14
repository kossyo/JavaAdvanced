//100/100
// solution is against the logic and description. Whether mission is completed of not should be based on the fact
// if text.contains("C"). In this case it is based on the fact if !text.contains("X").
// That is why input "ro7Mck4IetS561VlauSInO$c#h24N^" calculates mission successful
// even though there's no "C" in the input. Besides, in the description it is clearly stated:
// "(the input will always contain one of the characters)" and the example above does not contain either X or C.

package ExamPreparation._27aug2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_Mission {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(\\S*)M(\\S*)I(\\S*)S(\\S*)S(\\S*)I(\\S*)O(\\S*)N(\\S*)";
        Pattern pattern = Pattern.compile(regex);

        List<Mission> listOfMissions = new LinkedList<>();
        String line;
        while (!"Decrypt".equals((line = reader.readLine()))) {

            Matcher matcher = pattern.matcher(line);
            String missionName = "";
            long rating = 0;
            if (matcher.find()) {

                Mission mission = new Mission();
                StringBuilder textSB = new StringBuilder();

                for (int i = 1; i <= 8; i++) { // as there are 8 groups

                    if (!"".equals(matcher.group(i))) {

                        textSB.append(matcher.group(i));
                    }
                }
                String text = textSB.toString();

                if (!text.contains("X")) {
                    mission.isCompleted = true;
                } else {
                    mission.isCompleted = false;
                }
                StringBuilder missionNameSB = new StringBuilder();

                for (int i = 0; i < text.length(); i++) {
                    if (Character.isLowerCase(text.charAt(i))) {
                        missionNameSB.append(text.charAt(i));
                    } else if (Character.isDigit(text.charAt(i))) {
                        rating += Long.parseLong(String.valueOf(text.charAt(i)));
                    }
                }
                missionName = missionNameSB.toString();

                mission.name = missionName;
                mission.rating = rating;

                listOfMissions.add(mission);
            }
        }

        System.out.printf(
                "Completed mission %s with rating: %d%n",

                listOfMissions.stream()
                        .filter(Mission::getIsCompleted)
                        .sorted(Comparator.comparing(Mission::getRating, Comparator.reverseOrder()))
                        .findFirst().get().getName(),

                listOfMissions.stream()
                        .filter(Mission::getIsCompleted)
                        .sorted(Comparator.comparing(Mission::getRating, Comparator.reverseOrder()))
                        .findFirst().get().getRating()
        );

        System.out.printf("Failed Mission %s with rating: %d",

                listOfMissions.stream()
                        .filter(mission -> !mission.getIsCompleted())
                        .sorted(Comparator.comparing(Mission::getRating, Comparator.reverseOrder()))
                        .findFirst().get().getName(),

                listOfMissions.stream()
                        .filter(mission -> !mission.getIsCompleted())
                        .sorted(Comparator.comparing(Mission::getRating, Comparator.reverseOrder()))
                        .findFirst().get().getRating()
        );
    }
}

class Mission {

    String name;
    Long rating;
    boolean isCompleted;


    public String getName() {
        return name;
    }

    public Long getRating() {
        return rating;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

}