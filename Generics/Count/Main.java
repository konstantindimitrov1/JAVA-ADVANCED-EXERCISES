package Generics.Count;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Count<String> count = new Count<>();

        for (int i = 0; i < n; i++) {
            count.add(scanner.nextLine());
        }

        System.out.println(count.getCount(scanner.nextLine()));
    }
}
