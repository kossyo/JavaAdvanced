//85/100
//сигурно минава пак през храна и аз не я махам тая храна

package ExamPreparation._10june2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Snake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        List<List<String>> field = new LinkedList<>();
        String[] commands = reader.readLine().split(", ");
        for (int i = 0; i < size; i++) {

            List<String> inner = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
            field.add(inner);
        }
        List<int[]> enemies = findEnemies(field);
        List<int[]> foodCoordinates = findFood(field);
        int foodLeft = foodCoordinates.size();
        int snakeLength = 1;
        int[] currentPosition = findStartingPosition(field);

        for (String command : commands) {

            currentPosition = moveSnakesHead(field, currentPosition, command, size);
            //20	21		22		32	   31  21  22     23     13
            if (hitEnemy(enemies, currentPosition)){
                System.out.println("You lose! Killed by an enemy!");

                return;
            }

            if (foundFood(foodCoordinates, currentPosition)){
                ++snakeLength;
                --foodLeft;

                for (int i = 0; i < foodCoordinates.size(); i++) {

                    if (foodCoordinates.get(i)[0] == currentPosition[0] && foodCoordinates.get(i)[1] == currentPosition[1]){
                        foodCoordinates.remove(i);
                    }
                }
            }
        }

        if (foodLeft > 0){
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodLeft);
        }
        else {
            System.out.printf("You win! Final snake length is %d%n", snakeLength);

        }
    }

    private static boolean foundFood(List<int[]> foodCoordinates, int[] currentPosition) {

        boolean foundFood = false;
        for (int[] food : foodCoordinates) {
            if (food[0] == currentPosition[0] && food[1] == currentPosition[1]){
                foundFood = true;
                break;
            }
        }
        return foundFood;
    }

    private static boolean hitEnemy(List<int[]> enemies, int[] currentPosition) {

        for (int[] enemy : enemies) {
            if (enemy[0] == currentPosition[0] && enemy[1] == currentPosition[1]){
                return  true;
            }
        }
        return false;
    }

    private static int[] moveSnakesHead(List<List<String>> field, int[] currentPosition, String currentCommand, int size) {

        int[] newPosition = new int[2];

        switch (currentCommand){
            case "right":

                newPosition[0] = currentPosition[0];
                newPosition[1] = ++currentPosition[1];
                break;

            case "down":
                newPosition[0] = ++currentPosition[0];
                newPosition[1] = currentPosition[1];
                break;
            case "left":

                newPosition[0] = currentPosition[0];
                newPosition[1] = --currentPosition[1];
                break;
            case "up":

                newPosition[0] = --currentPosition[0];
                newPosition[1] = currentPosition[1];
                break;
        }

        if (newPosition[0] < 0 || newPosition[0] > size - 1){//top/bottom overflow
            if (newPosition[0] < 0){    //top overflow
                newPosition[0] = size - 1;
            }
            else{   //bottom overflow
                newPosition[0] = 0;

            }
        }

        if (newPosition[1] < 0 || newPosition[1] > size - 1)//sides overflow
            if (newPosition[1] < 0){    //left overflow
                newPosition[1] = size - 1;

            }
            else{   //right overflow
                newPosition[1] = 0;

            }
        return newPosition;
    }

    private static List<int[]> findFood(List<List<String>> field) {

        List<int[]> food = new LinkedList<>();

        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {

                if ("f".equals(field.get(i).get(j))) {

                    int[] foodPosition = {i, j};
                    food.add(foodPosition);

                }
            }
        }
        return food;
    }

    private static int[] findStartingPosition(List<List<String>> field) {

        int[] startingPosition = new int[2];
        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {

                if ("s".equals(field.get(i).get(j))) {
                    startingPosition[0] = i;
                    startingPosition[1] = j;
                    break;
                }
            }
        }
        return startingPosition;
    }

    private static List<int[]> findEnemies(List<List<String>> field) {

        List<int[]> enemies = new LinkedList<>();

        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.size(); j++) {

                if ("e".equals(field.get(i).get(j))) {

                    int[] enemyPosition = {i, j};
                    enemies.add(enemyPosition);

                }
            }
        }
        return enemies;
    }
}
