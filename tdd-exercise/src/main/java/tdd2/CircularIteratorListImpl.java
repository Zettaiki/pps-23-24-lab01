package tdd2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularIteratorListImpl implements CircularIteratorList {

    private final List<Integer> list = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return iteratorFactory(1);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return iteratorFactory(-1);
    }

    private Iterator<Integer> iteratorFactory(int step) {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {

                if(list.isEmpty()) {
                    throw new IllegalStateException("The list don't have elements to be iterated.");
                }

                currentIndex = (currentIndex + step + list.size()) % list.size();

                return step > 0 ?
                        list.get((currentIndex - step + list.size()) % list.size()) :
                        list.get(currentIndex);
            }
        };
    }
}
