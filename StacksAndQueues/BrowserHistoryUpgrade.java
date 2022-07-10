import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();

        ArrayDeque<String> forwardURLS = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            switch (input) {
                case "back":
                    if (urls.size() <= 1) {
                        System.out.println("no previous URLs");
                        break;
                    }
                    forwardURLS.push(urls.pop());
                    System.out.println(urls.peek());
                    break;
                case "forward":
                    if (forwardURLS.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        System.out.println(forwardURLS.pop());
                    }
                    break;
                default:
                    urls.push(input);
                    forwardURLS.clear();
                    System.out.println(urls.peek());
            }


            input = scanner.nextLine();
        }
    }
}
