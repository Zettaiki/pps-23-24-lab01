import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd3.CircularFilteredList;
import tdd3.CircularFilteredListImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularFilteredListTest {

    private CircularFilteredList circularFilteredList;

    @BeforeEach
    void beforeEach() {
        circularFilteredList = new CircularFilteredListImpl();
    }

    @Test
    void testAddElement() {
        circularFilteredList.add(1);
        circularFilteredList.add(2);
        circularFilteredList.add(3);

        assertEquals(3, circularFilteredList.size());

        circularFilteredList.add(4);
        circularFilteredList.add(5);

        assertEquals(5, circularFilteredList.size());
    }

    @Test
    void testListEmpty() {
        assertTrue(circularFilteredList.isEmpty());

        circularFilteredList.add(1);

        assertFalse(circularFilteredList.isEmpty());
    }

    @Test
    void testNextElementInList() {
        circularFilteredList.add(1);
        circularFilteredList.add(3);
        circularFilteredList.add(5);

        assertEquals(1, circularFilteredList.next().orElse(-1));
        assertEquals(3, circularFilteredList.next().orElse(-1));
        assertEquals(5, circularFilteredList.next().orElse(-1));
        assertEquals(1, circularFilteredList.next().orElse(-1));
    }

    @Test
    void testNextFilteredElementInList() {
        circularFilteredList.add(1);
        circularFilteredList.add(3);
        circularFilteredList.add(5);
        circularFilteredList.add(7);
        circularFilteredList.add(9);

        assertEquals(3, circularFilteredList.filteredNext(i -> i % 3 == 0).orElse(-1));
        assertEquals(9, circularFilteredList.filteredNext(i -> i % 3 == 0).orElse(-1));
        assertEquals(5, circularFilteredList.filteredNext(i -> i % 5 == 0).orElse(-1));
        assertEquals(Optional.empty(), circularFilteredList.filteredNext(i -> i % 2 == 0));
    }

    @Test
    void testPreviousElementInList() {
        circularFilteredList.add(1);
        circularFilteredList.add(3);
        circularFilteredList.add(5);

        assertEquals(5, circularFilteredList.previous().orElse(-1));
        assertEquals(3, circularFilteredList.previous().orElse(-1));
        assertEquals(1, circularFilteredList.previous().orElse(-1));
        assertEquals(5, circularFilteredList.previous().orElse(-1));
    }

    @Test
    void testCircularListReset() {
        circularFilteredList.add(1);
        circularFilteredList.add(3);
        circularFilteredList.add(5);
        circularFilteredList.add(7);

        assertEquals(1, circularFilteredList.next().orElse(-1));
        assertEquals(3, circularFilteredList.next().orElse(-1));
        assertEquals(5, circularFilteredList.next().orElse(-1));

        circularFilteredList.reset();

        assertEquals(1, circularFilteredList.next().orElse(-1));

    }

}
