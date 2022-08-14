package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get input
        String input = scanner.nextLine();
        int start = Integer.parseInt(input.split(" ")[0]);
        int end = Integer.parseInt(input.split(" ")[1]);
        String type = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();


        IntStream.range(start, end + 1)
                .filter(checkParams(type))
                .forEach(numbers::add);

        System.out.println(numbers.toString().replaceAll("[,\\[\\]]", ""));

    }

    private static IntPredicate checkParams(String type) {
        if (type.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}
