package org.apache.commons.collections4.iterators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator_previousIndex_6_0_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("test");
    }

    @Test
    public void testPreviousIndex_BeforeFirst() {
        // Test when beforeFirst is true
        assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void testPreviousIndex_AfterNextCalled() {
        // Call next to change the state
        iterator.next();
        // Test when beforeFirst is false
        assertEquals(0, iterator.previousIndex());
    }

    @Test
    public void testPreviousIndex_AfterReset() {
        // Call next to change the state
        iterator.next();
        // Reset the iterator
        iterator.reset();
        // Test when beforeFirst is true again
        assertEquals(-1, iterator.previousIndex());
    }
}
