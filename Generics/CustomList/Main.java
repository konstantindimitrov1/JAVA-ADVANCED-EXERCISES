package Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            switch (input.split(" ")[0]) {
                case "Add":
                    list.add(input.split(" ")[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(input.split(" ")[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(input.split(" ")[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(input.split(" ")[1]), Integer.parseInt(input.split(" ")[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(input.split(" ")[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;
                case "Sort":

                    break;

            }


            input = scanner.nextLine();
        }
    }
}
