package ExamPreparation._03Jan2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DHARMASonarFence {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"Reprogram".equals(line = reader.readLine())){

            String binaryInput = Long.toBinaryString(Long.parseLong(line));
            //System.out.println(binaryInput);
            StringBuilder leadingZeros = new StringBuilder();

            for (int i = 0; i < 32 - binaryInput.length(); i++) {

                leadingZeros.append('0');
            }
            binaryInput = leadingZeros + binaryInput;

            Set<Integer> indicesToFlip = new HashSet<>();

            for (int i = 0; i < 31; i+=2) {

                if (binaryInput.charAt(i) == binaryInput.charAt(i+1)){
                    indicesToFlip.add(i);
                    indicesToFlip.add(i + 1);
                }
                else{
                    try {
                        if (binaryInput.charAt(i + 1) == binaryInput.charAt(i + 2)) {
                            indicesToFlip.add(i + 1);
                            indicesToFlip.add(i + 2);
                            i++;
                        }
                    }
                    catch (Exception e){}
                }
            }

            StringBuilder binaryOutput = new StringBuilder();

            for (int i = 0; i < binaryInput.length() ; i++) {

                if(indicesToFlip.contains(i)){

                    if (binaryInput.charAt(i) == '1') {
                        binaryOutput.append('0');
                    }
                    else{
                        binaryOutput.append('1');
                    }
                }
                else{
                    binaryOutput.append(binaryInput.charAt(i));
                }
            }
            System.out.println(Long.parseLong(binaryOutput.toString(), 2));
        }
    }
}
