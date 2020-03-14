package ExamPreparation._22oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitSnow {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[numbers.length][16];

        for (int i = 0; i < numbers.length; i++) {

            String binNumStr = Integer.toBinaryString(numbers[i]);
            StringBuilder leadingZeros = new StringBuilder();
            for (int j = 0; j < 16 - binNumStr.length(); j++) {
                leadingZeros.append('0');
            }
            binNumStr = leadingZeros.toString() + binNumStr;

            char[] binNum = binNumStr.toCharArray();
            matrix[i] = binNum;
        }

        for (int col = 0; col < matrix[0].length; col++) {

            int onesCount = 0;
            for (int row = 0; row < matrix.length; row++) {

                if (matrix[row][col] == '1') {

                    onesCount++;
                }
            }

            for (int row = 0; row < matrix.length - onesCount; row++) {

                matrix[row][col] = '0';
            }

            for (int row = matrix.length - onesCount; row < matrix.length; row++) {

                matrix[row][col] = '1';
            }
        }
        int[] result = new int[numbers.length];

        for (int i = 0; i < matrix.length; i++) {

            StringBuilder currentBinNumStr = new StringBuilder();
            for (int j = 0; j < 16; j++) {

                currentBinNumStr.append(matrix[i][j]);

            }
            int currentBinNum = Integer.parseInt(currentBinNumStr + "", 2);

            result[i] = currentBinNum;
        }
        System.out.println(Arrays.toString(result).replaceAll("[\\[\\]]", ""));
    }
}
