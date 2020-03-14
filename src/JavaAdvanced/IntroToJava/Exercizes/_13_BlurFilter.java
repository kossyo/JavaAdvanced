package IntroToJava.Exercizes;

import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _13_BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blur = Integer.parseInt(scanner.nextLine());
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrixSize[0]; i++) {

            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Integer::parseInt).toArray();
        }

        int[] target = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (isIndexValid(target[0], target[1], matrixSize)) {


            for (int i = target[0] - 1; i <= target[0] + 1; i++) {
                for (int j = target[1] - 1; j <= target[1] + 1; j++) {

                    if (isIndexValid(i, j, matrixSize)) {
                        matrix[i][j] += blur;
                    }
                }
            }
        }
        for (int i = 0; i < matrixSize[0]; i++) {

            String result = Arrays.stream(matrix[i])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(result);
        }
    }

    static boolean isIndexValid(int x, int y, int[] matrixSize) {


        if (x >= 0 && x < matrixSize[0]
                && y >= 0 && y < matrixSize[1]
        ) {
            return true;
        }
        return false;
    }
}
