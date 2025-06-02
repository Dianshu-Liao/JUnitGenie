package org.apache.commons.collections4.comparators;

import java.util.Comparator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ComparatorChain_ComparatorChain_15_0_Test {

    @Test
    public void testComparatorChainWithNormalOrder() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(stringComparator, false);
        assertNotNull(comparatorChain, "ComparatorChain should not be null");
    }

    @Test
    public void testComparatorChainWithReverseOrder() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(stringComparator, true);
        assertNotNull(comparatorChain, "ComparatorChain should not be null");
    }

    @Test
    public void testComparatorChainWithDifferentComparator() {
        Comparator<Integer> integerComparator = Comparator.reverseOrder();
        ComparatorChain<Integer> comparatorChain = new ComparatorChain<>(integerComparator, false);
        assertNotNull(comparatorChain, "ComparatorChain should not be null");
    }

    @Test
    public void testComparatorChainWithNullComparator() {
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(null, false);
        assertNotNull(comparatorChain, "ComparatorChain should not be null even with null comparator");
    }

    @Test
    public void testComparatorChainWithNullAndReverse() {
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(null, true);
        assertNotNull(comparatorChain, "ComparatorChain should not be null even with null comparator in reverse order");
    }
}
