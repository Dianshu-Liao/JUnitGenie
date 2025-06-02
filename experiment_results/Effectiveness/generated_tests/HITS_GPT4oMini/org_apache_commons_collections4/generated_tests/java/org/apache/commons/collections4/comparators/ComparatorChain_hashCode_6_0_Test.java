package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
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

public class // Additional test to check consistency
ComparatorChain_hashCode_6_0_Test {

    @Test
    public void testHashCode_NullComparatorsAndOrderingBits() {
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(null, null);
        // Both fields are null, so hash should be 0
        int expectedHashCode = 0;
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

    @Test
    public void testHashCode_NonNullComparators() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(comparators, null);
        // Only comparators contribute to hash
        int expectedHashCode = comparators.hashCode();
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

    @Test
    public void testHashCode_NonNullOrderingBits() {
        BitSet orderingBits = new BitSet();
        orderingBits.set(0);
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(null, orderingBits);
        // Only orderingBits contribute to hash
        int expectedHashCode = orderingBits.hashCode();
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

    @Test
    public void testHashCode_NonNullComparatorsAndOrderingBits() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        BitSet orderingBits = new BitSet();
        orderingBits.set(1);
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(comparators, orderingBits);
        // Both contribute to hash
        int expectedHashCode = comparators.hashCode() ^ orderingBits.hashCode();
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }
}
