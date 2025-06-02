package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

class PeekingIterator_element_1_0_Test {

    private PeekingIterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        iterator = new PeekingIterator<>(list.iterator());
    }

    @Test
    void testElement() {
        assertEquals(1, iterator.element());
        // Should still return 1
        assertEquals(1, iterator.element());
    }

    @Test
    void testExhaustion() {
        // Advance to first element
        iterator.element();
        // Advance to second element
        iterator.element();
        // Advance to third element
        iterator.element();
        assertThrows(NoSuchElementException.class, () -> {
            // Should throw exception as there are no more elements
            iterator.element();
        });
    }

    @Test
    void testMultipleCalls() {
        assertEquals(1, iterator.element());
        assertEquals(1, iterator.element());
        assertEquals(1, iterator.element());
        // Advance to second element
        iterator.element();
        assertEquals(2, iterator.element());
    }

    @Test
    void testEmptyIterator() {
        List<Integer> emptyList = Arrays.asList();
        PeekingIterator<Integer> emptyIterator = new PeekingIterator<>(emptyList.iterator());
        assertThrows(NoSuchElementException.class, emptyIterator::element);
    }
}
