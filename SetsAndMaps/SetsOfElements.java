package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get data
        String tokens = scanner.nextLine();
        int N = Integer.parseInt(tokens.split(" ")[0]);
        int M = Integer.parseInt(tokens.split(" ")[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        // fill data
        for (int i = 0; i < N + M; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i < N) {
                firstSet.add(number);
            } else {
                secondSet.add(number);
            }
        }

        // print data
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}