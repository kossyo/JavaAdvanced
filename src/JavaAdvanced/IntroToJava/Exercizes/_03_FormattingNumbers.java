package IntroToJava.Exercizes;

import java.util.Arrays;
import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String numbersStr = scanner.nextLine();
        double[] numbers = Arrays.stream(numbersStr.split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        String binaryString = getBinaryString(numbers[0]);
        String hex = getHex(numbers[0]);
        String roundedTo2 = getNrRoundedTill2nd(numbers[1]);
        String roundedTo3 = getNrRoundedTill3rd(numbers[2]);



        System.out.printf("|" + hex);
        System.out.printf("|" + binaryString);
        System.out.printf("|" + roundedTo2);
        System.out.printf("|" + roundedTo3 + "|");
    }

    static String getBinaryString(double number){

        String binary = Integer.toBinaryString((int)number);
        String leadingZeros = "";

        for(int i = 0; i < 10 - binary.length(); i++){
            leadingZeros += "0";
        }

        return leadingZeros + binary;

    }

    static String getHex(double number){

        String hexStr = Integer.toHexString((int)number).toUpperCase();
        String spaces = "";

        for(int i = 0; i < 10 - hexStr.length(); i++){

            spaces += " ";
        }

        return hexStr + spaces;

    }

    static String getNrRoundedTill2nd(double number){
        String spaces = "";
        String numberStr = String.format("%.2f",number) + "";

        for(int i = 0; i < 10 - numberStr.length(); i++){
            spaces += " ";
        }
        return spaces + numberStr;
    }

    static String getNrRoundedTill3rd(double number){

        String spaces = "";
        String numberStr = String.format("%.3f",number) + "";

        for(int i = 0; i < 10 - numberStr.length(); i++){
            spaces += " ";
        }
        return numberStr + spaces;
    }
}
