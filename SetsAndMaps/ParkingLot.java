package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            // get data
            String[] tokens = input.split(", ");
            String action = tokens[0];
            String carNumber = tokens[1];

            // take action
            switch (action) {
                case "IN" -> parkingLot.add(carNumber);
                case "OUT" -> parkingLot.remove(carNumber);
            }
            // get new input
            input = scanner.nextLine();
        }

        // print
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : parkingLot) {
                System.out.println(s);
            }
        }
    }
}