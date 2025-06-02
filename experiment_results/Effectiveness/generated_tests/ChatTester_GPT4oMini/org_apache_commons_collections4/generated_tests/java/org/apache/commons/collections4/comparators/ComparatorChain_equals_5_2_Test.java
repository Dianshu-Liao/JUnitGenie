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

public class ComparatorChain_equals_5_2_Test {

    private ComparatorChain<Integer> chain1;

    private ComparatorChain<Integer> chain2;

    private ComparatorChain<Integer> chain3;

    private ComparatorChain<Integer> chain4;

    @BeforeEach
    public void setUp() {
        List<Comparator<Integer>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        BitSet bits1 = new BitSet();
        bits1.set(0);
        BitSet bits2 = new BitSet();
        bits2.set(1);
        chain1 = new ComparatorChain<>(comparators, bits1);
        chain2 = new ComparatorChain<>(comparators, bits1);
        chain3 = new ComparatorChain<>(comparators, bits2);
        chain4 = new ComparatorChain<>();
    }

    @Test
    public void testEquals_SameReference() {
        assertTrue(chain1.equals(chain1), "Same reference should be equal");
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(chain1.equals(null), "Null should not be equal");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(chain1.equals("Not a ComparatorChain"), "Different class should not be equal");
    }

    @Test
    public void testEquals_EqualChains() {
        assertTrue(chain1.equals(chain2), "Chains with same ordering bits and comparators should be equal");
    }

    @Test
    public void testEquals_DifferentOrderingBits() {
        assertFalse(chain1.equals(chain3), "Chains with different ordering bits should not be equal");
    }

    @Test
    public void testEquals_EmptyChains() {
        assertTrue(chain4.equals(new ComparatorChain<>()), "Two empty chains should be equal");
    }

    @Test
    public void testEquals_EqualChainsWithDifferentComparators() {
        List<Comparator<Integer>> comparators2 = new ArrayList<>();
        comparators2.add(Comparator.reverseOrder());
        ComparatorChain<Integer> chain5 = new ComparatorChain<>(comparators2, new BitSet());
        assertFalse(chain1.equals(chain5), "Chains with different comparators should not be equal");
    }
}
