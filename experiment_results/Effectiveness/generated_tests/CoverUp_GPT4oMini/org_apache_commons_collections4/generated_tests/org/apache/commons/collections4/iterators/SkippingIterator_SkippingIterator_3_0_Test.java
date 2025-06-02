package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.SkippingIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SkippingIterator_SkippingIterator_3_0_Test {

    private Iterator<Integer> iterator;

    private long validOffset;

    private long negativeOffset;

    @BeforeEach
    void setUp() {
        iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        validOffset = 2;
        negativeOffset = -1;
    }

    @Test
    void testConstructorWithValidOffset() {
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, validOffset);
        assertNotNull(skippingIterator);
    }

    @Test
    void testConstructorWithNegativeOffsetThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new SkippingIterator<>(iterator, negativeOffset);
        });
        assertEquals("Offset parameter must not be negative.", exception.getMessage());
    }

    @Test
    void testIteratorHasNextAfterSkipping() {
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, validOffset);
        assertTrue(skippingIterator.hasNext());
    }

    @Test
    void testIteratorNextAfterSkipping() {
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, validOffset);
        assertEquals(3, skippingIterator.next());
    }

    @Test
    void testIteratorExhaustion() {
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, validOffset);
        // 3
        skippingIterator.next();
        // 4
        skippingIterator.next();
        // 5
        skippingIterator.next();
        assertFalse(skippingIterator.hasNext());
        assertThrows(NoSuchElementException.class, skippingIterator::next);
    }

    @Test
    void testSkippingZeroOffset() {
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, 0);
        assertEquals(1, skippingIterator.next());
    }
}
