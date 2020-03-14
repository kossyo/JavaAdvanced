package Lab;

import java.util.*;

public class _01_ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> parkedCars = new HashSet<>();
        String input = scanner.nextLine();

        while(!"END".equals(input)){

            String[] commandAndRegPlate = input.split(", ");
            String command = commandAndRegPlate[0];
            String regPlate = commandAndRegPlate[1];

            if ("IN".equals(command)){
                parkedCars.add(regPlate);
            }

            else{
                parkedCars.remove(regPlate);
            }


            input = scanner.nextLine();
        }


        if (parkedCars.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String parkedCar : parkedCars) {

            System.out.println(parkedCar);
        }


    }
}
