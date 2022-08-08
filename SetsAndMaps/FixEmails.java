package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String mailInput = scanner.nextLine();
            List<String> email = Arrays.stream(mailInput.split("\\.")).toList();
            if (!email.contains("us") && !email.contains("uk") && !email.contains("com")) {
                emails.put(input, mailInput);
            }
            input = scanner.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s\n", key, value));
    }
}