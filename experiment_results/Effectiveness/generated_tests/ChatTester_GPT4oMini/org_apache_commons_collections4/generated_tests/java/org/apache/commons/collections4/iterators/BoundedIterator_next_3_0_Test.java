package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class BoundedIterator_next_3_0_Test {

    private BoundedIterator<String> boundedIterator;

    @BeforeEach
    public void setUp() {
        // Create an iterator with a sample data set
        Iterator<String> iterator = Arrays.asList("A", "B", "C", "D").iterator();
        // offset = 0, max = 3
        boundedIterator = new BoundedIterator<>(iterator, 0, 3);
    }

    @Test
    public void testNextWithinBounds() {
        assertEquals("A", boundedIterator.next());
        assertEquals("B", boundedIterator.next());
        assertEquals("C", boundedIterator.next());
    }

    @Test
    public void testNextAtBounds() {
        // A
        boundedIterator.next();
        // B
        boundedIterator.next();
        // C
        boundedIterator.next();
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    public void testNextBeyondBounds() {
        boundedIterator = new BoundedIterator<>(Arrays.asList("A", "B", "C", "D").iterator(), 2, 3);
        // C
        boundedIterator.next();
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    public void testNextWithEmptyIterator() {
        boundedIterator = new BoundedIterator<>(Collections.emptyIterator(), 0, 3);
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    public void testNextWithOffset() {
        // offset = 1
        boundedIterator = new BoundedIterator<>(Arrays.asList("A", "B", "C", "D").iterator(), 1, 3);
        assertEquals("B", boundedIterator.next());
        assertEquals("C", boundedIterator.next());
        // Should throw at max
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }

    @Test
    public void testNextWithMaxLessThanOffset() {
        // offset > max
        boundedIterator = new BoundedIterator<>(Arrays.asList("A", "B", "C", "D").iterator(), 3, 2);
        // Should throw immediately
        assertThrows(NoSuchElementException.class, () -> boundedIterator.next());
    }
}
