package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class BoundedIterator_next_3_0_Test {

    private BoundedIterator<String> boundedIterator;

    @BeforeEach
    void setUp() {
        List<String> elements = Arrays.asList("A", "B", "C", "D", "E");
        boundedIterator = new BoundedIterator<>(elements.iterator(), 1, 3);
    }

    @Test
    void testNextWithinBounds() {
        assertEquals("A", boundedIterator.next());
        assertEquals("B", boundedIterator.next());
        assertEquals("C", boundedIterator.next());
    }

    @Test
    void testNextThrowsNoSuchElementExceptionWhenOutOfBounds() {
        // "A"
        boundedIterator.next();
        // "B"
        boundedIterator.next();
        // "C"
        boundedIterator.next();
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    void testNextThrowsNoSuchElementExceptionWhenMaxExceeded() {
        boundedIterator = new BoundedIterator<>(Arrays.asList("A", "B").iterator(), 0, 2);
        // "A"
        boundedIterator.next();
        // "B"
        boundedIterator.next();
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    void testNextWithDifferentOffsets() {
        boundedIterator = new BoundedIterator<>(Arrays.asList("A", "B", "C", "D", "E").iterator(), 2, 2);
        assertEquals("C", boundedIterator.next());
        assertEquals("D", boundedIterator.next());
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    void testNextWithOffsetGreaterThanSize() {
        boundedIterator = new BoundedIterator<>(Arrays.asList("A", "B").iterator(), 3, 2);
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    void testConstructorThrowsIllegalArgumentExceptionForNegativeOffset() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedIterator<>(Arrays.asList("A", "B").iterator(), -1, 2));
    }

    @Test
    void testConstructorThrowsIllegalArgumentExceptionForNegativeMax() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedIterator<>(Arrays.asList("A", "B").iterator(), 0, -1));
    }

    @Test
    void testConstructorThrowsNullPointerExceptionForNullIterator() {
        assertThrows(NullPointerException.class, () -> new BoundedIterator<>(null, 0, 2));
    }
}
