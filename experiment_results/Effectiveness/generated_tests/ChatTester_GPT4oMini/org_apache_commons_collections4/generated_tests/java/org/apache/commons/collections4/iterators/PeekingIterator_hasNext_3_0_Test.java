package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class PeekingIterator_hasNext_3_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    private Iterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        iterator = new Iterator<Integer>() {

            private final Integer[] values = { 1, 2, 3 };

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return values[index++];
            }
        };
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    void testHasNext_whenExhaustedIsFalseAndSlotFilledIsFalse_shouldReturnTrue() {
        assertTrue(peekingIterator.hasNext());
    }

    @Test
    void testHasNext_whenExhaustedIsFalseAndSlotFilledIsTrue_shouldReturnTrue() throws Exception {
        // Using reflection to set slotFilled to true
        setPrivateField("slotFilled", true);
        assertTrue(peekingIterator.hasNext());
    }

    @Test
    void testHasNext_whenExhaustedIsTrue_shouldReturnFalse() throws Exception {
        // Using reflection to set exhausted to true
        setPrivateField("exhausted", true);
        assertFalse(peekingIterator.hasNext());
    }

    @Test
    void testHasNext_whenExhaustedIsFalseAndIteratorHasNoNext_shouldReturnFalse() throws Exception {
        // Exhaust the iterator
        while (peekingIterator.hasNext()) {
            peekingIterator.next();
        }
        // Now it should be exhausted
        assertFalse(peekingIterator.hasNext());
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = PeekingIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(peekingIterator, value);
    }
}
