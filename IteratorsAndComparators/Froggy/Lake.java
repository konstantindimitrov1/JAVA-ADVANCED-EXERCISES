package IteratorsAndComparators.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private final List<Integer> lake;

    public Lake(List<Integer> lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {
        int index = 0;
        boolean firstRoundIsFinished = false;

        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;
            if (index >= lake.size() && !firstRoundIsFinished) {
                index = 1;
                firstRoundIsFinished = true;
            }
            return lake.get(currentIndex);
        }
    }
}