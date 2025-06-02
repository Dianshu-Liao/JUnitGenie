package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Method;
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

class ComparatorChain_setComparator_9_0_Test {

    private ComparatorChain<Integer> comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    void testSetComparator() throws Exception {
        // Arrange
        Comparator<Integer> comparator = Comparator.naturalOrder();
        comparatorChain.addComparator(comparator, false);
        // Act
        invokeSetComparator(0, comparator, false);
        assertEquals(comparator, getComparator(0));
        assertFalse(getOrderingBits().get(0));
    }

    @Test
    void testSetComparatorWithReverse() throws Exception {
        // Arrange
        Comparator<Integer> comparator = Comparator.naturalOrder();
        comparatorChain.addComparator(comparator, true);
        // Act
        invokeSetComparator(0, comparator, true);
        assertEquals(comparator, getComparator(0));
        assertTrue(getOrderingBits().get(0));
    }

    @Test
    void testSetComparatorWhenLocked() throws Exception {
        // Arrange
        lockComparatorChain();
        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            invokeSetComparator(0, Comparator.naturalOrder(), false);
        });
        assertEquals("Comparator ordering cannot be changed after the first comparison is performed", exception.getMessage());
    }

    private void invokeSetComparator(int index, Comparator<?> comparator, boolean reverse) throws Exception {
        Method method = ComparatorChain.class.getDeclaredMethod("setComparator", int.class, Comparator.class, boolean.class);
        method.setAccessible(true);
        method.invoke(comparatorChain, index, comparator, reverse);
    }

    private void lockComparatorChain() throws Exception {
        Field field = ComparatorChain.class.getDeclaredField("isLocked");
        field.setAccessible(true);
        field.set(comparatorChain, true);
    }

    private Comparator<?> getComparator(int index) throws Exception {
        Method method = ComparatorChain.class.getDeclaredMethod("getComparator", int.class);
        method.setAccessible(true);
        return (Comparator<?>) method.invoke(comparatorChain, index);
    }

    private BitSet getOrderingBits() throws Exception {
        Field field = ComparatorChain.class.getDeclaredField("orderingBits");
        field.setAccessible(true);
        return (BitSet) field.get(comparatorChain);
    }

    @Test
    void testSetComparatorInvalidIndex() {
        // Arrange
        Comparator<Integer> comparator = Comparator.naturalOrder();
        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeSetComparator(1, comparator, false);
        });
    }
}
