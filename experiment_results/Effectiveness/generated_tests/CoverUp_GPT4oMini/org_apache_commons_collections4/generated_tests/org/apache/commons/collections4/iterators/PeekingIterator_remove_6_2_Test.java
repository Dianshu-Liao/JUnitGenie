package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class PeekingIterator_remove_6_2_Test {

    private PeekingIterator<Integer> peekingIterator;

    private List<Integer> list;

    private Iterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(1, 2, 3);
        iterator = list.iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    void testRemoveWithoutPeekOrElement() {
        // Ensure the iterator has elements to remove
        assertTrue(iterator.hasNext());
        // should not throw IllegalStateException
        peekingIterator.remove();
        // 1 should be removed
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveAfterPeek() {
        // Simulate calling peek() before remove
        // assuming peek() is implemented and does not throw
        peekingIterator.peek();
        assertThrows(IllegalStateException.class, () -> peekingIterator.remove());
    }

    @Test
    void testRemoveAfterElement() {
        // Simulate calling element() before remove
        // assuming next() is implemented and does not throw
        peekingIterator.next();
        assertThrows(IllegalStateException.class, () -> peekingIterator.remove());
    }

    @Test
    void testRemoveOnEmptyIterator() {
        // Exhaust the iterator
        while (iterator.hasNext()) {
            iterator.next();
        }
        assertThrows(NoSuchElementException.class, () -> peekingIterator.remove());
    }

    @Test
    void testRemoveWhenSlotFilled() throws Exception {
        // Use reflection to set slotFilled to true
        Field field = PeekingIterator.class.getDeclaredField("slotFilled");
        field.setAccessible(true);
        field.set(peekingIterator, true);
        assertThrows(IllegalStateException.class, () -> peekingIterator.remove());
    }
}
