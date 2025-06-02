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

public class ComparatorChain_ComparatorChain_13_0_Test {

    private ComparatorChain comparatorChain;

    @BeforeEach
    public void setUp() {
        comparatorChain = new ComparatorChain();
    }

    @Test
    public void testEmptyComparatorChain() {
        assertNotNull(comparatorChain);
    }

    @Test
    public void testComparatorChainWithSingleComparator() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        ComparatorChain singleComparatorChain = new ComparatorChain(stringComparator);
        assertNotNull(singleComparatorChain);
    }

    @Test
    public void testComparatorChainWithSingleComparatorReversed() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        ComparatorChain reversedComparatorChain = new ComparatorChain(stringComparator, true);
        assertNotNull(reversedComparatorChain);
    }

    @Test
    public void testComparatorChainWithListOfComparators() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        ComparatorChain listComparatorChain = new ComparatorChain(comparators);
        assertNotNull(listComparatorChain);
    }

    @Test
    public void testComparatorChainWithListOfComparatorsAndBits() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        BitSet bits = new BitSet();
        bits.set(0);
        ComparatorChain bitSetComparatorChain = new ComparatorChain(comparators, bits);
        assertNotNull(bitSetComparatorChain);
    }
}
