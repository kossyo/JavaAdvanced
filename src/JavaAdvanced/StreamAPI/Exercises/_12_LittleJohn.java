package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12_LittleJohn {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int largeCounter = 0;
        int middleCounter = 0;
        int smallCounter = 0;

        String line = "";

        for (int i = 0; i < 4; i++) {

            line = reader.readLine();

            while (line.contains(">>>----->>") || line.contains(">>----->") || line.contains(">----->")) {

                if (line.contains(">>>----->>") ){

                    largeCounter++;
                    line = line.replaceFirst(">>>----->>", "|");
                }
                else if (line.contains(">>----->")){

                    middleCounter++;
                    line = line.replaceFirst(">>----->", "|");
                }
                else if (line.contains(">----->")){
                    smallCounter++;
                    line = line.replaceFirst(">----->", "|");
                }
            }
        }

        int initalCount = Integer.parseInt(String.format("%d%d%d", smallCounter, middleCounter, largeCounter));

        String binaryCount = (Integer.toBinaryString(initalCount));

        StringBuilder sb = new StringBuilder();
        sb.append(binaryCount);
        String result = sb.toString();
        sb.reverse();
        result += sb.toString();
        System.out.println(Integer.parseInt(result,2));



    }


}
