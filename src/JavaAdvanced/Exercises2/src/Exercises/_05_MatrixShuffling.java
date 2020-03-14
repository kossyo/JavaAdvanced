package Exercises;
import java.util.Scanner;
import java.util.Arrays;
public class _05_MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];

        for(int i = 0; i < size[0]; i++){

            int[] current = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = current;
        }

        while(true){


            String input = scanner.nextLine();

            if("END".equals(input)){
                break;
            }
            String[] command = input.split("\\s+");
            if(!areAllIntegers(command)){

                System.out.println("Invalid input!");
                continue;
            }





            int x1 = Integer.parseInt(command[1]);
            int y1 = Integer.parseInt(command[2]);
            int x2 = Integer.parseInt(command[3]);
            int y2 = Integer.parseInt(command[4]);

            if("swap".equals(command[0]) && command.length == 5 &&
                    Integer.parseInt(command[1]) < size[0] &&
                    Integer.parseInt(command[2]) < size[1] &&
                    Integer.parseInt(command[3]) < size[0] &&
                    Integer.parseInt(command[4]) < size[1])
            {
                //tryparse

                int temporary = matrix[x1][y1];
                matrix[x1][y1] = matrix[x2][y2];
                matrix[x2][y2] = temporary;

                for(int i = 0; i < size[0]; i++){
                    for(int j = 0; j < size[1]; j++){
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else{

                System.out.println("Invalid input!");

            }
        }
    }
    static boolean areAllIntegers(String[] array){

        int parsedArray[] = new int[array.length];
        for(int i = 0; i < array.length; i++){
            //System.out.print(array[i] + "*");
        }
        for(int i = 1; i < array.length; i++){

            try{

                parsedArray[i] = Integer.parseInt(array[i]);


            }

            catch(NumberFormatException e){

                return false;

            }

        }
        return true;

    }
}
