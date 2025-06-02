package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

class PeekingIterator_hasNext_3_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    @BeforeEach
    void setUp() {
        // Initialize the PeekingIterator with an Iterator
        peekingIterator = new PeekingIterator<>(Arrays.asList(1, 2, 3).iterator());
    }

    @Test
    void testHasNextWhenNotExhaustedAndSlotNotFilled() {
        assertTrue(peekingIterator.hasNext());
    }

    @Test
    void testHasNextWhenNotExhaustedAndSlotFilled() throws Exception {
        // Use reflection to set slotFilled to true
        setPrivateField(peekingIterator, "slotFilled", true);
        assertTrue(peekingIterator.hasNext());
    }

    @Test
    void testHasNextWhenExhausted() throws Exception {
        // Use reflection to set exhausted to true
        setPrivateField(peekingIterator, "exhausted", true);
        assertFalse(peekingIterator.hasNext());
    }

    @Test
    void testHasNextWhenIteratorHasNoNext() throws Exception {
        // Exhaust the iterator
        while (peekingIterator.hasNext()) {
            peekingIterator.next();
        }
        // Use reflection to set exhausted to true
        setPrivateField(peekingIterator, "exhausted", true);
        assertFalse(peekingIterator.hasNext());
    }

    private void setPrivateField(PeekingIterator<?> obj, String fieldName, Object value) throws Exception {
        Field field = PeekingIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
