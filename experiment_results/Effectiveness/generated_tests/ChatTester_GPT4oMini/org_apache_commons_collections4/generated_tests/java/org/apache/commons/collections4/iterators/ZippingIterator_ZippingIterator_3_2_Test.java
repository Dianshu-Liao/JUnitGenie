package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.collections4.FluentIterable;

class ZippingIterator_ZippingIterator_3_2_Test {

    private ZippingIterator<String> zippingIterator;

    @BeforeEach
    void setUp() {
        // Setup with a few iterators for testing
    }

    @Test
    void testZippingIterator_withMultipleIterators() {
        Iterator<String> iterator1 = Arrays.asList("a", "b", "c").iterator();
        Iterator<String> iterator2 = Arrays.asList("1", "2").iterator();
        Iterator<String> iterator3 = Arrays.asList("x", "y", "z", "w").iterator();
        zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        List<String> expected = Arrays.asList("a", "1", "x", "b", "2", "y", "c", "z", "w");
        List<String> actual = new ArrayList<>();
        while (zippingIterator.hasNext()) {
            actual.add(zippingIterator.next());
        }
        assertEquals(expected, actual);
    }

    @Test
    void testZippingIterator_withEmptyIterators() {
        Iterator<String> iterator1 = Collections.emptyIterator();
        Iterator<String> iterator2 = Collections.emptyIterator();
        zippingIterator = new ZippingIterator<>(iterator1, iterator2);
        assertFalse(zippingIterator.hasNext());
    }

    @Test
    void testZippingIterator_withNullIterator() {
        assertThrows(NullPointerException.class, () -> {
            new ZippingIterator<>(Arrays.asList("a", "b").iterator(), null);
        });
    }

    @Test
    void testZippingIterator_withSingleIterator() {
        Iterator<String> iterator1 = Arrays.asList("a", "b", "c").iterator();
        zippingIterator = new ZippingIterator<>(iterator1);
        List<String> expected = Arrays.asList("a", "b", "c");
        List<String> actual = new ArrayList<>();
        while (zippingIterator.hasNext()) {
            actual.add(zippingIterator.next());
        }
        assertEquals(expected, actual);
    }

    @Test
    void testZippingIterator_withMixedEmptyAndNonEmptyIterators() {
        Iterator<String> iterator1 = Arrays.asList("a", "b").iterator();
        Iterator<String> iterator2 = Collections.emptyIterator();
        Iterator<String> iterator3 = Arrays.asList("1", "2", "3").iterator();
        zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        List<String> expected = Arrays.asList("a", "1", "b", "2", "3");
        List<String> actual = new ArrayList<>();
        while (zippingIterator.hasNext()) {
            actual.add(zippingIterator.next());
        }
        assertEquals(expected, actual);
    }
}
