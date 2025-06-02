package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.Transformer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayDeque;
import java.util.Deque;

class ObjectGraphIterator_ObjectGraphIterator_7_2_Test {

    private ObjectGraphIterator<String> iterator;

    @BeforeEach
    void setUp() {
        Iterator<String> rootIterator = Arrays.asList("A", "B", "C").iterator();
        iterator = new ObjectGraphIterator<>(rootIterator);
    }

    @Test
    void testHasNextInitiallyReturnsTrue() {
        assertTrue(iterator.hasNext());
    }

    @Test
    void testNextReturnsElementsInOrder() {
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
    }

    @Test
    void testHasNextAfterExhaustingIteratorReturnsFalse() {
        // A
        iterator.next();
        // B
        iterator.next();
        // C
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testNextThrowsNoSuchElementExceptionWhenExhausted() {
        // A
        iterator.next();
        // B
        iterator.next();
        // C
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testRemoveThrowsIllegalStateExceptionWhenCalledWithoutNext() {
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    void testRemoveWorksAfterNext() {
        // A
        iterator.next();
        // Should not throw
        iterator.remove();
        // Should still be false
        assertFalse(iterator.hasNext());
    }

    @Test
    void testRemoveWorksWithMultipleCalls() {
        // A
        iterator.next();
        // Should not throw
        iterator.remove();
        assertEquals("B", iterator.next());
        // Should not throw
        iterator.remove();
        assertEquals("C", iterator.next());
        // Should not throw
        iterator.remove();
        // Should still be false
        assertFalse(iterator.hasNext());
    }

    @Test
    void testNextThrowsExceptionIfRemoveCalledBeforeNext() {
        iterator.next();
        // Now it's valid
        iterator.remove();
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    void testHasNextAfterRemoveReturnsFalse() {
        // A
        iterator.next();
        // Remove A
        iterator.remove();
        // Next should still be B
        assertTrue(iterator.hasNext());
        // Should return B
        assertEquals("B", iterator.next());
        // Remove B
        iterator.remove();
        // Next should still be C
        assertTrue(iterator.hasNext());
        // Should return C
        assertEquals("C", iterator.next());
        // No more elements
        assertFalse(iterator.hasNext());
    }
}
