package IteratorsAndComparators.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());

        ComparatorName comparatorName = new ComparatorName();
        ComparatorAge comparatorAge = new ComparatorAge();

        Set<Person> peopleByName = new TreeSet<>(comparatorName);
        Set<Person> peopleByAge = new TreeSet<>(comparatorAge);

        for (int i = 0; i < peopleCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        peopleByName.stream().sorted(comparatorName).forEach(System.out::println);
        peopleByAge.stream().sorted(comparatorAge).forEach(System.out::println);


    }
}
