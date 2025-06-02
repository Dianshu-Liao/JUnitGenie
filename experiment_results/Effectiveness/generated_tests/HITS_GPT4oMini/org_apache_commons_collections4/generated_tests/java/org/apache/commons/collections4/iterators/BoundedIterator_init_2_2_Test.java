package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BoundedIterator_init_2_2_Test {

    private Iterator<Integer> iterator;

    private BoundedIterator boundedIterator;

    @BeforeEach
    public void setUp() {
        // Initialize the iterator with a simple list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        iterator = list.iterator();
    }

    @Test
    public void testInit_withOffsetLessThanIteratorSize() {
        boundedIterator = new BoundedIterator(iterator, 2, 3);
        // The init method should move the position to 2, skipping the first two elements (1 and 2)
        // The next call should return 3
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
    }

    @Test
    public void testInit_withOffsetEqualToIteratorSize() {
        boundedIterator = new BoundedIterator(iterator, 5, 3);
        // The init method should skip all elements since offset is equal to the size of the iterator
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testInit_withOffsetGreaterThanIteratorSize() {
        boundedIterator = new BoundedIterator(iterator, 10, 3);
        // The init method should not advance the iterator as offset is greater than the size
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testInit_withZeroOffset() {
        boundedIterator = new BoundedIterator(iterator, 0, 3);
        // The init method should not skip any elements
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
    }

    @Test
    public void testInit_withNegativeOffset() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator(iterator, -1, 3);
        });
        assertEquals("Offset parameter must not be negative.", exception.getMessage());
    }

    @Test
    public void testInit_withNegativeMax() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator(iterator, 2, -1);
        });
        assertEquals("Max parameter must not be negative.", exception.getMessage());
    }

    @Test
    public void testInit_withEmptyIterator() {
        List<Integer> emptyList = Arrays.asList();
        iterator = emptyList.iterator();
        boundedIterator = new BoundedIterator(iterator, 0, 3);
        // The init method should not advance the iterator
        assertFalse(iterator.hasNext());
    }
}
