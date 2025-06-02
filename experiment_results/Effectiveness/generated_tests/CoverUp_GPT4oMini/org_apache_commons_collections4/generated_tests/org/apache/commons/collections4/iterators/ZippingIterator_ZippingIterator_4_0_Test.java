package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.FluentIterable;

class ZippingIterator_ZippingIterator_4_0_Test {

    private Iterator<Integer> iterator1;

    private Iterator<Integer> iterator2;

    private ZippingIterator<Integer> zippingIterator;

    @BeforeEach
    void setUp() {
        iterator1 = Arrays.asList(1, 2, 3).iterator();
        iterator2 = Arrays.asList(4, 5, 6).iterator();
        zippingIterator = new ZippingIterator<>(iterator1, iterator2);
    }

    @Test
    void testHasNextWhenBothIteratorsHaveElements() {
        assertTrue(zippingIterator.hasNext());
    }

    @Test
    void testNextWhenBothIteratorsHaveElements() {
        assertEquals(1, zippingIterator.next());
        assertEquals(4, zippingIterator.next());
    }

    @Test
    void testHasNextWhenOneIteratorExhausted() {
        // 1
        zippingIterator.next();
        // 4
        zippingIterator.next();
        // 2
        zippingIterator.next();
        // 5
        zippingIterator.next();
        // Should still have 3 and 6
        assertTrue(zippingIterator.hasNext());
    }

    @Test
    void testNextWhenOneIteratorExhausted() {
        // 1
        zippingIterator.next();
        // 4
        zippingIterator.next();
        // 2
        zippingIterator.next();
        // 5
        zippingIterator.next();
        assertEquals(3, zippingIterator.next());
        assertEquals(6, zippingIterator.next());
    }

    @Test
    void testNextThrowsExceptionWhenNoElementsLeft() {
        // 1
        zippingIterator.next();
        // 4
        zippingIterator.next();
        // 2
        zippingIterator.next();
        // 5
        zippingIterator.next();
        // 3
        zippingIterator.next();
        // 6
        zippingIterator.next();
        assertThrows(NoSuchElementException.class, zippingIterator::next);
    }

    @Test
    void testRemoveThrowsExceptionWhenNothingToRemove() {
        assertThrows(IllegalStateException.class, zippingIterator::remove);
    }

    @Test
    void testRemoveAfterNext() {
        // 1
        zippingIterator.next();
        // Should remove 1
        zippingIterator.remove();
        // Next should still work
        assertThrows(NoSuchElementException.class, zippingIterator::next);
        // Should still be able to get 4
        assertEquals(4, zippingIterator.next());
    }
}
