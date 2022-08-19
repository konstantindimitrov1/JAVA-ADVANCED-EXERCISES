package SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get data
        int lines = Integer.parseInt(scanner.nextLine());

        // fill data
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            set.addAll(Arrays.asList(tokens));
        }
        // print
        set.forEach(e -> System.out.print(e + " "));
    }
}
