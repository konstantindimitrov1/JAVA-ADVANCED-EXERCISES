package SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> guestList = new TreeSet<>();

        // add all invited guests
        while (!input.equals("PARTY")) {
            guestList.add(input);
            input = scanner.nextLine();
        }

        // check how many guests didn't come
        input = scanner.nextLine();
        while (!input.equals("END")) {
            guestList.remove(input);
            input = scanner.nextLine();
        }

        // print
        System.out.println(guestList.size());
        for (String s : guestList) {
            System.out.println(s);
        }
    }
}