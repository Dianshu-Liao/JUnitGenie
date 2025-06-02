package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.ExtendedIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.collections4.IteratorUtils;

class ExtendedIterator_create_0_1_Test {

    @Test
    void testCreateWithExtendedIterator() {
        Iterator<Integer> baseIterator = Arrays.asList(1, 2, 3).iterator();
        ExtendedIterator<Integer> extendedIterator = ExtendedIterator.create(baseIterator);
        assertNotNull(extendedIterator);
        assertTrue(extendedIterator.hasNext());
        assertEquals(1, extendedIterator.next());
    }

    @Test
    void testCreateWithNonExtendedIterator() {
        Iterator<Integer> baseIterator = Arrays.asList(4, 5, 6).iterator();
        ExtendedIterator<Integer> extendedIterator = ExtendedIterator.create(baseIterator);
        assertNotNull(extendedIterator);
        assertTrue(extendedIterator.hasNext());
        assertEquals(4, extendedIterator.next());
    }

    @Test
    void testCreateWithEmptyIterator() {
        Iterator<Integer> baseIterator = Collections.emptyIterator();
        ExtendedIterator<Integer> extendedIterator = ExtendedIterator.create(baseIterator);
        assertNotNull(extendedIterator);
        assertFalse(extendedIterator.hasNext());
    }

    @Test
    void testCreateWithNullIterator() {
        assertThrows(NullPointerException.class, () -> {
            ExtendedIterator.create((Iterator<Integer>) null);
        });
    }

    @Test
    void testCreateNoRemove() {
        Iterator<Integer> baseIterator = Arrays.asList(7, 8, 9).iterator();
        ExtendedIterator<Integer> extendedIterator = ExtendedIterator.createNoRemove(baseIterator);
        assertNotNull(extendedIterator);
        assertTrue(extendedIterator.hasNext());
        assertEquals(7, extendedIterator.next());
    }

    @Test
    void testEmptyIterator() {
        ExtendedIterator<?> emptyIterator = ExtendedIterator.emptyIterator();
        assertNotNull(emptyIterator);
        assertFalse(emptyIterator.hasNext());
    }

    @Test
    void testFlatten() {
        Iterator<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(1, 2).iterator(), Arrays.asList(3, 4).iterator()).iterator();
        ExtendedIterator<Integer> flattened = ExtendedIterator.flatten(iterators);
        assertNotNull(flattened);
        assertTrue(flattened.hasNext());
        assertEquals(1, flattened.next());
        assertEquals(2, flattened.next());
        assertEquals(3, flattened.next());
        assertEquals(4, flattened.next());
        assertFalse(flattened.hasNext());
    }
}
