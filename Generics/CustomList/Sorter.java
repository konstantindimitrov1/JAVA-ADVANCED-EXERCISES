package Generics.CustomList;

import java.util.Collections;
import java.util.List;

public class Sorter<T extends CustomList & Comparable<T>> {
    private final List<T> list;

    public Sorter(List<T> listOfElements) {
        this.list = listOfElements;
    }

    public <T> void sort() {
        Collections.sort(this.list);
    }
}
