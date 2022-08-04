import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nCommands; i++) {
            String input = scanner.nextLine();
            int commandType = Integer.parseInt(input.split("\\s+")[0]);
            switch (commandType) {
                case 1 -> {
                    int number = Integer.parseInt(input.split("\\s+")[1]);
                    stack.push(number);
                }
                case 2 -> stack.pop();
                case 3 -> printMaxElement(stack);
            }
        }
    }

    private static void printMaxElement(ArrayDeque<Integer> stack) {
        stack.stream().sorted(Comparator.reverseOrder())
                .limit(1).forEach(System.out::println);
    }
}