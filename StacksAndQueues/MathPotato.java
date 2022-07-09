import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String kids = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Arrays.stream(kids.split("\\s+")).forEach(queue::offer);

        int cycles = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            boolean isPrimeCycle = checkPrime(cycles);

            if (isPrimeCycle) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycles++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean checkPrime(int cycles) {
        if (cycles <= 1) {
            return false;
        }
        int counter = 0;
        for (int i = 1; i <= cycles; i++) {
            if (cycles % i == 0) {
                counter++;
            }
        }
        return counter <= 2;
    }
}