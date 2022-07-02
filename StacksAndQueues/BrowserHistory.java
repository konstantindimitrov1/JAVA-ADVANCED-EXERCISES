import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            switch (input) {
                case "back" -> {
                    if (urls.size() <= 1) {
                        System.out.println("no previous URLs");
                        break;
                    }
                    urls.pop();
                    System.out.println(urls.peek());
                }
                default -> {
                    urls.push(input);
                    System.out.println(urls.peek());
                }
            }


            input = scanner.nextLine();
        }
    }
}
