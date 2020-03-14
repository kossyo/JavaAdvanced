//60/100

package Exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11_Robotics {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(";");
        List<Robot> robots = new LinkedList<>();

        ///////натъпква се и freeRobots
        for (int i = 0; i < input.length; i++) {

            String[] currentNameAndHandlingTime = input[i].split("-");
            String currentName = currentNameAndHandlingTime[0];
            int currentHandlingTime = Integer.parseInt(currentNameAndHandlingTime[1]);

            Robot robot = new Robot(currentName, currentHandlingTime, "");
            robots.add(robot);
        }

        /////// чете се time
        long[] startTimeInput = Arrays.stream(reader.readLine().split(":"))
                .mapToLong(Long::parseLong).toArray();
        long time = startTimeInput[2] + startTimeInput[1] * 60 + startTimeInput[0] * 60 * 60;
        Deque<String> productsQueue = new ArrayDeque<>();

        while (true) {
            String productInput = reader.readLine();
            if ("End".equals(productInput)) {
                break;
            }
            productsQueue.add(productInput);
        }

        List<String> history = new LinkedList<>();

        while (true) {

            time++;
            long hours = time / 60 / 60 % 24;
            long minutes = time / 60 % 60;
            long seconds = time % 60;

            String currentProduct = productsQueue.poll();

            if (!robots.isEmpty()) {//ако има робот

                for (Robot robot : robots) {
                    if (time == robot.getTimeWhenExpectedToBeFree()) {
                        robot.setIsFree(true);
                    }
                }

                Robot currentRobot = null;

                //find 1st free robot
                for (Robot robot : robots) {

                    if (!robot.getIsFree()){
                        if (time >= robot.getTimeWhenExpectedToBeFree()) {
                            robot.setIsFree(true);
                        }
                    }

                    else {
                        currentRobot = robot;
                        break;
                    }
                }

                if (currentRobot != null) {

                    currentRobot.setTimeStartAndEndTime(time);
                    currentRobot.setProductWorkingOn(currentProduct);
                    currentRobot.setIsFree(false);
                    history.add(String.format("%s - %s [%02d:%02d:%02d]",
                            currentRobot.getName(), currentProduct, hours, minutes, seconds));
                } else {
                    productsQueue.add(currentProduct);
                }
            }

            if (productsQueue.isEmpty()) {
                break;
            }
        }

        System.out.print(String.join("\r\n", history));
    }
}
