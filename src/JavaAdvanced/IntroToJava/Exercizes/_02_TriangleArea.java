package IntroToJava.Exercizes;

import java.util.Arrays;
import java.util.Scanner;

public class _02_TriangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        String input3 = scanner.nextLine();

        int[] p1 = Arrays.stream(input1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p2 = Arrays.stream(input2.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p3 = Arrays.stream(input3.split(" ")).mapToInt(Integer::parseInt).toArray();


        System.out.print(getArea(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]));
    }

    static int getArea(int aX, int aY, int bX, int bY, int cX, int cY){

        int area = Math.abs(aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY));

        return area/2;
    }
}
