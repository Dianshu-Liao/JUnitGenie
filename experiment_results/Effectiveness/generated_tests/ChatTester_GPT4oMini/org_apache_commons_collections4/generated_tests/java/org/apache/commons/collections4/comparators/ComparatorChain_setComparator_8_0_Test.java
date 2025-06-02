package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

public class ComparatorChain_setComparator_8_0_Test {

    private ComparatorChain comparatorChain;

    @BeforeEach
    public void setUp() {
        comparatorChain = new ComparatorChain(new ArrayList<>());
    }

    @Test
    public void testSetComparator_ValidIndex() {
        Comparator<String> comparator = Comparator.naturalOrder();
        comparatorChain.setComparator(0, comparator);
        assertEquals(comparator, getComparatorAtIndex(0));
    }

    @Test
    public void testSetComparator_InvalidIndex() {
        Comparator<String> comparator = Comparator.naturalOrder();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Index 1 is out of bounds for an empty list
            comparatorChain.setComparator(1, comparator);
        });
    }

    @Test
    public void testSetComparator_NegativeIndex() {
        Comparator<String> comparator = Comparator.naturalOrder();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Negative index should also throw
            comparatorChain.setComparator(-1, comparator);
        });
    }

    @Test
    public void testSetComparator_UpdatingExistingComparator() {
        Comparator<String> comparator1 = Comparator.naturalOrder();
        Comparator<String> comparator2 = Comparator.reverseOrder();
        // Set first comparator
        comparatorChain.setComparator(0, comparator1);
        assertEquals(comparator1, getComparatorAtIndex(0));
        // Update first comparator
        comparatorChain.setComparator(0, comparator2);
        assertEquals(comparator2, getComparatorAtIndex(0));
    }

    @Test
    public void testSetComparator_OrderingBits() {
        Comparator<String> comparator = Comparator.naturalOrder();
        comparatorChain.setComparator(0, comparator);
        // Assuming there's a method to check the ordering bits
        // Should be false by default
        assertFalse(getOrderingBitAtIndex(0));
    }

    // Reflection method to access private method
    private Comparator<?> getComparatorAtIndex(int index) {
        try {
            java.lang.reflect.Field field = ComparatorChain.class.getDeclaredField("comparatorChain");
            field.setAccessible(true);
            List<Comparator<?>> comparators = (List<Comparator<?>>) field.get(comparatorChain);
            return comparators.get(index);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
            // Unreachable
            return null;
        }
    }

    // Reflection method to access private method for ordering bits
    private boolean getOrderingBitAtIndex(int index) {
        try {
            java.lang.reflect.Field field = ComparatorChain.class.getDeclaredField("orderingBits");
            field.setAccessible(true);
            BitSet bits = (BitSet) field.get(comparatorChain);
            return bits.get(index);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
            // Unreachable
            return false;
        }
    }
}
