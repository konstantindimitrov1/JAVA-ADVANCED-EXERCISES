package IteratorsAndComparators.ListIterator;

import java.util.List;

public class ListIterator {

    private final List<String> data;
    static int index = 0;

    public ListIterator(List<String> data) {
        this.data = data;
    }

    public boolean hasNext() {
        return index + 1 < data.size();
    }

    public boolean next() {
        if (index < data.size() - 1) {
            index++;
            return true;
        }

        return false;
    }

    public void print() {
        try {
            System.out.println(data.get(index));
        } catch (Exception e) {
            System.out.println("Invalid Operation!");
        }
    }
}
