package org.apache.commons.collections4.iterators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator_hasNext_1_0_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("Test");
    }

    @Test
    public void testHasNextBeforeFirst() {
        // Test when beforeFirst is true and removed is false
        assertTrue(iterator.hasNext(), "Expected hasNext() to return true before first element.");
    }

    @Test
    public void testHasNextAfterNextCalled() {
        // Call next to change the state
        iterator.next();
        assertFalse(iterator.hasNext(), "Expected hasNext() to return false after next() is called.");
    }

    @Test
    public void testHasNextAfterRemove() {
        // Call next then remove the element
        iterator.next();
        iterator.remove();
        assertFalse(iterator.hasNext(), "Expected hasNext() to return false after element is removed.");
    }

    @Test
    public void testHasNextAfterReset() {
        // Call next then reset
        iterator.next();
        iterator.reset();
        assertTrue(iterator.hasNext(), "Expected hasNext() to return true after reset.");
    }

    @Test
    public void testHasNextWhenRemoved() {
        // Call next then remove the element
        iterator.next();
        iterator.remove();
        assertFalse(iterator.hasNext(), "Expected hasNext() to return false after element is removed.");
    }
}
