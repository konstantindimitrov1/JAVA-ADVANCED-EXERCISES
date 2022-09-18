package IteratorsAndComparators.ComparingObj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);

            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine());

        if (index >= people.size()) {
            System.out.println("No matches");
            return;
        }

        Person person = people.get(index);

        int equalCount = 0;
        int notEqual = 0;

        for (Person otherPerson : people) {
            if (person.compareTo(otherPerson) == 0) {
                equalCount++;
            } else {
                notEqual++;
            }
        }

        System.out.printf("%d %d %d", equalCount, notEqual, people.size());


    }
}
