import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] chars = scanner.nextLine().split("");

        for (String aChar : chars) {
            if (aChar.equals("(") || aChar.equals("{") || aChar.equals("[")) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                String bracketToCompare = stack.pop();
                switch (bracketToCompare) {
                    case "{":
                        if (!aChar.equals("}")) {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case "[":
                        if (!aChar.equals("]")) {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case "(":
                        if (!aChar.equals(")")) {
                            System.out.println("NO");
                            return;
                        }
                        break;
                }
            }
        }
        System.out.println("YES");
    }
}
