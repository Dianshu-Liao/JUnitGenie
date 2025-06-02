package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

class ComparatorChain_setComparator_9_1_Test {

    private ComparatorChain<Integer> comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    void testSetComparatorWithReverse() {
        Comparator<Integer> comparator = Integer::compareTo;
        comparatorChain.setComparator(0, comparator, true);
        // Verify the comparator is set
        assertEquals(comparator, getComparatorChain().get(0));
        // Verify the orderingBits is set for reverse
        assertTrue(getOrderingBits().get(0));
    }

    @Test
    void testSetComparatorWithoutReverse() {
        Comparator<Integer> comparator = Integer::compareTo;
        comparatorChain.setComparator(0, comparator, false);
        // Verify the comparator is set
        assertEquals(comparator, getComparatorChain().get(0));
        // Verify the orderingBits is cleared
        assertFalse(getOrderingBits().get(0));
    }

    @Test
    void testSetComparatorLocked() {
        Comparator<Integer> comparator = Integer::compareTo;
        comparatorChain.setComparator(0, comparator, false);
        // Lock the comparatorChain
        lockComparatorChain();
        // Attempt to set a new comparator should throw an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.setComparator(0, comparator, true);
        });
    }

    @Test
    void testSetComparatorIndexOutOfBounds() {
        Comparator<Integer> comparator = Integer::compareTo;
        // Attempting to set a comparator at an invalid index should throw an exception
        assertThrows(IndexOutOfBoundsException.class, () -> {
            comparatorChain.setComparator(1, comparator, false);
        });
    }

    @Test
    void testSetComparatorMultiple() {
        Comparator<Integer> comparator1 = Integer::compareTo;
        Comparator<Integer> comparator2 = (a, b) -> b.compareTo(a);
        comparatorChain.setComparator(0, comparator1, false);
        // This should throw an exception
        assertThrows(IndexOutOfBoundsException.class, () -> {
            comparatorChain.setComparator(1, comparator2, true);
        });
        // Verify that the first comparator is still set
        assertEquals(comparator1, getComparatorChain().get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Should still be out of bounds
            getComparatorChain().get(1);
        });
    }

    // Reflection utility methods to access private fields for tests
    private List<Comparator<Integer>> getComparatorChain() {
        try {
            Field field = ComparatorChain.class.getDeclaredField("comparatorChain");
            field.setAccessible(true);
            return (List<Comparator<Integer>>) field.get(comparatorChain);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BitSet getOrderingBits() {
        try {
            Field field = ComparatorChain.class.getDeclaredField("orderingBits");
            field.setAccessible(true);
            return (BitSet) field.get(comparatorChain);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void lockComparatorChain() {
        try {
            Field field = ComparatorChain.class.getDeclaredField("isLocked");
            field.setAccessible(true);
            field.set(comparatorChain, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
