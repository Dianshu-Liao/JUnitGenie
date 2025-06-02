package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.SingletonListIterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.ResettableListIterator;

class SingletonListIterator_next_3_0_Test {

    private SingletonListIterator<String> iterator;

    private final String testObject = "Test";

    @BeforeEach
    void setUp() {
        iterator = new SingletonListIterator<>(testObject);
    }

    @Test
    void testNext() {
        assertEquals(testObject, iterator.next());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testNextAfterRemoval() {
        iterator.next();
        iterator.remove();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testNextBeforeFirst() {
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testRemoveWithoutNext() {
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    void testRemoveAfterNext() {
        iterator.next();
        iterator.remove();
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    void testSetWithoutNext() {
        assertThrows(IllegalStateException.class, () -> iterator.set("New Value"));
    }

    @Test
    void testSetAfterNext() {
        iterator.next();
        iterator.set("New Value");
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testReset() {
        iterator.next();
        iterator.reset();
        assertTrue(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testHasPrevious() {
        assertFalse(iterator.hasPrevious());
        iterator.next();
        assertTrue(iterator.hasPrevious());
    }

    @Test
    void testPrevious() {
        iterator.next();
        assertEquals(testObject, iterator.previous());
        assertThrows(NoSuchElementException.class, iterator::previous);
    }

    @Test
    void testPreviousBeforeFirst() {
        assertThrows(NoSuchElementException.class, iterator::previous);
    }

    @Test
    void testNextIndex() {
        assertEquals(0, iterator.nextIndex());
        iterator.next();
        assertEquals(1, iterator.nextIndex());
    }

    @Test
    void testPreviousIndex() {
        assertEquals(-1, iterator.previousIndex());
        iterator.next();
        assertEquals(0, iterator.previousIndex());
    }
}
