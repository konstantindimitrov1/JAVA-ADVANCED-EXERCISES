import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> lastChanges = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < operations; i++) {
            String input = scanner.nextLine();
            int commandType = Integer.parseInt(input.split(" ")[0]);

            switch (commandType) {
                case 1 -> {
                    lastChanges.push(text.toString());
                    String textToAdd = input.split(" ")[1];
                    text.append(textToAdd);
                }
                case 2 -> {
                    lastChanges.push(text.toString());
                    int charsToErase = Integer.parseInt(input.split(" ")[1]);
                    text.delete(text.length() - charsToErase, text.length());
                }
                case 3 -> {
                    int charIndex = Integer.parseInt(input.split(" ")[1]);
                    System.out.println(text.toString().charAt(charIndex - 1));
                }
                case 4 -> {
                    text.delete(0, text.length());
                    text.append(lastChanges.pop());
                }
            }
        }
    }
}
