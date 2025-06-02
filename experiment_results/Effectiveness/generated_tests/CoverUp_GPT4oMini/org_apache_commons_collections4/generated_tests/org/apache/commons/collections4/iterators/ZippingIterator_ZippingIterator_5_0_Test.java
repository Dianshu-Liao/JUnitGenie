package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.FluentIterable;

public class ZippingIterator_ZippingIterator_5_0_Test {

    private Iterator<Integer> iterator1;

    private Iterator<Integer> iterator2;

    private Iterator<Integer> iterator3;

    private ZippingIterator<Integer> zippingIterator;

    @BeforeEach
    public void setUp() {
        iterator1 = Arrays.asList(1, 2, 3).iterator();
        iterator2 = Arrays.asList(4, 5).iterator();
        iterator3 = Arrays.asList(6, 7, 8, 9).iterator();
    }

    @Test
    public void testZippingIteratorWithTwoIterators() {
        zippingIterator = new ZippingIterator<>(iterator1, iterator2);
        assertTrue(zippingIterator.hasNext());
        assertEquals(1, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(4, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(2, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(5, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(3, zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    public void testZippingIteratorWithThreeIterators() {
        zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        assertTrue(zippingIterator.hasNext());
        assertEquals(1, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(4, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(6, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(2, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(5, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(7, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(3, zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    public void testNextThrowsNoSuchElementException() {
        zippingIterator = new ZippingIterator<>(iterator2);
        // consume the first element
        zippingIterator.next();
        // consume the second element
        zippingIterator.next();
        assertThrows(NoSuchElementException.class, () -> zippingIterator.next());
    }

    @Test
    public void testRemove() {
        zippingIterator = new ZippingIterator<>(iterator1, iterator2);
        // consume the first element
        zippingIterator.next();
        // remove the last returned element
        zippingIterator.remove();
        // check that the next element is still accessible
        assertEquals(4, zippingIterator.next());
    }

    @Test
    public void testRemoveThrowsIllegalStateException() {
        zippingIterator = new ZippingIterator<>(iterator1, iterator2);
        assertThrows(IllegalStateException.class, () -> zippingIterator.remove());
    }
}
