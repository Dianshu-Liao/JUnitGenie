package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ComparatorChain_setComparator_9_0_Test {

    private ComparatorChain<Integer> comparatorChain;

    @BeforeEach
    public void setUp() {
        comparatorChain = new ComparatorChain<>(new ArrayList<>(), new BitSet());
    }

    @Test
    public void testSetComparatorWithValidIndexAndReverseFalse() {
        Comparator<Integer> comparator = Integer::compareTo;
        comparatorChain.setComparator(0, comparator, false);
        assertEquals(comparator, getComparatorChainField("comparatorChain").get(0));
        assertFalse(getOrderingBits().get(0));
    }

    @Test
    public void testSetComparatorWithValidIndexAndReverseTrue() {
        Comparator<Integer> comparator = Integer::compareTo;
        comparatorChain.setComparator(0, comparator, true);
        assertEquals(comparator, getComparatorChainField("comparatorChain").get(0));
        assertTrue(getOrderingBits().get(0));
    }

    @Test
    public void testSetComparatorThrowsIndexOutOfBoundsException() {
        Comparator<Integer> comparator = Integer::compareTo;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            comparatorChain.setComparator(1, comparator, false);
        });
    }

    @Test
    public void testSetComparatorThrowsUnsupportedOperationExceptionWhenLocked() throws Exception {
        setLocked(true);
        Comparator<Integer> comparator = Integer::compareTo;
        assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.setComparator(0, comparator, false);
        });
    }

    @Test
    public void testCheckLockedDoesNotThrowWhenNotLocked() {
        assertDoesNotThrow(() -> {
            comparatorChain.setComparator(0, Integer::compareTo, false);
        });
    }

    private BitSet getOrderingBits() {
        try {
            Field field = comparatorChain.getClass().getDeclaredField("orderingBits");
            field.setAccessible(true);
            return (BitSet) field.get(comparatorChain);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Comparator<Integer>> getComparatorChainField(String fieldName) {
        try {
            Field field = comparatorChain.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (ArrayList<Comparator<Integer>>) field.get(comparatorChain);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setLocked(boolean locked) throws Exception {
        Field field = comparatorChain.getClass().getDeclaredField("isLocked");
        field.setAccessible(true);
        field.set(comparatorChain, locked);
    }
}
