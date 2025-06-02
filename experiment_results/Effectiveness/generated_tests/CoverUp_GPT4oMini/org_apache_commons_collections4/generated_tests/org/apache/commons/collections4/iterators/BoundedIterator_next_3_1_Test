package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.BoundedIterator;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class BoundedIterator_next_3_1_Test {

    private BoundedIterator<Integer> boundedIterator;

    @BeforeEach
    void setUp() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        boundedIterator = new BoundedIterator<>(iterator, 0, 5);
    }

    @Test
    void testNextWithinBounds() {
        assertEquals(1, boundedIterator.next());
        assertEquals(2, boundedIterator.next());
        assertEquals(3, boundedIterator.next());
    }

    @Test
    void testNextExceedsMax() {
        // 1
        boundedIterator.next();
        // 2
        boundedIterator.next();
        // 3
        boundedIterator.next();
        // 4
        boundedIterator.next();
        // 5
        boundedIterator.next();
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    void testNextWithOffset() {
        boundedIterator = new BoundedIterator<>(Arrays.asList(1, 2, 3, 4, 5).iterator(), 2, 3);
        // 1
        boundedIterator.next();
        // 2
        boundedIterator.next();
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    void testNextNegativeOffset() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedIterator<>(Arrays.asList(1, 2, 3).iterator(), -1, 5));
    }

    @Test
    void testNextNegativeMax() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedIterator<>(Arrays.asList(1, 2, 3).iterator(), 0, -1));
    }

    @Test
    void testCheckBoundsMethod() throws Exception {
        Method method = BoundedIterator.class.getDeclaredMethod("checkBounds");
        method.setAccessible(true);
        // Create an instance with offset and max that will exceed bounds
        BoundedIterator<Integer> iterator = new BoundedIterator<>(Arrays.asList(1, 2, 3).iterator(), 0, 2);
        // Invoke the private method
        boolean withinBounds = (boolean) method.invoke(iterator);
        // Should be false as pos exceeds max
        assertFalse(withinBounds);
        // 1
        iterator.next();
        // 2
        iterator.next();
        withinBounds = (boolean) method.invoke(iterator);
        // Should be true as pos is within bounds
        assertTrue(withinBounds);
    }
}
