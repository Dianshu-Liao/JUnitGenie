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

public class ComparatorChain_ComparatorChain_14_0_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    public void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    public void testComparatorChainWithSingleComparator() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        ComparatorChain<String> singleComparatorChain = new ComparatorChain<>(stringComparator);
        assertEquals(1, getComparatorCount(singleComparatorChain));
    }

    @Test
    public void testComparatorChainWithMultipleComparators() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        comparators.add(Comparator.reverseOrder());
        ComparatorChain<String> multiComparatorChain = new ComparatorChain<>(comparators);
        assertEquals(2, getComparatorCount(multiComparatorChain));
    }

    @Test
    public void testComparatorChainWithBitSet() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        comparators.add(Comparator.reverseOrder());
        BitSet bits = new BitSet();
        bits.set(0, true);
        ComparatorChain<String> bitSetComparatorChain = new ComparatorChain<>(comparators, bits);
        assertEquals(2, getComparatorCount(bitSetComparatorChain));
    }

    @Test
    public void testEmptyComparatorChain() {
        ComparatorChain<String> emptyComparatorChain = new ComparatorChain<>();
        assertEquals(0, getComparatorCount(emptyComparatorChain));
    }

    @Test
    public void testComparatorChainWithReverseOrder() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        ComparatorChain<String> reverseComparatorChain = new ComparatorChain<>(stringComparator, true);
        assertEquals(1, getComparatorCount(reverseComparatorChain));
    }

    // Helper method to get the count of comparators in the ComparatorChain
    private int getComparatorCount(ComparatorChain<String> chain) {
        // Assuming we can access a method or field that gives us the size of the comparator list
        // This is a placeholder since we cannot modify the ComparatorChain class
        // In a real scenario, this would be implemented in the ComparatorChain class
        // Replace this with the actual logic to retrieve the count
        return 0;
    }
}
