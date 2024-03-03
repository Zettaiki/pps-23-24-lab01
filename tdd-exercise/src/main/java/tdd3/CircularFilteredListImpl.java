package tdd3;

import tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;

public class CircularFilteredListImpl extends CircularListImpl implements CircularFilteredList {

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {

        int startIndex = currentIndex;
        while(!predicate.test(list.get(currentIndex))) {
            currentIndex = (currentIndex + 1) % list.size();
            if(currentIndex == startIndex) {
                return Optional.empty();
            }
        }

        return super.next();
    }
}
