package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s++"))
                .forEach(e -> System.out.printf("Sir %s\n", e));
    }
}
