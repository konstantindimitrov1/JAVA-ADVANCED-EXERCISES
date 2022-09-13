package Generics.Count;

import java.util.ArrayList;
import java.util.List;

public class Count<T extends Comparable<T>> {
    private final List<T> list;
    private static int count = 0;

    public Count() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public int getCount(T element) {
        for (T item : this.list) {
            int result = item.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }

}
