import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        while (stack.size()>1) {
            int left = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int right = Integer.parseInt(stack.pop());
            int sum;
            if (operation.equals("+")) {
                sum = left + right;
            } else {
                sum = left - right;
            }
            stack.push(String.valueOf(sum));
        }

        System.out.println(stack.peek());

    }
}
