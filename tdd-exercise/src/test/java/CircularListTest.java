import org.junit.jupiter.api.*;
import tdd.CircularList;
import tdd.CircularListImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    void testAddElement() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        assertEquals(3, circularList.size());

        circularList.add(4);
        circularList.add(5);

        assertEquals(5, circularList.size());
    }

    @Test
    void testListEmpty() {
        assertTrue(circularList.isEmpty());

        circularList.add(1);

        assertFalse(circularList.isEmpty());
    }

    @Test
    void testNextElementInList() {
        circularList.add(1);
        circularList.add(3);
        circularList.add(5);

        assertEquals(1, circularList.next().orElse(-1));
        assertEquals(3, circularList.next().orElse(-1));
        assertEquals(5, circularList.next().orElse(-1));
        assertEquals(1, circularList.next().orElse(-1));
    }

    @Test
    void testPreviousElementInList() {
        circularList.add(1);
        circularList.add(3);
        circularList.add(5);

        assertEquals(5, circularList.previous().orElse(-1));
        assertEquals(3, circularList.previous().orElse(-1));
        assertEquals(1, circularList.previous().orElse(-1));
        assertEquals(5, circularList.previous().orElse(-1));
    }

    @Test
    void testCircularListReset() {
        circularList.add(1);
        circularList.add(3);
        circularList.add(5);
        circularList.add(7);

        assertEquals(1, circularList.next().orElse(-1));
        assertEquals(3, circularList.next().orElse(-1));
        assertEquals(5, circularList.next().orElse(-1));

        circularList.reset();

        assertEquals(1, circularList.next().orElse(-1));

    }

}
