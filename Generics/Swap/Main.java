package Generics.Swap;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Swap<String> swap = new Swap<>();

        for (int i = 0; i < n; i++) {
            swap.add(scanner.nextLine());
        }

        int[] swapPositions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        swap.swap(swapPositions[0], swapPositions[1]);

        System.out.println(swap);

    }
}
