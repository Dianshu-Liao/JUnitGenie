package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.ZippingIterator;
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

public class ZippingIterator_ZippingIterator_3_4_Test {

    private Iterator<Integer> iterator1;

    private Iterator<Integer> iterator2;

    private Iterator<Integer> iterator3;

    @BeforeEach
    public void setUp() {
        iterator1 = Arrays.asList(1, 2, 3).iterator();
        iterator2 = Arrays.asList(4, 5, 6).iterator();
        // Shorter iterator
        iterator3 = Arrays.asList(7, 8).iterator();
    }

    @Test
    public void testZippingIteratorWithTwoIterators() {
        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(iterator1, iterator2);
        assertTrue(zippingIterator.hasNext());
        assertEquals(1, zippingIterator.next());
        assertEquals(4, zippingIterator.next());
        assertEquals(2, zippingIterator.next());
        assertEquals(5, zippingIterator.next());
        assertEquals(3, zippingIterator.next());
        assertEquals(6, zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    public void testZippingIteratorWithThreeIterators() {
        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        assertTrue(zippingIterator.hasNext());
        assertEquals(1, zippingIterator.next());
        assertEquals(4, zippingIterator.next());
        assertEquals(7, zippingIterator.next());
        assertEquals(2, zippingIterator.next());
        assertEquals(5, zippingIterator.next());
        assertEquals(8, zippingIterator.next());
        assertEquals(3, zippingIterator.next());
        assertEquals(6, zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    public void testZippingIteratorWithEmptyIterators() {
        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(new Iterator[] {});
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    public void testZippingIteratorWithNullIterator() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new ZippingIterator<>(iterator1, null);
        });
        assertEquals("iterator", exception.getMessage());
    }

    @Test
    public void testZippingIteratorWithExhaustedIterators() {
        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(iterator1, iterator3);
        assertTrue(zippingIterator.hasNext());
        assertEquals(1, zippingIterator.next());
        assertEquals(7, zippingIterator.next());
        assertEquals(2, zippingIterator.next());
        assertEquals(8, zippingIterator.next());
        assertEquals(3, zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }
}
