package IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class ComparatorName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());

        if (result == 0) {
            result = o1.getName().compareToIgnoreCase(o2.getName());
        }

        return result;
    }
}
