package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

class ComparatorChain_ComparatorChain_16_0_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    void setUp() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        comparators.add(Comparator.reverseOrder());
        comparatorChain = new ComparatorChain<>(comparators);
    }

    @Test
    void testComparatorChainInitialization() {
        assertNotNull(comparatorChain);
        assertEquals(2, getComparatorChainSize(comparatorChain));
    }

    @Test
    void testSetComparator() {
        Comparator<String> newComparator = Comparator.comparingInt(String::length);
        comparatorChain.setComparator(0, newComparator);
        assertEquals(newComparator, getComparator(comparatorChain, 0));
    }

    @Test
    void testSetComparatorOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            comparatorChain.setComparator(5, Comparator.naturalOrder());
        });
    }

    @Test
    void testSetReverseSort() {
        comparatorChain.setReverseSort(1);
        assertTrue(isOrderingBitSet(comparatorChain, 1));
    }

    @Test
    void testSetForwardSort() {
        comparatorChain.setReverseSort(1);
        comparatorChain.setForwardSort(1);
        assertFalse(isOrderingBitSet(comparatorChain, 1));
    }

    private int getComparatorChainSize(ComparatorChain<String> chain) {
        try {
            Field field = ComparatorChain.class.getDeclaredField("comparatorChain");
            field.setAccessible(true);
            List<?> list = (List<?>) field.get(chain);
            return list.size();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Comparator<String> getComparator(ComparatorChain<String> chain, int index) {
        try {
            Method method = ComparatorChain.class.getDeclaredMethod("getComparator", int.class);
            method.setAccessible(true);
            return (Comparator<String>) method.invoke(chain, index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isOrderingBitSet(ComparatorChain<String> chain, int index) {
        try {
            Field field = ComparatorChain.class.getDeclaredField("orderingBits");
            field.setAccessible(true);
            BitSet bits = (BitSet) field.get(chain);
            return bits.get(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
