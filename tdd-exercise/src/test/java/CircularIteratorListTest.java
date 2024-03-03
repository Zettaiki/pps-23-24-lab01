import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd2.CircularIteratorList;
import tdd2.CircularIteratorListImpl;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularIteratorListTest {

    private CircularIteratorList circularIteratorList;

    @BeforeEach
    void beforeEach() {
        circularIteratorList = new CircularIteratorListImpl();
    }

    @Test
    void testAddElement() {
        circularIteratorList.add(1);
        circularIteratorList.add(2);
        circularIteratorList.add(3);

        assertEquals(3, circularIteratorList.size());

        circularIteratorList.add(4);
        circularIteratorList.add(5);

        assertEquals(5, circularIteratorList.size());
    }

    @Test
    void testListEmpty() {
        assertTrue(circularIteratorList.isEmpty());

        circularIteratorList.add(1);

        assertFalse(circularIteratorList.isEmpty());
    }

    @Test
    void testNextElementInList() {
        circularIteratorList.add(1);
        circularIteratorList.add(3);
        circularIteratorList.add(5);

        Iterator<Integer> forwardIterator = circularIteratorList.forwardIterator();

        assertEquals(1, forwardIterator.next());
        assertEquals(3, forwardIterator.next());
        assertEquals(5, forwardIterator.next());
        assertEquals(1, forwardIterator.next());
    }

    @Test
    void testPreviousElementInList() {
        circularIteratorList.add(1);
        circularIteratorList.add(3);
        circularIteratorList.add(5);

        Iterator<Integer> backwardIterator = circularIteratorList.backwardIterator();

        assertEquals(5, backwardIterator.next());
        assertEquals(3, backwardIterator.next());
        assertEquals(1, backwardIterator.next());
        assertEquals(5, backwardIterator.next());
    }

}
