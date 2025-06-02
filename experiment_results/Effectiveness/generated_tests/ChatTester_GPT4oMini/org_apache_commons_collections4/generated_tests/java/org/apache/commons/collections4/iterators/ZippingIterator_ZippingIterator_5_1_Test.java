package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.FluentIterable;

class ZippingIterator_ZippingIterator_5_1_Test {

    private ZippingIterator<String> zippingIterator;

    @BeforeEach
    void setUp() {
        Iterator<String> iterator1 = Arrays.asList("A", "B", "C").iterator();
        Iterator<String> iterator2 = Arrays.asList("1", "2", "3").iterator();
        Iterator<String> iterator3 = Arrays.asList("X", "Y", "Z").iterator();
        zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
    }

    @Test
    void testZippingIterator() {
        assertNotNull(zippingIterator);
    }

    @Test
    void testHasNext() {
        assertTrue(zippingIterator.hasNext());
        // consume first element
        zippingIterator.next();
        assertTrue(zippingIterator.hasNext());
        // consume second element
        zippingIterator.next();
        assertTrue(zippingIterator.hasNext());
        // consume third element
        zippingIterator.next();
        assertTrue(zippingIterator.hasNext());
        // consume fourth element
        zippingIterator.next();
        // no more elements
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    void testNext() {
        assertEquals("A", zippingIterator.next());
        assertEquals("1", zippingIterator.next());
        assertEquals("X", zippingIterator.next());
        assertEquals("B", zippingIterator.next());
        assertEquals("2", zippingIterator.next());
        assertEquals("Y", zippingIterator.next());
        assertEquals("C", zippingIterator.next());
        assertEquals("3", zippingIterator.next());
        assertEquals("Z", zippingIterator.next());
    }

    @Test
    void testNextNoSuchElementException() {
        while (zippingIterator.hasNext()) {
            zippingIterator.next();
        }
        assertThrows(NoSuchElementException.class, () -> zippingIterator.next());
    }

    @Test
    void testZippingIteratorWithThreeIterators() {
        Iterator<String> iterator1 = Arrays.asList("A", "B").iterator();
        Iterator<String> iterator2 = Arrays.asList("1", "2").iterator();
        Iterator<String> iterator3 = Arrays.asList("X", "Y").iterator();
        ZippingIterator<String> testZippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        assertNotNull(testZippingIterator);
        assertTrue(testZippingIterator.hasNext());
        assertEquals("A", testZippingIterator.next());
        assertEquals("1", testZippingIterator.next());
        assertEquals("X", testZippingIterator.next());
        assertEquals("B", testZippingIterator.next());
        assertEquals("2", testZippingIterator.next());
        assertEquals("Y", testZippingIterator.next());
        assertFalse(testZippingIterator.hasNext());
    }
}
