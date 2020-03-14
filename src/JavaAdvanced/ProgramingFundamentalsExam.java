
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramingFundamentalsExam {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<String> schedule = Arrays.stream(input.split(", ")).collect(Collectors.toList());


        while (true) {
            String command = reader.readLine();

            if ("course start".equals(command)) {
                break;
            }

            List<String> commands = Arrays.stream(command.split(":")).collect(Collectors.toList());
            String lesson = commands.get(1);

            switch (commands.get(0)) {
                case "Add":

                    if (!schedule.contains(lesson)) {
                        schedule.add(lesson);
                    }

                    break;

                case "Insert":
                    int index = Integer.parseInt(commands.get(2));

                    if (!schedule.contains(lesson) && index < schedule.size()) {

                        schedule.add(index, lesson);
                    }

                    break;
                case "Remove":

                    if (schedule.contains(lesson)) {
                        int indexOfLesson = schedule.indexOf(lesson);

                        schedule.remove(lesson);// tuka kvo praim

                        if (schedule.get(indexOfLesson).contains("Exersice"))//tuka da nqma primer s urok koito se kazva exercise
                        {
                            schedule.remove(indexOfLesson);
                        }
                    }
                    break;

                case "Swap":

                    String lesson2 = commands.get(2);

                    //if (schedule.contains(lesson) && schedule.contains(lesson2)) {
                    if (schedule.stream().anyMatch(x -> x.contains(lesson))// и двата урока ги има
                    && schedule.stream().anyMatch(y -> y.contains(lesson2))){

                        int indexOfLesson1 = schedule.indexOf(lesson);
                        int indexOfLesson2 = schedule.indexOf(lesson2);

                        schedule = getSwapped(schedule, lesson, lesson2);
                    }
                    break;
                case "Exercise":

                    if (schedule.contains(lesson)) {
                        int indexOfLesson = schedule.indexOf(lesson);

                        if (!schedule.get(indexOfLesson).contains("-Exercise")) {

                            schedule.set(indexOfLesson, String.format("%s-Exercise", lesson));
                        }
                    } else {
                        //schedule.set(indexOfLesson, lesson);
                        schedule.add(String.format("%s-Exercise", lesson));
                    }
                    break;
            }
        }
        int counter = 1;
        for (String item : schedule) {
            System.out.printf("%d.%s%n", counter, item);
            counter++;
        }


    }

    private static List<String> getSwapped(List<String> schedule, String lesson, String lesson2) {

        if (schedule.stream().anyMatch(x -> x.contains(lesson))
        && schedule.stream().anyMatch(y -> y.contains(lesson2))){

            int index1 = 0;
            int index2 = 0;
            String tempLesson = "";
            for (int i = 0; i < schedule.size(); i++) {

                if (schedule.get(i).contains(lesson) || schedule.get(i).contains(lesson2)){

                    tempLesson = schedule.get(i);
                    schedule.set(i, "");
                    index1 = i;

                }
            }
        }
        return schedule;
    }
}
