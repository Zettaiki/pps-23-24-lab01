package tdd2;

import java.util.Iterator;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 * Example: with a list like {1,2,3}, the first call of forwardIterator() returns 1, the second call returns 2,
 * the third returns 3, the fourth returns 1, and so on. Call to backwardIterator() goes in the other way.
 */
public interface CircularIteratorList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Provides the next element of the list, as given by the built-in iterator.
     * @return the next element of the list
     */
    Iterator<Integer> forwardIterator();

    /**
     * Provides the previous element of the list. Its behaviour is dual of the forwardIterator() method.
     * @return the previous element into the list
     */
    Iterator<Integer> backwardIterator();
}
