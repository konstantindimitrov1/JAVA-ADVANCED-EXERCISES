package DefiningClasses.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String output = null;

            switch (tokens[0]) {
                case "Create" -> {
                    BankAccount account = new BankAccount();
                    bankAccounts.put(account.getId(), account);
                    output = "Account ID" + account.getId() + " created";
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        bankAccounts.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    }
                }
                case "SetInterest" -> BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                default -> {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        double interest = bankAccounts.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    }
                }
            }

            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }

    }
}