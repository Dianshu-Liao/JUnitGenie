package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.collections4.IteratorUtils;

class ExtendedIterator_create_1_0_Test {

    @Test
    void testCreateWithEmptyStream() {
        Stream<String> emptyStream = Stream.empty();
        ExtendedIterator<String> iterator = ExtendedIterator.create((Stream<String>) emptyStream);
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCreateWithSingleElementStream() {
        Stream<String> singleElementStream = Stream.of("element");
        ExtendedIterator<String> iterator = ExtendedIterator.create((Stream<String>) singleElementStream);
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("element", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCreateWithMultipleElementStream() {
        Stream<String> multipleElementStream = Stream.of("one", "two", "three");
        ExtendedIterator<String> iterator = ExtendedIterator.create((Stream<String>) multipleElementStream);
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("one", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("two", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("three", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCreateWithNullStream() {
        assertThrows(NullPointerException.class, () -> {
            ExtendedIterator.create((Stream<String>) null);
        });
    }

    @Test
    void testCreateWithStreamContainingNullElements() {
        Stream<String> streamWithNulls = Stream.of("one", null, "three");
        ExtendedIterator<String> iterator = ExtendedIterator.create((Stream<String>) streamWithNulls);
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("one", iterator.next());
        assertTrue(iterator.hasNext());
        assertNull(iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("three", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
